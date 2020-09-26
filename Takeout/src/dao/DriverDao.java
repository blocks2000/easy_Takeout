package dao;

import java.util.List;

import bean.Order;

public interface DriverDao {
	/**
	 * 查询未派送的订单
	 * @return
	 */
	public List<Order> undoOrders();
	
	/**
	 * 改变订单状态
	 */
	int changeState(String state, String user_id);
	
	/**
	 * 为该订单设置骑手名字
	 * @param user_id
	 * @param drivername
	 * @return
	 */
	public int changeDriver(String user_id,String drivername);
	
	/**
	 * 查询骑手已接订单
	 * @param drivername 骑手名
	 * @return
	 */
	public List<Order> driverOrders(String drivername);
	
	
	/**
	 * 查询骑手已完成订单
	 * @param drivername 骑手名
	 * @return
	 */
	public List<Order> finishOrders(String drivername);

	/**
	 * 将订单状态置为已完成
	 * @return
	 */
	int changeStatetoOK(String user_id, String drivername);

}
