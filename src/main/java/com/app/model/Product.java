package com.app.model;

import lombok.Data;


@Data
public class Product {
    private int id;
    private String name;
    private String description;
    private double price;
}