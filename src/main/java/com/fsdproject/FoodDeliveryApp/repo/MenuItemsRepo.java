package com.fsdproject.FoodDeliveryApp.repo;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fsdproject.FoodDeliveryApp.entity.MenuItems;



@Repository
public interface MenuItemsRepo extends JpaRepository<MenuItems, Integer> {
//	MenuItems save(MenuItems menuItems);

}