package testassignment.exposit.deliveryservice.database;

import com.google.gson.reflect.TypeToken;
import testassignment.exposit.deliveryservice.exception.ObjectNotFoundException;
import testassignment.exposit.deliveryservice.model.*;
import testassignment.exposit.deliveryservice.util.parser.JsonParserClass;

import java.util.LinkedList;
import java.util.List;

public class DatabaseServiceImpl implements DataBaseService{
	
	public static final String JSON_SHOP = "shop.json";
	public static final String JSON_USER = "user.json";
	public static final String JSON_ORDER = "order.json";
	public static final String JSON_PRODUCT = "product.json";
	public static final String JSON_PRODUCTSHOP = "productShop.json";
	
	@Override
	public void saveListOfUser(List<User> userList) {
		JsonParserClass.parseToJson(JSON_USER, userList);
	}
	
	@Override
	public List<User> loadListOfUser() {
		
		return (List<User>) JsonParserClass
				.parseFromJson(JSON_USER, new TypeToken<LinkedList<User>>(){}
				.getType());
	}
	
	@Override
	public void saveProductList(List<Product> productList) {
		JsonParserClass.parseToJson(JSON_PRODUCT, productList);
	}
	
	@Override
	public List<Product> loadListOfProduct() {
		
		return (List<Product>) JsonParserClass
				.parseFromJson(JSON_PRODUCT, new TypeToken<LinkedList<Product>>(){}
				.getType());
	}
	
	@Override
	public void saveListOfShop(List<Shop> shopList) {
		JsonParserClass.parseToJson(JSON_SHOP, shopList);
	}
	
	@Override
	public List<Shop> loadListOfShop() {
		
		return (List<Shop>) JsonParserClass
				.parseFromJson(JSON_SHOP, new TypeToken<LinkedList<Shop>>(){}
				.getType());
	}
	
	@Override
	public void saveProductShopList(List<ProductShop> productShopList) {
		JsonParserClass.parseToJson(JSON_PRODUCTSHOP, productShopList);
	}
	
	@Override
	public List<ProductShop> loadListOfProductShop() {
		
		return (List<ProductShop>) JsonParserClass
				.parseFromJson(JSON_PRODUCTSHOP, new TypeToken<LinkedList<ProductShop>>(){}
				.getType());
	}
	
	@Override
	public void saveOrderList(List<Order> orderList) {
		JsonParserClass.parseToJson(JSON_ORDER, orderList);
	}
	
	@Override
	public List<Order> loadListOfOrder() {
		
		return (List<Order>) JsonParserClass
				.parseFromJson(JSON_ORDER, new TypeToken<LinkedList<Order>>(){}
						.getType());
	}
	
	@Override
	public User findUserById(Integer userId) throws ObjectNotFoundException {
		
		User user = loadListOfUser().get(userId);
		
		if (user == null) {
			throw new ObjectNotFoundException("This user isn't in the database.");
		}
		return user;
	}
	
	@Override
	public Shop findShopById(Integer shopId) throws ObjectNotFoundException {
		
		Shop shop = loadListOfShop().get(shopId);
		
		if (shop == null) {
			throw new ObjectNotFoundException("This shop isn't in the database.");
		}
		return shop;
	}
	
	@Override
	public Product findProductById(Integer productId) throws ObjectNotFoundException {
		
		Product product = loadListOfProduct().get(productId);
		
		if (product == null) {
			throw new ObjectNotFoundException("This product isn't in the database.");
		}
		return product;
	}
	
	@Override
	public ProductShop findProductShopById(Integer productShopId) throws ObjectNotFoundException {
		
		ProductShop productShop = loadListOfProductShop().get(productShopId);
		
		if (productShop == null) {
			throw new ObjectNotFoundException("This ProductShop object isn't in the database.");
		}
		return productShop;
	}
	
	@Override
	public void findProductShopByProductName(String productName) {
		
		List<ProductShop> productShopList = loadListOfProductShop();
		
		productShopList.stream()
				.filter(productShop -> productShop.getProduct().getName().equalsIgnoreCase(productName))
				.forEach(System.out::println);
	}
	
	@Override
	public Order findOrderById(Integer orderId) throws ObjectNotFoundException {
		
		Order order = loadListOfOrder().get(orderId);
		
		if (order == null) {
			throw new ObjectNotFoundException("This order isn't in the database.");
		}
		return order;
	}
	
	@Override
	public void findProductShopByProductNameAndShopName(String productName, String shopName) {
	
		List<ProductShop> productShopList = loadListOfProductShop();
		
		productShopList.stream()
				.filter(productShop -> productShop.getProduct().getName().equalsIgnoreCase(productName)
						&& productShop.getShop().getName().equalsIgnoreCase(shopName))
				.forEach(System.out::println);
	}
}
