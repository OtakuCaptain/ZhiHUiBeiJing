package com.chen.zhihuibeijing;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;


import com.chen.zhihuibeijing.adapter.MenuItemAdapter;
import com.chen.zhihuibeijing.fragment.ContentFragment;

public class MainActivity extends AppCompatActivity {


    public ListView mLvLeftMenu;
    public DrawerLayout mDrawerLayout;
    private static final String TAG_CONTENT = "tag_content";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.dl_drwaer_layout);
        mLvLeftMenu = (ListView) findViewById(R.id.lv_nav_left);
        setUpDrawer();
        initFragment();

    }

    private void setUpDrawer() {
        LayoutInflater inflater = LayoutInflater.from(this);
        mLvLeftMenu.addHeaderView(inflater.inflate(R.layout.nav_header, mLvLeftMenu, false));
        mLvLeftMenu.setAdapter(new MenuItemAdapter(this));
    }

    private void initFragment() {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.fl_main, new ContentFragment(), TAG_CONTENT);
        transaction.commit();
    }
}
