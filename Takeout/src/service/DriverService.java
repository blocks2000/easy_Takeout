package service;

import java.util.List;

import bean.Order;

public interface DriverService {
	
	public List<Order> undoOrder();
	
	

	int change(String state, String user_id);

}
