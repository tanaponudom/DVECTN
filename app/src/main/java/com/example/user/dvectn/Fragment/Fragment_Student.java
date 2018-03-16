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
 * Created by User on 21/2/2561.
 */

public class Fragment_Student extends Fragment{
    Bundle bundle2;
    String user;
    String frg;

    public static final String TAG_HELL2 = "Hello2";


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.student_layout, container, false);

        
        bundle2 = getArguments();
        user = bundle2.getString(Fragment_login.TAG_user);

        if(bundle2 != null);
        {
            frg = bundle2.getString(Fragment_login.TAG_user);
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
