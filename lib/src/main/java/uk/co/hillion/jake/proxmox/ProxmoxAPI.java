package uk.co.hillion.jake.proxmox;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.entity.BufferedHttpEntity;
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

  private <T> T executeRequest(HttpPost request, Class<T> classOfT, Object body) throws IOException {
    StringEntity jsonBody = new StringEntity(objectMapper.writeValueAsString(body));
    jsonBody.setContentType("application/json");
    request.setEntity(jsonBody);

    return executeRequest(request, classOfT);
  }

  private <T> T executeRequest(HttpUriRequest request, Class<T> classOfT) throws IOException {
    System.out.println(getAuthorizationHeader());
    request.addHeader("Authorization", getAuthorizationHeader());

    try (CloseableHttpResponse response = client.execute(request)) {
      int statusCode = response.getStatusLine().getStatusCode();
      if (statusCode < 200 || statusCode > 300) {
        if (statusCode == 400) {
          String resp = new String(response.getEntity().getContent().readAllBytes());
          System.out.println(resp);
        }
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
    private StringBuilder getUrl() {
      return ProxmoxAPI.this.getUrl().append("nodes/");
    }

    public Node[] index() throws IOException {
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

      public class QemusApi {
        private StringBuilder getUrl() {
          return NodeApi.this.getUrl().append("qemu/");
        }

        public Qemu[] index() throws IOException {
          HttpGet request = new HttpGet(getUrl().toString());
          return executeRequest(request, Qemu[].class);
        }

        public Qemu get(int qemu) throws IOException {
          return qemu(qemu).get();
        }

        public QemuApi qemu(int qemu) {
          return new QemuApi(qemu);
        }

        public String create(Qemu.Create spec) throws IOException {
          HttpPost request = new HttpPost(getUrl().toString());
          return executeRequest(request, String.class, spec);
        }

        public class QemuApi {
          private final int qemu;

          private QemuApi(int qemu) {
            this.qemu = qemu;
          }

          private StringBuilder getUrl() {
            return NodeApi.this.getUrl().append(qemu).append('/');
          }

          public Qemu get() throws IOException {
            HttpGet request = new HttpGet(getUrl().toString());
            return executeRequest(request, Qemu.class);
          }
        }
      }
    }
  }
}
