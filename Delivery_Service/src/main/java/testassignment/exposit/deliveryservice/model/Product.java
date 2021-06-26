package testassignment.exposit.deliveryservice.model;

import testassignment.exposit.deliveryservice.model.enums.ProductCategories;

import java.util.List;
import java.util.Objects;

public class Product {
	
	private Integer productId;
	private String name;
	private Double price;
	private ProductCategories productCategories;
	
	private static Integer count = 0;
	
	public Product() {
		count++;
		this.productId = count;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Product)) return false;
		Product product = (Product) o;
		return Objects.equals(getProductId(), product.getProductId()) &&
				Objects.equals(getName(), product.getName()) &&
				Objects.equals(getPrice(), product.getPrice()) &&
				Objects.equals(productCategories, product.productCategories);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(getProductId(), getName(), getPrice(), productCategories);
	}
	
	@Override
	public String toString() {
		return "Product: " + productId + ".\n" +
				"Name: " + name + ".\n" +
				"Price: " + price + ".\n" +
				"Categories: " + productCategories + ".\n";
	}
	
	public Integer getProductId() {
		return productId;
	}
	
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Double getPrice() {
		return price;
	}
	
	public void setPrice(Double price) {
		this.price = price;
	}
	
	public ProductCategories getProductCategories() {
		return productCategories;
	}
	
	public void setProductCategories(ProductCategories productCategories) {
		this.productCategories = productCategories;
	}
}
