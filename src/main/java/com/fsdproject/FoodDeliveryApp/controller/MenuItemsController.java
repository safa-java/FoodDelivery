package com.fsdproject.FoodDeliveryApp.controller;





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

import com.fsdproject.FoodDeliveryApp.entity.MenuItems;
import com.fsdproject.FoodDeliveryApp.service.MenuItemsService;



//import com.foodies.service.OrderServiceImp;

@RestController
@RequestMapping("/menu")
public class MenuItemsController {
	
	@Autowired
	private MenuItemsService menuitemsService;
	

	//user service
//	OrderServiceImp orderService;
	
	@GetMapping("/foods")
    public ResponseEntity<List<MenuItems>> getAllFoods() {
		List<MenuItems> foods = null;
        
		try {
			foods = menuitemsService.getAllFoods();
		} catch (Exception e) {
			System.out.println(e);
		}
        return new ResponseEntity<>(foods, HttpStatus.OK);
    }
	
    @GetMapping("/foods/{foodId}")
    public ResponseEntity<MenuItems> getFoodById(@PathVariable("foodId") int foodId)throws Exception {
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
    public ResponseEntity<Void> deleteFood(@PathVariable("foodId") int foodId) throws Exception {
        boolean deleted = menuitemsService.deleteFood(foodId);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    /*@PostMapping("/{foodId}/addToCart")
    public ResponseEntity<String> addToCart(@PathVariable int foodId) {
        // Check if the food item is available and perform validation 
        MenuItems food = menuitemsService.getFoodById(foodId);
        
        if (food.getStatus() != "available") {
            return ResponseEntity.badRequest().body("Food item not found");
        }
        cartService.addToCart(foodId);

        return ResponseEntity.ok("Food item added to cart successfully");
    }*/
    
    
    // User Management

//    @GetMapping("/users")
//    public ResponseEntity<List<User>> getAllUsers() {
//        List<User> users = userService.getAllUsers();
//        return new ResponseEntity<>(users, HttpStatus.OK);
//    }
//    
//    @DeleteMapping("/users/{userId}")
//    public ResponseEntity<Void> deleteUserAccount(@PathVariable("userId") Long userId) {
//        boolean deleted = userService.deleteUser(userId);
//        if (deleted) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//    
//    //order management
//    
//    @GetMapping("/orders")
//    public ResponseEntity<List<Order>> getAllOrders() throws OrderNotFoundException{
//        List<Order> orders = orderService.viewOrder();//get all orders from order service
//        return new ResponseEntity<>(orders, HttpStatus.OK);
//    }
//    

//    ;;
}
