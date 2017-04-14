package com.kf.fly.fangweixing.view.fragment.appstore;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *     sinlov
 *
 *     /\__/\
 *    /`    '\
 *  ≈≈≈ 0  0 ≈≈≈ Hello world!
 *    \  --  /
 *   /        \
 *  /          \
 * |            |
 *  \  ||  ||  /
 *   \_oo__oo_/≡≡≡≡≡≡≡≡o
 *
 * </pre>
 * 稍微解释一下实现思路：
 * 1、缓存所有的 Fragment
 * 使用一个 List 将数据源对应的 Fragment 都缓存起来
 * 2、更新数据源，刷新 Fragment
 * 当有数据源更新的时候，从 List 中取出相应的 Fragment，然后刷新 Adapter
 * 3、删除数据时，删除 List 中对应的 Fragment
 * 当数据源中删除某项时，将 List 中对应的 Fragment 也删除，然后刷新 Adapter
 */
public class CommonViewPagerAdapter extends FragmentPagerAdapter {



    private final List<Fragment> mFragments = new ArrayList<>();
    private final List<String> mFragmentTitles = new ArrayList<>();

    public CommonViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    public void addFragment(Fragment fragment, String title) {
        mFragments.add(fragment);
        mFragmentTitles.add(title);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mFragmentTitles.get(position);
    }
}
