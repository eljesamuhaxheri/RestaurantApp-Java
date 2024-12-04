package org.makerminds.jcoaching.resturantapp.controller.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.makermainds.jcoaching.resturantapp.controller.order.AbstractOrderCalculator;
import org.makermainds.jcoaching.resturantapp.model.Menu;
import org.makermainds.jcoaching.resturantapp.model.order.Order;
import org.makermainds.jcoaching.resturantapp.model.order.OrderItem;
import org.makermainds.jcoaching.resturantapp.model.order.OrderItemSize;
import org.makermainds.jcoaching.resturantapp.model.product.Meal;

public class AbstractOrderCalculatorTest {

	Menu menu = new Menu();
	
	AbstractOrderCalculator abstractOrderCalculatorMock = new AbstractOrderCalculator() {

		@Override
		public double getSizeRateAmount(OrderItemSize orderItemSize) {
			// TODO Auto-generated method stub
			return 1;
		}

		@Override
		public double getVATRate() {
			// TODO Auto-generated method stub
			return 0.12;
		}
		
	
	};

		
		@Test
		public void calculateOrderItemPriceTest()  {
			
			Meal hamburger = (Meal) menu.getMenuItems().get(100);
			
			OrderItem orderItem = new OrderItem(hamburger, 2, OrderItemSize.MEDIUM);
			
			double totalOrderItemPrice = abstractOrderCalculatorMock.calculateOrderItemPrice(orderItem);
			
			Assertions.assertEquals(9, totalOrderItemPrice);
			Assertions.assertEquals(4.5, orderItem.getOrderItemPrice());
			
			
		}
		
}
