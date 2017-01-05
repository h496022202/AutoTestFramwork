package com.autoTest.web.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by wb-huangqiang.a on 2017/1/3.
 */
public class DateFormat {
    public String formatDateToString(long date){
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        return format.format(date);
    }

    public String formatDate(Date date){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,SSS");
        return df.format(date);
    }

    public String formatDate(long date){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(date);
    }

    public Date formateToDate(String date){
        SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d = null;
        try {
            d = fm.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return d;
    }

    public long formateDate(String date){
        SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d = null;
        try {
            d= fm.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return d.getTime();
    }
}
