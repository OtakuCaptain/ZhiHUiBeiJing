package com.chen.zhihuibeijing.base;

import android.app.Activity;
import android.support.v4.view.GravityCompat;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import com.chen.zhihuibeijing.MainActivity;
import com.chen.zhihuibeijing.R;


public class BasePager {

    public MainActivity mActivity;
    public TextView tvTitle;
    public ImageButton btnMenu;
    public FrameLayout flContent;
    public View mRootView;

    public BasePager(MainActivity activity) {
        mActivity = activity;
        mRootView = initView();
    }

    //初始化布局
    public View initView() {
        View view = View.inflate(mActivity, R.layout.base_page, null);
        tvTitle = (TextView) view.findViewById(R.id.tv_title);
        btnMenu = (ImageButton) view.findViewById(R.id.btn_menu);
        flContent = (FrameLayout) view.findViewById(R.id.fl_content);
        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               mActivity.mDrawerLayout.openDrawer(GravityCompat.START);
            }
        });
        return view;
    }

    public void initData() {

    }

}
