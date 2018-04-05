package com.example.user.dvectn.RecycelViewPack;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.user.dvectn.Fragment.Fragment_login;
import com.example.user.dvectn.Fragment.Student_save;
import com.example.user.dvectn.MainActivity;
import com.example.user.dvectn.POJO.POJOGetDaily;
import com.example.user.dvectn.POJO.POJO_Stu_naja;
import com.example.user.dvectn.R;
import com.example.user.dvectn.Retrofit.NetworkConnectionManager;
import com.example.user.dvectn.Retrofit.OnNetworkCallback_GetStdDaily;
import com.example.user.dvectn.Retrofit.OnNetworkCallback_Stu_naja;

import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;

/**
 * Created by User on 7/3/2561.
 */

public class Fragment_Student_Recycel extends Fragment {
    RecyclerView recyclerView;
    RecycleViewAdapter1 recycleViewAdapter;
    List<String> Data_St;
    List<String> Data_Url;
    String frg_st;
    String dep_id = "";
    int memberId = 0;
    SharedPreferences.Editor editor;
    SharedPreferences sharedPreferences;
    Context context;

    public  static  final String TAG_STU = "DENT";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View viewtt = inflater.inflate(R.layout.student_page, container, false);


        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();

        context = getContext();

        sharedPreferences = getActivity().getSharedPreferences(Fragment_login.MyPer, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        dep_id = sharedPreferences.getString(Fragment_login.KEY_dep_id,null);

        FloatingActionButton fab = viewtt.findViewById(R.id.fab);
        FloatingActionButton fab1 = viewtt.findViewById(R.id.fab12);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {

                    case R.id.fab:
                        Bundle bnq = new Bundle();
                        bnq.putString(TAG_STU, "11587");
//                        ส่วนภายใน Fragment
                        Snackbar.make(view, "โปรดกรอกข้อมูล", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();

                        Student_save student_save = new Student_save();
                        student_save.setArguments(bnq);
                        replaceFragment(student_save, bnq);
                        break;





                }
            }

        });

        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {

                    case R.id.fab12:

                        Logout();

//                        Fragment_login fragment_login = new Fragment_login();
//                        fragment_login.setArguments(null);
//                        replaceFragment(fragment_login,null);

                        break;
                }
            }

        });

        memberId = sharedPreferences.getInt(Fragment_login.KEY_member_id,0);

        recyclerView = viewtt.findViewById(R.id.LV_st_1);

        Data_St = new ArrayList<>();
        Data_Url = new ArrayList<>();
        new NetworkConnectionManager().callServer_stu_naja(onCallbackList,""+ memberId);


        return viewtt;
    }

    OnNetworkCallback_Stu_naja onCallbackList = new OnNetworkCallback_Stu_naja() {


        @Override
        public void onResponse(List<POJO_Stu_naja> stu_naja) {

            for (int i = 0; i< stu_naja.size() ;i++){
                  Data_St.add(stu_naja.get(i).getAppDetail());
                  Data_Url.add(stu_naja.get(i).getImgurl());
            }

            recycleViewAdapter = new RecycleViewAdapter1(getContext());

            recycleViewAdapter.Update_Data(Data_St,Data_Url);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            recyclerView.setHasFixedSize(true);
            recyclerView.setAdapter(recycleViewAdapter);

        }


        @Override
        public void onBodyError(ResponseBody responseBodyError) {
            Toast.makeText(context, "responseBodyError", Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onBodyErrorIsNull() {

            Toast.makeText(context, "res is null", Toast.LENGTH_SHORT).show();


        }

        @Override
        public void onFailure(Throwable t) {

            Toast.makeText(context, "Err "+t.getMessage(), Toast.LENGTH_SHORT).show();


        }
    };



    public void replaceFragment(Fragment fragment, Bundle bundle) {

        if (bundle != null)
            fragment.setArguments(bundle);

        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction frgTran = fragmentManager.beginTransaction();
        frgTran.replace(R.id.content,fragment).addToBackStack(null).commit();


    }

    private void Logout(){

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("คำเตือน");
        builder.setMessage("คุณต้องการออกจากระบบ ?");

        builder.setPositiveButton("ตกลง", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                fragmentManager.popBackStack(null,FragmentManager.POP_BACK_STACK_INCLUSIVE);
//                fragmentManager.popBackStack();

                Fragment_login fragment_login = new Fragment_login();
                replaceFragment(fragment_login,null);


            }
        });

        builder.setNegativeButton("ยกเลิก", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.show();
    }


}

