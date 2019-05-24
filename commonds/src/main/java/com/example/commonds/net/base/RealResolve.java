package com.example.commonds.net.base;

import com.example.commonds.net.HttpDataReource;
import com.google.gson.Gson;

import java.lang.reflect.ParameterizedType;

public class RealResolve implements ResolveData {
    @Override
    public <T>void resolve(Response <T> response, String msg  ) {


        Gson  gson = new Gson();


        T  t = gson.fromJson(msg,    getClass(response));



        response.sucess(t);


    }

    public   <T>Class<T>   getClass(Response<T> response){

        ParameterizedType type = (ParameterizedType) response.getClass()
                .getGenericInterfaces()[0];
        return   (Class<T>) type.getActualTypeArguments()[0];
    }
}
