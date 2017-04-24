package com.summer.lib.bean;

//by summer on 2017-04-20.

import android.support.v7.widget.RecyclerView;
import android.view.View;

public abstract class BaseViewHolder<A extends BaseUIBean> extends RecyclerView.ViewHolder{

    A uiBean;

    public BaseViewHolder(A uiBean) {
        super(uiBean.getView());
        this.uiBean = uiBean;
    }


    public A getUiBean() {
        return uiBean;
    }
}
