package uk.co.hillion.jake.proxmox;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Network {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Create {
        public String iface;
        public Type type;

        public String address;
        public String address6;
        public Boolean autostart;

        @JsonProperty("bond-primary")
        public String bondPrimary;

        @JsonProperty("bond_mode")
        public BondMode bondMode;

        @JsonProperty("bond_xmit_hash_policy")
        public BondXmitHashPolicy bondXmitHashPolicy;

        @JsonProperty("bridge_ports")
        public String bridgePorts;

        @JsonProperty("bridge_vlan_aware")
        public Boolean bridgeVlanAware;

        public String cidr;
        public String cidr6;
        public String comments;
        public String comments6;
        public String gateway;
        public String gateway6;
        public Integer mtu;
        public String netmask;
        public Integer netmask6;

        @JsonProperty("ovs_bonds")
        public String ovsBonds;

        @JsonProperty("ovs_bridge")
        public String ovsBridge;

        @JsonProperty("ovs_options")
        public String ovsOptions;

        @JsonProperty("ovs_ports")
        public String ovsPorts;

        @JsonProperty("ovs_tag")
        public Integer ovsTag;

        public String slaves;

        @JsonProperty("vlan-id")
        public Integer vlanId;

        @JsonProperty("vlan-raw-device")
        public String vlanRawDevice;

        public Create setIface(String iface) {
            this.iface = iface;
            return this;
        }

        public Create setType(Type type) {
            this.type = type;
            return this;
        }

        public Create setAddress(String address) {
            this.address = address;
            return this;
        }

        public Create setAddress6(String address6) {
            this.address6 = address6;
            return this;
        }

        public Create setAutostart(Boolean autostart) {
            this.autostart = autostart;
            return this;
        }

        public Create setBondPrimary(String bondPrimary) {
            this.bondPrimary = bondPrimary;
            return this;
        }

        public Create setBondMode(BondMode bondMode) {
            this.bondMode = bondMode;
            return this;
        }

        public Create setBondXmitHashPolicy(BondXmitHashPolicy bondXmitHashPolicy) {
            this.bondXmitHashPolicy = bondXmitHashPolicy;
            return this;
        }

        public Create setBridgePorts(String bridgePorts) {
            this.bridgePorts = bridgePorts;
            return this;
        }

        public Create setBridgeVlanAware(Boolean bridgeVlanAware) {
            this.bridgeVlanAware = bridgeVlanAware;
            return this;
        }

        public Create setCidr(String cidr) {
            this.cidr = cidr;
            return this;
        }

        public Create setCidr6(String cidr6) {
            this.cidr6 = cidr6;
            return this;
        }

        public Create setComments(String comments) {
            this.comments = comments;
            return this;
        }

        public Create setComments6(String comments6) {
            this.comments6 = comments6;
            return this;
        }

        public Create setGateway(String gateway) {
            this.gateway = gateway;
            return this;
        }

        public Create setGateway6(String gateway6) {
            this.gateway6 = gateway6;
            return this;
        }

        public Create setMtu(Integer mtu) {
            this.mtu = mtu;
            return this;
        }

        public Create setNetmask(String netmask) {
            this.netmask = netmask;
            return this;
        }

        public Create setNetmask6(Integer netmask6) {
            this.netmask6 = netmask6;
            return this;
        }

        public Create setOvsBonds(String ovsBonds) {
            this.ovsBonds = ovsBonds;
            return this;
        }

        public Create setOvsBridge(String ovsBridge) {
            this.ovsBridge = ovsBridge;
            return this;
        }

        public Create setOvsOptions(String ovsOptions) {
            this.ovsOptions = ovsOptions;
            return this;
        }

        public Create setOvsPorts(String ovsPorts) {
            this.ovsPorts = ovsPorts;
            return this;
        }

        public Create setOvsTag(Integer ovsTag) {
            this.ovsTag = ovsTag;
            return this;
        }

        public Create setSlaves(String slaves) {
            this.slaves = slaves;
            return this;
        }

        public Create setVlanId(Integer vlanId) {
            this.vlanId = vlanId;
            return this;
        }

        public Create setVlanRawDevice(String vlanRawDevice) {
            this.vlanRawDevice = vlanRawDevice;
            return this;
        }

        public enum Type {
            @JsonProperty("bridge")
            BRIDGE,

            @JsonProperty("bridge")
            BOND,

            @JsonProperty("eth")
            ETH,

            @JsonProperty("alias")
            ALIAS,

            @JsonProperty("vlan")
            VLAN,

            @JsonProperty("OVSBridge")
            OVS_BRIDGE,

            @JsonProperty("OVSBond")
            OVS_BOND,

            @JsonProperty("OVSPort")
            OVS_PORT,

            @JsonProperty("OVSIntPort")
            OVS_INT_PORT,

            @JsonProperty("unknown")
            UNKNOWN,
        }

        public enum BondMode {
            @JsonProperty("balance-rr")
            BALANCE_RR,

            @JsonProperty("active-backup")
            ACTIVE_BACKUP,

            @JsonProperty("balance-xor")
            BALANCE_XOR,

            @JsonProperty("broadcast")
            BROADCAST,

            @JsonProperty("802.3ad")
            E802_3_AD,

            @JsonProperty("balance-tlb")
            BALANCE_TLB,

            @JsonProperty("balance-alb")
            BALANCE_ALB,

            @JsonProperty("balance-slb")
            BALANCE_SLB,

            @JsonProperty("lacp-balance-slb")
            LACP_BALANCE_SLB,

            @JsonProperty("lacp-balance-tcp")
            LACP_BALANCE_TCP,
        }

        public enum BondXmitHashPolicy {
            @JsonProperty("layer2")
            LAYER2,

            @JsonProperty("layer2+3")
            LAYER2_3,

            @JsonProperty("layer3+4")
            LAYER3_4,
        }
    }
}
