package org.makermainds.jcoaching.resturantapp.controller.order;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

import org.makermainds.jcoaching.resturantapp.model.Resturant;
import org.makermainds.jcoaching.resturantapp.model.Client;
import org.makermainds.jcoaching.resturantapp.model.order.Order;
import org.makermainds.jcoaching.resturantapp.model.order.OrderAmount;
import org.makermainds.jcoaching.resturantapp.model.order.OrderItem;
import org.makermainds.jcoaching.resturantapp.model.product.Product;

public class OrderPrinter {
	
	
	StringBuilder stringBuilder = new StringBuilder();
	
	public void printOrderInfo(Resturant resturant ,Client client, 	Order order, OrderAmount orderAmount , int vatRate) {
		
		ArrayList<OrderItem> orderProducts = order.getOrderItems();
		printOrderInfoHeader(client);
		for(OrderItem orderItem : orderProducts) {
			printOrderItemInfo(orderItem);
		}
	
     printOrderInfoFooter(resturant,orderAmount, vatRate);
		
	}
       public String  getOrderInfo(Resturant resturant ,Client client, 	Order order, OrderAmount orderAmount , int vatRate) {
		
		ArrayList<OrderItem> orderProducts = order.getOrderItems();
		printOrderInfoHeader(client);
		for(OrderItem orderItem : orderProducts) {
			printOrderItemInfo(orderItem);
		}
	
     printOrderInfoFooter(resturant, orderAmount, vatRate);
			return stringBuilder.toString();
		
	}
	
	public  void printOrderItemInfo(OrderItem orderItem){
		
		Product product = orderItem.getProduct();
		double totalOrderItemPrice = orderItem.getOrderItemPrice() * orderItem.getQuantity();
		//System.out.println(orderItem.getQuantity() + "x  | " + product.getId()  + "." + product.getname() + " | " + orderItem.getOrderItemPrice() + " | " + totalOrderItemPrice + " Euro ");
	stringBuilder.append(orderItem.getQuantity())
	.append("x   | " + product.getProductId())
	.append(" .  " + product.getName())
	.append("  |  ")
	.append(orderItem.getOrderItemPrice())
	.append("  |  ")
	.append(totalOrderItemPrice)
	.append(" Euro \n ")
	.append("<br>");
	
	}
	
	public  void printOrderInfoHeader(Client client) {
		
		stringBuilder.append("<html> <br> Order from:")
		.append(client.getName())
		.append("<br>")
		.append("Tabel ID:" + client.getPhoneNumber())
		.append("<br>")
		.append("<hr>").append("<br>");
		
	}
	
	public  void printOrderInfoFooter(Resturant resturant, OrderAmount  orderAmount, int vatRate) {
		
		/*System.out.println("----------------------------------------");
		System.out.println("the price of the order is: ");
		System.out.println("SUB TOTAL: " + orderAmount.getTotalOrderAmount() + "Euro");
		System.out.println("VAT "+vatRate+"%: " + orderAmount.getTotalOrderAmountVAT() + "Euro");
		System.out.println("TOTAL: " + orderAmount.getTotalOrderAmountWithVAT() + "Euro");
		System.out.println("----------------------------------------");
		System.out.println(resturant.getName() + " in " + resturant.getAddress());*/
		
		
		stringBuilder.append("<hr>")
		.append("<br>")
		.append("the price of the order is: ").append("<br>")
		.append("SUB TOTAL: " ).append("<br>")
		.append(orderAmount.getTotalOrderAmount())
		.append(" Euro ").append("<br>");		
		stringBuilder.append(" VAT ")
		//.append(System.lineSeparator())
		.append(vatRate).append(" :  " )
		.append( orderAmount.getTotalOrderAmountVAT())
		.append(" Euro " ).append("<br>")
		.append(" TOTAL: " + orderAmount.getTotalOrderAmountWithVAT() + "Euro").append("<br>")
		.append(resturant.getName() + " in " + resturant.getAddress());
		System.out.println(stringBuilder);
				
	}
		
	}
	
	


