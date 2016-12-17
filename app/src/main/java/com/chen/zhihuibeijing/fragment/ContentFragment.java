package com.chen.zhihuibeijing.fragment;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.chen.zhihuibeijing.R;
import com.chen.zhihuibeijing.base.BasePager;
import com.chen.zhihuibeijing.base.impl.GovAffairsPager;
import com.chen.zhihuibeijing.base.impl.HomePager;
import com.chen.zhihuibeijing.base.impl.NewsCenterPager;
import com.chen.zhihuibeijing.base.impl.SettingPager;
import com.chen.zhihuibeijing.base.impl.SmartServicePager;
import com.chen.zhihuibeijing.view.NoScrollViewPager;

import java.util.ArrayList;

public class ContentFragment extends BaseFragment {

    private NoScrollViewPager mViewPager;
    private ArrayList<BasePager> mPagers;
    private RadioGroup rgGroup;

    @Override
    public View initView() {
        View view = View.inflate(mActivity, R.layout.fragment_content, null);
        rgGroup = (RadioGroup) view.findViewById(R.id.rg_group);
        mViewPager = (NoScrollViewPager) view.findViewById(R.id.vp_content);
        return view;
    }

    @Override
    public void initData() {
        mPagers = new ArrayList<BasePager>();
        mPagers.add(new HomePager(mActivity));
        mPagers.add(new NewsCenterPager(mActivity));
        mPagers.add(new SmartServicePager(mActivity));
        mPagers.add(new GovAffairsPager(mActivity));
        mPagers.add(new SettingPager(mActivity));
        mViewPager.setAdapter(new ContentAdapter());

        rgGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_home:
                        mViewPager.setCurrentItem(0);
//                        mViewPager.setCurrentItem(0,false);参2表示是否需要切换动画
                        break;
                    case R.id.rb_newscenter:
                        mViewPager.setCurrentItem(1);
                        break;
                    case R.id.rb_smart:
                        mViewPager.setCurrentItem(2);
                        break;
                    case R.id.rb_gov:
                        mViewPager.setCurrentItem(3);
                        break;
                    case R.id.rb_setting:
                        mViewPager.setCurrentItem(4);
                        break;

                }
            }
        });

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                BasePager pager=mPagers.get(position);
                switch (position){
                    case 0:
                        rgGroup.check(R.id.rb_home);
                        break;
                    case 1:
                        rgGroup.check(R.id.rb_newscenter);
                        break;
                    case 2:
                        rgGroup.check(R.id.rb_smart);
                        break;
                    case 3:
                        rgGroup.check(R.id.rb_gov);
                        break;
                    case 4:
                        rgGroup.check(R.id.rb_setting);
                        break;
                }
                pager.initData();

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        //手动加载第一页数据
        mPagers.get(0).initData();


    }

    class ContentAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return mPagers.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {

            BasePager pagers = mPagers.get(position);
            View view = pagers.mRootView;//获取当前页面对象的布局
//            pagers.initData();//viewpager初始化数据，会自动加载下一个页面
            container.addView(view);

            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }
}
