package sevlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class deleFoodServlet
 */
@WebServlet("/deleFoodServlet")
public class deleFoodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


    public deleFoodServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
    	String text=request.getParameter("text");
    	String foodId=request.getParameter("foodId");
    	String foodPrice=request.getParameter("foodPrice");
    	PrintWriter out=response.getWriter();
    	if(!text.equals("")&&text!=null)
    	{
    		int num=Integer.parseInt(text);
    		int sum;
    		if(num>0)
    		{
    			sum=num-1;
    		}
    		else sum=0;
    		out.print(sum);
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
