package com.webapp.mensaapp.service;

import com.webapp.mensaapp.model.Meal;
import com.webapp.mensaapp.repository.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class MealService {

    @Autowired
    private MealRepository mealRepository;

    public List<Meal> getMeals() {
        return mealRepository.findAll();
    }

    public Optional<Meal> getMealById(int id) {
        return mealRepository.findById(id);
    }

    @Transactional
    public void deleteMealById(int id) {
        mealRepository.deleteMealFromMealplanById(id);
        mealRepository.deleteById(id);
    }

    public Meal updateMeal(Meal meal) {
        return mealRepository.save(meal);
    }

    public void addMeal(Meal meal) {
        mealRepository.save(meal);
    }
}
