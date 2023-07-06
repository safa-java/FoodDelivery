package com.fooddelivery.entity;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

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
	private int unitPrice;
	

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

	public int getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}


	

	public MenuItems(int foodId, String foodName, String category, int unitPrice) {
		super();
		this.foodId = foodId;
		this.foodName = foodName;
		this.category = category;
		this.unitPrice = unitPrice;
	
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	

	public MenuItems() {
		super();
		
	}
	

}	


