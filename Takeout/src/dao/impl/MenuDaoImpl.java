package dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.FoodMenu;
import dao.IMenuDao;
import utils.DBUtil2;



public class MenuDaoImpl implements IMenuDao {

	@Override
	public int getTotalCount() {//查询总数据量
		 String sql="select count(1) from Menu";
		 System.out.println(DBUtil2.getTotalCount(sql));
		return DBUtil2.getTotalCount(sql);
	}

	@Override
	public boolean updateMenuById(String id, FoodMenu menu) {
		String sql = "update Menu set name=?,des=?,imgurl=?,mark=?,price=? where id=?";
		Object params[]= {menu.getName(),menu.getDes(),menu.getImgurl(),menu.getMark(),menu.getPrice(),id};
		return DBUtil2.executeUpdate(sql, params);
	}

	@Override
	public boolean deleteMenu(String id) {
		String sql = "delete from Menu where id=?";
		Object params[]= {id};
		return DBUtil2.executeUpdate(sql, params);	}

	@Override
	public boolean addMenu(FoodMenu menu) {
		String sql = "insert into Menu values(?,?,?,?,?,?,?)";
		Object params[]= {menu.getId(),menu.getName(),menu.getDes(),menu.getImgurl(),menu.getMark(),menu.getPrice(),menu.getMerchant()};
		return DBUtil2.executeUpdate(sql, params);
	}

	@Override
	public FoodMenu queryMenuByName(String name) {
		FoodMenu menu = null;
		ResultSet rs=null;
		try {
			String sql = "select * from Menu where name=?";
			Object params[]= {name};
			rs=DBUtil2.queryAll(sql, params);
			if (rs.next()) {
				String id=rs.getString("id");
				String fname=rs.getString("name");
				String des=rs.getString("des");
				String imgurl=rs.getString("imgurl");
				String mark=rs.getString("mark");
				String price=rs.getString("price");
				String merchant=rs.getString("merchant");
				menu = new FoodMenu(id,fname,des,imgurl,mark,price,merchant);
			}
			return menu;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		} finally {
			DBUtil2.closeAll(rs, DBUtil2.pstmt, DBUtil2.connection);
		}
	}

	@Override
	public boolean isExist(String sname) {
		return queryMenuByName(sname) == null ? false : true;
	}

	@Override
	public List<FoodMenu> queryAll() {
		PreparedStatement pstmt=null;
		List<FoodMenu> menus=new ArrayList<>();
		FoodMenu foodMenu=null;
		ResultSet rs=null;
		try {
			String sql = " select *from Menu";
			rs=DBUtil2.queryAll(sql, null);
			//ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{  
				String id=rs.getString("id");
				String fname=rs.getString("name");
				String des=rs.getString("des");
				String imgurl=rs.getString("imgurl");
				String mark=rs.getString("mark");
				String price=rs.getString("price");
				String merchant=rs.getString("merchant");
				foodMenu = new FoodMenu(id,fname,des,imgurl,mark,price,merchant);
				menus.add(foodMenu);
			}
			return menus;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		} finally {
			DBUtil2.closeAll(rs, pstmt, DBUtil2.connection);
		}

	}
	
	@Override
	public FoodMenu queryMenuById(String id) {
		FoodMenu menu = null;
		ResultSet rs=null;
		try {
			String sql = "select * from Menu where id=?";
			Object params[]= {id};
			rs=DBUtil2.queryAll(sql, params);
			if (rs.next()) {
				String fname=rs.getString("name");
				String des=rs.getString("des");
				String imgurl=rs.getString("imgurl");
				String mark=rs.getString("mark");
				menu = new FoodMenu(fname,des,imgurl,mark);
			}
			return menu;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		} finally {
			DBUtil2.closeAll(rs, DBUtil2.pstmt, DBUtil2.connection);
		}


	}

	@Override
	public boolean isExistId(String id) {
		return queryMenuById(id) == null ? false : true;
	}

	@Override
	public boolean updateMarkByName(String name, String mark) {
		String sql = "update Menu set mark=? where name=?";
		Object params[]= {mark,name};
		return DBUtil2.executeUpdate(sql, params);
	}

	@Override
	public boolean updateMenuByName(String oldName,String newName, String comment, String imgurl) {
		String sql = "update Menu set name=?,des=?,imgurl=? where name=?";
		Object params[]= {newName,comment,imgurl,oldName};
		return DBUtil2.executeUpdate(sql, params);
	}

	@Override
	public String queryPriceById(String id) {
		ResultSet rs=null;
		String price = null;
		try {
			String sql = "select price from Menu where id=?";
			Object params[]= {id};
			rs=DBUtil2.queryAll(sql, params);
			if (rs.next()) {
				price=rs.getString("price");
			}
			return price;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		} finally {
			DBUtil2.closeAll(rs, DBUtil2.pstmt, DBUtil2.connection);
		}


	}

	@Override
	public String queryImgById(String id) {
		ResultSet rs=null;
		String img = null;
		try {
			String sql = "select imgurl from Menu where id=?";
			Object params[]= {id};
			rs=DBUtil2.queryAll(sql, params);
			if (rs.next()) {
				img=rs.getString("imgurl");
			}
			return img;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		} finally {
			DBUtil2.closeAll(rs, DBUtil2.pstmt, DBUtil2.connection);
		}
	}

	@Override
	public String queryNameById(String id) {
		ResultSet rs=null;
		String name = null;
		try {
			String sql = "select name from Menu where id=?";
			Object params[]= {id};
			rs=DBUtil2.queryAll(sql, params);
			if (rs.next()) {
				name=rs.getString("name");
			}
			return name;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		} finally {
			DBUtil2.closeAll(rs, DBUtil2.pstmt, DBUtil2.connection);
		}
	}

	@Override
	public boolean updateExceptMer(String id, String name, String des, String imgurl, String mark, String price) {
		String sql = "update Menu set name=?,des=?,imgurl=?,mark=?,price=? where id=?";
		Object params[]= {name,des,imgurl,mark,price,id};
		return DBUtil2.executeUpdate(sql, params);
	}

	@Override
	public List<FoodMenu> queryMenuByShopName(String shopname) {
		PreparedStatement pstmt=null;
		List<FoodMenu> menus=new ArrayList<>();
		FoodMenu foodMenu=null;
		ResultSet rs=null;
		try {
			String sql = " select *from Menu where merchant=?";
			Object params[]= {shopname};
			rs=DBUtil2.queryAll(sql, params);
			//ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{  
				String id=rs.getString("id");
				String fname=rs.getString("name");
				String des=rs.getString("des");
				String imgurl=rs.getString("imgurl");
				String mark=rs.getString("mark");
				String price=rs.getString("price");
				foodMenu = new FoodMenu(id,fname,des,imgurl,mark,price,shopname);
				menus.add(foodMenu);
			}
			return menus;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		} finally {
			DBUtil2.closeAll(rs, pstmt, DBUtil2.connection);
		}

	}

	@Override
	public String queryMerById(String id) {
		ResultSet rs=null;
		String merchant = null;
		try {
			String sql = "select merchant from Menu where id=?";
			Object params[]= {id};
			rs=DBUtil2.queryAll(sql, params);
			if (rs.next()) {
				merchant=rs.getString("merchant");
			}
			return merchant;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		} finally {
			DBUtil2.closeAll(rs, DBUtil2.pstmt, DBUtil2.connection);
		}
	}




	//@Override
//	public List<User> queryUserByPage(int currentPage, int pageSize) {
//		String sql="select *from(select row_number() over(order by name) as r,* from student)student2 where r>=? and r<=?";
//		Object params[]= {(currentPage-1)*pageSize+1,currentPage*pageSize};
//		List<User>users=new ArrayList<>();
//		ResultSet rs=DBUtil.queryAll(sql, params);
//		try {
//			while(rs.next())
//			{
//				String name=rs.getString("name");
//				int age=rs.getInt("age");
//				String address=rs.getString("address");
//				User student =new User(name, age, address);
//				users.add(student);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return users;
//	}
}
