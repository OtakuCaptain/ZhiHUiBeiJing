package com.chen.zhihuibeijing.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

    private ImageView image;

    private TextView text;

    private ArrayList<NewsMenu.NewsMenuData> data;

    private LayoutInflater layoutInflater;

    private Context context;

    public LeftMenuAdapter(Context context, ArrayList<NewsMenu.NewsMenuData> data) {

        this.context = context;
        this.data = data;
        this.layoutInflater = LayoutInflater.from(context);
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
        return view;
    }
}

