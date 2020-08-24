package com.webapp.mensaapp.controller;

import com.webapp.mensaapp.model.Meal;
import com.webapp.mensaapp.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/meal")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MealController {

    @Autowired
    private MealService mealService;

    @GetMapping
    public List<Meal> getMeals() {
        return mealService.getMeals();
    }

    @GetMapping(value="/{id}")
    public Optional<Meal> getMealById(@PathVariable("id") int id) {
        return mealService.getMealById(id);
    }

    @DeleteMapping(value="/{id}")
    public void deleteMealById(@PathVariable("id") int id) {
        mealService.deleteMealById(id);
    }

    //Update
    @PutMapping
    public Meal updateMeal(@RequestBody Meal meal) {
        return mealService.updateMeal(meal);
    }

    @PostMapping
    public ResponseEntity<Meal> addMeal(@RequestBody Meal meal){
        mealService.addMeal(meal);
        return new ResponseEntity<> (meal, HttpStatus.OK);
    }
}
