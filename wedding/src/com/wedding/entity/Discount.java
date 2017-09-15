package com.wedding.entity;

import java.io.Serializable;

public class Discount implements Serializable{
	private int discountId;
	private String discountName;
	private double  discountPrice;
	//����ʱ��
	private String discountOnlineTime;
	//��Ч������ʱ��
	private String discountUpLimitTime;
	//��Ч������ʱ��
	private String discountDownLimitTime;
	private int discountCount;
	private int productId;
	//�Ż�ȯ��Ϳ�ʹ�ü۸�
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
