package com.chen.zhihuibeijing;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

public class GuideActivity extends AppCompatActivity {

    private ViewPager mViewPager;

    private ArrayList<ImageView> mImageViewList;
    private int[] mImageIds=new int[]{R.drawable.guide_1,R.drawable.guide_2,R.drawable.guide_3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_guide);
        mViewPager = (ViewPager) findViewById(R.id.vp_guide);
        initData();
        mViewPager.setAdapter(new GuideAdapter());
    }

    private void initData(){

        mImageViewList=new ArrayList<>();
        for (int i = 0; i < mImageIds.length; i++) {
            ImageView view=new ImageView(this);
            view.setBackgroundResource(mImageIds[i]);
            mImageViewList.add(view);
        }
    }

    class GuideAdapter extends PagerAdapter {

        //item的个数
        @Override
        public int getCount() {
            return mImageViewList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {

            ImageView view = mImageViewList.get(position);
            container.addView(view);
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View)object);
        }
    }
}
