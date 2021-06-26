package testassignment.exposit.deliveryservice.util.comparator;

import testassignment.exposit.deliveryservice.model.ProductShop;

import java.util.Comparator;

public class MostExpensivePriceComparator implements Comparator<ProductShop> {
	
	@Override
	public int compare(ProductShop productShop1, ProductShop productShop2) {
		
		return Double.compare(productShop2.getPrice(), productShop1.getPrice());
	}
}
