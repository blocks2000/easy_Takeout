package sevlet;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

 
@WebServlet("/addShopServlet")
public class addShopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public addShopServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String shopName=null;
		String deS=null;
		String imgurl=null;
		
		boolean isMultipart=ServletFileUpload.isMultipartContent(request);
		if(isMultipart)
		{
			FileItemFactory factory=new DiskFileItemFactory();
			ServletFileUpload upload=new ServletFileUpload(factory);
			try {
				List<FileItem> items = upload.parseRequest(request);
				Iterator<FileItem> iterator = items.iterator();
				while(iterator.hasNext())
				{
					FileItem item=iterator.next();
					String itemName=item.getFieldName();//获取普通表单字段
					if(item.isFormField())//需要对表单区域进行区分
					{
						if(itemName.equals("shopName"))
						{
							shopName=item.getString("utf-8");
						}
						else if(itemName.equals("commet"))
						{
							deS=item.getString("utf-8");
						}
						else {
							System.out.println("其他字段...");
						}
					}else
					{
						//文件上传
						String fileName=item.getName();//获取文件字段名字
						System.out.print(fileName);
						//获取服务器路径
						//request.getSession().getServletContext().getRealPath(arg0);
						String path="D:\\Tomcat\\upload";
						File file=new File(path,fileName);
						item.write(file);
						System.out.println(fileName+"上传成功");
						imgurl="./ShopImages/"+fileName;
						System.out.println(imgurl);
					}
				}
				
			} catch (FileUploadException e) {
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		request.setAttribute("shopName", shopName);
		request.setAttribute("desc", deS);
		request.setAttribute("imgurl", imgurl);
		request.getRequestDispatcher("addFood.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
