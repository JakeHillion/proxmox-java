package uk.co.hillion.jake.proxmox;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Node {
  private String node;
  private Status status;

  private double cpu;
  private String level;
  private int maxcpu;
  private long maxmem;
  private long mem;

  @JsonProperty("ssl_fingerprint")
  private String sslFingerprint;

  private long uptime;

  /** @return The cluster node name. */
  public String getNode() {
    return node;
  }

  /** @return Node status. */
  public Status getStatus() {
    return status;
  }

  /** @return CPU utilization. */
  public double getCpu() {
    return cpu;
  }

  /** @return Support level. */
  public String getLevel() {
    return level;
  }

  /** @return Number of available CPUs. */
  public int getMaxcpu() {
    return maxcpu;
  }

  /** @return Number of available memory in bytes. */
  public long getMaxmem() {
    return maxmem;
  }

  /** @return Used memory in bytes. */
  public long getMem() {
    return mem;
  }

  /** @return The SSL fingerprint for the node certificate. */
  public String getSslFingerprint() {
    return sslFingerprint;
  }

  /** @return Node uptime in seconds. */
  public long getUptime() {
    return uptime;
  }

  public enum Status {
    @JsonProperty("unknown")
    UNKNOWN,

    @JsonProperty("online")
    ONLINE,

    @JsonProperty("offline")
    OFFLINE,
  }
}
