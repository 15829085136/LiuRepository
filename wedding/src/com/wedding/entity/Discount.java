package com.wedding.entity;

import java.io.Serializable;

public class Discount implements Serializable{
	private int discountId;
	private String discountName;
	private double  discountPrice;
	//上线时间
	private String discountOnlineTime;
	//有效期上限时间
	private String discountUpLimitTime;
	//有效期下限时间
	private String discountDownLimitTime;
	private int discountCount;
	private int productId;
	//优惠券最低可使用价格
	private double discountMinPrice;
	
	
	public Discount() {
	}
	
	
	public int getDiscountId() {
		return discountId;
	}
	public void setDiscountId(int discountId) {
		this.discountId = discountId;
	}
	public String getDiscountName() {
		return discountName;
	}
	public void setDiscountName(String discountName) {
		this.discountName = discountName;
	}
	public double getDiscountPrice() {
		return discountPrice;
	}
	public void setDiscountPrice(double discountPrice) {
		this.discountPrice = discountPrice;
	}
	public String getDiscountOnlineTime() {
		return discountOnlineTime;
	}
	public void setDiscountOnlineTime(String discountOnlineTime) {
		this.discountOnlineTime = discountOnlineTime;
	}
	public String getDiscountUpLimitTime() {
		return discountUpLimitTime;
	}
	public void setDiscountUpLimitTime(String discountUpLimitTime) {
		this.discountUpLimitTime = discountUpLimitTime;
	}
	public String getDiscountDownLimitTime() {
		return discountDownLimitTime;
	}
	public void setDiscountDownLimitTime(String discountDownLimitTime) {
		this.discountDownLimitTime = discountDownLimitTime;
	}
	public int getDiscountCount() {
		return discountCount;
	}
	public void setDiscountCount(int discountCount) {
		this.discountCount = discountCount;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public double getDiscountMinPrice() {
		return discountMinPrice;
	}
	public void setDiscountMinPrice(double discountMinPrice) {
		this.discountMinPrice = discountMinPrice;
	}
	
	

}
