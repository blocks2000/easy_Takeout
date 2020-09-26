package dao;

import bean.User;

public interface UserDao {
	/**
	 * 根据用户名查找用户，没找到返回null,找到返回user对象
	 * @param username
	 * @return
	 */
	public User queryByName(String username);
	
	
	
	/**
	 * 保存用户
	 * @param user
	 * @return
	 */
	public int saveUser(User user);
	
	
	
	
	
	/**
	 * 根据用户名和密码查找用户，没找到返回null,找到返回user对象
	 * @param username
	 * @return
	 */
	public User queryByNameandPassword(String username,String password);
	
	
}

