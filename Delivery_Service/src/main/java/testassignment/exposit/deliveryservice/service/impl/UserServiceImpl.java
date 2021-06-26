package testassignment.exposit.deliveryservice.service.impl;

import testassignment.exposit.deliveryservice.database.DatabaseServiceImpl;
import testassignment.exposit.deliveryservice.model.User;
import testassignment.exposit.deliveryservice.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
	
	DatabaseServiceImpl databaseService = new DatabaseServiceImpl();
	List<User> usersList = databaseService.loadListOfUser();
	
	@Override
	public User save(String name, String surname, String username, String email, String password, String confirmedPassword, String deliveryAddress) {
		
		User user = new User();
		System.out.println("Please enter your name: ");
		user.setName(name);
		System.out.println("Please enter your surname: ");
		user.setSurname(surname);
		System.out.println("Please enter your username: ");
		user.setUsername(username);
		System.out.println("Please enter your email: ");
		user.setEmail(email);
		System.out.println("Please enter your address: ");
		user.setDeliveryAddress(deliveryAddress);
		System.out.println("Please enter your password: ");
		user.setPassword(password);
		System.out.println("Please repeat your password: ");
		user.setConfirmedPassword(confirmedPassword);
		
		boolean userExists = usersList.stream()
				.anyMatch(userDB -> userDB.getUsername().equals(user.getUsername()));
		if (!userExists && password.equals(confirmedPassword)) {
			usersList.add(user);
			System.out.println("Thank you, your account has been created.");
		}
		return user;
	}
	
	@Override
	public void delete(String username) {
		
		usersList.stream()
				.filter(user -> user.getUsername().equals(username))
				.findFirst()
				.ifPresent(usersList::remove);
		System.out.println("User successfully deleted.");
	}
	
	@Override
	public User update(Integer userId, String name, String surname, String email, String address) {
		
		User user = usersList.get(userId);
		
		if (user != null) {
			user.setName(name);
			user.setSurname(surname);
			user.setEmail(email);
			user.setDeliveryAddress(address);
			System.out.println("Your data has been updated");
			System.out.println(user);
		} else {
			System.out.println("This user does not exist!");
		}
		return user;
	}
}
