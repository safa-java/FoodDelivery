package com.fooddelivery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fooddelivery.entity.MenuItems;
import com.fooddelivery.exception.FoodNotFoundException;
import com.fooddelivery.repo.MenuItemsRepo;


@Service
public class MenuItemsServiceImpl implements MenuItemsService {
	
	@Autowired
	private MenuItemsRepo menuItemsRepo;
	
    @Override
	public List<MenuItems> getAllFoods(){
		return menuItemsRepo.findAll();
	}
    @Override
	public  MenuItems getFoodById(int foodId) throws FoodNotFoundException{
        return menuItemsRepo.findById(foodId).orElse(null);
	}

    @Override
	public MenuItems addFood(MenuItems food) {
		return menuItemsRepo.save(food);
	}
    @Override
	public  MenuItems updateFood(int foodId, MenuItems updatedFood) {
		MenuItems existingFood = menuItemsRepo.findById(foodId).orElse(null);
        if (existingFood != null) {
            existingFood.setFoodName(updatedFood.getFoodName());
            existingFood.setCategory(updatedFood.getCategory());
            existingFood.setUnitPrice(updatedFood.getUnitPrice());
   
            return menuItemsRepo.save(existingFood);
        } else {
            return null;
        }
	}
    
    @Override
	public boolean deleteFood(int foodId) throws FoodNotFoundException{
		if (menuItemsRepo.existsById(foodId)) {
            menuItemsRepo.deleteById(foodId);
            return true;
        } else {
            return false;
        }
	}
	
	
    



	
	
}
