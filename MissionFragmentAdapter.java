package com.respect.presto.respectu;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.respect.presto.respectu.R;

import java.util.List;

/**
 * Created by presto on 2017. 10. 13..
 */

public class MissionFragmentAdapter extends BaseAdapter {
    private Context context;
    private int layoutId;
    private LayoutInflater inflater;
    private List<MissionInfo> items;

    public MissionFragmentAdapter(Context context, int layoutId, List<MissionInfo> items){
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
        TextView color=(TextView)view.findViewById(R.id.labelColor);
        TextView title=(TextView)view.findViewById(R.id.labelTitle);
        TextView section=(TextView)view.findViewById(R.id.labelSection);
        MissionInfo missionInfo=this.items.get(i);
        switch(missionInfo.getSection()){
            case "Departure":
                color.setBackgroundColor(Color.rgb(78,231,190));
                break;
            case "CLUB Road645":
                color.setBackgroundColor(Color.rgb(86,216,244));
                break;
            case "MAX Theater":
                color.setBackgroundColor(Color.rgb(79,178,232));
                break;
            case "Another WORLD":
                color.setBackgroundColor(Color.rgb(113,150,222));
                break;
            case "Back STAGE":
                color.setBackgroundColor(Color.rgb(180,160,235));
                break;
            case "Chaos Theory":
                color.setBackgroundColor(Color.rgb(179,140,229));
                break;
            case "Sound Lab":
                color.setBackgroundColor(Color.rgb(212,120,239));
                break;
            case "Visualizer":
                color.setBackgroundColor(Color.rgb(228,121,230));
                break;
            case "D-VELOPERS":
                color.setBackgroundColor(Color.rgb(245,85,167));
                break;
            case "Destination":
                color.setBackgroundColor(Color.rgb(203,73,99));
                break;
            case "T-SIDE":
                color.setBackgroundColor(Color.rgb(143,173,212));
                break;
            case "R-SIDE":
                color.setBackgroundColor(Color.rgb(169,148,222));
                break;
            case "Electronic City":
                color.setBackgroundColor(Color.rgb(226,223,113));
                break;
            case "Metropolis":
                color.setBackgroundColor(Color.rgb(182,161,205));
                break;
            case "Platinum Mixing":
                color.setBackgroundColor(Color.rgb(182,209,229));
                break;
            case "Technical Mixing":
                color.setBackgroundColor(Color.rgb(227,153,199));
                break;
        }
        title.setText("   "+missionInfo.getTitle());
        section.setText(missionInfo.getSection());
        return view;
    }
}