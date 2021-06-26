package testassignment.exposit.deliveryservice.model;

import java.util.Objects;

public class User {
	
	private Integer userId;
	private String name;
	private String surname;
	private String username;
	private String email;
	private String password;
	private String confirmedPassword;
	private String deliveryAddress;
	
	private static Integer count = 0;
	
	public User() {
		count++;
		this.userId = count;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof User)) return false;
		User user = (User) o;
		return userId.equals(user.userId) &&
				getUsername().equals(user.getUsername()) &&
				getEmail().equals(user.getEmail());
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(userId, getUsername(), getEmail());
	}
	
	@Override
	public String toString() {
		return "User: " + + userId + ".\n" +
				"Name: '" + name + ".\n" +
				"Surname='" + surname + ".\n" +
				"Username='" + username + ".\n" +
				"Email='" + email + ".\n" +
				"Password='" + password + ".\n" +
				"DeliveryAddress='" + deliveryAddress + ".\n";
	}
	
	public Integer getUserId() {
		return userId;
	}
	
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getConfirmedPassword() {
		return confirmedPassword;
	}
	
	public void setConfirmedPassword(String confirmedPassword) {
		this.confirmedPassword = confirmedPassword;
	}
	
	public String getDeliveryAddress() {
		return deliveryAddress;
	}
	
	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}
}
