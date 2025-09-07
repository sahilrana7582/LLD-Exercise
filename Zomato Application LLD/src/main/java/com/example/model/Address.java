package com.example.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Getter
@Setter
@Builder
@ToString
public class Address {

    private UUID id = UUID.randomUUID();
    private String street;
    private String city;
    private String state;
    private String country;
    private String postalCode;

}
