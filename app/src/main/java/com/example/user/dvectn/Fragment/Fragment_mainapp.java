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
import android.widget.TextView;

import com.example.user.dvectn.R;
import com.example.user.dvectn.RecycelViewPack.Fragment_bt_ag;
import com.example.user.dvectn.RecycelViewPack.Fragment_bt_d1;


/**
 * Created by User on 19/2/2561.
 */

public class Fragment_mainapp extends Fragment implements View.OnClickListener {
    TextView TV_1;
    Bundle bundle1;
    String user;
    String frg;

    public static final String TAG_HELL = "Hello";


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {



        View view = inflater.inflate(R.layout.av_main_traner, container, false);

        bundle1 = getArguments();
        user = bundle1.getString(Fragment_login.TAG_user);
        view.findViewById(R.id.BT_D).setOnClickListener(this);
        view.findViewById(R.id.BT_PD).setOnClickListener(this);
        view.findViewById(R.id.BT_AG).setOnClickListener(this);
        view.findViewById(R.id.BT_DD).setOnClickListener(this);
        view.findViewById(R.id.BT_PJ).setOnClickListener(this);

        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();

        return view;


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
            case R.id.BT_D:
                Bundle bn = new Bundle();
                bn.putString(TAG_HELL, "1150");

                Fragment_bt_d1 av_bt_d = new Fragment_bt_d1();
                av_bt_d.setArguments(bn);
                replaceFragment(av_bt_d, bn);
                break;
//               getActivity().getSupportFragmentManager().beginTransaction().add(R.id.content,av_bt_ag,"name").commit();
            case R.id.BT_PD:
                Bundle bn1 = new Bundle();
                bn1.putString(TAG_HELL, "1150");

                com.example.user.dvectn.RecycelViewPack.Fragment_bt_pd1 av_bt_pd = new com.example.user.dvectn.RecycelViewPack.Fragment_bt_pd1();
                av_bt_pd.setArguments(bn1);
                replaceFragment(av_bt_pd, bn1);
                break;
            case R.id.BT_AG:
                Bundle bn2 = new Bundle();
                bn2.putString(TAG_HELL, "1150");

                Fragment_AF_ag af_ag_list = new Fragment_AF_ag();
                af_ag_list.setArguments(bn2);
                replaceFragment(af_ag_list, bn2);
                break;
            case R.id.BT_DD:
                Bundle bn3 = new Bundle();
                bn3.putString(TAG_HELL, "1150");

                Fragment_AF_dd af_dd_list = new Fragment_AF_dd();
                af_dd_list.setArguments(bn3);
                replaceFragment(af_dd_list, bn3);
                break;
            case R.id.BT_PJ:
                Bundle bn4 = new Bundle();
                bn4.putString(TAG_HELL, "1150");

                Fragment_AF_pj af_pj_list = new Fragment_AF_pj();
                af_pj_list.setArguments(bn4);
                replaceFragment(af_pj_list, bn4);
                break;
        }

    }


}
