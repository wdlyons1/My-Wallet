package com.finalproject.mywallet;

import android.support.v4.app.Fragment; import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public class Tab_2_FragmentManagement extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.tab_2_layout, viewGroup, false);
    }
}
