package com.kf.fly.fangweixing.view.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.kf.fly.fangweixing.R;
import com.kf.fly.fangweixing.data.RecyclerViewData;
import com.kf.fly.fangweixing.tools.GetResId;
import com.kf.fly.fangweixing.view.fragment.appstore.ViewPagerFragment;
import com.kf.fly.fangweixing.view.fragment.recycler.FragmentAdapter;
import com.kf.fly.fangweixing.view.fragment.recycler.FragmentViewHolder;
import com.kf.fly.fangweixing.view.fragment.recycler.FragmentViewItems;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by "FLY" on 2017/4/26.
 */
public class ContactsFragment extends ViewPagerFragment {

    private RecyclerView mRecyclerView;
    private FragmentAdapter mAdapter;
    private List<RecyclerViewData> mData;

    @Override
    protected void initView(Bundle savedInstanceState) {
        setContentView(R.layout.fragment_main_contacts);
        initData();
        //1 实例化RecyclerView
        mRecyclerView = (RecyclerView) contentView.findViewById(R.id.fragment_main_contacts_recycler);
        //2 为RecyclerView创建布局管理器，这里使用的是LinearLayoutManager，表示里面的Item排列是线性排列
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        handlerRecyclerView();

    }

    @Override
    protected void setListeners() {

    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {

    }

    @Override
    protected void onUserVisible() {

    }

    private void initData() {
        mData = new ArrayList<RecyclerViewData>();
        mData.add(new RecyclerViewData(1, "枫阳", "recycler_my", "FLY346422332", "recycler_two"));
        mData.add(new RecyclerViewData(4, "相册", "recycler_photo"));
        mData.add(new RecyclerViewData(5, "收藏", "recycler_collect"));
        mData.add(new RecyclerViewData(4, "钱包", "recycler_money"));
        mData.add(new RecyclerViewData(5, "卡包", "recycler_card"));
        mData.add(new RecyclerViewData(4, "设置", "recycler_install"));
    }

    private void handlerRecyclerView() {
        FragmentAdapter mAdapter = new FragmentAdapter(getActivity(), mData) {
            @Override
            public void convert(FragmentViewHolder holder, RecyclerViewData data) {
                switch (data.getViewType()) {
                    case FragmentViewItems.TEMPLATE_1:
                        break;
                    case FragmentViewItems.TEMPLATE_2:
                        handlerTemplate2(holder, data);
                        break;
                    case FragmentViewItems.TEMPLATE_3:
                        break;
                    case FragmentViewItems.TEMPLATE_4:
                        break;
                    case FragmentViewItems.TEMPLATE_5:
                        handlerTemplate5(holder, data);
                        break;
                    case FragmentViewItems.TEMPLATE_6:
                        handlerTemplate6(holder, data);
                        break;
                    default:
                        Log.d(TAG, "no viewType is : " + data.getViewType());
                        break;
                }
            }
        };
        //3 设置数据适配器
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new FragmentAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(ViewGroup parent, View view, Object o, int position) {
                RecyclerViewData data = (RecyclerViewData) o;
                Toast.makeText(getContext(), data.getName() + " :  " + position, Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void handlerTemplate2(FragmentViewHolder holder, RecyclerViewData data) {
        ImageView photo = holder.getView(R.id.recyclerview_item_my_photo);
        photo.setImageResource(GetResId.getDrawableId(getContext(), data.getLogo()));
        TextView name = holder.getView(R.id.recyclerview_item_my_name);
        name.setText(data.getName());
        TextView number = holder.getView(R.id.recyclerview_item_my_number);
        number.setText("微信号: " + data.getNotificationText());
        ImageView two = holder.getView(R.id.recyclerview_item_my_two);
        two.setImageResource(GetResId.getDrawableId(getContext(),data.getNotificationImg()));
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"two 000000 ",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void handlerTemplate5(FragmentViewHolder holder, RecyclerViewData data) {
        ImageView photo = holder.getView(R.id.recyclerview_item_ordinary_1_img);
        photo.setImageResource(GetResId.getDrawableId(getContext(),data.getLogo()));
        TextView name = holder.getView(R.id.recyclerview_item_ordinary_1_text);
        name.setText(data.getName());
        if (null!= data.getNotificationText() ){
            TextView number = holder.getView(R.id.recyclerview_item_notification_1_img);
            number.setVisibility(View.VISIBLE);
            number.setText(data.getNotificationText());
        }
        if (null != data.getNotificationImg()){
            ImageView two = holder.getView(R.id.recyclerview_item_notification_1_text);
            two.setVisibility(View.VISIBLE);
            two.setImageResource(GetResId.getDrawableId(getContext(),data.getNotificationImg()));
        }
    }

    private void handlerTemplate6(FragmentViewHolder holder, RecyclerViewData data) {
        ImageView photo = holder.getView(R.id.recyclerview_item_ordinary_2_img);
        photo.setImageResource(GetResId.getDrawableId(getContext(),data.getLogo()));
        TextView name = holder.getView(R.id.recyclerview_item_ordinary_2_text);
        name.setText(data.getName());
        if (null!= data.getNotificationText() ){
            TextView number = holder.getView(R.id.recyclerview_item_notification_2_img);
            number.setVisibility(View.VISIBLE);
            number.setText(data.getNotificationText());
        }
        if (null != data.getNotificationImg()){
            ImageView two = holder.getView(R.id.recyclerview_item_notification_2_text);
            two.setVisibility(View.VISIBLE);
            two.setImageResource(GetResId.getDrawableId(getContext(),data.getNotificationImg()));
        }
    }


}
