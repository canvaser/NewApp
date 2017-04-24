package com.summer.app.main.app;

//by summer on 2017-04-20.

import android.content.Context;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.summer.app.R;
import com.summer.lib.bean.BaseUIBean;
import com.summer.lib.util.ScreenUtil;
import com.summer.lib.value.ValueConstant;

import butterknife.BindView;

public class AppUIBean extends BaseUIBean {

    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.rl_folder)
    RelativeLayout rlFolder;


    public AppUIBean(Context context, ViewGroup parent) {
        super(context, parent, R.layout.item_folder);
        getView().getLayoutParams().width = ScreenUtil.getInstance().getScreenSize(context)[0] / 4;
        getView().getLayoutParams().height = (ScreenUtil.getInstance().getScreenSize(context)[1] - ValueConstant.DIMEN_1 * 60) / 4;
        getView().requestLayout();
    }


    public TextView getTvName() {
        return tvName;
    }

    public RelativeLayout getRlFolder() {
        return rlFolder;
    }
}
