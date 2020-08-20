package com.webapp.mensaapp.repository;


import com.webapp.mensaapp.model.MealTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MealTableRepository extends JpaRepository<MealTable, Integer> {
}
