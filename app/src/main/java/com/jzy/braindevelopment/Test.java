package com.jzy.braindevelopment;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.jzy.braindevelopment.comment.InitActivity;
import com.jzy.braindevelopment.user.CentreActivity;
import com.jzy.braindevelopment.user.LoginActivity;
import com.jzy.braindevelopment.user.SignActivity;

public class Test extends AppCompatActivity {

    public static final String TAG = "Debug";

    TextView tvShow;
    private int i = 0;
    private int TIME = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        Button button = (Button)findViewById(R.id.btn_login);
        button.setOnClickListener(new View.OnClickListener() {
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
                Intent intent = new Intent(Test.this, SignActivity.class);
                startActivity(intent);
            }
        });
        /*tvShow = (TextView) findViewById(R.id.textView);
        handler.postDelayed(runnable, TIME); //每隔1s执行*/


        //        个人中心
        Button Ge = (Button)findViewById(R.id.ger_but);
        Ge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Test.this, CentreActivity.class);
                startActivity(intent);
            }
        });



    }
    //计时器
    Handler handler = new Handler();
    Runnable runnable = new Runnable() {

        @Override
        public void run() {
            // handler自带方法实现定时器
            try {
                handler.postDelayed(this, TIME);
                tvShow.setText(Integer.toString(i++));
                System.out.println("do...");
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                System.out.println("exception...");
            }
        }
    };
}
