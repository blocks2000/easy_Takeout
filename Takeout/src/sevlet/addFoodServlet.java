package sevlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class addFoodServlet
 */
@WebServlet("/addFoodServlet")
public class addFoodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public addFoodServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("utf-8");
    	String foodId=request.getParameter("foodId");
    	String foodPrice=request.getParameter("foodPrice");
    	String count=request.getParameter("count");
    	String username=request.getParameter("username");
    	String shopname=request.getParameter("shopname");
    	System.out.println(foodId);
    	System.out.println(foodPrice);
    	request.setAttribute("foodId", foodId);
    	request.setAttribute("foodPrice", foodPrice);
    	request.setAttribute("count", count);
    	request.setAttribute("username", username);
    	request.setAttribute("shopname", shopname);
    	Date date=new Date();
		SimpleDateFormat formatter=new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		String time=formatter.format(date);
		request.setAttribute("time",time);
    	request.getRequestDispatcher("addOrderServlet").forward(request, response);
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
