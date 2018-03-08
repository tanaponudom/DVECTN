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

public class Student_save extends Fragment implements View.OnClickListener {
    EditText et_ins;
    Bundle bundlesave;
    String frg_sa;

    public static final  String TAG_STUSA = "STUSAVE";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View viewses = inflater.inflate(R.layout.student_save,container,false);

        viewses.findViewById(R.id.btn_bsp).setOnClickListener(this);
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
            case R.id.btn_bsp:
                Bundle bn = new Bundle();
                bn.putString(TAG_STUSA,"15589");

                Fragment_Student_Recycel student_page = new Fragment_Student_Recycel();
                student_page.setArguments(bn);
                replaceFragment(student_page,bn);
                break;


        }

    }
}
