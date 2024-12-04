package org.makermainds.jcoaching.resturantapp.model.product;

public class Product {
	
	private int productId;
	private String Name;
	private double Price;
	
	
    public Product(int productId, String name,Double price) {
		this.productId = productId;
		this.Name = name;
		this.Price = price;
		
		
	}


	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}


	public String getName() {
		return Name;
	}


	public void setName(String name) {
		Name = name;
	}


	public double getPrice() {
		return Price;
	}


	public void setPrice(double price) {
		Price = price;
	}
	
	
	
	
}
