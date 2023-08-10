package com.example.cupcakefactory;

public class Cupcake {




    public Cupcake(String cupCakeNo, String cupcakeName, String price, String quantity) {
        this.cupCakeNo = cupCakeNo;
        this.cupcakeName = cupcakeName;
        this.price = price;
        this.quantity = quantity;
    }
    private String cupCakeNo;
    private String cupcakeName;
    private String price;
    private String quantity;

    public Cupcake(String id, String price) {
    }

    public Cupcake() {
    }

    public String getCupcakeName() {return cupcakeName;}
    public String getCupcakeNo() {return cupCakeNo;}

    public String getPrice() {
        return price;
    }

    public String getQuantity() {
        return quantity;
    }


    public void setCupCakeNo(String cupCakeNo) {
        this.cupCakeNo = cupCakeNo;
    }

    public void setCupcakeName(String cupcakeName) {
        this.cupcakeName = cupcakeName;
    }

    public void setPrice(String price) {this.price = price;}

    public void setQuantity(String quantity) {this.quantity = quantity;}




    }



