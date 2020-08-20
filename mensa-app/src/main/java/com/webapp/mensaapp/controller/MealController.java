package com.webapp.mensaapp.controller;

import com.webapp.mensaapp.model.Meal;
import com.webapp.mensaapp.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Controller
@RestController(value="/meal")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MealController {

    @Autowired
    private MealService mealService;

    @GetMapping(value="/{id}")
    public Optional<Meal> getMealById(@PathVariable("id") int id) {
        return mealService.getMealById(id);
    }
}
