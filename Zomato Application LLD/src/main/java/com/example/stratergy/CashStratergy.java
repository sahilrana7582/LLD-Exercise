package com.example.stratergy;

public class CashStratergy implements PaymentStratergy {
    @Override
    public void pay() {
        System.out.println("Payment processed successfully using cash");
    }
}
