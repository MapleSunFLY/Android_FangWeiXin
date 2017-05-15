package com.kf.fly.fangweixing.view.fragment.recycler;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by "FLY" on 2017/4/26.
 */
public class FragmentViewHolder extends RecyclerView.ViewHolder {

    private SparseArray<View> mViews;
    private View mConvertView;
    private Context mContext;
    private int mLayoutId;

    public FragmentViewHolder(Context context ,View itemView,ViewGroup viewGroup) {
        super(itemView);
        mContext = context;

        //由于itemView是item的布局文件，我们需要的是里面的textView，因此利用itemView.findViewById获
        //取里面的View实例，后面通过onBindViewHolder方法能直接填充数据到每一个View了
        mConvertView = itemView;

        //运用泛型，适配所有的View，多布局，不用写多个RecyclerView.ViewHolder。
        mViews = new SparseArray<View>();
        mConvertView.setTag(this);
    }

    //创建缓存
    public static FragmentViewHolder get(Context context,View convertView,ViewGroup parent,int layoutId){
        if (null == convertView){
            View itemView = LayoutInflater.from(context).inflate(layoutId,parent,false);
            FragmentViewHolder holder = new FragmentViewHolder(context,itemView,parent);
            return holder;
        }else {
            FragmentViewHolder holder = (FragmentViewHolder) convertView.getTag();
            return holder;
        }
    }

    /**
     * 通过viewId获取控件
     *
     * @param viewId
     * @return
     */
    public <T extends View> T getView(int viewId)
    {
        View view = mViews.get(viewId);
        if (view == null)
        {
            view = mConvertView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T) view;
    }

    public View getConvertView()
    {
        return mConvertView;
    }

    /**
     * 设置TextView的值
     *
     * @param viewId
     * @param text
     * @return
     */
    public FragmentViewHolder setText(int viewId, String text)
    {
        TextView tv = getView(viewId);
        tv.setText(text);
        return this;
    }

    public FragmentViewHolder setImageResource(int viewId, int resId)
    {
        ImageView view = getView(viewId);
        view.setImageResource(resId);
        return this;
    }

    public FragmentViewHolder setImageBitmap(int viewId, Bitmap bitmap)
    {
        ImageView view = getView(viewId);
        view.setImageBitmap(bitmap);
        return this;
    }

    public FragmentViewHolder setImageDrawable(int viewId, Drawable drawable)
    {
        ImageView view = getView(viewId);
        view.setImageDrawable(drawable);
        return this;
    }

    public FragmentViewHolder setBackgroundColor(int viewId, int color)
    {
        View view = getView(viewId);
        view.setBackgroundColor(color);
        return this;
    }

    public FragmentViewHolder setBackgroundRes(int viewId, int backgroundRes)
    {
        View view = getView(viewId);
        view.setBackgroundResource(backgroundRes);
        return this;
    }

    public FragmentViewHolder setTextColor(int viewId, int textColor)
    {
        TextView view = getView(viewId);
        view.setTextColor(textColor);
        return this;
    }

    public FragmentViewHolder setTextColorRes(int viewId, int textColorRes)
    {
        TextView view = getView(viewId);
        view.setTextColor(mContext.getResources().getColor(textColorRes));
        return this;
    }


}
