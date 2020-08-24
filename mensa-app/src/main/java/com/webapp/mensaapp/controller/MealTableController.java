package com.webapp.mensaapp.controller;

import com.webapp.mensaapp.model.MealTable;
import com.webapp.mensaapp.service.MealTableService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping(value = "/{id}")
    public Optional<MealTable> getMealTableById(@PathVariable("id") int id) {
        return mealTableService.getMealTableById(id);
    }
}
