package com.autoTest.web.util;

import com.autoTest.web.dao.ElementDao;
import com.autoTest.web.entity.WebElement;
import com.autoTest.web.resource.WebElementFindType;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by wb-huangqiang.a on 2017/1/3.
 */
@Service
public class BaseAction extends PreClass {

    public void setElementDao(ElementDao elementDao) {
        this.elementDao = elementDao;
    }

    @Autowired
    ElementDao elementDao;

    public void clickOnElement(String name){
        WebElement element = elementDao.getWebElement(name);
        this.findElementBy(element).click();
    }

    public org.openqa.selenium.WebElement findElementBy(WebElement element){
        switch (element.getFindType()){
            case 1:
                return driver.findElement(By.xpath(element.getPath()));
            case 2:
                return driver.findElement(By.className(element.getPath()));
            case 3:
                return driver.findElement(By.id(element.getPath()));
            default:
                System.err.println("unexpected element find type for "+element.getFindType());
                return null;
        }
    }

    public void setElement(WebElement element){
        this.elementDao.setWebElement(element);
    }

    public void getElement(String elementName){
        this.elementDao.getWebElement(elementName);
    }
}
