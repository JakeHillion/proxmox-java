package uk.co.hillion.jake.proxmox;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import uk.co.hillion.jake.proxmox.AppendKeyMaps.AppendKeyMap;

import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class QemuConfig implements AppendKeyMaps {
  private String digest;

  private Boolean acpi;
  private String agent;
  private Architecture arch;
  private String args;
  private String audio0;
  private Boolean autostart;
  private Long balloon;
  private Bios bios;
  private String boot;
  private String bootdisk;
  private String cdrom;
  private String cicustom;
  private String cipassword;
  private CiType citype;
  private String ciuser;
  private Integer cores;
  private String cpu;
  private Double cpulimit;
  private Integer cpuunits;
  private String description;
  private String efidisk0;
  private Boolean freeze;
  private String hookscript;
  @AppendKeyMap private Map<Integer, String> hostpci;
  private String hotplug;
  private HugePages hugepages;
  @AppendKeyMap private Map<Integer, String> ide;
  @AppendKeyMap private Map<Integer, String> ipconfig;
  private String ivshmem;
  private Boolean keephugepages;
  private Keyboard keyboard;
  private Boolean kvm;
  private Boolean localtime;
  private Lock lock;
  private String machine;
  private Integer memory;

  @JsonProperty("migrate_downtime")
  private Float migrateDowntime;

  @JsonProperty("migrate_speed")
  private Integer migrateSpeed;

  private String name;
  private String nameserver;
  @AppendKeyMap private Map<Integer, String> net;
  private Boolean numa;

  @JsonProperty("numa")
  @AppendKeyMap
  private Map<Integer, String> numaMap;

  private Boolean onboot;
  private OsType ostype;
  @AppendKeyMap private Map<Integer, String> parallel;
  private Boolean protection;
  private Boolean reboot;
  private String rng0;
  @AppendKeyMap private Map<Integer, String> sata;
  @AppendKeyMap private Map<Integer, String> scsi;
  private ScsiHardware scsihw;
  private String searchdomain;
  @AppendKeyMap private Map<Integer, String> serial;
  private Integer shares;
  private String smbios1;
  private Integer smp;
  private Integer sockets;

  @JsonProperty("spice_enhancements")
  private String spiceEnhancements;

  private String sshkeys;
  private String startdate;
  private String startup;
  private Boolean tablet;
  private String tags;
  private Boolean tdf;
  private Boolean template;
  @AppendKeyMap private Map<Integer, String> unused;
  @AppendKeyMap private Map<Integer, String> usb;
  private Integer vcpus;
  private String vga;
  @AppendKeyMap private Map<Integer, String> virtio;
  private String vmgenid;
  private String vmstatestorage;
  private String watchdog;

  public String getDigest() {
    return digest;
  }

  public Boolean getAcpi() {
    return acpi;
  }

  public String getAgent() {
    return agent;
  }

  public Architecture getArch() {
    return arch;
  }

  public String getArgs() {
    return args;
  }

  public String getAudio0() {
    return audio0;
  }

  public Boolean getAutostart() {
    return autostart;
  }

  public Long getBalloon() {
    return balloon;
  }

  public Bios getBios() {
    return bios;
  }

  public String getBoot() {
    return boot;
  }

  public String getBootdisk() {
    return bootdisk;
  }

  public String getCdrom() {
    return cdrom;
  }

  public String getCicustom() {
    return cicustom;
  }

  public String getCipassword() {
    return cipassword;
  }

  public CiType getCitype() {
    return citype;
  }

  public String getCiuser() {
    return ciuser;
  }

  public Integer getCores() {
    return cores;
  }

  public String getCpu() {
    return cpu;
  }

  public Double getCpulimit() {
    return cpulimit;
  }

  public Integer getCpuunits() {
    return cpuunits;
  }

  public String getDescription() {
    return description;
  }

  public String getEfidisk0() {
    return efidisk0;
  }

  public Boolean getFreeze() {
    return freeze;
  }

  public String getHookscript() {
    return hookscript;
  }

  public Map<Integer, String> getHostpci() {
    return hostpci;
  }

  public String getHotplug() {
    return hotplug;
  }

  public HugePages getHugepages() {
    return hugepages;
  }

  public Map<Integer, String> getIde() {
    return ide;
  }

  public Map<Integer, String> getIpconfig() {
    return ipconfig;
  }

  public String getIvshmem() {
    return ivshmem;
  }

  public Boolean getKeephugepages() {
    return keephugepages;
  }

  public Keyboard getKeyboard() {
    return keyboard;
  }

  public Boolean getKvm() {
    return kvm;
  }

  public Boolean getLocaltime() {
    return localtime;
  }

  public Lock getLock() {
    return lock;
  }

  public String getMachine() {
    return machine;
  }

  public Integer getMemory() {
    return memory;
  }

  public Float getMigrateDowntime() {
    return migrateDowntime;
  }

  public Integer getMigrateSpeed() {
    return migrateSpeed;
  }

  public String getName() {
    return name;
  }

  public String getNameserver() {
    return nameserver;
  }

  public Map<Integer, String> getNet() {
    return net;
  }

  public Boolean getNuma() {
    return numa;
  }

  public Map<Integer, String> getNumaMap() {
    return numaMap;
  }

  public Boolean getOnboot() {
    return onboot;
  }

  public OsType getOstype() {
    return ostype;
  }

  public Map<Integer, String> getParallel() {
    return parallel;
  }

  public Boolean getProtection() {
    return protection;
  }

  public Boolean getReboot() {
    return reboot;
  }

  public String getRng0() {
    return rng0;
  }

  public Map<Integer, String> getSata() {
    return sata;
  }

  public Map<Integer, String> getScsi() {
    return scsi;
  }

  public ScsiHardware getScsihw() {
    return scsihw;
  }

  public String getSearchdomain() {
    return searchdomain;
  }

  public Map<Integer, String> getSerial() {
    return serial;
  }

  public Integer getShares() {
    return shares;
  }

  public String getSmbios1() {
    return smbios1;
  }

  public Integer getSmp() {
    return smp;
  }

  public Integer getSockets() {
    return sockets;
  }

  public String getSpiceEnhancements() {
    return spiceEnhancements;
  }

  public String getSshkeys() {
    return sshkeys;
  }

  public String getStartdate() {
    return startdate;
  }

  public String getStartup() {
    return startup;
  }

  public Boolean getTablet() {
    return tablet;
  }

  public String getTags() {
    return tags;
  }

  public Boolean getTdf() {
    return tdf;
  }

  public Boolean getTemplate() {
    return template;
  }

  public Map<Integer, String> getUnused() {
    return unused;
  }

  public Map<Integer, String> getUsb() {
    return usb;
  }

  public Integer getVcpus() {
    return vcpus;
  }

  public String getVga() {
    return vga;
  }

  public Map<Integer, String> getVirtio() {
    return virtio;
  }

  public String getVmgenid() {
    return vmgenid;
  }

  public String getVmstatestorage() {
    return vmstatestorage;
  }

  public String getWatchdog() {
    return watchdog;
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
  
  private static abstract class BaseUpdate<T> {
    protected abstract T returnThis();
    
    public Boolean acpi;
    public String agent;
    public Architecture arch;
    public String args;
    public String audio0;
    public Boolean autostart;
    public Long balloon;
    public Bios bios;
    public String boot;
    public String bootdisk;
    public String cdrom;
    public String cicustom;
    public String cipassword;
    public CiType citype;
    public String ciuser;
    public Integer cores;
    public String cpu;
    public Double cpulimit;
    public Integer cpuunits;
    public String delete;
    public String description;
    public String digest;
    public String efidisk0;
    public Boolean force;
    public Boolean freeze;
    public String hookscript;
    @AppendKeyMap public Map<Integer, String> hostpci;
    public String hotplug;
    public HugePages hugepages;
    @AppendKeyMap public Map<Integer, String> ide;
    @AppendKeyMap public Map<Integer, String> ipconfig;
    public String ivshmem;
    public Boolean keephugepages;
    public Keyboard keyboard;
    public Boolean kvm;
    public Boolean localtime;
    public Lock lock;
    public String machine;
    public Integer memory;

    @JsonProperty("migrate_downtime")
    public Float migrateDowntime;

    @JsonProperty("migrate_speed")
    public Integer migrateSpeed;

    public String name;
    public String nameserver;
    @AppendKeyMap public Map<Integer, String> net;
    public Boolean numa;

    @JsonProperty("numa")
    @AppendKeyMap
    public Map<Integer, String> numaMap;

    public Boolean onboot;
    public OsType ostype;
    @AppendKeyMap public Map<Integer, String> parallel;
    public Boolean protection;
    public Boolean reboot;
    public String revert;
    public String rng0;
    @AppendKeyMap public Map<Integer, String> sata;
    @AppendKeyMap public Map<Integer, String> scsi;
    public ScsiHardware scsihw;
    public String searchdomain;
    @AppendKeyMap public Map<Integer, String> serial;
    public Integer shares;
    public Boolean skiplock;
    public String smbios1;
    public Integer smp;
    public Integer sockets;

    @JsonProperty("spice_enhancements")
    public String spiceEnhancements;

    public String sshkeys;
    public String startdate;
    public String startup;
    public Boolean tablet;
    public String tags;
    public Boolean tdf;
    public Boolean template;
    @AppendKeyMap public Map<Integer, String> unused;
    @AppendKeyMap public Map<Integer, String> usb;
    public Integer vcpus;
    public String vga;
    @AppendKeyMap public Map<Integer, String> virtio;
    public String vmgenid;
    public String vmstatestorage;
    public String watchdog;

    public T setAcpi(Boolean acpi) {
      this.acpi = acpi;
      return returnThis();
    }

    public T setAgent(String agent) {
      this.agent = agent;
      return returnThis();
    }

    public T setArch(Architecture arch) {
      this.arch = arch;
      return returnThis();
    }

    public T setArgs(String args) {
      this.args = args;
      return returnThis();
    }

    public T setAudio0(String audio0) {
      this.audio0 = audio0;
      return returnThis();
    }

    public T setAutostart(Boolean autostart) {
      this.autostart = autostart;
      return returnThis();
    }

    public T setBalloon(Long balloon) {
      this.balloon = balloon;
      return returnThis();
    }

    public T setBios(Bios bios) {
      this.bios = bios;
      return returnThis();
    }

    public T setBoot(String boot) {
      this.boot = boot;
      return returnThis();
    }

    public T setBootdisk(String bootdisk) {
      this.bootdisk = bootdisk;
      return returnThis();
    }

    public T setCdrom(String cdrom) {
      this.cdrom = cdrom;
      return returnThis();
    }

    public T setCicustom(String cicustom) {
      this.cicustom = cicustom;
      return returnThis();
    }

    public T setCipassword(String cipassword) {
      this.cipassword = cipassword;
      return returnThis();
    }

    public T setCitype(CiType citype) {
      this.citype = citype;
      return returnThis();
    }

    public T setCiuser(String ciuser) {
      this.ciuser = ciuser;
      return returnThis();
    }

    public T setCores(Integer cores) {
      this.cores = cores;
      return returnThis();
    }

    public T setCpu(String cpu) {
      this.cpu = cpu;
      return returnThis();
    }

    public T setCpulimit(Double cpulimit) {
      this.cpulimit = cpulimit;
      return returnThis();
    }

    public T setCpuunits(Integer cpuunits) {
      this.cpuunits = cpuunits;
      return returnThis();
    }

    public T setDelete(String delete) {
      this.delete = delete;
      return returnThis();
    }

    public T setDescription(String description) {
      this.description = description;
      return returnThis();
    }

    public T setDigest(String digest) {
      this.digest = digest;
      return returnThis();
    }

    public T setEfidisk0(String efidisk0) {
      this.efidisk0 = efidisk0;
      return returnThis();
    }

    public T setForce(Boolean force) {
      this.force = force;
      return returnThis();
    }

    public T setFreeze(Boolean freeze) {
      this.freeze = freeze;
      return returnThis();
    }

    public T setHookscript(String hookscript) {
      this.hookscript = hookscript;
      return returnThis();
    }

    public T setHostpci(Map<Integer, String> hostpci) {
      this.hostpci = hostpci;
      return returnThis();
    }

    public T setHotplug(String hotplug) {
      this.hotplug = hotplug;
      return returnThis();
    }

    public T setHugepages(HugePages hugepages) {
      this.hugepages = hugepages;
      return returnThis();
    }

    public T setIde(Map<Integer, String> ide) {
      this.ide = ide;
      return returnThis();
    }

    public T setIpconfig(Map<Integer, String> ipconfig) {
      this.ipconfig = ipconfig;
      return returnThis();
    }

    public T setIvshmem(String ivshmem) {
      this.ivshmem = ivshmem;
      return returnThis();
    }

    public T setKeephugepages(Boolean keephugepages) {
      this.keephugepages = keephugepages;
      return returnThis();
    }

    public T setKeyboard(Keyboard keyboard) {
      this.keyboard = keyboard;
      return returnThis();
    }

    public T setKvm(Boolean kvm) {
      this.kvm = kvm;
      return returnThis();
    }

    public T setLocaltime(Boolean localtime) {
      this.localtime = localtime;
      return returnThis();
    }

    public T setLock(Lock lock) {
      this.lock = lock;
      return returnThis();
    }

    public T setMachine(String machine) {
      this.machine = machine;
      return returnThis();
    }

    public T setMemory(Integer memory) {
      this.memory = memory;
      return returnThis();
    }

    public T setMigrateDowntime(Float migrateDowntime) {
      this.migrateDowntime = migrateDowntime;
      return returnThis();
    }

    public T setMigrateSpeed(Integer migrateSpeed) {
      this.migrateSpeed = migrateSpeed;
      return returnThis();
    }

    public T setName(String name) {
      this.name = name;
      return returnThis();
    }

    public T setNameserver(String nameserver) {
      this.nameserver = nameserver;
      return returnThis();
    }

    public T setNet(Map<Integer, String> net) {
      this.net = net;
      return returnThis();
    }

    public T setNuma(Boolean numa) {
      this.numa = numa;
      return returnThis();
    }

    public T setNumaMap(Map<Integer, String> numaMap) {
      this.numaMap = numaMap;
      return returnThis();
    }

    public T setOnboot(Boolean onboot) {
      this.onboot = onboot;
      return returnThis();
    }

    public T setOstype(OsType ostype) {
      this.ostype = ostype;
      return returnThis();
    }

    public T setParallel(Map<Integer, String> parallel) {
      this.parallel = parallel;
      return returnThis();
    }

    public T setProtection(Boolean protection) {
      this.protection = protection;
      return returnThis();
    }

    public T setReboot(Boolean reboot) {
      this.reboot = reboot;
      return returnThis();
    }

    public T setRevert(String revert) {
      this.revert = revert;
      return returnThis();
    }

    public T setRng0(String rng0) {
      this.rng0 = rng0;
      return returnThis();
    }

    public T setSata(Map<Integer, String> sata) {
      this.sata = sata;
      return returnThis();
    }

    public T setScsi(Map<Integer, String> scsi) {
      this.scsi = scsi;
      return returnThis();
    }

    public T setScsihw(ScsiHardware scsihw) {
      this.scsihw = scsihw;
      return returnThis();
    }

    public T setSearchdomain(String searchdomain) {
      this.searchdomain = searchdomain;
      return returnThis();
    }

    public T setSerial(Map<Integer, String> serial) {
      this.serial = serial;
      return returnThis();
    }

    public T setShares(Integer shares) {
      this.shares = shares;
      return returnThis();
    }

    public T setSkiplock(Boolean skiplock) {
      this.skiplock = skiplock;
      return returnThis();
    }

    public T setSmbios1(String smbios1) {
      this.smbios1 = smbios1;
      return returnThis();
    }

    public T setSmp(Integer smp) {
      this.smp = smp;
      return returnThis();
    }

    public T setSockets(Integer sockets) {
      this.sockets = sockets;
      return returnThis();
    }

    public T setSpiceEnhancements(String spiceEnhancements) {
      this.spiceEnhancements = spiceEnhancements;
      return returnThis();
    }

    public T setSshkeys(String sshkeys) {
      this.sshkeys = sshkeys;
      return returnThis();
    }

    public T setStartdate(String startdate) {
      this.startdate = startdate;
      return returnThis();
    }

    public T setStartup(String startup) {
      this.startup = startup;
      return returnThis();
    }

    public T setTablet(Boolean tablet) {
      this.tablet = tablet;
      return returnThis();
    }

    public T setTags(String tags) {
      this.tags = tags;
      return returnThis();
    }

    public T setTdf(Boolean tdf) {
      this.tdf = tdf;
      return returnThis();
    }

    public T setTemplate(Boolean template) {
      this.template = template;
      return returnThis();
    }

    public T setUnused(Map<Integer, String> unused) {
      this.unused = unused;
      return returnThis();
    }

    public T setUsb(Map<Integer, String> usb) {
      this.usb = usb;
      return returnThis();
    }

    public T setVcpus(Integer vcpus) {
      this.vcpus = vcpus;
      return returnThis();
    }

    public T setVga(String vga) {
      this.vga = vga;
      return returnThis();
    }

    public T setVirtio(Map<Integer, String> virtio) {
      this.virtio = virtio;
      return returnThis();
    }

    public T setVmgenid(String vmgenid) {
      this.vmgenid = vmgenid;
      return returnThis();
    }

    public T setVmstatestorage(String vmstatestorage) {
      this.vmstatestorage = vmstatestorage;
      return returnThis();
    }

    public T setWatchdog(String watchdog) {
      this.watchdog = watchdog;
      return returnThis();
    }
  }

  @JsonInclude(JsonInclude.Include.NON_NULL)
  public static class SyncUpdate extends BaseUpdate<SyncUpdate> {

    @Override
    protected SyncUpdate returnThis() {
      return this;
    }
  }

  @JsonInclude(JsonInclude.Include.NON_NULL)
  public static class AsyncUpdate extends BaseUpdate<AsyncUpdate> {

    @Override
    protected AsyncUpdate returnThis() {
      return this;
    }

    @JsonProperty("background_delay")
    public Integer backgroundDelay;

    public AsyncUpdate setBackgroundDelay(Integer backgroundDelay) {
      this.backgroundDelay = backgroundDelay;
      return this;
    }
  }
}
