package org.makerminds.jcoaching.resturantapp.controller.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.makermainds.jcoaching.resturantapp.controller.order.OrderCalculatorGER;
import org.makermainds.jcoaching.resturantapp.controller.order.OrderCalculatorKS;
import org.makermainds.jcoaching.resturantapp.model.order.OrderItemSize;

public class OrderCalculatorGERTest {
	
  OrderCalculatorGER orderCalculatorGERMock = new OrderCalculatorGER();
	
	@Test
	public void getVATRateTest() {
		
		double vatRate = orderCalculatorGERMock.getVATRate();
		
		Assertions.assertEquals(0.19 , vatRate);
	}
	@Test
	public void getSizeRateAmountTest() {
		
		double sizeRateAmountSmall = orderCalculatorGERMock.getSizeRateAmount(OrderItemSize.SMALL);
		Assertions.assertEquals(0.7 , sizeRateAmountSmall);
		
		double sizeRateAmountMedium = orderCalculatorGERMock.getSizeRateAmount(OrderItemSize.MEDIUM);
		Assertions.assertEquals(1 , sizeRateAmountMedium);
		
		double sizeRateAmountLarge = orderCalculatorGERMock.getSizeRateAmount(OrderItemSize.LARGE);
		Assertions.assertEquals(1.2 , sizeRateAmountLarge);
		
		double sizeRateAmountXXL = orderCalculatorGERMock.getSizeRateAmount(OrderItemSize.XXL);
		Assertions.assertEquals(1.35 , sizeRateAmountXXL);
		
	}

}
