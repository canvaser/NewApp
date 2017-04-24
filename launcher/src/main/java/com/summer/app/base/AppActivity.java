package com.summer.app.base;

//by summer on 2017-04-20.

import android.os.Bundle;

import com.summer.lib.ope.BaseDAOpe;
import com.summer.lib.ope.BaseUIOpe;
import com.summer.lib.ui.activity.BaseUIActivity;
import com.summer.lib.util.statusbar.StatusBarUtil;
import com.summer.lib.value.color.ColorConstant;

public abstract class AppActivity<A extends BaseUIOpe, B extends BaseDAOpe>  extends BaseUIActivity<A,B>{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarUtil.getInstance().setStatusBarColorResId(activity, ColorConstant.COLOR_TRANSPARENT);
    }
}
