package testassignment.exposit.deliveryservice.service;

import testassignment.exposit.deliveryservice.model.Order;

public interface OrderService {
	
	Order createAndUpdate(String address, Integer orderStatus, Integer currentStatusOrder, Integer productShopId);
	
	void delete(Integer orderId);
}
