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
        final Button logo = findViewById(R.id.logoboot);
        logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String User;
                String Pwd;
            }
        });
        logo.setClickable(true);
        logo.setOnTouchListener(new TouchAnimation());
    }
}
class TouchAnimation implements View.OnTouchListener{
    public static final  String TAG = "Debug";
    @Override
    public boolean onTouch(View view, MotionEvent event) {
        Log.d(TAG, event.getAction()+"");
        if(event.getAction()== KeyEvent.ACTION_DOWN) {
            Log.d(TAG, "ACTION_DOWN: ");
            view.setBackgroundResource(R.mipmap.botton_logoer);

        }
        if(event.getAction()==KeyEvent.ACTION_UP){
            Log.d(TAG, "ACTION_UP: ");
            view.setBackgroundResource(R.mipmap.button_logo);
        }
        return false;
    }
}

