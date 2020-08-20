package com.webapp.mensaapp.service;

import com.webapp.mensaapp.model.Meal;
import com.webapp.mensaapp.repository.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MealService {

    @Autowired
    private MealRepository mealRepository;

    public Optional<Meal> getMealById(int id){
        return mealRepository.findById(id);
    }
}
