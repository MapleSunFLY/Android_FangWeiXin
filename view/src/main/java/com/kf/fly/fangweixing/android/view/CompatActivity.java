package com.kf.fly.fangweixing.android.view;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by "sinlov" on 2017/3/29.
 */
public abstract class CompatActivity extends AppCompatActivity {
    private long testTimeUse;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        processLogic(savedInstanceState);
    }

    /**
     * process logic and resumes states etc.
     *
     * @param savedInstanceState {@link Bundle}
     */
    protected abstract void processLogic(Bundle savedInstanceState);


    protected void showToast(String text){
        Toast.makeText(this.getApplicationContext(),text,Toast.LENGTH_SHORT).show();
    }

    protected void showToast(int id){
        Toast.makeText(this.getApplicationContext(),id,Toast.LENGTH_SHORT).show();
    }

    protected void skip2Acivity(Class<?> cls,Bundle bundle){
        Intent intent = new Intent(CompatActivity.this,cls);
        if (null != bundle){
            intent.putExtras(bundle);
        }

        startActivity(intent);
    }

    protected void skip2Activity(Class<?> cls){
        skip2Acivity(cls, null);
    }

    protected void testTimeUseStart() {
        testTimeUse = System.currentTimeMillis();
    }

    protected long testTimeUseEnd() {
        long useTime = System.currentTimeMillis() - testTimeUse;
        Log.d("CompatActivity", "testTimeUse: " + useTime);
        return useTime;
    }
}
