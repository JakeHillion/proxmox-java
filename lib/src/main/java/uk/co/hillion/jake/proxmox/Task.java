package uk.co.hillion.jake.proxmox;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Task {
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class Status {
    private int pid;
    private EStatus status;

    public enum EStatus {
      @JsonProperty("running")
      RUNNING,

      @JsonProperty("stopped")
      STOPPED,
    }
  }
}
