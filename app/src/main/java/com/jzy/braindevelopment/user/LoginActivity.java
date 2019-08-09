package com.jzy.braindevelopment.user;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


import com.jzy.braindevelopment.R;
import com.jzy.braindevelopment.comment.InitActivity;

public class LoginActivity extends AppCompatActivity {

    public static final String TAG = "Debug";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
//        改变头部标题名字
        InitActivity.initTitle(this, "登录");
//        改变头部图片为注册
        ImageView title_img=(this.findViewById(R.id.head_pic));
        title_img.setBackgroundResource(R.mipmap.sign);

        final Button logo = findViewById(R.id.logoboot);
//        单击按钮
        logo.setOnTouchListener(new TouchAnimation());
        /*     验证登录信息，避免恶意攻击*/
        logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /* 获得用户输入的账号，密码验证防止恶意登录*/
                EditText editText1 = findViewById(R.id.user);
                String user = String.valueOf(editText1.getText().toString());
                EditText editText2 = (EditText) findViewById(R.id.password);
                String Pwd = String.valueOf(editText2.getText().toString());
                if (user.length() <= 0)
                {
                    Log.d(TAG, "!=null" + user);
                    Toast.makeText(LoginActivity.this, "请输入账号", Toast.LENGTH_SHORT).show();
                } else if (user.length()!=11)
                {
                    Toast.makeText(LoginActivity.this, "请输入11位手机账号", Toast.LENGTH_SHORT).show();
                }else if (Pwd.length() <= 0)
                {
                    Toast.makeText(LoginActivity.this, "请输入密码", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

class TouchAnimation implements View.OnTouchListener {

    @Override
    public boolean onTouch(View view, MotionEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            view.setBackgroundResource(R.mipmap.botton_logoer);
        }
        if (event.getAction() == KeyEvent.ACTION_UP) {
            view.setBackgroundResource(R.mipmap.button_logo);
        }
        return false;
    }
}
