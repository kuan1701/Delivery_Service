package testassignment.exposit.deliveryservice.Application;

import testassignment.exposit.deliveryservice.database.DatabaseServiceImpl;
import testassignment.exposit.deliveryservice.service.impl.*;

import java.util.Scanner;

public class DeliveryApp {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		UserServiceImpl userService = new UserServiceImpl();
		ShopServiceImpl shopService = new ShopServiceImpl();
		OrderServiceImpl orderService = new OrderServiceImpl();
		ProductServiceImpl productService = new ProductServiceImpl();
		DatabaseServiceImpl databaseService = new DatabaseServiceImpl();
		ProductShopServiceImpl productShopService = new ProductShopServiceImpl();
		
		System.out.println("Hi, this is a grocery delivery service.\n");
		System.out.println("If you want create a new account, enter 1.\n"
				+ "If you want to place an order, enter 2.\n"
				+ "If you want to change the data, enter 3.\n"
				+ "If you want to delete the data, enter 4.\n"
				+ "If you want to see the data, enter 5");
		
		Integer resultStart = scanner.nextInt();
		if (resultStart == 1) {
			
			System.out.println("If you want to create a new user, enter 1.\n"
					+ "If you want to create a new shop, enter 2.\n"
					+ "If you want to create a new product, enter 3.\n"
					+ "If you want to link a product to a store, enter 4.\n"
					+ "What operation do you want to perform?");
			
			Integer operationResult = scanner.nextInt();
			
			// creating user
			if (operationResult == 1) {
				
				System.out.println("Creating a new user.");
				System.out.print("Please enter your name: ");
				String name = scanner.nextLine();
				System.out.print("Please enter your surname: ");
				String surname = scanner.nextLine();
				System.out.print("Please enter your username: ");
				String username = scanner.nextLine();
				System.out.print("Please enter your email: ");
				String email = scanner.nextLine();
				System.out.print("Please enter your address: ");
				String address = scanner.nextLine();
				System.out.print("Please enter your password: ");
				String password = scanner.nextLine();
				userService.save(name, surname, username, email, address, password);
				
				// adding store to database
			} else if (operationResult == 2) {
				
				System.out.println("Adding a store.");
				System.out.print("Enter the name of the store: ");
				String name = scanner.nextLine();
				System.out.print("Enter the address of the store: ");
				String address = scanner.nextLine();
				System.out.print("Enter store markup: ");
				Double markup = scanner.nextDouble();
				shopService.save(name, address, markup);
				
				// adding to product to database
			} else if (operationResult == 3) {
				
				System.out.println("Adding a product.");
				System.out.print("Enter the product name: ");
				String name = scanner.nextLine();
				System.out.print("Enter the product price: ");
				Double price = scanner.nextDouble();
				System.out.print("Choose a category: \n"
						+ "Appliances\n"
						+ "Electronics\n"
						+ "Vegetables\n"
						+ "Fruits\n"
						+ "Beverages\n"
						+ "Milk products\n"
						+ "Meat products\n"
						+ "Grocery\n"
						+ "Sweets\n"
						+ "Frozen food\n"
						+ "Household\n"
						+ "Kids\n"
						+ "Sundries");
				scanner.nextLine();
				String productCategory = scanner.nextLine();
				productService.save(name, price, productCategory);
				
				// linking a product to a store
			} else if (operationResult == 4) {
				
				System.out.println("Adding a product to the store.");
				System.out.println("List of products.");
				System.out.println(databaseService.loadListOfProduct());
				System.out.println("List of shops.");
				System.out.println(databaseService.loadListOfShop());
				System.out.print("Enter store ID: ");
				Integer shopId = scanner.nextInt() - 1;
				System.out.print("Enter product ID: ");
				Integer productId = scanner.nextInt() - 1;
				System.out.print("Enter product quantity: ");
				Integer quantity = scanner.nextInt();
				productShopService.save(shopId, productId, quantity);
			}
			
			// creating order
		} else if (resultStart == 2) {
			
			System.out.println("Creating order.");
			System.out.println("List of products.");
			System.out.println(databaseService.loadListOfProductShop());
			System.out.print("Enter the delivery address: ");
			String address = scanner.nextLine();
			System.out.println("To add a product enter 1, if you want to sort product enter 2");
			
			Integer currentStatusOrder = scanner.nextInt();
			
			// creating order without product sorting
			if (currentStatusOrder == 1) {
				
				System.out.print("Enter product ID: ");
				Integer productId = scanner.nextInt() - 1;
				System.out.print("Enter quantity: ");
				Integer quantity = scanner.nextInt() - 1;
				orderService.create(address, productId, quantity);
				
				//to sort products when creating an order
			} else if (currentStatusOrder == 2) {
				
				System.out.println("Sort by category enter 1," +
						" by cheapest products enter 2," +
						" by most expensive products enter 3");
				int sort = scanner.nextInt();
				
				//sort product-shop by category
				if (sort == 1) {
					
					String category = scanner.nextLine();
					productShopService.sortByCategory(category);
					System.out.print("Enter product ID: ");
					Integer productId = scanner.nextInt() - 1;
					System.out.print("Enter quantity: ");
					Integer quantity = scanner.nextInt() - 1;
					orderService.create(address, productId, quantity);
					
					//sort product-shop by cheapest product
				} else if (sort == 2) {
					
					productShopService.sortByCheapest();
					System.out.print("Enter product ID: ");
					Integer productId = scanner.nextInt() - 1;
					System.out.print("Enter quantity: ");
					Integer quantity = scanner.nextInt() - 1;
					orderService.create(address, productId, quantity);
					
					//sort product-shop by most expensive
				} else if (sort == 3) {
					
					productShopService.sortByMostExpensive();
					System.out.print("Enter product ID: ");
					Integer productId = scanner.nextInt() - 1;
					System.out.print("Enter quantity: ");
					Integer quantity = scanner.nextInt() - 1;
					orderService.create(address, productId, quantity);
				}
			}
			//data change operations
		} else if (resultStart == 3) {
			
			System.out.println("If you want to change user data, enter 1.\n"
					+ "If you want to change shop data, enter 2.\n"
					+ "If you want to change product data, enter 3.");
			Integer changeResult = scanner.nextInt();
			
			//changing user data
			if (changeResult == 1) {
				
				System.out.println("Changing user data.");
				System.out.println(databaseService.loadListOfUser());
				System.out.print("Please enter the user ID you want to change: ");
				Integer userId = scanner.nextInt() - 1;
				scanner.nextLine();
				System.out.print("Please enter your new name: ");
				String name = scanner.nextLine();
				System.out.print("Please enter your new surname: ");
				String surname = scanner.nextLine();
				System.out.print("Please enter your new username: ");
				String username = scanner.nextLine();
				System.out.print("Please enter your new email: ");
				String email = scanner.nextLine();
				System.out.print("Please enter your new address: ");
				String address = scanner.nextLine();
				userService.update(userId, name, surname, username, email, address);
				
				//changing store data
			} else if (changeResult == 2) {
				
				System.out.println("Changing store data.");
				System.out.println(databaseService.loadListOfShop());
				System.out.print("Please enter the store ID you want to change: ");
				Integer shopId = scanner.nextInt() - 1;
				scanner.nextLine();
				System.out.print("Enter the new address of the store: ");
				String address = scanner.nextLine();
				System.out.print("Enter the new name of the store: ");
				String name = scanner.nextLine();
				shopService.update(shopId, name, address);
				
				//changing product data
			} else if (changeResult == 3) {
				
				System.out.println("Changing product data.");
				System.out.println(databaseService.loadListOfProduct());
				System.out.print("Please enter the product ID you want to change: ");
				Integer productId = scanner.nextInt() - 1;
				scanner.nextLine();
				System.out.print("Enter the new name of the product: ");
				String name = scanner.nextLine();
				System.out.print("Enter the new product price: ");
				Double price = scanner.nextDouble();
				productService.update(productId, name, price);
			}
			//deleting data
		} else if (resultStart == 4) {
			
			System.out.println("If you want to delete user data, enter 1.\n"
					+ "If you want to delete shop data, enter 2.\n"
					+ "If you want to delete product data, enter 3.\n"
					+ "If you want to delete product-shop data, enter 4.");
			
			Integer deleteResult = scanner.nextInt();
			
			//deleting user data
			if (deleteResult == 1) {
				
				System.out.println("Deleting user data.");
				System.out.println(databaseService.loadListOfUser());
				System.out.print("Please enter the user ID you want to delete: ");
				Integer userId = scanner.nextInt() - 1;
				userService.delete(userId);
				
				//deleting store data
			} else if (deleteResult == 2) {
				
				System.out.println("Deleting store data.");
				System.out.println(databaseService.loadListOfShop());
				System.out.print("Please enter the shop ID you want to delete: ");
				Integer shopId = scanner.nextInt() - 1;
				shopService.delete(shopId);
				
				//deleting product data
			} else if (deleteResult == 3) {
				
				System.out.println("Deleting product data.");
				System.out.println(databaseService.loadListOfShop());
				System.out.print("Please enter the product ID you want to delete: ");
				Integer productId = scanner.nextInt() - 1;
				productService.delete(productId);
				
				//deleting product-shop data
			} else if (deleteResult == 4) {
				
				System.out.println("Deleting product-shop data.");
				System.out.println(databaseService.loadListOfProductShop());
				System.out.print("Please enter the product-shop ID you want to delete: ");
				Integer productShopId = scanner.nextInt() - 1;
				productShopService.delete(productShopId);
			}
			// list the selected object
		} else if (resultStart == 5) {
			
			System.out.println("If you want to see the list of users, enter 1.\n"
					+ "If you want to see the list of shops, enter 2.\n"
					+ "If you want to see the list of products, enter 3.\n"
					+ "If you want to see the list of product-shops, enter 4.\n"
					+ "If you want to see the list of orders, enter 5");
			
			Integer seeResult = scanner.nextInt();
			
			// list of users
			if (seeResult == 1) {
				
				System.out.println("List of users.");
				System.out.println(databaseService.loadListOfUser());
				
				// list of stores
			} else if (seeResult == 2) {
				
				System.out.println("List of stores.");
				System.out.println(databaseService.loadListOfShop());
				
				// list of products
			} else if (seeResult == 3) {
				
				System.out.println("List of products.");
				System.out.println(databaseService.loadListOfProduct());
				
				// list of product-shops
			} else if (seeResult == 4) {
				
				System.out.println("List of product-shops.");
				System.out.println(databaseService.loadListOfProductShop());
				
				// list of orders
			} else if (seeResult == 5) {
				
				System.out.println("List of orders.");
				System.out.println(databaseService.loadListOfOrder());
			}
		}
		scanner.close();
	}
}
