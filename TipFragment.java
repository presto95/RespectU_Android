package com.respect.presto.respectu;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.bigkoo.pickerview.MyOptionsPickerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import io.realm.Realm;
import io.realm.RealmResults;


public class TipFragment extends android.support.v4.app.Fragment {

    private ListView listView;
    private ArrayAdapter<String> adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tip, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        setHasOptionsMenu(true);
        listView = getView().findViewById(R.id.listTip);
        List<String> fakeItems = setList();
        List<String> items = new ArrayList<>();
        Random random = new Random();
        int count = fakeItems.size();
        int randomNo = random.nextInt(count);
        for(int i=0;i<count;++i){
            while(items.contains(fakeItems.get(randomNo))){
                randomNo = random.nextInt(count);
            }
            items.add(fakeItems.get(randomNo));
        }
        adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, items);
        listView.setAdapter(adapter);

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_tip, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.actionTip:
                AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
                if(getActivity().getResources().getConfiguration().locale.toString().equals("ko_KR"))
                    builder.setMessage("플레이에 도움이 되는 유용한 정보가 더 있나요?\n'개발자에게 이메일 보내기'로 알려주세요.\n다음 업데이트 때 추가하겠습니다.");
                else
                    builder.setMessage("Do you have any other useful information to help you play?\nPlease let me know by using 'Send Email to Developer'.\nWe will add it for the next update.");

                builder.setPositiveButton(getString(R.string.OK), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder.show();
                return true;
        }
        return false;
    }

    private List<String> setList(){
        List<String> list = new ArrayList<>();
        if(getActivity().getResources().getConfiguration().locale.toString().equals("ko_KR")){
            list.add("각 곡마다 설정했던 배속이 따로 저장됩니다.");
            list.add("아날로그 노트는 스틱을 돌리거나 한쪽 방향으로 입력을 유지하여 연주 가능합니다.");
            list.add("시스템 설정은 메인 메뉴에서 터치패드 버튼을 누르면 변경할 수 있습니다.");
            list.add("FREESTYLE 모드에서 R3 버튼을 눌러서 곡을 즐겨찾기에 등록할 수 있습니다.");
            list.add("FREESTYLE 모드에서는 콤보가 누적됩니다.");
            list.add("몇몇 곡에는 숨겨진 BGA가 존재합니다.");
            list.add("MAX COMBO 달성 시 해당 곡의 뮤직비디오를 획득할 수 있습니다.");
            list.add("음악 연주 중에 터치패드 버튼을 눌러서 BGA의 밝기를 조절할 수 있습니다.");
            list.add("FREESTYLE 모드에서 2인 로컬 플레이가 가능하며 서로 다른 모드로 함께 플레이 가능합니다.");
            list.add("연주에 사용되는 버튼 설정은 시스템 설정에서 변경 가능합니다.");
            list.add("FREESTYLE 모드의 콤보 누적 여부는 시스템 설정에서 변경 가능합니다.");
            list.add("ARCADE 모드는 난이도 기준으로 곡이 랜덤하게 주어집니다.");
            list.add("피버 게이지는 연주 정확도에 따라 증가량이 다릅니다.");
            list.add("시스템 설정에서 UI 스킨을 변경할 수 있습니다.");
            list.add("게임 화면이 전부 표시되지 않으면 \"Playstation4\" 설정 항목 중 표시 영역 설정을 확인해 보세요.");
            list.add("FREESTYLE 모드에서 L1 버튼, R1 버튼으로 카테고리를 변경할 수 있습니다.");
            list.add("ONLINE 모드에서는 아직 획득하지 못한 곡도 플레이할 수 있습니다.");
            list.add("피버를 발동하면 더 많은 콤보와 점수를 획득할 수 있습니다.");
            list.add("음악 연주 중이거나 곡 선택 화면에서 L2 버튼 R2 버튼으로 배속을 즉시 변경할 수 있습니다.");
        }
        else{
            list.add("Each music's speed settings are saved separately.");
            list.add("ANALOG NOTE can be played by rotating the stick or holding it to one side.");
            list.add("System Settings can be changed from the main menu by pressing the touch pad button.");
            list.add("In FREESTYLE mode, press the R3 button to add a music to your favorites.");
            list.add("In FREESTYLE mode, combos are cumulative.");
            list.add("Some music have hidden BGAs.");
            list.add("When you achieve MAX COMBO, you can receive the music video for the current music.");
            list.add("While performing, press the touch pad to adjust the BGA brightness.");
            list.add("In FREESTYLE mode, 2 players local play is possible, and each player can play a different mode.");
            list.add("The button used to play can be changed in System Settings.");
            list.add("FREESTYLE mode's combo accumulation can be changed in System Settings.");
            list.add("ARCADE mode's music are chosen randomly according to the set difficulty.");
            list.add("The FEVER gauge increases according to note play accuracy.");
            list.add("You can change the System Settings UI skin.");
            list.add("If the game screen doesn't display completely, check your \"PS4\" Display Area settings.");
            list.add("In FREESTYLE mode, use the L1 button and R1 button to change the category.");
            list.add("In ONLINE mode, you can play music you have not yet acquired.");
            list.add("While FEVER is active, you can receive more points and larger combos.");
            list.add("You can use the L2 button and R2 button to change the speed during play, or from the music selection screen.");
        }
        return list;
    }
}

