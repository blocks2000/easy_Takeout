package org.lanqiao.controller;

import java.util.List;

import org.lanqiao.Iservice.EmployeeService;
import org.lanqiao.bean.Msg;
import org.lanqiao.bean.department;
import org.lanqiao.mapper.EmployeeMapper;
import org.lanqiao.service.impl.DepartmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//处理和部门有关信息的controller
@Controller
public class deptController {
	
	@Autowired
	private DepartmentServiceImpl departmentServiceImpl;
	
	@RequestMapping("/depts")
	@ResponseBody //会自动把字符串解析成为json格式，所以不能忘记写上了
	public Msg getDepts() {
		List<department> list=departmentServiceImpl.getDepts();
		return Msg.success().add("depts", list);
	}
}
