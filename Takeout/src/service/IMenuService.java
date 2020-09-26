package service;

import java.util.List;

import bean.FoodMenu;

public interface IMenuService {
	public int getTotalCount(); //查询总共的数据
	//public List<User> queryUserByPage(int currentPage,int pageSize);//当前页和页数
		
	public boolean updateMenuById(String id,FoodMenu menu);//根据id改内容
	public String queryPriceById(String id);//根据id查价格
	
	public boolean deleteMenu(String id);//根据名字删除
	public boolean updateMarkByName(String name,String mark);
	public boolean updateMenuByName(String oldName,String newName,String comment,String imgurl);
	public boolean addMenu(FoodMenu menu);//添加
	public List<FoodMenu> queryAll();//查询所有
	public String queryImgById(String id);
	public String queryNameById(String id);
	public boolean updateExceptMer(String id,String name,String des,String imgurl,String mark,String price);
	public List<FoodMenu> queryMenuByShopName(String shopname);
	public String queryMerById(String id);
	


	public FoodMenu queryMenuByName(String name);
}
