package com.autoTest.web.dao;

import com.autoTest.web.entity.WebElement;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wb-huangqiang.a on 2016/12/29.
 */
public interface ElementDao {
    public  WebElement getWebElement(String name);
    public void setWebElement(WebElement elment);
}
