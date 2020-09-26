package test;

import bean.User;
import dao.impl.UserDaoImpl;

public class UserDaoTest {
	public static void main(String args[]) {
		UserDaoImpl u=new UserDaoImpl();
		User user=new User("12", "256", "416", "54", "nnn","joi");
		u.saveUser(user);
		System.out.println(u.queryByName("zhangsan"));
		System.out.println(u.queryByNameandPassword("zhangsan", "123456"));
		
	}

}
