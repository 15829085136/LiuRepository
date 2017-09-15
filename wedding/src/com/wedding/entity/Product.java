package com.wedding.entity;

import java.io.Serializable;

public class Product implements Serializable{
	private int productId;
	private String productName;
	private double productInPrice;
	private double productOutPrice;
	private int productStoreCount;
	private int productSellCount;
	private int productTypeId;
	
	
	public Product() {
	}
	
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getProductInPrice() {
		return productInPrice;
	}
	public void setProductInPrice(double productInPrice) {
		this.productInPrice = productInPrice;
	}
	public double getProductOutPrice() {
		return productOutPrice;
	}
	public void setProductOutPrice(double productOutPrice) {
		this.productOutPrice = productOutPrice;
	}
	public int getProductStoreCount() {
		return productStoreCount;
	}
	public void setProductStoreCount(int productStoreCount) {
		this.productStoreCount = productStoreCount;
	}
	public int getProductSellCount() {
		return productSellCount;
	}
	public void setProductSellCount(int productSellCount) {
		this.productSellCount = productSellCount;
	}
	public int getProductTypeId() {
		return productTypeId;
	}
	public void setProductTypeId(int productTypeId) {
		this.productTypeId = productTypeId;
	}

}
