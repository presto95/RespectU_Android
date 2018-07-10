package com.respect.presto.respectu;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.respect.presto.respectu.R;

import java.util.ArrayList;
import java.util.List;


public class MoreFragment extends Fragment implements AdapterView.OnItemClickListener{

    private ListView listView;
    private ArrayAdapter<String> arrayAdapter;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_more, container, false);
    }


    @Override
    public void onStart(){
        super.onStart();
        sharedPreferences = getActivity().getSharedPreferences("Setting",Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        listView=(ListView)getView().findViewById(R.id.listMore);
        List<String> rows=setList();
        arrayAdapter=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,rows);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(this);
    }

    private List<String> setList(){
        List<String> list=new ArrayList<>();
        if(getActivity().getResources().getConfiguration().locale.toString().equals("ko_KR")){
            list.add("목록을 눌러 더 많은 정보를 확인하세요.");
            list.add("스킬 레벨");
            list.add("도전과제");
            list.add("BPM 기본값 변경");
            list.add("주 버튼 설정");
            list.add("개발자에게 이메일 보내기");
        }
        else{
            list.add("Tap cells to get additional info.");
            list.add("Skill Level");
            list.add("ACHIEVEMENT");
            list.add("Change BPM Defaults");
            list.add("My Favorite Button");
            list.add("Send Email to Developer");
        }
        list.add("TIP");
        list.add("DJMAX Respect 1.12");
        list.add("RespectU 1.18");
        list.add("PSN ID : Presto_95");
        return list;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        switch(i){
            case 1:
                listView.setEnabled(false);
                GradeFragment gradeFragment = new GradeFragment();
                FragmentTransaction gradeTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                gradeTransaction.replace(R.id.moreContainer, gradeFragment);
                gradeTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                gradeTransaction.addToBackStack(null);
                gradeTransaction.commit();
                break;
            case 2:
                AchievementFragment achievementFragment=new AchievementFragment();
                FragmentTransaction achievementTransaction=getActivity().getSupportFragmentManager().beginTransaction();
                achievementTransaction.replace(R.id.moreContainer, achievementFragment);
                achievementTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                achievementTransaction.addToBackStack(null);
                achievementTransaction.commit();
                break;
            case 3:
                //final SharedPreferences sharedPreferences=getActivity().getSharedPreferences("Setting",Context.MODE_PRIVATE);
                AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
                builder.setTitle(getString(R.string.Change_BPM_Default));
                builder.setMessage(getString(R.string.Current) + " : " + (int)sharedPreferences.getFloat("bpm",0f) + " BPM\n\n"+getString(R.string.BPM_Explanation));
                final EditText editText=new EditText(getActivity());
                editText.setInputType(InputType.TYPE_CLASS_NUMBER);
                builder.setView(editText);
                builder.setPositiveButton(getString(R.string.OK), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //SharedPreferences.Editor editor=sharedPreferences.edit();
                        float tempBpm=sharedPreferences.getFloat("bpm",0f);
                        try{
                            editor.putFloat("bpm",Float.parseFloat(editText.getText().toString()));
                            editor.commit();
                            Toast.makeText(getActivity(),"Changed Successfully",Toast.LENGTH_SHORT).show();
                        }catch (Exception e){
                            editor.putFloat("bpm",tempBpm);
                            editor.commit();
                            Toast.makeText(getActivity(),"Not Changed",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                builder.setNegativeButton(getString(R.string.Cancel), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder.show();
                break;
            case 4:
                AlertDialog.Builder favoriteBuilder = new AlertDialog.Builder(getContext());
                favoriteBuilder.setTitle(getString(R.string.My_Favorite_Button)+" ("+getString(R.string.Current)+" : "+sharedPreferences.getString("favoriteButton", getString(R.string.None))+")");
                favoriteBuilder.setItems(new CharSequence[]{
                        "4B", "5B", "6B", "8B", getContext().getString(R.string.Cancel)
                }, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        switch(i){
                            case 0:
                                editor.putString("favoriteButton", "4B");
                                editor.commit();
                                break;
                            case 1:
                                editor.putString("favoriteButton", "5B");
                                editor.commit();
                                break;
                            case 2:
                                editor.putString("favoriteButton", "6B");
                                editor.commit();
                                break;
                            case 3:
                                editor.putString("favoriteButton", "8B");
                                editor.commit();
                                break;
                            case 4:
                                break;
                        }
                    }
                });
                favoriteBuilder.create().show();
                break;
            case 5:
                Intent email=new Intent(Intent.ACTION_SEND);
                email.setType("plain/text");
                String[] address={"yoohan95@gmail.com"};
                email.putExtra(Intent.EXTRA_EMAIL,address);
                startActivity(email);
                break;
            case 6:
                TipFragment tipFragment = new TipFragment();
                FragmentTransaction tipTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                tipTransaction.replace(R.id.moreContainer, tipFragment);
                tipTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                tipTransaction.addToBackStack(null);
                tipTransaction.commit();
            default:
                break;
        }
    }
}
