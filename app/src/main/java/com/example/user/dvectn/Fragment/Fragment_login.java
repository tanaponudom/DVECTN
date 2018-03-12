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
import android.widget.EditText;

import com.example.user.dvectn.R;
import com.example.user.dvectn.RecycelViewPack.Fragment_Student_Recycel;
import com.example.user.dvectn.RecycelViewPack.Fragment_Teacher_Recycle;
import com.example.user.dvectn.RecycelViewPack.Fragment_Teacher_Trainer;

/**
 * Created by User on 19/2/2561.
 */

public class Fragment_login extends Fragment implements View.OnClickListener {
    EditText et_user,et_pass;
    String str_user,str_pass;


    public static final String TAG_user = "user";


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.login_layout,container,false);
        view.findViewById(R.id.btn_login).setOnClickListener(this);
        et_user = view.findViewById(R.id.et_user);
        et_pass = view.findViewById(R.id.et_pass);


        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();

        return view;

    }

    private void login(){
        str_user = et_user.getText().toString();
        str_pass = et_pass.getText().toString();
        if (str_user.equals("admin") && str_pass.equals("1234"))
        {

            Fragment_mainapp sec=new Fragment_mainapp();
            Bundle bundle = new Bundle();
            bundle.putString(TAG_user,str_user);

            replaceFragment(sec ,bundle);
//            getActivity().getSupportFragmentManager().beginTransaction().add(R.id.content,sec,"ีsec").commit();

        }
          else if (str_user.equals("admin") && str_pass.equals("12345"))

        {
              Fragment_Student sec =new Fragment_Student();
              Bundle bundle = new Bundle();
              bundle.putString(TAG_user,str_user);

              replaceFragment(sec ,bundle);

        }
        else if (str_user.equals("2")&& str_pass.equals("2")){


            Fragment_Student_Recycel sec = new Fragment_Student_Recycel();
            Bundle bunble = new Bundle();
            bunble.putString(TAG_user,str_user);

            replaceFragment(sec,bunble);
        }
        else  if (str_user.equals("3") && str_pass.equals("3")){

            Fragment_Teacher_Recycle sec = new Fragment_Teacher_Recycle();
            Bundle bundle = new Bundle();
            bundle.putString(TAG_user,str_user);

            replaceFragment(sec,bundle);
        }
        else  if (str_user.equals("4") && str_pass.equals("4")){

            Fragment_Teacher_Trainer sec = new Fragment_Teacher_Trainer();
            Bundle bundle = new Bundle();
            bundle.putString(TAG_user,str_user);

            replaceFragment(sec,bundle);
        }

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
            case R.id.btn_login:
                login();
                break;
        }
    }
}
