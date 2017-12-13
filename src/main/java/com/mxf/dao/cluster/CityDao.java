package com.mxf.dao.cluster;

import org.apache.ibatis.annotations.Select;

import com.mxf.bean.City;

/**
 * @author moxiaofei
 * @date 2017年12月13日 下午6:12:31
 * 		city接口类
 */
public interface CityDao {
	//根据城市名称查询城市信息
	@Select("select * from city where cname = #{cname} ")
	City findByName(String cname);
}
