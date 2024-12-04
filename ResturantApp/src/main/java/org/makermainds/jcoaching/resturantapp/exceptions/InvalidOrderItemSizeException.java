package org.makermainds.jcoaching.resturantapp.exceptions;


@SuppressWarnings("serial")
public class InvalidOrderItemSizeException extends RuntimeException {

	public InvalidOrderItemSizeException(String  message) {
		super(message);
		
	}
}
