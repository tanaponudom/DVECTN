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
import com.example.user.dvectn.RecycelViewPack.Fragment_Teacher_Recycle;
import com.example.user.dvectn.RecycelViewPack.Fragment_Teacher_Trainer;

/**
 * Created by User on 8/3/2561.
 */

public class Teacher_layout_save extends Fragment implements View.OnClickListener {
    EditText et_ins2;
    Bundle bundlesave2;
    String frg_sa2;

    public static final  String TAG_STUSA2 = "STUSAVE2";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view2 = inflater.inflate(R.layout.teacher_layuot_save,container,false);

        view2.findViewById(R.id.btn_bsp3).setOnClickListener(this);
        bundlesave2 = getArguments();
        if(bundlesave2 != null){
            frg_sa2 = bundlesave2.getString(Fragment_Teacher_Recycle.TAG_TCH);
        }
        return  view2;
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
            case R.id.btn_bsp3:
                Bundle bn = new Bundle();
                bn.putString(TAG_STUSA2,"155189");

                Fragment_Teacher_Recycle teacher_layuot = new Fragment_Teacher_Recycle();
                teacher_layuot.setArguments(bn);
                replaceFragment(teacher_layuot,bn);
                break;


        }

    }
}