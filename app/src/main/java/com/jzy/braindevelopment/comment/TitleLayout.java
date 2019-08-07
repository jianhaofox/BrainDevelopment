package com.jzy.braindevelopment.comment;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.jzy.braindevelopment.R;

//自定义标题栏控件
public  class TitleLayout extends LinearLayout {

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }

    public TitleLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        //LayoutInflater可以实现布局动态加载，参数1布局文件ID，参数2可以给加载好的布局添加一个父布局,不需要可以填null
        LayoutInflater.from(context).inflate(R.layout.title_layout,this);
        final ImageButton titleBack = (ImageButton) findViewById(R.id.bar_back);
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
                Log.d("Key", event.getAction()+"");

                if(event.getAction()==KeyEvent.ACTION_DOWN) {
                    Log.d("Key", "ACTION_DOWN: ");
                    titleBack.setBackgroundColor(Color.parseColor("#2480A7"));
                    ((Activity)getContext()).finish();
                }
                if(event.getAction()==KeyEvent.ACTION_UP){
                    Log.d("Key", "ACTION_UP: ");
                    titleBack.setBackgroundColor(Color.parseColor("#4E8CA7"));
                }
                return false;
            }
        });



    }
}
