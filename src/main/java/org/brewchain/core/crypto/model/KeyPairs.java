package org.brewchain.core.crypto.model;


public class KeyPairs {
	public static String ADDR_PRE = "CVN";
	//公钥
	String pubkey;
	//私钥
	String prikey;
	//地址
	String address;
	String bcuid;

	public KeyPairs(String pubkey, String prikey, String address, String bcuid) {
		super();

		this.pubkey = pubkey;
		this.prikey = prikey;
		this.address = ADDR_PRE==null|| ADDR_PRE==""?address:(ADDR_PRE+address);
		this.bcuid = bcuid;
	}

	public String getPubkey() {
		return pubkey;
	}

	public void setPubkey(String pubkey) {
		this.pubkey = pubkey;
	}

	public String getPrikey() {
		return prikey;
	}

	public void setPrikey(String prikey) {
		this.prikey = prikey;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBcuid() {
		return bcuid;
	}

	public void setBcuid(String bcuid) {
		this.bcuid = bcuid;
	}

	@Override
	public String toString() {
		return "KeyPairs{" +
				"pubkey='" + pubkey + '\'' +
				", prikey='" + prikey + '\'' +
				", address='" + address + '\'' +
				", bcuid='" + bcuid + '\'' +
				'}';
	}
}
