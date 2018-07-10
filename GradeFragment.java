package com.respect.presto.respectu;

import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
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

public class GradeFragment extends android.support.v4.app.Fragment implements RadioGroup.OnCheckedChangeListener {

    private Realm realm;
    private RealmResults<SongInfo> results;
    private SharedPreferences sp;
    private SegmentedGroup segmentedControl;
    private TextView skillLevel;
    private TextView skillPoint;
    private PieChart chart;
    private TextView next;
    private TextView firstSkillPoint;
    private TextView firstColor;
    private TextView firstSong;
    private TextView lastSkillPoint;
    private TextView lastColor;
    private TextView lastSong;
    private TextView top50;
    private String key;
    private float button4SkillPoint=0;
    private String button4SkillLevel="";
    private float button4Percent=0;
    private float button5SkillPoint=0;
    private String button5SkillLevel="";
    private float button5Percent=0;
    private float button6SkillPoint=0;
    private String button6SkillLevel="";
    private float button6Percent=0;
    private float button8SkillPoint=0;
    private String button8SkillLevel="";
    private float button8Percent=0;
    private float button4MaxSkillPoint = 0;
    private float button5MaxSkillPoint = 0;
    private float button6MaxSkillPoint = 0;
    private float button8MaxSkillPoint = 0;
    private ArrayList<Integer> colors;
    private String[] button4GradeArray = {"BEGINNER", "AMATEUR 4", "AMATEUR 3", "AMATEUR 2", "AMATEUR 1", "SUB DJ 4", "SUB DJ 3", "SUB DJ 2", "SUB DJ 1", "MAIN DJ 4", "MAIN DJ 3", "MAIN DJ 2", "MAIN DJ 1", "POP DJ 4", "POP DJ 3", "POP DJ 2", "POP DJ 1", "PROFESSIONAL 3", "PROFESSIONAL 2", "PROFESSIONAL 1", "MIX MASTER 3", "MIX MASTER 2", "MIX MASTER 1", "SUPERSTAR 3", "SUPERSTAR 2", "SUPERSTAR 1", "DJMAX GRAND MASTER", "THE DJMAX"};
    private String[] button5GradeArray = {"BEGINNER", "AMATEUR 4", "AMATEUR 3", "AMATEUR 2", "AMATEUR 1", "SUB DJ 4", "SUB DJ 3", "SUB DJ 2", "SUB DJ 1", "MAIN DJ 4", "MAIN DJ 3", "MAIN DJ 2", "MAIN DJ 1", "POP DJ 4", "POP DJ 3", "POP DJ 2", "POP DJ 1", "PROFESSIONAL 4", "PROFESSIONAL 3", "PROFESSIONAL 2", "PROFESSIONAL 1", "MIX MASTER 3", "MIX MASTER 2", "MIX MASTER 1", "SUPERSTAR 3", "SUPERSTAR 2", "SUPERSTAR 1", "DJMAX GRAND MASTER", "THE DJMAX"};
    private String[] button6And8GradeArray = {"BEGINNER", "AMATEUR 4", "AMATEUR 3", "AMATEUR 2", "AMATEUR 1", "SUB DJ 4", "SUB DJ 3", "SUB DJ 2", "SUB DJ 1", "MAIN DJ 4", "MAIN DJ 3", "MAIN DJ 2", "MAIN DJ 1", "POP DJ 4", "POP DJ 3", "POP DJ 2", "POP DJ 1", "PROFESSIONAL 4", "PROFESSIONAL 3", "PROFESSIONAL 2", "PROFESSIONAL 1", "MIX MASTER 3", "MIX MASTER 2", "MIX MASTER 1", "SUPERSTAR 3", "SUPERSTAR 2", "SUPERSTAR 1", "DJMAX GRAND MASTER", "THE DJMAX"};

    private Map<String, Float> button4Map = new HashMap<>();
    private Map<String, Float> button5Map = new HashMap<>();
    private Map<String, Float> button6Map = new HashMap<>();
    private Map<String, Float> button8Map = new HashMap<>();
    private Iterator button4Iterator;
    private Iterator button5Iterator;
    private Iterator button6Iterator;
    private Iterator button8Iterator;
    private String button4FirstKey;
    private String button5FirstKey;
    private String button6FirstKey;
    private String button8FirstKey;
    private String button4LastKey;
    private String button5LastKey;
    private String button6LastKey;
    private String button8LastKey;

    private String firstSeries = "";
    private String lastSeries = "";



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_grade, container, false);
    }
    @Override
    public void onStart() {
        super.onStart();
        realm = Realm.getDefaultInstance();
        results = realm.where(SongInfo.class).findAll();
        sp = getActivity().getSharedPreferences("Record", Context.MODE_PRIVATE);
        DescendingInteger descendingInteger = new DescendingInteger();
        DescendingFloat descendingFloat = new DescendingFloat();
        top50 = getView().findViewById(R.id.buttonTop50);
        skillLevel = getView().findViewById(R.id.labelSkillLevel);
        skillPoint = getView().findViewById(R.id.labelSkillPoint);
        chart = getView().findViewById(R.id.chart);
        next = getView().findViewById(R.id.labelNext);
        firstSkillPoint = getView().findViewById(R.id.labelFirstSkillPoint);
        firstColor = getView().findViewById(R.id.labelFirstColor);
        firstSong = getView().findViewById(R.id.labelFirstSong);
        lastSkillPoint = getView().findViewById(R.id.labelLastSkillPoint);
        lastColor = getView().findViewById(R.id.labelLastColor);
        lastSong = getView().findViewById(R.id.labelLastSong);
        segmentedControl = getView().findViewById(R.id.segmentedControl);
        key = getActivity().getSharedPreferences("Setting", Context.MODE_PRIVATE).getString("favoriteButton", "4B");
        segmentedControl.setOnCheckedChangeListener(this);

        chart.setCenterTextSize(20);
        chart.setDescription(null);
        chart.setTouchEnabled(false);
        chart.setHoleRadius(80);


        colors = new ArrayList<>();
        colors.add(Color.GRAY);
        colors.add(Color.RED);
        Legend legend = chart.getLegend();
        legend.setForm(Legend.LegendForm.CIRCLE);
        legend.setDirection(Legend.LegendDirection.LEFT_TO_RIGHT);

        this.button4SkillPoint = 0;
        this.button5SkillPoint = 0;
        this.button6SkillPoint = 0;
        this.button8SkillPoint = 0;
        this.button4MaxSkillPoint=0;
        this.button5MaxSkillPoint=0;
        this.button6MaxSkillPoint=0;
        this.button8MaxSkillPoint=0;

        ArrayList<Integer> button4Top50 = new ArrayList<>();
        ArrayList<Integer> button5Top50 = new ArrayList<>();
        ArrayList<Integer> button6Top50 = new ArrayList<>();
        ArrayList<Integer> button8Top50 = new ArrayList<>();

        for(SongInfo i: results){
            int[] button4Array = {i.getNm4(), i.getHd4(), i.getMx4() };
            int[] button5Array = {i.getNm5(), i.getHd5(), i.getMx5() };
            int[] button6Array = {i.getNm6(), i.getHd6(), i.getMx6() };
            int[] button8Array = {i.getNm8(), i.getHd8(), i.getMx8() };
            Arrays.sort(button4Array);
            Arrays.sort(button5Array);
            Arrays.sort(button6Array);
            Arrays.sort(button8Array);
            int button4MaxDifficulty = button4Array[2];
            int button5MaxDifficulty = button5Array[2];
            int button6MaxDifficulty = button6Array[2];
            int button8MaxDifficulty = button8Array[2];
            button4Top50.add(button4MaxDifficulty);
            button5Top50.add(button5MaxDifficulty);
            button6Top50.add(button6MaxDifficulty);
            button8Top50.add(button8MaxDifficulty);
        }
        Collections.sort(button4Top50, descendingInteger);
        Collections.sort(button5Top50, descendingInteger);
        Collections.sort(button6Top50, descendingInteger);
        Collections.sort(button8Top50, descendingInteger);
        for(int i=0;i<50;++i){
            this.button4MaxSkillPoint = this.button4MaxSkillPoint + getWeight(button4Top50.get(i)) * 105;
            this.button5MaxSkillPoint = this.button5MaxSkillPoint + getWeight(button5Top50.get(i)) * 105;
            this.button6MaxSkillPoint = this.button6MaxSkillPoint + getWeight(button6Top50.get(i)) * 105;
            this.button8MaxSkillPoint = this.button8MaxSkillPoint + getWeight(button8Top50.get(i)) * 105;
        }
        //여기까지 만점 계산 끝

        ArrayList<Float> button4SkillPointArray = new ArrayList<>();
        ArrayList<Float> button5SkillPointArray = new ArrayList<>();
        ArrayList<Float> button6SkillPointArray = new ArrayList<>();
        ArrayList<Float> button8SkillPointArray = new ArrayList<>();



        for(SongInfo i: results){
            String title = i.getTitle();
            float button4SkillPoint = sp.getFloat(title+"4BSkillPoint",0);
            float button5SkillPoint = sp.getFloat(title+"5BSkillPoint",0);
            float button6SkillPoint = sp.getFloat(title+"6BSkillPoint",0);
            float button8SkillPoint = sp.getFloat(title+"8BSkillPoint",0);
            button4SkillPointArray.add(button4SkillPoint);
            button5SkillPointArray.add(button5SkillPoint);
            button6SkillPointArray.add(button6SkillPoint);
            button8SkillPointArray.add(button8SkillPoint);

            button4Map.put(i.getTitle(), button4SkillPoint);
            button5Map.put(i.getTitle(), button5SkillPoint);
            button6Map.put(i.getTitle(), button6SkillPoint);
            button8Map.put(i.getTitle(), button8SkillPoint);
        }
        Collections.sort(button4SkillPointArray,descendingFloat);
        Collections.sort(button5SkillPointArray,descendingFloat);
        Collections.sort(button6SkillPointArray,descendingFloat);
        Collections.sort(button8SkillPointArray,descendingFloat);
        button4Iterator = sortByValue(button4Map).iterator();
        button5Iterator = sortByValue(button5Map).iterator();
        button6Iterator = sortByValue(button6Map).iterator();
        button8Iterator = sortByValue(button8Map).iterator();
        button4FirstKey = (String)button4Iterator.next();
        button5FirstKey = (String)button5Iterator.next();
        button6FirstKey = (String)button6Iterator.next();
        button8FirstKey = (String)button8Iterator.next();
        for(int i=0;i<49;++i){
            button4LastKey = (String)button4Iterator.next();
            button5LastKey = (String)button5Iterator.next();
            button6LastKey = (String)button6Iterator.next();
            button8LastKey = (String)button8Iterator.next();
        }
        for(int i=0;i<50;++i){
            this.button4SkillPoint = this.button4SkillPoint + button4SkillPointArray.get(i);
            this.button5SkillPoint = this.button5SkillPoint + button5SkillPointArray.get(i);
            this.button6SkillPoint = this.button6SkillPoint + button6SkillPointArray.get(i);
            this.button8SkillPoint = this.button8SkillPoint + button8SkillPointArray.get(i);
        }
        //Top 50

        this.button4SkillLevel = getGradeButton4(this.button4SkillPoint);
        this.button5SkillLevel = getGradeButton5(this.button5SkillPoint);
        this.button6SkillLevel = getGradeButton6And8(this.button6SkillPoint);
        this.button8SkillLevel = getGradeButton6And8(this.button8SkillPoint);
        //스킬레벨

        this.button4Percent = Math.round(this.button4SkillPoint / button4MaxSkillPoint * 10000f) / 100f;
        this.button5Percent = Math.round(this.button5SkillPoint / button5MaxSkillPoint * 10000f) / 100f;
        this.button6Percent = Math.round(this.button6SkillPoint / button6MaxSkillPoint * 10000f) / 100f;
        this.button8Percent = Math.round(this.button8SkillPoint / button8MaxSkillPoint * 10000f) / 100f;
        //퍼센트


        switch(key){
            case "4B":
                segmentedControl.check(R.id.segment0);
                skillPoint.setText(getString(R.string.Skill_Point)+" : "+String.valueOf(Math.round(this.button4SkillPoint * 100f) / 100f));
                skillLevel.setText(this.button4SkillLevel);
                chart.setCenterText(String.valueOf(this.button4Percent)+"%");
                ArrayList<PieEntry> button4Entries = new ArrayList<>();
                button4Entries.add(new PieEntry(button4MaxSkillPoint - this.button4SkillPoint, 0));
                button4Entries.add(new PieEntry(this.button4SkillPoint, 1));
                PieDataSet button4PieDataSet = new PieDataSet(button4Entries, "");
                button4PieDataSet.setSliceSpace(2);
                button4PieDataSet.setValueTextSize(0);
                button4PieDataSet.setColors(colors);
                PieData button4PieData = new PieData(button4PieDataSet);
                chart.setData(button4PieData);
                next.setText(getNextString(this.button4SkillLevel, 0));
                firstSkillPoint.setText(String.valueOf(button4Map.get(button4FirstKey)));
                firstSong.setText(button4FirstKey);
                firstSeries = realm.where(SongInfo.class).equalTo("title", firstSong.getText().toString()).findAll().get(0).getSeries();
                firstColor.setBackgroundColor(getColor(firstSeries));
                lastSkillPoint.setText(String.valueOf(button4Map.get(button4LastKey)));
                lastSong.setText(button4LastKey);
                lastSeries = realm.where(SongInfo.class).equalTo("title", lastSong.getText().toString()).findAll().get(0).getSeries();
                lastColor.setBackgroundColor(getColor(lastSeries));
                break;
            case "5B":
                segmentedControl.check(R.id.segment1);
                skillPoint.setText(getString(R.string.Skill_Point)+" : "+String.valueOf(Math.round(this.button5SkillPoint * 100f) / 100f));
                skillLevel.setText(this.button5SkillLevel);
                chart.setCenterText(String.valueOf(this.button5Percent)+"%");
                ArrayList<PieEntry> button5Entries = new ArrayList<>();
                button5Entries.add(new PieEntry(button5MaxSkillPoint - this.button5SkillPoint, 0));
                button5Entries.add(new PieEntry(this.button5SkillPoint, 1));
                PieDataSet button5PieDataSet = new PieDataSet(button5Entries, "");
                button5PieDataSet.setSliceSpace(2);
                button5PieDataSet.setValueTextSize(0);
                button5PieDataSet.setColors(colors);
                PieData button5PieData = new PieData(button5PieDataSet);
                chart.setData(button5PieData);
                next.setText(getNextString(this.button5SkillLevel, 1));
                firstSkillPoint.setText(String.valueOf(button5Map.get(button5FirstKey)));
                firstSong.setText(button5FirstKey);
                firstSeries = realm.where(SongInfo.class).equalTo("title", firstSong.getText().toString()).findAll().get(0).getSeries();
                firstColor.setBackgroundColor(getColor(firstSeries));
                lastSkillPoint.setText(String.valueOf(button5Map.get(button5LastKey)));
                lastSong.setText(button5LastKey);
                lastSeries = realm.where(SongInfo.class).equalTo("title", lastSong.getText().toString()).findAll().get(0).getSeries();
                lastColor.setBackgroundColor(getColor(lastSeries));
                break;
            case "6B":
                segmentedControl.check(R.id.segment2);
                skillPoint.setText(getString(R.string.Skill_Point)+" : "+String.valueOf(Math.round(this.button6SkillPoint * 100f) / 100f));
                skillLevel.setText(this.button6SkillLevel);
                chart.setCenterText(String.valueOf(this.button6Percent)+"%");
                ArrayList<PieEntry> button6Entries = new ArrayList<>();
                button6Entries.add(new PieEntry(button6MaxSkillPoint - this.button6SkillPoint, 0));
                button6Entries.add(new PieEntry(this.button6SkillPoint, 1));
                PieDataSet button6PieDataSet = new PieDataSet(button6Entries, "");
                button6PieDataSet.setSliceSpace(2);
                button6PieDataSet.setValueTextSize(0);
                button6PieDataSet.setColors(colors);
                PieData button6PieData = new PieData(button6PieDataSet);
                chart.setData(button6PieData);
                next.setText(getNextString(this.button6SkillLevel, 2));
                firstSkillPoint.setText(String.valueOf(button6Map.get(button6FirstKey)));
                firstSong.setText(button6FirstKey);
                firstSeries = realm.where(SongInfo.class).equalTo("title", firstSong.getText().toString()).findAll().get(0).getSeries();
                firstColor.setBackgroundColor(getColor(firstSeries));
                lastSkillPoint.setText(String.valueOf(button6Map.get(button6LastKey)));
                lastSong.setText(button6LastKey);
                lastSeries = realm.where(SongInfo.class).equalTo("title", lastSong.getText().toString()).findAll().get(0).getSeries();
                lastColor.setBackgroundColor(getColor(lastSeries));
                break;
            case "8B":
                segmentedControl.check(R.id.segment3);
                skillPoint.setText(getString(R.string.Skill_Point)+" : "+String.valueOf(Math.round(this.button8SkillPoint * 100f) / 100f));
                skillLevel.setText(this.button8SkillLevel);
                chart.setCenterText(String.valueOf(this.button8Percent)+"%");
                ArrayList<PieEntry> button8Entries = new ArrayList<>();
                button8Entries.add(new PieEntry(button8MaxSkillPoint - this.button8SkillPoint, 0));
                button8Entries.add(new PieEntry(this.button8SkillPoint, 1));
                PieDataSet button8PieDataSet = new PieDataSet(button8Entries, "");
                button8PieDataSet.setSliceSpace(2);
                button8PieDataSet.setValueTextSize(0);
                button8PieDataSet.setColors(colors);
                PieData button8PieData = new PieData(button8PieDataSet);
                chart.setData(button8PieData);
                next.setText(getNextString(this.button8SkillLevel, 3));
                firstSkillPoint.setText(String.valueOf(button8Map.get(button8FirstKey)));
                firstSong.setText(button8FirstKey);
                firstSeries = realm.where(SongInfo.class).equalTo("title", firstSong.getText().toString()).findAll().get(0).getSeries();
                firstColor.setBackgroundColor(getColor(firstSeries));
                lastSkillPoint.setText(String.valueOf(button8Map.get(button8LastKey)));
                lastSong.setText(button8LastKey);
                lastSeries = realm.where(SongInfo.class).equalTo("title", lastSong.getText().toString()).findAll().get(0).getSeries();
                lastColor.setBackgroundColor(getColor(lastSeries));
                break;
            default:
                break;
        }

        top50.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                segmentedControl.setEnabled(false);
                Bundle bundle=new Bundle(1);
                bundle.putString("key", key);
                Top50Fragment top50Fragment = new Top50Fragment();
                top50Fragment.setArguments(bundle);
                FragmentTransaction top50Transaction = getActivity().getSupportFragmentManager().beginTransaction();
                top50Transaction.replace(R.id.gradeContainer, top50Fragment);
                top50Transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                top50Transaction.addToBackStack(null);
                top50Transaction.commit();
            }
        });
    }

    @Override
    public void onStop(){
        getActivity().findViewById(R.id.listMore).setEnabled(true);
        super.onStop();
    }

    String getGradeButton4(float value){
        String returnString = "";
        if(value >= 0 && value < 1000)
            returnString = "BEGINNER";
        else if(value > 1000 && value <= 1500)
            returnString = "AMATEUR 4";
        else if(value > 1500 && value <= 2000)
            returnString = "AMATEUR 3";
        else if(value > 2000 && value <= 2300)
            returnString = "AMATEUR 2";
        else if(value > 2300 && value <= 2600)
            returnString = "AMATEUR 1";
        else if(value > 2600 && value <= 3000)
            returnString = "SUB DJ 4";
        else if(value > 3000 && value <= 3300)
            returnString = "SUB DJ 3";
        else if(value > 3300 && value <= 3600)
            returnString = "SUB DJ 2";
        else if(value > 3600 && value <= 4000)
            returnString = "SUB DJ 1";
        else if(value > 4000 && value <= 4300)
            returnString = "MAIN DJ 4";
        else if(value > 4300 && value <= 4600)
            returnString = "MAIN DJ 3";
        else if(value > 4600 && value <= 5000)
            returnString = "MAIN DJ 2";
        else if(value > 5000 && value <= 5300)
            returnString = "MAIN DJ 1";
        else if(value > 5300 && value <= 5600)
            returnString = "POP DJ 4";
        else if(value > 5600 && value <= 6000)
            returnString = "POP DJ 3";
        else if(value > 6000 && value <= 6300)
            returnString = "POP DJ 2";
        else if(value > 6300 && value <= 6600)
            returnString = "POP DJ 1";
        else if(value > 6600 && value <= 7000)
            returnString = "PROFESSIONAL 3";
        else if(value > 7000 && value <= 7200)
            returnString = "PROFESSIONAL 2";
        else if(value > 7200 && value <= 7400)
            returnString = "PROFESSIONAL 1";
        else if(value > 7400 && value <= 7600)
            returnString = "MIX MASTER 3";
        else if(value > 7600 && value <= 7800)
            returnString = "MIX MASTER 2";
        else if(value > 7800 && value <= 8000)
            returnString = "MIX MASTER 1";
        else if(value > 8000 && value <= 8200)
            returnString = "SUPERSTAR 3";
        else if(value > 8200 && value <= 8400)
            returnString = "SUPERSTAR 2";
        else if(value > 8400 && value <= 8600)
            returnString = "SUPERSTAR 1";
        else if(value > 8600 && value <= 8800)
            returnString = "DJMAX GRAND MASTER";
        else if(value > 8800)
            returnString = "THE DJMAX";
        return returnString;
    }

    String getGradeButton5(float value){
        String returnString = "";
        if(value >= 0 && value < 1000)
            returnString = "BEGINNER";
        else if(value > 1000 && value <= 1500)
            returnString = "AMATEUR 4";
        else if(value > 1500 && value <= 2000)
            returnString = "AMATEUR 3";
        else if(value > 2000 && value <= 2300)
            returnString = "AMATEUR 2";
        else if(value > 2300 && value <= 2600)
            returnString = "AMATEUR 1";
        else if(value > 2600 && value <= 3000)
            returnString = "SUB DJ 4";
        else if(value > 3000 && value <= 3300)
            returnString = "SUB DJ 3";
        else if(value > 3300 && value <= 3600)
            returnString = "SUB DJ 2";
        else if(value > 3600 && value <= 4000)
            returnString = "SUB DJ 1";
        else if(value > 4000 && value <= 4300)
            returnString = "MAIN DJ 4";
        else if(value > 4300 && value <= 4600)
            returnString = "MAIN DJ 3";
        else if(value > 4600 && value <= 5000)
            returnString = "MAIN DJ 2";
        else if(value > 5000 && value <= 5300)
            returnString = "MAIN DJ 1";
        else if(value > 5300 && value <= 5600)
            returnString = "POP DJ 4";
        else if(value > 5600 && value <= 6000)
            returnString = "POP DJ 3";
        else if(value > 6000 && value <= 6300)
            returnString = "POP DJ 2";
        else if(value > 6300 && value <= 6600)
            returnString = "POP DJ 1";
        else if(value > 6600 && value <= 7000)
            returnString = "PROFESSIONAL 4";
        else if(value > 7000 && value <= 7200)
            returnString = "PROFESSIONAL 3";
        else if(value > 7200 && value <= 7400)
            returnString = "PROFESSIONAL 2";
        else if(value > 7400 && value <= 7600)
            returnString = "PROFESSIONAL 1";
        else if(value > 7600 && value <= 7800)
            returnString = "MIX MASTER 3";
        else if(value > 7800 && value <= 8000)
            returnString = "MIX MASTER 2";
        else if(value > 8000 && value <= 8200)
            returnString = "MIX MASTER 1";
        else if(value > 8200 && value <= 8400)
            returnString = "SUPERSTAR 3";
        else if(value > 8400 && value <= 8600)
            returnString = "SUPERSTAR 2";
        else if(value > 8600 && value <= 8800)
            returnString = "SUPERSTAR 1";
        else if(value > 8800 && value <= 9000)
            returnString = "DJMAX GRAND MASTER";
        else if(value > 9000)
            returnString = "THE DJMAX";
        return returnString;
    }

    String getGradeButton6And8(float value){
        String returnString = "";
        if(value >= 0 && value < 1500)
            returnString = "BEGINNER";
        else if(value > 1500 && value <= 2000)
            returnString = "AMATEUR 4";
        else if(value > 2000 && value <= 2300)
            returnString = "AMATEUR 3";
        else if(value > 2300 && value <= 2600)
            returnString = "AMATEUR 2";
        else if(value > 2600 && value <= 3000)
            returnString = "AMATEUR 1";
        else if(value > 3000 && value <= 3300)
            returnString = "SUB DJ 4";
        else if(value > 3300 && value <= 3600)
            returnString = "SUB DJ 3";
        else if(value > 3600 && value <= 4000)
            returnString = "SUB DJ 2";
        else if(value > 4000 && value <= 4300)
            returnString = "SUB DJ 1";
        else if(value > 4300 && value <= 4600)
            returnString = "MAIN DJ 4";
        else if(value > 4600 && value <= 5000)
            returnString = "MAIN DJ 3";
        else if(value > 5000 && value <= 5300)
            returnString = "MAIN DJ 2";
        else if(value > 5300 && value <= 5600)
            returnString = "MAIN DJ 1";
        else if(value > 5600 && value <= 6000)
            returnString = "POP DJ 4";
        else if(value > 6000 && value <= 6300)
            returnString = "POP DJ 3";
        else if(value > 6300 && value <= 6600)
            returnString = "POP DJ 2";
        else if(value > 6600 && value <= 7000)
            returnString = "POP DJ 1";
        else if(value > 7000 && value <= 7200)
            returnString = "PROFESSIONAL 4";
        else if(value > 7200 && value <= 7400)
            returnString = "PROFESSIONAL 3";
        else if(value > 7400 && value <= 7600)
            returnString = "PROFESSIONAL 2";
        else if(value > 7600 && value <= 7800)
            returnString = "PROFESSIONAL 1";
        else if(value > 7800 && value <= 8000)
            returnString = "MIX MASTER 3";
        else if(value > 8000 && value <= 8200)
            returnString = "MIX MASTER 2";
        else if(value > 8200 && value <= 8400)
            returnString = "MIX MASTER 1";
        else if(value > 8400 && value <= 8600)
            returnString = "SUPERSTAR 3";
        else if(value > 8600 && value <= 8800)
            returnString = "SUPERSTAR 2";
        else if(value > 8800 && value <= 9000)
            returnString = "SUPERSTAR 1";
        else if(value > 9000 && value <= 9200)
            returnString = "DJMAX GRAND MASTER";
        else if(value > 9200)
            returnString = "THE DJMAX";
        return returnString;
    }

    float getWeight(int value){
        switch(value){
            case 1:
                return 0.4f;
            case 2:
                return 0.6f;
            case 3:
                return 0.8f;
            case 4:
                return 1f;
            case 5:
                return 1.14f;
            case 6:
                return 1.24f;
            case 7:
                return 1.33f;
            case 8:
                return 1.42f;
            case 9:
                return 1.53f;
            case 10:
                return 1.6f;
            case 11:
                return 1.68f;
            case 12:
                return 1.77f;
            case 13:
                return 1.85f;
            case 14:
                return 1.94f;
            case 15:
                return 2f;
            default:
                return 0f;
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch(i){
            case R.id.segment0:
                key = "4B";
                segmentedControl.check(R.id.segment0);
                skillPoint.setText(getString(R.string.Skill_Point)+" : "+String.valueOf(Math.round(this.button4SkillPoint * 100f) / 100f));
                skillLevel.setText(this.button4SkillLevel);
                chart.setCenterText(String.valueOf(this.button4Percent)+"%");
                ArrayList<PieEntry> button4Entries = new ArrayList<>();
                button4Entries.add(new PieEntry(this.button4MaxSkillPoint - this.button4SkillPoint, 0));
                button4Entries.add(new PieEntry(this.button4SkillPoint, 1));
                PieDataSet button4PieDataSet = new PieDataSet(button4Entries, "");
                button4PieDataSet.setSliceSpace(2);
                button4PieDataSet.setValueTextSize(0);
                button4PieDataSet.setColors(colors);
                PieData button4PieData = new PieData(button4PieDataSet);
                chart.setData(button4PieData);
                next.setText(getNextString(this.button4SkillLevel, 0));
                firstSkillPoint.setText(String.valueOf(button4Map.get(button4FirstKey)));
                firstSong.setText(button4FirstKey);
                firstSeries = realm.where(SongInfo.class).equalTo("title", firstSong.getText().toString()).findAll().get(0).getSeries();
                firstColor.setBackgroundColor(getColor(firstSeries));
                lastSkillPoint.setText(String.valueOf(button4Map.get(button4LastKey)));
                lastSong.setText(button4LastKey);
                lastSeries = realm.where(SongInfo.class).equalTo("title", lastSong.getText().toString()).findAll().get(0).getSeries();
                lastColor.setBackgroundColor(getColor(lastSeries));
                chart.invalidate();
                break;
            case R.id.segment1:
                key = "5B";
                segmentedControl.check(R.id.segment1);
                skillPoint.setText(getString(R.string.Skill_Point)+" : "+String.valueOf(Math.round(this.button5SkillPoint * 100f) / 100f));
                skillLevel.setText(this.button5SkillLevel);
                chart.setCenterText(String.valueOf(this.button5Percent)+"%");
                ArrayList<PieEntry> button5Entries = new ArrayList<>();
                button5Entries.add(new PieEntry(this.button5MaxSkillPoint - this.button5SkillPoint, 0));
                button5Entries.add(new PieEntry(this.button5SkillPoint, 1));
                PieDataSet button5PieDataSet = new PieDataSet(button5Entries, "");
                button5PieDataSet.setSliceSpace(2);
                button5PieDataSet.setValueTextSize(0);
                button5PieDataSet.setColors(colors);
                PieData button5PieData = new PieData(button5PieDataSet);
                chart.setData(button5PieData);
                next.setText(getNextString(this.button5SkillLevel, 1));
                firstSkillPoint.setText(String.valueOf(button5Map.get(button5FirstKey)));
                firstSong.setText(button5FirstKey);
                firstSeries = realm.where(SongInfo.class).equalTo("title", firstSong.getText().toString()).findAll().get(0).getSeries();
                firstColor.setBackgroundColor(getColor(firstSeries));
                lastSkillPoint.setText(String.valueOf(button5Map.get(button5LastKey)));
                lastSong.setText(button5LastKey);
                lastSeries = realm.where(SongInfo.class).equalTo("title", lastSong.getText().toString()).findAll().get(0).getSeries();
                lastColor.setBackgroundColor(getColor(lastSeries));
                chart.invalidate();
                break;
            case R.id.segment2:
                key = "6B";
                segmentedControl.check(R.id.segment2);
                skillPoint.setText(getString(R.string.Skill_Point)+" : "+String.valueOf(Math.round(this.button6SkillPoint * 100f) / 100f));
                skillLevel.setText(this.button6SkillLevel);
                chart.setCenterText(String.valueOf(this.button6Percent)+"%");
                ArrayList<PieEntry> button6Entries = new ArrayList<>();
                button6Entries.add(new PieEntry(this.button6MaxSkillPoint - this.button6SkillPoint, 0));
                button6Entries.add(new PieEntry(this.button6SkillPoint, 1));
                PieDataSet button6PieDataSet = new PieDataSet(button6Entries, "");
                button6PieDataSet.setSliceSpace(2);
                button6PieDataSet.setValueTextSize(0);
                button6PieDataSet.setColors(colors);
                PieData button6PieData = new PieData(button6PieDataSet);
                chart.setData(button6PieData);
                next.setText(getNextString(this.button6SkillLevel, 2));
                firstSkillPoint.setText(String.valueOf(button6Map.get(button6FirstKey)));
                firstSong.setText(button6FirstKey);
                firstSeries = realm.where(SongInfo.class).equalTo("title", firstSong.getText().toString()).findAll().get(0).getSeries();
                firstColor.setBackgroundColor(getColor(firstSeries));
                lastSkillPoint.setText(String.valueOf(button6Map.get(button6LastKey)));
                lastSong.setText(button6LastKey);
                lastSeries = realm.where(SongInfo.class).equalTo("title", lastSong.getText().toString()).findAll().get(0).getSeries();
                lastColor.setBackgroundColor(getColor(lastSeries));
                chart.invalidate();
                break;
            case R.id.segment3:
                key = "8B";
                segmentedControl.check(R.id.segment3);
                skillPoint.setText(getString(R.string.Skill_Point)+" : "+String.valueOf(Math.round(this.button8SkillPoint * 100f) / 100f));
                skillLevel.setText(this.button8SkillLevel);
                chart.setCenterText(String.valueOf(this.button8Percent)+"%");
                ArrayList<PieEntry> button8Entries = new ArrayList<>();
                button8Entries.add(new PieEntry(this.button8MaxSkillPoint - this.button8SkillPoint, 0));
                button8Entries.add(new PieEntry(this.button8SkillPoint, 1));
                PieDataSet button8PieDataSet = new PieDataSet(button8Entries, "");
                button8PieDataSet.setSliceSpace(2);
                button8PieDataSet.setValueTextSize(0);
                button8PieDataSet.setColors(colors);
                PieData button8PieData = new PieData(button8PieDataSet);
                chart.setData(button8PieData);
                next.setText(getNextString(this.button8SkillLevel, 3));
                firstSkillPoint.setText(String.valueOf(button8Map.get(button8FirstKey)));
                firstSong.setText(button8FirstKey);
                firstSeries = realm.where(SongInfo.class).equalTo("title", firstSong.getText().toString()).findAll().get(0).getSeries();
                firstColor.setBackgroundColor(getColor(firstSeries));
                lastSkillPoint.setText(String.valueOf(button8Map.get(button8LastKey)));
                lastSong.setText(button8LastKey);
                lastSeries = realm.where(SongInfo.class).equalTo("title", lastSong.getText().toString()).findAll().get(0).getSeries();
                lastColor.setBackgroundColor(getColor(lastSeries));
                chart.invalidate();
                break;
            default:
                break;
        }
    }

    class DescendingInteger implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1);
        }

    }

    class DescendingFloat implements Comparator<Float>{
        @Override
        public int compare(Float o1, Float o2){
            return o2.compareTo(o1);
        }
    }

    String getNextString(String string, int sender){
        int index = 0;
        String nextString = getString(R.string.Next)+" : ";
        switch(sender){
            case 0:
                for(int i=0;i<button4GradeArray.length;++i){
                    if(button4GradeArray[i].equals(string))
                        break;
                    index++;
                }
                if(index + 1 == button4GradeArray.length)
                    nextString = nextString + getString(R.string.None);
                else
                    nextString = nextString + button4GradeArray[index + 1];
                break;
            case 1:
                for(int i=0;i<button5GradeArray.length;++i){
                    if(button5GradeArray[i].equals(string))
                        break;
                    index++;
                }
                if(index + 1 == button5GradeArray.length)
                    nextString = nextString + getString(R.string.None);
                else
                    nextString = nextString + button5GradeArray[index + 1];
                break;
            case 2:
                for(int i=0;i<button6And8GradeArray.length;++i){
                    if(button6And8GradeArray[i].equals(string))
                        break;
                    index++;
                }
                if(index + 1 == button6And8GradeArray.length)
                    nextString = nextString + getString(R.string.None);
                else
                    nextString = nextString + button6And8GradeArray[index + 1];
                break;
            case 3:
                for(int i=0;i<button6And8GradeArray.length;++i){
                    if(button6And8GradeArray[i].equals(string))
                        break;
                    index++;
                }
                if(index + 1 == button6And8GradeArray.length)
                    nextString = nextString + getString(R.string.None);
                else
                    nextString = nextString + button6And8GradeArray[index + 1];
                break;
            default:
                break;
        }
        return nextString;
    }

    int getColor(String series){
        switch(series){
            case "Respect":
                return Color.rgb(240,179,44);
            case "Trilogy":
                return Color.rgb(115,139,252);
            case "Portable1":
                return Color.rgb(29,180,210);
            case "Portable2":
                return Color.rgb(252,34,43);
            case "CE":
                return Color.rgb(255,248,221);
            case "Technika1":
                return Color.rgb(238,44,189);
            default:
                return 0;
        }
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
