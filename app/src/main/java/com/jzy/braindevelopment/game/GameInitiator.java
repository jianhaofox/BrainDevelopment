package com.jzy.braindevelopment.game;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Point;
import android.util.Log;
import android.view.WindowManager;

import com.jzy.braindevelopment.game.activity.FigureGameActivity;
import com.jzy.braindevelopment.game.activity.PokerGameActivity;

//游戏启动器
public class GameInitiator {

  /*  private Integer gameGrade;  //1 2 3 4*/

    private Integer gameGrade;  //1 2 3 4
    private String gameName;
    private Integer phoneType;
    private Activity activity;      //来自那个活动
    public static int isOver=1;     //游戏是否结束 0 技术 1 未结束
    public static final String TAG = "Debug";


    public GameInitiator(String gameName, Integer gameGrade, Activity activity) {
        this.gameGrade=gameGrade;
        this.gameName=gameName;
        this.activity = activity;
        //得到手机分辨率
        WindowManager wm = (WindowManager) activity.getSystemService(activity.WINDOW_SERVICE);
        Point point = new Point();
        wm.getDefaultDisplay().getSize(point);
        int width = point.x;
        int height = point.y;

        if (width == 1080 && height > 1620 && height < 2220) {      /*1080*1920类型手机*/
            setPhoneType(1);
        } else if (width == 1440 && height > 2260 && height < 2860) { /*1440*2560*/
            setPhoneType(2);
        } else if (width == 720 && height > 980 && height < 1580) {
            setPhoneType(3);
        }
        Log.d(TAG, "屏幕宽度*高度:" + width + "*" + height + "手机类型：" + this.phoneType);
    }


    //启动游戏Activity
    public void startGame() {
        Log.d(TAG, "startGame: ");
        Log.d(TAG, "gameName:" + this.getGameName());
        if (this.gameName.equals("poker")) {
            Intent intent = new Intent(activity, PokerGameActivity.class);
            intent.putExtra("phoneType", this.phoneType);

            PokerGame pokerGame = new PokerGame();
            switch (gameGrade) {     //难度：几秒记住几张
                case 1:
                    pokerGame.setSecond(3);
                    pokerGame.setEachShowCardNum(4);
                    break;
                case 2:
                    pokerGame.setSecond(5);
                    pokerGame.setEachShowCardNum(8);
                    break;
                case 3:
                    pokerGame.setSecond(7);
                    pokerGame.setEachShowCardNum(10);
                    break;
                case 4:
                    pokerGame.setSecond(8);
                    pokerGame.setEachShowCardNum(15);
                    break;
            }
            intent.putExtra("initData", pokerGame);
            intent.putExtra("phoneType", getPhoneType().toString());
            intent.putExtra("gameGrade", getGameGrade().toString());
            activity.startActivity(intent);
        }else if (this.gameName.equals("figure")) {
            Intent intent = new Intent(activity, FigureGameActivity.class);
            intent.putExtra("phoneType", this.phoneType);

            PokerGame pokerGame = new PokerGame();
            switch (gameGrade) {     //难度：几秒记住几张
                case 1:
                    pokerGame.setSecond(2);
                    pokerGame.setEachShowCardNum(5);
                    break;
                case 2:
                    pokerGame.setSecond(2);
                    pokerGame.setEachShowCardNum(8);
                    break;
                case 3:
                    pokerGame.setSecond(3);
                    pokerGame.setEachShowCardNum(10);
                    break;
                case 4:
                    pokerGame.setSecond(5);
                    pokerGame.setEachShowCardNum(15);
                    break;
            }
            intent.putExtra("initData", pokerGame);
            intent.putExtra("phoneType", getPhoneType().toString());
            intent.putExtra("gameGrade", getGameGrade().toString());
            activity.startActivity(intent);
        }

    }
    //获得游戏规则介绍
    public static String getGameRule(String gameName){
        if (gameName.equals("poker")) {
            return new PokerGame().getGameRule();
        }else if (gameName.equals("figure")){

        }
        return null;

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

    public Integer getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(Integer phoneType) {
        this.phoneType = phoneType;
    }

}
