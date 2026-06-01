package com.workintech.s18d2.controller;

import com.workintech.s18d2.entity.Vegetable;
import com.workintech.s18d2.services.VegetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workintech/vegetables")
@Validated
public class VegetableController {

    private final VegetableService vegetableService;

    @Autowired
    public VegetableController(VegetableService vegetableService) {
        this.vegetableService = vegetableService;
    }

    @GetMapping
    public List<Vegetable> getAll() {
        return vegetableService.getByPriceAsc();
    }

    @GetMapping("/{id}")
    public Vegetable getById(@PathVariable Long id) {
        return vegetableService.getById(id);
    }

    @GetMapping("/desc")
    public List<Vegetable> getAllDesc() {
        return vegetableService.getByPriceDesc();
    }

    @PostMapping
    public Vegetable save(@RequestBody Vegetable vegetable) {
        return vegetableService.save(vegetable);
    }

    @PostMapping("/{name}")
    public List<Vegetable> search(
            @PathVariable String name) {

        return vegetableService.searchByName(name);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {

        vegetableService.delete(id);

        return "Fruit silindi";
    }
}
