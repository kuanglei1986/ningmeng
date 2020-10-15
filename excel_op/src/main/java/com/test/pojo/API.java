package com.test.pojo;

import cn.afterturn.easypoi.excel.annotation.Excel;

public class API {
    //CaseId
    @Excel(name = "CaseId(用例编号)")
    private int id;
    @Excel(name = "Name(接口名)")
    private String name;
    @Excel(name = "Url(接口地址)")
    private String url;
    @Excel(name = "Type(接口提交类型)")
    private String method;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    @Override
    public String toString() {
        return "API{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", method='" + method + '\'' +
                '}';
    }

}
