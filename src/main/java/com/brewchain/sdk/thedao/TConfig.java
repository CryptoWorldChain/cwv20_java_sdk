package com.brewchain.sdk.thedao;

import lombok.Data;
import onight.tfw.outils.conf.PropHelper;

@Data
public class TConfig {
	public static PropHelper props = new PropHelper(null);

	public static final String CONTRACT_MINER_WHITELIST = props.get("org.brewchain.eco.com.brewchain.sdk.thedao.contract.miner.whitelist", "0x");

}
