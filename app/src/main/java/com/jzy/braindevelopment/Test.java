package com.jzy.braindevelopment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.jzy.braindevelopment.comment.InitActivity;
import com.jzy.braindevelopment.user.LoginActivity;
import com.jzy.braindevelopment.user.signActiviy;

public class Test extends AppCompatActivity {

    public static final String TAG = "Debug";
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
//        引用头部标题
        setContentView(R.layout.activity_test);
        InitActivity.initTitle(Test.this,"测试");
//        登录
        Button btn_logi = (Button)findViewById(R.id.btn_login);
        btn_logi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Test.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        //        注册
        Button btn_sign = (Button)findViewById(R.id.sign_user);
        btn_sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Test.this, signActiviy.class);
                startActivity(intent);
            }
        });
    }
}

