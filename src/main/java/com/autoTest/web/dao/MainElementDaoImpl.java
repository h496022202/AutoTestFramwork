package com.autoTest.web.dao;

import com.autoTest.web.entity.WebElement;
import com.autoTest.web.resource.MainSrc;
import com.autoTest.web.resource.WebElementFindType;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wb-huangqiang.a on 2016/12/29.
 */

@Repository
public class MainElementDaoImpl implements ElementDao {

    private static Map<String,WebElement> webElementMap;
    static{
        webElementMap = new HashMap(){
            {
                put("login_btn",new WebElement("login_btn","login-link", WebElementFindType.BY_CLASS));

            }
        };
    }

    @Override
    public WebElement getWebElement(String name) {
        return webElementMap.get(name);
    }
}
