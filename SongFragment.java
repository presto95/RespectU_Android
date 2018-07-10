package com.respect.presto.respectu;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bigkoo.pickerview.MyOptionsPickerView;
import com.respect.presto.respectu.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.Sort;


public class SongFragment extends Fragment implements AdapterView.OnItemClickListener{

    private Realm realm;
    private ListView listView;
    private RealmResults<SongInfo> results;
    private SongFragmentAdapter adapter;
    private RealmResults<AchievementInfo> achievementResults;
    private RealmResults<MissionInfo> missionResults;

    private SharedPreferences sharedPreferences;

    private int indexSearch1=0;
    private int indexSearch2=0;
    private int indexSort1=0;
    private int indexSort2=0;
    private String series="All";
    private String key="4B";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_song, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        setHasOptionsMenu(true);
        sharedPreferences = getActivity().getSharedPreferences("Setting",Context.MODE_PRIVATE);
        key = sharedPreferences.getString("favoriteButton", "4B");
        switch(key){
            case "4B":
                indexSearch2=0;
                break;
            case "5B":
                indexSearch2=1;
                break;
            case "6B":
                indexSearch2=2;
                break;
            case "8B":
                indexSearch2=3;
                break;
            default:
                break;
        }
        listView=(ListView)getView().findViewById(R.id.listSong);
        realm=Realm.getDefaultInstance();
        results=realm.where(SongInfo.class).findAll().sort("lowercase");
        achievementResults = realm.where(AchievementInfo.class).equalTo("type", "MUSIC").findAll();
        missionResults = realm.where(MissionInfo.class).like("reward", "Music*").findAll();

        adapter=new SongFragmentAdapter(getActivity(), R.layout.list_song, results, key);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_song, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.actionRandom:
                RealmResults<SongInfo> objects = realm.where(SongInfo.class).findAll();
                Random random = new Random();
                int rand = random.nextInt(objects.size());
                SongInfo object = objects.get(rand);
                final String title=object.getTitle();
                String seriesString=object.getSeries();
                if(seriesString.equals("Portable1"))
                    seriesString="Portable 1";
                else if(seriesString.equals("Portable2"))
                    seriesString="Portable 2";
                else if(seriesString.equals("CE"))
                    seriesString="Clazziquai Edition";
                String bpm=object.getBpm();
                bpm="BPM "+bpm;
                float bpmFloat;
                String recommend="";
                String recommendTransform="\n"+getString(R.string.SPEED_Variation);
                String[] strArr=bpm.split(" ");
                if(Arrays.asList(strArr).contains("~"))
                    bpmFloat=Float.parseFloat(strArr[3]);
                else{
                    bpmFloat=Float.parseFloat(strArr[1]);
                    recommendTransform="";
                }
                SharedPreferences sharedPreferences=getActivity().getSharedPreferences("Setting", Context.MODE_PRIVATE);
                float speed=sharedPreferences.getFloat("bpm",0f)/bpmFloat;
                if(speed<0.50f)
                    recommend="0.50"+recommendTransform;
                else if(speed>=0.50f && speed<0.75f)
                    recommend="0.50 ~ 0.75"+recommendTransform;
                else if(speed>=0.75f && speed<1.00f)
                    recommend="0.75 ~ 1.00"+recommendTransform;
                else if(speed>=1.00f && speed<1.25f)
                    recommend="1.00 ~ 1.25"+recommendTransform;
                else if(speed>=1.25f && speed<1.50f)
                    recommend="1.25 ~ 1.50"+recommendTransform;
                else if(speed>=1.50f && speed<1.75f)
                    recommend="1.50 ~ 1.75"+recommendTransform;
                else if(speed>=1.75f && speed<2.00f)
                    recommend="1.75 ~ 2.00"+recommendTransform;
                else if(speed>=2.00f && speed<2.25f)
                    recommend="2.00 ~ 2.25"+recommendTransform;
                else if(speed>=2.25f && speed<2.50f)
                    recommend="2.25 ~ 2.50"+recommendTransform;
                else if(speed>=2.50f && speed<2.75f)
                    recommend="2.50 ~ 2.75"+recommendTransform;
                else if(speed>=2.75f && speed<3.00f)
                    recommend="2.75 ~ 3.00"+recommendTransform;
                else if(speed>=3.00f && speed<3.25f)
                    recommend="3.00 ~ 3.25"+recommendTransform;
                else if(speed>=3.25f && speed<3.50f)
                    recommend="3.25 ~ 3.50"+recommendTransform;
                else if(speed>=3.50f && speed<3.75f)
                    recommend="3.50 ~ 3.75"+recommendTransform;
                else if(speed>=3.75f && speed<4.00f)
                    recommend="3.75 ~ 4.00"+recommendTransform;
                else if(speed>=4.00f && speed<4.25f)
                    recommend="4.00 ~ 4.25"+recommendTransform;
                else if(speed>=4.25f && speed<4.50f)
                    recommend="4.25 ~ 4.50"+recommendTransform;
                else if(speed>=4.50f && speed<4.75f)
                    recommend="4.50 ~ 4.75"+recommendTransform;
                else if(speed>=4.75f && speed<5.00f)
                    recommend="4.75 ~ 5.00"+recommendTransform;
                else if(speed>=5.00f)
                    recommend="5.00"+recommendTransform;
                String unlockString="";
                for (AchievementInfo i : achievementResults){
                    if(i.getItem().equals(title)){
                        unlockString+="\n\n"+getString(R.string.Unlock_ACHIEVEMENT)+"\n";
                        unlockString+=i.getTitle()+" Stage "+i.getLevel();
                        break;
                    }
                }
                for (MissionInfo i : missionResults){
                    if(i.getReward().split(":")[1].trim().equals(title)){
                        unlockString+="\n\n"+getString(R.string.Unlock_Mission)+"\n";
                        unlockString+=i.getSection()+" - "+i.getTitle();
                    }
                }
                AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
                builder.setTitle(title);
                builder.setMessage(seriesString+"\n\n"+getString(R.string.SPEED_Recommendation)+"\n"+recommend+unlockString);
                builder.setPositiveButton(getString(R.string.OK), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder.create();
                builder.show();
                break;
            case R.id.actionSort:
                MyOptionsPickerView pickerSort=new MyOptionsPickerView(getActivity());
                final ArrayList<String> itemSort1=new ArrayList<>();
                final ArrayList<String> itemSort2=new ArrayList<>();
                itemSort1.add("NORMAL");
                itemSort1.add("HARD");
                itemSort1.add("MAXIMUM");
                itemSort2.add(getString(R.string.Asc));
                itemSort2.add(getString(R.string.Desc));
                pickerSort.setTitle(getString(R.string.Sort));
                pickerSort.setPicker(itemSort1,itemSort2,true);
                pickerSort.setCyclic(false);
                pickerSort.setSelectOptions(indexSort1,indexSort2);
                pickerSort.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    //리스트뷰 리로드
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        indexSort1=options1;
                        indexSort2=option2;
                        if(itemSort1.get(options1).equals("NORMAL")){
                            if(key.equals("4B")){
                                if(itemSort2.get(option2).equals(getString(R.string.Asc))){
                                    if(series.equals("All"))
                                        results=realm.where(SongInfo.class).notEqualTo("nm4", 0).findAll().sort("nm4");
                                    else
                                        results=realm.where(SongInfo.class).equalTo("series",series).notEqualTo("nm4", 0).findAllSorted("nm4");
                                }
                                else if(itemSort2.get(option2).equals(getString(R.string.Desc))){
                                    if(series.equals("All"))
                                        results=realm.where(SongInfo.class).notEqualTo("nm4", 0).findAll().sort("nm4",Sort.DESCENDING);
                                    else
                                        results=realm.where(SongInfo.class).equalTo("series",series).notEqualTo("nm4", 0).findAllSorted("nm4",Sort.DESCENDING);
                                }
                            }
                            if(key.equals("5B")){
                                if(itemSort2.get(option2).equals(getString(R.string.Asc))){
                                    if(series.equals("All"))
                                        results=realm.where(SongInfo.class).notEqualTo("nm5", 0).findAll().sort("nm5");
                                    else
                                        results=realm.where(SongInfo.class).equalTo("series",series).notEqualTo("nm5", 0).findAllSorted("nm5");
                                }
                                else if(itemSort2.get(option2).equals(getString(R.string.Desc))){
                                    if(series.equals("All"))
                                        results=realm.where(SongInfo.class).notEqualTo("nm5", 0).findAll().sort("nm5",Sort.DESCENDING);
                                    else
                                        results=realm.where(SongInfo.class).equalTo("series",series).notEqualTo("nm5", 0).findAllSorted("nm5",Sort.DESCENDING);
                                }
                            }
                            if(key.equals("6B")){
                                if(itemSort2.get(option2).equals(getString(R.string.Asc))){
                                    if(series.equals("All"))
                                        results=realm.where(SongInfo.class).notEqualTo("nm6", 0).findAll().sort("nm6");
                                    else
                                        results=realm.where(SongInfo.class).equalTo("series",series).notEqualTo("nm6", 0).findAllSorted("nm6");
                                }
                                else if(itemSort2.get(option2).equals(getString(R.string.Desc))){
                                    if(series.equals("All"))
                                        results=realm.where(SongInfo.class).notEqualTo("nm6", 0).findAll().sort("nm6",Sort.DESCENDING);
                                    else
                                        results=realm.where(SongInfo.class).equalTo("series",series).notEqualTo("nm6", 0).findAllSorted("nm6",Sort.DESCENDING);
                                }
                            }
                            if(key.equals("8B")){
                                if(itemSort2.get(option2).equals(getString(R.string.Asc))){
                                    if(series.equals("All"))
                                        results=realm.where(SongInfo.class).notEqualTo("nm8", 0).findAll().sort("nm8");
                                    else
                                        results=realm.where(SongInfo.class).equalTo("series",series).notEqualTo("nm8", 0).findAllSorted("nm8");
                                }
                                else if(itemSort2.get(option2).equals(getString(R.string.Desc))){
                                    if(series.equals("All"))
                                        results=realm.where(SongInfo.class).notEqualTo("nm8", 0).findAll().sort("nm8",Sort.DESCENDING);
                                    else
                                        results=realm.where(SongInfo.class).equalTo("series",series).notEqualTo("nm8", 0).findAllSorted("nm8",Sort.DESCENDING);
                                }
                            }
                        }
                        else if(itemSort1.get(options1).equals("HARD")){
                            if(key.equals("4B")){
                                if(itemSort2.get(option2).equals(getString(R.string.Asc))){
                                    if(series.equals("All"))
                                        results=realm.where(SongInfo.class).notEqualTo("hd4", 0).findAll().sort("hd4");
                                    else
                                        results=realm.where(SongInfo.class).equalTo("series",series).notEqualTo("hd4", 0).findAllSorted("hd4");
                                }
                                else if(itemSort2.get(option2).equals(getString(R.string.Desc))){
                                    if(series.equals("All"))
                                        results=realm.where(SongInfo.class).notEqualTo("hd4", 0).findAll().sort("hd4",Sort.DESCENDING);
                                    else
                                        results=realm.where(SongInfo.class).equalTo("series",series).notEqualTo("hd4", 0).findAllSorted("hd4",Sort.DESCENDING);
                                }
                            }
                            if(key.equals("5B")){
                                if(itemSort2.get(option2).equals(getString(R.string.Asc))){
                                    if(series.equals("All"))
                                        results=realm.where(SongInfo.class).notEqualTo("hd5", 0).findAll().sort("hd5");
                                    else
                                        results=realm.where(SongInfo.class).equalTo("series",series).notEqualTo("hd5", 0).findAllSorted("hd5");
                                }
                                else if(itemSort2.get(option2).equals(getString(R.string.Desc))){
                                    if(series.equals("All"))
                                        results=realm.where(SongInfo.class).notEqualTo("hd5", 0).findAll().sort("hd5",Sort.DESCENDING);
                                    else
                                        results=realm.where(SongInfo.class).equalTo("series",series).notEqualTo("hd5", 0).findAllSorted("hd5",Sort.DESCENDING);
                                }
                            }
                            if(key.equals("6B")){
                                if(itemSort2.get(option2).equals(getString(R.string.Asc))){
                                    if(series.equals("All"))
                                        results = realm.where(SongInfo.class).notEqualTo("hd6", 0).findAllSorted("hd6");
                                    else
                                        results=realm.where(SongInfo.class).equalTo("series",series).notEqualTo("hd6", 0).findAllSorted("hd6");
                                }
                                else if(itemSort2.get(option2).equals(getString(R.string.Desc))){
                                    if(series.equals("All"))
                                        results=realm.where(SongInfo.class).notEqualTo("hd6", 0).findAllSorted("hd6",Sort.DESCENDING);
                                    else
                                        results=realm.where(SongInfo.class).equalTo("series",series).notEqualTo("hd6", 0).findAllSorted("hd6",Sort.DESCENDING);
                                }
                            }
                            if(key.equals("8B")){
                                if(itemSort2.get(option2).equals(getString(R.string.Asc))){
                                    if(series.equals("All"))
                                        results=realm.where(SongInfo.class).notEqualTo("hd8", 0).findAllSorted("hd8");
                                    else
                                        results=realm.where(SongInfo.class).equalTo("series",series).notEqualTo("hd8", 0).findAllSorted("hd8");
                                }
                                else if(itemSort2.get(option2).equals(getString(R.string.Desc))){
                                    if(series.equals("All"))
                                        results=realm.where(SongInfo.class).notEqualTo("hd8", 0).findAllSorted("hd8",Sort.DESCENDING);
                                    else
                                        results=realm.where(SongInfo.class).equalTo("series",series).notEqualTo("hd8", 0).findAllSorted("hd8",Sort.DESCENDING);
                                }
                            }
                        }
                        else if(itemSort1.get(options1).equals("MAXIMUM")){
                            if(key.equals("4B")){
                                if(itemSort2.get(option2).equals(getString(R.string.Asc))){
                                    if(series.equals("All"))
                                        results=realm.where(SongInfo.class).notEqualTo("mx4", 0).findAllSorted("mx4");
                                    else
                                        results=realm.where(SongInfo.class).equalTo("series",series).notEqualTo("mx4", 0).findAllSorted("mx4");
                                }
                                else if(itemSort2.get(option2).equals(getString(R.string.Desc))){
                                    if(series.equals("All"))
                                        results=realm.where(SongInfo.class).notEqualTo("mx4", 0).findAll().sort("mx4",Sort.DESCENDING);
                                    else
                                        results=realm.where(SongInfo.class).equalTo("series",series).notEqualTo("mx4", 0).findAllSorted("mx4",Sort.DESCENDING);
                                }
                            }
                            if(key.equals("5B")){
                                if(itemSort2.get(option2).equals(getString(R.string.Asc))){
                                    if(series.equals("All"))
                                        results=realm.where(SongInfo.class).notEqualTo("mx5", 0).findAll().sort("mx5");
                                    else
                                        results=realm.where(SongInfo.class).equalTo("series",series).notEqualTo("mx5", 0).findAllSorted("mx5");
                                }
                                else if(itemSort2.get(option2).equals(getString(R.string.Desc))){
                                    if(series.equals("All"))
                                        results=realm.where(SongInfo.class).notEqualTo("mx5", 0).findAll().sort("mx5",Sort.DESCENDING);
                                    else
                                        results=realm.where(SongInfo.class).equalTo("series",series).notEqualTo("mx5", 0).findAllSorted("mx5",Sort.DESCENDING);
                                }
                            }
                            if(key.equals("6B")){
                                if(itemSort2.get(option2).equals(getString(R.string.Asc))){
                                    if(series.equals("All"))
                                        results=realm.where(SongInfo.class).notEqualTo("mx6", 0).findAll().sort("mx6");
                                    else
                                        results=realm.where(SongInfo.class).equalTo("series",series).notEqualTo("mx6", 0).findAllSorted("mx6");
                                }
                                else if(itemSort2.get(option2).equals(getString(R.string.Desc))){
                                    if(series.equals("All"))
                                        results=realm.where(SongInfo.class).notEqualTo("mx6", 0).findAll().sort("mx6",Sort.DESCENDING);
                                    else
                                        results=realm.where(SongInfo.class).equalTo("series",series).notEqualTo("mx6", 0).findAllSorted("mx6",Sort.DESCENDING);
                                }
                            }
                            if(key.equals("8B")){
                                if(itemSort2.get(option2).equals(getString(R.string.Asc))){
                                    if(series.equals("All"))
                                        results=realm.where(SongInfo.class).notEqualTo("mx8", 0).findAll().sort("mx8");
                                    else
                                        results=realm.where(SongInfo.class).equalTo("series",series).notEqualTo("mx8", 0).findAllSorted("mx8");
                                }
                                else if(itemSort2.get(option2).equals(getString(R.string.Desc))){
                                    if(series.equals("All"))
                                        results=realm.where(SongInfo.class).notEqualTo("mx8", 0).findAll().sort("mx8",Sort.DESCENDING);
                                    else
                                        results=realm.where(SongInfo.class).equalTo("series",series).notEqualTo("mx8", 0).findAllSorted("mx8",Sort.DESCENDING);
                                }
                            }
                        }
                        adapter=new SongFragmentAdapter(getActivity(), R.layout.list_song, results, key);
                        listView.setAdapter(adapter);
                    }
                });
                pickerSort.show();
                return true;
            case R.id.actionSearch:
                MyOptionsPickerView pickerSearch=new MyOptionsPickerView(getActivity());
                final ArrayList<String> itemSearch1=new ArrayList<>();
                final ArrayList<String> itemSearch2=new ArrayList<>();
                itemSearch1.add("All");
                itemSearch1.add("Portable 1");
                itemSearch1.add("Portable 2");
                itemSearch1.add("Respect");
                itemSearch1.add("Trilogy");
                itemSearch1.add("Clazziquai");
                itemSearch1.add("Technika 1");
                itemSearch2.add("4B");
                itemSearch2.add("5B");
                itemSearch2.add("6B");
                itemSearch2.add("8B");
                pickerSearch.setTitle(getString(R.string.Search));
                pickerSearch.setPicker(itemSearch1,itemSearch2,true);
                pickerSearch.setSelectOptions(indexSearch1,indexSearch2);
                pickerSearch.setCyclic(false);
                pickerSearch.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    //리스트뷰 리로드
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        series=itemSearch1.get(options1);
                        if(series.equals("Clazziquai"))
                            series="CE";
                        else if(series.equals("Portable 1"))
                            series="Portable1";
                        else if(series.equals("Portable 2"))
                            series="Portable2";
                        else if(series.equals("Technika 1"))
                            series = "Technika1";
                        key=itemSearch2.get(option2);
                        indexSearch1=options1;
                        indexSearch2=option2;
                        if(series.equals("All"))
                            results=realm.where(SongInfo.class).findAll().sort("lowercase");
                        else
                            results=realm.where(SongInfo.class).equalTo("series",series).findAllSorted("lowercase");
                        adapter=new SongFragmentAdapter(getActivity(), R.layout.list_song, results, key);
                        listView.setAdapter(adapter);

                    }
                });
                pickerSearch.show();
                return true;
        }
        return false;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, final int row, long l) {
        final SongInfo songInfo=results.get(row);
        final String title=((TextView)view.findViewById(R.id.labelTitle)).getText().toString();
        String bpm=((TextView)view.findViewById(R.id.labelBpm)).getText().toString();
        float bpmFloat;
        String recommend="";
        String recommendTransform="\n"+getString(R.string.SPEED_Variation);
        String[] strArr=bpm.split(" ");
        if(Arrays.asList(strArr).contains("~"))
            bpmFloat=Float.parseFloat(strArr[3]);
        else{
            bpmFloat=Float.parseFloat(strArr[1]);
            recommendTransform="";
        }
        SharedPreferences sharedPreferences=getActivity().getSharedPreferences("Setting", Context.MODE_PRIVATE);
        float speed=sharedPreferences.getFloat("bpm",0f)/bpmFloat;
        if(speed<0.50f)
            recommend="0.50"+recommendTransform;
        else if(speed>=0.50f && speed<0.75f)
            recommend="0.50 ~ 0.75"+recommendTransform;
        else if(speed>=0.75f && speed<1.00f)
            recommend="0.75 ~ 1.00"+recommendTransform;
        else if(speed>=1.00f && speed<1.25f)
            recommend="1.00 ~ 1.25"+recommendTransform;
        else if(speed>=1.25f && speed<1.50f)
            recommend="1.25 ~ 1.50"+recommendTransform;
        else if(speed>=1.50f && speed<1.75f)
            recommend="1.50 ~ 1.75"+recommendTransform;
        else if(speed>=1.75f && speed<2.00f)
            recommend="1.75 ~ 2.00"+recommendTransform;
        else if(speed>=2.00f && speed<2.25f)
            recommend="2.00 ~ 2.25"+recommendTransform;
        else if(speed>=2.25f && speed<2.50f)
            recommend="2.25 ~ 2.50"+recommendTransform;
        else if(speed>=2.50f && speed<2.75f)
            recommend="2.50 ~ 2.75"+recommendTransform;
        else if(speed>=2.75f && speed<3.00f)
            recommend="2.75 ~ 3.00"+recommendTransform;
        else if(speed>=3.00f && speed<3.25f)
            recommend="3.00 ~ 3.25"+recommendTransform;
        else if(speed>=3.25f && speed<3.50f)
            recommend="3.25 ~ 3.50"+recommendTransform;
        else if(speed>=3.50f && speed<3.75f)
            recommend="3.50 ~ 3.75"+recommendTransform;
        else if(speed>=3.75f && speed<4.00f)
            recommend="3.75 ~ 4.00"+recommendTransform;
        else if(speed>=4.00f && speed<4.25f)
            recommend="4.00 ~ 4.25"+recommendTransform;
        else if(speed>=4.25f && speed<4.50f)
            recommend="4.25 ~ 4.50"+recommendTransform;
        else if(speed>=4.50f && speed<4.75f)
            recommend="4.50 ~ 4.75"+recommendTransform;
        else if(speed>=4.75f && speed<5.00f)
            recommend="4.75 ~ 5.00"+recommendTransform;
        else if(speed>=5.00f)
            recommend="5.00"+recommendTransform;
        final String recommendedSpeed=getString(R.string.SPEED_Recommendation) + " : " + recommend;
        String unlockString="";
        for (AchievementInfo i : achievementResults){
            if(i.getItem().equals(title)){
                unlockString+="\n\n"+getString(R.string.Unlock_ACHIEVEMENT)+"\n";
                unlockString+=i.getTitle()+" Stage "+i.getLevel();
                break;
            }
        }
        for (MissionInfo i : missionResults){
            if(i.getReward().split(":")[1].trim().equals(title)){
                unlockString+="\n\n"+getString(R.string.Unlock_Mission)+"\n";
                unlockString+=i.getSection()+" - "+i.getTitle();
            }
        }
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        builder.setTitle(title);
        builder.setMessage(getString(R.string.SPEED_Recommendation)+"\n"+recommend+unlockString);
        builder.setPositiveButton(getString(R.string.OK), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.setNegativeButton(getString(R.string.Add_to_Playlist), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if(realm.where(PlaylistInfo.class).equalTo("title",title).findAll().size() == 0){

                    addPlaylist(songInfo.getSeries(),songInfo.getTitle(),songInfo.getComposer(),songInfo.getBpm(),songInfo.getNm4(),songInfo.getHd4(),songInfo.getMx4(),songInfo.getNm5(),songInfo.getHd5(),songInfo.getMx5(),songInfo.getNm6(),songInfo.getHd6(),songInfo.getMx6(),songInfo.getNm8(),songInfo.getHd8(),songInfo.getMx8());
                }
            }
        });
        builder.setNeutralButton(getString(R.string.Performance), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Bundle bundle=new Bundle(17);
                bundle.putString("key", key);
                bundle.putString("bpm", recommendedSpeed);
                bundle.putString("title", songInfo.getTitle());
                bundle.putString("series", songInfo.getSeries());
                switch(key){
                    case "4B":
                        bundle.putInt("segment",0);
                        break;
                    case "5B":
                        bundle.putInt("segment",1);
                        break;
                    case "6B":
                        bundle.putInt("segment",2);
                        break;
                    case "8B":
                        bundle.putInt("segment",3);
                        break;
                    default:
                        break;
                }
                bundle.putInt("nm4", songInfo.getNm4());
                bundle.putInt("nm5", songInfo.getNm5());
                bundle.putInt("nm6", songInfo.getNm6());
                bundle.putInt("nm8", songInfo.getNm8());
                bundle.putInt("hd4", songInfo.getHd4());
                bundle.putInt("hd5", songInfo.getHd5());
                bundle.putInt("hd6", songInfo.getHd6());
                bundle.putInt("hd8", songInfo.getHd8());
                bundle.putInt("mx4", songInfo.getMx4());
                bundle.putInt("mx5", songInfo.getMx5());
                bundle.putInt("mx6", songInfo.getMx6());
                bundle.putInt("mx8", songInfo.getMx8());
                PerformanceFragment performanceFragment = new PerformanceFragment();
                performanceFragment.setArguments(bundle);
                listView.setEnabled(false);

                FragmentTransaction performanceTransaction=getActivity().getSupportFragmentManager().beginTransaction();
                performanceTransaction.replace(R.id.songContainer, performanceFragment);
                performanceTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                performanceTransaction.addToBackStack(null);
                performanceTransaction.commit();
            }
        });
        builder.create();
        builder.show();
    }

    public void addPlaylist(String series, String title, String composer, String bpm, int nm4, int hd4, int mx4, int nm5, int hd5, int mx5, int nm6, int hd6, int mx6, int nm8, int hd8, int mx8){
        Realm realm=Realm.getDefaultInstance();
        realm.beginTransaction();
        PlaylistInfo playlist=realm.createObject(PlaylistInfo.class);
        playlist.setSeries(series);
        playlist.setTitle(title);
        playlist.setComposer(composer);
        playlist.setBpm(bpm);
        playlist.setNm4(nm4);
        playlist.setNm5(nm5);
        playlist.setNm6(nm6);
        playlist.setNm8(nm8);
        playlist.setHd4(hd4);
        playlist.setHd5(hd5);
        playlist.setHd6(hd6);
        playlist.setHd8(hd8);
        playlist.setMx4(mx4);
        playlist.setMx5(mx5);
        playlist.setMx6(mx6);
        playlist.setMx8(mx8);
        realm.commitTransaction();
    }
}
