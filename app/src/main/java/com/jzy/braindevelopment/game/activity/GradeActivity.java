package com.jzy.braindevelopment.game.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.jzy.braindevelopment.R;
import com.jzy.braindevelopment.comment.InitActivity;
import com.jzy.braindevelopment.game.GameInitiator;


//难度选择活动
public class GradeActivity extends AppCompatActivity {
    public static final  String TAG = "Debug";
    //游戏启动器
    private GameInitiator gameInitiator;
    //游戏名字
    private String gameName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grade);
        InitActivity.initTitle(this,"选择级别");
        //获得游戏
        Bundle bundle = getIntent().getExtras();
        gameName = bundle.getString("gameName");
        Log.d(TAG, gameName);

        //绑定游戏难度按钮点击事件
        ViewGroup viewGroup = findViewById(R.id.grade_layout);

        int count = viewGroup.getChildCount();
        View view = null;
        for (int i = 0; i  < count;i++){
            view =viewGroup.getChildAt(i);

            if(view instanceof Button){ //如果是按钮 绑定点击事件
                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int grade = Integer.parseInt(view.getTag().toString());
                        gameInitiator = new GameInitiator(gameName, grade, GradeActivity.this);     //游戏名字 游戏难度 当前活动（难度选择页面）
                        Log.d(TAG, "GradeClicked Game-Grade is " + gameInitiator.getGameGrade());
                        Log.d(TAG, "GradeClicked Game-Name is " + gameInitiator.getGameName());
                        //游戏启动
                        gameInitiator.startGame();
                    }

                });
            }
        }
    }
}
