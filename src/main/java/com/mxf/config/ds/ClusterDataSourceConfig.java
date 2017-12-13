package com.mxf.config.ds;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * @author moxiaofei
 * @date 2017年12月13日 下午9:05:28 DataSource的管理 其中涉及连接数据库连接池(DataSource)，
 *       开启事务管理(DataSourceTransactionManager)， 开启连接池管理类(SqlSessionFactory).
 */
@Configuration
// 扫描mapper接口并容器管理
@MapperScan(basePackages = "com.mxf.dao.cluster", sqlSessionFactoryRef = "clusterSqlSessionFactory")
public class ClusterDataSourceConfig {
	// 精确到 cluster 目录，以便跟其他数据源隔离
	// static final String PACKAGE = "com.mxf.dao.cluster";
	/**
	 * 注：我这里使用了@Select注解，所以不需要进行mapper.xml的书写，因此这里也就不需要进行配置了。
	 * 如果你没有使用的话，就需要书写对应的mapper.xml文件(我这里已经写好了，只不过我没用)，并在这里进行配置
	 */
	// static final String MAPPER_LOCATION = "classpath:mapper/cluster/*.xml";

	@Value("${cluster.datasource.url}")
	private String url;
	@Value("${cluster.datasource.username}")
	private String username;
	@Value("${cluster.datasource.password}")
	private String password;
	@Value("${cluster.datasource.driverclass}")
	private String driverclass;

	@Bean(name = "clusterDataSource")
	public DataSource clusterDataSource() {
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		dataSource.setDriverClassName(driverclass);
		return dataSource;
	}

	@Bean(name = "clusterTransactionManager")
	public DataSourceTransactionManager clusterTransactionManager() {
		return new DataSourceTransactionManager(clusterDataSource());
	}

	// SqlSessionFactory：session的连接工厂配置,更像一种连接池管理类,每次的数据操作都将由连接池来分配连接后进行。
	@Bean(name = "clusterSqlSessionFactory")
	public SqlSessionFactory clusterSqlSessionFactory(@Qualifier("clusterDataSource") DataSource clusterDataSource)
			throws Exception {
		final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(clusterDataSource);
		// sessionFactory.setMapperLocations(new
		// PathMatchingResourcePatternResolver()
		// .getResources(ClusterDataSourceConfig.MAPPER_LOCATION));
		return sessionFactory.getObject();
	}

}
