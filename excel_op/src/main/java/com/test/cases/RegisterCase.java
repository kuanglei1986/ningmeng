package com.test.cases;
import com.test.utils.HttpUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegisterCase {
    @Test(dataProvider="datas")
    public void testRegister(String url, String type, String params, String contentType)
            throws Exception {
       HttpUtils.call(url, type, params, contentType);
    }

    @DataProvider(name = "datas")
    public void datas () throws Exception {
        Object[][] datas = {
                {"http://api.lemonban.com/futureloan/member/register",
                        "{\"mobile_phone\": \"13412312312\",\"pwd\": \"12345678\"}"},

                {"http://api.lemonban.com/futureloan/member/register",
                        "{\"mobile_phone\": \"13412312313\",\"pwd\": \"12345678\"}"},

                {"http://api.lemonban.com/futureloan/member/register",
                        "{\"mobile_phone\": \"13412312314\",\"pwd\": \"12345678\"}"}

                };
//        Object[][] data = ExcelUtils.read();
//        System.out.println(data);
//
//        return data;
    }

}