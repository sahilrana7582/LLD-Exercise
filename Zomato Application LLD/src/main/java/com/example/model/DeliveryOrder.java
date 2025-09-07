package com.example.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
public class DeliveryOrder extends Order {
    private Address deliveryAddress;
//    private DeliveryPerson assignedDeliveryPerson;

    @Override
    public String getType() {
        return "DELIVERY";
    }
}
