package org.lanqiao.Iservice;

import java.util.List;

import org.lanqiao.bean.Employee;

public interface EmployeeService {
	public List<Employee> getAllEmps();
	
	public void saveEmp(Employee employee);
	
	public boolean checkUser(String empName);
	
	public Employee getEmp(Integer id) ;
	
	public void updateEmp(Employee employee);
	
	public void deleteEmp(Integer id) ;
	
	public void deleteBatch(List<Integer> ids);
}
