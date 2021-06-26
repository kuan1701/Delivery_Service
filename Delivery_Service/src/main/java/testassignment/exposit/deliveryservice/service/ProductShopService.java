package testassignment.exposit.deliveryservice.service;

import testassignment.exposit.deliveryservice.model.ProductShop;

public interface ProductShopService {
	
	ProductShop save(Integer shopId, Integer productId, Integer quantity);
	
	void delete(Integer productShopId);
	
	void sortByCategory (String filterCategory);
	
	void sortByCheapest();
	
	void sortByMostExpensive();
}
