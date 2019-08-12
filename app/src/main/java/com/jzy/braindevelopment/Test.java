package com.jzy.braindevelopment;

import android.content.Intent;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.jzy.braindevelopment.comment.InitActivity;
import com.jzy.braindevelopment.user.LoginActivity;

public class Test extends AppCompatActivity {
    private Button add;
    private ConstraintLayout constraintLayout;
    private int num;
    @android.support.annotation.IdRes
    int TAG1403 = 1002;
    int TAG1404 = 1003;
    int TAG1405 = 1004;
    int TAG1406 = 1005;
    int TAG1407 = 1006;


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

        add=findViewById(R.id.test_btn);
        constraintLayout=findViewById(R.id.content);
        num=0;//代表按钮点击的次数
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {//点击事件
                if(num==0){
                    ConstraintSet constraintSet=new ConstraintSet();//新建一个ConstraintSet
                    num++;




                   /* constraintSet.connect(new1.getId(),ConstraintSet.START, ConstraintSet.PARENT_ID,ConstraintSet.START);
                    //这个按钮距离顶部的margin值为1000
                    constraintSet.connect(new1.getId(),ConstraintSet.TOP, ConstraintSet.PARENT_ID,ConstraintSet.TOP,0);
                    constraintSet.connect(new1.getId(),ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID,ConstraintSet.BOTTOM);*/
                    constraintLayout.setBackgroundColor(Color.parseColor("#A63618"));
                    Button new1=new Button(Test.this);
                    //在其中添加第一个Button
                    new1.setText("第一个BUTTON");
                    new1.setId(TAG1403);
                    constraintLayout.addView(new1);
                    constraintSet.clone(constraintLayout);
                    constraintSet.connect(new1.getId(),ConstraintSet.LEFT, ConstraintSet.PARENT_ID,ConstraintSet.LEFT);
                    constraintSet.connect(new1.getId(),ConstraintSet.RIGHT, ConstraintSet.PARENT_ID,ConstraintSet.RIGHT);
                    constraintSet.connect(new1.getId(),ConstraintSet.TOP,ConstraintSet.PARENT_ID,ConstraintSet.TOP);
                    constraintSet.connect(new1.getId(),ConstraintSet.BOTTOM,ConstraintSet.PARENT_ID,ConstraintSet.BOTTOM);
                    constraintSet.applyTo(constraintLayout);
                    Button new2=new Button(Test.this);
                    //在其中添加第一个Button
                    new2.setText("第二个BUTTON");
                    new2.setId(TAG1404);
                    constraintLayout.addView(new2);
                    constraintSet.clone(constraintLayout);
                    constraintSet.connect(new2.getId(),ConstraintSet.START, TAG1403,ConstraintSet.END);
                    constraintSet.connect(new2.getId(),ConstraintSet.TOP,ConstraintSet.PARENT_ID,ConstraintSet.TOP);
                    constraintSet.connect(new2.getId(),ConstraintSet.BOTTOM,ConstraintSet.PARENT_ID,ConstraintSet.BOTTOM);

                    constraintSet.applyTo(constraintLayout);

                    Button new3=new Button(Test.this);
                    //在其中添加第一个Button
                    new3.setText("第三个BUTTON");
                    new3.setId(TAG1405);
                    constraintLayout.addView(new3);
                    constraintSet.clone(constraintLayout);
                    constraintSet.constrainWidth(new3.getId(), ConstraintLayout.LayoutParams.WRAP_CONTENT);
                    constraintSet.constrainHeight(new3.getId(),ConstraintLayout.LayoutParams.WRAP_CONTENT);
                    constraintSet.connect(new3.getId(),ConstraintSet.START, TAG1404,ConstraintSet.END);
                    constraintSet.connect(new3.getId(),ConstraintSet.TOP,ConstraintSet.PARENT_ID,ConstraintSet.TOP);
                    constraintSet.connect(new3.getId(),ConstraintSet.BOTTOM,ConstraintSet.PARENT_ID,ConstraintSet.BOTTOM);


                    constraintSet.applyTo(constraintLayout);
                }
            }
        });

    }
}
