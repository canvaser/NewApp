package com.summer.app.main;

//by summer on 2017-04-20.

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import com.summer.app.R;
import com.summer.app.main.app.AppUIBean;
import com.summer.lib.bean.BaseViewHolder;
import com.summer.lib.ui.adapter.AppRecycleAdapter;
import com.summer.lib.util.FragmentUtil;
import com.summer.lib.util.RandomUtil;
import com.summer.lib.value.BaseID;
import com.summer.lib.view.ItemDecoration.GridDecoration;

import java.util.Collections;

public class MainAppsView extends RecyclerView{

    ItemTouchHelper itemTouchHelper;

    OnClickListener onClickListener;

    public MainAppsView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setLayoutManager(new GridLayoutManager(getContext(),4));
        addItemDecoration(new GridDecoration(getContext(),0));
    }

    public void setAdapter(){
        setAdapter(new MainAppsAdapter(getContext()));
    }

    public void attachToItemTouch(){
        itemTouchHelper = new ItemTouchHelper(new ItemTouchHelper.Callback() {
            @Override
            public int getMovementFlags(RecyclerView recyclerView, ViewHolder viewHolder) {
                final int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN | ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;
                final int swipeFlags = 0;
                return makeMovementFlags(dragFlags,swipeFlags);
            }

            @Override
            public boolean onMove(RecyclerView recyclerView, ViewHolder viewHolder, ViewHolder target) {
                int fromPosition = viewHolder.getAdapterPosition();//得到拖动ViewHolder的position
                int toPosition = target.getAdapterPosition();//得到目标ViewHolder的position
                if (fromPosition < toPosition) {
                    for (int i = fromPosition; i < toPosition; i++) {
                       // Collections.swap(results, i, i + 1);
                    }
                } else {
                    for (int i = fromPosition; i > toPosition; i--) {
                        //Collections.swap(results, i, i - 1);
                    }
                }
                getAdapter().notifyItemMoved(fromPosition, toPosition);
                return true;
            }

            @Override
            public void onSwiped(ViewHolder viewHolder, int direction) {

            }
        });
        itemTouchHelper.attachToRecyclerView(this);
    }




    public class MainAppsAdapter extends AppRecycleAdapter<MainAppViewHolder>{


        public MainAppsAdapter(Context context) {
            super(context);
        }

        @Override
        public MainAppViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new MainAppViewHolder(new AppUIBean(context,parent));
        }

        @Override
        public void onBindViewHolder(MainAppViewHolder holder, int position) {
            //holder.getUiBean().getIvIcon().setImageResource(R.drawable.drawable_bed);
            holder.getUiBean().getTvName().setText("+++"+(RandomUtil.getInstance().nextInt(1000)));
            holder.getUiBean().getView().setOnClickListener(this);
        }

        @Override
        public int getItemCount() {
            return 16;
        }

        @Override
        public void onClick(View v) {
            v.setTag(R.id.a,v.getLeft()+v.getWidth()/2);
            v.setTag(R.id.b,v.getTop()+v.getHeight()/2);
         if(onClickListener!=null){
             onClickListener.onClick(v);
         }
        }

    }


    public class MainAppViewHolder extends BaseViewHolder<AppUIBean>{


        public MainAppViewHolder(AppUIBean uiBean) {
            super(uiBean);
        }
    }

    @Override
    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }
}
