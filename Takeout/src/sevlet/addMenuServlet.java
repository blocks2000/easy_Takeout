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

import bean.FoodMenu;
import bean.Shop;
import service.IMenuService;
import service.IShopService;
import service.impl.IMenuServiceImpl;
import service.impl.ShopServiceImpl;


/**
 * Servlet implementation class addMenuServlet
 */
@WebServlet("/addMenuServlet")
public class addMenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public addMenuServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String shopName=null;
		String desc=null;
		String imgurl=null;
		String foodName = null;
		String foodDes=null;
		String price=null;
		String foodImg=null;
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
						if(itemName.equals("shopDes"))
						{
							desc=item.getString("utf-8");
						}
						if(itemName.equals("shopImg"))
						{
							imgurl=item.getString("utf-8");
						}
						if(itemName.equals("shopName"))
						{
							shopName=item.getString("utf-8");
						}
						if(itemName.equals("foodName"))
						{
							foodName=item.getString("utf-8");
						}
						if(itemName.equals("commet"))
						{
							foodDes=item.getString("utf-8");
						}
						if(itemName.equals("price"))
						{
							price=item.getString("utf-8");
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
						foodImg="./images/"+fileName;
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
		FoodMenu menu=new FoodMenu(foodName, foodName, foodDes, foodImg,"7",price,shopName);
		IMenuService menuService=new IMenuServiceImpl();
		if(menuService.addMenu(menu))
		{
			System.out.println("添加成功");
		}
		else {
			System.out.println("添加失败");
		}
		Shop shop=new Shop(foodName, shopName, shopName, foodName, desc, imgurl);
		IShopService shopService=new ShopServiceImpl();
		shopService.addShop(shop);
		request.setAttribute("menu", menu);
		request.setAttribute("shop", shop);
		request.getRequestDispatcher("showShop.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
