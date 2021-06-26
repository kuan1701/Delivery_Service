package testassignment.exposit.deliveryservice.util.parser;

import com.google.gson.Gson;
import testassignment.exposit.deliveryservice.database.DatabaseServiceImpl;

import java.io.*;
import java.lang.reflect.Type;
import java.util.LinkedList;

public class JsonParserClass {
	
	public JsonParserClass() {
	}
	
	private static Gson gson = new Gson();
	
	public static Object parseFromJson(String filePath, Type listType) {
		
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
			return gson.fromJson(bufferedReader, listType);
		}catch (FileNotFoundException e){
			System.out.println("Parsing from json error " + e.toString());
			
			switch (filePath) {
				
				case DatabaseServiceImpl.JSON_USER: new File(DatabaseServiceImpl.JSON_USER);
				break;
				
				case DatabaseServiceImpl.JSON_PRODUCT: new File(DatabaseServiceImpl.JSON_PRODUCT);
				break;
				
				case DatabaseServiceImpl.JSON_PRODUCTSHOP: new File(DatabaseServiceImpl.JSON_PRODUCTSHOP);
				break;
				
				case DatabaseServiceImpl.JSON_SHOP: new File(DatabaseServiceImpl.JSON_SHOP);
				break;
				
				case DatabaseServiceImpl.JSON_ORDER: new File(DatabaseServiceImpl.JSON_ORDER);
				break;
			}
		}
		return new LinkedList<>();
	}
	
	public static void parseToJson(String filePath, Object object) {
		
		try {
			FileWriter writer = new FileWriter(filePath);
			writer.write(gson.toJson(object));
			writer.close();
		}catch (IOException e){
			System.out.println("Parsing to json error " + e.toString());
		}
	}
}
