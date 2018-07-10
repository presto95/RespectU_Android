package com.respect.presto.respectu;

import android.content.Context;
import android.graphics.Color;
import android.telephony.TelephonyManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.respect.presto.respectu.R;

import java.util.List;
import java.util.Locale;

/**
 * Created by presto on 2017. 10. 14..
 */

public class TrophyFragmentAdapter extends BaseAdapter {
    private Context context;
    private int layoutId;
    private LayoutInflater inflater;
    private List<TrophyInfo> items;
    private String language;
    private Locale locale;
    private String series;

    public TrophyFragmentAdapter(Context context, int layoutId, List<TrophyInfo> items, String language, Locale locale, String series){
        this.context=context;
        this.layoutId=layoutId;
        this.items=items;
        this.inflater=LayoutInflater.from(context);
        this.language=language;
        this.locale=locale;
        this.series = series;
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
        ImageView imageView = view.findViewById(R.id.imageTrophy);
        final TextView title=(TextView)view.findViewById(R.id.labelTitle);
        final TextView content=(TextView)view.findViewById(R.id.labelContent);
        title.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
            @Override
            public void onLayoutChange(View view, int i, int i1, int i2, int i3, int i4, int i5, int i6, int i7) {
                title.setSelected(true);
            }
        });
        content.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
            @Override
            public void onLayoutChange(View view, int i, int i1, int i2, int i3, int i4, int i5, int i6, int i7) {
                content.setSelected(true);
            }
        });

        TrophyInfo trophyInfo=this.items.get(i);
        switch(series){
            case "Respect":
                imageView.setImageResource(view.getResources().getIdentifier("respect"+(i+1), "drawable", context.getPackageName()));
                break;
            case "Trilogy":
                imageView.setImageResource(view.getResources().getIdentifier("trilogy"+(i+1), "drawable", context.getPackageName()));
                break;
            case "CE":
                imageView.setImageResource(view.getResources().getIdentifier("ce"+(i+1), "drawable", context.getPackageName()));
                break;
            case "Technika1":
                imageView.setImageResource(view.getResources().getIdentifier("technika1"+(i+1), "drawable", context.getPackageName()));
            default:
                break;
        }
        if(trophyInfo.getRating().equals("PLATINUM"))
            color.setBackgroundColor(Color.rgb(229,228,226));
        else if(trophyInfo.getRating().equals("GOLD"))
            color.setBackgroundColor(Color.rgb(212,175,55));
        else if(trophyInfo.getRating().equals("SILVER"))
            color.setBackgroundColor(Color.rgb(192,192,192));
        else if(trophyInfo.getRating().equals("BRONZE"))
            color.setBackgroundColor(Color.rgb(205,127,50));
        if(locale.toString().equals("ko_KR")){
            title.setText(trophyInfo.getTitleKor());
            content.setText(trophyInfo.getContentKor());
        }
        else{
            title.setText(trophyInfo.getTitleEng());
            content.setText(trophyInfo.getContentEng());
        }
        return view;
    }
}
