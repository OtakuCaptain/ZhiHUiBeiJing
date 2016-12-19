package com.chen.zhihuibeijing.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.chen.zhihuibeijing.R;
import com.chen.zhihuibeijing.adapter.LeftMenuAdapter;
import com.chen.zhihuibeijing.adapter.MenuItemAdapter;
import com.chen.zhihuibeijing.domain.NewsMenu;

import java.util.ArrayList;

/**
 * Created by chen on 2016-12-19.
 */

public class LeftMenuFragment extends BaseFragment {

    private ArrayList<NewsMenu.NewsMenuData> mNewsMenuData;

    private ListView lvNavLeft;

    @Override
    public View initView() {
        View view = View.inflate(mActivity, R.layout.fragment_leftmenu, null);
        lvNavLeft = (ListView) view.findViewById(R.id.lv_nav_left);
        return view;
    }

    @Override
    public void initData() {

    }



}
