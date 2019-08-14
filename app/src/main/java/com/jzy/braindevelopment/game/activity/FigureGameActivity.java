package com.jzy.braindevelopment.game.activity;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.jzy.braindevelopment.R;
import com.jzy.braindevelopment.comment.ArrayComment;
import com.jzy.braindevelopment.comment.InitActivity;
import com.jzy.braindevelopment.game.PokerGame;

import java.util.ArrayList;
import java.util.List;

public class FigureGameActivity extends AppCompatActivity {

    public static final String TAG = "Debug";
    private ConstraintLayout gameViewLayout = null;
    private PokerGame pokerGame = null;
    private Integer phoneType = 1;     //手机类型
    private Integer gameGrade = null;  //难度
    String Number = " ";
    /*存放数字数组*/
    Integer[] Figure;
    /*随机数字对象*/
    private ArrayComment arrayComment = new ArrayComment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_figure_game);

        InitActivity.initTitle(this, "数字记忆");

        gameGrade = Integer.valueOf(getIntent().getStringExtra("gameGrade")); //难度
        phoneType = Integer.valueOf(getIntent().getStringExtra("phoneType")); //手机类型

        /*获得显示数字控件*/
        TextView tv = (TextView) findViewById(R.id.wzi_text);


        /* 难度选择*/
        switch (gameGrade) {
            case 1:
                tv.setTextSize(30);
                Number="";
                Number.trim(); //去空格
                Number="\n\n\n\n";
                /*随机数字*/
                Figure = arrayComment.FigureArray(20,99,38);
                for (int i = 0; i < Figure.length; i++) {
                    if (i == 4||i==9||i==14) {
                        Number = Number + "  " + Figure[i] + "\n\n";
                    } else {
                        Number = Number + "  " + Figure[i];
                    }
                }
                tv.setText(Number);
                break;
            case 2:
                tv.setTextSize(30);
                Number="";
                Number.trim(); //去空格
                Number="\n\n\n";
                Figure = arrayComment.FigureArray(25,666,101);
                for (int i = 0; i < Figure.length; i++) {
                    if (i == 4||i==9||i==14||i==19) {
                        Number = Number + "  " + Figure[i] + "\n\n";
                    } else {
                        Number = Number + "  " + Figure[i];
                    }

                }
                tv.setText(Number);
                break;
            case 3:
                tv.setTextSize(30);
                Number="";
                Number.trim(); //去空格
                Number="\n";
                Figure = arrayComment.FigureArray(45,999,380);
                for (int i = 0; i < Figure.length; i++) {
                    if (i == 4||i==9||i==14||i==19||i==24||i==29||i==34||i==39||i==44) {
                        Number = Number + "  " + Figure[i] + "\n\n";
                    } else {
                        Number = Number + "  " + Figure[i];
                    }

                }
                tv.setText(Number);
                break;
            case 4:
                tv.setTextSize(26);
                Number="";
                Number.trim(); //去空格
                Figure = arrayComment.FigureArray(80,9999,1008);
                for (int i = 0; i < Figure.length; i++) {
                    if (i == 4||i==9||i==14||i==19||i==24||i==29||i==34||i==39||i==44||i==49||i==54||i==59||i==64||i==69||i==74||i==79||i==84||i==89) {
                        Number = Number + "  " + Figure[i] + "\n";
                    } else {
                        Number = Number + "  " + Figure[i];
                    }
                }
                tv.setText(Number);
                break;
        }
    }
}