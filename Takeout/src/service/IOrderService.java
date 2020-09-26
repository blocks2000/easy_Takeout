package service;

import java.util.List;

import bean.Order;

public interface IOrderService {
	public boolean isExistOrder(String id);
	public int getTotalCount(); //查询总共的数据
	//public List<User> queryUserByPage(int currentPage,int pageSize);//当前页和页数
		
	public boolean updateOrderById(String id,Order order);//根据id改内容
//	public boolean updateMarkByName(String name,String mark);
//	public boolean updateMenuByName(String oldName,String newName,String comment,String imgurl);
	
	public boolean deleteOrder(String id);//根据名字删除
	public boolean deleteAll();
	public boolean updateExceptPri();

	public boolean addOrder(Order order);//添加新订单
	public List<Order> queryAll();//查询所有
	public Order queryOrder(String user_id);//根据id查订单
	public Order queryIdOrder(String id);
	public boolean updatePrice(String shopname, String price);
	public boolean isExistById(String id);
	public Order queryByMerchant(String shopname);
	public boolean isExistByShopName(String shopname) ;
	public boolean updatestate(String shopname,String state);
}
