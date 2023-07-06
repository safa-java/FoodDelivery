package com.fooddelivery.repo;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fooddelivery.entity.MenuItems;



@Repository
public interface MenuItemsRepo extends JpaRepository<MenuItems, Integer> {

}