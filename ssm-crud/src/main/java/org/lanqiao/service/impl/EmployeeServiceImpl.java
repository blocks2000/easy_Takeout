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
	
	//��ȡ���ݿ��б���������û�
	public List<Employee> getAllEmps(){
		return employeeMapper.selectByExampleWithDept(null);
	}

	//�������û�
	public void saveEmp(Employee employee) {
		 employeeMapper.insertSelective(employee);
		
	}

	//�����½����û����Ƿ����
	public boolean checkUser(String empName) {
		EmployeeExample example=new EmployeeExample();
		Criteria criteria = example.createCriteria();
		criteria.andEmpNameEqualTo(empName);
		long count=employeeMapper.countByExample(example);
		return count==0;
	}

	//��ѯ�ض�idֵ���û�
	public Employee getEmp(Integer id) {
		Employee employee = employeeMapper.selectByPrimaryKey(id);
		return employee;
	}

	public void updateEmp(Employee employee) {
		// TODO Auto-generated method stub
		employeeMapper.updateByPrimaryKeySelective(employee);
	}

	//ɾ���ض�id��Ա��
	public void deleteEmp(Integer id) {
		// TODO Auto-generated method stub
		employeeMapper.deleteByPrimaryKey(id);
	}

	//����ɾ��Ա��
	public void deleteBatch(List<Integer> ids) {
		// TODO Auto-generated method stub
		EmployeeExample example=new EmployeeExample();
		Criteria criteria=example.createCriteria();
		//delete from xxx where empId in(1,2,3...)
		criteria.andEmpIdIn(ids);
		employeeMapper.deleteByExample(example);
	}

	
	


}
