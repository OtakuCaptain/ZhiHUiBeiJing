package com.chen.zhihuibeijing.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.chen.zhihuibeijing.MainActivity;
import com.chen.zhihuibeijing.R;
import com.chen.zhihuibeijing.domain.NewsMenu;

import java.util.ArrayList;

/**
 * Created by chen on 2016-12-19.
 */

public class LeftMenuAdapter extends BaseAdapter {

    private ArrayList<NewsMenu.NewsMenuData> data;

    private LayoutInflater layoutInflater;
    private Context context;
    public int mCurrentPositon;

    public LeftMenuAdapter(final MainActivity mainActivity, ArrayList<NewsMenu.NewsMenuData> data) {

        this.context = mainActivity;
        this.data = data;
        this.layoutInflater = LayoutInflater.from(context);
        mainActivity.mLvLeftMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mainActivity.mDrawerLayout.closeDrawers();
                mCurrentPositon=position-1;
                Refresh();
            }
        });
    }

    private void Refresh(){
        this.notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public NewsMenu.NewsMenuData getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = View.inflate(context, R.layout.list_item_left_menu, null);
        TextView leftMenu = (TextView) view.findViewById(R.id.tv_left);
        NewsMenu.NewsMenuData item = getItem(position);
        leftMenu.setText(item.title);
        if (position==mCurrentPositon){
            leftMenu.setEnabled(true);
        }else {
            leftMenu.setEnabled(false);
        }
        return view;
    }
}

