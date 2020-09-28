package com.test.cases;
import com.test.utils.HttpUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegisterCase {
    @Test(dataProvider="datas")
    public void testRegister(String url,String params) throws Exception {
//        String params ="{\"mobile-phone\": \"13418530001\",\"pwd\": \"12345678\"}";
        HttpUtils.jsonPost(url,params);
    }

    @DataProvider(name = "datas")
    public Object[][] datas() {
        Object[][] datas = {
                {"http://api.lemonban.com/futureloan/member/register",
                        "{\"mobile_phone\": \"13412312312\",\"pwd\": \"12345678\"}"},

                {"http://api.lemonban.com/futureloan/member/register",
                        "{\"mobile_phone\": \"13412312313\",\"pwd\": \"12345678\"}"},

                {"http://api.lemonban.com/futureloan/member/register",
                        "{\"mobile_phone\": \"13412312314\",\"pwd\": \"12345678\"}"}

                };
        return datas;
    }


}

