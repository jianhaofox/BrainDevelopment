package com.jzy.braindevelopment.game;

import android.app.Activity;
import android.util.Log;

//游戏启动器
public class GameInitiator {
    private String gameName;
    private Integer gameGrade;
    private Activity activity;
    public static final  String TAG = "Debug";
    //启动游戏Activity
    public void startGame(){
        Log.d(TAG, "startGame: ");
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
