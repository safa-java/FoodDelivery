package com.fsdproject.FoodDeliveryApp.entity;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
@Entity
@Table(name="menuitems")
public class MenuItems {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="foodId")
	private int foodId;
	
	@Column(name="foodName")
	private String foodName;
	
	@Column(name="category")
	private String category;
	
	@Column(name="unit_price")
	private int unit_price;
	

	public int getFoodId() {
		return foodId;
	}

	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}

	

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getUnit_price() {
		return unit_price;
	}

	public void setUnit_price(int unit_price) {
		this.unit_price = unit_price;
	}


	

	public MenuItems(int foodId, String foodName, String category, int unit_price) {
		super();
		this.foodId = foodId;
		this.foodName = foodName;
		this.category = category;
		this.unit_price = unit_price;
	
	}

	@Override
	public String toString() {
		return "MenuItems [foodId=" + foodId + ", foodName=" + foodName + ", category=" + category + ", unit_price="
				+ unit_price + "]";
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	

	public MenuItems() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}	


