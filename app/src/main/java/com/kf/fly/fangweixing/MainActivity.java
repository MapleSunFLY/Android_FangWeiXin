package com.kf.fly.fangweixing;


import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.RadioGroup;

import com.kf.fly.fangweixing.android.view.BaseCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseCompatActivity {

    @BindView(R.id.app_mian_viewpager)
    ViewPager mViewPager;

    @BindView(R.id.main_radiogroup)
    RadioGroup mRadioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化BindView
        ButterKnife.bind(this);
        initToolbar();
        monitoringRadioGrop();
    }

    private void monitoringRadioGrop(){
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.main_radiobutton_weixing:
                        showToast(R.string.main_radiobutton_weixing);
                        break;
                    case R.id.main_radiobutton_contacts:
                        showToast(R.string.main_radiobutton_contects);
                        break;
                    case R.id.main_radiobutton_find:
                        showToast(R.string.main_radiobutton_find);
                        break;
                    case R.id.main_radiobutton_my:
                        showToast(R.string.main_radiobutton_my);
                        break;
                    default:
                        Log.d(TAG,"怎么监听的????");
                        break;
                }
            }
        });
    }

    private void initToolbar() {
        Toolbar mToolbar = (Toolbar) findViewById(R.id.tool_bar_main);
        //添加溢出菜单
        mToolbar.inflateMenu(R.menu.setting_menu);
        // 添加菜单点击事件
        mToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.item_search:
                        showToast(R.string.main_menu_search);
                        break;
                    case R.id.item_chat:
                        //点击设置菜单
                        showToast(R.string.main_menu_chat);
                        break;
                    case R.id.item_add_person:
                        //点击设置菜单
                        showToast(R.string.main_menu_add_person);
                        break;
                    case R.id.item_richscan:
                        //点击设置菜单
                        showToast(R.string.main_menu_richscan);
                        break;
                    case R.id.item_money:
                        //点击设置菜单
                        showToast(R.string.main_menu_money);
                        break;
                    case R.id.item_help:
                        //点击设置菜单
                        showToast(R.string.main_menu_help);
                        break;
                }
                return false;
            }
        });

    }


    @Override
    protected void processLogic(Bundle savedInstanceState) {

    }
}
