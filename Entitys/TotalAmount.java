package com.example.demo.Entitys;


public class TotalAmount {          //toplam fatura miktarı için gerekli entity

    private Double totalAmount;

    public TotalAmount(Long billId, Double billAmount, double result) {

    }


    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
