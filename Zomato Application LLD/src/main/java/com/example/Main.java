package com.example;

import com.example.factory.OrderFactory;
import com.example.factory.OrderFactoryImpl;
import com.example.model.*;
import com.example.services.RestaurantManagerService;
import com.example.stratergy.CashStratergy;
import com.example.stratergy.PaymentStratergy;
import com.example.stratergy.UpiStratergy;

import java.util.Arrays;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {

        RestaurantManagerService restaurantManager = RestaurantManagerService.getInstance();
        OrderFactory orderFactory = new OrderFactoryImpl();

        System.out.println("==========================");
        System.out.println("CREATING RESTAURANTS");
        System.out.println("==========================");

        String[] restaurantNames = {"Pasta Palace", "Sushi World", "Curry Corner", "Burger Barn", "Pizza Planet"};

        for (int i = 0; i < restaurantNames.length; i++) {
            MenuItem item1 = MenuItem.builder()
                    .id(UUID.randomUUID())
                    .name("Dish " + (i+1) + "A")
                    .price(150 + i * 10)
                    .isAvailable(true)
                    .build();

            MenuItem item2 = MenuItem.builder()
                    .id(UUID.randomUUID())
                    .name("Dish " + (i+1) + "B")
                    .price(180 + i * 10)
                    .isAvailable(true)
                    .build();

            MenuList menu = MenuList.builder()
                    .id(UUID.randomUUID())
                    .name(restaurantNames[i] + " Menu")
                    .items(Arrays.asList(item1, item2))
                    .build();

            Restaurant restaurant = Restaurant.builder()
                    .id(UUID.randomUUID())
                    .name(restaurantNames[i])
                    .description("Famous for amazing " + restaurantNames[i])
                    .isActive(true)
                    .isOpen(true)
                    .address(Address.builder()
                            .id(UUID.randomUUID())
                            .street("Street " + (i+1))
                            .city("City " + (i+1))
                            .state("State " + (i+1))
                            .country("Country")
                            .postalCode("1000" + (i+1))
                            .build())
                    .menuList(menu)
                    .build();

            restaurantManager.addRestaurant(restaurant);
            System.out.println("Added Restaurant: " + restaurant.getName());
        }

        System.out.println("==========================");
        System.out.println("CREATING USERS");
        System.out.println("==========================");

        String[] userNames = {"Alice", "Bob", "Charlie", "Diana", "Ethan"};
        User[] users = new User[5];

        for (int i = 0; i < userNames.length; i++) {
            users[i] = User.builder()
                    .id(UUID.randomUUID())
                    .name(userNames[i])
                    .email(userNames[i].toLowerCase() + "@mail.com")
                    .phoneNumber("987654321" + i)
                    .address(Address.builder()
                            .id(UUID.randomUUID())
                            .street("User Street " + (i+1))
                            .city("City " + (i+1))
                            .state("State " + (i+1))
                            .country("Country")
                            .postalCode("2000" + (i+1))
                            .build())
                    .cart(Cart.builder().id(UUID.randomUUID()).build())
                    .isActive(true)
                    .build();
            System.out.println("Created User: " + users[i].getName());
        }

        System.out.println("==========================");
        System.out.println("CREATING ORDERS WITH PAYMENT");
        System.out.println("==========================");

        PaymentStratergy cash = new CashStratergy();
        PaymentStratergy upi = new UpiStratergy();

        for (User user : users) {
            System.out.println("----- User: " + user.getName() + " -----");
            for (Restaurant restaurant : restaurantManager.getAllRestaurants()) {
                Cart cart = user.getCart();
                cart.setItems(restaurant.getMenuList().getItems());
                cart.setTotalAmount(restaurant.getMenuList().getItems()
                        .stream().mapToDouble(MenuItem::getPrice).sum());

                String orderType = (Math.random() > 0.5) ? "DELIVERY" : "PICKUP";
                PaymentStratergy strategy = (Math.random() > 0.5) ? cash : upi;

                Order order;
                if ("DELIVERY".equals(orderType)) {
                    order = orderFactory.createOrder(user, restaurant, strategy, "DELIVERY");
                } else {
                    order = orderFactory.createOrder(user, restaurant, strategy, "PICKUP", "CODE" + UUID.randomUUID().toString().substring(0, 5));
                }

                System.out.println("==========================");
                System.out.println("Order Type: " + orderType);
                System.out.println("Restaurant: " + restaurant.getName());
                System.out.println("User: " + user.getName());
                System.out.println("Address" + user.getAddress());
                System.out.println("Items: " + order.getItems());
                System.out.println("Total Price: " + order.getTotalPrice());
                System.out.println("Order ID: " + order.getId());
                System.out.print("Payment Log: ");
                order.processPayment();
                System.out.println("==========================\n");
            }
        }

        System.out.println("==========================");
        System.out.println("SIMULATION COMPLETED");
        System.out.println("==========================");
    }
}
