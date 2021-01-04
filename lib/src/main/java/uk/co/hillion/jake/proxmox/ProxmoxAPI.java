package uk.co.hillion.jake.proxmox;

import com.google.gson.Gson;
import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class ProxmoxAPI {
  private static final int PORT = 8006;
  private static final Set<String> writeMethods = Set.of("POST", "PUT", "DELETE");

  private final String host;
  private final String user;
  private final String tokenName;
  private final String token;
  private final boolean verifySsl;

  private final CloseableHttpClient client;
  private final BasicCookieStore cookieStore;
  private final Gson gson = new Gson();

  private String csrfToken, ticket;
  private LocalDateTime tokensExpire;

  public ProxmoxAPI(String host, String user, String tokenName, String token, boolean verifySsl) {
    this.host = host;
    this.user = user;
    this.tokenName = tokenName;
    this.token = token;
    this.verifySsl = verifySsl;

    tokensExpire = LocalDateTime.now();

    cookieStore = new BasicCookieStore();
    client = HttpClientBuilder.create().setDefaultCookieStore(cookieStore).build();
  }

  private StringBuilder getUrl() {
    return new StringBuilder("https://")
        .append(host)
        .append(':')
        .append(PORT)
        .append("/api2/json/");
  }

  private void refreshTokens() throws IOException {
    class Response {
      Data data;

      class Data {
        private String CSRFPreventionToken;
        private String ticket;
        private String username;
      }
    }

    HttpPost request = new HttpPost(getUrl().append("access/ticket").toString());
    request.setEntity(
        new UrlEncodedFormEntity(
            List.of(
                new BasicNameValuePair("username", user),
                new BasicNameValuePair("password", token))));

    Response response = executeRequest(request, Response.class, false);

    csrfToken = response.data.CSRFPreventionToken;
    ticket = response.data.ticket;

    tokensExpire = LocalDateTime.now();
  }

  private String getTicket() throws IOException {
    if (tokensExpire.isBefore(LocalDateTime.now().plus(5, ChronoUnit.MINUTES))) {
      refreshTokens();
    }

    return ticket;
  }

  private String getCsrfToken() throws IOException {
    if (tokensExpire.isBefore(LocalDateTime.now().plus(5, ChronoUnit.MINUTES))) {
      refreshTokens();
    }

    return csrfToken;
  }

  private <T> T executeRequest(HttpUriRequest request, Class<T> classOfT) throws IOException {
    return executeRequest(request, classOfT, true);
  }

  private <T> T executeRequest(HttpUriRequest request, Class<T> classOfT, boolean ticket)
      throws IOException {
    if (ticket) {
      cookieStore.addCookie(new BasicClientCookie("PVEAuthCookie", getTicket()));
      if (writeMethods.contains(request.getMethod())) {
        request.addHeader("CSRFPreventionToken", getCsrfToken());
      }
    }

    try (CloseableHttpResponse response = client.execute(request)) {
      int statusCode = response.getStatusLine().getStatusCode();
      if (statusCode < 200 || statusCode > 300) {
        throw new BadStatusException(statusCode);
      }

      HttpEntity responseEntity = response.getEntity();
      return gson.fromJson(new InputStreamReader(responseEntity.getContent()), classOfT);
    }
  }

  public NodesApi nodes() {
    return new NodesApi();
  }

  public class NodesApi {
    public StringBuilder getUrl() {
      return ProxmoxAPI.this.getUrl().append("nodes/");
    }

    public Node[] index() throws IOException {
      HttpGet request = new HttpGet(getUrl().toString());
      return executeRequest(request, Node[].class);
    }

    public Node get(String node) throws IOException {
      HttpGet request = new HttpGet(getUrl().append(node).toString());
      return executeRequest(request, Node.class);
    }

    public NodeApi node(String node) {
      return new NodeApi(node);
    }

    public class NodeApi {
      private final String node;

      NodeApi(String node) {
        this.node = node;
      }

      public StringBuilder getUrl() {
        return NodesApi.this.getUrl().append(node).append('/');
      }

      public Node get() throws IOException {
        HttpGet request = new HttpGet(getUrl().toString());
        return executeRequest(request, Node.class);
      }

      public QemusApi qemu() {
        return new QemusApi();
      }

      public class QemusApi {
        public StringBuilder getUrl() {
          return NodeApi.this.getUrl().append("qemu/");
        }

        public Qemu[] index() throws IOException {
          HttpGet request = new HttpGet(getUrl().toString());
          return executeRequest(request, Qemu[].class);
        }

        public Qemu create() throws IOException {
          // TODO: Implement creates
          return null;
        }
      }
    }
  }
}
