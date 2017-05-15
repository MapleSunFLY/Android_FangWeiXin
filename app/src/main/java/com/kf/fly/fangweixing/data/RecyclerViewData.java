package com.kf.fly.fangweixing.data;

/**
 * Created by "FLY" on 2017/4/26.
 */
public class RecyclerViewData {

    private int viewType;

    private String name;

    private String logo;

    private String notificationText;

    private String notificationImg;

    public RecyclerViewData(){

    }

    public RecyclerViewData(int viewType, String name, String logo) {
        this.viewType = viewType;
        this.name = name;
        this.logo = logo;
    }

    public RecyclerViewData(int viewType, String name, String logo, String notificationText, String notificationImg) {
        this.viewType = viewType;
        this.name = name;
        this.logo = logo;
        this.notificationText = notificationText;
        this.notificationImg = notificationImg;
    }

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getNotificationText() {
        return notificationText;
    }

    public void setNotificationText(String notificationText) {
        this.notificationText = notificationText;
    }

    public String getNotificationImg() {
        return notificationImg;
    }

    public void setNotificationImg(String notificationImg) {
        this.notificationImg = notificationImg;
    }
}
