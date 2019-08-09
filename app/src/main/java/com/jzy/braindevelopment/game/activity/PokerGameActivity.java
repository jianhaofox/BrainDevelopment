package com.jzy.braindevelopment.game.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jzy.braindevelopment.R;
import com.jzy.braindevelopment.comment.InitActivity;
import com.jzy.braindevelopment.game.PokerGame;

public class PokerGameActivity extends AppCompatActivity {
    //进入记忆扑克游戏活动
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poker_game);
        InitActivity.initTitle(this,"扑克记忆");
        //创建游戏
        PokerGame pokerGame = new PokerGame();

        //随机

    }
}
