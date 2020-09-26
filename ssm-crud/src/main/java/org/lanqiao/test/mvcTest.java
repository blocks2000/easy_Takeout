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

//ʹ��spring����ģ���ṩ�Ĳ��������ܣ�����crud�������ȷ��
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:applicationContext.xml","classpath:applicationContext-controller.xml"})
public class mvcTest {

	//����springMvc��IOC
	@Autowired
	WebApplicationContext context;
	//����mvc���󣬻�ȡ������
	MockMvc mockMvc;
	private int[] nums;
	
	@Before
	public void initMockMvc() {
		mockMvc=MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	@Test
	public void testPage() throws Exception {
		//ģ�������õ�����ֵ
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/getAllEmps").param("pn", "5")).andReturn();
		//����ɹ��Ժ��������л���pageInfo,ȡ��pageInfo������֤
		MockHttpServletRequest request = result.getRequest();
		PageInfo pi = (PageInfo)request.getAttribute("pageInfo");
		System.out.println("��ǰҳ��:"+pi.getPageNum());
		System.out.println("��Ҳ������"+pi.getPages());
		System.out.println("�ܼ�¼����"+pi.getTotal());
		System.out.println("��ҳ����Ҫ������ʾ��ҳ��");
		int[] nums = pi.getNavigatepageNums();
		for (int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}
		
		//��ȡԱ������
		List<Employee> list=pi.getList();
		for(Employee employee:list) {
			System.out.println("ID"+employee.getEmpId()+"===>Name:"+employee.getEmpName());
		}
	}
}
