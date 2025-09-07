package com.example.stratergy;

public class UpiStratergy implements PaymentStratergy {
    @Override
    public void pay() {
        System.out.println("Payment processed successfully using UPI");
    }
}
