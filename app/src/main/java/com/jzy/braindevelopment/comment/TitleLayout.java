package com.jzy.braindevelopment.comment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.nfc.Tag;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.jzy.braindevelopment.R;
import com.jzy.braindevelopment.Test;

//自定义标题栏控件
public  class TitleLayout extends ConstraintLayout {
    public static final  String TAG = "Debug";
    public TitleLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
  //LayoutInflater可以实现布局动态加载，参数1布局文件ID，参数2可以给加载好的布局添加一个父布局,不需要可以填null
        LayoutInflater.from(context).inflate(R.layout.title_layout,this);
        final ImageButton titleBack = (ImageButton) findViewById(R.id.bar_back);
        ImageView headPic = (ImageView) findViewById((R.id.head_pic));
        headPic.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), Test.class);
                getContext().startActivity(intent);
            }
        });
       /* titleBack.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                *//*((Activity)getContext()).finish();*//*
                Log.d("Key","点击返回按钮");
            }
        });*/

        titleBack.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.d(TAG, event.getAction()+"");

                if(event.getAction()==KeyEvent.ACTION_DOWN) {
                    Log.d(TAG, "ACTION_DOWN: ");
                    v.setBackgroundColor(Color.parseColor("#4A8DFE"));
                    String activityName = getContext().toString();
                    ((Activity)getContext()).finish();
                    Log.d(TAG, activityName);
                }
                if(event.getAction()==KeyEvent.ACTION_UP){
                    Log.d(TAG, "ACTION_UP: ");
                    v.setBackgroundColor(Color.parseColor("#4399FE"));
                }
                return false;
            }
        });

    }
    //将活动显示在标题上
    public void updateTitle(String title){
        ((TextView)findViewById(R.id.bar_title)).setText(title);
    }
}
