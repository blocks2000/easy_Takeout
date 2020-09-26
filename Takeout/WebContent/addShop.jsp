<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>添加店铺</h1>
    <form method="post"  action="addShopServlet" enctype="multipart/form-data">       
        <p>		   
            <lable for="name"> 店铺名称：</label>		      
            <input type="text" name="shopName" id="name" ></p>        		
        <p>		  
            <lable for="introduce"> 店铺描述：</label>		  
            <textarea name="commet"rows=5 cols=60  id="introduce"></textarea>
        </p>	     
        <p>店铺图片<input type="file" name="filename" id="selectFiles"></p>	
        <p>  
            <input type="submit"value="添加菜品">          
            <input type="reset"value="清空">
        </p>     
    </form>
</body>
</html>