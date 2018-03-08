package com.example.user.dvectn.RecycelViewPack;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.dvectn.Fragment.Fragment_login;
import com.example.user.dvectn.Fragment.Student_save;
import com.example.user.dvectn.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 7/3/2561.
 */

public class Fragment_Student_Recycel extends Fragment implements View.OnClickListener {
    RecyclerView recyclerView;
    RecycleViewAdapter recycleViewAdapter;
    List<String> Data_St;
    List<String> Data_Url;
    Bundle bn_se;
    String frg_st;

    public  static  final String TAG_STU = "DENT";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View viewtt = inflater.inflate(R.layout.student_page, container, false);
        showdawae(viewtt);
        viewtt.findViewById(R.id.btn_bl).setOnClickListener(this);
        viewtt.findViewById(R.id.fab).setOnClickListener(this);
        bn_se = getArguments();
        frg_st = bn_se.getString(Fragment_login.TAG_user);


        FloatingActionButton fab = viewtt.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {

                    case R.id.fab:
                        Bundle bnq = new Bundle();
                        bnq.putString(TAG_STU, "11587");
//                        ส่วนภายใน Fragment
                        Snackbar.make(view, "โปรดกรอกข้อมูล", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();

                        Student_save student_save = new Student_save();
                        student_save.setArguments(bnq);
                        replaceFragment(student_save, bnq);
                        break;



                }
            }

        });
        return viewtt;
    }
    private void showdawae(View view) {


        Data_St = new ArrayList<>();
        Data_Url = new ArrayList<>();


        for (int i = 0; i < 100; i++) {

            Data_St.add("HewkawJung");
            Data_Url.add("https://images.pexels.com/photos/52710/matterhorn-zermatt-switzerland-snow-52710.jpeg?w=940&h=650&auto=compress&cs=tinysrgb");
        }


        recyclerView = view.findViewById(R.id.LV_st_1);

        recycleViewAdapter = new RecycleViewAdapter(getContext());

        recycleViewAdapter.Update_Data(Data_St, Data_Url);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(recycleViewAdapter);
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
            case R.id.btn_bl:
                Bundle bn = new Bundle();
                bn.putString(TAG_STU,"1153");

                Fragment_login fragment_login = new Fragment_login();
                fragment_login.setArguments(bn);
                replaceFragment(fragment_login,bn);
                break;
        }
    }
}

