package org.makermainds.jcoaching.resturantapp.model;


import java.util.HashMap;

import org.makermainds.jcoaching.resturantapp.model.product.Drink;
import org.makermainds.jcoaching.resturantapp.model.product.Meal;
import org.makermainds.jcoaching.resturantapp.model.product.Product;

public class Menu {

	private HashMap<Integer , Product> menuItems = new HashMap<>();
	
	public Menu() {
		
	}
	
	public void initializeMenuProduct() {
		
		menuItems.put(100, new Meal(100, "Hamburger", 4.5, "Angus beef patty, tomato, red onion"));
		menuItems.put(101, new Meal(101, "Cheeseburger", 5, "Angus beef patty, cheese, tomato, red onion"));
		menuItems.put(102, new Meal(102, "Sandwhich", 3.5, "Chicken, mayonnaise, peppers"));
		menuItems.put(103, new Meal(103, "Hotdog", 3, "Beef, mustard, ketchup, onion, cucumber"));
		menuItems.put(104, new Meal(104, "Pizza", 6, "Margarita, tomato sauce, mozarella"));
		menuItems.put(105, new Meal(105, "Fries", 2, "French fries with ketchup and mayonnaise"));
		menuItems.put(200, new Drink(200, "Coca-Cola", 1, false));
		menuItems.put(201, new Drink(201, "Coca-Cola Zero", 1, true));
		menuItems.put(202, new Drink(202, "Fanta", 1, false));
		menuItems.put(203, new Drink(203, "Sprite", 1, false));
		menuItems.put(204, new Drink(204, "RedBull", 2, false));
		menuItems.put(205, new Drink(205, "Coffee", 0.5));
		menuItems.put(300, new Meal(300, "Ice Cream", 1));
		menuItems.put(301, new Meal(301, "Waffle", 2.5));
		menuItems.put(302, new Meal(302, "Brownie", 1.5));
	}

	
	public HashMap<Integer, Product> getMenuItems(){
		return menuItems;
		
	}
}
