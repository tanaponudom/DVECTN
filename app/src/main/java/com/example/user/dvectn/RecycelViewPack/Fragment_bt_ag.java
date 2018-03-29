package com.example.user.dvectn.RecycelViewPack;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
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
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.dvectn.Fragment.Fragment_mainapp;
import com.example.user.dvectn.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 20/2/2561.
 */

public class Fragment_bt_ag extends Fragment implements View.OnClickListener {
    String frg3;

    RecyclerView recycleView6;
    RecycleViewAdapter2 recycleViewAdapter6;
    List<String> Data_str;
    List<Integer> Data_state;
    Context context;


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

    private void showCustomDialog(final String member_id, String detail, String url){

        String[] DataSp = {"-","0","1","2","3"};  // คะแนน

        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        LayoutInflater layoutInflater = LayoutInflater.from(context);

        View handleView = layoutInflater.inflate(R.layout.custom_layout_dialog,null);
        TextView tv_detail = handleView.findViewById(R.id.tv_detail);
        ImageView imageView = handleView.findViewById(R.id.img);
        final Spinner spinner = handleView.findViewById(R.id.spScore);


        //set detail
        tv_detail.setText(detail);
        // set image from url
        Picasso.with(context).load(url).into(imageView);

        ArrayAdapter adt = new ArrayAdapter(context,android.R.layout.simple_spinner_dropdown_item,DataSp);
        spinner.setAdapter(adt);
        builder.setTitle("ดูรายละเอียด");
        builder.setView(handleView);

        builder.setPositiveButton("อนุมัติ", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                Toast.makeText(context, "อนุมัติ member_id = "+member_id, Toast.LENGTH_SHORT).show();

            }
        });

        builder.setNegativeButton("ไม่อนุมัติ", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                Toast.makeText(context, "ไม่อนุมัติ  member_id = "+member_id, Toast.LENGTH_SHORT).show();

            }
        });
        builder.show();


    }

    public void replaceFragment(Fragment fragment, Bundle bundle) {

        if (bundle != null)
            fragment.setArguments(bundle);

        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction frgTran = fragmentManager.beginTransaction();
        frgTran.replace(R.id.content,fragment).addToBackStack(null).commit();


    }


    @Override
    public void onClick(View v) {
        switch (recycleView6.getId()){
            case  R.id.btn_ap:

                showCustomDialog("50999","ลง windows","http://2.bp.blogspot.com/-6_khqkp_IYc/Vm3LCXRwdvI/AAAAAAAA3i8/jYteC-WQXRE/s1000/header.jpg");

                break;
        }
    }
}
