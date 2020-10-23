package com.test.cases;
import com.test.pojo.API;
import com.test.pojo.Case;
import com.test.utils.ExcelUtils;
import com.test.utils.HttpUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class RegisterCase {
    @Test(dataProvider="datas")
    public void testRegister(API api, Case c)
            throws Exception {
       String url = api.getUrl();
       String type = api.getMethod();
       String params = c.getParams();
       String contentType = api.getContentType();
       HttpUtils.call(url, type, params, contentType);
    }

    @DataProvider(name = "datas")
    public Object[][] datas () throws Exception {
//        Object[][] datas = {
//                {"http://api.lemonban.com/futureloan/member/register",
//                        "{\"mobile_phone\": \"13412312312\",\"pwd\": \"12345678\"}"},
//
//                {"http://api.lemonban.com/futureloan/member/register",
//                        "{\"mobile_phone\": \"13412312313\",\"pwd\": \"12345678\"}"},
//
//                {"http://api.lemonban.com/futureloan/member/register",
//                        "{\"mobile_phone\": \"13412312314\",\"pwd\": \"12345678\"}"}
//
//                };
        List<API> list = ExcelUtils.read(0,API.class);
//        System.out.println(data);
//
        return null;
    }

}