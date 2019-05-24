package com.example.commonds.net.base;


import com.example.commonds.net.HttpDataReource;
import com.example.commonds.net.ShareDataResource;

import java.util.Map;

//装饰器
public class ProxyDataResource   implements BaseDataBase {
    private static final ProxyDataResource ourInstance = new ProxyDataResource();


    private  HttpDataReource  httpDataReource;


    private ShareDataResource shareDataResource;

    public static ProxyDataResource getInstance() {
        return ourInstance;
    }

    private ProxyDataResource() {

    }




    public   void  init( HttpDataReource  httpDataReource   ,ShareDataResource shareDataResource){

        this.httpDataReource = httpDataReource;

        this.shareDataResource =  shareDataResource;

    }





    public   void checkInit(){






        if (httpDataReource ==null){


            try {
                throw new Exception("请先初始化");
            } catch (Exception e) {
                e.printStackTrace();
            }


        }
    }


    @Override
    public <T> void excuteHttp(String url, Map<String, Object> msg, Response<T> t) {
        checkInit();
        httpDataReource.excuteHttp(url,msg,t);
    }

    @Override
    public <T> void excuteGet(String url, Map<String, Object> msg, Response<T> t) {
        checkInit();

        httpDataReource.excuteGet(url,msg ,t);



    }



    @Override
    public <T> void excutePut(String url, Map<String, Object> msg, Response<T> t) {
        checkInit();
        httpDataReource.excutePut(url,msg,t);
    }

    @Override
    public void put(String key, Object vualue) {
        checkInit();
    }

    @Override
    public Object getStringByKey(String key) {
        checkInit();
        return null;
    }
}
