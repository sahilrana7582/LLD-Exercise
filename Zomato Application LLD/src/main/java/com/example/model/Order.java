package com.example.model;

import com.example.stratergy.PaymentStratergy;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@ToString
public abstract class Order {
    private UUID id = UUID.randomUUID();
    private User user;
    private Restaurant restaurant;
    private List<MenuItem> items;
    private double totalPrice;
    private PaymentStratergy paymentStratergy;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String status;

    public abstract String getType();


    public void processPayment() {
        if(paymentStratergy != null) {
            paymentStratergy.pay();
        }else{
            System.out.println("Payment stratergy not set");
        }
    }
}
