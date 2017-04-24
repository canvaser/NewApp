package com.summer.app.main;

//by summer on 2017-04-20.

import android.content.Context;

import com.summer.app.main.app.AppsUIBean;
import com.summer.lib.ope.BaseUIOpe;

public class AppsUIOpe extends BaseUIOpe<AppsUIBean>{

    public AppsUIOpe(Context context, AppsUIBean uiBean) {
        super(context, uiBean);
    }


    public void loadApps(Context context){
        getUiBean().getAppsview().setAdapter();
        getUiBean().getAppsview().attachToItemTouch();
    }
}
