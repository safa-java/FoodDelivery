package com.fsdproject.FoodDeliveryApp.service;

import java.util.List;

import com.fsdproject.FoodDeliveryApp.entity.MenuItems;

public interface MenuItemsService {
	
	public MenuItems addFood(MenuItems food);
	
    public MenuItems getFoodById(int foodId) throws Exception;
    
	public  List<MenuItems> getAllFoods();
	
    public MenuItems updateFood(int foodId, MenuItems updatedFood);
    
    public boolean deleteFood(int foodId)throws Exception;



}
