package org.makermainds.jcoaching.resturantapp.controller.order;

import org.makermainds.jcoaching.resturantapp.model.Client;
import org.makermainds.jcoaching.resturantapp.model.Menu;
import org.makermainds.jcoaching.resturantapp.model.Resturant;
import org.makermainds.jcoaching.resturantapp.model.enums.Location;
import org.makermainds.jcoaching.resturantapp.model.order.Order;
import org.makermainds.jcoaching.resturantapp.model.order.OrderAmount;

public class OrderProcessor {
	

	public void processOrder(Client client , Resturant resturant, Menu menu , Location location) {
		
		OrderManager orderProcessor = new OrderManager();
		Order order = orderProcessor.createOrder(menu);
		IOrderCalculator calculator = OrderCalculatorFactory.getCalculator(location);
		OrderAmount orderAmount = calculator.calculateOrderAmount(order);
		int vatRate = (int)calculator.getVATRate(false);
		
		OrderPrinter orderPrinter = new OrderPrinter();
		orderPrinter.printOrderInfo(resturant, client, order, orderAmount, vatRate);
		
		
	}

	public String processOrder(Client client, Resturant resturant, Order order, Location location) {

		// OrderManager orderProcessor = new OrderManager();
		// Order order = orderProcessor.createOrder(menu);
		IOrderCalculator calculator = OrderCalculatorFactory.getCalculator(location);
		OrderAmount orderAmount = calculator.calculateOrderAmount(order);
	    int vatRate = (int) calculator.getVATRate(false);

		OrderPrinter orderPrinter = new OrderPrinter();
		return orderPrinter.getOrderInfo(resturant, client, order, orderAmount, vatRate);

	}
}
