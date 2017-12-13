package com.mxf.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mxf.bean.City;
import com.mxf.bean.Teacher;
import com.mxf.dao.cluster.CityDao;
import com.mxf.dao.master.TeacherDao;
import com.mxf.service.TeacherService;

/**
 * @author moxiaofei
 * @date 2017年12月13日 下午9:10:18
 * 		@Service表示这是一个服务层的类
 * 注入两个对象：TeacherDao & CityDao。
 * 由于数据源有多个，所以不能做关联查询，只能分别查询出信息，再将一个类的信息作为属性设置进
 * 另外一个类中去
 */
@Service
public class TeacherServiceImpl implements TeacherService{

	@Autowired
	private TeacherDao teacherDao;
	
	@Autowired
	private CityDao cityDao;
	
	@Override
	public Teacher findByName(String name) {
		Teacher teacher = teacherDao.findByName(name);
		City city = cityDao.findByName("西安");
		teacher.setCity(city);
		return teacher;
	}
		
}
