package uk.co.hillion.jake.proxmox;

import com.fasterxml.jackson.annotation.JsonProperty;
import uk.co.hillion.jake.proxmox.AppendKeyMaps.AppendKeyMap;

import java.util.Map;

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
    @JsonProperty("stoppped")
    STOPPED,

    @JsonProperty("running")
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
    @AppendKeyMap public Map<Integer, String> efidisk;
    public boolean force;
    public boolean freeze;
    public String hookscript;
    public String hostpci0;
    public String hotplug;
    public HugePages hugepages;
    public String ide0;
    @AppendKeyMap public Map<Integer, String> ipconfig;
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
    @AppendKeyMap public Map<Integer, String> net;
    public boolean numa;

    @AppendKeyMap
    @JsonProperty("numa")
    public Map<Integer, String> numaMap;

    public boolean onboot;
    public OsType ostype;
    @AppendKeyMap public Map<Integer, String> parallel;
    public String pool;
    public boolean protection;
    public boolean reboot;
    public String rng0;
    @AppendKeyMap public Map<Integer, String> sata;
    @AppendKeyMap public Map<Integer, String> scsi;
    public ScsiHardware scsihw;
    public String searchdomain;
    @AppendKeyMap public Map<Integer, String> serial;
    public Integer shares;
    public String smbios1;
    public int smp;
    public int sockets;

    @JsonProperty("spice_enhancements")
    public String spiceEnhancements;

    public String sshkeys;
    public boolean start;
    public String startdate;
    public String startup;
    public String storage;
    public boolean tablet;
    public String tags;
    public boolean tdf;
    public boolean template;
    public boolean unique;
    @AppendKeyMap public Map<Integer, String> unused;
    @AppendKeyMap public Map<Integer, String> usb;
    public int vcpus;
    public String vga;
    @AppendKeyMap public Map<Integer, String> virtio;
    public String vmgenid;
    public String vmstatestorage;
    public String watchdog;

    public enum Architecture {
      @JsonProperty("aarch64")
      AARCH64,

      @JsonProperty("x84_64")
      X86_64,
    }

    public enum Bios {
      @JsonProperty("seabios")
      SEABIOS,

      @JsonProperty("ovmf")
      OVMF,
    }

    public enum CiType {
      @JsonProperty("configdrive2")
      CONFIGDRIVE2,

      @JsonProperty("nocloud")
      NOCLOUD,
    }

    public enum HugePages {
      @JsonProperty("any")
      ANY,

      @JsonProperty("2")
      N2,

      @JsonProperty("1024")
      N1024,
    }

    public enum Keyboard {
      @JsonProperty("de")
      DE,

      @JsonProperty("de-ch")
      DE_CH,

      @JsonProperty("da")
      DA,

      @JsonProperty("en-gb")
      EN_GB,

      @JsonProperty("en-us")
      EN_US,

      @JsonProperty("es")
      ES,

      @JsonProperty("fi")
      FI,

      @JsonProperty("fr")
      FR,

      @JsonProperty("fr-be")
      FR_BE,

      @JsonProperty("fr-ca")
      FR_CA,

      @JsonProperty("fr-ch")
      FR_CH,

      @JsonProperty("hu")
      HU,

      @JsonProperty("is")
      IS,

      @JsonProperty("it")
      IT,

      @JsonProperty("ja")
      JA,

      @JsonProperty("lt")
      LT,

      @JsonProperty("mk")
      MK,

      @JsonProperty("nl")
      NL,

      @JsonProperty("no")
      NO,

      @JsonProperty("pl")
      PL,

      @JsonProperty("pt")
      PT,

      @JsonProperty("pt-br")
      PT_BR,

      @JsonProperty("sv")
      SV,

      @JsonProperty("sl")
      SL,

      @JsonProperty("tr")
      TR,
    }

    public enum Lock {
      @JsonProperty("backup")
      BACKUP,

      @JsonProperty("clone")
      CLONE,

      @JsonProperty("create")
      CREATE,

      @JsonProperty("migrate")
      MIGRATE,

      @JsonProperty("rollback")
      ROLLBACK,

      @JsonProperty("snapshot")
      SNAPSHOT,

      @JsonProperty("snapshot-delete")
      SNAPSHOT_DELETE,

      @JsonProperty("suspending")
      SUSPENDING,

      @JsonProperty("suspended")
      SUSPENDED,
    }

    public enum OsType {
      @JsonProperty("other")
      OTHER,

      @JsonProperty("wxp")
      WXP,

      @JsonProperty("w2k")
      W2K,

      @JsonProperty("w2k3")
      W2K3,

      @JsonProperty("w2k8")
      W2K8,

      @JsonProperty("wvista")
      WVISTA,

      @JsonProperty("win7")
      WIN7,

      @JsonProperty("win8")
      WIN8,

      @JsonProperty("win10")
      WIN10,

      @JsonProperty("l24")
      L24,

      @JsonProperty("l26")
      L26,

      @JsonProperty("solaris")
      SOLARIS,
    }

    public enum ScsiHardware {
      @JsonProperty("lsi")
      LSI,

      @JsonProperty("lsi53c810")
      LSI53C810,

      @JsonProperty("virtio-scsi-pci")
      VIRTIO_SCSI_PCI,

      @JsonProperty("virtio-scsi-single")
      VIRTIO_SCSI_SINGLE,

      @JsonProperty("megasas")
      MEGASAS,

      @JsonProperty("pvscsi")
      PVSCSI,
    }
  }
}
