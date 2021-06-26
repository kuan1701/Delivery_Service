package testassignment.exposit.deliveryservice.model.enums;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

public enum OrderStatus {
	
	PLACED (0, "Placed"),
	INBOUND (1, "Inbound"),
	DELIVERED (2, "Delivered"),
	CANCELED (3, "Canceled"),
	REJECTED (4, "Rejected");
	
	public int code;
	public String status;
	
	OrderStatus(int code, String status) {
		this.code = code;
		this.status = status;
	}
	
	public int getCode() {
		return code;
	}
	
	public void setCode(int code) {
		this.code = code;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public static OrderStatus getByCode(Integer code) {
		
		Stream<OrderStatus> values = Arrays.stream(OrderStatus.values());
		
		Predicate<OrderStatus> predicate = x -> x.getCode() == code;
		
		Optional<OrderStatus> result = values.filter(predicate).findFirst();
		
		return result.get();
	}
}
