<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>员工列表</title>

<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<script type="text/javascript"
	src="${APP_PATH }/static/js/jquery-3.5.1.min.js"></script>
<script type="text/javascript"
	src="${APP_PATH }/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<!-- js的引入都必须以script开头，src开始，跟css的引入不同，css是以link开头 -->
<link
	href="${APP_PATH }/static/bootstrap-3.3.7-dist/css/bootstrap.min.css"
	rel="stylesheet">
<!--千万不要忘了rel后面的句子-->
</head>
<body>

<!-- 员工修改的模态框 -->
	<div class="modal fade" id="empUpdateModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" >员工修改</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal">
						<div class="form-group">
							<label class="col-sm-2 control-label">empName</label>
							<div class="col-sm-10">
								<p class="form-control-static" id="empName_update_static"></p>
							</div>
						</div>
						<div class="form-group">
							<label  class="col-sm-2 control-label">email</label>
							<div class="col-sm-10">
								<input type="text" name="email" class="form-control" id="email_update_input"
									placeholder="eamil@qq.com">
								<span class="help-block"></span>
							</div>
						</div>
						<div class="form-group">
							<label  class="col-sm-2 control-label">gender</label>
							<div class="col-sm-10">
								<label class="radio-inline">
									<input type="radio" name="gender" id="gender1_update_input" value="m" checked="checked">男
								</label>
								<label class="radio-inline">
									<input type="radio" name="gender" id="gender2_update_input" value="f">女
								</label>
							</div>
						</div>
						<div class="form-group">
							<label  class="col-sm-2 control-label">deptName</label>
							<div class="col-sm-4">
								<select class="form-control" name="dId" id="dept_add_select">
								
								</select>
							</div>
						</div>
					</form>

				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" id="emp_update_btn">更新</button>
				</div>
			</div>
		</div>
	</div>


	<!-- 员工添加的模态框 -->
	<div class="modal fade" id="empAddModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">员工添加</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal">
						<div class="form-group">
							<label class="col-sm-2 control-label">empName</label>
							<div class="col-sm-10">
								<input type="text" name="empName" class="form-control" id="empName_add_input"
									placeholder="empName">
								<span class="help-block"></span>
							</div>
						</div>
						<div class="form-group">
							<label  class="col-sm-2 control-label">email</label>
							<div class="col-sm-10">
								<input type="text" name="email" class="form-control" id="email_add_input"
									placeholder="eamil@qq.com">
								<span class="help-block"></span>
							</div>
						</div>
						<div class="form-group">
							<label  class="col-sm-2 control-label">gender</label>
							<div class="col-sm-10">
								<label class="radio-inline">
									<input type="radio" name="gender" id="gender1_add_input" value="m" checked="checked">男
								</label>
								<label class="radio-inline">
									<input type="radio" name="gender" id="gender2_add_input" value="f">女
								</label>
							</div>
						</div>
						<div class="form-group">
							<label  class="col-sm-2 control-label">deptName</label>
							<div class="col-sm-4">
								<select class="form-control" name="dId" id="dept_add_select">
								
								</select>
							</div>
						</div>
					</form>

				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" id="emp_save_btn">保存</button>
				</div>
			</div>
		</div>
	</div>
	<!-- 搭建显示页面 -->

	<div class="container">
		<!-- 标题 -->
		<div class="row">
			<div class="col-md-12">
				<h1>SSM-CRUD</h1>
			</div>
		</div>
		<!-- 按钮 -->
		<div class="row">
			<div class="col-md-4 col-md-offset-8">
				<button class="btn btn-primary" id="emp_add_modal_btn">新增</button>
				<button class="btn btn-danger" id="emp_delete_all_btn">删除</button>
			</div>
		</div>
		<!-- 显示表格数据 -->
		<div class="row">
			<div class="col-md-12">
				<table class="table table-hover" id="emps_table">
					<thead>
						<tr>
							<th>
								<input type="checkbox" id="check_all"/>
							</th>
							<th>#</th>
							<th>empName</th>
							<th>gender</th>
							<th>email</th>
							<th>deptName</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>

					</tbody>
				</table>
			</div>
		</div>
		<!-- 显示分页信息 -->
		<div class="row">
			<!-- 分页文字信息 -->
			<div class="col-md-6" id="page_info">当前第页，总页，记录数</div>
			<!-- 分页条信息 -->
			<div class="col-md-6" id="page_nav"></div>
		</div>
	</div>

	<script type="text/javascript">
		var currentPage;
		var totalRecord;//总记录数
		//页面加载完以后，直接去发送ajax请求，要到分页数据
		$(function() {
			to_page(1);
		});

		function to_page(pn) {
			$.ajax({
				url : "${APP_PATH}/getAllEmps",
				data : "pn=" + pn,
				type : "GET",//get要大写
				success : function(result) {
					//解析并显示员工数据
					build_emps_table(result);
					//解析并显示分页信息
					build_page_nav(result);
					build_page_info(result);
				}
			});
		}

		//显示员工表格信息
		function build_emps_table(result) {
			$("#emps_table tbody").empty();
			var emps = result.extend.pageInfo.list;
			$.each(emps, function(index, item) {
				//alert(item.empName);
				var checkBoxTd=$("<td><input type='checkbox' class='check_item' /></td>");
				var empIdTd = $("<td></td>").append(item.empId);
				var empNameTd = $("<td></td>").append(item.empName);
				var gender = item.gender == "m" ? "男" : "女";
				var genderTd = $("<td></td>").append(gender);
				var emilTd = $("<td></td>").append(item.email);
				var DeptNameTd = $("<td></td>")
						.append(item.department.deptName);
				var editBtn = $("<button></button>").addClass(
						"btn btn-primary btn-sm edit_btn").append(
						$("<span></span>").addClass(
								"glyphicon glyphicon-pencil")).append("编辑");
				editBtn.attr("edit-id",item.empId);
				var deleteBtn = $("<button></button>").addClass(
						"btn btn-danger btn-sm delete_btn").append(
						$("<span></span>")
								.addClass("glyphicon glyphicon-trash")).append(
						"删除");
				deleteBtn.attr("del-id",item.empId);
				var btnTd = $("<td></td>").append(editBtn).append(" ").append(
						deleteBtn);
				$("<tr></tr>").append(checkBoxTd).append(empIdTd).append(empNameTd).append(
						genderTd).append(emilTd).append(DeptNameTd).append(
						btnTd).appendTo("#emps_table tbody");
			});
		}

		//解析显示分页条
		function build_page_nav(result) {
			$("#page_nav").empty();
			var ul = $("<ul></ul>").addClass("pagination");
			var firstPageLi = $("<li></li>").append(
					$("<a></a>").append("首页").attr("href", "#"));
			var prePage = $("<li></li>").append($("<a></a>").append("&laquo;"));

			if (result.extend.pageInfo.hasPreviousPage == false) {
				firstPageLi.addClass("disabled");
				prePage.addClass("disabled");
			} else {
				//给前一页和首页添加点击事件
				//有上一页，才绑定点击事件
				firstPageLi.click(function() {
					to_page(1);
				})

				prePage.click(function() {
					to_page(result.extend.pageInfo.pageNum - 1);
				})
			}

			var backPage = $("<li></li>")
					.append($("<a></a>").append("&raquo;"));
			var lsatPageLi = $("<li></li>").append(
					$("<a></a>").append("末页").attr("href", "#"));

			if (result.extend.pageInfo.hasNextPage == false) {
				backPage.addClass("disabled");
				lsatPageLi.addClass("disabled");
			} else {
				//给下一页和末页添加点击事件
				//有下一页，才绑定点击事件
				backPage.click(function() {
					to_page(result.extend.pageInfo.pageNum + 1);
				})
				lsatPageLi.click(function() {
					to_page(result.extend.pageInfo.pages);
				})
			}

			//添加首页和前一页的提示
			ul.append(firstPageLi).append(prePage);
			//遍历给ul添加页码提示
			$.each(result.extend.pageInfo.navigatepageNums, function(index,
					item) {
				var numLi = $("<li></li>").append($("<a></a>").append(item));
				if (result.extend.pageInfo.pageNum == item)
					numLi.addClass("active");
				numLi.click(function() {
					to_page(item);
				});
				ul.append(numLi);
			})
			//最后添加末页和下一页的提示
			ul.append(backPage).append(lsatPageLi);
			//把ul添加到nav标签中
			var navEle = $("<nav></nav>").append(ul);
			navEle.appendTo("#page_nav");
		}

		//解析显示分页信息
		function build_page_info(result) {
			$("#page_info").empty();
			$("#page_info").append(
					"当前第" + result.extend.pageInfo.pageNum + "页,"
							+ result.extend.pageInfo.pages + "总页，"
							+ result.extend.pageInfo.total + "记录数");
			totalRecord=result.extend.pageInfo.total;
			currentPage=result.extend.pageInfo.pageNum;
		}
		
		//完整的重置表单方法
		function reset_form(ele){
			$(ele)[0].reset();//重置表单内容
			//DOM才有reset方法，所以记得添加上[0],取出DOM对象
			$(ele).find("*").removeClass("has-error has-success");
			$(ele).find(".help-block").text("");//找到特定class的标签
		}

		//点击新增按钮弹出模态框
		$("#emp_add_modal_btn").click(function() {
			//清除表单数据，表单完整重置（数据和样式）
			reset_form("#empAddModal form" );
			//发送ajax请求，把部门信息显示在下拉列表中
			getDepts("#empAddModal select");
			
			//弹出模态框
			$("#empAddModal").modal({
				backdrop : "static"
			});
		})
		
		//查出所有的部门信息
		function getDepts(ele){
			//每次显示之前，都要清空下拉列表的值
			$(ele).empty();
			$.ajax({
				url:"${APP_PATH}/depts",
				type:"GET",
				success:function(result){
					$.each(result.extend.depts,function(){
						var optionEle=$("<option></option>").append(this.deptName).attr("value",this.deptId);
						optionEle.appendTo(ele);
					});
				}
			});//分号一定记着写上
		}
		
		//添加用户时，如果用户名表格发生变化，则发送ajax请求，检查数据库中用户名是否已经存在
		$("#empName_add_input").change(function(){
			var empName=this.value;
			var successString="用户名可用";
			var errorString="用户名不可用";
			$.ajax({
				url:"${APP_PATH}/checkuser",
				data:"empName="+empName,
				type:"POST",
				success:function(result){
					if(result.code==100){
						show_validate_msg("#empName_add_input","success",successString);
						$("#emp_save_btn").attr("ajax-va","success");
					}
					else{
						show_validate_msg("#empName_add_input","error",errorString);
						$("#emp_save_btn").attr("ajax-va","error");
					}
				}
			});
		});
		
		//校验员工数据
		function validate_add_form(){
			//1.拿到要校验的数据 
			//校验员工姓名
			var empName=$("#empName_add_input").val();
			var regName=/(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{2,5})/;
			if(!regName.test(empName)){
				//alert("用户名可以是6-16位的英文，或者2-5位中文");
				var errorString="用户名必须是6-16位的英文，或者2-5位中文";
				show_validate_msg("#empName_add_input","error",errorString);
				return false;
			}else{
				show_validate_msg("#empName_add_input","success","");
			}
			//校验邮箱
			var email=$("#email_add_input").val();
			var regEmail=/^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
			if(!regEmail.test(email)){
				//alert("邮箱格式不正确");
				var errorStringE="邮箱格式不正确";
				show_validate_msg("#email_add_input","error",errorStringE);
				return false;
			}else{
				show_validate_msg("#email_add_input","success","");
			}
			return true; 
		}
		
		
		//将校验效果显示封装成函数
		function show_validate_msg(ele,status,msg){//直接把对象，状态和信息传过来
			$(ele).parent().removeClass("has-success has-error"); //每次都应该先清空之前的元素样式
			$(ele).next("span").text(""); //每次都应该清空span标签内的内容
			if(status=="success"){
				$(ele).parent().addClass("has-success");
				$(ele).next("span").text(msg);
			}else if(status=="error"){
				$(ele).parent().addClass("has-error");
				$(ele).next("span").text(msg);
			}
		}
		
		//点击保存员工
		$("#emp_save_btn").click(function(){
			//先对要提交给服务器的数据进行校验,前端校验
			if(!validate_add_form()){
				return false;
			}
			
			if($(this).attr("ajax-va")=="error"){//检查保存按钮的ajax-va属性是否为success
				return false;//后端也需校验一遍
			}
			$.ajax({
				url:"${APP_PATH}/saveEmp",
				type:"POST",
				data: $("#empAddModal form").serialize(),//表单序列化
				success:function(result){
					if(result.code==100){
						//员工保存成功后，关闭对话框
						//来到最后一页，显示保存的数据
						$("#empAddModal").modal("hide"); 
						to_page(totalRecord);
					}else{
						//失败后显示失败信息，jsr303校验,用户即使绕过前端校验，也不能进行操作
						if(undefined!=result.extend.errorFields.email){
							//显示邮箱错误信息
							show_validate_msg("#email_add_input","error",result.extend.errorFields.email);
						}
						if(undefined!=result.extend.errorFields.empName){
							//显示员工名错误信息
							show_validate_msg("#empName_add_input","error",result.extend.errorFields.empName);
						}
						
					}
				}
			});
		});
		
		//1.我们是按钮创建之前就绑定了click,所以用（..）.click(function())绑定不上
		//1，可以在创建按钮时绑定，但是这样会导致代码特别的混乱和复杂，不好管理
		//2.绑定点击.live()，但是jquery新版没有live，使用on进行代替，并且要为整个文本对象绑定
		$(document).on("click",".edit_btn",function(){
			//查出部门信息，并显示列表
			getDepts("#empUpdateModal select");
			//查出员工信息，并显示
			getEmp($(this).attr("edit-id"));
			//为更新按钮添加上员工id
			$("#emp_update_btn").attr("edit-id",$(this).attr("edit-id"));
			//弹出模态框
			$("#empUpdateModal").modal({
				backdrop:"static"
			});
		});
		
		//单个删除
		$(document).on("click",".delete_btn",function(){
			//弹出是否删除信息框
			var empName=$(this).parents("tr").find("td:eq(2)").text();
			var empId=$(this).attr("del-id");
			if(confirm("确认删除【"+empName+"】吗？")){
				$.ajax({
					url:"${APP_PATH}/emp/"+empId,
					type:"DELETE",
					success:function(result){
						alert(result.msg);
						//回到本页
						to_page(currentPage);
					}
				});
			}
		});
		
		//查出对应的员工信息
		function getEmp(id){
			$.ajax({
				url:"${APP_PATH}/emp/"+id,
				type:"GET",
				success:function(result){
					var empData=result.extend.emp;
					$("#empName_update_static").text(empData.empName);
					$("#email_update_input").val(empData.email);
					$("#empUpdateModal input[name=gender]").val([empData.gender]);
					$("#empUpdateModal select").val([empData.dId]);//每个option选项的value值就是部门id号
				}
			});
		}
		
		$("#emp_update_btn").click(function(){
			//先验证邮箱是否合法
			var email=$("#email_update_input").val();
			var regEmail=/^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
			if(!regEmail.test(email)){
				//alert("邮箱格式不正确");
				var errorStringE="邮箱格式不正确";
				show_validate_msg("#email_update_input","error",errorStringE);
				return false;
			}else{
				show_validate_msg("#email_update_input","success","");
			}
			
			//发送ajax请求，更新员工数据
			$.ajax({
				url:"${APP_PATH}/emp/"+$(this).attr("edit-id"),
				type:"PUT",
				data:$("#empUpdateModal form").serialize(),
				success:function(result){
					//关闭模态框，回到本页面
					$("#empUpdateModal").modal("hide");
					to_page(currentPage);
				}
			});
		});
		
		//完成全选和全不选功能
		$("#check_all").click(function(){
			//attr获取自定义的值，prop修改和读取原生dom属性值
			$(".check_item").prop("checked",$(this).prop("checked"));
		});
		
		//因为每一个单独的checkbox是后来动态添加的，所以要用document来执行
		$(document).on("click",".check_item",function(){
			//判断当前选中的元素是否为所有的checkbox个数
			var flag=$(".check_item:checked").length==$(".check_item").length;
			//若全选中，则check_all的prop值为true
			$("#check_all").prop("checked",flag);
		});
		
		//点击全部删除按钮时，就批量删除
		$("#emp_delete_all_btn").click(function(){
			var empNames="";
			var del_idstr="";
			//组装员工id字符串
			$.each($(".check_item:checked"),function(){
				empNames+=$(this).parents("tr").find("td:eq(2)").text()+",";
				del_idstr+=$(this).parents("tr").find("td:eq(1)").text()+"-";
			});
			empNames=empNames.substring(0,empNames.length-1);
			del_idstr=del_idstr.substring(0,del_idstr.length-1);
			if(confirm("确认删除【"+empNames+"】吗?")){
				//发送ajax请求
				$.ajax({
					url:"${APP_PATH}/emp/"+del_idstr,
					type:"DELETE",
					success:function(result){
						alert(result.msg);
						to_page(currentPage);
					}
				});
			}
		});
		</script>
</body>
</html>