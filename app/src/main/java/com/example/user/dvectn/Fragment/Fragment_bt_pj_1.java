package com.example.user.dvectn.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
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

public class Fragment_bt_pj_1 extends Fragment implements  OnClickListener {
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

        CheckBox CB5 = view.findViewById(R.id.CB5);
        CB5.setChecked(false);


        if (bn != null) ;
        {
            frg = bn.getString(Fragment_bt_pj.TAG_KAW3);
        }
        view.findViewById(R.id.btn9).setOnClickListener(this);
        return view;


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
        switch (view.getId()){
            case R.id.btn9:
                Bundle bn = new Bundle();
                bn.putString(TAG_KONAMI,"456");

                Fragment_bt_pj av_bt_pj = new Fragment_bt_pj();
                av_bt_pj.setArguments(bn);
                replaceFragment(av_bt_pj,bn);
                break;
        }

    }

}


