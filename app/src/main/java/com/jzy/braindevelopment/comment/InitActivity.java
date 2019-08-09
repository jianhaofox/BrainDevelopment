package com.jzy.braindevelopment.comment;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.support.v4.content.res.ResourcesCompat;
import android.widget.ImageView;
import android.widget.TextView;

import com.jzy.braindevelopment.R;
//活动初始化类 省去隐藏标题栏和实现动态标题
public class InitActivity {

    public static void initTitle(Activity activity, String title) {
        ((TextView) (activity.findViewById(R.id.bar_title))).setText(title);
    }
}