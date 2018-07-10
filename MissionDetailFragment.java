package com.respect.presto.respectu;

import android.app.FragmentManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.respect.presto.respectu.R;

import io.realm.Realm;
import io.realm.RealmResults;


public class MissionDetailFragment extends Fragment implements View.OnClickListener{

    private Realm realm;
    private RealmResults<SongInfo> results;
    private TextView title;
    private TextView scoreLimit;
    private TextView feverLimit;
    private TextView comboLimit;
    private TextView rateLimit;
    private TextView breakLimit;
    private TextView song1key;
    private TextView song2key;
    private TextView song3key;
    private TextView song4key;
    private TextView song5key;
    private TextView song6key;
    private TextView song1level;
    private TextView song2level;
    private TextView song3level;
    private TextView song4level;
    private TextView song5level;
    private TextView song6level;
    private TextView song1title;
    private TextView song2title;
    private TextView song3title;
    private TextView song4title;
    private TextView song5title;
    private TextView song6title;
    private TextView song1button;
    private TextView song2button;
    private TextView song3button;
    private TextView song4button;
    private TextView song5button;
    private TextView song6button;
    private TextView more;
    private TextView reward;

    private String song1difficulty;
    private String song2difficulty;
    private String song3difficulty;
    private String song4difficulty;
    private String song5difficulty;
    private String song6difficulty;
    private String song1bpm;
    private String song2bpm;
    private String song3bpm;
    private String song4bpm;
    private String song5bpm;
    private String song6bpm;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mission_detail, container, false);
    }

    @Override
    public void onStop(){
        getActivity().findViewById(R.id.listMission).setEnabled(true);
        super.onStop();
    }
    @Override
    public void onStart(){
        super.onStart();
        setHasOptionsMenu(true);

        realm=Realm.getDefaultInstance();

        title=(TextView)getView().findViewById(R.id.labelTitle);
        scoreLimit=(TextView)getView().findViewById(R.id.labelScoreLimit);
        feverLimit=(TextView)getView().findViewById(R.id.labelFeverLimit);
        comboLimit=(TextView)getView().findViewById(R.id.labelComboLimit);
        rateLimit=(TextView)getView().findViewById(R.id.labelRateLimit);
        breakLimit=(TextView)getView().findViewById(R.id.labelBreakLimit);
        song1key=(TextView)getView().findViewById(R.id.labelSong1key);
        song2key=(TextView)getView().findViewById(R.id.labelSong2key);
        song3key=(TextView)getView().findViewById(R.id.labelSong3key);
        song4key=(TextView)getView().findViewById(R.id.labelSong4key);
        song5key=(TextView)getView().findViewById(R.id.labelSong5key);
        song6key=(TextView)getView().findViewById(R.id.labelSong6key);
        song1level=(TextView)getView().findViewById(R.id.labelSong1level);
        song2level=(TextView)getView().findViewById(R.id.labelSong2level);
        song3level=(TextView)getView().findViewById(R.id.labelSong3level);
        song4level=(TextView)getView().findViewById(R.id.labelSong4level);
        song5level=(TextView)getView().findViewById(R.id.labelSong5level);
        song6level=(TextView)getView().findViewById(R.id.labelSong6level);
        song1title=(TextView)getView().findViewById(R.id.labelSong1title);
        song2title=(TextView)getView().findViewById(R.id.labelSong2title);
        song3title=(TextView)getView().findViewById(R.id.labelSong3title);
        song4title=(TextView)getView().findViewById(R.id.labelSong4title);
        song5title=(TextView)getView().findViewById(R.id.labelSong5title);
        song6title=(TextView)getView().findViewById(R.id.labelSong6title);
        song1button=(TextView)getView().findViewById(R.id.labelSong1button);
        song2button=(TextView)getView().findViewById(R.id.labelSong2button);
        song3button=(TextView)getView().findViewById(R.id.labelSong3button);
        song4button=(TextView)getView().findViewById(R.id.labelSong4button);
        song5button=(TextView)getView().findViewById(R.id.labelSong5button);
        song6button=(TextView)getView().findViewById(R.id.labelSong6button);
        more=(TextView)getView().findViewById(R.id.labelEffector);
        reward=(TextView)getView().findViewById(R.id.labelReward);

        song1button.setOnClickListener(this);
        song2button.setOnClickListener(this);
        song3button.setOnClickListener(this);
        song4button.setOnClickListener(this);
        song5button.setOnClickListener(this);
        song6button.setOnClickListener(this);

        title.setText(getArguments().getString("title"));
        scoreLimit.setText(getArguments().getInt("scoreLimit")==0 ? "-" : String.valueOf(getArguments().getInt("scoreLimit")));
        feverLimit.setText(getArguments().getInt("feverLimit")==0 ? "-" : "X"+getArguments().getInt("feverLimit"));
        comboLimit.setText(getArguments().getInt("comboLimit")==0 ? "-" : String.valueOf(getArguments().getInt("comboLimit")));
        rateLimit.setText(getArguments().getInt("rateLimit")==0 ? "-" : getArguments().getInt("rateLimit")+"%");
        breakLimit.setText(getArguments().getInt("breakLimit")==0 ? "-" : String.valueOf(getArguments().getInt("breakLimit")));
        song1key.setText(getArguments().getString("song1key"));
        song2key.setText(getArguments().getString("song2key"));
        song3key.setText(getArguments().getString("song3key"));
        song4key.setText(getArguments().getString("song4key"));
        song5key.setText(getArguments().getString("song5key"));
        song6key.setText(getArguments().getString("song6key"));
        song1level.setText(getArguments().getString("song1level"));
        song2level.setText(getArguments().getString("song2level"));
        song3level.setText(getArguments().getString("song3level"));
        song4level.setText(getArguments().getString("song4level"));
        song5level.setText(getArguments().getString("song5level"));
        song6level.setText(getArguments().getString("song6level"));
        song1title.setText(getArguments().getString("song1title"));
        song2title.setText(getArguments().getString("song2title"));
        song3title.setText(getArguments().getString("song3title"));
        song4title.setText(getArguments().getString("song4title"));
        song5title.setText(getArguments().getString("song5title"));
        song6title.setText(getArguments().getString("song6title"));
        more.setText(getArguments().getString("more"));
        reward.setText(getArguments().getString("reward").equals("") ? "None" : getArguments().getString("reward"));

        if(!song1title.getText().toString().equals("") && !song1title.getText().toString().equals("RANDOM")){
            song1button.setVisibility(View.VISIBLE);
            results=realm.where(SongInfo.class).equalTo("title",song1title.getText().toString()).findAll();
            song1bpm=results.get(0).getBpm();
            if(song1key.getText().toString().equals("4B")){
                if(song1level.getText().toString().equals("NORMAL"))
                    song1difficulty=String.valueOf(results.get(0).getNm4());
                else if(song1level.getText().toString().equals("HARD"))
                    song1difficulty=String.valueOf(results.get(0).getHd4());
                else if(song1level.getText().toString().equals("MAXIMUM"))
                    song1difficulty=String.valueOf(results.get(0).getMx4());
            }
            else if(song1key.getText().toString().equals("5B")){
                if(song1level.getText().toString().equals("NORMAL"))
                    song1difficulty=String.valueOf(results.get(0).getNm5());
                else if(song1level.getText().toString().equals("HARD"))
                    song1difficulty=String.valueOf(results.get(0).getHd5());
                else if(song1level.getText().toString().equals("MAXIMUM"))
                    song1difficulty=String.valueOf(results.get(0).getMx5());
            }
            else if(song1key.getText().toString().equals("6B")){
                if(song1level.getText().toString().equals("NORMAL"))
                    song1difficulty=String.valueOf(results.get(0).getNm6());
                else if(song1level.getText().toString().equals("HARD"))
                    song1difficulty=String.valueOf(results.get(0).getHd6());
                else if(song1level.getText().toString().equals("MAXIMUM"))
                    song1difficulty=String.valueOf(results.get(0).getMx6());
            }
            else if(song1key.getText().toString().equals("8B")){
                if(song1level.getText().toString().equals("NORMAL"))
                    song1difficulty=String.valueOf(results.get(0).getNm8());
                else if(song1level.getText().toString().equals("HARD"))
                    song1difficulty=String.valueOf(results.get(0).getHd8());
                else if(song1level.getText().toString().equals("MAXIMUM"))
                    song1difficulty=String.valueOf(results.get(0).getMx8());
            }
            else if(song1key.getText().toString().equals("XB"))
                song1difficulty="??";
        }
        else if(song1title.getText().toString().equals("RANDOM")){
            song1bpm="??";
            song1difficulty="??";
        }
        if(song1level.getText().toString().equals("FX"))
            song1difficulty="??";

        if(!song2title.getText().toString().equals("") && !song2title.getText().toString().equals("RANDOM")){
            song2button.setVisibility(View.VISIBLE);
            results=realm.where(SongInfo.class).equalTo("title",song2title.getText().toString()).findAll();
            song2bpm=results.get(0).getBpm();
            if(song2key.getText().toString().equals("4B")){
                if(song2level.getText().toString().equals("NORMAL"))
                    song2difficulty=String.valueOf(results.get(0).getNm4());
                else if(song2level.getText().toString().equals("HARD"))
                    song2difficulty=String.valueOf(results.get(0).getHd4());
                else if(song2level.getText().toString().equals("MAXIMUM"))
                    song2difficulty=String.valueOf(results.get(0).getMx4());
            }
            else if(song2key.getText().toString().equals("5B")){
                if(song2level.getText().toString().equals("NORMAL"))
                    song2difficulty=String.valueOf(results.get(0).getNm5());
                else if(song2level.getText().toString().equals("HARD"))
                    song2difficulty=String.valueOf(results.get(0).getHd5());
                else if(song2level.getText().toString().equals("MAXIMUM"))
                    song2difficulty=String.valueOf(results.get(0).getMx5());
            }
            else if(song2key.getText().toString().equals("6B")){
                if(song2level.getText().toString().equals("NORMAL"))
                    song2difficulty=String.valueOf(results.get(0).getNm6());
                else if(song2level.getText().toString().equals("HARD"))
                    song2difficulty=String.valueOf(results.get(0).getHd6());
                else if(song2level.getText().toString().equals("MAXIMUM"))
                    song2difficulty=String.valueOf(results.get(0).getMx6());
            }
            else if(song2key.getText().toString().equals("8B")){
                if(song2level.getText().toString().equals("NORMAL"))
                    song2difficulty=String.valueOf(results.get(0).getNm8());
                else if(song2level.getText().toString().equals("HARD"))
                    song2difficulty=String.valueOf(results.get(0).getHd8());
                else if(song2level.getText().toString().equals("MAXIMUM"))
                    song2difficulty=String.valueOf(results.get(0).getMx8());
            }
            else if(song2key.getText().toString().equals("XB"))
                song2difficulty="??";
        }
        else if(song2title.getText().toString().equals("RANDOM")){
            song2bpm="??";
            song2difficulty="??";
        }
        if(song2level.getText().toString().equals("FX"))
            song2difficulty="??";

        if(!song3title.getText().toString().equals("") && !song3title.getText().toString().equals("RANDOM")){
            song3button.setVisibility(View.VISIBLE);
            results=realm.where(SongInfo.class).equalTo("title",song3title.getText().toString()).findAll();
            song3bpm=results.get(0).getBpm();
            if(song3key.getText().toString().equals("4B")){
                if(song3level.getText().toString().equals("NORMAL"))
                    song3difficulty=String.valueOf(results.get(0).getNm4());
                else if(song3level.getText().toString().equals("HARD"))
                    song3difficulty=String.valueOf(results.get(0).getHd4());
                else if(song3level.getText().toString().equals("MAXIMUM"))
                    song3difficulty=String.valueOf(results.get(0).getMx4());
            }
            else if(song3key.getText().toString().equals("5B")){
                if(song3level.getText().toString().equals("NORMAL"))
                    song3difficulty=String.valueOf(results.get(0).getNm5());
                else if(song3level.getText().toString().equals("HARD"))
                    song3difficulty=String.valueOf(results.get(0).getHd5());
                else if(song3level.getText().toString().equals("MAXIMUM"))
                    song3difficulty=String.valueOf(results.get(0).getMx5());
            }
            else if(song3key.getText().toString().equals("6B")){
                if(song3level.getText().toString().equals("NORMAL"))
                    song3difficulty=String.valueOf(results.get(0).getNm6());
                else if(song3level.getText().toString().equals("HARD"))
                    song3difficulty=String.valueOf(results.get(0).getHd6());
                else if(song3level.getText().toString().equals("MAXIMUM"))
                    song3difficulty=String.valueOf(results.get(0).getMx6());
            }
            else if(song3key.getText().toString().equals("8B")){
                if(song3level.getText().toString().equals("NORMAL"))
                    song3difficulty=String.valueOf(results.get(0).getNm8());
                else if(song3level.getText().toString().equals("HARD"))
                    song3difficulty=String.valueOf(results.get(0).getHd8());
                else if(song3level.getText().toString().equals("MAXIMUM"))
                    song3difficulty=String.valueOf(results.get(0).getMx8());
            }
            else if(song3key.getText().toString().equals("XB"))
                song3difficulty="??";
        }
        else if(song3title.getText().toString().equals("RANDOM")){
            song3bpm="??";
            song3difficulty="??";
        }
        if(song3level.getText().toString().equals("FX"))
            song3difficulty="??";

        if(!song4title.getText().toString().equals("") && !song4title.getText().toString().equals("RANDOM") && !song4title.getText().toString().equals("??") && !song4title.getText().toString().equals("!?")){
            song4button.setVisibility(View.VISIBLE);
            results=realm.where(SongInfo.class).equalTo("title",song4title.getText().toString()).findAll();
            song4bpm=results.get(0).getBpm();
            if(song4key.getText().toString().equals("4B")){
                if(song4level.getText().toString().equals("NORMAL"))
                    song4difficulty=String.valueOf(results.get(0).getNm4());
                else if(song4level.getText().toString().equals("HARD"))
                    song4difficulty=String.valueOf(results.get(0).getHd4());
                else if(song4level.getText().toString().equals("MAXIMUM"))
                    song4difficulty=String.valueOf(results.get(0).getMx4());
            }
            else if(song4key.getText().toString().equals("5B")){
                if(song4level.getText().toString().equals("NORMAL"))
                    song4difficulty=String.valueOf(results.get(0).getNm5());
                else if(song4level.getText().toString().equals("HARD"))
                    song4difficulty=String.valueOf(results.get(0).getHd5());
                else if(song4level.getText().toString().equals("MAXIMUM"))
                    song4difficulty=String.valueOf(results.get(0).getMx5());
            }
            else if(song4key.getText().toString().equals("6B")){
                if(song4level.getText().toString().equals("NORMAL"))
                    song4difficulty=String.valueOf(results.get(0).getNm6());
                else if(song4level.getText().toString().equals("HARD"))
                    song4difficulty=String.valueOf(results.get(0).getHd6());
                else if(song4level.getText().toString().equals("MAXIMUM"))
                    song4difficulty=String.valueOf(results.get(0).getMx6());
            }
            else if(song4key.getText().toString().equals("8B")){
                if(song4level.getText().toString().equals("NORMAL"))
                    song4difficulty=String.valueOf(results.get(0).getNm8());
                else if(song4level.getText().toString().equals("HARD"))
                    song4difficulty=String.valueOf(results.get(0).getHd8());
                else if(song4level.getText().toString().equals("MAXIMUM"))
                    song4difficulty=String.valueOf(results.get(0).getMx8());
            }
            else if(song4key.getText().toString().equals("XB"))
                song4difficulty="??";
        }
        else if(song4title.getText().toString().equals("RANDOM")){
            song4bpm="??";
            song4difficulty="??";
        }
        if(song4level.getText().toString().equals("FX"))
            song4difficulty="??";

        if(!song5title.getText().toString().equals("") && !song5title.getText().toString().equals("RANDOM")){
            song5button.setVisibility(View.VISIBLE);
            results=realm.where(SongInfo.class).equalTo("title",song5title.getText().toString()).findAll();
            song5bpm=results.get(0).getBpm();
            if(song5key.getText().toString().equals("4B")){
                if(song5level.getText().toString().equals("NORMAL"))
                    song5difficulty=String.valueOf(results.get(0).getNm4());
                else if(song5level.getText().toString().equals("HARD"))
                    song5difficulty=String.valueOf(results.get(0).getHd4());
                else if(song5level.getText().toString().equals("MAXIMUM"))
                    song5difficulty=String.valueOf(results.get(0).getMx4());
            }
            else if(song5key.getText().toString().equals("5B")){
                if(song5level.getText().toString().equals("NORMAL"))
                    song5difficulty=String.valueOf(results.get(0).getNm5());
                else if(song5level.getText().toString().equals("HARD"))
                    song5difficulty=String.valueOf(results.get(0).getHd5());
                else if(song5level.getText().toString().equals("MAXIMUM"))
                    song5difficulty=String.valueOf(results.get(0).getMx5());
            }
            else if(song5key.getText().toString().equals("6B")){
                if(song5level.getText().toString().equals("NORMAL"))
                    song5difficulty=String.valueOf(results.get(0).getNm6());
                else if(song5level.getText().toString().equals("HARD"))
                    song5difficulty=String.valueOf(results.get(0).getHd6());
                else if(song5level.getText().toString().equals("MAXIMUM"))
                    song5difficulty=String.valueOf(results.get(0).getMx6());
            }
            else if(song5key.getText().toString().equals("8B")){
                if(song5level.getText().toString().equals("NORMAL"))
                    song5difficulty=String.valueOf(results.get(0).getNm8());
                else if(song5level.getText().toString().equals("HARD"))
                    song5difficulty=String.valueOf(results.get(0).getHd8());
                else if(song5level.getText().toString().equals("MAXIMUM"))
                    song5difficulty=String.valueOf(results.get(0).getMx8());
            }
            else if(song5key.getText().toString().equals("XB"))
                song5difficulty="??";
        }
        else if(song5title.getText().toString().equals("RANDOM")){
            song5bpm="??";
            song5difficulty="??";
        }
        if(song5level.getText().toString().equals("FX"))
            song5difficulty="??";

        if(!song6title.getText().toString().equals("") && !song6title.getText().toString().equals("RANDOM")){
            song6button.setVisibility(View.VISIBLE);
            results=realm.where(SongInfo.class).equalTo("title",song6title.getText().toString()).findAll();
            song6bpm=results.get(0).getBpm();
            if(song6key.getText().toString().equals("4B")){
                if(song6level.getText().toString().equals("NORMAL"))
                    song6difficulty=String.valueOf(results.get(0).getNm4());
                else if(song6level.getText().toString().equals("HARD"))
                    song6difficulty=String.valueOf(results.get(0).getHd4());
                else if(song6level.getText().toString().equals("MAXIMUM"))
                    song6difficulty=String.valueOf(results.get(0).getMx4());
            }
            else if(song6key.getText().toString().equals("5B")){
                if(song6level.getText().toString().equals("NORMAL"))
                    song6difficulty=String.valueOf(results.get(0).getNm5());
                else if(song6level.getText().toString().equals("HARD"))
                    song6difficulty=String.valueOf(results.get(0).getHd5());
                else if(song6level.getText().toString().equals("MAXIMUM"))
                    song6difficulty=String.valueOf(results.get(0).getMx5());
            }
            else if(song6key.getText().toString().equals("6B")){
                if(song6level.getText().toString().equals("NORMAL"))
                    song6difficulty=String.valueOf(results.get(0).getNm6());
                else if(song6level.getText().toString().equals("HARD"))
                    song6difficulty=String.valueOf(results.get(0).getHd6());
                else if(song6level.getText().toString().equals("MAXIMUM"))
                    song6difficulty=String.valueOf(results.get(0).getMx6());
            }
            else if(song6key.getText().toString().equals("8B")){
                if(song6level.getText().toString().equals("NORMAL"))
                    song6difficulty=String.valueOf(results.get(0).getNm8());
                else if(song6level.getText().toString().equals("HARD"))
                    song6difficulty=String.valueOf(results.get(0).getHd8());
                else if(song6level.getText().toString().equals("MAXIMUM"))
                    song6difficulty=String.valueOf(results.get(0).getMx8());
            }
            else if(song6key.getText().toString().equals("XB"))
                song6difficulty="??";
        }
        else if(song6title.getText().toString().equals("RANDOM")){
            song6bpm="??";
            song6difficulty="??";
        }
        if(song6level.getText().toString().equals("FX"))
            song6difficulty="??";
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_mission_detail, menu);
    }


    @Override
    public void onClick(View view) {
        SharedPreferences sharedPreferences=getActivity().getSharedPreferences("Setting",Context.MODE_PRIVATE);
        float standardBpm=sharedPreferences.getFloat("bpm",0f);
        float tempSpeed=0.0f;
        String recommend="";
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        switch(view.getId()){
            case R.id.labelSong1button:
                try{
                    tempSpeed=Float.parseFloat(song1bpm);
                    recommend=decideSpeed(standardBpm/tempSpeed);
                }catch(Exception e){
                    String[] strArr=song1bpm.split("~");
                    tempSpeed=Float.parseFloat(strArr[1].trim());
                    recommend=decideSpeed(standardBpm/tempSpeed) + getString(R.string.SPEED_Variation);
                }
                builder.setTitle(song1title.getText().toString());
                builder.setMessage(song1key.getText().toString()+" "+song1level.getText().toString()+"\n\n"+getString(R.string.Difficulty)+"\n"+song1difficulty+"\n\n"+getString(R.string.SPEED_Recommendation)+"\n"+recommend);
                builder.setPositiveButton(getString(R.string.OK),new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder.create();
                builder.show();
                break;
            case R.id.labelSong2button:
                try{
                    tempSpeed=Float.parseFloat(song2bpm);
                    recommend=decideSpeed(standardBpm/tempSpeed);
                }catch(Exception e){
                    String[] strArr=song2bpm.split("~");
                    tempSpeed=Float.parseFloat(strArr[1].trim());
                    recommend=decideSpeed(standardBpm/tempSpeed) + getString(R.string.SPEED_Variation);
                }
                builder.setTitle(song2title.getText().toString());
                builder.setMessage(song2key.getText().toString()+" "+song2level.getText().toString()+"\n\n"+getString(R.string.Difficulty)+"\n"+song2difficulty+"\n\n"+getString(R.string.SPEED_Recommendation)+"\n"+recommend);
                builder.setPositiveButton(getString(R.string.OK),new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder.create();
                builder.show();
                break;
            case R.id.labelSong3button:
                try{
                    tempSpeed=Float.parseFloat(song3bpm);
                    recommend=decideSpeed(standardBpm/tempSpeed);
                }catch(Exception e){
                    String[] strArr=song3bpm.split("~");
                    tempSpeed=Float.parseFloat(strArr[1].trim());
                    recommend=decideSpeed(standardBpm/tempSpeed) + getString(R.string.SPEED_Variation);
                }
                builder.setTitle(song3title.getText().toString());
                builder.setMessage(song3key.getText().toString()+" "+song3level.getText().toString()+"\n\n"+getString(R.string.Difficulty)+"\n"+song3difficulty+"\n\n"+getString(R.string.SPEED_Recommendation)+"\n"+recommend);
                builder.setPositiveButton(getString(R.string.OK),new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder.create();
                builder.show();
                break;
            case R.id.labelSong4button:
                try{
                    tempSpeed=Float.parseFloat(song4bpm);
                    recommend=decideSpeed(standardBpm/tempSpeed);
                }catch(Exception e){
                    String[] strArr=song4bpm.split("~");
                    tempSpeed=Float.parseFloat(strArr[1].trim());
                    recommend=decideSpeed(standardBpm/tempSpeed) + getString(R.string.SPEED_Variation);
                }
                builder.setTitle(song4title.getText().toString());
                builder.setMessage(song4key.getText().toString()+" "+song4level.getText().toString()+"\n\n"+getString(R.string.Difficulty)+"\n"+song4difficulty+"\n\n"+getString(R.string.SPEED_Recommendation)+"\n"+recommend);
                builder.setPositiveButton(getString(R.string.OK),new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder.create();
                builder.show();
                break;
            case R.id.labelSong5button:
                try{
                    tempSpeed=Float.parseFloat(song5bpm);
                    recommend=decideSpeed(standardBpm/tempSpeed);
                }catch(Exception e){
                    String[] strArr=song5bpm.split("~");
                    tempSpeed=Float.parseFloat(strArr[1].trim());
                    recommend=decideSpeed(standardBpm/tempSpeed) + getString(R.string.SPEED_Variation);
                }
                builder.setTitle(song5title.getText().toString());
                builder.setMessage(song5key.getText().toString()+" "+song5level.getText().toString()+"\n\n"+getString(R.string.Difficulty)+"\n"+song5difficulty+"\n\n"+getString(R.string.SPEED_Recommendation)+"\n"+recommend);
                builder.setPositiveButton(getString(R.string.OK),new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder.create();
                builder.show();
                break;
            case R.id.labelSong6button:
                try{
                    tempSpeed=Float.parseFloat(song6bpm);
                    recommend=decideSpeed(standardBpm/tempSpeed);
                }catch(Exception e){
                    String[] strArr=song6bpm.split("~");
                    tempSpeed=Float.parseFloat(strArr[1].trim());
                    recommend=decideSpeed(standardBpm/tempSpeed) + getString(R.string.SPEED_Variation);
                }
                builder.setTitle(song6title.getText().toString());
                builder.setMessage(song6key.getText().toString()+" "+song6level.getText().toString()+"\n\n"+getString(R.string.Difficulty)+"\n"+song6difficulty+"\n\n"+getString(R.string.SPEED_Recommendation)+"\n"+recommend);
                builder.setPositiveButton(getString(R.string.OK),new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder.create();
                builder.show();
                break;
        }
    }

    String decideSpeed(float speed){
        String recommend="";
        if(speed<0.50f)
            recommend="0.50";
        else if(speed>=0.50f && speed<0.75f)
            recommend="0.50 ~ 0.75";
        else if(speed>=0.75f && speed<1.00f)
            recommend="0.75 ~ 1.00";
        else if(speed>=1.00f && speed<1.25f)
            recommend="1.00 ~ 1.25";
        else if(speed>=1.25f && speed<1.50f)
            recommend="1.25 ~ 1.50";
        else if(speed>=1.50f && speed<1.75f)
            recommend="1.50 ~ 1.75";
        else if(speed>=1.75f && speed<2.00f)
            recommend="1.75 ~ 2.00";
        else if(speed>=2.00f && speed<2.25f)
            recommend="2.00 ~ 2.25";
        else if(speed>=2.25f && speed<2.50f)
            recommend="2.25 ~ 2.50";
        else if(speed>=2.50f && speed<2.75f)
            recommend="2.50 ~ 2.75";
        else if(speed>=2.75f && speed<3.00f)
            recommend="2.75 ~ 3.00";
        else if(speed>=3.00f && speed<3.25f)
            recommend="3.00 ~ 3.25";
        else if(speed>=3.25f && speed<3.50f)
            recommend="3.25 ~ 3.50";
        else if(speed>=3.50f && speed<3.75f)
            recommend="3.50 ~ 3.75";
        else if(speed>=3.75f && speed<4.00f)
            recommend="3.75 ~ 4.00";
        else if(speed>=4.00f && speed<4.25f)
            recommend="4.00 ~ 4.25";
        else if(speed>=4.25f && speed<4.50f)
            recommend="4.25 ~ 4.50";
        else if(speed>=4.50f && speed<4.75f)
            recommend="4.50 ~ 4.75";
        else if(speed>=4.75f && speed<5.00f)
            recommend="4.75 ~ 5.00";
        else if(speed>=5.00f)
            recommend="5.00";
        return recommend;
    }
}
