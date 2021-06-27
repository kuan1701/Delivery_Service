package testassignment.exposit.deliveryservice.service.impl;

import testassignment.exposit.deliveryservice.database.DatabaseServiceImpl;
import testassignment.exposit.deliveryservice.model.User;
import testassignment.exposit.deliveryservice.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
	
	DatabaseServiceImpl databaseService = new DatabaseServiceImpl();
	List<User> usersList = databaseService.loadListOfUser();
	
	@Override
	public User save(String name, String surname, String username, String email, String password,  String deliveryAddress) {
		
		User user = new User();
		user.setName(name);
		user.setSurname(surname);
		user.setUsername(username);
		user.setEmail(email);
		user.setDeliveryAddress(deliveryAddress);
		user.setPassword(password);
		boolean userExists = usersList.stream()
				.anyMatch(userDB -> userDB.getUsername().equals(user.getUsername()));
		if (!userExists) {
			usersList.add(user);
			databaseService.saveListOfUser(usersList);
			System.out.println("Thank you, your account has been created.");
		} else System.out.println("This user is already in the database.");
		return user;
	}
	
	@Override
	public void delete(Integer userId) {
		
		usersList.stream()
				.filter(user -> user.getUserId().equals(userId))
				.findFirst()
				.ifPresent(usersList::remove);
		databaseService.saveListOfUser(usersList);
		System.out.println("User successfully deleted.");
	}
	
	@Override
	public User update(Integer userId, String name, String surname, String username, String email, String address) {
		
		User user = usersList.get(userId);
		
		if (user != null) {
			user.setName(name);
			user.setSurname(surname);
			user.setUsername(username);
			user.setEmail(email);
			user.setDeliveryAddress(address);
			System.out.println("Your data has been updated");
			System.out.println(user);
		} else {
			System.out.println("This user does not exist!");
		}
		databaseService.saveListOfUser(usersList);
		return user;
	}
}
