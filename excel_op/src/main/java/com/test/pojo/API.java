package com.test.pojo;

import cn.afterturn.easypoi.excel.annotation.Excel;

public class API {
    //CaseId
    @Excel(name = "Id(接口编号)")
    private String id;
    @Excel(name = "Name(接口名)")
    private String name;
    @Excel(name = "Url(接口地址)")
    private String url;
    @Excel(name = "Type(接口提交类型)")
    private String method;
    @Excel(name = "Content-Type")
    private String contentType;

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
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
