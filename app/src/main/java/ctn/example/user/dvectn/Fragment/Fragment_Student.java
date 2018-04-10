package ctn.example.user.dvectn.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by User on 21/2/2561.
 */

public class Fragment_Student extends Fragment{

    String user;
    String frg;

    public static final String TAG_HELL2 = "Hello2";


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(ctn.example.user.dvectn.R.layout.student_layout, container, false);


        return view;

    }

    public void replaceFragment(Fragment fragment, Bundle bundle) {

        if (bundle != null)
            fragment.setArguments(bundle);

        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction frgTran = fragmentManager.beginTransaction();
        frgTran.replace(ctn.example.user.dvectn.R.id.content,fragment).addToBackStack(null).commit();


    }



}
