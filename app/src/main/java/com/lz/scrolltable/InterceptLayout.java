package com.lz.scrolltable;

import android.content.Context;
import android.graphics.Color;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * -------- 日期 ---------- 维护人 ------------ 变更内容 --------
 * 2018/9/14    16:55	    刘泽			    新增 类
 * 2018/9/14	16:55	    刘泽			    增加yyy属性
 */
public class InterceptLayout extends LinearLayout {


    public InterceptLayout(Context context) {
        super(context);
    }

    public InterceptLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public InterceptLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return true;
    }


}
