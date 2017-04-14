package com.kf.fly.fangweixing.android.view.frament;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.kf.fly.fangweixing.android.view.BaseCompatActivity;

/**
 * Created by "sinlov" on 2017/4/11.
 */
public abstract class BaseCompatFragment extends Fragment {

    private static final String STATE_SAVE_IS_HIDDEN = "Fragment:STATE:SAVE_IS_HIDDEN";

    protected String TAG;

    protected BaseCompatActivity mActivity;
    private FragmentManager mFramentManager;

    /**
     * view of this fragment
     */
    protected View contentView;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        TAG = "FLY."+this.getClass().getCanonicalName();
        mActivity = (BaseCompatActivity) getActivity();
        mFramentManager = getFragmentManager();
    }

    /**
     *  FragmentState没帮我们保存Hidden状态，那就我们自己来保存，在页面重启后，我们自己来决定Fragment是否显示！
     *  解决思路转变了，由Activity/父Fragment来管理子Fragment的Hidden状态转变为 由Fragment自己来管理自己的Hidden状态！
     *  优点：不管多深的嵌套Fragment、同级Fragment等场景，全都可以正常工作，不会发生重叠！
     *  缺点：无。
     *  @param savedInstanceState
     */

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (null != savedInstanceState){
            boolean isSupportHidden = savedInstanceState.getBoolean(STATE_SAVE_IS_HIDDEN);

            FragmentTransaction ft = getFragmentManager().beginTransaction();
            if (isSupportHidden) {
                ft.hide(this);
            } else {
                ft.show(this);
            }
            ft.commit();
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(STATE_SAVE_IS_HIDDEN, isHidden());
    }

    /**
     * 提取出Fragment公共代码，给出需要使用的点的抽象方法，用于继承实现
     * create view by method {@link BaseCompatActivity#setContentView(int)}
     * <br>this method can avid multiple loading xml files
     *
     * @param inflater           {@link LayoutInflater}
     * @param container          {@link ViewGroup}
     * @param savedInstanceState {@link Bundle}
     * @return {@link View}
     */
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (null == contentView) {
            initView(savedInstanceState);
            setListeners();
            processLogic(savedInstanceState);
        } else {
            ViewGroup parent = (ViewGroup) contentView.getParent();
            if (null != parent) {
                parent.removeView(contentView);
            }
        }
        return contentView;
    }

    protected void setContentView(@LayoutRes int layoutResID) {
        contentView = LayoutInflater.from(mActivity).inflate(layoutResID, null);
    }

    protected void setContentViewChildMode(@LayoutRes int layoutResID) {
        contentView = LayoutInflater.from(mActivity).inflate(layoutResID, null);
    }

    /**
     * init view
     *
     * @param savedInstanceState {@link Bundle}
     */
    protected abstract void initView(Bundle savedInstanceState);

    /**
     * set view listeners
     */
    protected abstract void setListeners();

    /**
     * process logic and resumes states etc.
     *
     * @param savedInstanceState {@link Bundle}
     */
    protected abstract void processLogic(Bundle savedInstanceState);

    /**
     * find view by id which in content view
     *
     * @param id   view id
     * @param <CV> extends {@link View}
     * @return extends view
     */
    @SuppressWarnings("unchecked")
    protected <CV extends View> CV getViewById(@IdRes int id) {
        return (CV) contentView.findViewById(id);
    }

    protected void showToast(String text){
        Toast.makeText(mActivity, text, Toast.LENGTH_SHORT).show();
    }

    protected void showToast(int id){
        Toast.makeText(mActivity,id,Toast.LENGTH_SHORT).show();
    }


}
