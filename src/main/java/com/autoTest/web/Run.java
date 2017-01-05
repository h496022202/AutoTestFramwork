package com.autoTest.web;

import com.autoTest.web.bean.BeanConfiguration;
import com.autoTest.web.util.BaseAction;
import com.autoTest.web.util.PreClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;

/**
 * Created by wb-huangqiang.a on 2017/1/3.
 */
public class Run {
    public static void main(String[] args) throws InterruptedException {
       ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(String.valueOf(Run.class.getClassLoader().getResource("spring.xml")));
        BaseAction ba = applicationContext.getBean("BaseAction",BaseAction.class);

        System.setProperty("webdriver.chrome.driver","D:/dev_soft/driver/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        Thread.sleep(2000);
        driver.get("http://www.hupan.com");
        ba.setDriver(driver);
        ba.clickOnElement("login_btn");
    }
}
