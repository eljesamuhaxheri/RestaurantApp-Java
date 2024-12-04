package org.makermainds.jcoaching.resturantapp.model.product;

public class Drink extends Product{
	private boolean sugerFree;
	
	public Drink(int id, String name, double price) {
		super(id, name, price);
		
	}
	public Drink(int id ,String name, double price, boolean sugerFree) {
		this(id,name,price);
		this.sugerFree = sugerFree;
	}
	
	public boolean isSugerFree() {
		return sugerFree;
	}
	public void setSugerFree(boolean sugerFree) {
		this.sugerFree = sugerFree;
	}
	

}
