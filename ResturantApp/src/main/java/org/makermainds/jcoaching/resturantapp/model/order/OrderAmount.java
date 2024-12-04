package org.makermainds.jcoaching.resturantapp.model.order;

public class OrderAmount {

	private double totalOrderAmount;
	private double totalOrderAmountVAT;
	private double totalOrderAmountWithVAT;
	

	public OrderAmount(double totalOrderAmount, double totalOrderAmountVAT, double totalOrderAmountWithVAT) {
		this.totalOrderAmount = totalOrderAmount;
		this.totalOrderAmountVAT = totalOrderAmountVAT;
		this.totalOrderAmountWithVAT = totalOrderAmountWithVAT;
	}


	public double getTotalOrderAmount() {
		return totalOrderAmount;
	}


	public void setTotalOrderAmount(double totalOrderAmount) {
		this.totalOrderAmount = totalOrderAmount;
	}


	public double getTotalOrderAmountVAT() {
		return totalOrderAmountVAT;
	}


	public void setTotalOrderAmountVAT(double totalOrderAmountVAT) {
		this.totalOrderAmountVAT = totalOrderAmountVAT;
	}


	public double getTotalOrderAmountWithVAT() {
		return totalOrderAmountWithVAT;
	}


	public void setTotalOrderAmountWithVAT(double totalOrderAmountWithVAT) {
		this.totalOrderAmountWithVAT = totalOrderAmountWithVAT;
	}


	
	
}
