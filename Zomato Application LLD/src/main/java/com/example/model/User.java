package com.example.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
@ToString
public class User {
    private UUID id = UUID.randomUUID();
    private String name;
    private String email;
    private String phoneNumber;
    private Address address;
    private Cart cart;
    private boolean isActive;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
