package com.respect.presto.respectu;


import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

import io.realm.Realm;
import io.realm.RealmResults;


public class PlaylistFragment extends Fragment implements AdapterView.OnItemClickListener{

    private Realm realm;
    private ListView listView;
    private RealmResults<PlaylistInfo> results;
    private PlaylistFragmentAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_playlist, container, false);
    }

    @Override
    public void onStart(){
        super.onStart();
        realm=Realm.getDefaultInstance();
        results=realm.where(PlaylistInfo.class).findAll();
        adapter=new PlaylistFragmentAdapter(getActivity(), R.layout.list_playlist, results);
        listView=(ListView)getView().findViewById(R.id.listPlaylist);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onResume(){
        super.onResume();
        realm=Realm.getDefaultInstance();
        results=realm.where(PlaylistInfo.class).findAll();
        adapter=new PlaylistFragmentAdapter(getActivity(), R.layout.list_playlist, results);
        listView=(ListView)getView().findViewById(R.id.listPlaylist);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, final int row, long l) {
        //배속추천 표시, 삭제
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
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        builder.setTitle(results.get(row).getTitle());
        builder.setMessage(getString(R.string.SPEED_Recommendation)+"\n"+recommend);
        builder.setPositiveButton(getString(R.string.OK), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.setNegativeButton(getString(R.string.Remove), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //행 삭제
                final RealmResults<PlaylistInfo> deleteRow=realm.where(PlaylistInfo.class).equalTo("title",results.get(row).getTitle()).findAll();
                realm.executeTransaction(new Realm.Transaction(){
                    @Override
                    public void execute(Realm realm) {
                        deleteRow.deleteFirstFromRealm();
                    }
                });
                adapter=new PlaylistFragmentAdapter(getActivity(), R.layout.list_playlist, results);
                listView.setAdapter(adapter);
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

    public static PlaylistFragment newInstance(){
        Bundle args=new Bundle();
        PlaylistFragment fragment=new PlaylistFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
