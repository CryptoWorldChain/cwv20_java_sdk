package com.brewchain.sdk.contract;

import com.brewchain.sdk.tools.bytes.BytesHelper;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

public class ABITypeHelper {

    public static void appendParam(ABIContract.Parameter param, Object input, ByteArrayOutputStream bout
            , ByteArrayOutputStream dynamic,int dataOffset) throws IOException {
        String orginType = param.getType().toLowerCase(Locale.ROOT);
        String type = orginType;
        int qutaIdx = type.indexOf("[");
        boolean fixLength = false;
        if(qutaIdx>0){
            int cc=0;
            for(int i=qutaIdx;i<type.length();i++){
                if(type.charAt(i)=='['){
                    if(i+1< type.length()&&type.charAt(i+1)!=']'){
                        fixLength = true;
                    }
                    cc++;
                }
            }
            type = orginType.substring(0,qutaIdx);
            if(orginType.startsWith("bytes")){
                if(qutaIdx>"bytes".length()){
                    type = "bytes32";
                }else {
                    type = "bytes";
                }
            }
            if(orginType.startsWith("uint")){
                type = "uint";
            }
            if(orginType.startsWith("int")){
                type = "nt";
            }
            for(int i=0;i<cc;i++)
            {
                type = type+"[]";
            }
        }else{
            if(orginType.startsWith("bytes")&&orginType.length()>"bytes".length()){
                type = "bytes32";
            }
        }
        System.out.println("orginType=="+orginType+",type="+type);
        switch (type) {
            case "address":
            case "uint32":
            case "bool":
            case "uint":
            case "uint256":
                bout.write(padding32(input));
                break;
            case "bytes32":
                bout.write(leftPadding32(input));
                break;
            case "bytes32[]":
            case "address[]":
                {
                if(input instanceof String[]){
                    String [] array = (String[])input;
                    for (int i = 0; i < array.length; i++) {
                        bout.write(leftPadding32(array[i]));
                    }
                }else if(input instanceof byte[][]){
                    byte[][] array = (byte[][]) input;
                    if (fixLength) {
                        for (int i = 0; i < array.length; i++) {
                            bout.write(padding32(array[i]));
                        }
                    } else {
                        bout.write(padding32(dataOffset + dynamic.size()));
                        bout.write(padding32(array.length));
                        for (int i = 0; i < array.length; i++) {
                            bout.write(padding32(array[i]));
                        }
                    }
                }else{
                    throw new IllegalStateException("Unexpected value: " + param.getType().toLowerCase(Locale.ROOT)+",realtype="+input.getClass());
                }
            }
                break;
            case "uint32[]":
            case "uint256[]":
            case "uint256[][]":
            case "uint[]":
            case "uint[][]":
            case "uint8[]":
            case "uint8[][]":
            case "uint32[][]":
            case "string":

            case "string[]":
            case "string[][]":
            case "int[][]":
            case "bytes":
            case "bytes[]":
                bout.write(padding32(dataOffset+dynamic.size()));
                writeDynamicType(input,dynamic);
                break;
            case "bytes3":
            case "bytes10":
                bout.write(leftPadding32(input));
            default:
                throw new IllegalStateException("Unexpected value: " + param.getType().toLowerCase(Locale.ROOT));
        }
    }

    public static byte[] leftPadding32(Object input) {
        return paddingHex(input, 32,true);
    }
    public static byte[] padding32(Object input) {
        return paddingHex(input, 32,false);
    }

    public static void writeDynamicType(Object input,ByteArrayOutputStream dynamic) throws IOException {
        System.out.println("writeDynamicType:"+input);
        if(input instanceof int[]){
            int []array = (int[])input;
            dynamic.write(padding32(array.length));
            for(int data:array){
                dynamic.write(padding32(data));
            }
        }
        else if(input instanceof String){
            byte []array = ((String)input).getBytes(StandardCharsets.UTF_8);
            dynamic.write(padding32(array.length));
            for(int i=0;i<array.length;i+=32)
            {
                byte aa[]=new byte[32];
                System.arraycopy(array,i*32,aa,0,Math.min(array.length-i*32,32));
                dynamic.write(leftPadding32(aa));
            }
        }
        else if(input instanceof byte[]){
            byte []array = (byte[])input;
            dynamic.write(padding32(array.length));
            for(int i=0;i<array.length;i+=32)
            {
                byte aa[]=new byte[32];
                System.arraycopy(array,i*32,aa,0,Math.min(array.length-i*32,32));
                dynamic.write(leftPadding32(aa));
            }
        }else if(input instanceof int[][]){
            int [][]array = (int[][])input;
            dynamic.write(padding32(array.length));
            ByteArrayOutputStream subout = new ByteArrayOutputStream();
            for(int i=0;i<array.length;i++){
                dynamic.write(padding32(array.length*32+subout.size()));
                writeDynamicType(array[i],subout);
            }
            dynamic.write(subout.toByteArray());
        }else if(input instanceof String[]){
            String []array = (String[])input;
            dynamic.write(padding32(array.length));
            ByteArrayOutputStream subout = new ByteArrayOutputStream();
            for(int i=0;i<array.length;i++){
                dynamic.write(padding32(array.length*32+subout.size()));
                writeDynamicType(array[i],subout);
            }
            dynamic.write(subout.toByteArray());
        }else if(input instanceof String[][]){
            String [][]array = (String[][])input;
            dynamic.write(padding32(array.length));
            ByteArrayOutputStream subout = new ByteArrayOutputStream();
            for(int i=0;i<array.length;i++){
                dynamic.write(padding32(array.length*32+subout.size()));
                writeDynamicType(array[i],subout);
            }
            dynamic.write(subout.toByteArray());
        }
        else if(input instanceof byte[][]){
            byte [][]array = (byte[][])input;
            dynamic.write(padding32(array.length));
            ByteArrayOutputStream subout = new ByteArrayOutputStream();
            for(int i=0;i<array.length;i++){
                dynamic.write(padding32(array.length*32+subout.size()));
                writeDynamicType(array[i],subout);
            }
            dynamic.write(subout.toByteArray());
        }
    }

    public static byte[] paddingHex(Object input, int len,boolean leftPad) {
        byte[] ret = new byte[len];
        for (int i = 0; i < len; i++) {
            ret[i] = 0;
        }
        if (input == null) {
            return ret;
        }
        byte[] inputBB = null;
        if (input instanceof String) {
            if(((String) input).startsWith("0x")){
            try {
                inputBB = Hex.decodeHex(((String) input).replaceFirst("0x", ""));
            } catch (DecoderException e) {
                e.printStackTrace();
            }}else{
                inputBB = ((String)input).getBytes(StandardCharsets.UTF_8);
            }
        } else if (input instanceof byte[]) {
            inputBB = (byte[]) input;
        } else if(input instanceof Boolean){
            if((Boolean)input)
            {
                inputBB = new byte[]{1};
            }else{
                inputBB = new byte[]{0};
            }
        }else if(input instanceof Integer){
            inputBB = BytesHelper.intToBytes((int)input);
        }
        if (inputBB != null) {
            if(leftPad){
                System.arraycopy(inputBB, 0, ret, 0, Math.min(32, inputBB.length));
            }else {
                System.arraycopy(inputBB,0, ret,  Math.max(0, 32 - inputBB.length), Math.min(32, inputBB.length));
            }
        }

        return ret;
    }
}
