package com.kf.fly.fangweixing.tools;

import android.content.Context;

/**
 * Created by "FLY" on 2017/4/27.
 */
public class GetResId {

    public static int getDrawableId(Context context, String drawableName){
        int resId = context.getResources().getIdentifier(drawableName,"drawable",context.getPackageName());
        return resId;
    }

    public static int getLayoutId(Context context, String drawableName){
        int resId = context.getResources().getIdentifier(drawableName,"layout",context.getPackageName());
        return resId;
    }

    public static int getMenuId(Context context, String drawableName){
        int resId = context.getResources().getIdentifier(drawableName,"menu",context.getPackageName());
        return resId;
    }

}
