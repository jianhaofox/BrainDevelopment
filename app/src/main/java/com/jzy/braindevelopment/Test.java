package com.jzy.braindevelopment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jzy.braindevelopment.comment.InitActivity;

public class Test extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        InitActivity.initTitle(Test.this,"测试");
    }
}
