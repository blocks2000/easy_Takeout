<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改菜品</title>
<script type="text/javascript">
</script>
</head>
<body>
<%
String id=(String)request.getAttribute("foodId");
String mark=(String)request.getAttribute("mark");
String name=(String)request.getAttribute("name");
String des=(String)request.getAttribute("des");
String price=(String)request.getAttribute("price");
%>
<h1>菜品信息</h1>
    <form method="post"  action="editMenuServlet" enctype="multipart/form-data">  
    		<input name="foodId" value="<%=id %>" type="hidden"/>      
        <p>		   
            <lable for="name"> 菜品名称：</label>		      
            <input type="text" name="foodName" id="name" value="<%=name %>" ></p>        		
        <p>		  
            <lable for="introduce"> 菜品描述：</label>		  
            <textarea name="commet"rows=5 cols=60  id="introduce"><%=des %></textarea>
        </p>	
     		  评分：<input name="mark" readonly="readonly" value="<%=mark %>"/>	 
     		 价格：<input name="price" value="<%=price%>">      
        <p>	图片<input type="file" name="filename" id="selectFiles" onchange="dealSelectFiles()" ></p>
        <canvas id="myCanvas" width=1440 height=900></canvas>		
        <p>  
            <input type="submit"value="提交">          
            <input type="reset"value="清空">
        </p>     
    </form>
</body>
</html>