package com.jzy.braindevelopment.user;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.jzy.braindevelopment.R;
import com.jzy.braindevelopment.comment.InitActivity;

public class CentreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_centre);
        InitActivity.initTitle(this,"个人中心");
        Button btn = (Button)findViewById(R.id.Centre_line);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ent = new Intent(CentreActivity.this,AuthorizationActivity.class);
                startActivity(ent);
            }
        });
    }
}
