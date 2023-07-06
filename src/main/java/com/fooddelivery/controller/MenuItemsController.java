package com.fooddelivery.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fooddelivery.entity.MenuItems;
import com.fooddelivery.exception.FoodNotFoundException;
import com.fooddelivery.service.MenuItemsService;




@RestController
@RequestMapping("/menu")
public class MenuItemsController {
	
	@Autowired
	private MenuItemsService menuitemsService;
	

	
	@GetMapping("/foods")
    public ResponseEntity<List<MenuItems>> getAllFoods() {
		List<MenuItems> foods = null;
        
		try {
			foods = menuitemsService.getAllFoods();
		} catch (Exception e) {
			//logger.log(e)
		}
        return new ResponseEntity<>(foods, HttpStatus.OK);
    }
	
    @GetMapping("/foods/{foodId}")
    public ResponseEntity<MenuItems> getFoodById(@PathVariable("foodId") int foodId)throws FoodNotFoundException {
    	MenuItems food = menuitemsService.getFoodById(foodId);
        if (food != null) {
            return new ResponseEntity<>(food, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/addFood")
    public ResponseEntity<MenuItems> addFood(@RequestBody MenuItems food) {
    	MenuItems savedFood = menuitemsService.addFood(food);
        return new ResponseEntity<>(savedFood, HttpStatus.CREATED);
    }

    @PutMapping("/updateFood/{foodId}")
    public ResponseEntity<MenuItems> updateFood(
            @PathVariable("foodId") int foodId,
            @RequestBody MenuItems food) {
    	MenuItems updatedFood = menuitemsService.updateFood(foodId, food);
        if (updatedFood != null) {
            return new ResponseEntity<>(updatedFood, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteFood/{foodId}")
    public ResponseEntity<Void> deleteFood(@PathVariable("foodId") int foodId) throws FoodNotFoundException {
        boolean deleted = menuitemsService.deleteFood(foodId);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    } 
    


}
