package com.webapp.mensaapp.service;

import com.webapp.mensaapp.model.Meal;
import com.webapp.mensaapp.model.Weekday;
import com.webapp.mensaapp.repository.MealRepository;
import com.webapp.mensaapp.repository.MealTableRepository;
import com.webapp.mensaapp.model.MealTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class MealTableService {

    @Autowired
    private MealTableRepository mealTableRepository;

    @Autowired
    private MealRepository mealRepository;

    public List<MealTable> getMealTables() {
        return mealTableRepository.findAll();
    }

    public Optional<MealTable> getMealTableById(int id) {
        return mealTableRepository.findById(id);
    }

    public void addMealTable(MealTable mealTable) {
        mealTableRepository.save(mealTable);
    }

    public void updateMeatTable(MealTable mealTable) {
        mealTableRepository.save(mealTable);
    }

    public void deleteMealTableById(int id) {
        Optional<MealTable> selectedMealTable = mealTableRepository.findById(id);
        if (selectedMealTable.isPresent()) {
            MealTable mealTable = selectedMealTable.get();
            mealTable.getMealTableWeek().clear();
            mealTableRepository.deleteById(id);
        }
    }

    @Transactional
    public ResponseEntity<MealTable> addMealToMealTable(int mealTableId, int mealId, int weekday) {
        Optional<MealTable> selectedMealTable = mealTableRepository.findById(mealTableId);
        Optional<Meal> selectedMeal = mealRepository.findById(mealId);
        if (!(selectedMealTable.isPresent() && selectedMeal.isPresent())) {
            return null;
        } else {
            MealTable mealTable = selectedMealTable.get();
            Meal meal = selectedMeal.get();
            mealTable.getMealTableWeek().put(Weekday.valueOf(weekday), meal);
            return new ResponseEntity<>(mealTable, HttpStatus.OK);
        }
    }

    @Transactional
    public ResponseEntity<MealTable> deleteMealFromMealTable(int mealTableId, int mealId, int weekday) {
        Optional<MealTable> selectedMealTable = mealTableRepository.findById(mealTableId);
        Optional<Meal> selectedMeal = mealRepository.findById(mealId);
        if (!(selectedMealTable.isPresent() && selectedMeal.isPresent())) {
            return null;
        } else {
            MealTable mealTable = selectedMealTable.get();
            Meal meal = selectedMeal.get();
            mealTable.getMealTableWeek().remove(Weekday.valueOf(weekday), meal);
            return new ResponseEntity<>(mealTable, HttpStatus.OK);
        }
    }
}
