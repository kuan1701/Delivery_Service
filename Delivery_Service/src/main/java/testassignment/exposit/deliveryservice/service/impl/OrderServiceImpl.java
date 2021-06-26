package testassignment.exposit.deliveryservice.service.impl;

import testassignment.exposit.deliveryservice.database.DatabaseServiceImpl;
import testassignment.exposit.deliveryservice.exception.ObjectNotFoundException;
import testassignment.exposit.deliveryservice.model.Order;
import testassignment.exposit.deliveryservice.model.ProductShop;
import testassignment.exposit.deliveryservice.model.enums.OrderStatus;
import testassignment.exposit.deliveryservice.service.OrderService;

import java.util.List;

public class OrderServiceImpl implements OrderService {
	
	DatabaseServiceImpl databaseService = new DatabaseServiceImpl();
	List<Order> orderList = databaseService.loadListOfOrder();
	
	@Override
	public Order create(String address, Integer productShopId, Integer quantity) {
		
		Order order = new Order();
		
		try {
			order.setProductShop(databaseService.findProductShopById(productShopId));
			order.setQuantity(quantity);
			orderList.add(order);
			databaseService.saveOrderList(orderList);
			System.out.println("Your order has been completed.");
		} catch (ObjectNotFoundException e) {
			System.err.println(e);
		}
		return order;
	}
	
	@Override
	public void delete(Integer orderId) {
		
		orderList.stream()
				.filter(user -> user.getOrderId().equals(orderId))
				.findFirst()
				.ifPresent(orderList::remove);
		databaseService.saveOrderList(orderList);
		System.out.println("Order successfully deleted.");
	}
}
