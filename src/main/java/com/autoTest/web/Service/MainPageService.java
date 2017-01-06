package com.autoTest.web.Service;

import com.autoTest.web.Service.base.BaseAction;
import com.autoTest.web.dao.ElementDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by wb-huangqiang.a on 2017/1/6.
 */
@Service
public class MainPageService extends BaseAction {

    @Autowired
    @Qualifier("main")
    private ElementDao elementDao;

    public MainPageService() {
        setElementDao(this.elementDao);
    }

    public void  gotoLoginPage(){
        clickOnElement("login_btn");
    }

    public void gotoRegisterPage(){
        clickOnElement("register_btn ");
    }
}
