package com.jzy.braindevelopment.user;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.jzy.braindevelopment.R;
import com.jzy.braindevelopment.comment.InitActivity;

public class AuthorizationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authorization);
        //改变头部标题
        InitActivity.initTitle(this,"授权管理");
        final Button button1=findViewById(R.id.userzc);
        //单击按钮
        button1.setOnTouchListener(new TouchAnimation());

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //获取用户卡号，密码信息，验证信息
                EditText editText1 = findViewById(R.id.user_edtx);
                String user_edtx = String.valueOf(editText1.getText().toString());

                EditText editText2 = (EditText) findViewById(R.id.passwords);
                String passwords = String.valueOf(editText2.getText().toString());
//                授权信息验证
                if (Validation(user_edtx, passwords)) {
                    Toast.makeText(AuthorizationActivity.this, "登陆成功", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    //            卡号，密码验证
    private boolean Validation(String user_edtx, String passwords) {

        boolean validation = true;

        if (user_edtx.length() <= 0 || user_edtx.length()<12) {
            Toast.makeText(AuthorizationActivity.this, "请输入正确的12位卡号", Toast.LENGTH_SHORT).show();
            validation = false;
        } else if (passwords.length() <= 0 || passwords.length() <8) {
            Toast.makeText(AuthorizationActivity.this, "请输入正确的密码", Toast.LENGTH_SHORT).show();
            validation = false;
        }
        return validation;
    }
}
