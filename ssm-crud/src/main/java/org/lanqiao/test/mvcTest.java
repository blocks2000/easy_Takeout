package org.lanqiao.test;

import java.util.Iterator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.lanqiao.bean.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.github.pagehelper.PageInfo;

//使用spring测试模块提供的测试请求功能，测试crud请求的正确性
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:applicationContext.xml","classpath:applicationContext-controller.xml"})
public class mvcTest {

	//传入springMvc的IOC
	@Autowired
	WebApplicationContext context;
	//虚拟mvc请求，获取处理结果
	MockMvc mockMvc;
	private int[] nums;
	
	@Before
	public void initMockMvc() {
		mockMvc=MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	@Test
	public void testPage() throws Exception {
		//模拟请求拿到返回值
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/getAllEmps").param("pn", "5")).andReturn();
		//请求成功以后，请求域中会有pageInfo,取出pageInfo进行验证
		MockHttpServletRequest request = result.getRequest();
		PageInfo pi = (PageInfo)request.getAttribute("pageInfo");
		System.out.println("当前页码:"+pi.getPageNum());
		System.out.println("总也码数："+pi.getPages());
		System.out.println("总记录数："+pi.getTotal());
		System.out.println("在页面需要连续显示的页数");
		int[] nums = pi.getNavigatepageNums();
		for (int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}
		
		//获取员工数据
		List<Employee> list=pi.getList();
		for(Employee employee:list) {
			System.out.println("ID"+employee.getEmpId()+"===>Name:"+employee.getEmpName());
		}
	}
}
