package com.jzy.braindevelopment.game.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.jzy.braindevelopment.R;
import com.jzy.braindevelopment.comment.InitActivity;


public class ExamActivity extends AppCompatActivity {
    public static final String TAG = "Debug";
    String ExemResult; //结果集
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam);
        InitActivity.initTitle(this, "数字记忆");

            /*获取数据记忆的值*/
        Bundle bundle = getIntent().getExtras();
         ExemResult = bundle.getString("numbers");
        ExemResult = ExemResult.replaceAll("\r|\n", "").replaceAll(" +", "").trim();  //删除换行，空格
        Log.d(TAG, "数字记忆答案: "+ExemResult);


        /*记完了*/
        Button Tji = findViewById(R.id.exam_OK);

        /* 提交答案处理*/
        Tji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editText1 = findViewById(R.id.exame_txt);
                String user = String.valueOf(editText1.getText().toString());
                Log.d(TAG, "数字记忆结果: "+user);

                if (user.equals(ExemResult))
                {
                    Log.d(TAG, "成功");
                    Toast.makeText(ExamActivity.this, "恭喜你闯攻成功，再接再厉", Toast.LENGTH_SHORT).show();
                }else {
                    Log.d(TAG, "失败");
                    Toast.makeText(ExamActivity.this, "对不起闯攻失败，下次加油，", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
