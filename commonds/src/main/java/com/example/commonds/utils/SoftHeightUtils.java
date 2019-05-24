package com.example.commonds.utils;

import android.graphics.Rect;
import android.view.View;

public class SoftHeightUtils {
    private static final SoftHeightUtils ourInstance = new SoftHeightUtils();

    public static SoftHeightUtils getInstance() {
        return ourInstance;
    }

    private SoftHeightUtils() {
    }


    //
    public  void buttonBeyondKeyboardLayout(final View root, final View button) {
        // 监听根布局的视图变化
        root.getViewTreeObserver().addOnGlobalLayoutListener(
                () -> {
                    Rect rect = new Rect();
                    // 获取内容布局在窗体的可视区域
                    root.getWindowVisibleDisplayFrame(rect);
                    // 获取内容布局在窗体的不可视区域高度(被其他View遮挡的区域高度)
                    int rootInvisibleHeight = root.getHeight() - rect.bottom;
                    if (rootInvisibleHeight !=0) {
                        int[] location = new int[2];
                        // 获取须顶上去的控件在窗体的坐标
                        button.getLocationInWindow(location);
                        // 计算内容滚动高度，使button在可见区域
                        int buttonHeight = (location[1]
                                + button.getHeight()) - rect.bottom;
                        root.scrollTo(0, buttonHeight);
                    } else {
                        // 键盘隐藏
                        root.scrollTo(0, 0);
                    }
                });
    }
}
