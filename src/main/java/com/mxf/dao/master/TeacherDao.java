package com.mxf.dao.master;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.mxf.bean.Teacher;

/**
 * @author moxiaofei
 * @date 2017年12月13日 下午6:10:55
 * 				教师Dao接口类
 * 使用@Select注解可以大大简化mapper.xml的配置
 */
public interface TeacherDao {
	//根据教师名获取用户信息
	@Select("select * from teacher where name = #{name} ")
	Teacher findByName(@Param("name")String name);
}
