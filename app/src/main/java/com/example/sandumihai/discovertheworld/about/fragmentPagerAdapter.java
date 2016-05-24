package com.example.sandumihai.discovertheworld.about;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class fragmentPagerAdapter extends FragmentPagerAdapter {

    private String tabTitles[] = new String[] {"Creators","Help","More Info"};
    private Context context;

    public fragmentPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {

        if(position == 0) {
            return new aboutCreatorsFragment();
        } else if(position == 1) {
            return new aboutHelpFragment();
        } else if(position == 2) {
            return new aboutMoreInfoFragment();
        }

        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}
