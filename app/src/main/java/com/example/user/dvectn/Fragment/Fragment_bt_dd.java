package com.example.user.dvectn.Fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.dvectn.R;

/**
 * Created by User on 20/2/2561.
 */

public class Fragment_bt_dd extends Fragment implements View.OnClickListener{
    Bundle bn4;
    String frg4;

    public static final String TAG_KAWNA = "KAWNA";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view4 =inflater.inflate(R.layout.av_bt_dd,container,false);
        view4.findViewById(R.id.BBTN_1).setOnClickListener(this);
        view4.findViewById(R.id.BBTN_2).setOnClickListener(this);
        view4.findViewById(R.id.BBTN_3).setOnClickListener(this);

        ((AppCompatActivity) getActivity()).getSupportActionBar().show();
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("การประเมินจิตพิสัย");

        bn4 = getArguments();
        if (bn4 != null) {
            frg4 = bn4.getString(Fragment_mainapp.TAG_HELL);
        }

        return  view4;

    }

    public void replaceFragment(Fragment fragment, Bundle bundle) {

        if (bundle != null)
            fragment.setArguments(bundle);

        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction frgTran = fragmentManager.beginTransaction();
        frgTran.replace(R.id.content,fragment).addToBackStack(null).commit();


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case  R.id.BBTN_1:
                Bundle bn4_1 = new Bundle();
                bn4_1.putString(TAG_KAWNA,"4567");

                Fragment_bt_dd_1 av_bt_dd_1 = new Fragment_bt_dd_1();
                av_bt_dd_1.setArguments(bn4_1);
                replaceFragment(av_bt_dd_1,bn4_1);
                break;
            case  R.id.BBTN_2:
                Bundle bn4_2 = new Bundle();
                bn4_2.putString(TAG_KAWNA,"4567");

                Fragment_bt_dd_2 av_bt_dd_2 = new Fragment_bt_dd_2();
                av_bt_dd_2.setArguments(bn4_2);
                replaceFragment(av_bt_dd_2,bn4_2);
                break;
            case  R.id.BBTN_3:
                Bundle bn4_3 = new Bundle();
                bn4_3.putString(TAG_KAWNA,"4567");

                Fragment_bt_dd_3 av_bt_dd_3 = new Fragment_bt_dd_3();
                av_bt_dd_3.setArguments(bn4_3);
                replaceFragment(av_bt_dd_3,bn4_3);
                break;
        }

    }
}
