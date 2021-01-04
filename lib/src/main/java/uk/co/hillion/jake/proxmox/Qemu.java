package uk.co.hillion.jake.proxmox;

import com.google.gson.annotations.SerializedName;

public class Qemu {
  private Status status;
  private int vmid;

  private double cpus;
  private String lock;
  private long maxdisk;
  private long maxmem;
  private String name;
  private int pid;
  private String qmpstatus;
  private String tags;
  private long uptime;

  /** @return Qemu process status. */
  public Status getStatus() {
    return status;
  }

  /** @return The (unique) ID of the VM. */
  public int getVmid() {
    return vmid;
  }

  /** @return Maximum usable CPUs. */
  public double getCpus() {
    return cpus;
  }

  /** @return The current config lock, if any. */
  public String getLock() {
    return lock;
  }

  /** @return Root disk size in bytes. */
  public long getMaxdisk() {
    return maxdisk;
  }

  /** @return Maximum memory size in bytes. */
  public long getMaxmem() {
    return maxmem;
  }

  /** @return VM name. */
  public String getName() {
    return name;
  }

  /** @return PID of running qemu process. */
  public int getPid() {
    return pid;
  }

  /** @return Qemu QMP agent status. */
  public String getQmpstatus() {
    return qmpstatus;
  }

  /** @return The current configured tags, if any. */
  public String getTags() {
    return tags;
  }

  /** @return Uptime. */
  public long getUptime() {
    return uptime;
  }

  public enum Status {
    @SerializedName("stoppped")
    STOPPED,

    @SerializedName("running")
    RUNNING,
  }

  public static class Create {
    public int vmid;

    public boolean acpi;
    public String agent;
    public Architecture arch;
    public String archive;
    public String args;
    public String audio0;
    public boolean autostart;
    public int balloon;
    public Bios bios;
    public String boot;
    public String bootdisk;
    public int bwlimit;
    public String cdrom;
    public String cicustom;
    public String cipasword;
    public CiType citype;
    public String ciuser;
    public int cores;
    public String cpu;
    public double cpulimit;
    public int cpuunits;
    public String description;
    public String efidisk0;
    public boolean force;
    public boolean freeze;
    public String hookscript;
    public String hostpci0;
    public String hotplug;
    public HugePages hugepages;
    public String ide0;
    public String ipconfig0;
    public String ivshmem;
    public boolean keephugepages;
    public Keyboard keyboard;
    public boolean kvm;
    public boolean localtime;
    public Lock lock;
    public String machine;
    public int memory;
    public float migrateDowntime;
    public int migrateSpeed;
    public String name;
    public String nameserver;
    public String net0;
    public boolean numa;
    public String numa0;


    public enum Architecture {
      @SerializedName("aarch64")
      AARCH64,

      @SerializedName("x84_64")
      X86_64,
    }

    public enum Bios {
      @SerializedName("seabios")
      SEABIOS,

      @SerializedName("ovmf")
      OVMF,
    }

    public enum CiType {
      @SerializedName("configdrive2")
      CONFIGDRIVE2,

      @SerializedName("nocloud")
      NOCLOUD,
    }

    public enum HugePages {
      @SerializedName("any")
      ANY,

      @SerializedName("2")
      N2,

      @SerializedName("1024")
      N1024,
    }

    public enum Keyboard {
      @SerializedName("de")
      DE,

      @SerializedName("de-ch")
      DE_CH,

      @SerializedName("da")
      DA,

      @SerializedName("en-gb")
      EN_GB,

      @SerializedName("en-us")
      EN_US,

      @SerializedName("es")
      ES,

      @SerializedName("fi")
      FI,

      @SerializedName("fr")
      FR,

      @SerializedName("fr-be")
      FR_BE,

      @SerializedName("fr-ca")
      FR_CA,

      @SerializedName("fr-ch")
      FR_CH,

      @SerializedName("hu")
      HU,

      @SerializedName("is")
      IS,

      @SerializedName("it")
      IT,

      @SerializedName("ja")
      JA,

      @SerializedName("lt")
      LT,

      @SerializedName("mk")
      MK,

      @SerializedName("nl")
      NL,

      @SerializedName("no")
      NO,

      @SerializedName("pl")
      PL,

      @SerializedName("pt")
      PT,

      @SerializedName("pt-br")
      PT_BR,

      @SerializedName("sv")
      SV,

      @SerializedName("sl")
      SL,

      @SerializedName("tr")
      TR,
    }

    public enum Lock {
      @SerializedName("backup")
      BACKUP,

      @SerializedName("clone")
      CLONE,

      @SerializedName("create")
      CREATE,

      @SerializedName("migrate")
      MIGRATE,

      @SerializedName("rollback")
      ROLLBACK,

      @SerializedName("snapshot")
      SNAPSHOT,

      @SerializedName("snapshot-delete")
      SNAPSHOT_DELETE,

      @SerializedName("suspending")
      SUSPENDING,

      @SerializedName("suspended")
      SUSPENDED,
    }
  }
}
