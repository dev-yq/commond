package com.example.commonds.net;

import android.util.Log;

import com.example.commonds.R;
import com.example.commonds.net.base.RealResolve;
import com.example.commonds.net.base.Response;
import com.example.commonds.net.retrofit.RerofitUtis;
import com.example.commonds.utils.RxSchedulers;

import java.lang.reflect.ParameterizedType;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import retrofit2.Retrofit;


/*
发送网络请求
* */

public class RetofitHttpResource implements HttpDataReource {



    private    String url;



    public   RetofitHttpResource(   String url){
        this.url = url;

    }
    @Override
    public <T> void excuteHttp(String url, Map<String, Object> msg, Response<T> t) {
        Observable<String >  observable ;
        if (msg==null){

        observable = RerofitUtis.getInstance()
                    .getApiService(this.url)
                    .noMapPost(url);
        }
        else {
            observable =   RerofitUtis.getInstance().getApiService(this.url).post(url ,msg);

        }
        http(observable ,t);
    }

    @Override
    public <T> void excuteGet(String url, Map<String, Object> msg, Response<T> t) {

        Observable<String >  observable ;


        if (msg==null){



            observable =RerofitUtis.getInstance().getApiService(this.url).get(url);
        }
        else {
            observable =RerofitUtis.getInstance().getApiService(this.url).get(url ,msg);
        }

        http(observable ,t);
    }

    @Override
    public <T> void excutePut(String url, Map<String, Object> msg, Response<T> t) {

    }

    @Override
    public void put(String key, Object vualue) {

    }

    @Override
    public Object getStringByKey(String key) {
        return null;
    }







    private   <T>void  http(Observable<String> observable  ,Response<T> t){

        observable
                .compose(RxSchedulers.applySchedulers())
                .subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(String s) {



                Log.e("网络请求" ,s);

                data(s  ,t);

            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
                t.errror(e.getMessage()+"--");
            }

            @Override
            public void onComplete() {

            }
        })
        ;

    }


    //数据解析
    private    <T> void        data(String  result  ,Response<T>  tResponse){




        RealResolve  realResolve =   new RealResolve();
        realResolve.resolve(tResponse ,result );
    }


}
