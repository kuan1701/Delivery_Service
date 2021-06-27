package testassignment.exposit.deliveryservice.service;

import testassignment.exposit.deliveryservice.model.User;

import java.util.List;

public interface UserService {

	User save(String name, String surname, String username, String email, String password, String deliveryAddress);
	
	void delete(Integer userId);
	
	User update(Integer userId, String name, String surname, String username, String email, String address);
}
