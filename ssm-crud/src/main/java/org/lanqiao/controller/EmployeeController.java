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
	
	
	//��Ҫ����jackson��������������ת��Ϊjson����
	@RequestMapping("/getAllEmps")
	@ResponseBody
	public Msg getEmpsWithJson(@RequestParam(value = "pn",defaultValue = "1")Integer pn) {
			//����pageHelper���
			//�ڲ�ѯ֮ǰֻ��Ҫ���������������,����ҳ���Լ�ÿһҳ�Ĵ�С
			PageHelper.startPage(pn, 5);
			//startPage��������Ĳ�ѯ����һ����ҳ��ѯ
			List<Employee> emps=employeeServiceImpl.getAllEmps();				//ʹ��pageInfo��װ��ѯ��Ľ����Ȼ��ֱ�Ӱ�pageInfo����ҳ�棬�����װ����ϸ��ҳ����Ϣ
			PageInfo page=new PageInfo(emps,5);//����������ʾ��ҳ��
			return Msg.success().add("pageInfo", page);
	}
	
	
	//Ա�����淽��
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
	
	//�����½���Ա�������Ƿ��Ѿ�����
	@ResponseBody
	@RequestMapping("/checkuser")
	public Msg checkUserName(@RequestParam("empName")String empName) {
		//�ڽ������ݿ�У��֮ǰ�������Ƚ���ǰ��У��
		String regxString="(^[a-zA-Z0-9_-]{6,16}$)|(^[\\u2E80-\\u9FFF]{2,5})";
		if(!empName.matches(regxString)) {
			return Msg.fail();
		}
		boolean result=employeeServiceImpl.checkUser(empName);
		if(result) return Msg.success();
		else return Msg.fail();
	}
	
	//��ѯ�ض�Ա��
	@ResponseBody
	@RequestMapping(value = "/emp/{id}",method = RequestMethod.GET) //��Ϊ����Ҫ�Զ�װ���������ֱ������id����
	public Msg getEmp(@PathVariable("id")Integer id) {
		Employee employee=employeeServiceImpl.getEmp(id);
		return Msg.success().add("emp", employee);
	}
	
	//�޸��ض�Ա��
	//tomcat�����װPUT�������е�����Ϊmap��������getparameter�ķ���Ҳ�ò�������
	//ֻ��POST�������������ܷ�װΪmap
	@ResponseBody
	@RequestMapping(value = "/emp/{empId}",method = RequestMethod.PUT)//��Ҫ�Զ�װ�����ʱ���ǵ�idҪ��Ϊ��bean�����ֵһ��
	public Msg updateEmp(Employee employee) {
		employeeServiceImpl.updateEmp(employee);
		return Msg.success();
	}
	
	//ɾ���ض�idԱ��
	//���Ե���ɾ����Ҳ��������ɾ��
	//����ɾ����1-2-3
	//����ɾ����1
	@ResponseBody
	@RequestMapping(value = "/emp/{ids}",method = RequestMethod.DELETE)
	public Msg deleteEmpById(@PathVariable("ids")String ids) {
		if(ids.contains("-")) {
			//����ɾ��
			List<Integer> del_ids=new ArrayList<Integer>();
			String[] str_ids = ids.split("-");
			//��װid����
			for (String string : str_ids) {
				del_ids.add(Integer.parseInt(string));
			}
			employeeServiceImpl.deleteBatch(del_ids);
		}else {
			//����ɾ��
			Integer id=Integer.parseInt(ids);
			employeeServiceImpl.deleteEmp(id);
		}
		return Msg.success();
	}
	
//	@RequestMapping("/getAllEmps")
//	public String getAllEmps(@RequestParam(value = "pn",defaultValue = "1")Integer pn,Model model) {
//		//����pageHelper���
//		//�ڲ�ѯ֮ǰֻ��Ҫ���������������,����ҳ���Լ�ÿһҳ�Ĵ�С
//		PageHelper.startPage(pn, 5);
//		//startPage��������Ĳ�ѯ����һ����ҳ��ѯ
//		List<Employee> emps=employeeServiceImpl.getAllEmps();
//		//ʹ��pageInfo��װ��ѯ��Ľ����Ȼ��ֱ�Ӱ�pageInfo����ҳ�棬�����װ����ϸ��ҳ����Ϣ
//		PageInfo page=new PageInfo(emps,5);//����������ʾ��ҳ��
//		model.addAttribute("pageInfo", page);
//		return "list";
//	}
}
