package com.summer.lib.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.summer.lib.R;
import com.summer.lib.ope.BaseDAOpe;
import com.summer.lib.ope.BaseOpes;
import com.summer.lib.ope.BaseUIOpe;

import butterknife.ButterKnife;

public abstract class BaseUIActivity<A extends BaseUIOpe, B extends BaseDAOpe> extends BaseActivity {

    private BaseOpes<A, B> opes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        isFullScreen(isFullScreen());
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        super.onCreate(savedInstanceState);
//        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.layout_base_ui);
        //StatusBarUtil.getInstance().setStatusBarColorResId(activity, ColorConstant.COLOR_STATUS);
        ViewGroup containerVG = (ViewGroup) findViewById(R.id.base_ui_root);
        if(getOpes()!=null){
            if(getOpes().getUiope()!=null){
                containerVG.addView(getOpes().getUiope().getUiBean().getView());
            }
        }
        ButterKnife.bind(activity);
    }

    public boolean isFullScreen() {
        return false;
    }

    private void isFullScreen(boolean is) {
        if (is) {
            // 隐藏标题栏
            requestWindowFeature(Window.FEATURE_NO_TITLE);
            // 隐藏状态栏
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
    }

    public BaseOpes<A, B> getOpes() {
        if (opes == null) {
            opes = create();
        }
        return opes;
    }

    public abstract BaseOpes<A, B> create();
}