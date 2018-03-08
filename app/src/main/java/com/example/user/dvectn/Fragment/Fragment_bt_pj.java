package com.example.user.dvectn.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.dvectn.R;

/**
 * Created by User on 20/2/2561.
 */

public class Fragment_bt_pj extends Fragment implements View.OnClickListener {
    Bundle bn5;
    String frg5;

    public static final String TAG_KAW3 = "KAW2";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view4 = inflater.inflate(R.layout.av_bt_pj, container, false);
        view4.findViewById(R.id.BTNN_1).setOnClickListener(this);
        view4.findViewById(R.id.BTNN_2).setOnClickListener(this);
        view4.findViewById(R.id.BTNN_3).setOnClickListener(this);
        view4.findViewById(R.id.BTNN_4).setOnClickListener(this);
        view4.findViewById(R.id.BTNN_5).setOnClickListener(this);
        view4.findViewById(R.id.BTNN_6).setOnClickListener(this);

        bn5 = getArguments();
        if (bn5 != null) {
            frg5 = bn5.getString(Fragment_mainapp.TAG_HELL);
        }
        view4.findViewById(R
                .id.btn5).setOnClickListener(this);

        return view4;
    }


    public void replaceFragment(Fragment fragment, Bundle bundle) {

        if (bundle != null)
            fragment.setArguments(bundle);

        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment oldFragment = fragmentManager.findFragmentByTag(fragment.getClass().getName());

        //if oldFragment already exits in fragmentManager use it
        if (oldFragment != null) {
            fragment = oldFragment;
        }

        fragmentTransaction.replace(R.id.content, fragment, fragment.getClass().getName());

        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);

        fragmentTransaction.commit();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn5:
                Bundle bn5 = new Bundle();
                bn5.putString(TAG_KAW3, "71120");

                Fragment_mainapp av_main_traner = new Fragment_mainapp();
                av_main_traner.setArguments(bn5);
                replaceFragment(av_main_traner, bn5);

                break;
            case R.id.BTNN_1:
                Bundle bn5_1 = new Bundle();
                bn5_1.putString(TAG_KAW3,"71120");

                Fragment_bt_pj_1 av_bt_pj_1 = new Fragment_bt_pj_1();
                av_bt_pj_1.setArguments(bn5_1);
                replaceFragment(av_bt_pj_1,bn5_1);

                break;
            case R.id.BTNN_2:
                Bundle bn5_2 = new Bundle();
                bn5_2.putString(TAG_KAW3,"71120");

                Fragment_bt_pj_2 av_bt_pj_2 = new Fragment_bt_pj_2();
                av_bt_pj_2.setArguments(bn5_2);
                replaceFragment(av_bt_pj_2,bn5_2);

                break;
            case R.id.BTNN_3:
                Bundle bn5_3 = new Bundle();
                bn5_3.putString(TAG_KAW3,"71120");

                Fragment_bt_pj_3 av_bt_pj_3 = new Fragment_bt_pj_3();
                av_bt_pj_3.setArguments(bn5_3);
                replaceFragment(av_bt_pj_3,bn5_3);

                break;
            case R.id.BTNN_4:
                Bundle bn5_4 = new Bundle();
                bn5_4.putString(TAG_KAW3,"71120");

                Fragment_bt_pj_4 av_bt_pj_4 = new Fragment_bt_pj_4();
                av_bt_pj_4.setArguments(bn5_4);
                replaceFragment(av_bt_pj_4,bn5_4);

                break;
            case R.id.BTNN_5:
                Bundle bn5_5 = new Bundle();
                bn5_5.putString(TAG_KAW3,"71120");

                Fragment_bt_pj_5 av_bt_pj_5 = new Fragment_bt_pj_5();
                av_bt_pj_5.setArguments(bn5_5);
                replaceFragment(av_bt_pj_5,bn5_5);

                break;
            case R.id.BTNN_6:
                Bundle bn5_6 = new Bundle();
                bn5_6.putString(TAG_KAW3,"71120");

                Fragment_bt_pj_6 av_bt_pj_6 = new Fragment_bt_pj_6();
                av_bt_pj_6.setArguments(bn5_6);
                replaceFragment(av_bt_pj_6,bn5_6);

                break;

            

        }
    }
}
