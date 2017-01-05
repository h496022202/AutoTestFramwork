package com.autoTest.web.bean;

import com.autoTest.web.dao.ElementDao;
import com.autoTest.web.dao.MainElementDaoImpl;
import com.autoTest.web.util.BaseAction;
import com.autoTest.web.util.DateFormat;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by wb-huangqiang.a on 2017/1/3.
 */
@Configuration
public class BeanConfiguration {

    @Bean
    public BaseAction baseAction(){
        BaseAction bean =  new BaseAction();
        bean.setElementDao(elementDao());
        return bean;
    }

    @Bean
    public ElementDao elementDao(){
        MainElementDaoImpl bean = new MainElementDaoImpl();
        return bean;
    }

    @Bean
    public DateFormat dateFormat(){
        DateFormat bean = new DateFormat();
        return bean;
    }

}
