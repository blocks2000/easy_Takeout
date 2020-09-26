package service.impl;

import java.util.List;

import bean.Shop;
import dao.IShopDao;
import dao.impl.ShopDaoImpl;
import service.IShopService;

public class ShopServiceImpl implements IShopService {

	IShopDao shopDao=new ShopDaoImpl();
	@Override
	public boolean deleteShop(String merchants) {
		return shopDao.deleteShop(merchants);
	}

	@Override
	public boolean addShop(Shop shop) {
		return shopDao.addShop(shop);
	}

	@Override
	public List<Shop> queryAll() {
		 return shopDao.queryAll();
	}

	@Override
	public List<Shop> queryShopByMer(String shopname) {
		return shopDao.queryShopByMer(shopname);
	}

	@Override
	public boolean isExist(String shopname) {
		return shopDao.isExist(shopname);
	}

	@Override
	public Shop queryShopByName(String shopname) {
		return shopDao.queryShopByName(shopname);
	}

}
