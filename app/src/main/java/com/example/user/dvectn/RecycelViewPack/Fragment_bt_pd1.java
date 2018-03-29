package com.example.user.dvectn.RecycelViewPack;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
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
import android.widget.Toast;

import com.example.user.dvectn.Fragment.Fragment_login;
import com.example.user.dvectn.Fragment.Fragment_mainapp;
import com.example.user.dvectn.POJO.POJO_getstu;
import com.example.user.dvectn.R;
import com.example.user.dvectn.Retrofit.NetworkConnectionManager;
import com.example.user.dvectn.Retrofit.OnNetworkCallBackGetStd;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import okhttp3.ResponseBody;

/**
 * Created by User on 20/2/2561.
 */

public class Fragment_bt_pd1 extends Fragment {
    String frg1;
    RecyclerView recycleView;
    RecycleViewAdapter4 recycleViewAdapter;
    List<String> Data_ftname , Data_ltname ;
    List<Integer> Data_member_id , Data_Score;
    String ScoreList [] = {"-","น้อยที่สุด","น้อย","ปานกลาง","มาก","มากที่สุด"};
    String dep_id = "";
    SharedPreferences.Editor editor;
    ProgressDialog progressDialog;
    SharedPreferences sharedPreferences;
    Context context;
    int memberId = 0;
    ArrayAdapter adp;
    public  static  final String TAG_HEW2 = "HEW2";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view2 = inflater.inflate(R.layout.av_bt_pd,container,false);
        context = getContext();

        sharedPreferences = getActivity().getSharedPreferences(Fragment_login.MyPer, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();



        dep_id = sharedPreferences.getString(Fragment_login.KEY_dep_id,null);
        Toast.makeText(context, ""+dep_id, Toast.LENGTH_SHORT).show();
        memberId = sharedPreferences.getInt(Fragment_login.KEY_member_id,0);

        recycleView = view2.findViewById(R.id.LV_bt_pd);

        Data_ftname = new ArrayList<>();
        Data_ltname = new ArrayList<>();
        Data_Score = new ArrayList<>();
        Data_member_id = new ArrayList<>();

        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("Loading......");
        progressDialog.show();

        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
        new NetworkConnectionManager().getStudentName(onCallbackList,dep_id);

        return  view2;

    }




    OnNetworkCallBackGetStd onCallbackList = new OnNetworkCallBackGetStd() {
        @Override
        public void onResponse(List<POJO_getstu> getstu) {

            if(progressDialog.isShowing()){
                progressDialog.dismiss();
            }

                Toast.makeText(context, ""+getstu.get(0).getFirstname(), Toast.LENGTH_SHORT).show();

            for (int i = 0; i< getstu.size() ;i++){


                Data_ftname.add(getstu.get(i).getFirstname());
                Data_ltname.add(getstu.get(i).getLastnamename());
                Data_member_id.add(Integer.parseInt(getstu.get(i).getMemberId()));   // get member id

                Random rn = new Random();
                int range = 4 - 0 + 1;
                int randomNum =  rn.nextInt(range) + 0;

                Data_Score.add(randomNum);
            }

            adp = new ArrayAdapter(getContext(),android.R.layout.simple_dropdown_item_1line ,ScoreList);
//            recycleView = view2.findViewById(R.id.LV_bt_pd);
            recycleViewAdapter = new RecycleViewAdapter4(getContext());
            recycleViewAdapter.Dataspinner(Data_ftname, Data_ltname ,Data_Score ,adp);
            recycleView.setLayoutManager(new LinearLayoutManager(getContext()));
            recycleView.setHasFixedSize(true);
            recycleView.setAdapter(recycleViewAdapter);



        }

        @Override
        public void onBodyError(ResponseBody responseBodyError) {
            Toast.makeText(context, "responseBodyError", Toast.LENGTH_SHORT).show();
            if(progressDialog.isShowing()){
                progressDialog.dismiss();
            }

        }

        @Override
        public void onBodyErrorIsNull() {

            Toast.makeText(context, "res is null", Toast.LENGTH_SHORT).show();
            if(progressDialog.isShowing()){
                progressDialog.dismiss();
            }

        }

        @Override
        public void onFailure(Throwable t) {

            Toast.makeText(context, "Err "+t.getMessage(), Toast.LENGTH_SHORT).show();
            if(progressDialog.isShowing()){
                progressDialog.dismiss();
            }

        }
    };

    public void replaceFragment(Fragment fragment, Bundle bundle) {

        if (bundle != null)
            fragment.setArguments(bundle);

        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction frgTran = fragmentManager.beginTransaction();
        frgTran.replace(R.id.content,fragment).addToBackStack(null).commit();


    }


}
