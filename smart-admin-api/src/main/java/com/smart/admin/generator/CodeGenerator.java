package com.smart.admin.generator;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.io.File;

/**
 * <p>
 * 代码生成器演示
 * </p>
 */
public class CodeGenerator {


    /**
     * <p>
     * MySQL 生成演示
     * </p>
     */
    public static void main(String[] args) {
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        //平常添加可以修改路径然后复制代码，不要轻易操作已有文件
       File dir = new File("d:/codetmp");
        //File dir = new File("/Users/mt1314/codeTmp");

        gc.setOutputDir(dir.getPath());
        gc.setFileOverride(true);
        gc.setActiveRecord(false);
        gc.setEnableCache(false);// XML 二级缓存
        gc.setBaseResultMap(true);// XML ResultMap
        gc.setBaseColumnList(true);// XML columList
        gc.setAuthor("xiaobai");
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("123456");
        dsc.setUrl("jdbc:mysql://localhost:3306/smart?characterEncoding=utf8");
        mpg.setDataSource(dsc);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        // strategy.setCapitalMode(true);// 全局大写命名 ORACLE 注意
        strategy.setTablePrefix(new String[]{"smart_"});// 此处可以修改为您的表前缀
        strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略
        strategy.setRestControllerStyle(true);
        //strategy.setInclude(new String[] { "user" ,"user_baby"}); // 需要生成的表

        // 自定义 controller 父类
         strategy.setSuperControllerClass("BaseController");
        // 【实体】是否生成字段常量（默认 false）
        // public static final String ID = "test_id";
         strategy.setEntityColumnConstant(true);
        mpg.setStrategy(strategy);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.smart.admin");
        pc.setController("controller");
        mpg.setPackageInfo(pc);


        // 执行生成
        mpg.execute();

    }
}