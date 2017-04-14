package com.kf.fly.fangweixing;


import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.kf.fly.fangweixing.android.view.BaseCompatActivity;
import com.kf.fly.fangweixing.view.fragment.appstore.CommonViewPagerAdapter;
import com.kf.fly.fangweixing.view.fragment.weixin.WeiXingFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseCompatActivity {

    @BindView(R.id.app_mian_viewpager)
    ViewPager mViewPager;

    @BindView(R.id.main_radiogroup)
    RadioGroup mRadioGroup;

    @BindView(R.id.main_radiobutton_weixing)
    RadioButton radiobuttonWeiXing;

    @BindView(R.id.main_radiobutton_contacts)
    RadioButton radiobuttonContacts;

    @BindView(R.id.main_radiobutton_find)
    RadioButton radiobuttonFind;

    @BindView(R.id.main_radiobutton_my)
    RadioButton radiobuttonMy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化BindView
        ButterKnife.bind(this);
        initFragment();
        initToolbar();
        monitoringRadioGrop();
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

    private void initFragment() {

        CommonViewPagerAdapter adapter = new CommonViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new WeiXingFragment(), getString(R.string.main_radiobutton_weixing));
        adapter.addFragment(new WeiXingFragment(), getString(R.string.main_radiobutton_weixing));
        adapter.addFragment(new WeiXingFragment(), getString(R.string.main_radiobutton_weixing));
        adapter.addFragment(new WeiXingFragment(), getString(R.string.main_radiobutton_weixing));
        mViewPager.setAdapter(adapter);
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            /**页面滚动时回调的方法
             * position:当前页面向下滑动的角标
             * positionOffset:当前页面滑动的偏移量
             * positionOffsetPixels:当前页面滑动的偏移量对应的像素值
             * */

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            /**
             * 页面被选中时回调的方法
             * position  ：表示页面的位置
             **/
            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        radiobuttonWeiXing.setChecked(true);
                        break;
                    case 1:
                        radiobuttonContacts.setChecked(true);
                        break;
                    case 2:
                        radiobuttonFind.setChecked(true);
                        break;
                    case 3:
                        radiobuttonMy.setChecked(true);
                        break;
                }
            }

            /**当页面滚动状态改变时回调的方法
             * 参数包含三种状态：
             *  SCROLL_STATE_IDLE  ：停止状态
             *  SCROLL_STATE_DRAGGING：滚动状态
             *  SCROLL_STATE_SETTLING：选中状态
             * */

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        mViewPager.setCurrentItem(0);
    }




    private void monitoringRadioGrop() {
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.main_radiobutton_weixing:
                        showToast(R.string.main_radiobutton_weixing);
                        mViewPager.setCurrentItem(0);
                        break;
                    case R.id.main_radiobutton_contacts:
                        showToast(R.string.main_radiobutton_contects);
                        mViewPager.setCurrentItem(1);
                        break;
                    case R.id.main_radiobutton_find:
                        showToast(R.string.main_radiobutton_find);
                        mViewPager.setCurrentItem(2);
                        break;
                    case R.id.main_radiobutton_my:
                        showToast(R.string.main_radiobutton_my);
                        mViewPager.setCurrentItem(3);
                        break;
                    default:
                        Log.d(TAG, "怎么监听的????");
                        break;
                }
            }
        });
    }


    @Override
    protected void processLogic(Bundle savedInstanceState) {

    }
}
