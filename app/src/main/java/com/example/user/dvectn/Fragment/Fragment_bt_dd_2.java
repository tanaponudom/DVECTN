package com.example.user.dvectn.Fragment;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import android.widget.Spinner;

import com.example.user.dvectn.POJO.POJO_DD_P1;
import com.example.user.dvectn.POJO.POJO_DD_P2;
import com.example.user.dvectn.R;
import com.example.user.dvectn.Retrofit.NetworkConnectionManager;
import com.example.user.dvectn.Retrofit.OnNetworkCallback_DD_P1;
import com.example.user.dvectn.Retrofit.OnNetworkCallback_DD_P2;

import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;

/**
 * Created by User on 20/2/2561.
 */

public class Fragment_bt_dd_2 extends Fragment implements View.OnClickListener
{
    Context context;
    ProgressDialog progressDialog;
    String frg;
    String nameList[] = {"-","1","2","3","4","5"};
    Spinner spin1, spin2 , spin3 , spin4 , spin5 , spin6 , spin7 , spin8 ;
    String dep_id = "";
    SharedPreferences.Editor editor;
    SharedPreferences sharedPreferences;
    public  static  final String TAG_HEW4 = "HEW4";

    String memberId = "";





    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.av_bt_dd_2,container, false);
        context = getContext();

        spin1 = view.findViewById(R.id.spinner6);
        ArrayAdapter adapter = new ArrayAdapter(getActivity(),android.R.layout.simple_spinner_item,nameList);
        spin1.setAdapter(adapter);

        spin2 = view.findViewById(R.id.spinner7);
        ArrayAdapter adapter1 = new ArrayAdapter(getActivity(),android.R.layout.simple_spinner_item,nameList);
        spin2.setAdapter(adapter1);

        spin3 = view.findViewById(R.id.spinner8);
        ArrayAdapter adapter2 = new ArrayAdapter(getActivity(),android.R.layout.simple_spinner_item,nameList);
        spin3.setAdapter(adapter2);

        spin4 = view.findViewById(R.id.spinner9);
        ArrayAdapter adapter3 = new ArrayAdapter(getActivity(),android.R.layout.simple_spinner_item,nameList);
        spin4.setAdapter(adapter3);

        spin5 = view.findViewById(R.id.spinner10);
        ArrayAdapter adapter4 = new ArrayAdapter(getActivity(),android.R.layout.simple_spinner_item,nameList);
        spin5.setAdapter(adapter4);

        spin6 = view.findViewById(R.id.spinner11);
        ArrayAdapter adapter5 = new ArrayAdapter(getActivity(),android.R.layout.simple_spinner_item,nameList);
        spin6.setAdapter(adapter5);

        spin7 = view.findViewById(R.id.spinner12);
        ArrayAdapter adapter6 = new ArrayAdapter(getActivity(),android.R.layout.simple_spinner_item,nameList);
        spin7.setAdapter(adapter6);

        spin8 = view.findViewById(R.id.spinner13);
        ArrayAdapter adapter7 = new ArrayAdapter(getActivity(),android.R.layout.simple_spinner_item,nameList);
        spin8.setAdapter(adapter7);


        ((AppCompatActivity) getActivity()).getSupportActionBar().show();

        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("ด้านสมรรถนะหลักและสมรรถภาพทั่วไป");

        view.findViewById(R.id.bbbtn2).setOnClickListener(this);

        sharedPreferences = getActivity().getSharedPreferences(Fragment_login.MyPer, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        dep_id = sharedPreferences.getString(Fragment_login.KEY_dep_id,null);
        memberId = sharedPreferences.getString(Fragment_AF_dd.KEY_STD_ID,"");




        return view;
    }





    OnNetworkCallback_DD_P2 onCallbackList = new OnNetworkCallback_DD_P2() {
        @Override
        public void onResponse(POJO_DD_P2 status) {
            Toast.makeText(context, "บันทึกข้อมูลสำเร็จ", Toast.LENGTH_SHORT).show();
            if(progressDialog.isShowing()){
                progressDialog.dismiss();
            }

            FragmentManager fragmentManager =getActivity().getSupportFragmentManager();
            fragmentManager.popBackStack();
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

//            Toast.makeText(context, "Err "+t.getMessage(), Toast.LENGTH_SHORT).show();
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


    private void senddata (){
        String[] tmpSpn = {spin1.getSelectedItem().toString(),spin2.getSelectedItem().toString(),spin3.getSelectedItem().toString(),
                spin4.getSelectedItem().toString(),spin5.getSelectedItem().toString(),spin6.getSelectedItem().toString(),
                spin7.getSelectedItem().toString(),spin8.getSelectedItem().toString()};

        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("Loading......");
        progressDialog.show();

        if(tmpSpn != null){
            if ((!tmpSpn[0].equals("-")) && (!tmpSpn[1].equals("-")) && (!tmpSpn[2].equals("-")) && (!tmpSpn[3].equals("-")) && (!tmpSpn[4].equals("-"))
                    && (!tmpSpn[5].equals("-")) && (!tmpSpn[6].equals("-")) && (!tmpSpn[7].equals("-")) ){
//                Toast.makeText(getContext(), ""+tmpSpn[0]
//                        +" , "+tmpSpn[1]+" , "+tmpSpn[2]+" , "+tmpSpn[3]+" , "+tmpSpn[4]+" , "+tmpSpn[5]
//                        +" , "+tmpSpn[6]+" , "+tmpSpn[7], Toast.LENGTH_SHORT).show();

                new NetworkConnectionManager().callServer_dd_p2(onCallbackList,Integer.parseInt(memberId),Integer.parseInt(tmpSpn[0]),Integer.parseInt(tmpSpn[1]),Integer.parseInt(tmpSpn[2]),Integer.parseInt(tmpSpn[3])
                        ,Integer.parseInt(tmpSpn[4]),Integer.parseInt(tmpSpn[5]),Integer.parseInt(tmpSpn[6]),Integer.parseInt(tmpSpn[7]));
            }else {
                Toast.makeText(getContext(),"กรุณากรอกให้ครบ",Toast.LENGTH_SHORT).show();
                if(progressDialog.isShowing()){
                    progressDialog.dismiss();
                }
            }


        }else {
            Toast.makeText(getContext(), "wrong", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bbbtn2:

                senddata ();
                break;
        }

    }

}
