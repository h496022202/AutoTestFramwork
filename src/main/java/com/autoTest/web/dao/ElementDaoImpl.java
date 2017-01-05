package com.autoTest.web.dao;

import com.autoTest.web.entity.WebElement;

import java.util.Map;

/**
 * Created by wb-huangqiang.a on 2017/1/5.
 */
public class ElementDaoImpl implements ElementDao {
    public static Map<String,WebElement> webElementMap;

    public WebElement getWebElement(String name) {
        return webElementMap.get(name);
    }

    public void setWebElement(WebElement elment) {
        webElementMap.put(elment.getName(),elment);
    }
}
