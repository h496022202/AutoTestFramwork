package com.autoTest.web.Service.base;

import com.autoTest.web.dao.ElementDao;
import org.openqa.selenium.WebDriver;

/**
 * Created by wb-huangqiang.a on 2017/1/3.
 */
public class PreClass {
    WebDriver driver;
    ElementDao elementDao;

    public void setElementDao(ElementDao elementDao) {
        this.elementDao = elementDao;
    }

    public PreClass() {
    }

    public PreClass(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }
}
