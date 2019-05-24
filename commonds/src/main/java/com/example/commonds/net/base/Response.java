package com.example.commonds.net.base;


//数据返回
public interface Response <T> {




    void   sucess(T  t);

    void errror(String o);
}
