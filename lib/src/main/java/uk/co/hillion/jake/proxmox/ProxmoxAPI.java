package uk.co.hillion.jake.proxmox;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.*;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.ssl.SSLContextBuilder;

import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.security.GeneralSecurityException;

public class ProxmoxAPI {
  private static final int PORT = 8006;
  private static final ObjectMapper objectMapper = new ObjectMapper();

  private final String host;
  private final String user;
  private final String tokenName;
  private final String token;

  private final CloseableHttpClient client;

  public ProxmoxAPI(String host, String user, String tokenName, String token, boolean verifySsl) {
    this.host = host;
    this.user = user;
    this.tokenName = tokenName;
    this.token = token;

    HttpClientBuilder builder = HttpClientBuilder.create();

    if (!verifySsl) {
      SSLContext ssl;
      try {
        ssl =
            new SSLContextBuilder().loadTrustMaterial(null, new TrustSelfSignedStrategy()).build();
      } catch (GeneralSecurityException e) {
        throw new RuntimeException(e);
      }
      builder.setSSLContext(ssl);
    }

    client = builder.build();
  }

  private StringBuilder getUrl() {
    return new StringBuilder("https://")
        .append(host)
        .append(':')
        .append(PORT)
        .append("/api2/json/");
  }

  private String getAuthorizationHeader() {
    return String.format("PVEAPIToken=%s!%s=%s", this.user, this.tokenName, this.token);
  }

  private <T> T executeRequest(
      HttpEntityEnclosingRequestBase request, Class<T> classOfT, Object body) throws IOException {
    StringEntity jsonBody = new StringEntity(objectMapper.writeValueAsString(body));
    jsonBody.setContentType("application/json");
    request.setEntity(jsonBody);

    return executeRequest(request, classOfT);
  }

  private <T> T executeRequest(HttpUriRequest request, Class<T> classOfT) throws IOException {
    request.addHeader("Authorization", getAuthorizationHeader());

    try (CloseableHttpResponse response = client.execute(request)) {
      int statusCode = response.getStatusLine().getStatusCode();
      if (statusCode < 200 || statusCode > 300) {
        throw new BadStatusException(statusCode);
      }

      HttpEntity responseEntity = response.getEntity();

      return objectMapper
          .reader()
          .withRootName("data")
          .readValue(responseEntity.getContent(), classOfT);
    }
  }

  public NodesApi nodes() {
    return new NodesApi();
  }

  public NodesApi.NodeApi node(String node) {
    return nodes().node(node);
  }

  public class NodesApi {
    private NodesApi() {}

    private StringBuilder getUrl() {
      return ProxmoxAPI.this.getUrl().append("nodes/");
    }

    public Node[] get() throws IOException {
      HttpGet request = new HttpGet(getUrl().toString());
      return executeRequest(request, Node[].class);
    }

    public Node get(String node) throws IOException {
      return node(node).get();
    }

    public NodeApi node(String node) {
      return new NodeApi(node);
    }

    public class NodeApi {
      private final String node;

      private NodeApi(String node) {
        this.node = node;
      }

      private StringBuilder getUrl() {
        return NodesApi.this.getUrl().append(node).append('/');
      }

      public Node get() throws IOException {
        HttpGet request = new HttpGet(getUrl().toString());
        return executeRequest(request, Node.class);
      }

      public QemusApi qemus() {
        return new QemusApi();
      }

      public QemusApi.QemuApi qemu(int qemu) {
        return qemus().qemu(qemu);
      }

      public TasksApi tasks() {
        return new TasksApi();
      }

      public TasksApi.TaskApi task(String upid) {
        return tasks().task(upid);
      }

      public class QemusApi {
        private QemusApi() {}

        private StringBuilder getUrl() {
          return NodeApi.this.getUrl().append("qemu/");
        }

        public Qemu[] get() throws IOException {
          HttpGet request = new HttpGet(getUrl().toString());
          return executeRequest(request, Qemu[].class);
        }

        public Qemu get(int qemu) throws IOException {
          return qemu(qemu).get();
        }

        public String post(Qemu.Create spec) throws IOException {
          HttpPost request = new HttpPost(getUrl().toString());
          return executeRequest(request, String.class, spec);
        }

        public QemuApi qemu(int qemu) {
          return new QemuApi(qemu);
        }

        public class QemuApi {
          private final int qemu;

          private QemuApi(int qemu) {
            this.qemu = qemu;
          }

          private StringBuilder getUrl() {
            return QemusApi.this.getUrl().append(qemu).append('/');
          }

          public Qemu get() throws IOException {
            HttpGet request = new HttpGet(getUrl().toString());
            return executeRequest(request, Qemu.class);
          }

          public String delete() throws IOException {
            HttpDelete request = new HttpDelete(getUrl().toString());
            return executeRequest(request, String.class);
          }

          public String clone(Qemu.Clone spec) throws IOException {
            HttpPost request = new HttpPost(getUrl().append("clone").toString());
            return executeRequest(request, String.class, spec);
          }

          public StatusApi status() {
            return new StatusApi();
          }

          public ConfigApi config() {
            return new ConfigApi();
          }

          public class StatusApi {
            private StatusApi() {}

            private StringBuilder getUrl() {
              return QemuApi.this.getUrl().append("status/");
            }

            public QemuStatus get() throws IOException {
              HttpGet request = new HttpGet(getUrl().append("current").toString());
              return executeRequest(request, QemuStatus.class);
            }

            public String reboot(QemuStatus.Reboot spec) throws IOException {
              HttpPost request = new HttpPost(getUrl().append("reboot").toString());
              return executeRequest(request, String.class, spec);
            }

            public String reset(QemuStatus.Reset spec) throws IOException {
              HttpPost request = new HttpPost(getUrl().append("reset").toString());
              return executeRequest(request, String.class, spec);
            }

            public String resume(QemuStatus.Resume spec) throws IOException {
              HttpPost request = new HttpPost(getUrl().append("resume").toString());
              return executeRequest(request, String.class, spec);
            }

            public String shutdown(QemuStatus.Shutdown spec) throws IOException {
              HttpPost request = new HttpPost(getUrl().append("shutdown").toString());
              return executeRequest(request, String.class, spec);
            }

            public String start(QemuStatus.Start spec) throws IOException {
              HttpPost request = new HttpPost(getUrl().append("start").toString());
              return executeRequest(request, String.class, spec);
            }

            public String stop(QemuStatus.Stop spec) throws IOException {
              HttpPost request = new HttpPost(getUrl().append("stop").toString());
              return executeRequest(request, String.class, spec);
            }

            public String suspend(QemuStatus.Suspend spec) throws IOException {
              HttpPost request = new HttpPost(getUrl().append("suspend").toString());
              return executeRequest(request, String.class, spec);
            }
          }

          public class ConfigApi {
            private ConfigApi() {}

            private StringBuilder getUrl() {
              return QemuApi.this.getUrl().append("/status");
            }

            public QemuConfig get() throws IOException {
              // TODO: Add support for get parameters
              HttpGet request = new HttpGet(getUrl().toString());
              return executeRequest(request, QemuConfig.class);
            }

            public String post(QemuConfig.AsyncUpdate spec) throws IOException {
              HttpPost request = new HttpPost(getUrl().toString());
              return executeRequest(request, String.class, spec);
            }

            public void put(QemuConfig.SyncUpdate spec) throws IOException {
              HttpPut request = new HttpPut(getUrl().toString());
              executeRequest(request, void.class, spec);
            }
          }
        }
      }

      public class TasksApi {
        private TasksApi() {}

        private StringBuilder getUrl() {
          return NodeApi.this.getUrl().append("/tasks");
        }

        public TaskApi task(String upid) {
          return new TaskApi(upid);
        }

        public class TaskApi {
          private final String upid;

          private TaskApi(String upid) {
            this.upid = upid;
          }

          private StringBuilder getUrl() {
            return TasksApi.this.getUrl().append(upid).append('/');
          }

          private Task.Status status() throws IOException {
            HttpGet request = new HttpGet(getUrl().append("status").toString());
            return executeRequest(request, Task.Status.class);
          }
        }
      }
    }
  }
}
