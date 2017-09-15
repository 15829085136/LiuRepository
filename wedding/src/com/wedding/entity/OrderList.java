package com.wedding.entity;

public class OrderList {
	private int orderListId;
	//订单状态（待付款，待收货，售后）
	private String orderListState;
	//默认为NULL，表示客户未下单及未收货时，客户无法进行评价
	//收货后改变为FALSE，表示客户尚未评价
	//评价后改变为TRUE，表示客户已经评价
	private boolean orderListAssess;
	//下单时间
	private String orderListSetTime;
	//客户备注信息
	private String orderListInfo;
	private int userId;
	private int addressId;
	private int discountId;
	
	
	public OrderList() {
	}
	
	
	public int getOrderListId() {
		return orderListId;
	}
	public void setOrderListId(int orderListId) {
		this.orderListId = orderListId;
	}
	public String getOrderListState() {
		return orderListState;
	}
	public void setOrderListState(String orderListState) {
		this.orderListState = orderListState;
	}
	public boolean isOrderListAssess() {
		return orderListAssess;
	}
	public void setOrderListAssess(boolean orderListAssess) {
		this.orderListAssess = orderListAssess;
	}
	public String getOrderListSetTime() {
		return orderListSetTime;
	}
	public void setOrderListSetTime(String orderListSetTime) {
		this.orderListSetTime = orderListSetTime;
	}
	public String getOrderListInfo() {
		return orderListInfo;
	}
	public void setOrderListInfo(String orderListInfo) {
		this.orderListInfo = orderListInfo;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public int getDiscountId() {
		return discountId;
	}
	public void setDiscountId(int discountId) {
		this.discountId = discountId;
	}
	
	

}
