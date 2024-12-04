package org.makermainds.jcoaching.resturantapp.controller.order;

import java.util.ArrayList;

import org.makermainds.jcoaching.resturantapp.model.Menu;
import org.makermainds.jcoaching.resturantapp.model.order.Order;
import org.makermainds.jcoaching.resturantapp.model.order.OrderItem;
import org.makermainds.jcoaching.resturantapp.model.order.OrderItemSize;
import org.makermainds.jcoaching.resturantapp.model.product.Product;

public class OrderManager {
	
	private ArrayList<Order> orders = new ArrayList<>();

    public ArrayList<Order> getOrders() {
	
    	return orders;
	}

    public Order createOrder(Menu menu) {
    	
    	Order order = new Order();
    	
 
     addOrder(order, menu.getMenuItems().get(103), OrderItemSize.MEDIUM , 2);
     addOrder(order, menu.getMenuItems().get(200), OrderItemSize.LARGE, 1);
     addOrder(order, menu.getMenuItems().get(201), OrderItemSize.XXL, 3);
		
		return order;
    }
    
    private void addOrder(Order order,Product product, OrderItemSize orderItemSize,int quantity) {
    	
    	OrderItem orderItemMeal = createOrderItemMeal(product , orderItemSize , quantity); 
    		 order.getOrderItems().add(orderItemMeal);
    	}
    	private OrderItem createOrderItemMeal(Product product , OrderItemSize orderItemSize , int  quantity) {
    		
    		return new OrderItem(product , quantity , orderItemSize);
    		
    		
    	}
    }


