package com.jzy.braindevelopment;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.jzy.braindevelopment.comment.InitActivity;
import com.jzy.braindevelopment.main.GlideImageLoader;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static java.security.AccessController.getContext;

public class MainActivity extends AppCompatActivity {

    public static final  String TAG = "Debug";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InitActivity.initTitle(this,"主页");
        //======= 轮播配置 =========
        Banner banner = (Banner)findViewById(R.id.main_banner);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        List <Integer> imageUrls = new ArrayList<>();
        //加入图片资源
        imageUrls.add(R.drawable.img1);
        imageUrls.add(R.drawable.img3);
        //设置图片集合
        banner.setImages(imageUrls);
        banner.start();
        //====== 触摸动画和事件 =======
        ConstraintLayout constraintLayout = (ConstraintLayout)findViewById(R.id.poker_layout);
        constraintLayout.setClickable(true);
        constraintLayout.setOnTouchListener(new TouchAnimation());
    }
    /*==== 单击动画 ====*/
    class TouchAnimation implements View.OnTouchListener{
        /*@Override
        public void onClick(View view) {*//*
            Log.d(TAG, "onClick: is OK");
            if(view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                LinkedList<ViewGroup> linkedList = new LinkedList<>();
                linkedList.add(viewGroup);

                while(!linkedList.isEmpty()) {      //列表移除第一个并返回这个元素
                    ViewGroup current = linkedList.removeFirst();

                    for(int i = 0; i < current.getChildCount(); i ++) {     //判断是否还有子控件
                        if(current.getChildAt(i) instanceof ViewGroup) {
                            linkedList.addLast((ViewGroup) current.getChildAt(i));  //子控件里若还有子控件则将其加入链表
                        }else {

                        }
                    }
                }
            }
        *//*
           view.setBackgroundColor(Color.parseColor("#4399FE"));
        }*/

        @Override
        public boolean onTouch(View view, MotionEvent event) {
            Log.d(TAG, event.getAction()+"");
            if(event.getAction()== KeyEvent.ACTION_DOWN) {
                Log.d(TAG, "ACTION_DOWN: ");
                view.setBackgroundColor(Color.parseColor("#A69AA0"));
                String activityName = view.getContext().toString();
                /*((Activity)view.getContext()).finish();*/
                Log.d(TAG, activityName);
            }
            if(event.getAction()==KeyEvent.ACTION_UP){
                Log.d(TAG, "ACTION_UP: ");
                view.setBackgroundColor(Color.parseColor("#FFFFFF"));
            }
            return false;
        }
        }
    }
