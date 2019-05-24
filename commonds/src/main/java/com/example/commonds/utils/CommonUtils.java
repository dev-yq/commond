package com.example.commonds.utils;


import android.content.Context;

public class CommonUtils {

    /**
     * 获取dimens定义的大小
     *
     * @param dimensionId
     * @return
     */
    public static int getPixelById(Context context , int dimensionId) {
        return context.getResources().getDimensionPixelSize(dimensionId);
    }

}
