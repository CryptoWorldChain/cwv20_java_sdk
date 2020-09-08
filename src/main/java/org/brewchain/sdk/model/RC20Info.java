package org.brewchain.sdk.model;

public class RC20Info {

    /**
     * token_address : 0x4887e8cba9d2d8923c79801864d5d5b06e4113c8
     * value : {"balance":"0x204fce5e3e25026110000000"}
     * totalSupply : 0x204fce5e3e25026110000000
     * name : AAA
     * symbol : AAA
     * decimals : 0
     * ret_code : 1
     */

    private String token_address;
    private ValueBean value;
    private String totalSupply;
    private String name;
    private String symbol;
    private int decimals;
    private int ret_code;

    public String getToken_address() {
        return token_address;
    }

    public void setToken_address(String token_address) {
        this.token_address = token_address;
    }

    public ValueBean getValue() {
        return value;
    }

    public void setValue(ValueBean value) {
        this.value = value;
    }

    public String getTotalSupply() {
        return totalSupply;
    }

    public void setTotalSupply(String totalSupply) {
        this.totalSupply = totalSupply;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public int getDecimals() {
        return decimals;
    }

    public void setDecimals(int decimals) {
        this.decimals = decimals;
    }

    public int getRet_code() {
        return ret_code;
    }

    public void setRet_code(int ret_code) {
        this.ret_code = ret_code;
    }

    public static class ValueBean {
        /**
         * balance : 0x204fce5e3e25026110000000
         */

        private String balance;

        public String getBalance() {
            return balance;
        }

        public void setBalance(String balance) {
            this.balance = balance;
        }
    }
}
