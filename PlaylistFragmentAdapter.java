package com.respect.presto.respectu;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by presto on 2017. 10. 16..
 */

public class PlaylistFragmentAdapter extends BaseAdapter{
    private Context context;
    private int layoutId;
    private LayoutInflater inflater;
    private List<PlaylistInfo> items;

    public PlaylistFragmentAdapter(Context context, int layoutId, List<PlaylistInfo> items){
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
        TextView composer=(TextView)view.findViewById(R.id.labelComposer);
        TextView bpm=(TextView)view.findViewById(R.id.labelBpm);
        PlaylistInfo playlistInfo=this.items.get(i);
        switch(playlistInfo.getSeries()){
            case "Portable1":
                color.setBackgroundColor(Color.rgb(29,180,210));
                break;
            case "Portable2":
                color.setBackgroundColor(Color.rgb(252,34,43));
                break;
            case "Respect":
                color.setBackgroundColor(Color.rgb(240,179,44));
                break;
            case "Trilogy":
                color.setBackgroundColor(Color.rgb(115,139,252));
                break;
            case "CE":
                color.setBackgroundColor(Color.rgb(255,248,221));
                break;
            case "Technika1":
                color.setBackgroundColor(Color.rgb(238,44,189));
                break;
        }
        title.setText(playlistInfo.getTitle());
        composer.setText(playlistInfo.getComposer());
        bpm.setText("BPM "+playlistInfo.getBpm());
        return view;
    }
}
