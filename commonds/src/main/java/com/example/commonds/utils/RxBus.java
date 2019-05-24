package com.example.commonds.utils;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;


//组件之间通信
public class RxBus {
    private volatile static RxBus rxBus;
    private Subject serializedSubscriber;
    public static synchronized  RxBus getInstance(){
        if (rxBus ==null){

            synchronized (RxBus.class){
                if (rxBus ==null){
                    rxBus = new RxBus();
                }
            }
        }
        return  rxBus;
    }

    public  RxBus(){
        serializedSubscriber = PublishSubject.create().toSerialized();

    }


    public <T> Observable<T> toObserverable (Class<T> eventType) {
        return serializedSubscriber.ofType( eventType );
    }

    public  void put(Object o){

        serializedSubscriber.onNext( o );

    }




}
