package service.impl;

import bean.User;
import dao.impl.UserDaoImpl;
import service.UserService;

public class UserServiceImpl implements UserService{
	public UserDaoImpl us=new UserDaoImpl();;

	@Override
	public boolean regist(User user) {
		// TODO Auto-generated method stub
		if(us.saveUser(user)==1) {
			return true;
		}
		return false;
	
	}

	@Override
	public User login(String username,String password) {
		
		User loginuser=us.queryByNameandPassword(username, password);
		if(loginuser!=null && loginuser.getPassword().equals(password)) {
			return loginuser;
		}else {
			return null;
		}
	}
}