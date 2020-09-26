package service.impl;

import java.util.List;

import bean.Order;
import dao.impl.DriverDaoImpl;
import service.DriverService;

public class DriverServiceImpl implements DriverService{
	DriverDaoImpl driver=new DriverDaoImpl();

	@Override
	public List<Order> undoOrder() {
		// TODO Auto-generated method stub
		return driver.undoOrders();
	}

	@Override
	public int change(String state,String user_id) {
		// TODO Auto-generated method stub
		return driver.changeState(state, user_id);
	}

}
