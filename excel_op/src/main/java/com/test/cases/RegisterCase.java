package com.test.cases;
import com.test.utils.HttpUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.test.utils.ExcelUtils;

import java.io.IOException;

public class RegisterCase {
    @Test(dataProvider="datas")
    public void testRegister(String url, String type, String params, String contentType)
            throws Exception {
        if ("json".equalsIgnoreCase(contentType)) {
            if ("post".equalsIgnoreCase(type)) {
                HttpUtils.jsonPost(url, params);
            } else if ("get".equalsIgnoreCase(type)) {
                HttpUtils.jsonget(url);
            } else if ("patch".equalsIgnoreCase(type)) {
                HttpUtils.jsonPatch(url, params);

            }
        } else if ("form".equalsIgnoreCase(contentType)) {
            if ("post".equalsIgnoreCase(type)) {
                HttpUtils.formPost(url, params);
            } else if ("get".equalsIgnoreCase(type)) {
                HttpUtils.formGet(url, params);
            }
        }
    }

    @DataProvider(name = "datas")
    public Object[][] datas () throws IOException {
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
        Object[][] data = ExcelUtils.read();
        System.out.println(data);

        return data;
    }

}