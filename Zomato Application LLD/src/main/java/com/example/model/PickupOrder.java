package com.example.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
public class PickupOrder extends Order {
    private String pickupCode;

    @Override
    public String getType() {
        return "PICKUP";
    }
}
