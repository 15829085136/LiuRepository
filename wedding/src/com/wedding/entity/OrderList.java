package com.wedding.entity;

public class OrderList {
	private int orderListId;
	//����״̬����������ջ����ۺ�
	private String orderListState;
	//Ĭ��ΪNULL����ʾ�ͻ�δ�µ���δ�ջ�ʱ���ͻ��޷���������
	//�ջ���ı�ΪFALSE����ʾ�ͻ���δ����
	//���ۺ�ı�ΪTRUE����ʾ�ͻ��Ѿ�����
	private boolean orderListAssess;
	//�µ�ʱ��
	private String orderListSetTime;
	//�ͻ���ע��Ϣ
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
