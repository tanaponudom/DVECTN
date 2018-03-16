package com.example.user.dvectn.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.user.dvectn.R;
import com.example.user.dvectn.RecycelViewPack.Fragment_Student_Recycel;


/**
 * Created by User on 21/2/2561.
 */

public class Student_save extends Fragment {
    EditText et_ins;
    Bundle bundlesave;
    String frg_sa;

    public static final  String TAG_STUSA = "STUSAVE";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View viewses = inflater.inflate(R.layout.student_save,container,false);


        bundlesave = getArguments();
        if(bundlesave != null){
            frg_sa = bundlesave.getString(Fragment_Student_Recycel.TAG_STU);

        }

       return  viewses;
    }
    public void replaceFragment(Fragment fragment, Bundle bundle) {

        if (bundle != null)
            fragment.setArguments(bundle);

        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction frgTran = fragmentManager.beginTransaction();
        frgTran.replace(R.id.content,fragment).addToBackStack(null).commit();


    }




}
