package org.makerminds.jcoaching.resturantapp.controller.test;

import java.util.HashMap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.makermainds.jcoaching.resturantapp.controller.MenuImporter;
import org.makermainds.jcoaching.resturantapp.model.Menu;
import org.makermainds.jcoaching.resturantapp.model.product.Product;

public class MenuImporterTest {

	private MenuImporter menuImporter;
	private final String MENU_FILE_PATE = "/menu-file.txt";
	
	@Test
	//testing
	public void testImporterMenu() {
		menuImporter = new MenuImporter();
		Menu importedMenu = menuImporter.importMenu(MENU_FILE_PATE);
		HashMap<Integer, Product> menuItems = importedMenu.getMenuItems();
		Assertions.assertEquals(8, menuItems.size());
		
		}
}
