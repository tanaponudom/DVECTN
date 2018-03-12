package com.example.user.dvectn.RecycelViewPack;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.dvectn.Fragment.Fragment_mainapp;
import com.example.user.dvectn.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 9/3/2561.
 */

public class Fragment_bt_d1 extends Fragment implements View.OnClickListener{
    RecyclerView recyclerView5;
    RecycleViewAdapter3 recycleViewAdapter5;
    List<String> Data_name;
    List<String> Data_chan;
    List<Integer> Data_num;
    String frg2;
    Bundle btn3;

    TextView TV_2;

    public  static  final String TAG_HEW = "HEW";




    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view1 = inflater.inflate(R.layout.av_bt_d,container,false);
        showboobs(view1);

        view1.findViewById(R.id.btn3).setOnClickListener(this);
        btn3 = getArguments();
        frg2 = btn3.getString(Fragment_mainapp.TAG_HELL);



        return view1;



    }
    private  void showboobs(View view){

        Data_name = new ArrayList<>();
        Data_chan = new ArrayList<>();
        Data_num = new ArrayList<>();



        for (int i = 0; i <3 ;  i++){

            Data_name.add("ผัก ชี");
            Data_chan.add("ปวช.2");
            Data_num.add(12);

        }

        recyclerView5 = view.findViewById(R.id.review_d);

        recycleViewAdapter5 = new RecycleViewAdapter3(getContext());

        recycleViewAdapter5.DataStudent(Data_name,Data_chan,Data_num);
        recyclerView5.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView5.setHasFixedSize(true);
        recyclerView5.setAdapter(recycleViewAdapter5);
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
            case R.id.btn3:
                Bundle bn = new Bundle();
                bn.putString(TAG_HEW,"1156");

                Fragment_mainapp av_main_traner = new Fragment_mainapp();
                av_main_traner.setArguments(bn);
                replaceFragment(av_main_traner,bn);

//                getActiviity().getSupportFragmentManager().beginTransaction().add(R.id.content,av_main_traner,"name2").commit();
                break;

        }

    }
}
