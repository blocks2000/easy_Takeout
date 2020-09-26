package utils;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class DBUtil2 {
	private static final String URL = "jdbc:mysql://localhost:3306/Takeout?useUnicode=true&characterEncoding=utf-8";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "";
	public static Connection connection = null;
	public static PreparedStatement pstmt = null;
	public static ResultSet rs=null;
	
	
	//加载驱动
	public static Connection getConnection() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection(URL, USERNAME, PASSWORD);
	}
	
	//创建preparedStatement
	public static PreparedStatement createPreparedStatement(String sql,Object params[]) throws SQLException {
		try {
			pstmt = getConnection().prepareStatement(sql);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(params!=null)
		{
			for(int i=0;i<params.length;i++)
			{
				pstmt.setObject(i+1,params[i]);
			}
		}
		return pstmt;
	}
	
	
	//关闭资源
	public static void closeAll(ResultSet rs,Statement stmt,Connection connection) {
		try {
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			if(connection!=null) connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//改
	public static boolean executeUpdate(String sql,Object params[]) {
		int count = -1;
		try {
			connection=getConnection();
			pstmt = createPreparedStatement(sql, params);
			count = pstmt.executeUpdate();
			if (count > 0)
				return true;
			else
				return false;

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		} finally {
			closeAll(null, pstmt, connection);
		}

	}
	
	//查所有,返回值是一个集合比较好
	public static ResultSet queryAll(String sql,Object params[]) {
		try {
			 connection=getConnection();
			pstmt =createPreparedStatement(sql, params);
			rs = pstmt.executeQuery();
			return rs;

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		} 
		}
	
	//查一共有多少数据，后期可以使用到分页功能
	public static int getTotalCount(String sql) {
		int count=-1;
		try {
			  pstmt=createPreparedStatement(sql, null);
			  rs=pstmt.executeQuery();
			if(rs.next())
			{
				count=rs.getInt(1);
				//System.out.println(count);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeAll(rs, pstmt, connection);
		}
		return count;
	}

	}


