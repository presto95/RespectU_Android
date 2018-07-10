package com.respect.presto.respectu;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.bigkoo.pickerview.MyOptionsPickerView;
import com.respect.presto.respectu.R;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;


public class MissionFragment extends Fragment implements AdapterView.OnItemClickListener {

    private Realm realm;
    private ListView listView;
    private RealmResults<MissionInfo> results;
    private MissionFragmentAdapter adapter;
    private String series="Respect";
    private int index=0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mission, container, false);
    }

    @Override
    public void onStart(){
        super.onStart();
        setHasOptionsMenu(true);

        realm=Realm.getDefaultInstance();
        results=realm.where(MissionInfo.class).equalTo("type",series).findAll();
        adapter=new MissionFragmentAdapter(getActivity(), R.layout.list_mission, results);
        listView=(ListView)getView().findViewById(R.id.listMission);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_mission, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.actionSearch:
                MyOptionsPickerView pickerSort=new MyOptionsPickerView(getActivity());
                final ArrayList<String> itemSearch=new ArrayList<>();
                itemSearch.add("Respect");
                itemSearch.add("Trilogy");
                itemSearch.add("Clazziquai Edition");
                itemSearch.add("Technika 1");
                pickerSort.setTitle(getString(R.string.Search));
                pickerSort.setPicker(itemSearch);
                pickerSort.setCyclic(false);
                pickerSort.setSelectOptions(index);
                pickerSort.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        index=options1;
                        series=itemSearch.get(options1);
                        if(series.equals("Clazziquai Edition"))
                            series="CE";
                        else if(series.equals("Technika 1"))
                            series = "Technika1";
                        results=realm.where(MissionInfo.class).equalTo("type",series).findAll();
                        adapter=new MissionFragmentAdapter(getActivity(),R.layout.list_mission,results);
                        listView.setAdapter(adapter);
                    }
                });
                pickerSort.show();
                return true;
        }
        return false;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        MissionDetailFragment missionDetailFragment=new MissionDetailFragment();
        MissionInfo missionInfo=results.get(i);
        String title=missionInfo.getTitle();
        int scoreLimit=missionInfo.getScoreLimit();
        int feverLimit=missionInfo.getFeverLimit();
        int comboLimit=missionInfo.getComboLimit();
        int rateLimit=missionInfo.getRateLimit();
        int breakLimit=missionInfo.getBreakLimit();
        String song1key=missionInfo.getSong1key();
        String song2key=missionInfo.getSong2key();
        String song3key=missionInfo.getSong3key();
        String song4key=missionInfo.getSong4key();
        String song5key=missionInfo.getSong5key();
        String song6key=missionInfo.getSong6key();
        String song1level=missionInfo.getSong1level();
        String song2level=missionInfo.getSong2level();
        String song3level=missionInfo.getSong3level();
        String song4level=missionInfo.getSong4level();
        String song5level=missionInfo.getSong5level();
        String song6level=missionInfo.getSong6level();
        String song1title=missionInfo.getSong1title();
        String song2title=missionInfo.getSong2title();
        String song3title=missionInfo.getSong3title();
        String song4title=missionInfo.getSong4title();
        String song5title=missionInfo.getSong5title();
        String song6title=missionInfo.getSong6title();
        String more=missionInfo.getMore();
        String reward=missionInfo.getReward();
        Bundle bundle=new Bundle(26);
        bundle.putString("title",title);
        bundle.putInt("scoreLimit",scoreLimit);
        bundle.putInt("feverLimit",feverLimit);
        bundle.putInt("comboLimit",comboLimit);
        bundle.putInt("rateLimit",rateLimit);
        bundle.putInt("breakLimit",breakLimit);
        bundle.putString("song1key",song1key);
        bundle.putString("song2key",song2key);
        bundle.putString("song3key",song3key);
        bundle.putString("song4key",song4key);
        bundle.putString("song5key",song5key);
        bundle.putString("song6key",song6key);
        bundle.putString("song1level",song1level);
        bundle.putString("song2level",song2level);
        bundle.putString("song3level",song3level);
        bundle.putString("song4level",song4level);
        bundle.putString("song5level",song5level);
        bundle.putString("song6level",song6level);
        bundle.putString("song1title",song1title);
        bundle.putString("song2title",song2title);
        bundle.putString("song3title",song3title);
        bundle.putString("song4title",song4title);
        bundle.putString("song5title",song5title);
        bundle.putString("song6title",song6title);
        bundle.putString("more",more);
        bundle.putString("reward",reward);
        missionDetailFragment.setArguments(bundle);
        listView.setEnabled(false);

        FragmentTransaction missionDetailTransaction=getActivity().getSupportFragmentManager().beginTransaction();
        missionDetailTransaction.replace(R.id.missionContainer, missionDetailFragment);
        missionDetailTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        missionDetailTransaction.addToBackStack(null);
        missionDetailTransaction.commit();


    }

}
