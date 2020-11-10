package com.webapp.mensaapp.repository;

import com.webapp.mensaapp.model.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface MealRepository extends JpaRepository<Meal, Integer> {

    // Removes every object from meal from every mealplan
    @Modifying
    @Query(value = "DELETE FROM meal_table_meal_table_week m WHERE m.meal_table_week_id = ?1", nativeQuery = true)
    void deleteMealFromMealplanById(int id);

}
