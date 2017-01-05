package com.autoTest.web.util;

import com.autoTest.web.entity.WebElement;
import com.autoTest.web.resource.WebElementFindType;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wb-huangqiang.a on 2017/1/4.
 */
public class CSVFileUtil {
    public static final String Encode = "UTF-8";

    private InputStream inputStream = null;
    private InputStreamReader inputStreamReader = null;
    private BufferedReader bufferedReader = null;

    public CSVFileUtil(String filename) {
        try {
            inputStream = CSVFileUtil.class.getClassLoader().getResourceAsStream(filename);
            inputStreamReader = new InputStreamReader(inputStream,Encode);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        bufferedReader = new BufferedReader(inputStreamReader);
    }

    public Map<String,WebElement> readCSV2Map(){

        Map<String ,WebElement> map =  new HashMap<String, WebElement>();
        String stemp;
        String []arr=null;
        try {
            while ((stemp = bufferedReader.readLine())!=null){
                System.out.println(stemp);
                arr = stemp.split(",");
                if(arr.length<3){
                    continue;
                }
                WebElement element = new WebElement();
                element.setName(arr[0]);
                element.setPath(arr[1]);
                if(arr[2].equals( "xpath")) {
                    element.setFindType(WebElementFindType.BY_XPATH);
                }else if(arr[2].equals("class")) {
                    element.setFindType(WebElementFindType.BY_CLASS);
                }else if(arr[2].equals("name")) {
                    element.setFindType(WebElementFindType.BY_NAME);
                }else if(arr[2].equals("id")) {
                    element.setFindType(WebElementFindType.BY_ID);
                }else if(arr[2].equals("errormsg")) {
                    element.setFindType(WebElementFindType.ERR_MSG);
                }else{
                        System.err.println("Type Error");
                }
                map.put(element.getName(),element);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    return map;
    }

    public static void main(String[] args) {
        CSVFileUtil csv =  new CSVFileUtil("login_src.csv");
        Map<String,WebElement> map  = new HashMap<String, WebElement>();
        map = csv.readCSV2Map();
        System.out.println(map.get("login_btn").getPath());
    }


}
