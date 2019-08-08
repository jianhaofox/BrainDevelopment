package com.jzy.braindevelopment;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.jzy.braindevelopment.comment.InitActivity;
import com.jzy.braindevelopment.main.GlideImageLoader;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InitActivity.initTitle(this,"主页");
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
    }
}
