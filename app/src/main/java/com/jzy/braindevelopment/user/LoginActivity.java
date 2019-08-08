package com.jzy.braindevelopment.user;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jzy.braindevelopment.R;
import com.jzy.braindevelopment.comment.InitActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        InitActivity.initTitle(this,"登录");

    }
}
