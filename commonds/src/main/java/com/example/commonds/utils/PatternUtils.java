package com.example.commonds.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternUtils {
    private static Pattern phone = Pattern.compile("^[1][3,4,5,7,8][0-9]{9}$");//判断是否是电话号码


    /**
        判断是否是电话号码
    * */
    public static boolean isPhone(String str) {
        Matcher m = phone.matcher(str);
        return m.matches();
    }



}
