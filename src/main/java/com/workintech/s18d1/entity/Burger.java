package com.workintech.s18d1.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Burger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double price;
    private Boolean isVegan;

    @Enumerated(EnumType.STRING)
    private BreadType breadType;

    private String contents;

    public Burger() {
    }

    public Burger(Long id, String name, Double price, Boolean isVegan, BreadType breadType, String contents) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.isVegan = isVegan;
        this.breadType = breadType;
        this.contents = contents;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }
    public Boolean getIsVegan() { return isVegan; }
    public void setIsVegan(Boolean isVegan) { this.isVegan = isVegan; }
    public BreadType getBreadType() { return breadType; }
    public void setBreadType(BreadType breadType) { this.breadType = breadType; }
    public String getContents() { return contents; }
    public void setContents(String contents) { this.contents = contents; }
}