package com.jzy.braindevelopment.user;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.jzy.braindevelopment.R;
import com.jzy.braindevelopment.comment.InitActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        InitActivity.initTitle(this, "登录");


//        验证登录信息，避免恶意攻击
        final Button logo = findViewById(R.id.logo_boot);
        logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String User;
                String Pwd;
            }
        });
        logo.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.d("Key", event.getAction() + "父");

                if (event.getAction() == KeyEvent.ACTION_DOWN) {
//                    Drawable  background=botton_logoer;
//                       logo.setBackground();



//                  @mipmap-xhdpi/botton_logoer);

                    if (event.getAction() == KeyEvent.ACTION_UP) {
                        Log.d("Key", "失去123: ");

                    }
                }
                return false;
            }
        });
    }
}

