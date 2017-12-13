# SpringBoot_Mybatis_Multi_Datasource
Spring Boot 整合Mybatis实现多数据源的简单示例

1.其中项目的结构图为：
```
src/
 +- main/
     +- java/
        +- com.mxf.
             +- bean
             +- config.ds
             +- controller
             +- dao
                +-cluster
                +-master
             +- service
                +-impl
             |- App.java
     +- resources/
             +- mapper
                +-master
                +-cluster
             |- application.properties

```

2.数据库的准备如下：

  2.1 主数据库的准备
  
      ```
      CREATE DATABASE first;
      ```
      
      ```
      CREATE TABLE `teacher` (
        `id` int(11) NOT NULL,
        `name` varchar(20) DEFAULT NULL,
        `password` varchar(20) DEFAULT NULL,
        `cid` int(11) DEFAULT NULL,
        PRIMARY KEY (`id`)
      ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
      ```
      
      ```
      INSERT INTO `teacher` VALUES ('1', 'moxiaofei', '123456', '1');
      ```
 
  2.2 从数据库的准备
  
      ```
      CREATE DATABASE second;
      ```
      
      ```
      CREATE TABLE `city` (
      `cid` int(11) NOT NULL,
      `cname` varchar(50) DEFAULT NULL,
      `cdescription` varchar(50) DEFAULT NULL,
      PRIMARY KEY (`cid`)
     ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
      ```
      
      ```
      INSERT INTO `city` VALUES ('1', '西安', '太美了');
      ```
      
3.改数据库配置   打开 application.properties 文件， 修改相应的数据源配置，比如数据源地址、账号、密码等。

4.运行App.java文件中的main方法启动SpringBoot

5.打开浏览器进行访问

