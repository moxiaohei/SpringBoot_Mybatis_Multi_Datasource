package com.mxf.config.ds;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * @author moxiaofei
 * @date 2017年12月13日 下午9:05:36 DataSource的管理 其中涉及连接数据库连接池(DataSource)，
 *       开启事务管理(DataSourceTransactionManager)， 开启连接池管理类(SqlSessionFactory).
 *       注：@Primary注解表示该方法是主要的
 */
@Configuration
// 扫描mapper接口并容器管理
@MapperScan(basePackages = "com.mxf.dao.master", sqlSessionFactoryRef = "masterSqlSessionFactory")
public class MasterDataSourceConfig {
	// 精确到 master 目录，以便跟其他数据源隔离
	// static final String PACKAGE = "com.mxf.dao.master";
	// static final String MAPPER_LOCATION = "classpath:mapper/master/*.xml";

	@Value("${master.datasource.url}")
	private String url;
	@Value("${master.datasource.username}")
	private String username;
	@Value("${master.datasource.password}")
	private String password;
	@Value("${master.datasource.driverclass}")
	private String driverclass;

	// 获取数据连接池
	@Bean(name = "masterDataSource")
	@Primary
	public DataSource masterDataSource() {
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		dataSource.setDriverClassName(driverclass);
		return dataSource;
	}

	// 开启事务管理，需要数据源
	@Bean(name = "masterTransactionManager")
	@Primary
	public DataSourceTransactionManager masterTransactionManager() {
		return new DataSourceTransactionManager(masterDataSource());
	}

	@Bean(name = "masterSqlSessionFactory")
	@Primary
	public SqlSessionFactory masterSqlSessionFactory(@Qualifier("masterDataSource") DataSource masterDataSource)
			throws Exception {
		final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(masterDataSource);
		// sessionFactory.setMapperLocations(new
		// PathMatchingResourcePatternResolver()
		// .getResources(MasterDataSourceConfig.MAPPER_LOCATION));
		return sessionFactory.getObject();
	}

}
