package com.summer.lib.app;

import android.app.Activity;
import android.app.Application;

import com.summer.lib.R;
import com.summer.lib.util.ScreenUtil;
import com.summer.lib.value.ValueConstant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * 用于一些跟应用程序生命周期一致的处理
 */
public class LibAplication extends Application {

    HashMap<String, Activity> activityHashMap = new HashMap<>();

    ArrayList<Activity> activities = new ArrayList<>();

    @Override
    public void onCreate() {
        super.onCreate();
        ScreenUtil.getInstance().getScreenSize(this);
        ValueConstant.DIMEN_1 = (int) getResources().getDimension(R.dimen.dimen_1);
    }

    /**
     * 退出结束所有界面
     */
    public void exit() {
        Iterator iterator = activityHashMap.keySet().iterator();
        while (iterator.hasNext()) {
            activityHashMap.get(iterator.next()).finish();
        }
        activityHashMap.clear();
        System.gc();
    }


    public HashMap<String, Activity> getActivityHashMap() {
        return activityHashMap;
    }

    public ArrayList<Activity> getActivities() {
        return activities;
    }
}