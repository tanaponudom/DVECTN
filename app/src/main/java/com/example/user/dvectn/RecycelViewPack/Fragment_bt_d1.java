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
 * Created by User on 9/3/2561.
 */

public class Fragment_bt_d1 extends Fragment   {
    RecyclerView recyclerView5;
    RecycleViewAdapter3 recycleViewAdapter5;
    List<String> Data_name;
    List<String> Data_ltname;
    List<String> Data_chan;
    List<Integer> Data_num;
    String CheckList [] = {"มา","มาสาย","ขาด","ลา"};
    String frg2;

    ArrayAdapter adp2;
    public  static  final String TAG_HEW = "HEW";




    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view1 = inflater.inflate(R.layout.av_bt_d,container,false);
        showboobs(view1);


        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();



        return view1;



    }
    private  void showboobs(View view){

        Data_name = new ArrayList<>();
        Data_ltname = new ArrayList<>();
        Data_chan = new ArrayList<>();
        Data_num = new ArrayList<>();





            Data_name.add("นาย อักษรขจร");
            Data_ltname.add("รถผ่าน");
            Data_chan.add("ปวช.2");
            Data_num.add(001);


            Data_name.add("นาย ประหยัด");
            Data_ltname.add("จันทร์อังคารพุธ");
            Data_chan.add("ปวช.2");
            Data_num.add(002);


            Data_name.add("นางสาว ประวิทย์");
            Data_ltname.add("ฉลาดจุง");
            Data_chan.add("ปวช.2");
            Data_num.add(003);


        adp2 = new ArrayAdapter(getContext(),android.R.layout.simple_dropdown_item_1line ,CheckList);
        recyclerView5 = view.findViewById(R.id.review_d);

        recycleViewAdapter5 = new RecycleViewAdapter3(getContext());

        recycleViewAdapter5.DataStudent(Data_name,Data_ltname,Data_chan,Data_num ,adp2);
        recyclerView5.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView5.setHasFixedSize(true);
        recyclerView5.setAdapter(recycleViewAdapter5);
    }

    public void replaceFragment(Fragment fragment, Bundle bundle) {

        if (bundle != null)
            fragment.setArguments(bundle);

        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction frgTran = fragmentManager.beginTransaction();
        frgTran.replace(R.id.content,fragment).addToBackStack(null).commit();


    }






}

