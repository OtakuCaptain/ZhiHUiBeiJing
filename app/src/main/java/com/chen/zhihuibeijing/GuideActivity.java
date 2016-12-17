package com.chen.zhihuibeijing;

import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.chen.zhihuibeijing.util.PrefUtil;

import java.util.ArrayList;

public class GuideActivity extends AppCompatActivity {

    private ViewPager mViewPager;

    private ArrayList<ImageView> mImageViewList;
    private int[] mImageIds = new int[]{R.drawable.guide_1, R.drawable.guide_2, R.drawable.guide_3};
    private LinearLayout llContainer;
    private ImageView ivRedPoint;
    private int mPointDis;
    private Button btnStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        mViewPager = (ViewPager) findViewById(R.id.vp_guide);
        llContainer = (LinearLayout) findViewById(R.id.ll_container);
        ivRedPoint = (ImageView) findViewById(R.id.iv_red_point);
        btnStart= (Button) findViewById(R.id.btn_start);
        initData();
        mViewPager.setAdapter(new GuideAdapter());
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                //滑动过程中回调
                int leftMargin = (int) (mPointDis * positionOffset)+position*mPointDis;//计算小红点当前的左边距
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ivRedPoint.getLayoutParams();
                layoutParams.leftMargin = leftMargin;//修改左边距
                ivRedPoint.setLayoutParams(layoutParams);
            }

            @Override
            public void onPageSelected(int position) {
                if (position==mImageViewList.size()-1){
                    btnStart.setVisibility(View.VISIBLE);//最后一页显示开始按钮
                }else {
                    btnStart.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        ivRedPoint.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                ivRedPoint.getViewTreeObserver().removeOnGlobalLayoutListener(this);

                //layout方法执行结束后的回调
                mPointDis = llContainer.getChildAt(1).getLeft() - llContainer.getChildAt(0).getLeft();
            }
        });

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //更新sp
                PrefUtil.setBoolean(getApplication(),"is_first_enter",false);
                //跳转主页面
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

    private void initData() {

        mImageViewList = new ArrayList<>();
        for (int i = 0; i < mImageIds.length; i++) {
            ImageView view = new ImageView(this);
            view.setBackgroundResource(mImageIds[i]);
            mImageViewList.add(view);

            //初始化圆点
            ImageView point = new ImageView(this);
            point.setImageResource(R.drawable.shape_point_gray);//设置图片
            //初始化布局参数
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);
            if (i > 0) {
                //设置左边距
                params.leftMargin = 20;
            }
            point.setLayoutParams(params);
            llContainer.addView(point);
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
            container.removeView((View) object);
        }
    }
}
