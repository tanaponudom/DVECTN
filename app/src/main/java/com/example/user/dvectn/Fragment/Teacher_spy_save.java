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
import com.example.user.dvectn.RecycelViewPack.Fragment_Teacher_Recycle;
import com.example.user.dvectn.RecycelViewPack.Fragment_Teacher_Trainer;

/**
 * Created by User on 8/3/2561.
 */

public class Teacher_spy_save extends Fragment implements View.OnClickListener {

    EditText se_ins1;
    Bundle bundlesave1;
    String frg_sa1;

    public static final String TAG_STUSA1 = "STUSAVE";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view1 = inflater.inflate(R.layout.teacher_spy_save, container, false);

        view1.findViewById(R.id.btn_bsp2).setOnClickListener(this);
        bundlesave1 = getArguments();
        if(bundlesave1 != null){
            frg_sa1 = bundlesave1.getString(Fragment_Teacher_Trainer.TAG_TCH1);
        }
        return  view1;
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
            case  R.id.btn_bsp2:
                Bundle bn = new Bundle();
                bn.putString(TAG_STUSA1,"1150");

                Fragment_Teacher_Trainer te = new Fragment_Teacher_Trainer();
                te.setArguments(bn);
                replaceFragment(te,bn);
                break;
        }

    }
}
