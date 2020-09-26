package service;

import bean.User;

public interface UserService {
	/**
	 * 注册
	 * @param user
	 * @return 
	 */
	public boolean regist(User user);
	
	/**
	 * 登录
	 * @param 用户名，账号
	 */
	public User login(String username, String password);

}
