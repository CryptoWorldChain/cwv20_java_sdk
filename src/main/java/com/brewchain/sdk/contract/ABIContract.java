package com.brewchain.sdk.contract;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Data
@Slf4j
public class ABIContract {

    List<? extends HashMap> abiDetails;


    @NoArgsConstructor
    @Data
    public static class Parameter{
        boolean indexed;
        String internalType;
        String name;
        String type;
    }

    @NoArgsConstructor
    @Data
    public static class Method {
        String name;
        List<Parameter> inputs = new ArrayList<>();
        List<Parameter> outputs = new ArrayList<>();
        ;
        boolean anonymous;
        String type;
        String stateMutability;
        byte[] signature ;
        String signHex;


    }

    HashMap<String,List<Method>> methodByName = new HashMap<>();
    HashMap<String,Method> methodByID = new HashMap<>();
    byte[] binData ;

    public Method getOneMethodByName(String name){
        List<Method> nameMethod = methodByName.get(name);
        if(nameMethod!=null&&nameMethod.size()==1){
            return nameMethod.get(0);
        }
        return null;
    }

    public Method getConstructor(){
        return getOneMethodByName("constructor");
    }
    public Method getMethodByID(String id){
        return methodByID.get(id);
    }

    public static ABIContract parse(List<? extends HashMap> abiDetails){
        if(abiDetails==null){
            return null;
        }
        ABIContract  contract = new ABIContract();
        contract.abiDetails = abiDetails;
        for(HashMap<String,Object> abi:abiDetails){
            String name = (String)abi.getOrDefault("name","constructor");
            List<Method> nameMethod = contract.methodByName.get(name);
            if(nameMethod==null){
                nameMethod = new ArrayList<>();
                contract.methodByName.put(name,nameMethod);
            }

            Method method = new Method();

            method.setName(name);
            nameMethod.add(method);

            method.setType((String)abi.getOrDefault("type","function"));
            method.setAnonymous((boolean)abi.getOrDefault("anonymous",false));
            method.setStateMutability((String)abi.getOrDefault("stateMutability",""));


            if(abi.containsKey("inputs")) {
                //inputs
                for (HashMap<String, Object> input : (List<HashMap<String, Object>>) abi.get("inputs")) {
                    Parameter param = new Parameter();
                    param.setName((String) input.getOrDefault("name", ""));
                    param.setType((String) input.getOrDefault("type", ""));
                    param.setInternalType((String) input.getOrDefault("type", ""));
                    param.setIndexed((boolean) input.getOrDefault("indexed", false));
                    method.getInputs().add(param);

                }

            }
            ABIHelper.calcMethodSig(method);
            contract.methodByID.put(method.getSignHex(),method);
            //outputs
            if(abi.containsKey("outputs")) {
                for (HashMap<String, Object> output : (List<HashMap<String, Object>>) abi.get("outputs")) {
                    Parameter param = new Parameter();
                    param.setName((String) output.getOrDefault("name", ""));
                    param.setType((String) output.getOrDefault("type", ""));
                    param.setInternalType((String) output.getOrDefault("type", ""));
                    param.setIndexed((boolean) output.getOrDefault("indexed", false));
                    method.getOutputs().add(param);
                }
            }


        }
        return contract;
    }

}
