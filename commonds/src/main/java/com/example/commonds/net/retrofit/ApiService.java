package com.example.commonds.net.retrofit;



//网络请求

import java.util.Map;
import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.Body;

import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;


/*
*
* */
public interface ApiService {

    @POST
    Observable<String>  post(@Url String url, @Body Map<String, Object> msg);



    @GET
    Observable<String>  get(@Url String url, @QueryMap Map<String, Object> msg);


    @POST
    Observable<String >  noMapPost(@Url String url);
    @POST
    Observable<String >  querPost(@Url String url, @QueryMap Map<String, Object> msg);

    @GET
    Observable<String>  get(@Url String url);


    //下载图片

    @GET
    Observable<ResponseBody> downloadPicFromNet(@Url String fileUrl);

}
