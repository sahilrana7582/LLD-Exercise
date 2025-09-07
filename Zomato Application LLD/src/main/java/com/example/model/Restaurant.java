package com.example.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@ToString
public class Restaurant {

    private UUID id = UUID.randomUUID();
    private String name;
    private String description;

    private boolean isActive;
    private boolean isOpen;

    private Address address;
//    private RestaurantManager manager;
    private MenuList menuList;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


}
