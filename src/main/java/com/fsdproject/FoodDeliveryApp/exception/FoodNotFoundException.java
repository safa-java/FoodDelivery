package com.fsdproject.FoodDeliveryApp.exception;



public class FoodNotFoundException extends RuntimeException {
    public FoodNotFoundException(int foodId) {
        super("Food not found with ID: " + foodId);
    }
}