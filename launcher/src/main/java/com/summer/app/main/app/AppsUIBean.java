package com.summer.app.main.app;

//by summer on 2017-04-20.

import android.content.Context;
import android.widget.RelativeLayout;

import com.summer.app.R;
import com.summer.app.main.MainAppsView;
import com.summer.lib.bean.BaseUIBean;

import butterknife.BindView;

public class AppsUIBean extends BaseUIBean {
    @BindView(R.id.appsview)
    MainAppsView appsview;
    @BindView(R.id.activity_main)
    RelativeLayout activityMain;


    public AppsUIBean(Context context) {
        super(context, R.layout.frag_main);
    }

    public MainAppsView getAppsview() {
        return appsview;
    }

    public RelativeLayout getActivityMain() {
        return activityMain;
    }
}
