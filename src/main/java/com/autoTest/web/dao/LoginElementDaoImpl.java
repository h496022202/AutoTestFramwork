package com.autoTest.web.dao;

import com.autoTest.web.entity.WebElement;
import com.autoTest.web.util.CSVFileUtil;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wb-huangqiang.a on 2017/1/5.
 */
@Repository
@Qualifier("login")
public class LoginElementDaoImpl extends ElementDaoImpl {
    static{
        webElementMap = new HashMap();
        CSVFileUtil csvFileUtil = new CSVFileUtil("login_src.csv");
        webElementMap = csvFileUtil.readCSV2Map();
    }

}
