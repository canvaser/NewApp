package com.summer.app.main;

//by summer on 2017-04-20.

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;

import com.summer.app.R;

public class FolderView extends ViewGroup{



    public FolderView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setBackgroundResource(R.drawable.drawable_bg_folder);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int w= getDefaultSize(getSuggestedMinimumWidth(), widthMeasureSpec);
        int h = getDefaultSize(getSuggestedMinimumHeight(), heightMeasureSpec);
        int l = w>h?h:w;
        setMeasuredDimension(l,l);
    }
}
