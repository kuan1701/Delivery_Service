package testassignment.exposit.deliveryservice.service.impl;

import testassignment.exposit.deliveryservice.database.DatabaseServiceImpl;
import testassignment.exposit.deliveryservice.model.Order;
import testassignment.exposit.deliveryservice.model.ProductShop;
import testassignment.exposit.deliveryservice.model.enums.OrderStatus;
import testassignment.exposit.deliveryservice.service.OrderService;

import java.util.List;

public class OrderServiceImpl implements OrderService {
	
	DatabaseServiceImpl databaseService = new DatabaseServiceImpl();
	List<Order> orderList = databaseService.loadListOfOrder();
	List<ProductShop> productShopList = databaseService.loadListOfProductShop();
	
	@Override
	public Order createAndUpdate(String address, Integer status, Integer currentStatusOrder, Integer productShopId) {
		
		OrderStatus orderStatus;
		
		Order order = new Order();
		System.out.println("Enter the delivery address: ");
		order.setDeliveryAddress(address);
		
		System.out.println("Choose order status: ");
		switch (status) {
			case (0) : orderStatus = OrderStatus.PLACED; break;
			case (1) : orderStatus = OrderStatus.INBOUND; break;
			case (2) : orderStatus = OrderStatus.DELIVERED; break;
			case (3) : orderStatus = OrderStatus.CANCELED; break;
			case (4) : orderStatus = OrderStatus.REJECTED; break;
			default:
				throw new IllegalStateException("Unexpected value: " + status);
		}
		order.setOrderStatus(orderStatus);
		
		System.out.println(productShopList);
		System.out.println("Select products: ");
		System.out.println("To add a product enter 1, to place an order enter 0, if you want to change the order, enter 2");
		
		//create order
		if (currentStatusOrder == 1) {
			do {
				order.getProductShopList().add(productShopList.get(productShopId));
				System.out.println("Product " + productShopId + " added to order.");
			} while (currentStatusOrder == 1);
			
			//save order
		} else if (currentStatusOrder == 0) {
			orderList.add(order);
			System.out.println("Thank you, your order has been placed.");
			System.out.println(order);
			
			//change order
		} else if (currentStatusOrder == 2 && order.getProductShopList() != null) {
			order.setDeliveryAddress(address);
			order.setOrderStatus(orderStatus);
			order.getProductShopList().stream()
					.filter(product -> product.getProductShopId().equals(productShopId))
					.findFirst()
					.ifPresent(order.getProductShopList()::remove);
			System.out.println("Order successfully updated.");
			System.out.println(order);
		}
		return order;
	}
	
	@Override
	public void delete(Integer orderId) {
		
		orderList.stream()
				.filter(user -> user.getOrderId().equals(orderId))
				.findFirst()
				.ifPresent(orderList::remove);
		System.out.println("Order successfully deleted.");
	}
}
