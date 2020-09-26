package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import bean.FoodMenu;
import bean.User;
import dao.BaseDao;
import dao.UserDao;
import utils.DBUtil2;

public class UserDaoImpl extends BaseDao implements UserDao{

	@Override
	public User queryByName(String username) {
		User user = null;
		ResultSet rs=null;
		try {
			String sql = "select * from User where username=?";
			Object params[]= {username};
			rs=DBUtil2.queryAll(sql, params);
			if (rs.next()) {
				String id=rs.getString("id");
				String password=rs.getString("password");
				String phone=rs.getString("phone");
				String address=rs.getString("address");
				String sex=rs.getString("sex");
				String type=rs.getString("type");
				user=new User(username, password, phone, address, sex, type);
			}
			return user;

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
	public int saveUser(User user) {
		String sql1="select id from user where 1 order by id*1 desc;";
		String id=(String)queryForSingleValue(sql1,null);
		System.out.println(id);
		String newid =(Integer.parseInt(id)+1)+"";
		String sql="insert into user(id,username,password,phone,address,sex,type) values (?,?,?,?,?,?,?)";
		return update(sql, newid,user.getUsername(),user.getPassword(),user.getPhone(),user.getAddress(),user.getSex(),user.getType());	
	}

	@Override
	public User queryByNameandPassword(String username, String password) {
		User user = null;
		ResultSet rs=null;
		try {
			String sql = "select *from user where username=? and password=?";
			Object params[]= {username,password};
			rs=DBUtil2.queryAll(sql, params);
			if (rs.next()) {
				String id=rs.getString("id");
				String phone=rs.getString("phone");
				String address=rs.getString("address");
				String sex=rs.getString("sex");
				String type=rs.getString("type");
				user=new User(username, password, phone, address, sex, type);
			}
			return user;

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

}



