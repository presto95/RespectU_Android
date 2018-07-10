package com.respect.presto.respectu;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.bigkoo.pickerview.MyOptionsPickerView;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by presto on 2017. 11. 19..
 */

public class AchievementFragment extends android.support.v4.app.Fragment {
    private Realm realm;
    private ListView listView;
    private RealmResults<AchievementInfo> results;
    private AchievementFragmentAdapter adapter;
    private int index=0;
    private String type="";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_achievement, container, false);
    }
    @Override
    public void onStart() {
        super.onStart();
        setHasOptionsMenu(true);

        realm=Realm.getDefaultInstance();
        results=realm.where(AchievementInfo.class).findAll();
        adapter=new AchievementFragmentAdapter(getActivity(), R.layout.list_achievement, results);
        listView=(ListView)getView().findViewById(R.id.listAchievement);
        listView.setAdapter(adapter);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_achievement, menu);
    }
    //나중에 검색 설정할 때 사용
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.actionSearch:
                MyOptionsPickerView pickerSort=new MyOptionsPickerView(getActivity());
                final ArrayList<String> itemSearch=new ArrayList<>();
                itemSearch.add("ALL");
                itemSearch.add("MUSIC");
                itemSearch.add("GEAR SKIN");
                itemSearch.add("NOTE SKIN");
                itemSearch.add("PLATE");
                itemSearch.add("GALLERY");
                itemSearch.add("COMMENT");
                pickerSort.setTitle(getString(R.string.Search));
                pickerSort.setPicker(itemSearch);
                pickerSort.setCyclic(false);
                pickerSort.setSelectOptions(index);
                pickerSort.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        index=options1;
                        type=itemSearch.get(options1);
                        if(type.equals("ALL")){
                            results=realm.where(AchievementInfo.class).findAll();
                        }
                        else{
                            results=realm.where(AchievementInfo.class).equalTo("type",type).findAll();
                        }

                        adapter=new AchievementFragmentAdapter(getActivity(),R.layout.list_achievement,results);
                        listView.setAdapter(adapter);
                    }
                });
                pickerSort.show();
                return true;
        }
        return false;
    }


}
