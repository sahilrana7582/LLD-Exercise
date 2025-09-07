package com.example;

import com.example.model.Address;
import com.example.model.Restaurant;
import com.example.services.RestaurantManagerService;

import java.time.LocalDateTime;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("===============");

        RestaurantManagerService restaurantManagerService = RestaurantManagerService.getInstance();
        System.out.println("===============");
        Restaurant restaurant = Restaurant.builder()
                .address(Address.builder().city("Garhshankar").state("Punjab").country("India").build())
                .name("Chicken Corne Punjab")
                .description("Best Chicken Corne in Punjab")
                .isActive(true)
                .isOpen(true)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();


        Restaurant r2 = Restaurant.builder()
                .address(Address.builder().city("Garhshankar").state("Punjab").country("India").build())
                .name("Punjabi Best KFC Punjab")
                .description("Best KFC Punjab Located in Garhshankar")
                .isActive(true)
                .isOpen(true)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();



        Restaurant r3 = Restaurant.builder()
                .address(Address.builder().city("Nawashehr").state("Punjab").country("India").build())
                .name("Punjabi Best KFC Punjab")
                .description("Best KFC Punjab Located in Garhshankar")
                .isActive(true)
                .isOpen(true)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        restaurantManagerService.addRestaurant(restaurant);
        restaurantManagerService.addRestaurant(r2);
        restaurantManagerService.addRestaurant(r3);


        System.out.println("====== ALl Services Operations ========");


        System.out.println("====== ALl  Restaurants ========");
        restaurantManagerService.getAllRestaurants().forEach(System.out::println);


        System.out.println("======  Restaurants By Location ========");
        restaurantManagerService.searchByLocation("Garhshankar", "Punjab").forEach(System.out::println);

    }
}