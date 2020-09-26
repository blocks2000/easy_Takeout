package sevlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.User;
import service.UserService;
import service.impl.UserServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");	
		UserService userService=new UserServiceImpl();
		HttpSession session = request.getSession();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//System.out.println(username);
		User loginUser = userService.login(username, password);
		if(loginUser==null) {
			//登录失败，返回登录页
			String error="用户名或密码错误";
			request.setAttribute("error", error);
			request.getRequestDispatcher("login.jsp").forward(request, response);
			
		}else {
			//登录成功，判断账号类型
			System.out.println(loginUser.toString());
			String type=loginUser.getType();
			String username2=loginUser.getUsername();
			//保存登录信息
			session.setAttribute("loginUser",loginUser);
			if(type.equals("customer")) {
				//顾客账号
				request.setAttribute("username",username2);
				request.getRequestDispatcher("queryFoodServlet").forward(request, response);
			}
			else if(type.equals("store")) {
				//商家账号
				request.setAttribute("username", username2);
				request.getRequestDispatcher("queryShopServlet").forward(request, response);
			}else {
				//骑手账号，跳到接订单页面
				request.getRequestDispatcher("/showUndoOrder.jsp").forward(request, response);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
