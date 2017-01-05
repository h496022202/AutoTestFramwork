package com.autoTest.web.dao;

import com.autoTest.web.entity.WebElement;
import com.autoTest.web.resource.MainSrc;
import com.autoTest.web.resource.WebElementFindType;
import com.autoTest.web.util.CSVFileUtil;
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
        webElementMap = new HashMap();
        CSVFileUtil csvFileUtil = new CSVFileUtil("main_src.csv");
        webElementMap = csvFileUtil.readCSV2Map();
    }


    public WebElement getWebElement(String name) {
        return webElementMap.get(name);
    }

    public void setWebElement(WebElement elment) {
        webElementMap.put(elment.getName(),elment);
    }
}
