package service.impl;
import java.util.List;

import bean.FoodMenu;
import dao.IMenuDao;
import dao.impl.MenuDaoImpl;
import service.IMenuService;

public class IMenuServiceImpl implements IMenuService {
	IMenuDao menuDao=new MenuDaoImpl();
	

	@Override
	public int getTotalCount() {
		// TODO Auto-generated method stub
		return menuDao.getTotalCount();
	}

	@Override
	public boolean updateMenuById(String id, FoodMenu menu) {
		if(menuDao.isExistId(id))
		{
			return menuDao.updateMenuById(id, menu);
		}
		return false;
	}

	@Override
	public boolean deleteMenu(String id) {
		if(menuDao.isExistId(id))
		{
			return menuDao.deleteMenu(id);
		}
		return false;
	}

	@Override
	public boolean addMenu(FoodMenu menu) {
		 return menuDao.addMenu(menu);
	}

	@Override
	public List<FoodMenu> queryAll() {
		return menuDao.queryAll();
	}

	@Override
	public FoodMenu queryMenuByName(String name) {
		 return menuDao.queryMenuByName(name);
	}

	@Override
	public boolean updateMarkByName(String name, String mark) {
		return menuDao.updateMarkByName(name, mark);
	}

	@Override
	public boolean updateMenuByName(String oldName,String newName,String comment,String imgurl) {
		return menuDao.updateMenuByName(oldName,newName, comment, imgurl);
	}

	@Override
	public String queryPriceById(String id) {
		return menuDao.queryPriceById(id);
	}

	@Override
	public String queryImgById(String id) {
		 return menuDao.queryImgById(id);
	}

	@Override
	public String queryNameById(String id) {
		return menuDao.queryNameById(id);
	}

	@Override
	public boolean updateExceptMer(String id, String name, String des, String imgurl, String mark, String price) {
		return menuDao.updateExceptMer(id, name, des, imgurl, mark, price);
	}

	@Override
	public List<FoodMenu> queryMenuByShopName(String shopname) {
		return menuDao.queryMenuByShopName(shopname);
	}

	@Override
	public String queryMerById(String id) {
		return menuDao.queryMerById(id);
	}

}
