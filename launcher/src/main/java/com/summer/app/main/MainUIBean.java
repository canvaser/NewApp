package com.summer.app.main;

//by summer on 2017-04-20.

import android.content.Context;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.summer.app.R;
import com.summer.lib.bean.BaseUIBean;

import butterknife.BindView;

public class MainUIBean extends BaseUIBean {

    @BindView(R.id.activity_main)
    RelativeLayout activityMain;
    @BindView(R.id.iv_bg)
    ImageView ivBg;

    public MainUIBean(Context context) {
        super(context, R.layout.act_main);
    }


}
