package com.webapp.mensaapp.repository;

import com.webapp.mensaapp.model.Meal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MealRepository extends JpaRepository<Meal, Integer> {

}
