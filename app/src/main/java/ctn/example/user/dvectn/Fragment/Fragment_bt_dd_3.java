package ctn.example.user.dvectn.Fragment;

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
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import android.widget.Spinner;

import ctn.example.user.dvectn.POJO.POJO_DD_P3;
import ctn.example.user.dvectn.Retrofit.NetworkConnectionManager;
import ctn.example.user.dvectn.Retrofit.OnNetworkCallback_DD_P3;

import okhttp3.ResponseBody;

/**
 * Created by User on 20/2/2561.
 */

public class Fragment_bt_dd_3 extends Fragment implements View.OnClickListener  {

    Context context;
    ProgressDialog progressDialog;
    String frg;
    String nameList[] = {"-","1","2","3","4","5"};
    Spinner spn1, spn2 , spn3 , spn4 , spn5 , spn6 , spn7 ;
    String dep_id = "";
    SharedPreferences.Editor editor;
    SharedPreferences sharedPreferences;
    public  static  final String TAG_HEW4 = "HEW4";

    String memberId = "";


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(ctn.example.user.dvectn.R.layout.av_bt_dd_3,container, false);
        context = getContext();

        spn1 = view.findViewById(ctn.example.user.dvectn.R.id.spinner14);
        ArrayAdapter adapter = new ArrayAdapter(getActivity(),android.R.layout.simple_spinner_item,nameList);
        spn1.setAdapter(adapter);

        spn2 = view.findViewById(ctn.example.user.dvectn.R.id.spinner15);
        ArrayAdapter adapter1 = new ArrayAdapter(getActivity(),android.R.layout.simple_spinner_item,nameList);
        spn2.setAdapter(adapter1);

        spn3 = view.findViewById(ctn.example.user.dvectn.R.id.spinner16);
        ArrayAdapter adapter2 = new ArrayAdapter(getActivity(),android.R.layout.simple_spinner_item,nameList);
        spn3.setAdapter(adapter2);

        spn4 = view.findViewById(ctn.example.user.dvectn.R.id.spinner17);
        ArrayAdapter adapter3 = new ArrayAdapter(getActivity(),android.R.layout.simple_spinner_item,nameList);
        spn4.setAdapter(adapter3);

        spn5 = view.findViewById(ctn.example.user.dvectn.R.id.spinner18);
        ArrayAdapter adapter4 = new ArrayAdapter(getActivity(),android.R.layout.simple_spinner_item,nameList);
        spn5.setAdapter(adapter4);

        spn6 = view.findViewById(ctn.example.user.dvectn.R.id.spinner19);
        ArrayAdapter adapter5 = new ArrayAdapter(getActivity(),android.R.layout.simple_spinner_item,nameList);
        spn6.setAdapter(adapter5);

        spn7 = view.findViewById(ctn.example.user.dvectn.R.id.spinner20);
        ArrayAdapter adapter6 = new ArrayAdapter(getActivity(),android.R.layout.simple_spinner_item,nameList);
        spn7.setAdapter(adapter6);



        ((AppCompatActivity) getActivity()).getSupportActionBar().show();
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("ด้านสมรรถนะวิชาชีพ");

        view.findViewById(ctn.example.user.dvectn.R.id.bbbtn20).setOnClickListener(this);

        sharedPreferences = getActivity().getSharedPreferences(Fragment_login.MyPer, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        dep_id = sharedPreferences.getString(Fragment_login.KEY_dep_id,null);
        memberId = sharedPreferences.getString(Fragment_AF_dd.KEY_STD_ID,"");




        return view;
    }

    OnNetworkCallback_DD_P3 onCallbackList = new OnNetworkCallback_DD_P3() {
        @Override
        public void onResponse(POJO_DD_P3 status) {
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
        frgTran.replace(ctn.example.user.dvectn.R.id.content,fragment).addToBackStack(null).commit();


    }

    private void senddata (){
        String[] tmpSpn = {spn1.getSelectedItem().toString(),spn2.getSelectedItem().toString(),spn3.getSelectedItem().toString(),
                spn4.getSelectedItem().toString(),spn5.getSelectedItem().toString(),spn6.getSelectedItem().toString(),spn7.getSelectedItem().toString()};

        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("Loading......");
        progressDialog.show();


        if(tmpSpn != null){
            if ((!tmpSpn[0].equals("-")) && (!tmpSpn[1].equals("-")) && (!tmpSpn[2].equals("-")) && (!tmpSpn[3].equals("-")) && (!tmpSpn[4].equals("-"))
                    && (!tmpSpn[5].equals("-")) && (!tmpSpn[6].equals("-")) ){

                new NetworkConnectionManager().callServer_dd_p3(onCallbackList,Integer.parseInt(memberId),Integer.parseInt(tmpSpn[0]),Integer.parseInt(tmpSpn[1]),Integer.parseInt(tmpSpn[2]),Integer.parseInt(tmpSpn[3])
                        ,Integer.parseInt(tmpSpn[4]),Integer.parseInt(tmpSpn[5]),Integer.parseInt(tmpSpn[6]));

            }else {
                Toast.makeText(getContext(),"กรุณากรอกให้ครบ",Toast.LENGTH_SHORT).show();
                if(progressDialog.isShowing()){
                    progressDialog.dismiss();}

            }


        }else {
            Toast.makeText(getContext(), "wrong", Toast.LENGTH_SHORT).show();
            if(progressDialog.isShowing()){
                progressDialog.dismiss();}
        }
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case ctn.example.user.dvectn.R.id.bbbtn20:

                senddata();
                break;


        }

    }
}
