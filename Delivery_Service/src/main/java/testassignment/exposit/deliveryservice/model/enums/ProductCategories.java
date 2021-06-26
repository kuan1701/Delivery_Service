package testassignment.exposit.deliveryservice.model.enums;

public enum ProductCategories {

	APPLIANCES (1,"APPLIANCES"),
	ELECTRONICS (2,"ELECTRONICS"),
	VEGETABLES (3,"VEGETABLES"),
	FRUITS (4,"FRUITS"),
	BEVERAGES (5,"BEVERAGES"),
	MILKPRODUCTS (6,"MILK PRODUCTS"),
	MEATPRODUCTS (7,"MEATPRODUCTS"),
	GROCERY (8,"GROCERY"),
	SWEETS (9,"SWEETS"),
	FROZENFOOD (10,"FROZEN FOOD"),
	HOUSEHOLD (11,"HOUSEHOLD"),
	KIDS (12, "KIDS"),
	SUNDRIES (13, "SUNDRIES");
	
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
