package com.respect.presto.respectu;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
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
import java.util.Locale;

import io.realm.Realm;
import io.realm.RealmResults;


public class TrophyFragment extends Fragment implements AdapterView.OnItemClickListener{

    private Realm realm;
    private ListView listView;
    private RealmResults<TrophyInfo> results;
    private TrophyFragmentAdapter adapter;
    private String series="Respect";
    private String language = "English";
    private int indexSearch=0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_trophy, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        setHasOptionsMenu(true);
        realm=Realm.getDefaultInstance();
        results=realm.where(TrophyInfo.class).equalTo("series",series).findAll();
        adapter=new TrophyFragmentAdapter(getActivity(), R.layout.list_trophy, results, language, getActivity().getResources().getConfiguration().locale, series);
        listView=(ListView)getView().findViewById(R.id.listTrophy);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_trophy, menu);
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
                pickerSort.setSelectOptions(indexSearch);
                pickerSort.setOnoptionsSelectListener(new MyOptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        indexSearch=options1;
                        series=itemSearch.get(options1);
                        if(series.equals("Clazziquai Edition"))
                            series="CE";
                        else if(series.equals("Technika 1"))
                            series = "Technika1";
                        results=realm.where(TrophyInfo.class).equalTo("series",series).findAll();
                        adapter=new TrophyFragmentAdapter(getActivity(),R.layout.list_trophy,results, language, getActivity().getResources().getConfiguration().locale, series);
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
        String title=results.get(i).getTitleKor();
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        if(title.equals("내 마음속에 저장") || title.equals("고고학자")){
            builder.setTitle("Hidden BGAs");
            builder.setMessage("A Lie\nEnemy Storm\nNB Ranger - Virgin Foce\nNever Say\nWhiteBlue\nOut Law");
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });
            builder.create();
            builder.show();
        }
        else if(title.equals("럭키 해피 데이")){
            builder.setTitle("777 Combos");
            builder.setMessage("5B NORMAL [Seeker]\n47 Combos -> BREAK -> Full Combo -> Trophy Earned");
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });
            builder.create();
            builder.show();
        }
        else if(title.equals("나올수도 있고 안나올수도 있습니다")){
            builder.setTitle("Hidden BGA");
            builder.setMessage("STOP");
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });
            builder.create();
            builder.show();
        }
        else if(title.equals("언제나 감사합니다")){
            builder.setTitle("CREDITS");
            builder.setMessage("CREDITS will appear when the average accuracy of three stages are greater than 98%.");
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });
            builder.create();
            builder.show();
        }
        else if(title.equals("Go Back From the Top")){
            builder.setTitle("Hidden BGA");
            builder.setMessage("First Kiss");
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });
            builder.create();
            builder.show();
        }
        else if(title.equals("암튼 레어 카드")){
            builder.setTitle("Hidden BGA");
            builder.setMessage("Thor");
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });
            builder.create();
            builder.show();
        }
    }
}
