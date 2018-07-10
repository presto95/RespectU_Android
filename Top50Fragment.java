package com.respect.presto.respectu;

import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.bigkoo.pickerview.MyOptionsPickerView;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import info.hoang8f.android.segmented.SegmentedGroup;
import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by presto on 2017. 11. 19..
 */

public class Top50Fragment extends android.support.v4.app.Fragment {

    private Realm realm;
    private RealmResults<SongInfo> results;
    private SharedPreferences sp;
    private ListView listView;
    private Top50FragmentAdapter adapter;
    private Map<String, Float> button4Map = new HashMap<>();
    private Map<String, Float> button5Map = new HashMap<>();
    private Map<String, Float> button6Map = new HashMap<>();
    private Map<String, Float> button8Map = new HashMap<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_top50, container, false);
    }
    @Override
    public void onStart() {
        super.onStart();
        realm = Realm.getDefaultInstance();
        results = realm.where(SongInfo.class).findAll();
        sp = getActivity().getSharedPreferences("Record", Context.MODE_PRIVATE);
        //results는 List<Top50Info>
        for(SongInfo i: results){
            String title = i.getTitle();
            float button4SkillPoint = sp.getFloat(title+"4BSkillPoint",0);
            float button5SkillPoint = sp.getFloat(title+"5BSkillPoint",0);
            float button6SkillPoint = sp.getFloat(title+"6BSkillPoint",0);
            float button8SkillPoint = sp.getFloat(title+"8BSkillPoint",0);
            button4Map.put(i.getTitle(), button4SkillPoint);
            button5Map.put(i.getTitle(), button5SkillPoint);
            button6Map.put(i.getTitle(), button6SkillPoint);
            button8Map.put(i.getTitle(), button8SkillPoint);
        }
        listView = getView().findViewById(R.id.listTop50);
        switch(getArguments().getString("key")) {
            case "4B":
                adapter = new Top50FragmentAdapter(getContext(), R.layout.list_top50, button4Map, 0);
                break;
            case "5B":
                adapter = new Top50FragmentAdapter(getContext(), R.layout.list_top50, button5Map, 1);
                break;
            case "6B":
                adapter = new Top50FragmentAdapter(getContext(), R.layout.list_top50, button6Map, 2);
                break;
            case "8B":
                adapter = new Top50FragmentAdapter(getContext(), R.layout.list_top50, button8Map, 3);
                break;
            default:
                break;
        }
        listView.setAdapter(adapter);
    }

    @Override
    public void onStop(){
        getActivity().findViewById(R.id.segmentedControl).setEnabled(true);
        super.onStop();
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
