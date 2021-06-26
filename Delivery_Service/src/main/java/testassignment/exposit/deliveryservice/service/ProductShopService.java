package testassignment.exposit.deliveryservice.service;

import testassignment.exposit.deliveryservice.model.ProductShop;

public interface ProductShopService {
	
	ProductShop save(Integer shopId, Integer productId, Integer quantity, Boolean inStock);
	
	void delete(Integer productShopId);
	
	void SortByCategory (String filterCategory);
	
	void sortByCheapest();
	
	void sortByMostExpensive();
}
