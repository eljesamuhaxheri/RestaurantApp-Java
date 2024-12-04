package org.makermainds.jcoaching.resturantapp;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.makermainds.jcoaching.resturantapp.controller.LocationManager;
import org.makermainds.jcoaching.resturantapp.controller.MenuImporter;
import org.makermainds.jcoaching.resturantapp.controller.MenuPrinter;
import org.makermainds.jcoaching.resturantapp.controller.order.IOrderCalculator;
import org.makermainds.jcoaching.resturantapp.controller.order.OrderCalculatorGER;
import org.makermainds.jcoaching.resturantapp.controller.order.OrderCalculatorKS;
import org.makermainds.jcoaching.resturantapp.controller.order.OrderProcessor;
import org.makermainds.jcoaching.resturantapp.controller.table.TablePrinter;
import org.makermainds.jcoaching.resturantapp.controller.table.TableReservationManager;
import org.makermainds.jcoaching.resturantapp.model.Menu;
import org.makermainds.jcoaching.resturantapp.model.Resturant;
import org.makermainds.jcoaching.resturantapp.model.enums.ApplicationMode;
import org.makermainds.jcoaching.resturantapp.model.enums.Location;
import org.makermainds.jcoaching.resturantapp.table.Table;
import org.makermainds.jcoaching.resturantapp.table.TableProvider;
import org.makermainds.jcoaching.resturantapp.model.Client;
import java.util.Scanner;


public class ResturantApp {
	
	private static Location currentLocation;
	private static int tableId;
	private static Scanner scanner  = new Scanner(System.in);
	
	private static TableProvider tableProvider = new TableProvider();
	
	private static List<Table> tableList = tableProvider.getTableList();
	private static TableReservationManager tableReservationManager = new TableReservationManager(tableList);
	
	private static final String MENU_FILE_PATH = "/menu-file.txt";
	
	public static void main(String[] args ) {
		ApplicationMode applicationMode;
		// String applicationMode = args[0];
		// String locationAsString = args[1];
		// chosenId = Integer.valueOf(args[0]);
		// currentLocation = LocationManager.getLocationFromString(locationAsString);
		try {
			do {
				applicationMode = getApplicationMode();
				if (applicationMode == ApplicationMode.ORDER) {
					getCurrentLocation();
					// runOrderProcess();s

				}
				validateApplicationMode(applicationMode);
			} while (applicationMode != ApplicationMode.EXIT);
			
			/*
			 * else { //System.out.println("Table reservation was selected");
			 * tableReservation(); }
			 */
			
		} catch (Exception exception) {
			exception.printStackTrace();
		} finally {
			scanner.close();
		}

	}
	private static void validateApplicationMode(ApplicationMode applicationMode) {
		switch(applicationMode) {
		case ORDER:
			runOrderProcess();
			break;
			
		case TABLERESERVATION:
			tableReservation();
			break;
			
		case EXIT:{
			System.out.println("The application has stopped. Thank you for using our app!");
			break;
		}
	       default:
				
			throw new IllegalArgumentException("unexpected value: " + (applicationMode));
		}
	}
	
	private static ApplicationMode getApplicationMode() {
		StringBuilder stringBuilder =  new StringBuilder();
		stringBuilder.append("Please select an application mode(type number): ")
		.append(System.lineSeparator())
		.append("1." + ApplicationMode.ORDER.name())
		.append(System.lineSeparator())
		.append("2." + ApplicationMode.TABLERESERVATION.name())
		.append(System.lineSeparator())
		.append("3." + ApplicationMode.EXIT.name());  
		System.out.print(stringBuilder);
		int selectedApplicationModeId = scanner.nextInt();
		ApplicationMode selectedApplicationMode = getApplicationModeFromId(selectedApplicationModeId);
		
		return selectedApplicationMode;
	}
	
	private static Location getCurrentLocation() {
		StringBuilder stringBuilder =  new StringBuilder();
		stringBuilder.append("Please select an application mode(type number): ")
		.append(System.lineSeparator())
		.append("1." + Location.KOSOVO.name())
		.append(System.lineSeparator())
		.append("2." + Location.GERMANY.name())
		.append(System.lineSeparator());
		System.out.print(stringBuilder);
		int selectedLocationId = scanner.nextInt();
	    currentLocation = LocationManager.getLocationFromId(selectedLocationId);
		return currentLocation;
	}
	
	private static ApplicationMode getApplicationModeFromId(int selectedApplicationModeId) {
		switch (selectedApplicationModeId) {
		case 1:{
			return ApplicationMode.ORDER;
		}
		case 2:{
			return ApplicationMode.TABLERESERVATION;
		}
		case 3:{
			return ApplicationMode.EXIT;
		}
		default:
			throw new IllegalArgumentException("Invalid order application");
	}
		
	}
	private static void runOrderProcess() {
	
		
    	Resturant resturant = new Resturant("Route 66" , "Te Heroinat,Prishtina");
    	
    	Client client = new Client("filan fisteku" , "+38345231123");
       
    	//Menu menu = new Menu();
    	//menu.initializeMenuProduct();
    	MenuImporter menuImporter = new MenuImporter();
    	Menu menu = menuImporter.importMenu(MENU_FILE_PATH);
    	
    	MenuPrinter menuPrinter = new MenuPrinter();
    	menuPrinter.printMenu(menu);
    	
    	OrderProcessor orderProcessor = new OrderProcessor();
    	orderProcessor.processOrder(client, resturant, menu, currentLocation);
    }
	
        private static void tableReservation() {
        	
        	//TableProvider tableProvider = new TableProvider();
        	//List<Table> tableList = tableProvider.getTableList();
        	TablePrinter tablePrinter = new TablePrinter();
        	tablePrinter.printTableList(tableList);
        	boolean tableWasFound = false ;
        	tableId = getTableIdFromUser();
        	//tableId = scanner.nextInt();
        	
        List<LocalDateTime> tableReservations = tableReservationManager.getTableReservationByTableId(tableId);
        tablePrinter.printTableReservations(tableId, tableReservations);
        
        LocalDateTime reservationLocalDateTime = getReservationDateTimeFromUser();
        
        boolean isTableFree = tableReservationManager.isTablFreeAt(tableId,reservationLocalDateTime);	
        if(isTableFree){
			tableReservationManager.addReservation(tableId, reservationLocalDateTime);
			System.out.println("Table with ID:" + tableId + "has been reserved for " + reservationLocalDateTime);
        }
        else {
        	System.out.println("The table with ID: " + tableId +"has already been reserved at " + reservationLocalDateTime);
        }
        
        	for(Table table : tableList) {
        		if(table.getTableId() == tableId) {
        			tableWasFound = true;
        		}
        	}
        	if(tableWasFound) {
        		System.out.println("the table with id " + tableId + " was found and reserved");
        	}
        	
        	else {
        		System.out.println("Table was not found");
        	}
        	
	}
         private static LocalDateTime getReservationDateTimeFromUser() {
		
        	 System.out.println("Pleace enter the date and time (yyyy-MM-dd HH:mm)");
        	 String input = scanner.nextLine();
        	
        	 DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
			return LocalDateTime.parse(input, dateTimeFormatter);
		}
         

		private static int getTableIdFromUser() {
			System.out.println("Please eneter the table ID: ");
			int selectedId = scanner.nextInt();
			scanner.nextLine();
			return selectedId;
			
		}

		private static IOrderCalculator getOrderCalculator(Location currentLocation) {
        	 switch(currentLocation) {
        	 case KOSOVO:
        		 return new OrderCalculatorKS();
        	 case GERMANY:
        		 return new OrderCalculatorGER();
        		 default:
        			 //throw new IllegalArgumentException("Invalid loction");
        			 System.err.println("Current location is invalid");
        			 return null;
        			 
        	 }
         }
}
