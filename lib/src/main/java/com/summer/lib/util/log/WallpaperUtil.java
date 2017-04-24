package com.summer.lib.util.log;

import android.app.WallpaperManager;
import android.content.Context;

//by summer on 2017-04-20.
public class WallpaperUtil {

    private static WallpaperUtil instance;

    private WallpaperUtil(){

    }

    public static WallpaperUtil getInstance(){
        if(instance==null){
            instance = new WallpaperUtil();
        }
        return instance;
    }






}


