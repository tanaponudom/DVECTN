package com.example.user.dvectn.RecycelViewPack;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;


import com.example.user.dvectn.Fragment.Fragment_bt_dd;
import com.example.user.dvectn.Fragment.Fragment_login;
import com.example.user.dvectn.Fragment.Fragment_mainapp;
import com.example.user.dvectn.POJO.POJOGetDaily;
import com.example.user.dvectn.POJO.POJO_Checkdaily;
import com.example.user.dvectn.POJO.POJO_PJ_P2;
import com.example.user.dvectn.POJO.POJO_getstu;
import com.example.user.dvectn.R;
import com.example.user.dvectn.Retrofit.NetworkConnectionManager;
import com.example.user.dvectn.Retrofit.OnNetworkCallBackGetStd;
import com.example.user.dvectn.Retrofit.OnNetworkCallback_Checkdaily_D1;
import com.example.user.dvectn.Retrofit.OnNetworkCallback_GET_state_d;
import com.example.user.dvectn.Retrofit.OnNetworkCallback_GetStdDaily;
import com.example.user.dvectn.Retrofit.OnNetworkCallback_PJ_P2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import okhttp3.ResponseBody;

/**
 * Created by User on 9/3/2561.
 */

public class Fragment_bt_d1 extends Fragment {
    RecyclerView recyclerView5;
    RecycleViewAdapter3 recycleViewAdapter5;
    List<String> Data_name;
    List<String> Data_ltname;
    List<String> Data_chan;
    List<String> Data_num;
    List<String>  Data_score;
    List<Integer> Data_member_id;

    String CheckList[] = {"-","ขาด", "ลา", "มา", "มาสาย"};
    String dep_id = "";
    int memberId = 0;
    SharedPreferences.Editor editor;
    ProgressDialog progressDialog;
    SharedPreferences sharedPreferences;
    Context context;
    Spinner spn1;
    ArrayAdapter adp2;
    public static final String TAG_HEW = "HEW";

    List<String> nameStd;
    List<String> idStd;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view1 = inflater.inflate(R.layout.av_bt_d, container, false);
//
//        spn1 = view1.findViewById(R.id.spn_checklist);
//        ArrayAdapter adapter = new ArrayAdapter(getActivity(),android.R.layout.simple_spinner_item,CheckList);
//        spn1.setAdapter(adapter);

        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();

        context = getContext();

        sharedPreferences = getActivity().getSharedPreferences(Fragment_login.MyPer, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        dep_id = sharedPreferences.getString(Fragment_login.KEY_dep_id,null);

//        Toast.makeText(context, ""+dep_id, Toast.LENGTH_SHORT).show();

        memberId = sharedPreferences.getInt(Fragment_login.KEY_member_id,0);

        Data_name = new ArrayList<>();
        Data_ltname = new ArrayList<>();
        Data_chan = new ArrayList<>();
        Data_num = new ArrayList<>();
        Data_score = new ArrayList<>();
        Data_member_id = new ArrayList<>();

        recyclerView5 = view1.findViewById(R.id.review_d);

        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("Loading......");
        progressDialog.show();

        new NetworkConnectionManager().getDataStdDaily(onCallbackList,dep_id);

        return view1;

    }


    OnNetworkCallback_GetStdDaily onCallbackList = new OnNetworkCallback_GetStdDaily() {
        @Override
        public void onResponse(List<POJOGetDaily> getstu) {

                if(progressDialog.isShowing()){
                    progressDialog.dismiss();
                }

//                Toast.makeText(context, ""+getstu.get(0).getFirstname(), Toast.LENGTH_SHORT).show();

                for (int i = 0; i< getstu.size() ;i++){


                    Data_name.add(getstu.get(i).getFirstname());
                    Data_ltname.add(getstu.get(i).getLastnamename());
                    Data_num.add(getstu.get(i).getMemberCode());
                    Data_member_id.add(Integer.parseInt(getstu.get(i).getMemberId()));   // get member id
                    Data_score.add(getstu.get(i).getScore());
                }

                    adp2 =  new ArrayAdapter(context,android.R.layout.simple_spinner_dropdown_item,CheckList);
                    recycleViewAdapter5 = new RecycleViewAdapter3(getContext());
                    recycleViewAdapter5.DataStudent(Data_name, Data_ltname, Data_num,Data_score, adp2);
                    recyclerView5.setLayoutManager(new LinearLayoutManager(getContext()));
                    recyclerView5.setHasFixedSize(true);
                    recyclerView5.setAdapter(recycleViewAdapter5);



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
        frgTran.replace(R.id.content, fragment).addToBackStack(null).commit();


    }




}