package org.makermainds.jcoaching.resturantapp.model.order;

import org.makermainds.jcoaching.resturantapp.model.product.Product;

public class OrderItem {
	
	private int quantity;
	private Product product;
	private double orderItemPrice;
	private OrderItemSize orderItemSize;
	
	public OrderItem(Product product, int quantity,OrderItemSize orderItemSize) {
		
		this.product = product;
		this.quantity =quantity;
		this.orderItemSize =orderItemSize;
		
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public double getOrderItemPrice() {
		return orderItemPrice;
	}

	public void setOrderItemPrice(double orderItemPrice) {
		this.orderItemPrice = orderItemPrice;
	}

	public OrderItemSize getOrderItemSize() {
		return orderItemSize;
	}

	public void setOrderItemSize(OrderItemSize orderItemSize) {
		this.orderItemSize = orderItemSize;
	}
	

}
