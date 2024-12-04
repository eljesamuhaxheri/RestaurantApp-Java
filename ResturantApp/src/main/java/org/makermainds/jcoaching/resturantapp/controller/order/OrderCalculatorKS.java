package org.makermainds.jcoaching.resturantapp.controller.order;

import org.makermainds.jcoaching.resturantapp.exceptions.InvalidOrderItemSizeException;
import org.makermainds.jcoaching.resturantapp.model.order.OrderItemSize;

public class OrderCalculatorKS extends AbstractOrderCalculator {
	
	private final double VAT_RATE = 0.18;
	
	@Override
	        public double getSizeRateAmount(OrderItemSize orderItemSize)    {
			switch (orderItemSize) {
			
			case SMALL:
			return 0.8;
			case MEDIUM:
			return 1;
			case LARGE:
			return 1.25;
			case XXL:
			return 1.5;
		
			default:
			//System.err.println("Invalid order item size");
			//return 1;
				throw new InvalidOrderItemSizeException("Invalid order item size");
	}
}
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
 