package testassignment.exposit.deliveryservice.service;

import testassignment.exposit.deliveryservice.model.Order;

public interface OrderService {
	
	Order create(String address, Integer productShopId, Integer quantity);
}
