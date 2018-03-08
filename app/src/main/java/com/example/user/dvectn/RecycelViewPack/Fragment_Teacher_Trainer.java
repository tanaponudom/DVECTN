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
import com.example.user.dvectn.Fragment.Teacher_spy_save;
import com.example.user.dvectn.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 8/3/2561.
 */

public class Fragment_Teacher_Trainer extends Fragment implements View.OnClickListener {

    RecyclerView recyclerView2;
    RecycleViewAdapter2 recycleViewAdapter2;
    List<String> Data_th;
    List<Integer> Data_state;
    Bundle bd_thch;
    String str_thch;



    public static final String TAG_TCH1 ="TCH";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View viewtcher = inflater.inflate(R.layout.teacher_fusionjob,container,false);
        showpuyfah(viewtcher);
        viewtcher.findViewById(R.id.btn_thnaja).setOnClickListener(this);
        viewtcher.findViewById(R.id.fab2).setOnClickListener(this);
        bd_thch = getArguments();
        str_thch = bd_thch.getString(Fragment_login.TAG_user);


        FloatingActionButton fab3 = viewtcher.findViewById(R.id.fab2);
        fab3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.fab2:
                        Bundle bgh = new Bundle();
                        bgh.putString(TAG_TCH1,"147258");

                        Snackbar.make(view, "โปรดกรอกข้อมูล", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();

                        Teacher_spy_save fragment_Teacher_Trainer = new Teacher_spy_save();
                        fragment_Teacher_Trainer.setArguments(bgh);
                        replaceFragment(fragment_Teacher_Trainer,bgh);
                        break;
                }
            }
        });
        return viewtcher;



    }
    private  void showpuyfah(View view){

        Data_th = new ArrayList<>();
        Data_state = new ArrayList<>();

        for (int i = 0; i < 100; i++) {

            Data_th.add("HewkawJung");
                if (i %2 == 0){
                    Data_state.add(1);

            }else {
                    Data_state.add(0);
                }
        }


        recyclerView2 = view.findViewById(R.id.LV_thnaja_1);

        recycleViewAdapter2 = new RecycleViewAdapter2(getContext());

        recycleViewAdapter2.Update_teacher_data(Data_th,Data_state);
        recyclerView2.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView2.setHasFixedSize(true);
        recyclerView2.setAdapter(recycleViewAdapter2);

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
            case R.id.btn_thnaja:
                Bundle bg = new Bundle();
                bg.putString(TAG_TCH1,"123458");

                Fragment_login fragment_login = new Fragment_login();
                fragment_login.setArguments(bg);
                replaceFragment(fragment_login,bg);
                break;


        }

    }
}



