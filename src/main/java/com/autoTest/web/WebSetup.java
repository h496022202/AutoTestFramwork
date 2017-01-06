package com.autoTest.web;

import com.autoTest.web.entity.WebElement;
import com.autoTest.web.resource.WebElementFindType;
import com.autoTest.web.Service.base.BaseAction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

/**
 * Created by wb-huangqiang.a on 2017/1/3.
 */
public class WebSetup {
    WebDriver driver;
    String url;
    String driverurl;
    ClassPathXmlApplicationContext applicationContext;
    BaseAction baseAction;
    @BeforeSuite
    public void suiteSetup(){
        url = "http://www.hupan.com";
        driverurl = "D:\\dev_soft\\driver\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",driverurl);
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        applicationContext = new ClassPathXmlApplicationContext(
                String.valueOf(this.getClass().getClassLoader().getResource("spring.xml")));
        baseAction = applicationContext.getBean("baseAction",BaseAction.class);
        baseAction.setDriver(driver);
    }

    @Test(description = "test11111")
    public void test1() throws InterruptedException {
        Thread.sleep(1000);
        baseAction.clickOnElement("login_btn");
        baseAction.setElement(new WebElement("switch_login_type","switch-login-type", WebElementFindType.BY_CLASS));
        baseAction.clickOnElement("switch_login_type");
        Thread.sleep(5000);
    }

    @AfterSuite
    public void SuiteTearDown(){
        if(driver != null)
            driver.close();
    }
}
