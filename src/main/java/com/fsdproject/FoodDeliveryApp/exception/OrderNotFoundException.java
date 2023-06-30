package com.fsdproject.FoodDeliveryApp.exception;



public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException(int orderId) {
        super("Order not found with ID: " + orderId);
    }
}