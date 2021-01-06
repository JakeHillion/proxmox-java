package uk.co.hillion.jake.proxmox;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class QemuStatus {
  private Object ha;
  private Status status;
  private Integer vmid;

  private Boolean agent;
  private Double cpus;
  private String lock;
  private Long maxdisk;
  private Long maxmem;
  private String name;
  private Integer pid;
  private String qmpstatus;
  private Boolean spice;
  private String tags;
  private Long uptime;

  public Object getHa() {
    return ha;
  }

  public Status getStatus() {
    return status;
  }

  public Integer getVmid() {
    return vmid;
  }

  public Boolean getAgent() {
    return agent;
  }

  public Double getCpus() {
    return cpus;
  }

  public String getLock() {
    return lock;
  }

  public Long getMaxdisk() {
    return maxdisk;
  }

  public Long getMaxmem() {
    return maxmem;
  }

  public String getName() {
    return name;
  }

  public Integer getPid() {
    return pid;
  }

  public String getQmpstatus() {
    return qmpstatus;
  }

  public Boolean getSpice() {
    return spice;
  }

  public String getTags() {
    return tags;
  }

  public Long getUptime() {
    return uptime;
  }

  public enum Status {
    @JsonProperty("stopped")
    STOPPED,

    @JsonProperty("running")
    RUNNING,
  }

  @JsonInclude(JsonInclude.Include.NON_NULL)
  public static class Reboot {
    public Integer timeout;

    public Reboot setTimeout(Integer timeout) {
      this.timeout = timeout;
      return this;
    }
  }

  @JsonInclude(JsonInclude.Include.NON_NULL)
  public static class Reset {
    public Boolean skiplock;

    public Reset setSkiplock(Boolean skiplock) {
      this.skiplock = skiplock;
      return this;
    }
  }

  @JsonInclude(JsonInclude.Include.NON_NULL)
  public static class Resume {
    public Boolean nocheck;
    public Boolean skiplock;

    public Resume setNocheck(Boolean nocheck) {
      this.nocheck = nocheck;
      return this;
    }

    public Resume setSkiplock(Boolean skiplock) {
      this.skiplock = skiplock;
      return this;
    }
  }

  @JsonInclude(JsonInclude.Include.NON_NULL)
  public static class Shutdown {
    public Boolean forceStop;
    public Boolean keepActive;
    public Boolean skiplock;
    public Integer timeout;

    public Shutdown setForceStop(Boolean forceStop) {
      this.forceStop = forceStop;
      return this;
    }

    public Shutdown setKeepActive(Boolean keepActive) {
      this.keepActive = keepActive;
      return this;
    }

    public Shutdown setSkiplock(Boolean skiplock) {
      this.skiplock = skiplock;
      return this;
    }

    public Shutdown setTimeout(Integer timeout) {
      this.timeout = timeout;
      return this;
    }
  }

  @JsonInclude(JsonInclude.Include.NON_NULL)
  public static class Start {
    @JsonProperty("force-cpu")
    public String forceCpu;

    public String machine;
    public String migratedfrom;

    @JsonProperty("migration_network")
    public String migrationNetwork;

    @JsonProperty("migration_type")
    public MigrationType migrationType;

    public Boolean skiplock;
    public String stateuri;
    public String targetstorage;
    public Integer timeout;

    public enum MigrationType {
      @JsonProperty("secure")
      SECURE,

      @JsonProperty("insecure")
      INSECURE,
    }
  }

  @JsonInclude(JsonInclude.Include.NON_NULL)
  public static class Stop {
    public Boolean keepActive;
    public String migratedfrom;
    public Boolean skiplock;
    public Integer timeout;

    public Stop setKeepActive(Boolean keepActive) {
      this.keepActive = keepActive;
      return this;
    }

    public Stop setMigratedfrom(String migratedfrom) {
      this.migratedfrom = migratedfrom;
      return this;
    }

    public Stop setSkiplock(Boolean skiplock) {
      this.skiplock = skiplock;
      return this;
    }

    public Stop setTimeout(Integer timeout) {
      this.timeout = timeout;
      return this;
    }
  }

  @JsonInclude(JsonInclude.Include.NON_NULL)
  public static class Suspend {
    public Boolean skiplock;
    public String statestorage;
    public Boolean todisk;

    public Suspend setSkiplock(Boolean skiplock) {
      this.skiplock = skiplock;
      return this;
    }

    public Suspend setStatestorage(String statestorage) {
      this.statestorage = statestorage;
      return this;
    }

    public Suspend setTodisk(Boolean todisk) {
      this.todisk = todisk;
      return this;
    }
  }
}
