package com.respect.presto.respectu;

import android.content.Context;
import android.content.SharedPreferences;
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

public class SongFragmentAdapter extends BaseAdapter{
    private Context context;
    private int layoutId;
    private LayoutInflater inflater;
    private List<SongInfo> items;
    private String key;

    public SongFragmentAdapter(Context context, int layoutId, List<SongInfo> items){
        this.context=context;
        this.layoutId=layoutId;
        this.items=items;
        this.inflater=LayoutInflater.from(context);
    }
    public SongFragmentAdapter(Context context, int layoutId, List<SongInfo> items, String key){
        this.context=context;
        this.layoutId=layoutId;
        this.items=items;
        this.key=key;
        this.inflater= LayoutInflater.from(context);
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
        final TextView title=(TextView)view.findViewById(R.id.labelTitle);
        TextView composer=(TextView)view.findViewById(R.id.labelComposer);
        TextView bpm=(TextView)view.findViewById(R.id.labelBpm);
        TextView nm=(TextView)view.findViewById(R.id.labelNormal);
        TextView hd=(TextView)view.findViewById(R.id.labelHard);
        TextView mx=(TextView)view.findViewById(R.id.labelMaximum);
        TextView nmRecord = view.findViewById(R.id.labelNormalRecord);
        TextView hdRecord = view.findViewById(R.id.labelHardRecord);
        TextView mxRecord = view.findViewById(R.id.labelMaximumRecord);
        SharedPreferences sp = context.getSharedPreferences("Record", Context.MODE_PRIVATE);

        title.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
            @Override
            public void onLayoutChange(View view, int i, int i1, int i2, int i3, int i4, int i5, int i6, int i7) {
                title.setSelected(true);
            }
        });

        SongInfo songInfo=this.items.get(i);
        switch(songInfo.getSeries()){
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
        }
        String titleString = songInfo.getTitle();
        title.setText(titleString);
        composer.setText(songInfo.getComposer());
        bpm.setText("BPM " + songInfo.getBpm());
        if(key.equals("4B")){
            nm.setText(songInfo.getNm4()==0 ? "-" : String.valueOf(songInfo.getNm4()));
            hd.setText(songInfo.getHd4()==0 ? "-" : String.valueOf(songInfo.getHd4()));
            mx.setText(songInfo.getMx4()==0 ? "-" : String.valueOf(songInfo.getMx4()));
            if(songInfo.getNm4() == 0)
                nmRecord.setText("");
            else{
                if(sp.getString(titleString+"4BNormalNote","").equals("PERFECT PLAY"))
                    nmRecord.setText("PP");
                else if(sp.getString(titleString+"4BNormalNote","").equals("MAX COMBO"))
                    nmRecord.setText("MC");
                else
                    nmRecord.setText(sp.getString(titleString+"4BNormalRank","-"));
            }
            if(songInfo.getHd4() == 0)
                hdRecord.setText("");
            else{
                if(sp.getString(titleString+"4BHardNote","").equals("PERFECT PLAY"))
                    hdRecord.setText("PP");
                else if(sp.getString(titleString+"4BHardNote","").equals("MAX COMBO"))
                    hdRecord.setText("MC");
                else
                    hdRecord.setText(sp.getString(titleString+"4BHardRank","-"));
            }
            if(songInfo.getMx4() == 0)
                mxRecord.setText("");
            else{
                if(sp.getString(titleString+"4BMaximumNote","").equals("PERFECT PLAY"))
                    mxRecord.setText("PP");
                else if(sp.getString(titleString+"4BMaximumNote","").equals("MAX COMBO"))
                    mxRecord.setText("MC");
                else
                    mxRecord.setText(sp.getString(titleString+"4BMaximumRank","-"));
            }

        }
        else if(key.equals("5B")){
            nm.setText(songInfo.getNm5()==0 ? "-" : String.valueOf(songInfo.getNm5()));
            hd.setText(songInfo.getHd5()==0 ? "-" : String.valueOf(songInfo.getHd5()));
            mx.setText(songInfo.getMx5()==0 ? "-" : String.valueOf(songInfo.getMx5()));
            if(songInfo.getNm5() == 0)
                nmRecord.setText("");
            else{
                if(sp.getString(titleString+"5BNormalNote","").equals("PERFECT PLAY"))
                    nmRecord.setText("PP");
                else if(sp.getString(titleString+"5BNormalNote","").equals("MAX COMBO"))
                    nmRecord.setText("MC");
                else
                    nmRecord.setText(sp.getString(titleString+"5BNormalRank","-"));
            }
            if(songInfo.getHd5() == 0)
                hdRecord.setText("");
            else{
                if(sp.getString(titleString+"5BHardNote","").equals("PERFECT PLAY"))
                    hdRecord.setText("PP");
                else if(sp.getString(titleString+"5BHardNote","").equals("MAX COMBO"))
                    hdRecord.setText("MC");
                else
                    hdRecord.setText(sp.getString(titleString+"5BHardRank","-"));
            }
            if(songInfo.getMx5() == 0)
                mxRecord.setText("");
            else{
                if(sp.getString(titleString+"5BMaximumNote","").equals("PERFECT PLAY"))
                    mxRecord.setText("PP");
                else if(sp.getString(titleString+"5BMaximumNote","").equals("MAX COMBO"))
                    mxRecord.setText("MC");
                else
                    mxRecord.setText(sp.getString(titleString+"5BMaximumRank","-"));
            }
        }
        else if(key.equals("6B")){
            nm.setText(songInfo.getNm6()==0 ? "-" : String.valueOf(songInfo.getNm6()));
            hd.setText(songInfo.getHd6()==0 ? "-" : String.valueOf(songInfo.getHd6()));
            mx.setText(songInfo.getMx6()==0 ? "-" : String.valueOf(songInfo.getMx6()));
            if(songInfo.getNm6() == 0)
                nmRecord.setText("");
            else{
                if(sp.getString(titleString+"6BNormalNote","").equals("PERFECT PLAY"))
                    nmRecord.setText("PP");
                else if(sp.getString(titleString+"6BNormalNote","").equals("MAX COMBO"))
                    nmRecord.setText("MC");
                else
                    nmRecord.setText(sp.getString(titleString+"6BNormalRank","-"));
            }
            if(songInfo.getHd6() == 0)
                hdRecord.setText("");
            else{
                if(sp.getString(titleString+"6BHardNote","").equals("PERFECT PLAY"))
                    hdRecord.setText("PP");
                else if(sp.getString(titleString+"6BHardNote","").equals("MAX COMBO"))
                    hdRecord.setText("MC");
                else
                    hdRecord.setText(sp.getString(titleString+"6BHardRank","-"));
            }
            if(songInfo.getMx6() == 0)
                mxRecord.setText("");
            else{
                if(sp.getString(titleString+"6BMaximumNote","").equals("PERFECT PLAY"))
                    mxRecord.setText("PP");
                else if(sp.getString(titleString+"6BMaximumNote","").equals("MAX COMBO"))
                    mxRecord.setText("MC");
                else
                    mxRecord.setText(sp.getString(titleString+"6BMaximumRank","-"));
            }
        }
        else if(key.equals("8B")){
            nm.setText(songInfo.getNm8()==0 ? "-" : String.valueOf(songInfo.getNm8()));
            hd.setText(songInfo.getHd8()==0 ? "-" : String.valueOf(songInfo.getHd8()));
            mx.setText(songInfo.getMx8()==0 ? "-" : String.valueOf(songInfo.getMx8()));
            if(songInfo.getNm8() == 0)
                nmRecord.setText("");
            else{
                if(sp.getString(titleString+"8BNormalNote","").equals("PERFECT PLAY"))
                    nmRecord.setText("PP");
                else if(sp.getString(titleString+"8BNormalNote","").equals("MAX COMBO"))
                    nmRecord.setText("MC");
                else
                    nmRecord.setText(sp.getString(titleString+"8BNormalRank","-"));
            }
            if(songInfo.getHd8() == 0)
                hdRecord.setText("");
            else{
                if(sp.getString(titleString+"8BHardNote","").equals("PERFECT PLAY"))
                    hdRecord.setText("PP");
                else if(sp.getString(titleString+"8BHardNote","").equals("MAX COMBO"))
                    hdRecord.setText("MC");
                else
                    hdRecord.setText(sp.getString(titleString+"8BHardRank","-"));
            }
            if(songInfo.getMx8() == 0)
                mxRecord.setText("");
            else{
                if(sp.getString(titleString+"8BMaximumNote","").equals("PERFECT PLAY"))
                    mxRecord.setText("PP");
                else if(sp.getString(titleString+"8BMaximumNote","").equals("MAX COMBO"))
                    mxRecord.setText("MC");
                else
                    mxRecord.setText(sp.getString(titleString+"8BMaximumRank","-"));
            }
        }

        return view;
    }
}
