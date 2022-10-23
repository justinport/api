package com.sample.api.models;

import java.util.LinkedList;

public class FoodItem {

    public int getFdcId() {
        return fdcId;
    }

    public void setFdcId(int fdcId) {
        this.fdcId = fdcId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getFoodCode() {
        return foodCode;
    }

    public void setFoodCode(String foodCode) {
        this.foodCode = foodCode;
    }

    public LinkedList<FoodNutrient> getFoodNutrients() {
        return foodNutrients;
    }

    private final LinkedList<FoodNutrient> foodNutrients = new LinkedList<>();
    private int fdcId = 0;
    private String description = null;
    private String dataType = null;
    private String publicationDate = null;
    private String foodCode = null;

}
