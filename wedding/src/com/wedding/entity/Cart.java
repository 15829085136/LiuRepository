package com.wedding.entity;

import java.io.Serializable;

public class Cart implements Serializable{
	private int cartId;
	private int userId;
	
	
	public Cart() {
	}
	
	
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	

}
