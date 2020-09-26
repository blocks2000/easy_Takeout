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

//����Ͳ����й���Ϣ��controller
@Controller
public class deptController {
	
	@Autowired
	private DepartmentServiceImpl departmentServiceImpl;
	
	@RequestMapping("/depts")
	@ResponseBody //���Զ����ַ���������Ϊjson��ʽ�����Բ�������д����
	public Msg getDepts() {
		List<department> list=departmentServiceImpl.getDepts();
		return Msg.success().add("depts", list);
	}
}
