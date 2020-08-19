package com.webapp.mensaapp.model;

import javax.persistence.*;
import java.util.Map;
import java.util.TreeMap;

@Entity
public class MealTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int calendarWeek;

    @ManyToMany(cascade = {CascadeType.ALL})
    private Map<Weekday, Meal> mealTableWeek = new TreeMap<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCalendarWeek() {
        return calendarWeek;
    }

    public void setCalendarWeek(int calendarWeek) {
        this.calendarWeek = calendarWeek;
    }
    public Map<Weekday, Meal> getMealTableWeek() {
        return mealTableWeek;
    }

    public void setMealTableWeek(Map<Weekday, Meal> mealTableWeek) {
        this.mealTableWeek = mealTableWeek;
    }
}
