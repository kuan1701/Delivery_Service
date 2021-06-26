package testassignment.exposit.deliveryservice.service.impl;

import testassignment.exposit.deliveryservice.database.DatabaseServiceImpl;
import testassignment.exposit.deliveryservice.model.Shop;
import testassignment.exposit.deliveryservice.service.ShopService;

import java.util.List;

public class ShopServiceImpl implements ShopService {
	
	DatabaseServiceImpl databaseService = new DatabaseServiceImpl();
	List<Shop> shopList = databaseService.loadListOfShop();
	
	@Override
	public Shop save(String name, String address, Double markup) {
		
		Shop shop = new Shop();
		shop.setName(name);
		shop.setAddress(address);
		shop.setMarkup(markup);
		
		boolean userExists = shopList.stream()
				.anyMatch(shopDB -> shopDB.getName().equals(shop.getName())
				&& shopDB.getAddress().equals(shop.getAddress()));
		if (!userExists) {
			shopList.add(shop);
			databaseService.saveListOfShop(shopList);
			System.out.println("The store has been successfully added to the database.");
		}
		else System.out.println("This store is already in the database.");
		return shop;
	}
	
	@Override
	public void delete(Integer shopId) {
		
		shopList.stream()
				.filter(user -> user.getShopId().equals(shopId))
				.findFirst()
				.ifPresent(shopList::remove);
		System.out.println("Store successfully deleted.");
	}
	
	@Override
	public Shop update(Integer shopId, String name, String address) {
		
		Shop shop = shopList.get(shopId);
		
		if(shop != null) {
			System.out.println("Enter the new address of the store: ");
			shop.setAddress(address);
			System.out.println("Enter the new name of the store: ");
			shop.setName(name);
			System.out.println("Store data updated!");
			System.out.println(shop);
		} else {
			System.out.println("This shop does not exist");
		}
		databaseService.saveListOfShop(shopList);
		return shop;
	}
}
