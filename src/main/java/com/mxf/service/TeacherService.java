package com.mxf.service;

import com.mxf.bean.Teacher;

public interface TeacherService {
	//根据教师名获取用户信息
	Teacher findByName(String name);
}
