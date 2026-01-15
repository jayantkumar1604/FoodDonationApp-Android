package com.foodwaste.app.model;

public class FoodDonation {
    private String donorName;
    private String foodType;
    private int quantity;
    private String location;
    private String expiryTime;
    public String getDonorName() {
        return donorName;
    }

    public void setDonorName(String donorName) {
        this.donorName = donorName;
    }

    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getExpiryTime() {
        return expiryTime;
    }

    public void setExpiryTime(String expiryTime) {
        this.expiryTime = expiryTime;
    }



    public FoodDonation(String donorName, String foodType, int quantity,
                        String location, String expiryTime) {
        this.donorName = donorName;
        this.foodType = foodType;
        this.quantity = quantity;
        this.location = location;
        this.expiryTime = expiryTime;
    }
}
