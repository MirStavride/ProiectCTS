package com.example.sandumihai.discovertheworld.about;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import com.example.sandumihai.discovertheworld.R;
import com.example.sandumihai.discovertheworld.about.stab.SlidingTabLayout;

public class aboutActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager_aboutActivity);
        viewPager.setAdapter(new fragmentPagerAdapter(getSupportFragmentManager(), aboutActivity.this));
        SlidingTabLayout slidingTabLayout = (SlidingTabLayout) findViewById(R.id.slidingTab_aboutActivity);
        slidingTabLayout.setViewPager(viewPager);
    }
}