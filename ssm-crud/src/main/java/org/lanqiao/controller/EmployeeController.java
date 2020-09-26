package org.lanqiao.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.lanqiao.bean.Employee;
import org.lanqiao.bean.Msg;
import org.lanqiao.service.impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeServiceImpl employeeServiceImpl;
	
	
	//需要导入jackson包，用来将对象转换为json对象
	@RequestMapping("/getAllEmps")
	@ResponseBody
	public Msg getEmpsWithJson(@RequestParam(value = "pn",defaultValue = "1")Integer pn) {
			//引入pageHelper插件
			//在查询之前只需要调用下面这个方法,传入页码以及每一页的大小
			PageHelper.startPage(pn, 5);
			//startPage后面紧跟的查询就是一个分页查询
			List<Employee> emps=employeeServiceImpl.getAllEmps();				//使用pageInfo包装查询后的结果，然后直接把pageInfo交给页面，里面封装了详细的页面信息
			PageInfo page=new PageInfo(emps,5);//传入连续显示的页数
			return Msg.success().add("pageInfo", page);
	}
	
	
	//员工保存方法
	@RequestMapping(value="/saveEmp",method = RequestMethod.POST)
	@ResponseBody
	public Msg saveEmp(@Valid Employee employee,BindingResult result)
	{
		if(result.hasErrors()) {
			Map<String, Object> map=new HashMap<String, Object>();
			List<FieldError> errors = result.getFieldErrors();
			for (FieldError fieldError : errors) {
				map.put(fieldError.getField(),fieldError.getDefaultMessage());
			}
			return Msg.fail().add("errorFields", map);
		}else {
			employeeServiceImpl.saveEmp(employee);
			return Msg.success();
		}
	}
	
	//检验新建的员工姓名是否已经存在
	@ResponseBody
	@RequestMapping("/checkuser")
	public Msg checkUserName(@RequestParam("empName")String empName) {
		//在进行数据库校验之前，可以先进行前端校验
		String regxString="(^[a-zA-Z0-9_-]{6,16}$)|(^[\\u2E80-\\u9FFF]{2,5})";
		if(!empName.matches(regxString)) {
			return Msg.fail();
		}
		boolean result=employeeServiceImpl.checkUser(empName);
		if(result) return Msg.success();
		else return Msg.fail();
	}
	
	//查询特定员工
	@ResponseBody
	@RequestMapping(value = "/emp/{id}",method = RequestMethod.GET) //因为不需要自动装配对象，所以直接引入id就行
	public Msg getEmp(@PathVariable("id")Integer id) {
		Employee employee=employeeServiceImpl.getEmp(id);
		return Msg.success().add("emp", employee);
	}
	
	//修改特定员工
	//tomcat不会封装PUT请求体中的数据为map，所以用getparameter的方法也拿不到数据
	//只有POST请求的请求体才能封装为map
	@ResponseBody
	@RequestMapping(value = "/emp/{empId}",method = RequestMethod.PUT)//当要自动装配对象时，记得id要改为和bean里面的值一样
	public Msg updateEmp(Employee employee) {
		employeeServiceImpl.updateEmp(employee);
		return Msg.success();
	}
	
	//删除特定id员工
	//可以单个删除，也可以批量删除
	//批量删除：1-2-3
	//单个删除：1
	@ResponseBody
	@RequestMapping(value = "/emp/{ids}",method = RequestMethod.DELETE)
	public Msg deleteEmpById(@PathVariable("ids")String ids) {
		if(ids.contains("-")) {
			//批量删除
			List<Integer> del_ids=new ArrayList<Integer>();
			String[] str_ids = ids.split("-");
			//组装id集合
			for (String string : str_ids) {
				del_ids.add(Integer.parseInt(string));
			}
			employeeServiceImpl.deleteBatch(del_ids);
		}else {
			//单个删除
			Integer id=Integer.parseInt(ids);
			employeeServiceImpl.deleteEmp(id);
		}
		return Msg.success();
	}
	
//	@RequestMapping("/getAllEmps")
//	public String getAllEmps(@RequestParam(value = "pn",defaultValue = "1")Integer pn,Model model) {
//		//引入pageHelper插件
//		//在查询之前只需要调用下面这个方法,传入页码以及每一页的大小
//		PageHelper.startPage(pn, 5);
//		//startPage后面紧跟的查询就是一个分页查询
//		List<Employee> emps=employeeServiceImpl.getAllEmps();
//		//使用pageInfo包装查询后的结果，然后直接把pageInfo交给页面，里面封装了详细的页面信息
//		PageInfo page=new PageInfo(emps,5);//传入连续显示的页数
//		model.addAttribute("pageInfo", page);
//		return "list";
//	}
}
