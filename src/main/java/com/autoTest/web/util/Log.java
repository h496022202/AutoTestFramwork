package com.autoTest.web.util;

import com.autoTest.web.bean.BeanConfiguration;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.Reporter;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;


/**
 * Created by wb-huangqiang.a on 2017/1/3.
 */
public class Log {
    private Logger logger;
    AnnotationConfigApplicationContext applicationContext
            = new AnnotationConfigApplicationContext(BeanConfiguration.class);
    private static DateFormat df;

    static {
        String log4jProperties = "/src/main/resources/log4j.properties";
        String fileName = "D:/log4j/"+df.formatDate(new Date())+".log";
        Properties properties = new Properties();

        try {
            properties.load(new FileInputStream(log4jProperties));
        } catch (IOException e) {
            e.printStackTrace();
        }

        properties.put("log4j.appender.logFile.File",fileName);
        System.out.println(fileName);
        PropertyConfigurator.configure(properties);
    }

    public Log() {
        logger = Logger.getLogger("");
        df = applicationContext.getBean("dataFormat",DateFormat.class);
    }

    public Log(String s) {
        logger = Logger.getLogger(s);
        df = applicationContext.getBean("dataFormat",DateFormat.class);

    }

    public Log(Class<?> clazz) {
        logger = Logger.getLogger(clazz);
        df = applicationContext.getBean("dataFormat",DateFormat.class);
    }

    public void info(Object message){
        logger.info(message);
        this.testngLogOutput(message);
    }
    public void warn(Object message){
        logger.warn(message);
        this.testngLogOutput(message);
    }

    public void error(Object message){
        logger.error(message);
        this.testngLogOutput(message);
    }

    public void debug(Object message){
        logger.debug(message);
        this.testngLogOutput(message);
    }

    private void testngLogOutput(Object message) {
        Reporter.log(df.formatDate(new Date())+":"+message);
    }
}
