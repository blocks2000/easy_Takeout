package service.impl;

import java.util.List;


import bean.Order;
import dao.IOrderDao;
import dao.impl.OrderDaoImpl;
import service.IOrderService;

public class OrderServiceImpl implements IOrderService {
	
	IOrderDao orderDao=new OrderDaoImpl();

	@Override
	public boolean isExistOrder(String id) {
		return orderDao.isExistOrder(id);
	}

	@Override
	public int getTotalCount() {
		return orderDao.getTotalCount();
	}

	@Override
	public boolean updateOrderById(String id, Order order) {
		if(orderDao.isExistOrder(id))
		{
			return orderDao.updateOrderById(id, order);
		}
		return false;
	}

	@Override
	public boolean deleteOrder(String id) {
		if(orderDao.isExistOrder(id))
		{
			return orderDao.deleteOrder(id);
		}
		return false;
	}

	@Override
	public boolean addOrder(Order order) {
		return orderDao.addOrder(order);
	}

	@Override
	public List<Order> queryAll() {
		return orderDao.queryAll();
	}

	@Override
	public Order queryOrder(String user_id) {
		return orderDao.queryOrder(user_id);
	}

	@Override
	public boolean updatePrice(String shopname, String price) {
		return orderDao.updatePrice(shopname, price);
	}

	@Override
	public boolean isExistById(String id) {
		return orderDao.isExistById(id);
	}

	@Override
	public Order queryIdOrder(String id) {
		return orderDao.queryIdOrder(id);
	}

	@Override
	public boolean deleteAll() {
		return orderDao.deleteAll();
	}

	@Override
	public boolean updateExceptPri() {
		return orderDao.updateExceptPri();
	}

	@Override
	public Order queryByMerchant(String shopname) {
		return orderDao.queryByMerchant(shopname);
	}

	@Override
	public boolean isExistByShopName(String shopname) {
		return orderDao.isExistByShopName(shopname);
	}

	@Override
	public boolean updatestate(String shopname, String state) {
		return orderDao.updatestate(shopname, state);
	}

}
