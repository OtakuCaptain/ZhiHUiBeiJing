package com.chen.zhihuibeijing.base.impl;

import android.app.Activity;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.widget.TextView;
import android.widget.Toast;

import com.chen.zhihuibeijing.MainActivity;
import com.chen.zhihuibeijing.base.BasePager;
import com.chen.zhihuibeijing.domain.NewsMenu;
import com.chen.zhihuibeijing.global.GlobalConstants;
import com.chen.zhihuibeijing.util.HttpUtil;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;


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
        getDataFromServer();

    }
    private void getDataFromServer(){
        HttpUtil.sendOkHttpRequest(GlobalConstants.CATEGORY_URL, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
                mActivity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(mActivity, "获取天气信息失败", Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
               String result= response.body().string();
                Log.i("Pager",result);
                processData(result);
            }
        });
    }

    private void processData(String json){
        Gson gson=new Gson();
        NewsMenu newsMenu = gson.fromJson(json, NewsMenu.class);
        Log.i("Pager", String.valueOf(newsMenu));
    }

}
