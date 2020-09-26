package dao;

import java.util.List;


import bean.Shop;

public interface IShopDao {
	public boolean isExist(String merchant);//查询用户是否存在
	//public int getTotalCount(); //查询总共的数据
	//public List<User> queryUserByPage(int currentPage,int pageSize);//当前页和页数
		
	//public boolean updateShopByMer(String name,User user);//根据名字改内容
	
	public boolean deleteShop(String merchants);//根据名字删除

	public boolean addShop(Shop shop);//添加
	public List<Shop> queryAll();//查询所有
	
	


	public List<Shop> queryShopByMer(String merchants);//根据学号查所有
	public Shop queryShopByName(String shopname);
}
