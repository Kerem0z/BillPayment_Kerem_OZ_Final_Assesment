package com.example.demo.Entitys;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name ="payment")             //payment isimli tablo
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)     //paymentId generate etmek için gerekli kısım
    private Long paymentId;

    private Double totalAmount;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) //listeyi düzgün yazdırmak için
    private User user;


    public Payment() {          //constructor
    }

    public Payment(Long paymentId, Double totalAmount, User user) {
        this.paymentId = paymentId;
        this.totalAmount = totalAmount;
        this.user = user;
    }

    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
