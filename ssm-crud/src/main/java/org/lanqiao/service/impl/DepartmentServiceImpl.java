package org.lanqiao.service.impl;

import java.util.List;

import org.lanqiao.Iservice.DepartmentService;
import org.lanqiao.bean.department;
import org.lanqiao.mapper.departmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private departmentMapper departmentMapper;
	
	public List<department> getDepts() {
		return departmentMapper.selectByExample(null);
	}

}
