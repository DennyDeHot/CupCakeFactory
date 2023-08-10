package com.example.cupcakefactory;

public class Cart {

    public Cart(String userN, String cupName, String qty) {
        this.userN = userN;
        this.cupName = cupName;
        this.qty = qty;
    }

    public Cart() {

    }

    public String getUserN() {
        return userN;
    }

    public void setUserN(String userN) {
        this.userN = userN;
    }

    public String getCupName() {
        return cupName;
    }

    public void setCupName(String cupName) {
        this.cupName = cupName;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    private String userN;
    private String cupName;
    private String qty;
}

