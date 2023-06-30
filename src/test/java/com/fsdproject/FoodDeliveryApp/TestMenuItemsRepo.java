package com.fsdproject.FoodDeliveryApp;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.fsdproject.FoodDeliveryApp.entity.MenuItems;
import com.fsdproject.FoodDeliveryApp.repo.MenuItemsRepo;
import com.fsdproject.FoodDeliveryApp.service.MenuItemsService;

@SpringBootTest
public class TestMenuItemsRepo {
	@Autowired
    private MenuItemsService menuItemService;

    @MockBean
    private MenuItemsRepo menuItemRepository;

    private MenuItems menuItem;

     @BeforeEach
     public void menuServiceTestCaseSetup() {
         menuItem = new MenuItems (1, "biryani","non-veg",100);
     }
     
     @Test
     public void addFoodTest() {
         Mockito.when(menuItemRepository.save(menuItem)).thenReturn(menuItem);
         assertThat(menuItemService.addFood(menuItem)).isEqualTo(menuItem);

     }


    @Test
    public void testGetAllMenuItems() throws Exception {
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
    public void testDeleteMenuItem() throws Exception {

        // Mock the behavior of the menuItemsrepo
        doNothing().when(menuItemRepository).deleteById(menuItem.getFoodId());

        // Perform the DELETE request
       menuItemService.deleteFood(menuItem.getFoodId());

        verify(menuItemRepository, times(1)).deleteById(menuItem.getFoodId());
    }

}




