package service.impl;

import java.util.List;

import bean.Single_order;
import dao.IOrderDao;
import dao.ISingle_orderDao;
import dao.impl.OrderDaoImpl;
import dao.impl.Single_orderDaoImpl;
import service.ISingle_orderService;

public class Single_orderServiceImpl implements ISingle_orderService {

	ISingle_orderDao single_dao=new Single_orderDaoImpl();
	@Override
	public boolean isExist(String id) {
		return single_dao.isExist(id);
	}

	@Override
	public int getTotalCount() {
		return single_dao.getTotalCount();
	}

	@Override
	public boolean updateS_OrderById(String id, Single_order s_order) {
		if(single_dao.isExist(id))
		{
			return single_dao.updateS_OrderById(id, s_order);
		}
		return false;
	}

	@Override
	public boolean deleteS_Order(String id) {
		if(single_dao.isExist(id))
		{
			return single_dao.deleteS_Order(id);
		}
		return false;
	}

	@Override
	public boolean addS_Order(Single_order s_order) {
		return single_dao.addS_Order(s_order);
	}

	@Override
	public List<Single_order> queryS_Order(String order_id) {
		return single_dao.queryS_Order(order_id);
	}

	@Override
	public Single_order queryS_OrderById(String id) {
		if(single_dao.isExist(id))
		{
			return single_dao.queryS_OrderById(id);
		}
		return null;
	}

	@Override
	public Single_order queryIdOrder(String id) {
		return single_dao.queryIdOrder(id);
	}

	@Override
	public boolean isExistById(String id) {
		return single_dao.isExistById(id);
	}

	@Override
	public boolean updateS_Order(String id, String quantity, String single_price) {
		return single_dao.updateS_Order(id, quantity, single_price);
	}

	@Override
	public boolean deleteAll() {
		return single_dao.deleteAll();
	}

}
