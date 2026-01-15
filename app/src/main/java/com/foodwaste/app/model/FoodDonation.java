package com.foodwaste.app.model;

public class FoodDonation {

    private Long id;
    private String donorName;
    private String foodType;
    private int quantity;
    private String location;
    private String expiryTime;
    private String status;   // 🆕

    public FoodDonation(String donorName, String foodType, int quantity,
                        String location, String expiryTime) {
        this.donorName = donorName;
        this.foodType = foodType;
        this.quantity = quantity;
        this.location = location;
        this.expiryTime = expiryTime;
    }

    public FoodDonation() {}

    public Long getId() { return id; }
    public String getDonorName() { return donorName; }
    public String getFoodType() { return foodType; }
    public int getQuantity() { return quantity; }
    public String getLocation() { return location; }
    public String getExpiryTime() { return expiryTime; }
    public String getStatus() { return status; }
}
