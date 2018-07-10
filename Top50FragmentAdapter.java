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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import io.realm.Realm;

/**
 * Created by presto on 2017. 10. 13..
 */

public class Top50FragmentAdapter extends BaseAdapter{
    private Context context;
    private int layoutId;
    private LayoutInflater inflater;
    private Map<String, Float> items;
    private Realm realm = Realm.getDefaultInstance();
    private int button;
    SharedPreferences sp;



    public Top50FragmentAdapter(Context context, int layoutId, Map<String, Float> items, int button){ //Map<String, Float>
        this.context=context;
        this.layoutId=layoutId;
        this.items=items;
        this.inflater=LayoutInflater.from(context);
        this.button = button;
        sp = context.getSharedPreferences("Record", Context.MODE_PRIVATE);
        //iterator = sortByValue(items).iterator();
    }

    @Override
    public int getCount() {
        return 50;
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view==null)
            view=inflater.inflate(this.layoutId,null);
        TextView color = view.findViewById(R.id.top50Color);
        TextView title = view.findViewById(R.id.top50Title);
        TextView skillPoint = view.findViewById(R.id.top50SkillPoint);
        TextView difficulty = view.findViewById(R.id.top50Difficulty);
        TextView note = view.findViewById(R.id.top50Note);
        TextView accuracy = view.findViewById(R.id.top50Accuracy);

        List list = sortByValue(items);
        Object key = list.get(i);
        title.setText((String)key);
        skillPoint.setText(items.get(key).toString());
        String realTitle = (String)key;
        switch(button){
            case 0:
                difficulty.setText(sp.getString(realTitle + "4BHighestDifficulty", "-"));
                note.setText(sp.getString(realTitle + "4BHighestNote", "-"));
                accuracy.setText(sp.getString(realTitle + "4BHighestRate", "-"));
                break;
            case 1:
                difficulty.setText(sp.getString(realTitle + "5BHighestDifficulty", "-"));
                note.setText(sp.getString(realTitle + "5BHighestNote", "-"));
                accuracy.setText(sp.getString(realTitle + "5BHighestRate", "-"));
                break;
            case 2:
                difficulty.setText(sp.getString(realTitle + "6BHighestDifficulty", "-"));
                note.setText(sp.getString(realTitle + "6BHighestNote", "-"));
                accuracy.setText(sp.getString(realTitle + "6BHighestRate", "-"));
                break;
            case 3:
                difficulty.setText(sp.getString(realTitle + "8BHighestDifficulty", "-"));
                note.setText(sp.getString(realTitle + "8BHighestNote", "-"));
                accuracy.setText(sp.getString(realTitle + "8BHighestRate", "-"));
                break;
            default:
                break;
        }





        switch(realm.where(SongInfo.class).equalTo("title", title.getText().toString()).findAll().get(0).getSeries()){
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
        return view;
    }

    public static List sortByValue(final Map map) {
        List<String> list = new ArrayList();
        list.addAll(map.keySet());

        Collections.sort(list,new Comparator() {

            public int compare(Object o1,Object o2) {
                Object v1 = map.get(o1);
                Object v2 = map.get(o2);

                return ((Comparable) v2).compareTo(v1);
            }

        });
        //Collections.reverse(list); // 주석시 오름차순
        return list;
    }

}
