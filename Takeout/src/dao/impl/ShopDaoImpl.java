package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import bean.Order;
import bean.Shop;
import dao.IShopDao;
import utils.DBUtil2;

public class ShopDaoImpl implements IShopDao {

	@Override
	public boolean deleteShop(String merchants) {
		String sql = "delete from Shop where merchants=?";
		Object params[]= {merchants};
		return DBUtil2.executeUpdate(sql, params);
	}

	@Override
	public boolean addShop(Shop shop) {
		String sql = "insert into Shop values(?,?,?,?,?,?)";
		Object params[]= {shop.getId(),shop.getMerchants(),shop.getShopname(),shop.getMenu_id(),shop.getDesc(),shop.getImgurl()};
		return DBUtil2.executeUpdate(sql, params);
	}

	@Override
	public List<Shop> queryAll() {
		PreparedStatement pstmt=null;
		List<Shop> shops=new ArrayList<>();
		Shop shop=null;
		ResultSet rs=null;
		try {
			String sql = " select *from Shop";
			rs=DBUtil2.queryAll(sql, null);
			//ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{  
				String id=rs.getString("id");
				String merchants=rs.getString("merchants");
				String shopname=rs.getString("menu_id");
				String menu_id=rs.getString("menu_id");
				String desc=rs.getString("desc");
				String imgurl=rs.getString("imgurl");
				shop = new Shop(id,merchants,shopname,menu_id,desc,imgurl);
				shops.add(shop);
			}
			return shops;

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
	public List<Shop> queryShopByMer(String shopname) {
		PreparedStatement pstmt=null;
		List<Shop> shops=new ArrayList<>();
		Shop shop=null;
		ResultSet rs=null;
		try {
			String sql = " select *from Shop where shopname=?";
			Object params[]= {shopname};
			rs=DBUtil2.queryAll(sql, params);
			//ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{  
				String id=rs.getString("id");
				String merchants=rs.getString("merchants");
				String menu_id=rs.getString("menu_id");
				String desc=rs.getString("desc");
				String imgurl=rs.getString("imgurl");
				shop = new Shop(id,merchants,shopname,menu_id,desc,imgurl);
				shops.add(shop);
			}
			return shops;

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
	public boolean isExist(String shopname) {
		return queryShopByMer(shopname)==null?false:true;
	}

	@Override
	public Shop queryShopByName(String shopname) {
		PreparedStatement pstmt=null;
		List<Shop> shops=new ArrayList<>();
		Shop shop=null;
		ResultSet rs=null;
		try {
			String sql = " select *from Shop where shopname=?";
			Object params[]= {shopname};
			rs=DBUtil2.queryAll(sql, params);
			//ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{  
				String id=rs.getString("id");
				String merchants=rs.getString("merchants");
				String menu_id=rs.getString("menu_id");
				String desc=rs.getString("desc");
				String imgurl=rs.getString("imgurl");
				shop = new Shop(id,merchants,shopname,menu_id,desc,imgurl);
				shops.add(shop);
			}
			return shops.get(0);

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

}
