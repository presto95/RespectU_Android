package com.respect.presto.respectu;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by presto on 2017. 11. 19..
 */

public class AchievementFragmentAdapter extends BaseAdapter{
    private Context context;
    private int layoutId;
    private LayoutInflater inflater;
    private List<AchievementInfo> items;

    public AchievementFragmentAdapter(Context context, int layoutId, List<AchievementInfo> items){
        this.context=context;
        this.layoutId=layoutId;
        this.items=items;
        this.inflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return items.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view==null)
            view=inflater.inflate(this.layoutId,null);
        TextView title=(TextView)view.findViewById(R.id.labelAchievementTitle);
        TextView level=(TextView)view.findViewById(R.id.labelAchievementLevel);
        TextView item=(TextView)view.findViewById(R.id.labelAchievementItem);
        TextView type=(TextView)view.findViewById(R.id.labelAchievementType);
        AchievementInfo achievementInfo=this.items.get(i);
        title.setText(achievementInfo.getTitle());
        level.setText(""+achievementInfo.getLevel());
        item.setText(achievementInfo.getItem());
        type.setText(achievementInfo.getType());
        return view;
    }
}
