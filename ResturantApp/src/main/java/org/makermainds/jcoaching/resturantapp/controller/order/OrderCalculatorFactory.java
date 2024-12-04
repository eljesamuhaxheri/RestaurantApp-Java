package org.makermainds.jcoaching.resturantapp.controller.order;

import org.makermainds.jcoaching.resturantapp.model.enums.Location;

public class OrderCalculatorFactory {
	

	public static IOrderCalculator getCalculator(Location location) {
		
		switch(location) {
		case KOSOVO:
			return new OrderCalculatorKS();
		case GERMANY:
			return new OrderCalculatorGER();
		case ITALY:
			return new OrderCalculatorItaly();
			default:
				throw new IllegalArgumentException("No loaction selected");
			
	
		}
				
	}
}


