package com.example.model;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@ToString
public class Cart {

    private UUID id = UUID.randomUUID();
    private List<MenuItem> items;
    @Getter
    private double totalAmount;


    public void addItem(MenuItem item) {
        items.add(item);
        totalAmount += item.getPrice();
    }

    public void removeItem(MenuItem item) {
        items.remove(item);
        totalAmount -= item.getPrice();
    }


    public void clearCart() {
        items.clear();
        totalAmount = 0.0;
    }

}
