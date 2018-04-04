package com.example.user.dvectn.RecycelViewPack;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
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
import android.widget.Toast;

import com.example.user.dvectn.Fragment.Fragment_login;
import com.example.user.dvectn.POJO.POJO_getstuemp;
import com.example.user.dvectn.R;
import com.example.user.dvectn.Retrofit.NetworkConnectionManager;
import com.example.user.dvectn.Retrofit.OnNetworkCallback_getstuemp;

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
    List<String> Data_member_ID;
    List<String> Data_dep_id;
    List<Integer> Data_state;

    List<String> Data_img;
    List<String> Data_detail;
    List<String> Data_score;


    Context context;
    String dep_id = "";
    SharedPreferences.Editor editor;
    ProgressDialog progressDialog;
    SharedPreferences sharedPreferences;
    int memberId = 0;
    public static final String TAG_TCH1 ="TCH";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View viewtcher = inflater.inflate(R.layout.teacher_fusionjob,container,false);
        context = getContext();



        sharedPreferences = getActivity().getSharedPreferences(Fragment_login.MyPer, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        dep_id = sharedPreferences.getString(Fragment_login.KEY_dep_id,null);
//        Toast.makeText(context, ""+dep_id, Toast.LENGTH_SHORT).show();
        memberId = sharedPreferences.getInt(Fragment_login.KEY_member_id,0);




        recyclerView2 = viewtcher.findViewById(R.id.LV_thnaja_1);

        Data_flstr = new ArrayList<>();
        Data_state = new ArrayList<>();
        Data_member_ID = new ArrayList<>();
        Data_dep_id = new ArrayList<>();

        Data_img = new ArrayList<>();
        Data_detail = new ArrayList<>();
        Data_score = new ArrayList<>();


        recycleViewAdapter2 = new RecycleViewAdapter2(getContext());

        new NetworkConnectionManager().callSrever_getstuemp(onCallbackList,dep_id);

        return viewtcher;

    }



    OnNetworkCallback_getstuemp onCallbackList = new OnNetworkCallback_getstuemp() {
        @Override
        public void onResponse(List<POJO_getstuemp> getstuemp) {

//            if(progressDialog.isShowing()){
//                progressDialog.dismiss();
//            }
//            Toast.makeText(context, "Fuckkkkkkkkkkkkkkkkkkkkkkk", Toast.LENGTH_SHORT).show();
//            Toast.makeText(context, ""+getstu.get(0).getFirstname(), Toast.LENGTH_SHORT).show();

//        Toast.makeText(context, "dep ="+dep_id+"memberId ="+memberId, Toast.LENGTH_SHORT).show();


            for (int i = 0; i< getstuemp.size() ;i++){

                Data_dep_id.add(getstuemp.get(i).getMemberId());
                Data_member_ID.add(getstuemp.get(i).getMemberId());
                Data_flstr.add(getstuemp.get(i).getFirstname()+"\t"+getstuemp.get(i).getLastname());


                Data_detail.add(getstuemp.get(i).getDetail());
                Data_score.add(getstuemp.get(i).getScore());
                Data_img.add(getstuemp.get(i).getImg());
//                Data_lsstr.add(getstu.get(i).getLastnamename());
                Data_state.add(i);
//                Data_member_id.add(Integer.parseInt(getstu.get(i).getMemberId()));   // get member id

            }

//            recycleViewAdapter2 = new RecycleViewAdapter2(getContext());
            recycleViewAdapter2.Update_teacher_data(Data_flstr,Data_state,Data_img,Data_detail,Data_score,Data_member_ID);
            recyclerView2.setLayoutManager(new LinearLayoutManager(getContext()));
            recyclerView2.setHasFixedSize(true);
            recyclerView2.setAdapter(recycleViewAdapter2);

//            editor.putString(Fragment_login.KEY_dep_id,Data_dep_id.get(Fragment_Teacher_Trainer));
//            editor.commit();


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



