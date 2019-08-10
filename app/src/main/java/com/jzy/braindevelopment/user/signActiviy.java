package com.jzy.braindevelopment.user;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.jzy.braindevelopment.R;
import com.jzy.braindevelopment.comment.InitActivity;

public class signActiviy extends AppCompatActivity {

    public static final String TAG = "Debug";
    //    信息验证
    boolean Together = true;
    //        验证码
    String Verification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);

        //        改变头部标题名字
        InitActivity.initTitle(this, "用户注册");

//        改变头部图片为注册
        ImageView title_img = (this.findViewById(R.id.head_pic));
        title_img.setBackgroundResource(0);

        //     获得手机按钮ID
        final Button Phone = findViewById(R.id.user_verify);
        //            手机号码格式
        final String num = "[1][345678]\\d{9}";
        //           验证手机号码
        Phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /* 手机号验证*/
                EditText editText1 = findViewById(R.id.phone_verify);
                String phone = String.valueOf(editText1.getText().toString());
                if (phone.length() <= 0) {
                    Together = false;
                    Toast.makeText(signActiviy.this, "手机号码不能为空", Toast.LENGTH_SHORT).show();
                } else if (phone.toString().matches(num) == true) {
                    Together = true;
                    Verification = "8520";
                    Toast.makeText(signActiviy.this, "验证码已发送到" + phone + "请注意查收", Toast.LENGTH_SHORT).show();
                } else {
                    Together = false;
                    Toast.makeText(signActiviy.this, "请输入正确的11位手机账号", Toast.LENGTH_SHORT).show();
                }
            }
        });

        final Button sign = findViewById(R.id.register);
        /*  验证 用户名，密码， ， */
        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText editUser = findViewById(R.id.user_name);
                String user = String.valueOf(editUser.getText().toString().replaceAll(" +", "").trim());
                Log.d(TAG, "onClick: " + user);

                EditText editpwd = findViewById(R.id.user_pwd);
                String pwd = String.valueOf(editpwd.getText().toString());

                EditText editPwds = findViewById(R.id.users_pwd);
                String pwdS = String.valueOf(editPwds.getText().toString());

                EditText editcode = findViewById(R.id.verify_code);
                String  verify = String.valueOf(editcode.getText().toString());
                if (user.length() <= 0)
                {
                    Together = false;
                    Toast.makeText(signActiviy.this, "用户名不能为空" + Together, Toast.LENGTH_SHORT).show();
                } else if (pwd.length() <= 0)
                {
                    Together = false;
                    Toast.makeText(signActiviy.this, "密码不能为空" + Together, Toast.LENGTH_SHORT).show();
                } else if (pwdS.length() <= 0)
                {
                    Together = false;
                    Toast.makeText(signActiviy.this, "请输入确认密码" + Together, Toast.LENGTH_SHORT).show();
                } else if (pwd.length() < 6 || pwdS.length() < 6) {
                    Together = false;
                    Toast.makeText(signActiviy.this, "请输入6位数以上的密码" + Together, Toast.LENGTH_SHORT).show();
                } else if (!pwd.equals(pwdS))
                {
                    Together = false;
                    Toast.makeText(signActiviy.this, "两次密码不一致，请重新输入" + Together, Toast.LENGTH_SHORT).show();
                } else if (Verification.equals(verify))
                {
                    Together = true;
                    Toast.makeText(signActiviy.this, Verification+"验证码通过---" + Together, Toast.LENGTH_SHORT).show();
                } else {
                    Together=false;
                }
                Toast.makeText(signActiviy.this, "TEST---" + Together, Toast.LENGTH_SHORT).show();
//                 判断信息是否全部通过验证
                if (Together) {
                    Toast.makeText(signActiviy.this, "所有信息通过验证" + Together, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
