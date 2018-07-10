package com.respect.presto.respectu;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.text.InputType;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

import info.hoang8f.android.segmented.SegmentedGroup;


public class PerformanceFragment extends Fragment implements View.OnClickListener, RadioGroup.OnCheckedChangeListener{

    SharedPreferences sp;
    SharedPreferences.Editor editor;
    private SegmentedGroup segmentedControl;
    private RadioButton segment0;
    private RadioButton segment1;
    private RadioButton segment2;
    private RadioButton segment3;
    private int segmentation;
    private String key;
    private String titleString;
    private TextView title;
    private TextView speed;
    private TextView skillPoint;
    private TextView series;
    private TextView normalDifficulty;
    private TextView hardDifficulty;
    private TextView maximumDifficulty;
    private TextView buttonNormalRank;
    private TextView buttonHardRank;
    private TextView buttonMaximumRank;
    private TextView buttonNormalAccuracy;
    private TextView buttonHardAccuracy;
    private TextView buttonMaximumAccuracy;
    private TextView buttonNormalNote;
    private TextView buttonHardNote;
    private TextView buttonMaximumNote;
    private TextView normalColor;
    private TextView hardColor;
    private TextView maximumColor;
    private int nm4;
    private int nm5;
    private int nm6;
    private int nm8;
    private int hd4;
    private int hd5;
    private int hd6;
    private int hd8;
    private int mx4;
    private int mx5;
    private int mx6;
    private int mx8;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_performance, container, false);
    }


    @Override
    public void onStart(){
        super.onStart();
        sp = getActivity().getSharedPreferences("Record", Context.MODE_PRIVATE);
        editor=sp.edit();
        segmentedControl = getView().findViewById(R.id.segmentedControl);
        segmentation = getArguments().getInt("segment");
        title = getView().findViewById(R.id.labelPerformanceTitle);
        speed = getView().findViewById(R.id.labelPerformanceRecommendedSpeed);
        skillPoint = getView().findViewById(R.id.labelSkillPoint);
        series = getView().findViewById(R.id.labelPerformanceColor);
        normalColor=getView().findViewById(R.id.labelPerformanceNormalColor);
        hardColor = getView().findViewById(R.id.labelPerformanceHardColor);
        maximumColor = getView().findViewById(R.id.labelPerformanceMaximumColor);
        normalDifficulty=getView().findViewById(R.id.labelPerformanceNormalDifficulty);
        hardDifficulty=getView().findViewById(R.id.labelPerformanceHardDifficulty);
        maximumDifficulty=getView().findViewById(R.id.labelPerformanceMaximumDifficulty);
        buttonNormalRank = getView().findViewById(R.id.labelNormalRankButton);
        buttonHardRank = getView().findViewById(R.id.labelHardRankButton);
        buttonMaximumRank = getView().findViewById(R.id.labelMaximumRankButton);
        buttonNormalAccuracy = getView().findViewById(R.id.labelNormalAccuracyButton);
        buttonHardAccuracy = getView().findViewById(R.id.labelHardAccuracyButton);
        buttonMaximumAccuracy = getView().findViewById(R.id.labelMaximumAccuracyButton);
        buttonNormalNote = getView().findViewById(R.id.labelNormalNoteButton);
        buttonHardNote = getView().findViewById(R.id.labelHardNoteButton);
        buttonMaximumNote = getView().findViewById(R.id.labelMaximumNoteButton);
        segmentedControl.setOnCheckedChangeListener(this);

        nm4 = getArguments().getInt("nm4");
        nm5 = getArguments().getInt("nm5");
        nm6 = getArguments().getInt("nm6");
        nm8 = getArguments().getInt("nm8");
        hd4 = getArguments().getInt("hd4");
        hd5 = getArguments().getInt("hd5");
        hd6 = getArguments().getInt("hd6");
        hd8 = getArguments().getInt("hd8");
        mx4 = getArguments().getInt("mx4");
        mx5 = getArguments().getInt("mx5");
        mx6 = getArguments().getInt("mx6");
        mx8 = getArguments().getInt("mx8");
        titleString = getArguments().getString("title");
        title.setText(titleString);
        switch(getArguments().getString("series")){
            case "Portable1":
                series.setBackgroundColor(Color.rgb(29,180,210));
                normalColor.setBackgroundColor(Color.rgb(29,180,210));
                hardColor.setBackgroundColor(Color.rgb(29,180,210));
                maximumColor.setBackgroundColor(Color.rgb(29,180,210));
                break;
            case "Portable2":
                series.setBackgroundColor(Color.rgb(252,34,43));
                normalColor.setBackgroundColor(Color.rgb(252,34,43));
                hardColor.setBackgroundColor(Color.rgb(252,34,43));
                maximumColor.setBackgroundColor(Color.rgb(252,34,43));
                break;
            case "Trilogy":
                series.setBackgroundColor(Color.rgb(115,139,252));
                normalColor.setBackgroundColor(Color.rgb(115,139,252));
                hardColor.setBackgroundColor(Color.rgb(115,139,252));
                maximumColor.setBackgroundColor(Color.rgb(115,139,252));
                break;
            case "Respect":
                series.setBackgroundColor(Color.rgb(240,179,44));
                normalColor.setBackgroundColor(Color.rgb(240,179,44));
                hardColor.setBackgroundColor(Color.rgb(240,179,44));
                maximumColor.setBackgroundColor(Color.rgb(240,179,44));
                break;
            case "CE":
                series.setBackgroundColor(Color.rgb(255,248,221));
                normalColor.setBackgroundColor(Color.rgb(255,248,221));
                hardColor.setBackgroundColor(Color.rgb(255,248,221));
                maximumColor.setBackgroundColor(Color.rgb(255,248,221));
            case "Technika1":
                series.setBackgroundColor(Color.rgb(238,44,189));
                normalColor.setBackgroundColor(Color.rgb(238,44,189));
                hardColor.setBackgroundColor(Color.rgb(238,44,189));
                maximumColor.setBackgroundColor(Color.rgb(238,44,189));
                break;
        }
        speed.setText(getArguments().getString("bpm"));
        switch(segmentation){
            case 0:
                key="4B";
                segmentedControl.check(R.id.segment0);
                break;
            case 1:
                key="5B";
                segmentedControl.check(R.id.segment1);
                break;
            case 2:
                key="6B";
                segmentedControl.check(R.id.segment2);
                break;
            case 3:
                key="8B";
                segmentedControl.check(R.id.segment3);
                break;
        }
        buttonSetting();

    }
    @Override
    public void onStop(){
        getActivity().findViewById(R.id.listSong).setEnabled(true);
        super.onStop();
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.labelNormalRankButton:
                showRankAlert("Normal");
                break;
            case R.id.labelNormalAccuracyButton:
                showAccuracyAlert("Normal");
                break;
            case R.id.labelNormalNoteButton:
                showNoteAlert("Normal");
                break;
            case R.id.labelHardRankButton:
                showRankAlert("Hard");
                break;
            case R.id.labelHardAccuracyButton:
                showAccuracyAlert("Hard");
                break;
            case R.id.labelHardNoteButton:
                showNoteAlert("Hard");
                break;
            case R.id.labelMaximumRankButton:
                showRankAlert("Maximum");
                break;
            case R.id.labelMaximumAccuracyButton:
                showAccuracyAlert("Maximum");
                break;
            case R.id.labelMaximumNoteButton:
                showNoteAlert("Maximum");
                break;
        }
    }

    void showRankAlert(final String difficulty){
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle(getString(R.string.Rank));
        builder.setItems(new CharSequence[]{
                "-", "S", "A", "B", "C", getContext().getString(R.string.Cancel)
        }, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                switch(i){
                    case 0:
                        setRank("-", difficulty);
                        break;
                    case 1:
                        setRank("S", difficulty);
                        showAccuracyAlert(difficulty);
                        break;
                    case 2:
                        setRank("A", difficulty);
                        showAccuracyAlert(difficulty);
                        break;
                    case 3:
                        setRank("B", difficulty);
                        showAccuracyAlert(difficulty);
                        break;
                    case 4:
                        setRank("C", difficulty);
                        showAccuracyAlert(difficulty);
                        break;
                }
            }
        });
        builder.create().show();
    }
    void showAccuracyAlert(final String difficulty){
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle(R.string.Accuracy);
        builder.setMessage("ex) 99.82% -> Input '99.82'");
        final EditText editText = new EditText(getActivity());
        editText.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        builder.setView(editText);
        builder.setPositiveButton(R.string.OK, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if(editText.getText().toString().equals(""))
                    setAccuracy(null, difficulty);
                else{
                    float valueFloat = Float.parseFloat(editText.getText().toString());
                    if(valueFloat>=100)
                        valueFloat=100;
                    String value = String.format("%05.2f%%", valueFloat);
                    setAccuracy(value, difficulty);
                    if(valueFloat >= 98 && valueFloat <= 100)
                        setRank("S",difficulty);
                    else if(valueFloat >= 95 && valueFloat < 98)
                        setRank("A",difficulty);
                    else if(valueFloat >= 90 && valueFloat < 95)
                        setRank("B",difficulty);
                    else
                        setRank("C",difficulty);
                }
            }
        });
        builder.setNegativeButton(R.string.Cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.create().show();
    }
    void showNoteAlert(final String difficulty){
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle(R.string.Note);
        builder.setItems(new CharSequence[]{
                "-", "MAX COMBO", "PERFECT PLAY", getContext().getString(R.string.Cancel)
        }, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                switch(i){
                    case 0:
                        setNote("-", difficulty);
                        break;
                    case 1:
                        setNote("MAX COMBO", difficulty);
                        break;
                    case 2:
                        setRank("S",difficulty);
                        setAccuracy("100.00%",difficulty);
                        setNote("PERFECT PLAY", difficulty);
                        break;
                }
            }
        });
        builder.create().show();
    }

    void setRank(String rank, String difficulty){
        switch(segmentation){
            case 0:
                editor.putString(titleString + "4B" + difficulty + "Rank", rank);
                break;
            case 1:
                editor.putString(titleString + "5B" + difficulty + "Rank", rank);
                break;
            case 2:
                editor.putString(titleString + "6B" + difficulty + "Rank", rank);
                break;
            case 3:
                editor.putString(titleString + "8B" + difficulty + "Rank", rank);
                break;
        }
        editor.commit();
        buttonSetting();
    }
    void setAccuracy(String accuracy, String difficulty){
        switch(segmentation){
            case 0:
                editor.putString(titleString + "4B" + difficulty + "Accuracy", accuracy);
                editor.commit();
                float nm4Point = getSkillPoint(nm4, sp.getString(titleString+"4BNormalAccuracy", ""), sp.getString(titleString+"4BNormalNote", ""));
                float hd4Point = getSkillPoint(hd4, sp.getString(titleString+"4BHardAccuracy", ""), sp.getString(titleString+"4BHardNote", ""));
                float mx4Point = getSkillPoint(mx4, sp.getString(titleString+"4BMaximumAccuracy", ""), sp.getString(titleString+"4BMaximumNote", ""));
                float[] max4PointArray = {nm4Point, hd4Point, mx4Point};
                Arrays.sort(max4PointArray);
                float max4Point = max4PointArray[2];
                editor.putFloat(titleString+"4BSkillPoint", max4Point);
                editor.commit();
                if(max4Point == nm4Point){
                    editor.putString(titleString+"4BHighestDifficulty", "NORMAL");
                    editor.putString(titleString+"4BHighestRate", sp.getString(titleString+"4BNormalAccuracy", "-"));
                    editor.putString(titleString+"4BHighestNote", sp.getString(titleString+"4BNormalNote", "-"));
                }
                else if(max4Point == hd4Point){
                    editor.putString(titleString+"4BHighestDifficulty", "HARD");
                    editor.putString(titleString+"4BHighestRate", sp.getString(titleString+"4BHardAccuracy", "-"));
                    editor.putString(titleString+"4BHighestNote", sp.getString(titleString+"4BHardNote", "-"));

                }
                else if(max4Point == mx4Point){
                    editor.putString(titleString+"4BHighestDifficulty", "MAXIMUM");
                    editor.putString(titleString+"4BHighestRate", sp.getString(titleString+"4BMaximumAccuracy", "-"));
                    editor.putString(titleString+"4BHighestNote", sp.getString(titleString+"4BMaximumNote", "-"));
                }
                editor.commit();
                showSkillPoint(0);
                break;
            case 1:
                editor.putString(titleString + "5B" + difficulty + "Accuracy", accuracy);
                editor.commit();
                float nm5Point = getSkillPoint(nm5, sp.getString(titleString+"5BNormalAccuracy", ""), sp.getString(titleString+"5BNormalNote", ""));
                float hd5Point = getSkillPoint(hd5, sp.getString(titleString+"5BHardAccuracy", ""), sp.getString(titleString+"5BHardNote", ""));
                float mx5Point = getSkillPoint(mx5, sp.getString(titleString+"5BMaximumAccuracy", ""), sp.getString(titleString+"5BMaximumNote", ""));
                float[] max5PointArray = {nm5Point, hd5Point, mx5Point};
                Arrays.sort(max5PointArray);
                float max5Point = max5PointArray[2];
                editor.putFloat(titleString+"5BSkillPoint", max5Point);
                editor.commit();
                if(max5Point == nm5Point){
                    editor.putString(titleString+"5BHighestDifficulty", "NORMAL");
                    editor.putString(titleString+"5BHighestRate", sp.getString(titleString+"5BNormalAccuracy", "-"));
                    editor.putString(titleString+"5BHighestNote", sp.getString(titleString+"5BNormalNote", "-"));
                }
                else if(max5Point == hd5Point){
                    editor.putString(titleString+"5BHighestDifficulty", "HARD");
                    editor.putString(titleString+"5BHighestRate", sp.getString(titleString+"5BHardAccuracy", "-"));
                    editor.putString(titleString+"5BHighestNote", sp.getString(titleString+"5BHardNote", "-"));

                }
                else if(max5Point == mx5Point){
                    editor.putString(titleString+"5BHighestDifficulty", "MAXIMUM");
                    editor.putString(titleString+"5BHighestRate", sp.getString(titleString+"5BMaximumAccuracy", "-"));
                    editor.putString(titleString+"5BHighestNote", sp.getString(titleString+"5BMaximumNote", "-"));
                }
                editor.commit();
                showSkillPoint(1);
                break;
            case 2:
                editor.putString(titleString + "6B" + difficulty + "Accuracy", accuracy);
                editor.commit();
                float nm6Point = getSkillPoint(nm6, sp.getString(titleString+"6BNormalAccuracy", ""), sp.getString(titleString+"6BNormalNote", ""));
                float hd6Point = getSkillPoint(hd6, sp.getString(titleString+"6BHardAccuracy", ""), sp.getString(titleString+"6BHardNote", ""));
                float mx6Point = getSkillPoint(mx6, sp.getString(titleString+"6BMaximumAccuracy", ""), sp.getString(titleString+"6BMaximumNote", ""));
                float[] max6PointArray = {nm6Point, hd6Point, mx6Point};
                Arrays.sort(max6PointArray);
                float max6Point = max6PointArray[2];
                editor.putFloat(titleString+"6BSkillPoint", max6Point);
                editor.commit();
                if(max6Point == nm6Point){
                    editor.putString(titleString+"6BHighestDifficulty", "NORMAL");
                    editor.putString(titleString+"6BHighestRate", sp.getString(titleString+"6BNormalAccuracy", "-"));
                    editor.putString(titleString+"6BHighestNote", sp.getString(titleString+"6BNormalNote", "-"));
                }
                else if(max6Point == hd6Point){
                    editor.putString(titleString+"6BHighestDifficulty", "HARD");
                    editor.putString(titleString+"6BHighestRate", sp.getString(titleString+"6BHardAccuracy", "-"));
                    editor.putString(titleString+"6BHighestNote", sp.getString(titleString+"6BHardNote", "-"));

                }
                else if(max6Point == mx6Point){
                    editor.putString(titleString+"6BHighestDifficulty", "MAXIMUM");
                    editor.putString(titleString+"6BHighestRate", sp.getString(titleString+"6BMaximumAccuracy", "-"));
                    editor.putString(titleString+"6BHighestNote", sp.getString(titleString+"6BMaximumNote", "-"));
                }
                editor.commit();
                showSkillPoint(2);
                break;
            case 3:
                editor.putString(titleString + "8B" + difficulty + "Accuracy", accuracy);
                editor.commit();
                float nm8Point = getSkillPoint(nm8, sp.getString(titleString+"8BNormalAccuracy", ""), sp.getString(titleString+"8BNormalNote", ""));
                float hd8Point = getSkillPoint(hd8, sp.getString(titleString+"8BHardAccuracy", ""), sp.getString(titleString+"8BHardNote", ""));
                float mx8Point = getSkillPoint(mx8, sp.getString(titleString+"8BMaximumAccuracy", ""), sp.getString(titleString+"8BMaximumNote", ""));
                float[] max8PointArray = {nm8Point, hd8Point, mx8Point};
                Arrays.sort(max8PointArray);
                float max8Point = max8PointArray[2];
                editor.putFloat(titleString+"8BSkillPoint", max8Point);
                editor.commit();
                if(max8Point == nm8Point){
                    editor.putString(titleString+"8BHighestDifficulty", "NORMAL");
                    editor.putString(titleString+"8BHighestRate", sp.getString(titleString+"8BNormalAccuracy", "-"));
                    editor.putString(titleString+"8BHighestNote", sp.getString(titleString+"8BNormalNote", "-"));
                }
                else if(max8Point == hd8Point){
                    editor.putString(titleString+"8BHighestDifficulty", "HARD");
                    editor.putString(titleString+"8BHighestRate", sp.getString(titleString+"8BHardAccuracy", "-"));
                    editor.putString(titleString+"8BHighestNote", sp.getString(titleString+"8BHardNote", "-"));

                }
                else if(max8Point == mx8Point){
                    editor.putString(titleString+"8BHighestDifficulty", "MAXIMUM");
                    editor.putString(titleString+"8BHighestRate", sp.getString(titleString+"8BMaximumAccuracy", "-"));
                    editor.putString(titleString+"8BHighestNote", sp.getString(titleString+"8BMaximumNote", "-"));
                }
                editor.commit();
                showSkillPoint(3);
                break;
        }
        buttonSetting();
    }
    void setNote(String note, String difficulty){
        switch(segmentation){
            case 0:
                editor.putString(titleString + "4B" + difficulty + "Note", note);
                editor.commit();
                float nm4Point = getSkillPoint(nm4, sp.getString(titleString+"4BNormalAccuracy", ""), sp.getString(titleString+"4BNormalNote", ""));
                float hd4Point = getSkillPoint(hd4, sp.getString(titleString+"4BHardAccuracy", ""), sp.getString(titleString+"4BHardNote", ""));
                float mx4Point = getSkillPoint(mx4, sp.getString(titleString+"4BMaximumAccuracy", ""), sp.getString(titleString+"4BMaximumNote", ""));
                float[] max4PointArray = {nm4Point, hd4Point, mx4Point};
                Arrays.sort(max4PointArray);
                float max4Point = max4PointArray[2];
                editor.putFloat(titleString+"4BSkillPoint", max4Point);
                editor.commit();
                if(max4Point == nm4Point){
                    editor.putString(titleString+"4BHighestDifficulty", "NORMAL");
                    editor.putString(titleString+"4BHighestRate", sp.getString(titleString+"4BNormalAccuracy", "-"));
                    editor.putString(titleString+"4BHighestNote", sp.getString(titleString+"4BNormalNote", "-"));
                }
                else if(max4Point == hd4Point){
                    editor.putString(titleString+"4BHighestDifficulty", "HARD");
                    editor.putString(titleString+"4BHighestRate", sp.getString(titleString+"4BHardAccuracy", "-"));
                    editor.putString(titleString+"4BHighestNote", sp.getString(titleString+"4BHardNote", "-"));

                }
                else if(max4Point == mx4Point){
                    editor.putString(titleString+"4BHighestDifficulty", "MAXIMUM");
                    editor.putString(titleString+"4BHighestRate", sp.getString(titleString+"4BMaximumAccuracy", "-"));
                    editor.putString(titleString+"4BHighestNote", sp.getString(titleString+"4BMaximumNote", "-"));
                }
                editor.commit();
                showSkillPoint(0);
                break;
            case 1:
                editor.putString(titleString + "5B" + difficulty + "Note", note);
                editor.commit();
                float nm5Point = getSkillPoint(nm5, sp.getString(titleString+"5BNormalAccuracy", ""), sp.getString(titleString+"5BNormalNote", ""));
                float hd5Point = getSkillPoint(hd5, sp.getString(titleString+"5BHardAccuracy", ""), sp.getString(titleString+"5BHardNote", ""));
                float mx5Point = getSkillPoint(mx5, sp.getString(titleString+"5BMaximumAccuracy", ""), sp.getString(titleString+"5BMaximumNote", ""));
                float[] max5PointArray = {nm5Point, hd5Point, mx5Point};
                Arrays.sort(max5PointArray);
                float max5Point = max5PointArray[2];
                editor.putFloat(titleString+"5BSkillPoint", max5Point);
                editor.commit();
                if(max5Point == nm5Point){
                    editor.putString(titleString+"5BHighestDifficulty", "NORMAL");
                    editor.putString(titleString+"5BHighestRate", sp.getString(titleString+"5BNormalAccuracy", "-"));
                    editor.putString(titleString+"5BHighestNote", sp.getString(titleString+"5BNormalNote", "-"));
                }
                else if(max5Point == hd5Point){
                    editor.putString(titleString+"5BHighestDifficulty", "HARD");
                    editor.putString(titleString+"5BHighestRate", sp.getString(titleString+"5BHardAccuracy", "-"));
                    editor.putString(titleString+"5BHighestNote", sp.getString(titleString+"5BHardNote", "-"));

                }
                else if(max5Point == mx5Point){
                    editor.putString(titleString+"5BHighestDifficulty", "MAXIMUM");
                    editor.putString(titleString+"5BHighestRate", sp.getString(titleString+"5BMaximumAccuracy", "-"));
                    editor.putString(titleString+"5BHighestNote", sp.getString(titleString+"5BMaximumNote", "-"));
                }
                editor.commit();
                showSkillPoint(1);
                break;
            case 2:
                editor.putString(titleString + "6B" + difficulty + "Note", note);
                editor.commit();
                float nm6Point = getSkillPoint(nm6, sp.getString(titleString+"6BNormalAccuracy", ""), sp.getString(titleString+"6BNormalNote", ""));
                float hd6Point = getSkillPoint(hd6, sp.getString(titleString+"6BHardAccuracy", ""), sp.getString(titleString+"6BHardNote", ""));
                float mx6Point = getSkillPoint(mx6, sp.getString(titleString+"6BMaximumAccuracy", ""), sp.getString(titleString+"6BMaximumNote", ""));
                float[] max6PointArray = {nm6Point, hd6Point, mx6Point};
                Arrays.sort(max6PointArray);
                float max6Point = max6PointArray[2];
                editor.putFloat(titleString+"6BSkillPoint", max6Point);
                editor.commit();
                if(max6Point == nm6Point){
                    editor.putString(titleString+"6BHighestDifficulty", "NORMAL");
                    editor.putString(titleString+"6BHighestRate", sp.getString(titleString+"6BNormalAccuracy", "-"));
                    editor.putString(titleString+"6BHighestNote", sp.getString(titleString+"6BNormalNote", "-"));
                }
                else if(max6Point == hd6Point){
                    editor.putString(titleString+"6BHighestDifficulty", "HARD");
                    editor.putString(titleString+"6BHighestRate", sp.getString(titleString+"6BHardAccuracy", "-"));
                    editor.putString(titleString+"6BHighestNote", sp.getString(titleString+"6BHardNote", "-"));

                }
                else if(max6Point == mx6Point){
                    editor.putString(titleString+"6BHighestDifficulty", "MAXIMUM");
                    editor.putString(titleString+"6BHighestRate", sp.getString(titleString+"6BMaximumAccuracy", "-"));
                    editor.putString(titleString+"6BHighestNote", sp.getString(titleString+"6BMaximumNote", "-"));
                }
                editor.commit();
                showSkillPoint(2);
                break;
            case 3:
                editor.putString(titleString + "8B" + difficulty + "Note", note);
                editor.commit();
                float nm8Point = getSkillPoint(nm8, sp.getString(titleString+"8BNormalAccuracy", ""), sp.getString(titleString+"8BNormalNote", ""));
                float hd8Point = getSkillPoint(hd8, sp.getString(titleString+"8BHardAccuracy", ""), sp.getString(titleString+"8BHardNote", ""));
                float mx8Point = getSkillPoint(mx8, sp.getString(titleString+"8BMaximumAccuracy", ""), sp.getString(titleString+"8BMaximumNote", ""));
                float[] max8PointArray = {nm8Point, hd8Point, mx8Point};
                Arrays.sort(max8PointArray);
                float max8Point = max8PointArray[2];
                editor.putFloat(titleString+"8BSkillPoint", max8Point);
                editor.commit();
                if(max8Point == nm8Point){
                    editor.putString(titleString+"8BHighestDifficulty", "NORMAL");
                    editor.putString(titleString+"8BHighestRate", sp.getString(titleString+"8BNormalAccuracy", "-"));
                    editor.putString(titleString+"8BHighestNote", sp.getString(titleString+"8BNormalNote", "-"));
                }
                else if(max8Point == hd8Point){
                    editor.putString(titleString+"8BHighestDifficulty", "HARD");
                    editor.putString(titleString+"8BHighestRate", sp.getString(titleString+"8BHardAccuracy", "-"));
                    editor.putString(titleString+"8BHighestNote", sp.getString(titleString+"8BHardNote", "-"));

                }
                else if(max8Point == mx8Point){
                    editor.putString(titleString+"8BHighestDifficulty", "MAXIMUM");
                    editor.putString(titleString+"8BHighestRate", sp.getString(titleString+"8BMaximumAccuracy", "-"));
                    editor.putString(titleString+"8BHighestNote", sp.getString(titleString+"8BMaximumNote", "-"));
                }
                editor.commit();
                showSkillPoint(3);
                break;
        }
        editor.commit();
        buttonSetting();

    }
    String difficultyToChar(int value){
        String result="";
        if(value >= 1 && value <= 5){
            for(int i=1;i<=value;++i)
                result+="★";
        }
        else if(value >= 6 && value <= 10){
            result="☆☆☆☆☆";
            for(int i=6;i<=value;++i)
                result+="★";
        }
        else if(value >= 11 && value <= 15){
            result = "☆☆☆☆☆☆☆☆☆☆";
            for(int i=11;i<=value;++i){
                result+="★";
            }
        }
        return result;
    }

    void buttonSetting(){
        buttonNormalRank.setOnClickListener(this);
        buttonNormalAccuracy.setOnClickListener(this);
        buttonNormalNote.setOnClickListener(this);
        buttonHardRank.setOnClickListener(this);
        buttonHardAccuracy.setOnClickListener(this);
        buttonHardNote.setOnClickListener(this);
        buttonMaximumRank.setOnClickListener(this);
        buttonMaximumAccuracy.setOnClickListener(this);
        buttonMaximumNote.setOnClickListener(this);
        buttonNormalRank.setText(sp.getString(titleString + key + "NormalRank", "-"));
        buttonNormalAccuracy.setText(sp.getString(titleString + key + "NormalAccuracy", "-"));
        buttonNormalNote.setText(sp.getString(titleString + key + "NormalNote", "-"));
        buttonHardRank.setText(sp.getString(titleString + key + "HardRank", "-"));
        buttonHardAccuracy.setText(sp.getString(titleString + key + "HardAccuracy", "-"));
        buttonHardNote.setText(sp.getString(titleString + key + "HardNote", "-"));
        buttonMaximumRank.setText(sp.getString(titleString + key + "MaximumRank", "-"));
        buttonMaximumAccuracy.setText(sp.getString(titleString + key + "MaximumAccuracy", "-"));
        buttonMaximumNote.setText(sp.getString(titleString + key + "MaximumNote", "-"));
        switch(segmentation){
            case 0:
                showSkillPoint(0);
                normalDifficulty.setText(difficultyToChar(nm4));
                hardDifficulty.setText(difficultyToChar(hd4));
                maximumDifficulty.setText(difficultyToChar(mx4));
                if(nm4 == 0){
                    buttonNormalRank.setText("No Pattern");
                    buttonNormalAccuracy.setText("No Pattern");
                    buttonNormalNote.setText("No Pattern");
                    normalDifficulty.setText("");
                    buttonNormalRank.setOnClickListener(null);
                    buttonNormalAccuracy.setOnClickListener(null);
                    buttonNormalNote.setOnClickListener(null);

                }
                if(hd4 == 0){
                    buttonHardRank.setText("No Pattern");
                    buttonHardAccuracy.setText("No Pattern");
                    buttonHardNote.setText("No Pattern");
                    hardDifficulty.setText("");
                    buttonHardRank.setOnClickListener(null);
                    buttonHardAccuracy.setOnClickListener(null);
                    buttonHardNote.setOnClickListener(null);
                }
                if(mx4 == 0){
                    buttonMaximumRank.setText("No Pattern");
                    buttonMaximumAccuracy.setText("No Pattern");
                    buttonMaximumNote.setText("No Pattern");
                    maximumDifficulty.setText("");
                    buttonMaximumRank.setOnClickListener(null);
                    buttonMaximumAccuracy.setOnClickListener(null);
                    buttonMaximumNote.setOnClickListener(null);
                }
                break;
            case 1:
                showSkillPoint(1);
                normalDifficulty.setText(difficultyToChar(nm5));
                hardDifficulty.setText(difficultyToChar(hd5));
                maximumDifficulty.setText(difficultyToChar(mx5));
                if(nm5 == 0){
                    buttonNormalRank.setText("No Pattern");
                    buttonNormalAccuracy.setText("No Pattern");
                    buttonNormalNote.setText("No Pattern");
                    normalDifficulty.setText("");
                    buttonNormalRank.setOnClickListener(null);
                    buttonNormalAccuracy.setOnClickListener(null);
                    buttonNormalNote.setOnClickListener(null);

                }
                if(hd5 == 0){
                    buttonHardRank.setText("No Pattern");
                    buttonHardAccuracy.setText("No Pattern");
                    buttonHardNote.setText("No Pattern");
                    hardDifficulty.setText("");
                    buttonHardRank.setOnClickListener(null);
                    buttonHardAccuracy.setOnClickListener(null);
                    buttonHardNote.setOnClickListener(null);
                }
                if(mx5 == 0){
                    buttonMaximumRank.setText("No Pattern");
                    buttonMaximumAccuracy.setText("No Pattern");
                    buttonMaximumNote.setText("No Pattern");
                    maximumDifficulty.setText("");
                    buttonMaximumRank.setOnClickListener(null);
                    buttonMaximumAccuracy.setOnClickListener(null);
                    buttonMaximumNote.setOnClickListener(null);
                }
                break;
            case 2:
                showSkillPoint(2);
                normalDifficulty.setText(difficultyToChar(nm6));
                hardDifficulty.setText(difficultyToChar(hd6));
                maximumDifficulty.setText(difficultyToChar(mx6));
                if(nm6 == 0){
                    buttonNormalRank.setText("No Pattern");
                    buttonNormalAccuracy.setText("No Pattern");
                    buttonNormalNote.setText("No Pattern");
                    normalDifficulty.setText("");
                    buttonNormalRank.setOnClickListener(null);
                    buttonNormalAccuracy.setOnClickListener(null);
                    buttonNormalNote.setOnClickListener(null);

                }
                if(hd6 == 0){
                    buttonHardRank.setText("No Pattern");
                    buttonHardAccuracy.setText("No Pattern");
                    buttonHardNote.setText("No Pattern");
                    hardDifficulty.setText("");
                    buttonHardRank.setOnClickListener(null);
                    buttonHardAccuracy.setOnClickListener(null);
                    buttonHardNote.setOnClickListener(null);
                }
                if(mx6 == 0){
                    buttonMaximumRank.setText("No Pattern");
                    buttonMaximumAccuracy.setText("No Pattern");
                    buttonMaximumNote.setText("No Pattern");
                    maximumDifficulty.setText("");
                    buttonMaximumRank.setOnClickListener(null);
                    buttonMaximumAccuracy.setOnClickListener(null);
                    buttonMaximumNote.setOnClickListener(null);
                }
                break;
            case 3:
                showSkillPoint(3);
                normalDifficulty.setText(difficultyToChar(nm8));
                hardDifficulty.setText(difficultyToChar(hd8));
                maximumDifficulty.setText(difficultyToChar(mx8));
                if(nm8 == 0){
                    buttonNormalRank.setText("No Pattern");
                    buttonNormalAccuracy.setText("No Pattern");
                    buttonNormalNote.setText("No Pattern");
                    normalDifficulty.setText("");
                    buttonNormalRank.setOnClickListener(null);
                    buttonNormalAccuracy.setOnClickListener(null);
                    buttonNormalNote.setOnClickListener(null);
                }
                if(hd8 == 0){
                    buttonHardRank.setText("No Pattern");
                    buttonHardAccuracy.setText("No Pattern");
                    buttonHardNote.setText("No Pattern");
                    hardDifficulty.setText("");
                    buttonHardRank.setOnClickListener(null);
                    buttonHardAccuracy.setOnClickListener(null);
                    buttonHardNote.setOnClickListener(null);
                }
                if(mx8 == 0){
                    buttonMaximumRank.setText("No Pattern");
                    buttonMaximumAccuracy.setText("No Pattern");
                    buttonMaximumNote.setText("No Pattern");
                    maximumDifficulty.setText("");
                    buttonMaximumRank.setOnClickListener(null);
                    buttonMaximumAccuracy.setOnClickListener(null);
                    buttonMaximumNote.setOnClickListener(null);
                }
                break;
        }
    }

    void showSkillPoint(int sender){
        switch(sender){
            case 0:
                skillPoint.setText(getString(R.string.Skill_Point)+" : "+String.valueOf(sp.getFloat(titleString+"4BSkillPoint", 0)));
                break;
            case 1:
                skillPoint.setText(getString(R.string.Skill_Point)+" : "+String.valueOf(sp.getFloat(titleString+"5BSkillPoint", 0)));
                break;
            case 2:
                skillPoint.setText(getString(R.string.Skill_Point)+" : "+String.valueOf(sp.getFloat(titleString+"6BSkillPoint", 0)));
                break;
            case 3:
                skillPoint.setText(getString(R.string.Skill_Point)+" : "+String.valueOf(sp.getFloat(titleString+"8BSkillPoint", 0)));
                break;
            default:
                break;
        }
    }

    float getSkillPoint(int difficulty, String rate, String note){
        if(difficulty == 0)
            return 0;
        float skillPoint = 0;
        final float e = 2.71828f;
        String rateString = rate.split("%")[0];
        float accuracy = 0;
        try{
            accuracy = Float.parseFloat(rateString);
        } catch (Exception a){
            accuracy = 0;
        }
        float weight = getWeight(difficulty);
        if(accuracy >= 80){
            float temp = (float)Math.pow((accuracy - 80) / 20, e) + 1;
            skillPoint = weight * 50 * temp;
        }
        else{
            skillPoint = weight * accuracy * 5 / 8;
        }
        if(note.equals("-") || note.equals(""))
            skillPoint = skillPoint * 0.98f;
        else if(note.equals("PERFECT PLAY"))
            skillPoint = skillPoint * 1.05f;
        skillPoint = Math.round(skillPoint * 100f) / 100f;
        return skillPoint;
    }

    float getWeight(int value){
        float result = 0f;
        switch(value){
            case 1:
                result = 0.4f;
                break;
            case 2:
                result = 0.6f;
                break;
            case 3:
                result = 0.8f;
                break;
            case 4:
                result = 1f;
                break;
            case 5:
                result = 1.14f;
                break;
            case 6:
                result = 1.24f;
                break;
            case 7:
                result = 1.33f;
                break;
            case 8:
                result = 1.42f;
                break;
            case 9:
                result = 1.53f;
                break;
            case 10:
                result = 1.6f;
                break;
            case 11:
                result = 1.68f;
                break;
            case 12:
                result = 1.77f;
                break;
            case 13:
                result = 1.85f;
                break;
            case 14:
                result = 1.94f;
                break;
            case 15:
                result = 2f;
                break;
            default:
                break;
        }
        return result;
    }


    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch(i){
            case R.id.segment0:
                segmentation = 0;
                key = "4B";
                segmentedControl.check(R.id.segment0);
                buttonSetting();
                break;
            case R.id.segment1:
                segmentation = 1;
                key = "5B";
                segmentedControl.check(R.id.segment1);
                buttonSetting();
                break;
            case R.id.segment2:
                segmentation = 2;
                key = "6B";
                segmentedControl.check(R.id.segment2);
                buttonSetting();
                break;
            case R.id.segment3:
                segmentation = 3;
                key = "8B";
                segmentedControl.check(R.id.segment3);
                buttonSetting();
                break;
            default:
                break;
        }
    }
}
