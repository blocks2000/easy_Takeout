package service;

import java.util.List;

import bean.Shop;

public interface IShopService {
	public boolean deleteShop(String merchants);//根据名字删除

	public boolean addShop(Shop shop);//添加
	public List<Shop> queryAll();//查询所有
	public boolean isExist(String shopname);
	public Shop queryShopByName(String shopname);


	public List<Shop> queryShopByMer(String shopname);//根据学号查所有
}
