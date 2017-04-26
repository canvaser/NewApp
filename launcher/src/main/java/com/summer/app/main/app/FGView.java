package com.summer.app.main.app;

//by summer on 2017-04-24.

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.summer.lib.util.LogUtil;
import com.summer.lib.util.ToastUtil;

import java.util.ArrayList;

public class FGView extends View{


    public FGView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    float[][] floats = new float[][]{{0,0}};

    ArrayList<Float> Y0 = new ArrayList<>();
    ArrayList<Float> Y1 = new ArrayList<>();

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event .getAction()&MotionEvent.ACTION_MASK){
            case MotionEvent. ACTION_POINTER_DOWN:
            case MotionEvent. ACTION_DOWN:
                Y0.clear();
                Y1.clear();
                //Log. e("按下" ,event .getPointerCount()+"" );
                break;
            case MotionEvent. ACTION_UP:
            case MotionEvent. ACTION_POINTER_UP:
                //Log. e("抬起" ,event .getPointerCount()+"" );
                if(event.getPointerCount()>=2 && Y0.size()>1 && Y1.size()>1){

                    Y0.remove(0);
                    Y1.remove(0);


                    for(int i = 0; i< Y0.size(); i++){
                        LogUtil.E(Y0.get(i));
                    }

                    LogUtil.E("-----------------");
                    for(int i = 0; i< Y1.size(); i++){
                        LogUtil.E(Y1.get(i));
                    }

                    LogUtil.E("@@@@"+event.getY(0)+":"+event.getY(1));
                    if(event.getY(0)>event.getY(0)){
                        int x=0;
                        int y=0;
                        for(int i = 0; i< Y0.size(); i++){
                            LogUtil.E("Y0"+Y0.get(i));
                            if(Y0.get(i)>0){
                                return true;
                            }
                            x+= Y0.get(i);
                        }
                        for(int i = 0; i< Y1.size(); i++){
                            LogUtil.E("Y1"+Y1.get(i));
                            if(Y1.get(i)<0){
                                return true;
                            }
                            y+= Y1.get(i);
                        }
                        LogUtil.E(x+"HHH"+y);
                        if(x<-10* Y0.size()&&y>10* Y1.size()){
                            ToastUtil.getInstance().show(getContext(),"keyi");
                        }


                    }

                    if(Y0.get(Y0.size()-1)<Y1.get(Y1.size()-1)){
                        int x=0;
                        int y=0;
                        for(int i = 0; i< Y1.size(); i++){
                            LogUtil.E("Y1"+Y1.get(i));
                            if(Y1.get(i)>0){
                                return true;
                            }
                            x+= Y1.get(i);
                        }
                        for(int i = 0; i< Y0.size(); i++){
                            LogUtil.E("Y0"+Y0.get(i));
                            if(Y0.get(i)<0){
                                return true;
                            }
                            y+= Y0.get(i);
                        }
                        LogUtil.E(x+"HHH"+y);
                        if(x<-10* Y1.size()&&y>10* Y0.size()){
                            ToastUtil.getInstance().show(getContext(),"keyi");
                        }

                    }


                }
                break;
            case MotionEvent. ACTION_MOVE:
                //Log. e("移动" ,event .getPointerCount()+"" );
                if(event.getPointerCount()>=2){
                    Log. e("移动" ,event .getPointerCount()+"" );
                    Y0.add(event.getY(0)-floats[0][0]);
                    Y1.add(event.getY(1)-floats[0][1]);
                    if(floats[0][0]==0){
                        Y0.clear();
                        Y1.clear();
                    }
                    floats[0][0]=event.getY(0);
                    floats[0][1]=event.getY(1);
                }
                break;
            default:
                break;
        }
        return true;
    }
}
