package testassignment.exposit.deliveryservice.service.impl;

import testassignment.exposit.deliveryservice.database.DatabaseServiceImpl;
import testassignment.exposit.deliveryservice.exception.ObjectNotFoundException;
import testassignment.exposit.deliveryservice.model.ProductShop;
import testassignment.exposit.deliveryservice.model.enums.ProductCategories;
import testassignment.exposit.deliveryservice.service.ProductShopService;
import testassignment.exposit.deliveryservice.util.comparator.MostExpensivePriceComparator;

import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class ProductShopServiceImpl implements ProductShopService {
	
	DatabaseServiceImpl databaseService = new DatabaseServiceImpl();
	List<ProductShop> productShopList = databaseService.loadListOfProductShop();
	
	
	@Override
	public ProductShop save(Integer shopId, Integer productId, Integer quantity) {
		
		ProductShop productShop = new ProductShop();
		try {
			// finding store by store ID
			productShop.setShop(databaseService.findShopById(shopId));
		} catch (ObjectNotFoundException e) {
			System.err.println(e);
		}
		try {
			// finding product by product ID
			productShop.setProduct(databaseService.findProductById(productId));
		} catch (ObjectNotFoundException e) {
			System.err.println(e);
		}
		try {
			productShop.setPrice((
					databaseService.findProductById(productId).getPrice()
							* databaseService.findShopById(shopId).getMarkup()));
		} catch (ObjectNotFoundException e) {
			System.err.println(e);
		}
		productShop.setQuantity(quantity);
		productShop.setInStock(true);
		productShopList.add(productShop);
		databaseService.saveProductShopList(productShopList);
		System.out.println("Product successfully added to database.");
		return productShop;
	}
	
	@Override
	public void delete(Integer productShopId) {
		
		try {
			databaseService.findProductById(productShopId);
			productShopList.stream()
					.filter(user -> user.getProductShopId().equals(productShopId))
					.findFirst()
					.ifPresent(productShopList :: remove);
			databaseService.saveProductShopList(productShopList);
			System.out.println("Product successfully deleted.");
		} catch (ObjectNotFoundException e) {
			System.err.println(e);
		}
	}
	
	@Override
	public void sortByCategory(String filterCategory) {
		
		for (ProductCategories productCategories : ProductCategories.values()
		) {
			if (productCategories.name().equalsIgnoreCase(filterCategory)) {
				productShopList.stream()
						.filter(productShop -> productShop.getProduct().getProductCategories()
								.equals(ProductCategories.valueOf(filterCategory.toUpperCase(Locale.ROOT))))
						.forEach(System.out :: println);
			}
		}
	}
	
	@Override
	public void sortByCheapest() {
		
		Collections.sort(productShopList);
		productShopList.forEach(System.out :: println);
	}
	
	@Override
	public void sortByMostExpensive() {
		
		MostExpensivePriceComparator mostExpensivePriceComparator = new MostExpensivePriceComparator();
		productShopList.sort(mostExpensivePriceComparator);
		productShopList.forEach(System.out :: println);
	}
}
