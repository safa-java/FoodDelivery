package com.fooddelivery;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.fooddelivery.entity.MenuItems;
import com.fooddelivery.exception.FoodNotFoundException;
import com.fooddelivery.repo.MenuItemsRepo;
import com.fooddelivery.service.MenuItemsService;
import com.fooddelivery.service.MenuItemsServiceImpl;

@SpringBootTest
class TestMenuItemsRepo {
	@Autowired
    private MenuItemsService menuItemService;
	
	@InjectMocks
	private MenuItemsServiceImpl menuItemServiceImpl;

    @MockBean
    private MenuItemsRepo menuItemRepository;
    
    @InjectMocks
    private MenuItems menuItem;

     @BeforeEach
     
     public void menuServiceTestCaseSetup() {
    	 
         menuItem = new MenuItems (1, "biryani","non-veg",100);
     }
     
     @Test
      void addFoodTest() {
         Mockito.when(menuItemRepository.save(menuItem)).thenReturn(menuItem);
         assertThat(menuItemService.addFood(menuItem)).isEqualTo(menuItem);

     }


    @Test
     void testGetAllMenuItems() throws Exception {
        // Arrange
        MenuItems menuItem1 = new MenuItems(1,"shawarma","non-veg",120);
        MenuItems menuItem2 = new MenuItems(3,"biryani","non-veg", 100);
        List<MenuItems> menuItems = Arrays.asList(menuItem1, menuItem2);

        Mockito.when(menuItemRepository.findAll()).thenReturn(menuItems);

        // Act
        List<MenuItems> result = menuItemService.getAllFoods();

        // Assert
        assertEquals(2, result.size());
        assertEquals("shawarma", result.get(0).getFoodName());
        assertEquals("biryani", result.get(1).getFoodName());
        verify(menuItemRepository, times(1)).findAll();
    }
    @Test
     void testGetFoodById() throws FoodNotFoundException {
        // Mock the getFoodById() method to return the mock menu item
        Mockito.when(menuItemRepository.findById(1)).thenReturn(Optional.of(menuItem));

        // Call the getFoodById() method on the MenuItemsServiceImpl object
        MenuItems foundFood = menuItemService.getFoodById(1);

        // Assert that the found food is the same as the mock food
        Mockito.verify(menuItemRepository).findById(1);
        assertEquals(menuItem, foundFood);
    }
    
  
    
    @Test
     void testUpdateFood() throws FoodNotFoundException {



        menuItem.setFoodId(1);
        menuItem.setFoodName("Pizza");
        menuItem.setCategory("Italian");
        menuItem.setUnitPrice(10);

        // Create an updated food item
        MenuItems updatedFood = new MenuItems();
        updatedFood.setFoodName("Pasta");
        updatedFood.setCategory("Italian");
        updatedFood.setUnitPrice(15);

        // Stub the menuItemsRepo.findById() method to return the mock food item
        Mockito.when(menuItemRepository.findById(menuItem.getFoodId())).thenReturn(Optional.of(menuItem));

        // Stub the menuItemsRepo.save() method to return the updated food item
        Mockito.when(menuItemRepository.save(menuItem)).thenReturn(updatedFood);

        // Call the updateFood() method
        MenuItems updatedMenuItem = menuItemService.updateFood(menuItem.getFoodId(), updatedFood);

        // Verify that the menuItemsRepo.findById() method was called
        Mockito.verify(menuItemRepository).findById(menuItem.getFoodId());

        // Verify that the menuItemsRepo.save() method was called
        Mockito.verify(menuItemRepository).save(menuItem);

        // Assert that the updatedFood object is returned
        assertEquals(updatedFood, updatedMenuItem);
    }
    
    @Test
     void testUpdateFoodDoesNotUpdateNonExistingFood() throws FoodNotFoundException {
        Mockito.when(menuItemRepository.findById(1)).thenReturn(Optional.of(menuItem));

        // Create a new menu item with updated information
        MenuItems updatedMenuItem = new MenuItems();
        updatedMenuItem.setFoodId(1);
        updatedMenuItem.setFoodName("Pasta");
        updatedMenuItem.setCategory("Main Course");
        updatedMenuItem.setUnitPrice(15);

        // Call the updateFood() method
        menuItemService.updateFood(1, updatedMenuItem);

        // Assert that the updateFood() method did not update the existing food
        Mockito.verify(menuItemRepository, Mockito.never()).save(updatedMenuItem);
    }
}






 
