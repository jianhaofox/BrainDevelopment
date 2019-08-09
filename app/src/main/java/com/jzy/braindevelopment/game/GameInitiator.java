package com.jzy.braindevelopment.game;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;

import com.jzy.braindevelopment.game.activity.PokerGameActivity;

//游戏启动器
public class GameInitiator{
    private String gameName;
    private Integer gameGrade;
    private Activity activity;      //来自那个活动
    public static final  String TAG = "Debug";

    public GameInitiator(String gameName, Integer gameGrade, Activity activity) {
        this.gameName = gameName;
        this.gameGrade = gameGrade;
        this.activity = activity;
    }


    //启动游戏Activity
    public void startGame(){
        Log.d(TAG, "startGame: ");
        Log.d(TAG, "gameName:"+this.getGameName());
        Intent intent = new Intent(activity,PokerGameActivity.class);
        activity.startActivity(intent);
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public Integer getGameGrade() {
        return gameGrade;
    }

    public void setGameGrade(Integer gameGrade) {
        this.gameGrade = gameGrade;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }
}
