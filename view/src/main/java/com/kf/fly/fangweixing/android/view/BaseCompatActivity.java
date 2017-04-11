package com.kf.fly.fangweixing.android.view;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.util.Log;

/**
 * Created by "sinlov" on 2017/3/30.
 */
public abstract class BaseCompatActivity extends CompatActivity {

    protected  String TAG;

    private boolean isAddStack = false;
    public static boolean isDebugMode = false;
    private FragmentManager fragmentManager = getSupportFragmentManager();
    private static final int FINISH_BACK_STACK_THRESHOLD = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        TAG = "FLY."+this.getClass().getCanonicalName();
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (isDebugMode) {

        }else {

        }
        synchronized (this) {
        }
    }

}
