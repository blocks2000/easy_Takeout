package sevlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import bean.User;
import service.UserService;
import service.impl.UserServiceImpl;





public class RegistServlet extends HttpServlet {
	private UserService userService=new UserServiceImpl();
	private static final long serialVersionUID = 1L;
 
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");	
		Map<String, String[]> map=request.getParameterMap();
		List<String> types=Arrays.asList("customer","store","driver");
		User registUser=new User();
		try {
			BeanUtils.populate(registUser, map);
			//System.out.println(types.toString());
			if(types.contains(registUser.getType())&&userService.regist(registUser)==true){
				//注册成功，
				String error="注册成功";
				request.setAttribute("error", error);
				//request.setAttribute("registUser",registUser);
				if(registUser.getType().equals("customer")) {
					//顾客账号，跳到登录页面
					request.getRequestDispatcher("/login.jsp").forward(request, response);
				}
				else if(registUser.getType().equals("store")) {
					//商家账号,跳到新增店铺页面
					request.getRequestDispatcher("/addShop.jsp").forward(request, response);
				}else {
					//骑手账号
					request.getRequestDispatcher("/login.jsp").forward(request, response);
				}
			}
			else {
				//注册失败,跳回登录注册页面
				//System.out.println("注册失败");
				String error="注册失败";
				request.setAttribute("error", error);
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
