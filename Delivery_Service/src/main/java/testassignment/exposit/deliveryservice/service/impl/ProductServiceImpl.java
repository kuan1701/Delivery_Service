package testassignment.exposit.deliveryservice.service.impl;

import testassignment.exposit.deliveryservice.database.DatabaseServiceImpl;
import testassignment.exposit.deliveryservice.model.Product;
import testassignment.exposit.deliveryservice.model.enums.ProductCategories;
import testassignment.exposit.deliveryservice.service.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {
	
	DatabaseServiceImpl databaseService = new DatabaseServiceImpl();
	List<Product> productList = databaseService.loadListOfProduct();
	
	@Override
	public Product save(String name, Double price, String category) {
		
		ProductCategories productCategories;
		
		Product product = new Product();
		product.setName(name);
		product.setPrice(price);
		
		//entering the product category
		for (ProductCategories elem : ProductCategories.values()) {
			if (elem.name().equalsIgnoreCase(category)) {
				product.setProductCategories(ProductCategories.valueOf(category.toUpperCase()));
			}
			//else product.setProductCategories(ProductCategories.SUNDRIES);
			productList.add(product);
			databaseService.saveProductList(productList);
		}
		System.out.println("Product successfully created.");
		return product;
	}
	
	
	@Override
	public void delete(Integer productId) {
		
		productList.stream()
				.filter(user -> user.getProductId().equals(productId))
				.findFirst()
				.ifPresent(productList :: remove);
		System.out.println("Product successfully deleted.");
	}
	
	@Override
	public Product update(Integer productId, String name, Double price) {
		
		Product product = productList.get(productId);
		if (product != null) {
			System.out.println("Enter the new product name: ");
			product.setName(name);
			System.out.println("Enter the new product price: ");
			product.setPrice(price);
			System.out.println("Data updated!");
			System.out.println(product);
		} else {
			System.out.println("This product does not exist");
		}
		databaseService.saveProductList(productList);
		return product;
	}
}
