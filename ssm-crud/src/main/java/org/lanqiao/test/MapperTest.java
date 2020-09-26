package org.lanqiao.test;

import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.lanqiao.bean.Employee;
import org.lanqiao.bean.department;
import org.lanqiao.mapper.EmployeeMapper;
import org.lanqiao.mapper.departmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml","classpath:applicationContext-controller.xml"})
public class MapperTest {
	
	@Autowired
	departmentMapper departmentMapper;
	
	@Autowired
	EmployeeMapper employeeMapper;
	
	@Autowired
	SqlSession sqlsession;
	
	@Test
	public void testCRUD() {
		//System.out.println(departmentMapper);
		//departmentMapper.insertSelective(new department(1, "开发部"));
		//departmentMapper.insertSelective(new department(0, "测试部"));
		
		//employeeMapper.insertSelective(new Employee(0, "zs", "m", "1600", 1));
		//employeeMapper.insertSelective(new Employee(0, "ls", "m", "121", 2));
	
		EmployeeMapper mapper=sqlsession.getMapper(EmployeeMapper.class);
		for(int i=1;i<1000;i++)
		{
			String uid=UUID.randomUUID().toString().substring(0, 5)+i;
			mapper.insertSelective(new Employee(i, uid, "m", uid+"@qq.com", 1));
			//System.out.println("插入一个成功");
		}
		System.out.println("批量完成");
	}
}
