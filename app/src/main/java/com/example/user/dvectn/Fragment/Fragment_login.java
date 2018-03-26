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
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.user.dvectn.POJO.POJO_login;
import com.example.user.dvectn.R;
import com.example.user.dvectn.RecycelViewPack.Fragment_Student_Recycel;
import com.example.user.dvectn.RecycelViewPack.Fragment_Teacher_Recycle;
import com.example.user.dvectn.RecycelViewPack.Fragment_Teacher_Trainer;
import com.example.user.dvectn.Retrofit.NetworkConnectionManager;
import com.example.user.dvectn.Retrofit.OnNetworkCallbackLoginListener;

import okhttp3.ResponseBody;

/**
 * Created by User on 19/2/2561.
 */

public class Fragment_login extends Fragment implements View.OnClickListener {
    EditText et_user,et_pass;
    String str_user,str_pass;
    public static String BASE_URL = "http://43.228.87.219/";
    public static final String TAG_user = "tokenData";
    public static final String MyPer = "myPer";
    public static final String KEY_member_id = "member_id";
    public static final String KEY_member_firstname = "member_firstname";
    public static final String KEY_member_lastname = "member_lastname";
    public static final String KEY_member_email = "member_email";
    public static final String KEY_dep_id = "dep_id";
    public static final String KEY_member_type = "member_type";

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    ProgressDialog progressDialog;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.login_layout,container,false);
        ImageView img = view.findViewById(R.id.imgif_naja);

        view.findViewById(R.id.btn_login).setOnClickListener(this);

        et_user = view.findViewById(R.id.et_user);
        et_pass = view.findViewById(R.id.et_pass);

        //init session
        sharedPreferences = getActivity().getSharedPreferences(MyPer, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

//        btn_login.setEnabled(false);

        img.setImageDrawable(getResources().getDrawable(R.drawable.logo2));

        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();

        return view;

    }

    private void login(){

        str_user = et_user.getText().toString().toUpperCase();
        str_pass = et_pass.getText().toString().toUpperCase();

     if (TextUtils.isEmpty(et_user.getText().toString().trim())|| TextUtils.isEmpty(et_pass.getText().toString().trim())){
            et_user.setError("โปรดกรอกให้ถูกต้อง");
            et_pass.setError("โปรดกรอกรหัสผ่านให้ถูกต้อง");

            if (progressDialog.isShowing()) {
                progressDialog.dismiss();
            }

        }else {

                new NetworkConnectionManager().callServerLogin(listener,str_user,str_pass);

        }


    }


    OnNetworkCallbackLoginListener listener = new OnNetworkCallbackLoginListener() {
        @Override
        public void onResponse(POJO_login loginRes) {

            editor.putString(KEY_member_id, loginRes.getMemberId());
            editor.putString(KEY_member_firstname, loginRes.getMemberFirstname());
            editor.putString(KEY_member_lastname, loginRes.getMemberLastname());
            editor.putString(KEY_member_email, loginRes.getMemberEmail());
            editor.putString(KEY_dep_id, loginRes.getDepId());
            editor.putString(KEY_member_type, loginRes.getMemberType());
            editor.commit();

//            Toast.makeText(getContext(), ""+loginRes.getDepId(), Toast.LENGTH_SHORT).show();


            String Member_Type = loginRes.getMemberType();
            Toast.makeText(getContext(), "Member type= " + Member_Type, Toast.LENGTH_SHORT).show();

            if (Member_Type.equals("establishment")) {

                Fragment_mainapp sec = new Fragment_mainapp();
                replaceFragment(sec, null);

            } else if (Member_Type.equals("student")) {

                Fragment_Student_Recycel sec = new Fragment_Student_Recycel();
                replaceFragment(sec, null);

            } else if (Member_Type.equals("teacher")) {

                Fragment_Teacher_Recycle sec = new Fragment_Teacher_Recycle();
                replaceFragment(sec, null);


            } else if (Member_Type.equals("admin")) {
                Fragment_Teacher_Trainer sec = new Fragment_Teacher_Trainer();
                replaceFragment(sec, null);

            }
                if (progressDialog.isShowing()) {
                    progressDialog.dismiss();
                }


            }


        @Override
        public void onBodyError(ResponseBody responseBodyError) {

//            Log.e("onBodyError",""+responseBodyError);
            if(progressDialog.isShowing()){
                progressDialog.dismiss();
            }

        }

        @Override
        public void onBodyErrorIsNull() {
//            Log.e("onBodyErrorIsNull","Data is Null");
            if(progressDialog.isShowing()){
                progressDialog.dismiss();
            }

        }

        @Override
        public void onFailure(Throwable t) {
//            Log.e("onFailure",t.getMessage());

            if(progressDialog.isShowing()){
                progressDialog.dismiss();
            }


        }
    };

    public void replaceFragment(Fragment fragment, Bundle bundle) {

        if (bundle != null)
            fragment.setArguments(bundle);

        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment oldFragment = fragmentManager.findFragmentByTag(fragment.getClass().getName());

        //if oldFragment already exits in fragmentManager use it
        if (oldFragment != null) {
            fragment = oldFragment;
        }

        fragmentTransaction.replace(R.id.content, fragment, fragment.getClass().getName());

        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);

        fragmentTransaction.commit();
    }

    private void showLoading(){

        progressDialog = new ProgressDialog(getContext());
        progressDialog.setIcon(R.drawable.logo2);
        progressDialog.setTitle("แจ้งเตือน");
        progressDialog.setMessage("กรุณารอสักครู่");
        progressDialog.show();
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_login:
//                Toast.makeText(getContext(), "Login", Toast.LENGTH_SHORT).show();
//            showDialog("Hello");
                showLoading();
//                showLoading();
                login();

                break;
        }
    }
}
