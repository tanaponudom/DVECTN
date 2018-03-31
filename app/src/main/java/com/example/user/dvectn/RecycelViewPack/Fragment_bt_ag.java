package com.example.user.dvectn.RecycelViewPack;

import android.app.AlertDialog;
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
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.dvectn.Fragment.Fragment_login;
import com.example.user.dvectn.POJO.POJO_getstu;
import com.example.user.dvectn.R;
import com.example.user.dvectn.Retrofit.NetworkConnectionManager;
import com.example.user.dvectn.Retrofit.OnNetworkCallBackGetStd;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import okhttp3.ResponseBody;

/**
 * Created by User on 20/2/2561.
 */

public class Fragment_bt_ag extends Fragment {


    RecyclerView recycleView6;
    RecycleViewAdapter2 recycleViewAdapter6;
    List<String> Data_flstr;
    List<String> Data_lsstr;
    List<Integer> Data_state;
    List<Integer> Data_member_id;

    Context context;
    String dep_id = "";
    SharedPreferences.Editor editor;
    ProgressDialog progressDialog;
    SharedPreferences sharedPreferences;
    int memberId = 0;
    public static final String TAG_KAW = "KAW";



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view2 = inflater.inflate(R.layout.av_bt_ag, container, false);
        context = getContext();




        sharedPreferences = getActivity().getSharedPreferences(Fragment_login.MyPer, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        dep_id = sharedPreferences.getString(Fragment_login.KEY_dep_id,null);
//        Toast.makeText(context, ""+dep_id, Toast.LENGTH_SHORT).show();
        memberId = sharedPreferences.getInt(Fragment_login.KEY_member_id,0);

        recycleView6 = view2.findViewById(R.id.LV_str_naja);

        Data_flstr = new ArrayList<>();
        Data_lsstr = new ArrayList<>();
        Data_state = new ArrayList<>();

//        Data_flstr.add("Hew");
//        Data_lsstr.add("kaw");
//        Data_state.add(1);
//
//
//        Data_flstr.add("Hew");
//        Data_lsstr.add("kaw");
//        Data_state.add(1);
//
//
//        Data_flstr.add("Hew");
//        Data_lsstr.add("kaw");
//        Data_state.add(1);
//        Data_member_id.add(55);

        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();

        new NetworkConnectionManager().getStudentName(onCallbackList,dep_id);

        return view2;
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

            recycleViewAdapter6 = new RecycleViewAdapter2(getContext());
            recycleViewAdapter6.Update_str_work(Data_flstr,Data_lsstr,Data_state);
            recycleView6.setLayoutManager(new LinearLayoutManager(getContext()));
            recycleView6.setHasFixedSize(true);
            recycleView6.setAdapter(recycleViewAdapter6);

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
