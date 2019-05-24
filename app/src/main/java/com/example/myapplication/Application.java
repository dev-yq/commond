package com.example.myapplication;

import com.example.commonds.net.RetofitHttpResource;

import com.example.commonds.net.base.ProxyDataResource;


public class Application extends android.app.Application {

    @Override
    public void onCreate() {
        super.onCreate();


        ProxyDataResource.getInstance().init(new RetofitHttpResource(ApiConnet.PRODUCT_SERVICE_NAME), null);
    }
}
