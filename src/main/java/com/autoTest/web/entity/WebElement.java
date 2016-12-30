package com.autoTest.web.entity;

/**
 * Created by wb-huangqiang.a on 2016/12/29.
 */
public class WebElement {
    private String name;
    private String path;
    private int findType;

    public WebElement(String name, String path, int findType) {
        this.name = name;
        this.path = path;
        this.findType = findType;
    }

    public WebElement() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getFindType() {
        return findType;
    }

    public void setFindType(int findType) {
        this.findType = findType;
    }
}
