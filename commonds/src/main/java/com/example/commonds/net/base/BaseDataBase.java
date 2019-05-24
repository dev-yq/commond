package com.example.commonds.net.base;

import java.util.Map;

public interface  BaseDataBase {

    <T> void   excuteHttp(String   url    , Map<String ,Object> msg  ,Response<T> t); //post请求

    <T>void  excuteGet(String   url    , Map<String ,Object> msg ,Response<T> t); //get请求


    <T> void  excutePut(String   url    , Map<String ,Object> msg  ,Response<T> t); //put请求

    void     put(String key    ,Object  vualue);
    Object    getStringByKey(String  key);





}
