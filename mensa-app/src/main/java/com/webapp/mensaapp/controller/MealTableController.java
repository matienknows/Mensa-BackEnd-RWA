package com.webapp.mensaapp.controller;

import com.webapp.mensaapp.model.MealTable;
import com.webapp.mensaapp.service.MealTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/mealtable")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MealTableController {

    @Autowired
    private MealTableService mealTableService;

    @GetMapping
    @PreAuthorize("hasAuthority('ROLE_ADMIN')or hasAuthority('ROLE_USER')")
    public List<MealTable> getMealTables() {
        return mealTableService.getMealTables();
    }

    @GetMapping(value = "/weekly/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')or hasAuthority('ROLE_USER')")
    public Optional<MealTable> getMealTableById(@PathVariable("id") int id) {
        return mealTableService.getMealTableById(id);
    }

    @PutMapping
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<MealTable> updateMealTable(@RequestBody MealTable mealTable) {
        mealTableService.updateMeatTable(mealTable);
        return new ResponseEntity<>(mealTable, HttpStatus.OK);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<MealTable> addMealTable(@RequestBody MealTable mealTable) {
        mealTableService.addMealTable(mealTable);
        return new ResponseEntity<>(mealTable, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteMealTableById(@PathVariable("id") int id) {
        mealTableService.deleteMealTableById(id);

    }

    @PostMapping(path = "/{mealTableId}/add/{mealId}/{weekday}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<MealTable> addMealToMealTable(@PathVariable("mealTableId") int mealTableId, @PathVariable("mealId") int mealId, @PathVariable("weekday") int weekday) {
        return mealTableService.addMealToMealTable(mealTableId, mealId, weekday);
    }

    @DeleteMapping(path = "/{mealTableId}/delete/{mealId}/{weekday}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<MealTable> deleteMealFromMealTable(@PathVariable("mealTableId") int mealTableId, @PathVariable("mealId") int mealId, @PathVariable("weekday") int weekday) {
        return mealTableService.deleteMealFromMealTable(mealTableId, mealId, weekday);
    }
}
