package com.chen.zhihuibeijing.base.impl;

import android.app.Activity;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.chen.zhihuibeijing.MainActivity;
import com.chen.zhihuibeijing.base.BasePager;


public class HomePager extends BasePager {
    public HomePager(Activity activity) {
        super(activity);
    }

    //给帧布局填充对象
    @Override
    public void initData() {
        Log.i("Pager", "首页初始化了");
        TextView textView = new TextView(mActivity);
        textView.setText("首页");
        textView.setTextColor(Color.RED);
        textView.setGravity(Gravity.CENTER);

        //给帧布局动态添加
        flContent.addView(textView);
        btnMenu.setVisibility(View.GONE);

    }
}
