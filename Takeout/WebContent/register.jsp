<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 <form action="../regist.do" method="post">	<!-- 相对路径 -->
		<table>
			<tr>
				<td>用户名：</td>
				<td>
					<input type="text" name="username" />
				</td>
			</tr>
			<tr>
				<td>密码：</td>
				<td>
					<input type="password" name="password" />
				</td>
			</tr>
			<tr>
				<td>电话：</td>
				<td>
					<input type="text" name="phone" />
				</td>
			</tr>
			<tr>
				<td>地址：</td>
				<td>
					<input type="text" name="address" />
				</td>
			</tr>
			<tr>
				<td>性别：</td>
				<td>
					<input type="radio" name="sex" />
				</td>
			</tr>
			<tr>
				<td>类型：</td>
				<td>
					<input type="text" name="type" />
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="reset" value="重置" />
					<input type="submit" value="确定" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>