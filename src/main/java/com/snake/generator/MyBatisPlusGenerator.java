package com.snake.generator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
* @author  jjbin
* @version 创建时间：2019年4月15日 上午11:48:38
* 类说明   Mybatis-plus自动代码生成工具类
*/

@SuppressWarnings("ALL")
public class MyBatisPlusGenerator {

  private static final String COM_MYSQL_JDBC_DRIVER = "com.mysql.jdbc.Driver";
  private static final String URL = "jdbc:mysql://127.0.0.1:3306/snake?characterEncoding=utf8&useSSL=false";
  private static final String USERNAME = "root";
  private static final String PASSWORD = "123456";
  private static final String AUTHOR = "jjbin";
  //需要生成在什么地方
  private static final String PATH = "F:\\mybatisplus";
  private static final String SERVICE = "service";
  private static final String ENTITY = "entity";
  private static final String MAPPER = "mapper";
  private static final String XML = "mapper";
  private static final String CONTROLLER = "controllers";
  private static final String SERVICE_NAME = "%sService";
  public static final String CONTROLLER_JAVA_VM = "/controller.java.vm";

  //项目名称
  private static final String PROJECTNAME = "demo";
  //包名称
  private static final String PACKAGENAME = "com.saas.ams.module.logs";
  //表名
  private static final String[] TABLENAMES = {"tbl_logs"};

  public static void main(String[] args) {

    //1. 全局配置
    GlobalConfig config = new GlobalConfig();
    config.setActiveRecord(true) // 是否支持AR模式
        .setAuthor(AUTHOR) // 作者
        .setOutputDir(PATH + "\\" + PROJECTNAME + "\\src\\main\\java") // 生成路径，需要修改
        .setFileOverride(true)  // 文件覆盖
        .setIdType(IdType.UUID) // 主键策略
        .setServiceName(SERVICE_NAME)  // 设置生成的service接口的名字的首字母是否为I
        .setBaseResultMap(true)//生成基本的resultMap
        .setBaseColumnList(true);//生成基本的SQL片段

    //2. 数据源配置
    DataSourceConfig dsConfig = new DataSourceConfig();
    dsConfig.setDbType(DbType.MYSQL)  // 设置数据库类型
        .setDriverName(COM_MYSQL_JDBC_DRIVER).setUrl(URL)
        .setUsername(USERNAME)
        .setPassword(PASSWORD);

    //3. 策略配置globalConfiguration中
    StrategyConfig stConfig = new StrategyConfig();
    stConfig.setCapitalMode(true) //全局大写命名
        //.setDbColumnUnderline(true)  // 指定表名 字段名是否使用下划线
        .setNaming(NamingStrategy.underline_to_camel) // 数据库表映射到实体的命名策略
        //.setTablePrefix("tbl_")
        .setInclude(TABLENAMES);// 生成的表，需要修改

    //4. 包名策略配置
    PackageConfig pkConfig = new PackageConfig();
    pkConfig.setParent(PACKAGENAME).setService(SERVICE)//servcie
        .setEntity(ENTITY)//entity
        .setMapper(MAPPER)//dao
        .setController(CONTROLLER)//controller
        .setXml(XML);//mapper.xml

    //5. 整合配置
    AutoGenerator ag = new AutoGenerator();
    ag.setGlobalConfig(config).setDataSource(dsConfig).setStrategy(stConfig)
        .setPackageInfo(pkConfig);

//    TemplateConfig tc = new TemplateConfig();
//    tc.setController(CONTROLLER_JAVA_VM);
//    ag.setTemplate(tc);

    //6. 执行
    ag.execute();
  }

}
