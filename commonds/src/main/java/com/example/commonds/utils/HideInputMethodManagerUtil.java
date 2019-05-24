package com.example.commonds.utils;

import android.app.Activity;
import android.content.Context;
import android.view.inputmethod.InputMethodManager;

/*
* 隐藏软键盘
* */
public class HideInputMethodManagerUtil {
    private static final HideInputMethodManagerUtil ourInstance = new HideInputMethodManagerUtil();

    public static HideInputMethodManagerUtil getInstance() {
        return ourInstance;
    }

    private HideInputMethodManagerUtil() {
    }


    public   void  hide(Activity context){




        if (context !=null&&context.getCurrentFocus() !=null){
            InputMethodManager inputMethodManager = (InputMethodManager)context.getSystemService(Context.INPUT_METHOD_SERVICE);


            inputMethodManager.hideSoftInputFromWindow(context.getCurrentFocus().getWindowToken() ,InputMethodManager.HIDE_NOT_ALWAYS);
        }


    }
}
