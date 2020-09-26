package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import utils.DBUtil;




public abstract class BaseDao {
	private QueryRunner queryRunner=new QueryRunner();
	
	/**
	 * @param sql
	 * @param args
	 * @return 返回-1执行失败，否则返回影响条数
	 */
	public int update(String sql,Object...args){
		Connection conn=DBUtil.getConnection();
		try {
			return queryRunner.update(conn, sql, args);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.close(conn);
		}
		return -1;
	}
	
	/**
	 * 查询返回一个JavaBean对象
	 * @param <T> 返回对象类型的泛型
	 * @param type 返回的对象类型
	 * @param sql
	 * @param args sql参数
	 * @return
	 */
	public <T> T queryForOne(Class<T> type,String sql,Object...args) {
		Connection conn=DBUtil.getConnection();
		try {
			return queryRunner.query(conn,sql,new BeanHandler<T>(type),args);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.close(conn);
		}
		return null;
	}
	
	/**
	 * 查询返回多个bean对象，list封装
	 * @param <T>
	 * @param type
	 * @param sql
	 * @param args
	 * @return
	 */
	public <T>List<T> queryForList(Class<T> type,String sql,Object...args) {
		Connection conn=DBUtil.getConnection();
		try {
			return queryRunner.query(conn,sql,new BeanListHandler<T>(type),args);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.close(conn);
		}
		return null;
	}
	
	public Object queryForSingleValue(String sql,Object...args) {
		Connection conn=DBUtil.getConnection();
		try {
			return queryRunner.query(conn,sql,new ScalarHandler<Object>(), args);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.close(conn);
		}
		return null;
	}
	
	
	
	

}

