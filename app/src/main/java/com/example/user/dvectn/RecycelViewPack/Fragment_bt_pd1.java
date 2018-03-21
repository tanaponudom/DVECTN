package com.example.user.dvectn.RecycelViewPack;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.user.dvectn.Fragment.Fragment_mainapp;
import com.example.user.dvectn.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 20/2/2561.
 */

public class Fragment_bt_pd1 extends Fragment {
    Bundle bn3;
    String frg1;
    RecyclerView recycleView;
    RecycleViewAdapter4 recycleViewAdapter;
    List<String> Data_ftname , Data_ltname , Data_Spiner;
    String ScoreList [] = {"-","1","2","3","4","5"};

    ArrayAdapter adp;


    public  static  final String TAG_HEW2 = "HEW2";
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view2 = inflater.inflate(R.layout.av_bt_pd,container,false);
        showdawae(view2);
        bn3 = getArguments();

        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();




        if(bn3 != null);
        {
            frg1 = bn3.getString(Fragment_mainapp.TAG_HELL);
        }
        return  view2;

    }



    private void showdawae(View view) {


        Data_ftname = new ArrayList<>();
        Data_ltname = new ArrayList<>();
        Data_Spiner = new ArrayList<String>();



            Data_ftname.add("นาย อักษรขจร");
            Data_ltname.add("รถผ่าน");

            Data_ftname.add("นาย ประหยัด");
            Data_ltname.add("จันทร์อังคารพุธ");

            Data_ftname.add("นางสาว ประวิทย์");
            Data_ltname.add("ฉลาดจุง");


        adp = new ArrayAdapter(getContext(),android.R.layout.simple_dropdown_item_1line ,ScoreList);

        recycleView = view.findViewById(R.id.LV_bt_pd);

        recycleViewAdapter = new RecycleViewAdapter4(getContext());

        recycleViewAdapter.Dataspinner(Data_ftname, Data_ltname ,adp);

        recycleView.setLayoutManager(new LinearLayoutManager(getContext()));
        recycleView.setHasFixedSize(true);
        recycleView.setAdapter(recycleViewAdapter);
    }

    public void replaceFragment(Fragment fragment, Bundle bundle) {

        if (bundle != null)
            fragment.setArguments(bundle);

        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction frgTran = fragmentManager.beginTransaction();
        frgTran.replace(R.id.content,fragment).addToBackStack(null).commit();


    }


}
