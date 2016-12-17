package com.chen.zhihuibeijing.base.impl;

import android.app.Activity;
import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.widget.TextView;

import com.chen.zhihuibeijing.base.BasePager;


public class SettingPager extends BasePager {
    public SettingPager(Activity activity) {
        super(activity);
    }

    //给帧布局填充对象
    @Override
    public void initData() {
        Log.i("Pager","设置初始化了");
        TextView textView = new TextView(mActivity);
        textView.setText("设置");
        textView.setTextColor(Color.RED);
        textView.setGravity(Gravity.CENTER);

        //给帧布局动态添加
        flContent.addView(textView);

    }
}