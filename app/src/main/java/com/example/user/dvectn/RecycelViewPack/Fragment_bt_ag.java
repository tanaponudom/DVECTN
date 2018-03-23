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

import com.example.user.dvectn.Fragment.Fragment_mainapp;
import com.example.user.dvectn.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 20/2/2561.
 */

public class Fragment_bt_ag extends Fragment {
    String frg3;
    RecyclerView recycleView6;
    RecycleViewAdapter2 recycleViewAdapter6;
    List<String> Data_str;
    List<Integer> Data_state;


    public static final String TAG_KAW = "KAW";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view2 = inflater.inflate(R.layout.av_bt_ag, container, false);
        shownanaju(view2);
        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();


        return view2;
    }

    private  void shownanaju (View view){

        Data_str = new ArrayList<>();
        Data_state = new ArrayList<>();

        for (int i = 0; i < 20; i++) {

            Data_str.add("HewkawJung");
            if (i %2 == 0){
                Data_state.add(1);

            }else {
                Data_state.add(0);
            }
        }


        recycleView6 = view.findViewById(R.id.LV_str_naja);

        recycleViewAdapter6 = new RecycleViewAdapter2(getContext());

        recycleViewAdapter6.Update_str_work(Data_str,Data_state);
        recycleView6.setLayoutManager(new LinearLayoutManager(getContext()));
        recycleView6.setHasFixedSize(true);
        recycleView6.setAdapter(recycleViewAdapter6);

    }

    public void replaceFragment(Fragment fragment, Bundle bundle) {

        if (bundle != null)
            fragment.setArguments(bundle);

        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction frgTran = fragmentManager.beginTransaction();
        frgTran.replace(R.id.content,fragment).addToBackStack(null).commit();


    }


}
