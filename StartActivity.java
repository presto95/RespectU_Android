package com.respect.presto.respectu;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import java.util.Locale;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class StartActivity extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        SharedPreferences sharedPreferences=getSharedPreferences("Setting",MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();

        Locale locale = this.getResources().getConfiguration( ).locale;
        String nation = locale.getLanguage();

        Realm.init(this);

        if(!sharedPreferences.getBoolean("updateFirst", false))
            Realm.deleteRealm(getRealmConfig());
        editor.putBoolean("updateFirst",true);

        //버전 업 시 해당 부분 +1 시켜주기
        //1.18.1 기준 20, 21

        //editor.putInt("version", 19);
        editor.commit();
        if(sharedPreferences.getInt("version", 0) <= 20){

            Realm.deleteRealm(getRealmConfig());
            new Database(getApplicationContext(), sharedPreferences.getInt("version", 0), nation);
            editor.putInt("version", 21);
            editor.commit();
        }


        if(!sharedPreferences.getBoolean("first",false))
            editor.putFloat("bpm",450.0f);
        editor.putBoolean("first",true);
        editor.commit();


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        mViewPager.setOffscreenPageLimit(5);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        /*tabLayout.getTabAt(0).setIcon(R.drawable.ic_song);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_mission);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_trophy);
        tabLayout.getTabAt(3).setIcon(R.drawable.ic_playlist);
        tabLayout.getTabAt(4).setIcon(R.drawable.ic_more);*/
    }

    private RealmConfiguration getRealmConfig(){
        return new RealmConfiguration.Builder().deleteRealmIfMigrationNeeded().build();
    }
    public static boolean deleteRealm(RealmConfiguration configuration){
        return Realm.deleteRealm(configuration);
    }


    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch(position){
                case 0:
                    SongFragment songFragment=new SongFragment();
                    return songFragment;
                case 1:
                    MissionFragment missionFragment=new MissionFragment();
                    return missionFragment;
                case 2:
                    TrophyFragment trophyFragment=new TrophyFragment();
                    return trophyFragment;
                case 3:
                    PlaylistFragment playlistFragment=new PlaylistFragment();
                    return playlistFragment;
                case 4:
                    MoreFragment moreFragment=new MoreFragment();
                    return moreFragment;
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 5;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return getString(R.string.Song);
                case 1:
                    return getString(R.string.Mission);
                case 2:
                    return getString(R.string.Trophy);
                case 3:
                    return getString(R.string.Playlist);
                case 4:
                    return getString(R.string.More);
            }
            return null;
        }

    }
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if(event.getKeyCode()==KeyEvent.KEYCODE_BACK && event.getAction()== KeyEvent.ACTION_UP){
            AlertDialog.Builder dialog=new AlertDialog.Builder(this);
            if(getSupportFragmentManager().getBackStackEntryCount()==0){
                dialog.setTitle(getString(R.string.Announcement));
                dialog.setMessage(getString(R.string.Application_Exit));
                dialog.setPositiveButton(getString(R.string.OK), new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                dialog.setNegativeButton(getString(R.string.Cancel),new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which){

                    }
                });
                dialog.create();
                dialog.show();
            }
            else{
                getSupportFragmentManager().popBackStack();
            }
        }
        return true;
    }
}
