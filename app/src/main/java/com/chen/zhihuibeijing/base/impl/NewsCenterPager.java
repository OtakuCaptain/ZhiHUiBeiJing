package com.chen.zhihuibeijing.base.impl;

import android.app.Activity;
import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.widget.TextView;

import com.chen.zhihuibeijing.base.BasePager;


public class NewsCenterPager extends BasePager {
    public NewsCenterPager(Activity activity) {
        super(activity);
    }

    //给帧布局填充对象
    @Override
    public void initData() {
        Log.i("Pager","新闻中心初始化了");
        TextView textView = new TextView(mActivity);
        textView.setText("新闻中心");
        textView.setTextColor(Color.RED);
        textView.setGravity(Gravity.CENTER);

        //给帧布局动态添加
        flContent.addView(textView);

    }
}