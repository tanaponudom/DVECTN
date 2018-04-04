package com.example.user.dvectn.Fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.user.dvectn.POJO.POJO_AF_teacher;
import com.example.user.dvectn.POJO.POJO_Stu_naja_gogo;
import com.example.user.dvectn.POJO.POJO_getstu;
import com.example.user.dvectn.R;
import com.example.user.dvectn.RecycelViewPack.Fragment_Teacher_Recycle;
import com.example.user.dvectn.Retrofit.NetworkConnectionManager;
import com.example.user.dvectn.Retrofit.OnNetworkCallBackGetStd;
import com.example.user.dvectn.Retrofit.OnNetworkCallback_AF_teacher;
import com.example.user.dvectn.Retrofit.OnNetworkCallback_Stu_naja_gogo;

import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;

/**
 * Created by Praipran on 3/21/2018.
 */

public class Fragment_AF_Teacherlayout2 extends Fragment {



    Context context;
    ArrayAdapter ListViewAdapter;
    ProgressDialog progressDialog;
    List<String> nameStd;
    List<String> idStd;
    List<String> list_dep_id;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String dep_id = "";
    int suppvision = -1;

    ListView listView;

    public static final String KEY_STD_ID = "id_std_res";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v4 =inflater.inflate(R.layout.af_teacher_layout,container,false);



        listView = v4.findViewById(R.id.list_af_th);
        nameStd = new ArrayList<>();
        list_dep_id = new ArrayList<>();
        idStd = new ArrayList<>();
        context = getContext();

        sharedPreferences = getActivity().getSharedPreferences(Fragment_login.MyPer, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        suppvision = sharedPreferences.getInt(Fragment_login.KEY_SUPERVISION,-1);

        dep_id = ""+sharedPreferences.getInt(Fragment_login.KEY_member_id,0);

//        Toast.makeText(context, "dep = "+dep_id+" sp = "+suppvision, Toast.LENGTH_SHORT).show();

        getStd();
        return v4;
    }
    private  void getStd(){

        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("Loading......");
        progressDialog.show();

        new NetworkConnectionManager().callSrever_AF_teacher(onCallbackList,dep_id);


//        ArrayAdapter
    }

    OnNetworkCallback_AF_teacher onCallbackList = new OnNetworkCallback_AF_teacher() {
        @Override
        public void onResponse(List<POJO_AF_teacher> af_teacher) {
//            Toast.makeText(context, ""+af_teacher.get(0).getMemberId(), Toast.LENGTH_SHORT).show();
            if(progressDialog.isShowing()){
                progressDialog.dismiss();
            }

            for (int i = 0; i<af_teacher.size() ;i++){

                list_dep_id.add(af_teacher.get(i).getDepId());
                nameStd.add(af_teacher.get(i).getName());

            }

            ListViewAdapter = new ArrayAdapter(context,android.R.layout.simple_list_item_1,nameStd);
            listView.setAdapter(ListViewAdapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

//                    Toast.makeText(context, ""+idStd.get(position), Toast.LENGTH_SHORT).show();
                    editor.putString(Fragment_login.KEY_dep_id,list_dep_id.get(position));
                    editor.putString(KEY_STD_ID,nameStd.get(position));
                    editor.commit();

                    replaceFragment(new Fragment_Teacher_Recycle(),null);

                }
            });


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

