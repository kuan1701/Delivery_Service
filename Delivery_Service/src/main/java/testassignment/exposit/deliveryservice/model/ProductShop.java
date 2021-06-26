package testassignment.exposit.deliveryservice.model;

import java.util.Objects;

public class ProductShop implements Comparable<ProductShop> {
	
	private Integer productShopId;
	private Shop shop;
	private Product product;
	private Double price;
	private Integer quantity;
	private Boolean inStock;
	
	private static Integer count = 0;
	
	public ProductShop() {
		count++;
		this.productShopId = count;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof ProductShop)) return false;
		ProductShop that = (ProductShop) o;
		return getProductShopId().equals(that.getProductShopId()) &&
				getShop().equals(that.getShop()) &&
				getProduct().equals(that.getProduct());
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(getProductShopId(), getShop(), getProduct());
	}
	
	@Override
	public String toString() {
		return "ProductShop: " + productShopId + ".\n" +
				"Shop: " + shop.getName() + ".\n" +
				"Product: " + product.getName() + ".\n" +
				"Price: " + price + ".\n" +
				"In stock: " + getInStock() + ".";
	}
	
	public Integer getProductShopId() {
		return productShopId;
	}
	
	public void setProductShopId(Integer productShopId) {
		this.productShopId = productShopId;
	}
	
	public Shop getShop() {
		return shop;
	}
	
	public void setShop(Shop shop) {
		this.shop = shop;
	}
	
	public Product getProduct() {
		return product;
	}
	
	public void setProduct(Product product) {
		this.product = product;
	}
	
	public Double getPrice() {
		return price;
	}
	
	public void setPrice(Double price) {
		this.price = price;
	}
	
	public Boolean getInStock() {
		return inStock;
	}
	
	public void setInStock(Boolean inStock) {
		this.inStock = inStock;
	}
	
	public Integer getQuantity() {
		return quantity;
	}
	
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public int compareTo(ProductShop obj) {
		
		return Double.compare(this.price, obj.price);
	}
}
