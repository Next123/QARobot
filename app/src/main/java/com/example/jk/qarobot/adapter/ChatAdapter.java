package com.example.jk.qarobot.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.jk.qarobot.R;
import com.example.jk.qarobot.bean.ChatBean;
import com.example.jk.qarobot.tools.Constant;

import java.util.List;

/**
 * Created by JK on 2017/5/3.
 * 聊天列表 适配器
 */

public class ChatAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater inflater;
    private List<ChatBean> list;

    public ChatAdapter(Context context, List<ChatBean> list) {
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
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
        LeftHolder leftHolder = null;
        RightHolder rightHolder = null;
        int type = getItemViewType(position);
        if (convertView == null) {
            switch (type) {
                case Constant.VALUE_LEFT_TEXT:
                    convertView = inflater.inflate(R.layout.left_item, null);
                    leftHolder = new LeftHolder();
                    leftHolder.tv_left_text = (TextView) convertView.findViewById(R.id.tv_left_text);
                    convertView.setTag(leftHolder);
                    break;
                case Constant.VALUE_RIGHT_TEXT:
                    convertView = inflater.inflate(R.layout.right_item, null);
                    rightHolder = new RightHolder();
                    rightHolder.tv_right_text = (TextView) convertView.findViewById(R.id.tv_right_text);
                    convertView.setTag(rightHolder);
                    break;
            }
        } else {
            switch (type) {
                case Constant.VALUE_LEFT_TEXT:
                    leftHolder = (LeftHolder) convertView.getTag();
                    break;
                case Constant.VALUE_RIGHT_TEXT:
                    rightHolder = (RightHolder) convertView.getTag();
                    break;
            }
        }
        //赋值
        ChatBean data = list.get(position);
        switch (type) {
            case Constant.VALUE_LEFT_TEXT:
                leftHolder.tv_left_text.setText(data.getText());
                break;
            case Constant.VALUE_RIGHT_TEXT:
                rightHolder.tv_right_text.setText(data.getText());
                break;
        }
        return convertView;
    }

    //根据数据源的positiion来返回要显示的item
    @Override
    public int getItemViewType(int position) {
        return list.get(position).getType();
    }

    //返回所有layout的数量
    @Override
    public int getViewTypeCount() {
        return 3;
    }

    private class LeftHolder {
        private TextView tv_left_text;
    }

    private class RightHolder {
        private TextView tv_right_text;
    }
}
