package org.lanqiao.service.impl;

import java.util.List;

import org.lanqiao.Iservice.EmployeeService;
import org.lanqiao.bean.Employee;
import org.lanqiao.bean.EmployeeExample;
import org.lanqiao.bean.EmployeeExample.Criteria;
import org.lanqiao.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeMapper employeeMapper;
	
	//获取数据库中保存的所有用户
	public List<Employee> getAllEmps(){
		return employeeMapper.selectByExampleWithDept(null);
	}

	//插入新用户
	public void saveEmp(Employee employee) {
		 employeeMapper.insertSelective(employee);
		
	}

	//检验新建的用户名是否可用
	public boolean checkUser(String empName) {
		EmployeeExample example=new EmployeeExample();
		Criteria criteria = example.createCriteria();
		criteria.andEmpNameEqualTo(empName);
		long count=employeeMapper.countByExample(example);
		return count==0;
	}

	//查询特定id值的用户
	public Employee getEmp(Integer id) {
		Employee employee = employeeMapper.selectByPrimaryKey(id);
		return employee;
	}

	public void updateEmp(Employee employee) {
		// TODO Auto-generated method stub
		employeeMapper.updateByPrimaryKeySelective(employee);
	}

	//删除特定id的员工
	public void deleteEmp(Integer id) {
		// TODO Auto-generated method stub
		employeeMapper.deleteByPrimaryKey(id);
	}

	//批量删除员工
	public void deleteBatch(List<Integer> ids) {
		// TODO Auto-generated method stub
		EmployeeExample example=new EmployeeExample();
		Criteria criteria=example.createCriteria();
		//delete from xxx where empId in(1,2,3...)
		criteria.andEmpIdIn(ids);
		employeeMapper.deleteByExample(example);
	}

	
	


}
