package com.autoTest.web;

import com.autoTest.web.Service.base.BaseAction;
import com.autoTest.web.Service.MainPageService;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by wb-huangqiang.a on 2017/1/3.
 */
public class Run {
    public static void main(String[] args) throws InterruptedException {
       ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(String.valueOf(Run.class.getClassLoader().getResource("spring.xml")));
        BaseAction ba = applicationContext.getBean(MainPageService.class);

        System.setProperty("webdriver.chrome.driver","D:/dev_soft/driver/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        Thread.sleep(2000);
        driver.get("http://www.hupan.com");
        driver.manage().window().maximize();
        ba.setDriver(driver);
        ba.clickOnElement("login_btn");
    }
}
