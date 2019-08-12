package com.jzy.braindevelopment.user;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.jzy.braindevelopment.R;
import com.jzy.braindevelopment.comment.InitActivity;

public class SignActivity extends AppCompatActivity {

    public static final String TAG = "Debug";

    //        验证码
    String Security = " ";
    //            手机号码格式
    final String num = "[1][345678]\\d{9}";

    boolean  Phoneboole=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);

        //        改变头部标题名字
        InitActivity.initTitle(this, "用户注册");

        //     改变头部图片为注册
        ImageView title_img = (this.findViewById(R.id.head_pic));

        //     清除标题栏图片
        title_img.setBackgroundResource(0);

        //     获得手机按钮ID
        final Button Phone = findViewById(R.id.user_verify);

        //           验证手机号码
        Phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /* 获得手机号验证*/
                EditText editText1 = findViewById(R.id.phone_verify);
                Phoneboole= PhoneExamine(editText1);
            }
        });

        /*注册按钮*/
        final Button sign = findViewById(R.id.register);
        sign.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
//                用户名验证
                if (NameVerifier())
                {
                  if ( cipherVerifier() )
                  {
                      if (Phoneboole){
                          if ( Verification() )
                          {
                              Toast.makeText(SignActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                          }
                      }else{
                          Toast.makeText(SignActivity.this, "请输入手机号", Toast.LENGTH_SHORT).show();
                      }
                  }
                }
            }
        });
    }

    /* 手机验证 */
    public boolean PhoneExamine(EditText editText) {

        boolean result = false;

        String phone = String.valueOf(editText.getText().toString());

        if (phone.length() <= 0) {
            result = false;
            Toast.makeText(SignActivity.this, "手机号码不能为空", Toast.LENGTH_SHORT).show();
        } else if (phone.matches(num) != true) {
            result = false;
            Toast.makeText(SignActivity.this, "请输入正确的11位手机账号", Toast.LENGTH_SHORT).show();
        } else {
            Security = "8520";
            result=true;
            Toast.makeText(SignActivity.this, "验证码已发送到" + phone + "注意查收", Toast.LENGTH_SHORT).show();
        }
        return result;
    }

    /* 验证码 */
    private boolean Verification() {
        boolean VerificationResult = true;
        String verify = " ";

        EditText editcode = findViewById(R.id.verify_code);
        verify = String.valueOf(editcode.getText().toString());

        if (!Security.equals(verify)) {
            VerificationResult = false;
            Toast.makeText(SignActivity.this, "请输入正确的验证码", Toast.LENGTH_SHORT).show();
        }
        return VerificationResult;
    }

    /*  用户名验证*/
    private boolean NameVerifier() {
        boolean NameResult = false;
        EditText editUser = findViewById(R.id.user_name);
        //过滤用户名空格
        String user = String.valueOf(editUser.getText().toString().replaceAll(" +", "").trim());
        if (user.length() > 0) {
            NameResult = true;
        } else {
            NameResult = false;
            Toast.makeText(SignActivity.this, "用户名不能为空", Toast.LENGTH_SHORT).show();
        }
        return NameResult;
    }

    /*密码验证*/
    private boolean cipherVerifier() {

        boolean PwdResult = true;
        EditText editpwd = findViewById(R.id.user_pwd);
        String pwd = String.valueOf(editpwd.getText().toString());

        EditText editPwds = findViewById(R.id.users_pwd);
        String pwdS = String.valueOf(editPwds.getText().toString());

        if (pwd.length() <= 0 || pwdS.length() <= 0) {
            PwdResult = false;
            Toast.makeText(SignActivity.this, "密码不能为空" , Toast.LENGTH_SHORT).show();
        } else if (pwd.length() < 6 || pwdS.length() < 6) {
            PwdResult = false;
            Toast.makeText(SignActivity.this, "请输入6位数以上的密码" , Toast.LENGTH_SHORT).show();
        } else if (!pwd.equals(pwdS)) {
            PwdResult = false;
            Toast.makeText(SignActivity.this, "两次密码不一致，请重新输入" , Toast.LENGTH_SHORT).show();
        }
        return PwdResult;
    }

}
