package com.finalproject.mywallet;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;



public class TabsAdapter extends FragmentStatePagerAdapter
{
    int mNumOfTabs;
    public TabsAdapter(FragmentManager fm, int NoomTabs)
    {
        super(fm);
        this.mNumOfTabs = NoomTabs;
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }


    @Override
    public Fragment getItem(int position)
    {
        switch (position){
            case 0:
                Tab_1_FragmentManagement home = new Tab_1_FragmentManagement();
                return home;
            case 1:
                Tab_2_FragmentManagement about = new Tab_2_FragmentManagement();
                return about;
            case 2:
                Tab_3_FragmentManagement contact = new Tab_3_FragmentManagement();
                return contact;
            default:
                return null;
        }
    }
}
