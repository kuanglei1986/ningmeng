package com.test.utils;

public class Demo {
    public static void main(String[] args) throws Exception {
        //        HttpUtils.get("http://api.lemonban.com/futureloan/loans");
//        HttpUtils.get("http://api.lemonban.com/futureloan/loans?pageIndex=2");
//        HttpUtils.get("http://api.lemonban.com/futureloan/loans?pageIndex=1&pageSize=1");
//        HttpUtils.get("http://api.lemonban.com/futureloan/member/-1/info");
//        HttpUtils.get("http://api.lemonban.com/futureloan/member/1/info");
//        HttpUtils.get("http://api.lemonban.com/futureloan/member/2060127/info");

        HttpUtils.jsonPost("http://api.lemonban.com/futureloan/member/recharge","{\"member_id\": 2060127,\"amount\": 1}");
        HttpUtils.jsonPost("http://api.lemonban.com/futureloan/member/recharge","{\"member_id\": 2060127,\"amount\": 1}");
        HttpUtils.jsonPost("http://api.lemonban.com/futureloan/member/recharge","{\"member_id\": 2060127,\"amount\": -1}");
        HttpUtils.jsonPost("http://api.lemonban.com/futureloan/member/recharge","{\"member_id\": 2060127,\"amount\": \"aaaa\"}");
    }
}
