package testassignment.exposit.deliveryservice.model.enums;

public enum ProductCategories {

	APPLIANCES (1,"Appliances"),
	ELECTRONICS (2,"Electronics"),
	VEGETABLES (3,"Vegetables"),
	FRUITS (4,"Fruits"),
	BEVERAGES (5,"Beverages"),
	MILKPRODUCTS (6,"Milk products"),
	MEATPRODUCTS (7,"Meat products"),
	GROCERY (8,"Grocery"),
	SWEETS (9,"Sweets"),
	FROZENFOOD (10,"Frozen food"),
	HOUSEHOLD (11,"Household"),
	KIDS (12, "Kids"),
	SUNDRIES (13, "Sundries");
	
	public Integer code;
	public String category;
	
	ProductCategories() {
	}
	
	ProductCategories(Integer code, String category) {
		this.code = code;
		this.category = category;
	}
	
	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	public Integer getCode() {
		return code;
	}
	
	public void setCode(Integer code) {
		this.code = code;
	}
}
