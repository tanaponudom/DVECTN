package com.example.user.dvectn.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.example.user.dvectn.R;

/**
 * Created by User on 20/2/2561.
 */

public class Fragment_bt_pj_1 extends Fragment {
    Bundle bn;
    String frg;

    public static final String TAG_KONAMI = "KOKO";


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.av_bt_pj_1, container, false);
        bn = getArguments();

        CheckBox CB1 = view.findViewById(R.id.CB1);
        CB1.setChecked(false);

        CheckBox CB2 = view.findViewById(R.id.CB2);
        CB2.setChecked(false);

        CheckBox CB3 = view.findViewById(R.id.CB3);
        CB3.setChecked(false);

        CheckBox CB4 = view.findViewById(R.id.CB4);
        CB4.setChecked(false);



        ((AppCompatActivity) getActivity()).getSupportActionBar().show();


        if (bn != null) ;
        {
            frg = bn.getString(Fragment_bt_pj.TAG_KAW3);
        }

        return view;


    }


    public void replaceFragment(Fragment fragment, Bundle bundle) {

        if (bundle != null)
            fragment.setArguments(bundle);

        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction frgTran = fragmentManager.beginTransaction();
        frgTran.replace(R.id.content,fragment).addToBackStack(null).commit();


    }




    }




