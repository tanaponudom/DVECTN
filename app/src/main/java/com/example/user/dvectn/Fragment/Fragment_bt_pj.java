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

public class Fragment_bt_pj extends Fragment implements View.OnClickListener {
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

        ((AppCompatActivity) getActivity()).getSupportActionBar().show();
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("แบบประเมินโครงการ");

        return view4;
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
        switch (view.getId()) {
            case R.id.BTNN_1:
                Fragment_bt_pj_1 av_bt_pj_1 = new Fragment_bt_pj_1();
                replaceFragment(av_bt_pj_1,null);

                break;
            case R.id.BTNN_2:
                Fragment_bt_pj_2 av_bt_pj_2 = new Fragment_bt_pj_2();
                replaceFragment(av_bt_pj_2,null);

                break;
            case R.id.BTNN_3:
                Fragment_bt_pj_3 av_bt_pj_3 = new Fragment_bt_pj_3();
                replaceFragment(av_bt_pj_3,null);

                break;
            case R.id.BTNN_4:
                Fragment_bt_pj_4 av_bt_pj_4 = new Fragment_bt_pj_4();
                replaceFragment(av_bt_pj_4,null);

                break;
            case R.id.BTNN_5:
                Fragment_bt_pj_5 av_bt_pj_5 = new Fragment_bt_pj_5();
                replaceFragment(av_bt_pj_5,null);

                break;
            case R.id.BTNN_6:
                Fragment_bt_pj_6 av_bt_pj_6 = new Fragment_bt_pj_6();
                replaceFragment(av_bt_pj_6,null);

                break;

            

        }
    }
}
