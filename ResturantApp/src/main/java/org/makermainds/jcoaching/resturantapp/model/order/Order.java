package org.makermainds.jcoaching.resturantapp.model.order;


import java.util.ArrayList;


public class Order {

	//SWITCH FROM AARRAY TO arrayList
	private  ArrayList<OrderItem> orderItems = new ArrayList<>();
	
	public Order() {
		
		
	}
	
	
	public ArrayList<OrderItem> getOrderItems(){
		
		return orderItems;
	}
	public void setOrderItem(ArrayList<OrderItem> productArrayList) {
		this.orderItems = productArrayList;
		
	}
}
