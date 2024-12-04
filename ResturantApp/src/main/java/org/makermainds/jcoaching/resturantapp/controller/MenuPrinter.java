package org.makermainds.jcoaching.resturantapp.controller;

import java.util.Map.Entry;

import org.makermainds.jcoaching.resturantapp.model.Menu;
import org.makermainds.jcoaching.resturantapp.model.product.Product;

public class MenuPrinter {

	public void printMenu(Menu menu) {
		
		System.out.println("---------------Menu------------------------------");
	for(Entry<Integer,Product> menuEntry : menu.getMenuItems().entrySet()) {
		
		Product menuItem = menuEntry.getValue();
		System.out.println(menuItem.getProductId() + "." + menuItem.getName() + "|" + menuItem.getPrice() + "  Euro  ");
			
		}
	System.out.println("-----------------------------------------------------");
	System.out.println("");
	}
}
