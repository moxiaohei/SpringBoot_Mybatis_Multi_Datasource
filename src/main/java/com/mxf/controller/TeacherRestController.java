package com.mxf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mxf.bean.Teacher;
import com.mxf.service.TeacherService;

/**
 * @author moxiaofei
 * @date 2017年12月13日 下午9:09:44
 * 			Controller类
 */
@RestController
@RequestMapping("teacher")
public class TeacherRestController {
	
	@Autowired
	private TeacherService service;
	
	@GetMapping("/getTeacher")
	public Teacher getTeacher(@RequestParam(value="name",required=true)String name){
		return service.findByName(name);
	}
	
}
