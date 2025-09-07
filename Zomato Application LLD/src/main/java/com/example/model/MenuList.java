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
public class MenuList {
    private UUID id = UUID.randomUUID();
    private String name;
    private String description;
    private List<MenuItem> items;
}
