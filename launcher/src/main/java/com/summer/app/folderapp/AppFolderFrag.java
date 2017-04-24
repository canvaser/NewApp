package com.summer.app.folderapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.summer.app.R;
import com.summer.app.main.AppsFrag;
import com.summer.lib.interf.OnFinishListener;
import com.summer.lib.util.AnimUtil;
import com.summer.lib.util.FragmentUtil;
import com.summer.lib.util.ToastUtil;
import com.summer.lib.value.ValueConstant;

import butterknife.OnClick;

public class AppFolderFrag extends AppsFrag {
    XY xy;
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        xy = (XY) getArguments().getSerializable(ValueConstant.DATA_DATA);
        AnimUtil.getInstance().animIn(getView(),xy.x,xy.y);
    }

    @OnClick({R.id.activity_main})
    public void onClick(View v){

        AnimUtil.getInstance().animOut(getView(), xy.x, xy.y, new OnFinishListener() {
            @Override
            public void onFinish(Object o) {
                FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();
                transaction.remove(AppFolderFrag.this);
                transaction.commit();
            }
        });

    }

}