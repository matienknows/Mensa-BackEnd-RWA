package com.webapp.mensaapp.service;

import com.webapp.mensaapp.repository.MealTableRepository;
import com.webapp.mensaapp.model.MealTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MealTableService {

    @Autowired
    private MealTableRepository mealTableRepository;

    public List<MealTable> getMealTables() {
        return mealTableRepository.findAll();
    }

    public Optional<MealTable> getMealTableById(int id) {
        return mealTableRepository.findById(id);
    }

    public void deleteEssenById() {

    }
}
