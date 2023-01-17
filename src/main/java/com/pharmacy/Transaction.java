package com.pharmacy;

import java.util.Date;

public class Transaction {
    private Drug drug;
    private int quantity;
    private Date date;

    public Transaction(){
        date = new Date();
    }

    public Drug getDrug(){
        return drug;
    }

    public void setDrug(Drug drug){
        this.drug = drug;
    }

    public int getQuantity(){
        return quantity;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    public Date getDate(){
        return date;
    }
}
