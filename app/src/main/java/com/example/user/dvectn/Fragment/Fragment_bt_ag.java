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

public class Fragment_bt_ag extends Fragment implements View.OnClickListener {
    Bundle bn2;
    String frg3;

    public static final String TAG_KAW = "KAW";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view2 = inflater.inflate(R.layout.av_bt_ag, container, false);
        bn2 = getArguments();
        if (bn2 != null) {
            frg3 = bn2.getString(Fragment_mainapp.TAG_HELL);
        }

        view2.findViewById(R.id.btn3).setOnClickListener(this);
        return view2;
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
            case R.id.btn3:
                Bundle bn2 = new Bundle();
                bn2.putString(TAG_KAW, "1112");

                Fragment_mainapp av_main_traner = new Fragment_mainapp();
                av_main_traner.setArguments(bn2);
                replaceFragment(av_main_traner, bn2);

                break;

        }
    }
}
