package org.makerminds.jcoaching.resturantapp.controller.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.makermainds.jcoaching.resturantapp.controller.order.OrderCalculatorKS;
import org.makermainds.jcoaching.resturantapp.model.order.OrderItemSize;

public class OrderCalculatorKSTest {
	
	OrderCalculatorKS orderCalculatorKSMock = new OrderCalculatorKS();
	
	@Test
	public void getVATRateTest() {
		
		double vatRate = orderCalculatorKSMock.getVATRate();
		
		Assertions.assertEquals(0.18 , vatRate);
	}
	@Test
	public void getSizeRateAmountTest() {
		
		double sizeRateAmountSmall = orderCalculatorKSMock.getSizeRateAmount(OrderItemSize.SMALL);
		Assertions.assertEquals(0.8 , sizeRateAmountSmall);
		
		double sizeRateAmountMedium = orderCalculatorKSMock.getSizeRateAmount(OrderItemSize.MEDIUM);
		Assertions.assertEquals(1 , sizeRateAmountMedium);
		
		double sizeRateAmountLarge = orderCalculatorKSMock.getSizeRateAmount(OrderItemSize.LARGE);
		Assertions.assertEquals(1.25 , sizeRateAmountLarge);
		
		double sizeRateAmountXXL = orderCalculatorKSMock.getSizeRateAmount(OrderItemSize.XXL);
		Assertions.assertEquals(1.5 , sizeRateAmountXXL);
		
	}

}
