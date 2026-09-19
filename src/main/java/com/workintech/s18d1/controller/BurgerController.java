package com.workintech.s18d1.controller;

import com.workintech.s18d1.dao.BurgerDao;
import com.workintech.s18d1.entity.BreadType;
import com.workintech.s18d1.entity.Burger;
import com.workintech.s18d1.util.BurgerValidation;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping({"/burger", "/workintech/burgers"})
public class BurgerController {
    private static final Logger logger = LoggerFactory.getLogger(BurgerController.class);

    private final BurgerDao burgerDao;
    private final BurgerValidation burgerValidation;

    public BurgerController(BurgerDao burgerDao, BurgerValidation burgerValidation) {
        this.burgerDao = burgerDao;
        this.burgerValidation = burgerValidation;
    }

    @GetMapping
    public List<Burger> findAll() {
        return burgerDao.findAll();
    }

    @GetMapping("/{id}")
    public Burger findById(@PathVariable Long id) {
        try {
            return burgerDao.findById(id);
        } catch (RuntimeException exception) {
            logger.error("Unable to find burger with id {}", id, exception);
            throw exception;
        }
    }

    @PostMapping
    public Burger save(@RequestBody Burger burger) {
        burgerValidation.validate(burger);
        return burgerDao.save(burger);
    }

    @PutMapping({"", "/{id}"})
    public Burger update(@PathVariable(required = false) Long id, @RequestBody Burger burger) {
        if (id != null) {
            burger.setId(id);
        }
        burgerValidation.validate(burger);
        return burgerDao.update(burger);
    }

    @DeleteMapping("/{id}")
    public Burger remove(@PathVariable Long id) {
        return burgerDao.remove(id);
    }

    @GetMapping("/findByPrice")
    public List<Burger> findByPrice(@RequestBody Double price) {
        return burgerDao.findByPrice(price);
    }

    @GetMapping("/findByBreadType")
    public List<Burger> findByBreadType(@RequestBody BreadType breadType) {
        return burgerDao.findByBreadType(breadType);
    }

    @GetMapping("/findByContent")
    public List<Burger> findByContent(@RequestBody String content) {
        return burgerDao.findByContent(content);
    }

    @GetMapping("/price/{price}")
    public List<Burger> findByPricePath(@PathVariable double price) {
        return burgerDao.findByPrice(price);
    }

    @GetMapping("/breadType/{breadType}")
    public List<Burger> findByBreadTypePath(@PathVariable BreadType breadType) {
        return burgerDao.findByBreadType(breadType);
    }

    @GetMapping("/content/{content}")
    public List<Burger> findByContentPath(@PathVariable String content) {
        return burgerDao.findByContent(content);
    }
}