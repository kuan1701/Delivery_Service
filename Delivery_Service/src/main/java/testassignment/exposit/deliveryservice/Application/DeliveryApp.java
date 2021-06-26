package testassignment.exposit.deliveryservice.Application;

import testassignment.exposit.deliveryservice.database.DatabaseServiceImpl;

import java.io.FileNotFoundException;

public class DeliveryApp {
	
	public static void main(String[] args) throws FileNotFoundException {
		
		DatabaseServiceImpl databaseService = new DatabaseServiceImpl();
	}
}
