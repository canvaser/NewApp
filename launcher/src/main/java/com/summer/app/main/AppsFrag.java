package com.summer.app.main;

//by summer on 2017-04-20.

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.summer.app.R;
import com.summer.app.folderapp.AppFolderFrag;
import com.summer.app.folderapp.XY;
import com.summer.app.main.app.AppsUIBean;
import com.summer.lib.ope.BaseOpes;
import com.summer.lib.ui.frag.BaseUIFrag;
import com.summer.lib.util.FragmentUtil;
import com.summer.lib.util.ToastUtil;
import com.summer.lib.value.BaseID;
import com.summer.lib.value.ValueConstant;

public class AppsFrag extends BaseUIFrag<AppsUIOpe,MainDAOpe> implements View.OnClickListener{

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getOpes().getUiope().loadApps(activity);
        getOpes().getUiope().getUiBean().getAppsview().setOnClickListener(this);

    }

    @Override
    public BaseOpes<AppsUIOpe, MainDAOpe> create() {
        return new BaseOpes<>(new AppsUIOpe(activity,new AppsUIBean(activity)),new MainDAOpe());
    }

    @Override
    public void onClick(View v) {
        AppFolderFrag appFolderFrag = new AppFolderFrag();
        Bundle bundle = new Bundle();
        XY xy = new XY();
        xy.x= (Integer) v.getTag(R.id.a);
        xy.y= (Integer) v.getTag(R.id.b);
        bundle.putSerializable(ValueConstant.DATA_DATA,xy);
        appFolderFrag.setArguments(bundle);

        FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();
        //transaction.setCustomAnimations(com.summer.lib.R.anim.anim_push_left_in, com.summer.lib.R.anim.anim_push_right_out);
        transaction.add(BaseID.ID_ACT_ROOT, appFolderFrag,appFolderFrag.getClass().getName());
        try {
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
