package com.jzy.braindevelopment.view.adapter;

import android.content.Context;
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
        Integer image = list.get(position);
        tvCode.setImageResource(image);
        tvCode.setId(image);
        return convertView;
    }
}
