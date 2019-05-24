package com.example.commonds.utils;


import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class SpacesItemDecoration extends RecyclerView.ItemDecoration {
    private int top;
    int left  ,right ,bootom;
    public SpacesItemDecoration(int top ,int left ,int right ,int bootom) {
        this.top = top;
        this.left = left;
        this.bootom = bootom;
        this.right =right;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view,
                               RecyclerView parent, RecyclerView.State state) {
        outRect.set(0,0,0,0);
        outRect.left = dipToPx(parent.getContext() ,left);
        outRect.right = dipToPx(parent.getContext() ,right);
        outRect.bottom = dipToPx(parent.getContext() ,bootom);

        // Add top margin only for the first item to avoid double space between items
        if (parent.getChildLayoutPosition(view) == 0) {
            outRect.top = dipToPx(view.getContext() ,top);
        } else {
            outRect.top = 0;
        }
    }

    private static int dipToPx(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

}
