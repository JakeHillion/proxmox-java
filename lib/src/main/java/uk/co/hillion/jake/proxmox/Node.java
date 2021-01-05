package uk.co.hillion.jake.proxmox;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Node {
  private String node;
  private Status status;

  private double cpu;
  private String level;
  private int maxCpu;
  private long maxMem;
  private long mem;
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
  public int getMaxCpu() {
    return maxCpu;
  }

  /** @return Number of available memory in bytes. */
  public long getMaxMem() {
    return maxMem;
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
