package testassignment.exposit.deliveryservice.database;

import testassignment.exposit.deliveryservice.exception.ObjectNotFoundException;
import testassignment.exposit.deliveryservice.model.*;

import java.io.FileNotFoundException;
import java.util.List;

public interface DataBaseService {
	
	void saveListOfUser(List <User> userList) throws FileNotFoundException;
	
	List <User> loadListOfUser();
	
	void saveProductList (List <Product> productList);
	
	List<Product> loadListOfProduct();
	
	void saveListOfShop(List<Shop> shopList);
	
	List<Shop> loadListOfShop();
	
	void saveShopProductList (List <ProductShop> productList);
	
	List<ProductShop> loadListOfProductShop();
	
	void saveOrderList (List <Order> orderList);
	
	List<Order> loadListOfOrder();

	User findUserById(Integer id) throws ObjectNotFoundException;
	
	Shop findShopById(Integer id) throws ObjectNotFoundException;
	
	Product findProductById(Integer id) throws ObjectNotFoundException;

	ProductShop findProductShopById(Integer id) throws ObjectNotFoundException;
	
	void findProductShopByProductName(String name);

	Order findOrderById(Integer id) throws ObjectNotFoundException;
	
	void findProductShopByProductNameAndShopName (String productName, String shopName);
}
