package com.example.commonds.utils;

import android.util.Log;

import com.example.commonds.BuildConfig;



public class LogUtils {


    public static final String  TAG = LogUtils.class.getName();



    public   static   void   e(String msg){


        if (BuildConfig.DEBUG){
            Log.e(TAG ,msg);
        }


    }

    public   static   void   v(String msg){


        if (BuildConfig.DEBUG){
            Log.v(TAG ,msg);
        }


    }
    public   static   void   d(String msg){


        if (BuildConfig.DEBUG){
            Log.d(TAG ,msg);
        }


    }
    public   static   void   i(String msg){


        if (BuildConfig.DEBUG){
            Log.i(TAG ,msg);
        }


    }
}
