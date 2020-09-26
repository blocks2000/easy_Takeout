<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href=".\css\login.css">
</head>
<body>
	<%
		String error=(String)request.getAttribute("error");
	%>
		<div class="container">
		<img src=".\image\background.jpg" width="420px" height="650px" alt="">
	
		<div class="panel">
			<div class="content login">
				<div class="switch">
					<span id ="login" class="active ">Login</span><span>/</span><span id ="signup">Sign Up</span>
					
				</div>
				
				<form action="login.do" method="post">
					
					<div class="input" placeholder='Username'><input type="text" name="username"></div>
					<div id="sex" class="input" placeholder='sex'><input type="text" name="sex"></div>
					<div id="phone" class="input" placeholder='Phone'><input type="phone" name="phone"></div>
					<div id="address" class="input" placeholder='Address'><input type="text" name="address"></div>
					<div id="type" class="input" placeholder='Type'><input type="text" name="type"></div>
					<div class="input" placeholder='Password'><input type="password" name="password"></div>
					
					<span>忘记密码？</span>
					<%
						if(error!=null)
						{
							%>
							<span>用户名或密码输入错误</span>
							<% 
						}
					%>
					<button>LOGIN</button>
					
				</form>
				
			</div>
		</div>
		
		
	</div>
</body>
<script type="text/javascript" src="js/jquery-1.12.3.js"></script>
<script>
	
	$('#login').click(function(){
		$('.switch span').removeClass('active');
		$(this).addClass('active');
		
		$(this).parents('.content').removeClass('signup');
		$(this).parents('.content').addClass('login');
		
		$('form button').text('LOGIN');
		$('form').attr("action","login.do");
		console.log($('form').attr("action"));
	})
	
	$('#signup').click(function(){
		$('.switch span').removeClass('active');
		$(this).addClass('active');
		
		$(this).parents('.content').removeClass('login');
		$(this).parents('.content').addClass('signup');
		
		$('form button').text('SIGN UP');
		$('form').attr("action","regist.do");
	})
	
	$('.input input').on('focus',function(){
		$(this).parent().addClass('focus');
	})
	
	$('.input input').on('blur',function(){
		if($(this).val() === '')
			$(this).parent().removeClass('focus');
	})
	
</script>

</html>