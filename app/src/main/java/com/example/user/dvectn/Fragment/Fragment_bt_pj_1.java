package com.example.user.dvectn.Fragment;

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
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.example.user.dvectn.POJO.POJO_PJ_P1;
import com.example.user.dvectn.POJO.POJO_getstu;
import com.example.user.dvectn.R;
import com.example.user.dvectn.Retrofit.NetworkConnectionManager;
import com.example.user.dvectn.Retrofit.OnNetworkCallBackGetStd;
import com.example.user.dvectn.Retrofit.OnNetworkCallback_PJ_P1;

import java.util.List;

import okhttp3.ResponseBody;

/**
 * Created by User on 20/2/2561.
 */

public class Fragment_bt_pj_1 extends Fragment implements OnClickListener{
    String frg;
    Button btn_confirm;
    String dep_id = "";
    List<String> nameStd;
    List<String> idStd;
    SharedPreferences.Editor editor;
    ProgressDialog progressDialog;
    SharedPreferences sharedPreferences;
    Context context;

    //checkbox
     CheckBox CB1,CB2,CB3,CB4;


    int memberId = 0,
            ex11_tmp = -1 ,
            ex12_tmp = -1 ;

    public static final String TAG_KONAMI = "KOKO";
    public static final String KEY_pjp1_ID = "id_pjp1_res";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.av_bt_pj_1, container, false);
        context = getContext();

        CB1 = view.findViewById(R.id.CB1);
        CB1.setChecked(false);

        CB2 = view.findViewById(R.id.CB2);
        CB2.setChecked(false);

        CB3 = view.findViewById(R.id.CB3);
        CB3.setChecked(false);

         CB4 = view.findViewById(R.id.CB4);
        CB4.setChecked(false);


        view.findViewById(R.id.CB1).setOnClickListener(this);
        view.findViewById(R.id.CB2).setOnClickListener(this);
        view.findViewById(R.id.CB3).setOnClickListener(this);
        view.findViewById(R.id.CB4).setOnClickListener(this);

        view.findViewById(R.id.btn_confirm).setOnClickListener(this);

        ((AppCompatActivity) getActivity()).getSupportActionBar().show();

        sharedPreferences = getActivity().getSharedPreferences(Fragment_login.MyPer, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        dep_id = sharedPreferences.getString(Fragment_login.KEY_dep_id,null);
        memberId = sharedPreferences.getInt(Fragment_login.KEY_member_id,0);
//        Toast.makeText(context, ""+dep_id, Toast.LENGTH_SHORT).show();

//        getStd();

        return view;


    }

    private  void ConfirmEx(int ex11,int ex12){

        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("Loading......");
        progressDialog.show();

        if(memberId > 0 ){
            new NetworkConnectionManager().callServer_pj_p1(onCallbackList,memberId,ex11,ex12);
        }else {
            Toast.makeText(context, "กรุราตรวจสอบข้อมูล", Toast.LENGTH_SHORT).show();
            if(progressDialog.isShowing()){
                progressDialog.dismiss();
            }
        }

//        ArrayAdapter
    }
    OnNetworkCallback_PJ_P1 onCallbackList = new OnNetworkCallback_PJ_P1() {
        @Override
        public void onResponse(POJO_PJ_P1 getstu) {
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


    @Override
    public void onClick(View v) {
    switch (v.getId()){
        case R.id.CB1:
            ex11_tmp = 1;
            CB2.setChecked(false);
            break;
        case R.id.CB2:
             ex11_tmp = 2;
             CB1.setChecked(false);
            break;
        case R.id.CB3:
            ex12_tmp = 1;
            CB4.setChecked(false);
            break;
        case R.id.CB4:
            ex12_tmp = 2;
            CB3.setChecked(false);
            break;
        case R.id.btn_confirm:

            if(ex11_tmp != -1 && ex12_tmp != -1 && (CB1.isChecked() || CB2.isChecked()) && (CB3.isChecked() || CB4.isChecked())  ){
                ConfirmEx(ex11_tmp,ex12_tmp);

            }


            else {
                Toast.makeText(context, "กรุณาเลือกข้อมูล", Toast.LENGTH_SHORT).show();
            }
            break;
    }

    }
}




