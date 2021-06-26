package testassignment.exposit.deliveryservice.model;

import java.util.Date;
import java.util.Objects;

public class Order {

	private Integer orderId;
	private String deliveryAddress;
	private Double totalPrice;
	private String date;
	private Integer quantity;
	private ProductShop productShop;
	
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
				date.equals(order.date);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(orderId,deliveryAddress, totalPrice, date);
	}
	
	@Override
	public String toString() {
		return "Order: " + orderId + ".\n" +
				"Delivery address: " + deliveryAddress + ".\n" +
				"Product: " + productShop + ".\n" +
				"Total price: " + totalPrice + ".\n" +
				"Date: " + date + ".\n";
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
		
		return productShop.getPrice() * quantity;
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
	
	public ProductShop getProductShop() {
		return productShop;
	}
	
	public void setProductShop(ProductShop productShopList) {
		this.productShop = productShopList;
	}
	
	public Integer getQuantity() {
		return quantity;
	}
	
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
}
