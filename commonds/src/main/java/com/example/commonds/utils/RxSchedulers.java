package com.example.commonds.utils;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;



/*
* 线程调度
* */
public class RxSchedulers {

    static final ObservableTransformer schedulersTransformer =
            upstream -> (upstream).subscribeOn(Schedulers.io())
            .observeOn( AndroidSchedulers.mainThread());

    public static <T> ObservableTransformer<T, T> applySchedulers() {

        return (ObservableTransformer<T, T>) schedulersTransformer;
    }






}



