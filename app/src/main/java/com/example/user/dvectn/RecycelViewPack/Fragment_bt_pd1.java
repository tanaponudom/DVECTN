package com.example.user.dvectn.RecycelViewPack;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.dvectn.Fragment.Fragment_mainapp;
import com.example.user.dvectn.R;

/**
 * Created by User on 20/2/2561.
 */

public class Fragment_bt_pd1 extends Fragment {
    Bundle bn3;
    String frg1;

    public  static  final String TAG_HEW2 = "HEW2";
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view2 = inflater.inflate(R.layout.av_bt_pd,container,false);
        bn3 = getArguments();

        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();

        if(bn3 != null);
        {
            frg1 = bn3.getString(Fragment_mainapp.TAG_HELL);
        }
        return  view2;
    }

    public void replaceFragment(Fragment fragment, Bundle bundle) {

        if (bundle != null)
            fragment.setArguments(bundle);

        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction frgTran = fragmentManager.beginTransaction();
        frgTran.replace(R.id.content,fragment).addToBackStack(null).commit();


    }


}
