package org.brewchain.sdk.util;


import org.brewchain.core.crypto.JavaEncImpl;
import org.brewchain.core.crypto.cwv.util.BytesHelper;
import org.brewchain.core.crypto.model.KeyPairs;

import java.math.BigDecimal;
import java.math.BigInteger;

public class CryptoUtil {


    public static JavaEncImpl crypto;

    static {
        crypto = new JavaEncImpl();
    }

    /**
     * 可兼容以"0x"开头的16进制字符串的转换
     */
    public static byte[] hexStrToBytes(String hexStr){
//        return crypto.hexDec(hexStr);
        return BytesHelper.hexStringToBytes(hexStr);
    }

    public static String bytesToHexStr(byte[] bytes){
//        return crypto.hexEnc(bytes);
        return BytesHelper.toHexString(bytes);
    }

    public static String hexEncodeWithPrefix(byte[] bytes){
//        return crypto.hexEnc(bytes);
        return "0x"+BytesHelper.toHexString(bytes);
    }

    public static byte[] sha3(byte[] contentBytes){
        return crypto.sha3Encode(contentBytes);
    }

    public static KeyPairs privatekeyToAccountKey(byte[] pkBytes){
        return crypto.priKeyToKey(crypto.hexEnc(pkBytes));
    }
    public static KeyPairs privatekeyToAccountKey(String pk){
        return crypto.priKeyToKey(pk);
    }

    public static byte[] sign(String privateKey,byte[] contentBytes){
        return crypto.ecSign(privateKey,contentBytes);
    }
    public static String signHex(String privateKey,byte[] contentBytes){
        return bytesToHexStr(crypto.ecSign(privateKey,contentBytes));
    }

    public static boolean verifySign(String pubKey,byte[] cont,String sign){
        return crypto.ecVerify(pubKey,cont,hexStrToBytes(sign));
    }

    public static String privateKeyToAddress(byte[] pkBytes){
        return crypto.priKeyToKey(crypto.hexEnc(pkBytes)).getAddress();
    }

    public static String privateKeyToPublicKey(byte[] pkBytes){
        return crypto.priKeyToKey(crypto.hexEnc(pkBytes)).getPubkey();
    }

    public static KeyPairs getRandomKP(){
        return crypto.getRandomKP();
    }


    public static String add0X(String s) {
        if (s == null)
            return null;
        return s.startsWith("0x") ? s : "0x" + s;
    }

    public static String del0X(String s) {
        if (s == null)
            return null;
        return s.startsWith("0x") ? s.substring(2) : s;
    }


}
