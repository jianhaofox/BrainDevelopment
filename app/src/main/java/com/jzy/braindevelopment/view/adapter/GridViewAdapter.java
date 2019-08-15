package com.jzy.braindevelopment.view.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Toast;

import com.jzy.braindevelopment.R;
import com.jzy.braindevelopment.game.activity.PokerGameActivity;

import java.util.List;

/*GridView数据适配器*/
public class GridViewAdapter extends BaseAdapter {
    Context context;
    List<Integer> list;

    public GridViewAdapter(Context _context, List<Integer> _list) {
        this.list = _list;
        this.context = _context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        convertView = layoutInflater.inflate(R.layout.list_item, null);
        ImageView tvCode = (ImageView) convertView.findViewById(R.id.list_diary);
        ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams)tvCode.getLayoutParams();
        params.height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 120, parent.getResources().getDisplayMetrics());
        params.width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 80, parent.getResources().getDisplayMetrics());
        Integer image = list.get(position);
        tvCode.setImageResource(image);
        tvCode.setId(image);
        tvCode.setLayoutParams(params);
        return convertView;
    }
}
