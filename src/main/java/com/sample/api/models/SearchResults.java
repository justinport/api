package com.sample.api.models;

import java.util.LinkedList;

public class SearchResults {
    public LinkedList<FoodItem> getFoods() {
        return foods;
    }

    private final LinkedList<FoodItem> foods = new LinkedList<>();
}
