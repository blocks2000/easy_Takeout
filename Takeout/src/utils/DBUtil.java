package utils;


import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;


public class DBUtil {
	private static DruidDataSource dataSource;
	static {
	    try {
	    	Properties pro=new Properties(); 
		    InputStream is= DBUtil.class.getClassLoader().getResourceAsStream("druid.properties");
			pro.load(is);
			dataSource=(DruidDataSource) DruidDataSourceFactory.createDataSource(pro);
			//System.out.println(dataSource.getConnection());	
	    } catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	   
	}
	/**
	 * 获取连接，返回null为失败
	 * @return
	 */
	public static Connection getConnection(){
		Connection conn=null;
		try {
			conn=dataSource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	/**
	 * 关闭连接
	 * @param conn
	 */
	public static void close(Connection conn) {
		if(conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	

}
