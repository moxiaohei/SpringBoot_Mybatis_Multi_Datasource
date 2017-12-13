package com.mxf.bean;

/**
 * @author moxiaofei
 * @date 2017年12月13日 下午9:04:17
 * 		Teacher实体类
 * 	注：其里面持有City对象
 */
public class Teacher {
	
	private Integer id;
	private String name;
	private String password;
	
	private City city;
	
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
