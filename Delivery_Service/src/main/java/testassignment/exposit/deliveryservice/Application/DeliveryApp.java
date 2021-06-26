package testassignment.exposit.deliveryservice.Application;

import testassignment.exposit.deliveryservice.database.DatabaseServiceImpl;
import testassignment.exposit.deliveryservice.service.impl.*;

import java.util.Scanner;

public class DeliveryApp {
	
	public static void main(String[] args){
		
		Scanner scanner = new Scanner(System.in);
		UserServiceImpl userService = new UserServiceImpl();
		ShopServiceImpl shopService = new ShopServiceImpl();
		OrderServiceImpl orderService = new OrderServiceImpl();
		ProductServiceImpl productService = new ProductServiceImpl();
		DatabaseServiceImpl databaseService = new DatabaseServiceImpl();
		ProductShopServiceImpl productShopService = new ProductShopServiceImpl();
		
		System.out.println("Hi, this is a grocery delivery service.\n"
				+ "If you want create a new account, press 1.\n"
				+ "If you want to place an order, press 2");
		
		int resultStart = scanner.nextInt();
		
		if (resultStart == 1) {
			System.out.println("If you want to create a new user, press 1.\n"
					+ "If you want to create a new shop, press 2.\n"
					+ "If you want to create a new product, press 3.\n"
					+ "If you want to link a product to a store, press 4.\n"
					+ "What operation do you want to perform?");
			
			int startResult = scanner.nextInt();
			
			if (startResult == 1) {
				
				System.out.println("Creating a new user.");
				scanner.nextLine();
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
			}
			else if (startResult == 2) {
				
				System.out.println("Adding a store.");
				scanner.nextLine();
				System.out.print("Enter the name of the store: ");
				String name = scanner.nextLine();
				System.out.print("Enter the address of the store: ");
				String address = scanner.nextLine();
				System.out.print("Enter store markup: ");
				Double markup = scanner.nextDouble();
				shopService.save(name, address, markup);
			}
			else if (startResult == 3) {
				
				System.out.print("Adding a product.");
				scanner.nextLine();
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
						+ "Sundries\n");
				scanner.nextLine();
				String productCategory = scanner.nextLine();
				productService.save(name, price, productCategory);
			}
			else if (startResult == 4) {
				
				System.out.println("Adding a product to the store.");
				
				System.out.println("List of products.");
				System.out.println(databaseService.loadListOfProduct());
				System.out.println("List of shops.");
				System.out.println(databaseService.loadListOfShop());
				
				scanner.nextLine();
				System.out.print("Enter store ID: ");
				Integer shopId = scanner.nextInt() - 1;
				System.out.print("Enter product ID: ");
				Integer productId = scanner.nextInt() - 1;
				System.out.print("Enter product quantity: ");
				Integer quantity = scanner.nextInt();
				productShopService.save(shopId, productId, quantity);
			}
		}
		if (resultStart == 2) {
			
			System.out.println("Creating order.");
			System.out.println("List of products.");
			System.out.println(databaseService.loadListOfProductShop());
			scanner.nextLine();
			System.out.println("Enter the delivery address: ");
			String address = scanner.nextLine();
			System.out.println("To add a product enter 1, if you want to sort product enter 2");
			int currentStatusOrder = scanner.nextInt();
			
			if (currentStatusOrder == 1) {
				
				System.out.print("Enter product ID: ");
				Integer productId = scanner.nextInt() - 1;
				System.out.print("Enter quantity: ");
				Integer quantity = scanner.nextInt() - 1;
				orderService.create(address, productId, quantity);
				
			}
			else if (currentStatusOrder == 2) {
				
				System.out.println("Sort by category enter 1," +
						" by cheapest products enter 2," +
						" by most expensive products enter 3");
				
				int sort = scanner.nextInt();
				if (sort == 1) {
					String category = scanner.nextLine();
					productShopService.sortByCategory(category);
					System.out.print("Enter product ID: ");
					Integer productId = scanner.nextInt() - 1;
					System.out.print("Enter quantity: ");
					Integer quantity = scanner.nextInt() - 1;
					orderService.create(address, productId, quantity);
				}
				else if (sort == 2) {
					productShopService.sortByCheapest();
					System.out.print("Enter product ID: ");
					Integer productId = scanner.nextInt() - 1;
					System.out.print("Enter quantity: ");
					Integer quantity = scanner.nextInt() - 1;
					orderService.create(address, productId, quantity);
				}
				else if (sort == 3) {
					productShopService.sortByMostExpensive();
					
					System.out.print("Enter product ID: ");
					Integer productId = scanner.nextInt() - 1;
					System.out.print("Enter quantity: ");
					Integer quantity = scanner.nextInt() - 1;
					orderService.create(address, productId, quantity);
				}
			}
		}
	}
}
