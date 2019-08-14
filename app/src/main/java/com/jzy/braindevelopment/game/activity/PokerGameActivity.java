package com.jzy.braindevelopment.game.activity;

import android.graphics.Color;
import android.graphics.Point;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import com.jzy.braindevelopment.R;
import com.jzy.braindevelopment.comment.InitActivity;
import com.jzy.braindevelopment.game.PokerGame;

import java.util.ArrayList;
import java.util.List;

public class PokerGameActivity extends AppCompatActivity {
    public static final String TAG = "Debug";
    private ConstraintLayout gameViewLayout;
    private int x = 0;
    private PokerGame pokerGame;
    private Integer phoneType = 1;
    private Integer gameGrade;

    //进入记忆扑克游戏活动
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poker_game);
        InitActivity.initTitle(this, "扑克记忆");

        pokerGame = (PokerGame) getIntent().getSerializableExtra("initData");
        gameGrade = Integer.valueOf(getIntent().getStringExtra("gameGrade"));
        phoneType = Integer.valueOf(getIntent().getStringExtra("phoneType"));

        Log.d(TAG, "pokerGameObject" + pokerGame.getSecond() + "" + pokerGame.getEachShowCardNum());
        Log.d(TAG, "手机类型" + phoneType);


        //创建游戏

        //随机换牌
        final Integer[] pokerGroup = new Integer[]{
                R.drawable.poker3, R.drawable.poker4, R.drawable.poker5, R.drawable.poker6, R.drawable.poker7, R.drawable.poker8, R.drawable.poker9, R.drawable.poker10, R.drawable.poker11,
                R.drawable.poker12, R.drawable.poker13, R.drawable.poker14, R.drawable.poker15, R.drawable.poker16, R.drawable.poker17, R.drawable.poker18, R.drawable.poker19, R.drawable.poker20,
                R.drawable.poker22, R.drawable.poker23, R.drawable.poker24, R.drawable.poker25, R.drawable.poker26, R.drawable.poker27, R.drawable.poker28, R.drawable.poker29, R.drawable.poker30,
                R.drawable.poker31, R.drawable.poker32, R.drawable.poker32, R.drawable.poker33, R.drawable.poker34, R.drawable.poker35, R.drawable.poker36, R.drawable.poker37, R.drawable.poker38,
                R.drawable.poker39, R.drawable.poker40, R.drawable.poker41, R.drawable.poker42, R.drawable.poker43, R.drawable.poker44, R.drawable.poker45, R.drawable.poker46, R.drawable.poker47,
                R.drawable.poker48, R.drawable.poker49, R.drawable.poker50, R.drawable.poker51, R.drawable.poker52, R.drawable.poker53, R.drawable.poker54, R.drawable.poker21
        };
        //测试 每次4个一组显示 动态加载控件
        gameViewLayout = findViewById(R.id.game_view);
        Button switchBackBtn = findViewById(R.id.switch_poker_back_btn);
        Button switchBtn = findViewById(R.id.switch_poker_btn);
        switchBtn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
            @Override
            public void onClick(View view) {
                int random = 0;
                int randomId = 0;
                if (phoneType == 1) {      /*1080*1920类型手机*/
                    x = 75;
                    if (gameGrade == 2) {
                        x -= 30;
                    } else if (gameGrade == 3) {
                        x = 30;
                    } else if (gameGrade == 4) {
                        x = 15;
                    }
                } else if (phoneType == 2) { /*1440*2560*/
                    x = 40;
                    if (gameGrade == 2) {
                        x -= 20;
                    }
                } else if (phoneType == 3) {
                    x = 20;
                    if (gameGrade == 2) {
                        x -= 20;
                    }
                }
                gameViewLayout.removeAllViews();

                ConstraintSet constraintSet = new ConstraintSet();
                List<Integer> idList = new ArrayList<>();
                for (int i = 0; i < pokerGame.getEachShowCardNum(); i++) {
                    random = (int) (Math.random() * (53 - 0)) + 0;//end结束的值，start开始的值
                    randomId = View.generateViewId();
                    if (idList.contains(randomId)) {
                        continue;
                    } else {
                        idList.add(randomId);
                    }


                    ImageView imageView = new ImageView(PokerGameActivity.this);
                    int pokerId = i == 0 ? ConstraintSet.PARENT_ID : idList.get(i - 1);
                    Log.d(TAG, "pokerId positions" + pokerId);
                    imageView.setImageResource(pokerGroup[random]);
                    imageView.setId(randomId);

                    constraintSet.clone(gameViewLayout);
                    //右对右
                    Log.d(TAG, "oldImageId = " + pokerId + "; newImageId = " + imageView.getId());
                    constraintSet.constrainHeight(imageView.getId(), 1600);
                    constraintSet.connect(imageView.getId(), ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, x, getResources().getDisplayMetrics()));
                    constraintSet.connect(imageView.getId(), ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP);
                    constraintSet.connect(imageView.getId(), ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM);

                    gameViewLayout.addView(imageView);
                    constraintSet.applyTo(gameViewLayout);
                    if (gameGrade == 1) {
                        x += 40;
                    } else if (gameGrade == 2) {
                        x += 30;
                    } else if (gameGrade == 3) {
                        x += 28;
                    } else if (gameGrade == 4) {
                        x += 20;
                    }
                }
                for (int i = 0; i < idList.size(); i++) {
                    Log.d(TAG, "[" + i + "]Id:" + idList.get(i));
                }

            }
        });

    }
}
