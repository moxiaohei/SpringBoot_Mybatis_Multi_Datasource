package com.mxf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * @author moxiaofei
 * @date 2017年12月13日 下午9:13:18
 * @MapperScan():扫描指定包下的所有接口类并注册
 */
@SpringBootApplication
@MapperScan("com.mxf.dao")
public class App {
	
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
	
}
