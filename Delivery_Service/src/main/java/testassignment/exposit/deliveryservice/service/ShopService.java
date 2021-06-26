package testassignment.exposit.deliveryservice.service;

import testassignment.exposit.deliveryservice.model.Shop;

public interface ShopService {
	
	Shop save(String name, String address, Double markup);
	
	void delete(Integer shopId);
	
	Shop update(Integer shopId, String name, String address);
}
