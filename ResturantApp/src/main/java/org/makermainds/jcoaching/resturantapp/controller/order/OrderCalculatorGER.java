package org.makermainds.jcoaching.resturantapp.controller.order;

import org.makermainds.jcoaching.resturantapp.model.order.OrderItemSize;


public class OrderCalculatorGER extends AbstractOrderCalculator{
	
	private final double VAT_RATE = 0.19;
	
	
	@Override
		public double getSizeRateAmount(OrderItemSize orderItemSize) { 
			
			switch(orderItemSize) {
			
			case SMALL:
			return 0.7;
			case MEDIUM:
			return 1;
			case LARGE:
			return 1.2;
			case XXL:
			return 1.35;
			default:
				throw new IllegalArgumentException("Invalid order item size");
				
		}	}
			

		@Override
		public double getVATRate() {
			
			
			return VAT_RATE;
			
		}


		/*@Override
		public double calculateTotalOrderAmount(Order order) {
			// TODO Auto-generated method stub
			return 0;
		}*/
		
}
 