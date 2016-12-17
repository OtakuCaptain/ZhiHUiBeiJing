package com.chen.zhihuibeijing.fragment;

import android.view.View;

import com.chen.zhihuibeijing.R;

public class ContentFragment extends BaseFragment {

    @Override
    public View initView() {
        View view = View.inflate(mActivity, R.layout.fragment_content, null);
        return view;
    }

    @Override
    public void initData() {
    }
}
