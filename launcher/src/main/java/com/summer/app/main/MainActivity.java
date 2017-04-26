package com.summer.app.main;

import android.os.Bundle;

import com.summer.app.R;
import com.summer.app.base.AppActivity;
import com.summer.app.folderapp.AppFolderFrag;
import com.summer.lib.ope.BaseOpes;
import com.summer.lib.util.FragmentUtil;
import com.summer.lib.value.BaseID;

public class MainActivity extends AppActivity<MainUIOpe,MainDAOpe> {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getOpes().getUiope().setWallpaper(activity);
        FragmentUtil.getInstance().addToContaier(activity,new AppsFrag(), R.id.rl_container,System.currentTimeMillis()+"");
    }

    @Override
    public BaseOpes<MainUIOpe, MainDAOpe> create() {
        return new BaseOpes<>(new MainUIOpe(activity,new MainUIBean(activity)),new MainDAOpe());
    }

    @Override
    public void onBackPressed() {

        if(getSupportFragmentManager().getFragments()!=null&&
                 getSupportFragmentManager().getFragments().size()>0&&
                getSupportFragmentManager().getFragments().get(getSupportFragmentManager().getFragments().size()-1)!=null
                ){
            if(getSupportFragmentManager().getFragments().get(getSupportFragmentManager().getFragments().size()-1) instanceof AppFolderFrag){
                AppFolderFrag appFolderFrag = (AppFolderFrag) getSupportFragmentManager().getFragments().get(getSupportFragmentManager().getFragments().size()-1);
                appFolderFrag.onClick(null);
            }
            else{
                super.onBackPressed();
            }
        }else{
            super.onBackPressed();
        }

    }
}
