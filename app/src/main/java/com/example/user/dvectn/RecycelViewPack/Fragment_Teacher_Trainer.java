package com.example.user.dvectn.RecycelViewPack;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
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
import android.widget.Toast;

import com.example.user.dvectn.Fragment.Fragment_login;
import com.example.user.dvectn.Fragment.Teacher_spy_save;
import com.example.user.dvectn.POJO.POJO_getstu;
import com.example.user.dvectn.R;
import com.example.user.dvectn.Retrofit.NetworkConnectionManager;
import com.example.user.dvectn.Retrofit.OnNetworkCallBackGetStd;

import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;

/**
 * Created by User on 8/3/2561.
 */

public class Fragment_Teacher_Trainer extends Fragment {

    RecyclerView recyclerView2;
    RecycleViewAdapter2 recycleViewAdapter2;
    List<String> Data_flstr;
    List<String> Data_lsstr;
    List<Integer> Data_state;

    Context context;
    String dep_id = "";
    SharedPreferences.Editor editor;
    ProgressDialog progressDialog;
    SharedPreferences sharedPreferences;
    int memberId = 0;
    String str_thch;



    public static final String TAG_TCH1 ="TCH";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View viewtcher = inflater.inflate(R.layout.teacher_fusionjob,container,false);
        context = getContext();

        sharedPreferences = getActivity().getSharedPreferences(Fragment_login.MyPer, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        sharedPreferences = getActivity().getSharedPreferences(Fragment_login.MyPer, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        dep_id = sharedPreferences.getString(Fragment_login.KEY_dep_id,null);
//        Toast.makeText(context, ""+dep_id, Toast.LENGTH_SHORT).show();
        memberId = sharedPreferences.getInt(Fragment_login.KEY_member_id,0);

        recyclerView2 = viewtcher.findViewById(R.id.LV_thnaja_1);

        Data_flstr = new ArrayList<>();
        Data_lsstr = new ArrayList<>();
        Data_state = new ArrayList<>();





        new NetworkConnectionManager().getStudentName(onCallbackList,dep_id);


        return viewtcher;



    }



    OnNetworkCallBackGetStd onCallbackList = new OnNetworkCallBackGetStd() {
        @Override
        public void onResponse(List<POJO_getstu> getstu) {

//            if(progressDialog.isShowing()){
//                progressDialog.dismiss();
//            }
//            Toast.makeText(context, "Fuckkkkkkkkkkkkkkkkkkkkkkk", Toast.LENGTH_SHORT).show();
//            Toast.makeText(context, ""+getstu.get(0).getFirstname(), Toast.LENGTH_SHORT).show();



            for (int i = 0; i< getstu.size() ;i++){


                Data_flstr.add(getstu.get(i).getFirstname());
                Data_lsstr.add(getstu.get(i).getLastnamename());
                Data_state.add(i);
//                Data_member_id.add(Integer.parseInt(getstu.get(i).getMemberId()));   // get member id

            }

            recycleViewAdapter2 = new RecycleViewAdapter2(getContext());
            recycleViewAdapter2.Update_teacher_data(Data_flstr,Data_lsstr,Data_state);
            recyclerView2.setLayoutManager(new LinearLayoutManager(getContext()));
            recyclerView2.setHasFixedSize(true);
            recyclerView2.setAdapter(recycleViewAdapter2);


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



