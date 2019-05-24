package com.example.commonds.utils;


import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.provider.Settings;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/*
* 本地存储
* */
public class SharedPreferencesUtils {
    private static final SharedPreferencesUtils ourInstance = new SharedPreferencesUtils();

    public   static  final  String APPFILE = "app_info";
    public  static  final String  PHONE = "phone";
    public  static  final String   TOKEN = "token";


    public   static   final  String   USER  ="user";


    public static final String   CARD = "card";
    public static final String   NICKNAME = "nickName";

    public static final String   identifier = "identifier";

    public static final String   usersig = "usersig";
    public static final String   avatarImg = "avatarImg";
    public static  final   String   realNameStatus = "realNameStatus";
    public static final String   currentPoint = "currentPoint";
    public static final String  levelPoint ="levelPoint";

    public static final String  weChatBindStatus = "weChatBindStatus";




    public static final String   first="fist";
    public static final String   mobileBindStatus = "mobileBindStatus";

    public static final String   pointSum  = "pointSum";
    public static final String  levelName = "levelName";

    public static final String  customerIdentifier = "customerIdentifier";

    public static final String  trafication = "trafication";


    public static final String  userId ="userId";
    public static final String  bitrthdy ="bitrthdy";
    public static final String liveLearn="liveLearn";
    private      Context context;
    public static SharedPreferencesUtils getInstance() {
        return ourInstance;
    }



    private SharedPreferencesUtils() {
    }



    public   void  init(Context context){


        this .context = context;


    }

    public     void  write(  String key ,String value){
        SharedPreferences sharedPreferences = context.getSharedPreferences( APPFILE, Context.MODE_PRIVATE );
        SharedPreferences.Editor editor =  sharedPreferences.edit();
        editor.putString( key, value);
        editor.commit();
    }
    public     void  write(  String key ,int value){
        SharedPreferences sharedPreferences = context.getSharedPreferences( APPFILE, Context.MODE_PRIVATE );
        SharedPreferences.Editor editor =  sharedPreferences.edit();
        editor.putInt( key, value);
        editor.commit();
    }

    public    String read(  String key){
        SharedPreferences sharedPreferences = context.getSharedPreferences( APPFILE, Context.MODE_PRIVATE );
        return sharedPreferences.getString( key,null );
    }

    public    int readInt(  String key){
        SharedPreferences sharedPreferences = context.getSharedPreferences( APPFILE, Context.MODE_PRIVATE );
        return sharedPreferences.getInt( key,0 );
    }

    public    void write(String key  ,boolean value){

        SharedPreferences sharedPreferences = context.getSharedPreferences( APPFILE, Context.MODE_PRIVATE );
        SharedPreferences.Editor editor =  sharedPreferences.edit();

        editor.putBoolean(key ,value);
        editor.commit();

    }



    public   boolean readLine(String key){

        SharedPreferences sharedPreferences = context.getSharedPreferences( APPFILE, Context.MODE_PRIVATE );


        return  sharedPreferences.getBoolean(key ,false);

    }



    //获取app版本号



    public   String   getVersion(){


        PackageManager   packageManager =  context.getPackageManager();

        try {
            PackageInfo packageInfo=   packageManager.getPackageInfo(context.getPackageName() ,0);

        return     packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }



        return  null;
    }



    public   String  versionName(){

        PackageManager   packageManager =  context.getPackageManager();

        try {
            PackageInfo packageInfo=   packageManager.getPackageInfo(context.getPackageName() ,0);

            return     packageInfo.versionCode+"";
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }


        return  null;
    }


    //获取手机品牌



    public  String getBramd(){





        return Build.BRAND+"";


    }



    //获取手机型号
    public    String  getModel(){



        return   Build.MODEL;

    }




    public  String    getBrandId() {

        String androidID = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
        String id = androidID + Build.SERIAL;
        try {
            return toMD5(id);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return id;
        }

    }

    private static String toMD5(String text) throws NoSuchAlgorithmException {
        //获取摘要器 MessageDigest
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        //通过摘要器对字符串的二进制字节数组进行hash计算
        byte[] digest = messageDigest.digest(text.getBytes());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < digest.length; i++) {
            //循环每个字符 将计算结果转化为正整数;
            int digestInt = digest[i] & 0xff;
            //将10进制转化为较短的16进制
            String hexString = Integer.toHexString(digestInt);
            //转化结果如果是个位数会省略0,因此判断并补0
            if (hexString.length() < 2) {
                sb.append(0);
            }
            //将循环结果添加到缓冲区
            sb.append(hexString);
        }
        //返回整个结果
        return sb.toString();
    }



    public  Context context(){



        return  context;
    }

}
