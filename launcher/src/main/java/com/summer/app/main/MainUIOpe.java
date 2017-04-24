package com.summer.app.main;

//by summer on 2017-04-20.

import android.app.WallpaperManager;
import android.content.Context;

import com.summer.lib.ope.BaseUIOpe;

public class MainUIOpe extends BaseUIOpe<MainUIBean>{

    public MainUIOpe(Context context, MainUIBean uiBean) {
        super(context, uiBean);
    }

    public void setWallpaper(Context context){
        getUiBean().ivBg.setImageDrawable(WallpaperManager.getInstance(context).getDrawable());
    }
}
