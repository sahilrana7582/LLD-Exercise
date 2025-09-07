package com.example.services;

import com.example.model.Address;
import com.example.model.Restaurant;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class RestaurantManagerService {

    private static RestaurantManagerService instance;
    private final List<Restaurant> restaurants;

    private RestaurantManagerService() {
        this.restaurants = new ArrayList<>();
    }

    public static synchronized RestaurantManagerService getInstance() {
        if (instance == null) {
            instance = new RestaurantManagerService();
        }
        return instance;
    }

    public void addRestaurant(Restaurant restaurant) {
        restaurants.add(restaurant);
    }

    public Restaurant getRestaurantById(UUID id) {
        return restaurants.stream()
                .filter(r -> r.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public List<Restaurant> searchByLocation(String city, String state) {
        return restaurants.stream()
                .filter(r -> {
                    Address adder = r.getAddress();
                    return adder.getCity().equalsIgnoreCase(city)
                            && adder.getState().equalsIgnoreCase(state);
                })
                .collect(Collectors.toList());
    }

    public List<Restaurant> getAllRestaurants() {
        return new ArrayList<>(restaurants);
    }

    public boolean removeRestaurant(UUID id) {
        return restaurants.removeIf(r -> r.getId().equals(id));
    }

    public void updateRestaurant(Restaurant restaurant) {
        for (int i = 0; i < restaurants.size(); i++) {
            if (restaurants.get(i).getId().equals(restaurant.getId())) {
                restaurants.set(i, restaurant);
                break;
            }
        }
    }

    public void updateAddress(UUID id, Address address) {
        for (Restaurant restaurant : restaurants) {
            if (restaurant.getId().equals(id)) {
                restaurant.setAddress(address);
                break;
            }
        }
    }
}
