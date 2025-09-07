package com.example.factory;

import com.example.model.*;
import com.example.stratergy.PaymentStratergy;

import java.time.LocalDateTime;
import java.util.UUID;

public class OrderFactoryImpl implements OrderFactory {

    @Override
    public Order createOrder(User user, Restaurant restaurant, PaymentStratergy paymentStratergy, String orderType) {
        if ("DELIVERY".equalsIgnoreCase(orderType)) {
            DeliveryOrder order = new DeliveryOrder();
            order.setId(UUID.randomUUID());
            order.setUser(user);
            order.setRestaurant(restaurant);
            order.setItems(user.getCart().getItems());
            order.setTotalPrice(user.getCart().getTotalAmount());
            order.setCreatedAt(LocalDateTime.now());
            order.setUpdatedAt(LocalDateTime.now());
            order.setStatus("PENDING");
            order.setPaymentStratergy(paymentStratergy);
            order.setDeliveryAddress(user.getAddress());
            return order;
        }
        throw new IllegalArgumentException("Invalid order type for this factory method: " + orderType);
    }

    @Override
    public Order createOrder(User user, Restaurant restaurant, PaymentStratergy paymentStratergy, String orderType, String pickupCode) {
        if ("PICKUP".equalsIgnoreCase(orderType)) {
            PickupOrder order = new PickupOrder();
            order.setId(UUID.randomUUID());
            order.setUser(user);
            order.setRestaurant(restaurant);
            order.setItems(user.getCart().getItems());
            order.setTotalPrice(user.getCart().getTotalAmount());
            order.setCreatedAt(LocalDateTime.now());
            order.setUpdatedAt(LocalDateTime.now());
            order.setStatus("PENDING");
            order.setPaymentStratergy(paymentStratergy);
            order.setPickupCode(pickupCode);
            return order;
        }
        throw new IllegalArgumentException("Invalid order type for this factory method: " + orderType);
    }
}
