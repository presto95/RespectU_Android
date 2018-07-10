package com.respect.presto.respectu;

import android.content.DialogInterface;
import android.content.SharedPreferences;
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

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class SongDetailActivity extends AppCompatActivity {

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



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        mViewPager.setOffscreenPageLimit(4);
        switch(getSharedPreferences("Setting",MODE_PRIVATE).getString("favoriteButton", "4B")){
            case "4B":
                mViewPager.setCurrentItem(0);
                break;
            case "5B":
                mViewPager.setCurrentItem(1);
                break;
            case "6B":
                mViewPager.setCurrentItem(2);
                break;
            case "8B":
                mViewPager.setCurrentItem(3);
                break;
            default:
                break;
        }

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
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
            PerformanceFragment performanceFragment = new PerformanceFragment();
            Bundle bundle = new Bundle(1);

            switch(position){
                case 0:
                    bundle.putInt("segment", 0);
                    performanceFragment.setArguments(bundle);
                    return performanceFragment;
                case 1:
                    bundle.putInt("segment", 1);
                    performanceFragment.setArguments(bundle);
                    return performanceFragment;
                case 2:
                    bundle.putInt("segment", 2);
                    performanceFragment.setArguments(bundle);
                    return performanceFragment;
                case 3:
                    bundle.putInt("segment", 3);
                    performanceFragment.setArguments(bundle);
                    return performanceFragment;
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 4;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "4B";
                case 1:
                    return "5B";
                case 2:
                    return "6B";
                case 3:
                    return "8B";
            }
            return null;
        }

    }
}
