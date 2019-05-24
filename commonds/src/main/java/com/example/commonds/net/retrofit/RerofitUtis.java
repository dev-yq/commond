package com.example.commonds.net.retrofit;

import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

//refrofit网络请求
public class RerofitUtis {

    private     static  RerofitUtis rerofitUtis;




    public   static  synchronized  RerofitUtis    getInstance(){

        if (rerofitUtis == null){

            synchronized (RerofitUtis.class){

                if (rerofitUtis == null){
                    rerofitUtis = new RerofitUtis();
                }
            }
        }



        return   rerofitUtis;
    }



    //构建refrofit
    private Retrofit    getRetofit(String  url){


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl( url
                )
                .client(onHttps(bulid()))
                .addConverterFactory(ScalarsConverterFactory.create())
                //增加返回值为Gson的支持(以实体类返回)
                .addConverterFactory( GsonConverterFactory.create())
                //增加返回值为Oservable<T>的支持



                .addCallAdapterFactory( RxJava2CallAdapterFactory.create())

                .build();

        return      retrofit;
    }

      private   OkHttpClient.Builder  bulid(){
        OkHttpClient.Builder b = new OkHttpClient.Builder();

        return  b;

    }







    private OkHttpClient onHttps(OkHttpClient.Builder builder) {
        try {

            builder.connectTimeout(60, TimeUnit.SECONDS);
            builder.readTimeout( 60,TimeUnit.SECONDS );
            builder.writeTimeout(60,TimeUnit.SECONDS);

            OkHttpClient okHttpClient =  builder.build();
            return okHttpClient;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }





    //创建网络通信

        public    ApiService  getApiService(String url){

        return      getRetofit(url).create(ApiService.class);
        }
}
