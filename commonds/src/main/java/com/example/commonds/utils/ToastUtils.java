package com.example.commonds.utils;

import android.content.Context;
import android.widget.Toast;

public class ToastUtils {


    public  static   void   showShort(Context context ,String  msg){


       if(context!=null&&msg!=null){

        Toast.makeText(context,msg ,Toast.LENGTH_SHORT).show();}
    }


    public     static   void   showLong(Context context ,String   msg){



        if(context!=null&&msg!=null) {
            Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
        }
    }

}
