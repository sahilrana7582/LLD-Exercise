package com.example.factory;

import com.example.model.*;
import com.example.stratergy.PaymentStratergy;

public interface OrderFactory {


    Order createOrder(User user, Restaurant restaurant, PaymentStratergy paymentStratergy
    , String orderType);
    Order createOrder(User user, Restaurant restaurant, PaymentStratergy paymentStratergy
            , String orderType, String pickupCode);
}
