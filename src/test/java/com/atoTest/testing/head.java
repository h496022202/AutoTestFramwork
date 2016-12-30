package com.atoTest.testing;

import com.autoTest.web.dao.ElementDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by wb-huangqiang.a on 2016/12/30.
 */

public class head extends  {

    @Autowired
    ElementDao elementDao;

    @BeforeClass
    protected void setUp(){
        System.out.println(elementDao.getWebElement("login_btn"));

    }

    @Test
    public void test1(){
        System.out.println("test");
    }
}
