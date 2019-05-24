package com.example.commonds.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtils   {


    public  static    String   get(long  endTime  ,int stat ,int  type){



        long day = 0;

        long hour = 0;

        long min = 0;

        long sec = 0;

        long diff = 0;


        diff = endTime -System.currentTimeMillis();

        day = diff/(24*60*60*1000);

     hour = diff/(60*60*1000) - day*24;

    min = diff/(60*1000) - day*24*60 - hour*60;

    sec = diff/1000-day*24*60*60-hour*60*60-min*60;


    if (min<=0&& sec<1){

        if (type==1)
        return "已结束";

        else {
            return "进行中";
        }

    }
    else {

        if (type==1&&stat==1){
            return min+"分"+ sec+"秒后开奖";
        }

        else {
            return min+"分"+ sec+"秒后开始";
        }

    }

    }


    /*
     * 将时间戳转换为时间
     */
    public static String stampToDate(long s){
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date date = new Date(s);
        res = simpleDateFormat.format(date);
        return res;
    }
}
