package uk.co.hillion.jake.proxmox;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import uk.co.hillion.jake.proxmox.AppendKeyMaps.AppendKeyMap;

import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
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
    @JsonProperty("stopped")
    STOPPED,

    @JsonProperty("running")
    RUNNING,
  }

  @JsonInclude(JsonInclude.Include.NON_NULL)
  public static class Create {
    public int vmid;

    public Boolean acpi;
    public String agent;
    public Architecture arch;
    public String archive;
    public String args;
    public String audio0;
    public Boolean autostart;
    public Integer balloon;
    public Bios bios;
    public String boot;
    public String bootdisk;
    public Integer bwlimit;
    public String cdrom;
    public String cicustom;
    public String cipasword;
    public CiType citype;
    public String ciuser;
    public Integer cores;
    public String cpu;
    public Double cpulimit;
    public Integer cpuunits;
    public String description;
    @AppendKeyMap public Map<Integer, String> efidisk;
    public Boolean force;
    public Boolean freeze;
    public String hookscript;
    public String hostpci0;
    public String hotplug;
    public HugePages hugepages;
    public String ide0;
    @AppendKeyMap public Map<Integer, String> ipconfig;
    public String ivshmem;
    public Boolean keephugepages;
    public Keyboard keyboard;
    public Boolean kvm;
    public Boolean localtime;
    public Lock lock;
    public String machine;
    public Integer memory;
    public Float migrateDowntime;
    public Integer migrateSpeed;
    public String name;
    public String nameserver;
    @AppendKeyMap public Map<Integer, String> net;
    public Boolean numa;

    @AppendKeyMap
    @JsonProperty("numa")
    public Map<Integer, String> numaMap;

    public Boolean onboot;
    public OsType ostype;
    @AppendKeyMap public Map<Integer, String> parallel;
    public String pool;
    public Boolean protection;
    public Boolean reboot;
    public String rng0;
    @AppendKeyMap public Map<Integer, String> sata;
    @AppendKeyMap public Map<Integer, String> scsi;
    public ScsiHardware scsihw;
    public String searchdomain;
    @AppendKeyMap public Map<Integer, String> serial;
    public Integer shares;
    public String smbios1;
    public Integer smp;
    public Integer sockets;

    @JsonProperty("spice_enhancements")
    public String spiceEnhancements;

    public String sshkeys;
    public Boolean start;
    public String startdate;
    public String startup;
    public String storage;
    public Boolean tablet;
    public String tags;
    public Boolean tdf;
    public Boolean template;
    public Boolean unique;
    @AppendKeyMap public Map<Integer, String> unused;
    @AppendKeyMap public Map<Integer, String> usb;
    public Integer vcpus;
    public String vga;
    @AppendKeyMap public Map<Integer, String> virtio;
    public String vmgenid;
    public String vmstatestorage;
    public String watchdog;

    public Create setVmid(int vmid) {
      this.vmid = vmid;
      return this;
    }

    public Create setAcpi(boolean acpi) {
      this.acpi = acpi;
      return this;
    }

    public Create setAgent(String agent) {
      this.agent = agent;
      return this;
    }

    public Create setArch(Architecture arch) {
      this.arch = arch;
      return this;
    }

    public Create setArchive(String archive) {
      this.archive = archive;
      return this;
    }

    public Create setArgs(String args) {
      this.args = args;
      return this;
    }

    public Create setAudio0(String audio0) {
      this.audio0 = audio0;
      return this;
    }

    public Create setAutostart(boolean autostart) {
      this.autostart = autostart;
      return this;
    }

    public Create setBalloon(int balloon) {
      this.balloon = balloon;
      return this;
    }

    public Create setBios(Bios bios) {
      this.bios = bios;
      return this;
    }

    public Create setBoot(String boot) {
      this.boot = boot;
      return this;
    }

    public Create setBootdisk(String bootdisk) {
      this.bootdisk = bootdisk;
      return this;
    }

    public Create setBwlimit(int bwlimit) {
      this.bwlimit = bwlimit;
      return this;
    }

    public Create setCdrom(String cdrom) {
      this.cdrom = cdrom;
      return this;
    }

    public Create setCicustom(String cicustom) {
      this.cicustom = cicustom;
      return this;
    }

    public Create setCipasword(String cipasword) {
      this.cipasword = cipasword;
      return this;
    }

    public Create setCitype(CiType citype) {
      this.citype = citype;
      return this;
    }

    public Create setCiuser(String ciuser) {
      this.ciuser = ciuser;
      return this;
    }

    public Create setCores(int cores) {
      this.cores = cores;
      return this;
    }

    public Create setCpu(String cpu) {
      this.cpu = cpu;
      return this;
    }

    public Create setCpulimit(double cpulimit) {
      this.cpulimit = cpulimit;
      return this;
    }

    public Create setCpuunits(int cpuunits) {
      this.cpuunits = cpuunits;
      return this;
    }

    public Create setDescription(String description) {
      this.description = description;
      return this;
    }

    public Create setEfidisk(Map<Integer, String> efidisk) {
      this.efidisk = efidisk;
      return this;
    }

    public Create setForce(boolean force) {
      this.force = force;
      return this;
    }

    public Create setFreeze(boolean freeze) {
      this.freeze = freeze;
      return this;
    }

    public Create setHookscript(String hookscript) {
      this.hookscript = hookscript;
      return this;
    }

    public Create setHostpci0(String hostpci0) {
      this.hostpci0 = hostpci0;
      return this;
    }

    public Create setHotplug(String hotplug) {
      this.hotplug = hotplug;
      return this;
    }

    public Create setHugepages(HugePages hugepages) {
      this.hugepages = hugepages;
      return this;
    }

    public Create setIde0(String ide0) {
      this.ide0 = ide0;
      return this;
    }

    public Create setIpconfig(Map<Integer, String> ipconfig) {
      this.ipconfig = ipconfig;
      return this;
    }

    public Create setIvshmem(String ivshmem) {
      this.ivshmem = ivshmem;
      return this;
    }

    public Create setKeephugepages(boolean keephugepages) {
      this.keephugepages = keephugepages;
      return this;
    }

    public Create setKeyboard(Keyboard keyboard) {
      this.keyboard = keyboard;
      return this;
    }

    public Create setKvm(boolean kvm) {
      this.kvm = kvm;
      return this;
    }

    public Create setLocaltime(boolean localtime) {
      this.localtime = localtime;
      return this;
    }

    public Create setLock(Lock lock) {
      this.lock = lock;
      return this;
    }

    public Create setMachine(String machine) {
      this.machine = machine;
      return this;
    }

    public Create setMemory(int memory) {
      this.memory = memory;
      return this;
    }

    public Create setMigrateDowntime(float migrateDowntime) {
      this.migrateDowntime = migrateDowntime;
      return this;
    }

    public Create setMigrateSpeed(int migrateSpeed) {
      this.migrateSpeed = migrateSpeed;
      return this;
    }

    public Create setName(String name) {
      this.name = name;
      return this;
    }

    public Create setNameserver(String nameserver) {
      this.nameserver = nameserver;
      return this;
    }

    public Create setNet(Map<Integer, String> net) {
      this.net = net;
      return this;
    }

    public Create setNuma(boolean numa) {
      this.numa = numa;
      return this;
    }

    public Create setNumaMap(Map<Integer, String> numaMap) {
      this.numaMap = numaMap;
      return this;
    }

    public Create setOnboot(boolean onboot) {
      this.onboot = onboot;
      return this;
    }

    public Create setOstype(OsType ostype) {
      this.ostype = ostype;
      return this;
    }

    public Create setParallel(Map<Integer, String> parallel) {
      this.parallel = parallel;
      return this;
    }

    public Create setPool(String pool) {
      this.pool = pool;
      return this;
    }

    public Create setProtection(boolean protection) {
      this.protection = protection;
      return this;
    }

    public Create setReboot(boolean reboot) {
      this.reboot = reboot;
      return this;
    }

    public Create setRng0(String rng0) {
      this.rng0 = rng0;
      return this;
    }

    public Create setSata(Map<Integer, String> sata) {
      this.sata = sata;
      return this;
    }

    public Create setScsi(Map<Integer, String> scsi) {
      this.scsi = scsi;
      return this;
    }

    public Create setScsihw(ScsiHardware scsihw) {
      this.scsihw = scsihw;
      return this;
    }

    public Create setSearchdomain(String searchdomain) {
      this.searchdomain = searchdomain;
      return this;
    }

    public Create setSerial(Map<Integer, String> serial) {
      this.serial = serial;
      return this;
    }

    public Create setShares(Integer shares) {
      this.shares = shares;
      return this;
    }

    public Create setSmbios1(String smbios1) {
      this.smbios1 = smbios1;
      return this;
    }

    public Create setSmp(int smp) {
      this.smp = smp;
      return this;
    }

    public Create setSockets(int sockets) {
      this.sockets = sockets;
      return this;
    }

    public Create setSpiceEnhancements(String spiceEnhancements) {
      this.spiceEnhancements = spiceEnhancements;
      return this;
    }

    public Create setSshkeys(String sshkeys) {
      this.sshkeys = sshkeys;
      return this;
    }

    public Create setStart(boolean start) {
      this.start = start;
      return this;
    }

    public Create setStartdate(String startdate) {
      this.startdate = startdate;
      return this;
    }

    public Create setStartup(String startup) {
      this.startup = startup;
      return this;
    }

    public Create setStorage(String storage) {
      this.storage = storage;
      return this;
    }

    public Create setTablet(boolean tablet) {
      this.tablet = tablet;
      return this;
    }

    public Create setTags(String tags) {
      this.tags = tags;
      return this;
    }

    public Create setTdf(boolean tdf) {
      this.tdf = tdf;
      return this;
    }

    public Create setTemplate(boolean template) {
      this.template = template;
      return this;
    }

    public Create setUnique(boolean unique) {
      this.unique = unique;
      return this;
    }

    public Create setUnused(Map<Integer, String> unused) {
      this.unused = unused;
      return this;
    }

    public Create setUsb(Map<Integer, String> usb) {
      this.usb = usb;
      return this;
    }

    public Create setVcpus(int vcpus) {
      this.vcpus = vcpus;
      return this;
    }

    public Create setVga(String vga) {
      this.vga = vga;
      return this;
    }

    public Create setVirtio(Map<Integer, String> virtio) {
      this.virtio = virtio;
      return this;
    }

    public Create setVmgenid(String vmgenid) {
      this.vmgenid = vmgenid;
      return this;
    }

    public Create setVmstatestorage(String vmstatestorage) {
      this.vmstatestorage = vmstatestorage;
      return this;
    }

    public Create setWatchdog(String watchdog) {
      this.watchdog = watchdog;
      return this;
    }

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

  @JsonInclude(JsonInclude.Include.NON_NULL)
  public static class Clone {
    public int newid;
    public Integer bwlimit;
    public String description;
    public DiskFormat format;
    public Boolean full;
    public String name;
    public String pool;
    public String snapname;
    public String storage;
    public String target;

    public Clone(int newid) {
      this.newid = newid;
    }

    public Clone setNewid(int newid) {
      this.newid = newid;
      return this;
    }

    public Clone setBwlimit(Integer bwlimit) {
      this.bwlimit = bwlimit;
      return this;
    }

    public Clone setDescription(String description) {
      this.description = description;
      return this;
    }

    public Clone setFormat(DiskFormat format) {
      this.format = format;
      return this;
    }

    public Clone setFull(Boolean full) {
      this.full = full;
      return this;
    }

    public Clone setName(String name) {
      this.name = name;
      return this;
    }

    public Clone setPool(String pool) {
      this.pool = pool;
      return this;
    }

    public Clone setSnapname(String snapname) {
      this.snapname = snapname;
      return this;
    }

    public Clone setStorage(String storage) {
      this.storage = storage;
      return this;
    }

    public Clone setTarget(String target) {
      this.target = target;
      return this;
    }

    public enum DiskFormat {
      @JsonProperty("raw")
      RAW,

      @JsonProperty("qcow2")
      QCOW2,

      @JsonProperty("vmdk")
      VMDK,
    }
  }
}
