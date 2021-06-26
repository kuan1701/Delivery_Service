package testassignment.exposit.deliveryservice.model;

import testassignment.exposit.deliveryservice.model.enums.OrderStatus;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Order {

	private Integer orderId;
	private String deliveryAddress;
	private Double totalPrice;
	private String date;
	private OrderStatus orderStatus;
	
	private List<ProductShop> productShopListInOrder;
	
	private static Integer count = 0;
	
	public Order() {
		count++;
		this.orderId = count;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Order)) return false;
		Order order = (Order) o;
		return orderId.equals(order.orderId) &&
				deliveryAddress.equals(order.deliveryAddress) &&
				totalPrice.equals(order.totalPrice) &&
				date.equals(order.date) &&
				orderStatus.equals(order.orderStatus);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(orderId,deliveryAddress, totalPrice, date, orderStatus);
	}
	
	@Override
	public String toString() {
		return "Order: " + orderId + ".\n" +
				"Delivery address: " + deliveryAddress + ".\n" +
				"Products list: " + productShopListInOrder + ".\n" +
				"Total price: " + getTotalPrice() + ".\n" +
				"Date: " + date + ".\n" +
				"Order status: " + orderStatus.getStatus() + ".\n";
	}
	
	public Integer getOrderId() {
		return orderId;
	}
	
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	
	public String getDeliveryAddress() {
		return deliveryAddress;
	}
	
	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}
	
	public Double getTotalPrice() {
		
		for (ProductShop productShop : productShopListInOrder) {
			totalPrice += productShop.getPrice();
		}
		return totalPrice;
	}
	
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public String getDate() {
		
		return (new Date()).toString();
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public OrderStatus getOrderStatus() {
		return orderStatus;
	}
	
	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}
	
	public List<ProductShop> getProductShopList() {
		return productShopListInOrder;
	}
	
	public void setProductShopList(List<ProductShop> productShopList) {
		this.productShopListInOrder = productShopList;
	}
}
