package org.makermainds.jcoaching.resturantapp.controller.order;

import org.makermainds.jcoaching.resturantapp.model.order.Order;
import org.makermainds.jcoaching.resturantapp.model.order.OrderItemSize;


public class OrderCalculatorItaly extends AbstractOrderCalculator {
	
	private final double VAT_RATE = 0.2;

	
	@Override
	public double getSizeRateAmount(OrderItemSize orderItemSize) {
		switch(orderItemSize) {
		
		case SMALL:
			return 0.5;
		case MEDIUM:
			return 1;
		case LARGE:
			return 1.2;
		case XXL:
			return 1.4;
			default:
				System.err.println("Invalid order item size");
				return 1;
			
			
		}
		
	}
	
	
	@Override
	public double getVATRate() {
		
		return VAT_RATE;
	}


	@Override
	public double calculateTotalOrderAmount(Order order) {
		// TODO Auto-generated method stub
		return 0;
	}


	

	
	

}
