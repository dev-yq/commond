package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.commonds.net.RetofitHttpResource;
import com.example.commonds.net.ShareDataResource;
import com.example.commonds.net.base.ProxyDataResource;
import com.example.commonds.net.base.Response;

import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }



    public   void data(View view){


        Log.e("点击" ,"网络请求点击事件");
        ProxyDataResource.getInstance().excuteGet("tbl_goods/list",
                null, new Response<Date>() {


                    @Override
                    public void sucess(Date date) {

                    }

                    @Override
                    public void errror(String o) {


                        Log.e("error" ,o);
                    }


                });

    }
}
