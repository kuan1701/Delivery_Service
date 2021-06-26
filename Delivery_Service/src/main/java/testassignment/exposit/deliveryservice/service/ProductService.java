package testassignment.exposit.deliveryservice.service;

import testassignment.exposit.deliveryservice.model.Product;

public interface ProductService {
	
	Product save(String name, Double price, String category);
	
	void delete(Integer productId);
	
	Product update(Integer productId, String name, Double price);
}
