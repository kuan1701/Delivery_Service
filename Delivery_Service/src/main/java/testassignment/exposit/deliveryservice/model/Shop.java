package testassignment.exposit.deliveryservice.model;

import java.util.Objects;

public class Shop {
	
	private Integer shopId;
	private String name;
	private String address;
	private Double markup;
	
	private static Integer count = 0;
	
	public Shop() {
		count++;
		this.shopId = count;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Shop)) return false;
		Shop shop = (Shop) o;
		return shopId.equals(shop.shopId) &&
				name.equals(shop.name) &&
				address.equals(shop.address);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(shopId, name, address);
	}
	
	@Override
	public String toString() {
		return "Shop: " + shopId + ".\n" +
				"Shop: " + name + ".\n" +
				"Address: " + address + ".\n" +
				"Markup: " + markup + ".\n";
	}
	
	public Integer getShopId() {
		return shopId;
	}
	
	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public Double getMarkup() {
		return markup;
	}
	
	public void setMarkup(Double markup) {
		this.markup = markup;
	}
}
