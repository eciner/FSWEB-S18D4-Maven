package com.workintech.s18d1.util;

import com.workintech.s18d1.entity.Burger;
import com.workintech.s18d1.exceptions.BurgerException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class BurgerValidation {
    public void validate(Burger burger) {
        if (burger == null || burger.getName() == null || burger.getName().isBlank()
                || burger.getPrice() == null || burger.getPrice() <= 0
                || burger.getIsVegan() == null || burger.getBreadType() == null
                || burger.getContents() == null || burger.getContents().isBlank()) {
            throw new BurgerException("Invalid burger", HttpStatus.BAD_REQUEST);
        }
    }
}