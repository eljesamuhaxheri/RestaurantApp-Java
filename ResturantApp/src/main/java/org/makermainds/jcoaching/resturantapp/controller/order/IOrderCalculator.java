package org.makermainds.jcoaching.resturantapp.controller.order;

import org.makermainds.jcoaching.resturantapp.model.order.Order;
import org.makermainds.jcoaching.resturantapp.model.order.OrderAmount;
import org.makermainds.jcoaching.resturantapp.model.order.OrderItem;
import org.makermainds.jcoaching.resturantapp.model.order.OrderItemSize;


public interface IOrderCalculator {

	public double calculateTotalOrderAmount(Order order);
	public double calculateOrderItemPrice(OrderItem orderItem) ;
    public double getSizeRateAmount(OrderItemSize orderItemSize) ;
	public double calculateTotalOrderAmountVAT(double totalOrderAmount) ;
	public double getVATRate();
	public double getVATRate(boolean decimal);
	
	public OrderAmount calculateOrderAmount(Order order) ;
	
	
	
}  

