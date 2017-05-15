package com.kf.fly.fangweixing.view.fragment.recycler;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.kf.fly.fangweixing.R;
import com.kf.fly.fangweixing.data.RecyclerViewData;

import java.util.List;

/**
 * Created by "FLY" on 2017/4/26.
 *
 */
public abstract class FragmentAdapter extends RecyclerView.Adapter<FragmentViewHolder> {

    private static final String TAG = "FLY.FragmentAdapter";
    private int mLayoutId;
    private Context mContext;
    private List<RecyclerViewData> mDataSet;

    /**
     * 构造器，接受数据集
     *
     * @param context
     * @param date
     */
    public FragmentAdapter(Context context,List<RecyclerViewData> date){
        mContext = context;
        mDataSet = date;
    }

    /**
     * onCreateViewHolder:创建ViewHolder，
     * 该方法会在RecyclerView需要展示一个item的时候回调。
     * 重写该方法时，应该使ViewHolder加载item view的布局。
     * 这个能发避免了不必要的findViewById操作，提高了性能。
     *
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public FragmentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //加载布局
        switch (viewType){
            case FragmentViewItems.TEMPLATE_1:
                break;
            case FragmentViewItems.TEMPLATE_2:
                mLayoutId = R.layout.fragment_main_recycler_view_item_my;
                break;
            case FragmentViewItems.TEMPLATE_3:
                break;
            case FragmentViewItems.TEMPLATE_4:
                break;
            case FragmentViewItems.TEMPLATE_5:
                mLayoutId = R.layout.fragment_main_recycler_view_item_ordinary_notification_1;
                break;
            case FragmentViewItems.TEMPLATE_6:
                mLayoutId = R.layout.fragment_main_recycler_view_item_ordinary_notification_2;
                break;
            default:
                Log.d(TAG,"no viewType is : " +viewType );
                break;
        }
        FragmentViewHolder holder = FragmentViewHolder.get(mContext,null,parent,mLayoutId);
        setListener(parent, holder);
        return holder;
    }



    /**
     * onBindeViewHolder:该方法在RecyclerView在特定位置展示数据时候回调，顾名思义，把数据绑定、填充到相应的item view中
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(FragmentViewHolder holder, int position) {
        //将数据填充到具体的view中
        convert(holder, mDataSet.get(position));
    }

    public abstract void convert(FragmentViewHolder holder, RecyclerViewData data);

    /**
     * 通过重写getItemViewType(int position)方法来告诉onCreateViewHolder(...)每个条目对应的布局
     * @param position
     * @return
     */
    @Override
    public int getItemViewType(int position) {
        return mDataSet.get(position).getViewType();
    }


    /**
     * getItemCount:返回数据的数量
     * @return
     */
    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    /**
     * java回调机制，依赖于子Item View的onClickListener及onLongClickListener。
     * @param <T> //数据类
     */
    public interface OnItemClickListener<T>{
        //RecyclerView监听
        void onItemClick(ViewGroup parent, View view, T t, int position);
    }
    public interface OnItemLongClickListener<T>{
        //长按监听
        boolean onItemLongClick(ViewGroup parent, View view, T t, int position);
    }

    private OnItemClickListener mOnItemClickListener;
    private OnItemLongClickListener mOnItemLongClickListener;

    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener){
        this.mOnItemClickListener = mOnItemClickListener;
    }

    public void setOnItemLongClickListener(OnItemLongClickListener mOnItemLongClickListener) {
        this.mOnItemLongClickListener = mOnItemLongClickListener;
    }

    protected void setListener(final ViewGroup parent, final FragmentViewHolder holder){
        //判断是否设置了监听器
        if(mOnItemClickListener != null) {
            //为ItemView设置监听器
            holder.getConvertView().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = holder.getLayoutPosition();
                    mOnItemClickListener.onItemClick(parent, v, mDataSet.get(position), position);
                }
            });
        }
        if(mOnItemLongClickListener != null){
            holder.getConvertView().setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    if (mOnItemLongClickListener != null) {
                        int position = holder.getLayoutPosition();
                        return mOnItemLongClickListener.onItemLongClick(parent, v, mDataSet.get(position), position);
                        //返回true 表示消耗了事件 事件不会继续传递
                    }

                    return false;
                }
            });
        }
    }

}
