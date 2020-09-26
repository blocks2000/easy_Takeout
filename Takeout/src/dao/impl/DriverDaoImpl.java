package dao.impl;

import java.util.List;

import bean.Order;
import dao.BaseDao;
import dao.DriverDao;

public class DriverDaoImpl extends BaseDao implements DriverDao{

	@Override
	public List<Order> undoOrders() {
		String sql="select * from foodorder where state=?";
		List<Order> undoOrder=queryForList(Order.class, sql, "2");
		return undoOrder;
	}
	

	@Override
	public int changeState(String state,String user_id) {
		String sql="update foodOrder set state=? where user_id=?";
		return update(sql, state,user_id);	
	}


	@Override
	public int changeDriver(String user_id, String drivername) {
		String sql="update foodOrder set driver=? where user_id=?";
		return update(sql, drivername,user_id);
	}


	@Override
	public List<Order> driverOrders(String drivername) {
		String sql="select * from foodorder where driver=? and state=3";
		List<Order> myOrder=queryForList(Order.class, sql,drivername);
		return myOrder;
	}


	@Override
	public int changeStatetoOK(String user_id,String drivername) {
		String sql="update foodOrder set state="+"4"+" where user_id=? and driver=?";
		return update(sql,user_id,drivername);	
	}


	@Override
	public List<Order> finishOrders(String drivername) {
		String sql="select * from foodorder where driver=? and state=?";
		List<Order> finishOrders=queryForList(Order.class, sql,drivername,"4");
		return finishOrders;
	}




	

}
