package org.brewchain.core.crypto.cwv.jce;

import org.spongycastle.jce.provider.BouncyCastleProvider;

import java.security.Provider;
import java.security.Security;

public final class SpongyCastleProvider {

  private static class Holder {
    private static final Provider INSTANCE;
    static{
        Provider p = Security.getProvider("SC");
        
        INSTANCE = (p != null) ? p : new BouncyCastleProvider();
            
        INSTANCE.put("MessageDigest.ETH-KECCAK-256", "org.brewchain.core.crypto.hash.Keccak256");
        INSTANCE.put("MessageDigest.ETH-KECCAK-512", "org.brewchain.core.crypto.hash.Keccak512");
    }
  }

  public static Provider getInstance() {
    return Holder.INSTANCE;
  }
}
