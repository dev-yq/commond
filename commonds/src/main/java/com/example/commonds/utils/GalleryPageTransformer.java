package com.example.commonds.utils;

import android.support.v4.view.ViewPager;
import android.view.View;

public class GalleryPageTransformer implements ViewPager.PageTransformer {
    private static final float MAX_ROTATION=20.0f;
    private static final float MIN_SCALE=0.9f;
    private static final float MAX_TRANSLATE=30.0f;

    @Override
    public void transformPage(View page, float position) {
        if(position<-1) {
            page.setTranslationX(0);
            page.setScaleX(position);
            page.setScaleY(position);

        }
        else if(  position>=-1&& position<=0) {
            page.setTranslationX(MAX_TRANSLATE*position);
            page.setScaleX(position);
            page.setScaleY(position);

        }


        else if(position>0&&position<=1) {
            page.setTranslationX(-MAX_TRANSLATE*position);
            page.setScaleX(MIN_SCALE);
            page.setScaleY(MIN_SCALE);
        }
        else {

            page.setScaleX(position);
            page.setScaleY(position);

        }
    }
}