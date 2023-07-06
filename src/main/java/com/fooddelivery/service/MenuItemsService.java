package com.fooddelivery.service;

import java.util.List;

import com.fooddelivery.entity.MenuItems;
import com.fooddelivery.exception.FoodNotFoundException;

public interface MenuItemsService {
	
	public MenuItems addFood(MenuItems food);
	
    public MenuItems getFoodById(int foodId) throws FoodNotFoundException;
    
	public  List<MenuItems> getAllFoods();
	
    public MenuItems updateFood(int foodId, MenuItems updatedFood);
    
    public boolean deleteFood(int foodId)throws FoodNotFoundException;



}
