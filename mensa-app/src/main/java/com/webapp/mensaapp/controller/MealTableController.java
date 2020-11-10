package com.webapp.mensaapp.controller;

import com.webapp.mensaapp.model.MealTable;
import com.webapp.mensaapp.service.MealTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/mealtable")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MealTableController {

    @Autowired
    private MealTableService mealTableService;

    @GetMapping
    public List<MealTable> getMealTables() {
        return mealTableService.getMealTables();
    }

    @GetMapping(value = "/weekly/{id}")
    public Optional<MealTable> getMealTableById(@PathVariable("id") int id) {
        return mealTableService.getMealTableById(id);
    }

    @PutMapping
    public ResponseEntity<MealTable> updateMealTable(@RequestBody MealTable mealTable) {
        mealTableService.updateMeatTable(mealTable);
        return new ResponseEntity<> (mealTable, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MealTable> addMealTable(@RequestBody MealTable mealTable) {
        mealTableService.addMealTable(mealTable);
        return new ResponseEntity<> (mealTable, HttpStatus.OK);
    }

    @DeleteMapping(value="/{id}")
    public void deleteMealTableById(@PathVariable("id") int id) {
        mealTableService.deleteMealTableById(id);

    }

    @PostMapping(path="/{mealTableId}/add/{mealId}/{weekday}")
    public ResponseEntity<MealTable> addMealToMealTable( @PathVariable("mealTableId") int mealTableId, @PathVariable("mealId") int mealId, @PathVariable("weekday") int weekday) {
        return mealTableService.addMealToMealTable(mealTableId, mealId, weekday);
    }

    @DeleteMapping(path="/{mealTableId}/delete/{mealId}/{weekday}")
    public ResponseEntity<MealTable> deleteMealFromMealTable( @PathVariable("mealTableId") int mealTableId, @PathVariable("mealId") int mealId, @PathVariable("weekday") int weekday) {
        return mealTableService.deleteMealFromMealTable(mealTableId, mealId, weekday);
    }
}
