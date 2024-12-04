package org.makerminds.jcoaching.resturantapp.controller.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.makermainds.jcoaching.resturantapp.controller.order.OrderCalculatorGER;
import org.makermainds.jcoaching.resturantapp.controller.order.OrderCalculatorItaly;
import org.makermainds.jcoaching.resturantapp.model.order.OrderItemSize;

public class OrderCalculatorItalyTest {
	
	  OrderCalculatorItaly orderCalculatorItalyMock = new OrderCalculatorItaly();
		
		@Test
		public void getVATRateTest() {
			
			double vatRate = orderCalculatorItalyMock.getVATRate();
			
			Assertions.assertEquals(0.2, vatRate);
		}
		@Test
		public void getSizeRateAmountTest() {
			
			double sizeRateAmountSmall = orderCalculatorItalyMock.getSizeRateAmount(OrderItemSize.SMALL);
			Assertions.assertEquals(0.5, sizeRateAmountSmall);
			
			double sizeRateAmountMedium = orderCalculatorItalyMock.getSizeRateAmount(OrderItemSize.MEDIUM);
			Assertions.assertEquals(1, sizeRateAmountMedium);
			
			double sizeRateAmountLarge = orderCalculatorItalyMock.getSizeRateAmount(OrderItemSize.LARGE);
			Assertions.assertEquals(1.2, sizeRateAmountLarge);
			
			double sizeRateAmountXXL = orderCalculatorItalyMock.getSizeRateAmount(OrderItemSize.XXL);
			Assertions.assertEquals(1.4, sizeRateAmountXXL);
			
		}

}
