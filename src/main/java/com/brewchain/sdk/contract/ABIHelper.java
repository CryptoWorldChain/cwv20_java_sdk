package com.brewchain.sdk.contract;

import com.brewchain.sdk.model.TransactionImpl;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import onight.tfw.otransio.api.PSender;
import onight.tfw.outils.serialize.JsonSerializer;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.brewchain.core.crypto.cwv.HashUtil;
import org.brewchain.sdk.Config;
import org.brewchain.sdk.HiChain;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

@Slf4j
public class ABIHelper {

    PSender sender;
    public static ABIContract abiParse(File abiFile) {

        ABIContract contract = null;
        try (FileInputStream fin = new FileInputStream(abiFile); ByteArrayOutputStream bout = new ByteArrayOutputStream()) {

            byte buffer[] = new byte[8192];
            int offset = 0;
            ;
            while ((offset = fin.read(buffer)) > 0) {
                bout.write(buffer, 0, offset);
            }
            HashMap<String, Object> mapping = new HashMap<>();
            byte[] jsonBB = bout.toByteArray();
            System.out.println("json=" + new String(jsonBB));
            List<? extends HashMap> abiMapping = JsonSerializer.getInstance().deserializeArray(jsonBB, mapping.getClass());

            contract = ABIContract.parse(abiMapping);
//            System.out.println(contract);
        } catch (IOException e) {
            log.error("abi file parse Error", e);
        }

        if(contract!=null) {
            ;
            String binFile = abiFile.getName();
            binFile = binFile.substring(0,binFile.lastIndexOf("."))+".bin";
            try (FileInputStream fin = new FileInputStream(new File(abiFile.getParentFile(),binFile)); ByteArrayOutputStream bout = new ByteArrayOutputStream()) {

                byte buffer[] = new byte[8192];
                int offset = 0;

                while ((offset = fin.read(buffer)) > 0) {
                    bout.write(buffer, 0, offset);
                }
                byte[] binData = bout.toByteArray();
                contract.setBinData(Hex.decodeHex(new String(binData)));
//                System.out.println(Hex.encodeHexString(binData));

            } catch (IOException e) {
                log.error("bin file not found Error", e);
            } catch (DecoderException e) {
                e.printStackTrace();
            }
        }
        return contract;

    }

    public static void calcMethodSig(ABIContract.Method method) {
        StringBuffer sb = new StringBuffer();
        if (method.getType().equalsIgnoreCase("constructor")) {
            method.setSignature(new byte[]{});
            method.setSignHex("");
        } else {
            sb.append(method.getName());
            sb.append("(");
            int cc = 0;
            for (ABIContract.Parameter input : method.getInputs()) {
                if (cc > 0) {
                    sb.append(",");
                }
                cc++;
                sb.append(input.getType());
            }
            sb.append(")");
            byte[] bb = sb.toString().getBytes(StandardCharsets.UTF_8);
            byte[] ret = new byte[4];

            System.arraycopy(HashUtil.sha3(bb, 0, bb.length), 0, ret, 0, 4);
            method.setSignature(ret);
            method.setSignHex(Hex.encodeHexString(ret));
//            System.out.println("method=="+sb.toString()+",sign="+method.getSignHex());
        }
    }


    public static byte[] calcCallMethod(ABIContract.Method method, Object input0) {
        if (1 != method.inputs.size()) {
            log.debug("method length error:" + 1 + ", require=" + method.inputs.size());
            return null;
        }
        try (ByteArrayOutputStream bout = new ByteArrayOutputStream(); ByteArrayOutputStream dynamic = new ByteArrayOutputStream();) {
            bout.write(method.getSignature());
            int dataOffset = 32;
            ABIContract.Parameter param = method.getInputs().get(0);
            Object input = input0;
            ABITypeHelper.appendParam(param, input, bout, dynamic, dataOffset);
            bout.write(dynamic.toByteArray());
            return bout.toByteArray();
        } catch (Throwable t) {
            log.error("error in calc Call Method");
        }
        return null;
    }

    public static byte[] calcCallMethod(ABIContract.Method method, Object input0, Object input1) {
        if (2 != method.inputs.size()) {
            log.debug("method length error:" + 1 + ", require=" + method.inputs.size());
            return null;
        }
        try (ByteArrayOutputStream bout = new ByteArrayOutputStream(); ByteArrayOutputStream dynamic = new ByteArrayOutputStream();) {
            bout.write(method.getSignature());
            int dataOffset = 32 * 2;
            ABIContract.Parameter param = method.getInputs().get(0);
            ABITypeHelper.appendParam(param, input0, bout, dynamic, dataOffset);
            param = method.getInputs().get(1);
            ABITypeHelper.appendParam(param, input1, bout, dynamic, dataOffset);
            bout.write(dynamic.toByteArray());
            return bout.toByteArray();
        } catch (Throwable t) {
            log.error("error in calc Call Method");
        }
        return null;
    }

    public static byte[] calcCallMethod(ABIContract.Method method) {
        if (0 != method.inputs.size()) {
            log.debug("method length error:" + 1 + ", require=" + method.inputs.size());
            return null;
        }
        try (ByteArrayOutputStream bout = new ByteArrayOutputStream(); ByteArrayOutputStream dynamic = new ByteArrayOutputStream();) {
            bout.write(method.getSignature());
            return bout.toByteArray();
        } catch (Throwable t) {
            log.error("error in calc Call Method");
        }
        return null;
    }

    public static byte[] calcCallMethod(ABIContract.Method method, Object... inputs) {
        if (inputs.length != method.inputs.size()) {
            log.debug("method length error:" + inputs.length + ", require=" + method.inputs.size());
            return null;
        }

        try (ByteArrayOutputStream bout = new ByteArrayOutputStream(); ByteArrayOutputStream dynamic = new ByteArrayOutputStream();) {
            bout.write(method.getSignature());
            int dataOffset = 32 * inputs.length;
            for (int i = 0; i < inputs.length; i++) {
                ABIContract.Parameter param = method.getInputs().get(i);
                Object input = inputs[i];
                ABITypeHelper.appendParam(param, input, bout, dynamic, dataOffset);
            }
            bout.write(dynamic.toByteArray());
            return bout.toByteArray();
        } catch (Throwable t) {
            log.error("error in calc Call Method", t);
        }
        return null;

    }


    @SneakyThrows
    public static void main(String[] args) {
        Config.host = "http://124.70.198.19:8000";
        String from = "fc85cd6c929847621f77bda95ea645f46df2af53";
        String priKey = "ee353e42dab6de236e0071257bddeb1402dbf56de5d003ef2c08fc976f016380";

        String abipath = "C:\\Users\\moon\\contract\\Owner.abi";

        ABIContract contract = ABIHelper.abiParse(new File(abipath));

//        String userInfo = HiChain.getUserInfo(from);
//        log.info("\r 3 HiChain.getUserInfo==>\n{}",userInfo);
//        //3.2 HiChain.transferTo
//        List<TransferInfo> transactionOutputList = new ArrayList<TransferInfo>(){{
//            this.add(new TransferInfo("124f5c8adef4a0df051e62fc3ef52c9dcee94acd","1"));
//        }};
//        TransactionImpl.TxResult resultTransfer = HiChain.transferTo(from, NonceKeeper.refreshNonce(from), priKey,"",transactionOutputList);
//        log.info("\r 3 HiChain.transferTo return==>\n{}",resultTransfer);

        try {
            ABIContract.Method m = contract.getConstructor();
            byte[] bb = ABIHelper.calcCallMethod(m,(Object) 10,(Object) 10);
            if (bb != null) {
                System.out.println("call==>0x" + Hex.encodeHexString(contract.getBinData())+Hex.encodeHexString(bb));
            }
            TransactionImpl.TxResult txResult = HiChain.contractCreate(from,(int)HiChain.getNonce(from),priKey,Hex.encodeHexString(contract.getBinData())+Hex.encodeHexString(bb),"test contract ABIHelper");
            if(txResult.getRetCode() == 1) {
                Thread.sleep(30000);
                txResult = HiChain.getTxInfo(txResult.getHash());
            }
            if("0x01".equals(txResult.getStatus().getStatus())){
                log.info("\r HiChain.contractCreate success==>"+txResult);
            }

            bb = calcCallMethod(contract.getOneMethodByName("add"),(Object) 10,(Object) 20);
            if (bb != null) {
                System.out.println("call==>0x" + Hex.encodeHexString(bb));
            }
            //0xfce353f661626300000000000000000000000000000000000000000000000000000000006465660000000000000000000000000000000000000000000000000000000000
            txResult = HiChain.contractCall(from,(int)HiChain.getNonce(from),priKey,txResult.getStatus().getResult(),Hex.encodeHexString(bb),"test contract ABIHelper");
            if(txResult.getRetCode() == 1) {
                Thread.sleep(30000);
                txResult = HiChain.getTxInfo(txResult.getHash());
            }
            if("0x01".equals(txResult.getStatus().getStatus())){
                log.info("\r HiChain.contractCall add success==>"+txResult);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
//
//        try {
//            ABIContract.Method m = contract.getOneMethodByName("baz");
//            byte[] bb = ABIHelper.calcCallMethod(m, (Object) (69), (Object) true);
//            if (bb != null) {
//                System.out.println("call==>0x" + Hex.encodeHexString(bb));
//            }
//            //0xcdcd77c000000000000000000000000000000000000000000000000000000000000000450000000000000000000000000000000000000000000000000000000000000001
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        try {
//            ABIContract.Method m = contract.getOneMethodByName("sam");
//            int input3[] = new int[]{1, 2, 3};
//            byte[] bb = ABIHelper.calcCallMethod(m, (Object) ("dave"), (Object) true, (Object) input3);
//            if (bb != null) {
//                System.out.println("call==>0x" + Hex.encodeHexString(bb));
//            }
//            //0xa5643bf20000000000000000000000000000000000000000000000000000000000000060000000000000000000000000000000000000000000000000000000000000000100000000000000000000000000000000000000000000000000000000000000a0000000000000000000000000000000000000000000000000000000000000000464617665000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000003000000000000000000000000000000000000000000000000000000000000000100000000000000000000000000000000000000000000000000000000000000020000000000000000000000000000000000000000000000000000000000000003
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        try {
//            ABIContract.Method m = contract.getOneMethodByName("f");
//            int input2[] = new int[]{0x456, 0x789};
//            byte[] bb = ABIHelper.calcCallMethod(m, (Object) (0x123), (Object) input2, (Object) "1234567890", "Hello, world!");
//            if (bb != null) {
//                System.out.println("call==>0x" + Hex.encodeHexString(bb));
//            }
//            //0x8be6524600000000000000000000000000000000000000000000000000000000000001230000000000000000000000000000000000000000000000000000000000000080313233343536373839300000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000e0000000000000000000000000000000000000000000000000000000000000000200000000000000000000000000000000000000000000000000000000000004560000000000000000000000000000000000000000000000000000000000000789000000000000000000000000000000000000000000000000000000000000000d48656c6c6f2c20776f726c642100000000000000000000000000000000000000
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        try {
//            ABIContract.Method m = contract.getOneMethodByName("g");
//            int input0[][] = new int[][]{new int[]{1, 2}, new int[]{3}};
//            String input1[] = new String[]{"one", "two", "three"};
//            byte[] bb = ABIHelper.calcCallMethod(m, (Object) (input0), (Object) input1);
//            if (bb != null) {
//                System.out.println("call==>0x" + Hex.encodeHexString(bb));
//            }
//            //0x2289b18c000000000000000000000000000000000000000000000000000000000000004000000000000000000000000000000000000000000000000000000000000001400000000000000000000000000000000000000000000000000000000000000002000000000000000000000000000000000000000000000000000000000000004000000000000000000000000000000000000000000000000000000000000000a0000000000000000000000000000000000000000000000000000000000000000200000000000000000000000000000000000000000000000000000000000000010000000000000000000000000000000000000000000000000000000000000002000000000000000000000000000000000000000000000000000000000000000100000000000000000000000000000000000000000000000000000000000000030000000000000000000000000000000000000000000000000000000000000003000000000000000000000000000000000000000000000000000000000000006000000000000000000000000000000000000000000000000000000000000000a000000000000000000000000000000000000000000000000000000000000000e000000000000000000000000000000000000000000000000000000000000000036f6e650000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000374776f000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000057468726565000000000000000000000000000000000000000000000000000000
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
    }
}
