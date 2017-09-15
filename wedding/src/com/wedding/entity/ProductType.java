package com.wedding.entity;

import java.io.Serializable;

public class ProductType implements Serializable{
	private int productTypeId;
	private String productTypeName;
	// Ù–‘ ˝
	private int productTypeCount;
	
	
	public ProductType() {
	}
	
	
	public int getProductTypeId() {
		return productTypeId;
	}
	public void setProductTypeId(int productTypeId) {
		this.productTypeId = productTypeId;
	}
	public String getProductTypeName() {
		return productTypeName;
	}
	public void setProductTypeName(String productTypeName) {
		this.productTypeName = productTypeName;
	}
	public int getProductTypeCount() {
		return productTypeCount;
	}
	public void setProductTypeCount(int productTypeCount) {
		this.productTypeCount = productTypeCount;
	}
	

}
