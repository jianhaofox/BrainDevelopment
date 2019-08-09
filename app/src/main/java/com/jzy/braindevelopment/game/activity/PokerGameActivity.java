package com.jzy.braindevelopment.game.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jzy.braindevelopment.R;

public class PokerGameActivity extends AppCompatActivity {
    //进入记忆扑克游戏活动
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poker_game);
        //得到游戏难度 - 设置要记的总副数 - 设置每次记忆的牌数 一副牌52张(去掉大小王)


    }
}
