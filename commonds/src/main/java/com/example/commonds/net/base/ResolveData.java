package com.example.commonds.net.base;


import com.example.commonds.net.HttpDataReource;

/*
* 数据解析
* */
public interface ResolveData {


    <T>void   resolve(Response <T> response, String msg  );


}
