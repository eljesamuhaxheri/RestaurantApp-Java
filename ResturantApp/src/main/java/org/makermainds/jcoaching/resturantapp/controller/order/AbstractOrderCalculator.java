package org.makermainds.jcoaching.resturantapp.controller.order;


import java.util.List;

import org.makermainds.jcoaching.resturantapp.exceptions.InvalidOrderItemSizeException;
import org.makermainds.jcoaching.resturantapp.model.order.Order;
import org.makermainds.jcoaching.resturantapp.model.order.OrderAmount;
import org.makermainds.jcoaching.resturantapp.model.order.OrderItem;
import org.makermainds.jcoaching.resturantapp.model.product.Product;

public abstract class AbstractOrderCalculator  implements IOrderCalculator{
	 
       public double calculateTotalOrderAmount(Order order)  {
		
		List<OrderItem> orderItems = order.getOrderItems();
		
		double totalOrderAmount = orderItems.stream()
		
		         .mapToDouble(this:: calculateOrderItemPrice)
		         .sum();
		
		/*for(OrderItem orderItem : orderItems) {
			totalOrderAmount += calculateOrderItemPrice(orderItem);
		}*/

		return totalOrderAmount;
		
	}

    public double calculateOrderItemPrice(OrderItem orderItem)   {
	//double sizeRateAmount = getSizeRateAmount(orderItem.getOrderItemSize());
	
    	double sizeRateAmount =  1;
    	
    	try {
    		
    		sizeRateAmount = getSizeRateAmount(orderItem.getOrderItemSize());
    	} 
    	catch(InvalidOrderItemSizeException e) {
 
    		System.out.println("No invalid order item size for "+ orderItem.getProduct().getName() + "Default size rate amount (100%) vill te applited");
    	}
    	
	Product product = orderItem.getProduct();
	double totalOrderItemPriceSingle = product.getPrice() * sizeRateAmount;
	orderItem.setOrderItemPrice(totalOrderItemPriceSingle);
	
	return totalOrderItemPriceSingle * orderItem.getQuantity();

	}
    
	public double calculateTotalOrderAmountVAT(double totalOrderAmount) {
	
		
	return totalOrderAmount * getVATRate();
	
	
}	

	//public abstract double getVATRate();
	
	public double getVATRate(boolean decimal) {
		if(decimal) {
			return getVATRate();
		} else {
			return getVATRate() * 100;
		}
	}
	
    public OrderAmount calculateOrderAmount(Order order) {
	
	double totalOrderAmount = calculateTotalOrderAmount(order);
	double totalOrderAmountVAT = calculateTotalOrderAmountVAT(totalOrderAmount);
	double totalOrderAmountWithVAT = totalOrderAmount + totalOrderAmountVAT;
	
	OrderAmount orderAmount = new OrderAmount(totalOrderAmount,totalOrderAmountVAT,totalOrderAmountWithVAT);
	

	return orderAmount;
}
}
    
