package com.jzy.braindevelopment.user;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jzy.braindevelopment.R;
import com.jzy.braindevelopment.comment.InitActivity;

public class signActiviy extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);
        //        改变头部标题名字
        InitActivity.initTitle(this, "用户注册");
    }
}
