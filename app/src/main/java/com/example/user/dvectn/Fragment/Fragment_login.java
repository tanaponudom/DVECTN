package com.example.user.dvectn.Fragment;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.user.dvectn.R;
import com.example.user.dvectn.RecycelViewPack.Fragment_Student_Recycel;
import com.example.user.dvectn.RecycelViewPack.Fragment_Teacher_Recycle;
import com.example.user.dvectn.RecycelViewPack.Fragment_Teacher_Trainer;
import com.example.user.dvectn.Retrofit.Login;
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
    ProgressDialog progressDialog;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.login_layout,container,false);
        ImageView img = view.findViewById(R.id.imgif_naja);
        view.findViewById(R.id.btn_login).setOnClickListener(this);
        et_user = view.findViewById(R.id.et_user);
        et_pass = view.findViewById(R.id.et_pass);

        img.setImageDrawable(getResources().getDrawable(R.drawable.logo2));

        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();

        return view;

    }

        private void login(){

        str_user = et_user.getText().toString();
        str_pass = et_pass.getText().toString();
//        Toast.makeText(getContext(), ""+str_user+str_pass, Toast.LENGTH_SHORT).show();
//        new NetworkConnectionManager().callServerLogin(listener,str_user,str_pass);


//        new NetworkConnectionManager().callServerLogin(onNetworkCallbackLoginListener,str_user,str_pass);

        if (str_user.equals("admin") && str_pass.equals("1234"))
        {

            Fragment_mainapp sec=new Fragment_mainapp();
            Bundle bundle = new Bundle();
            bundle.putString(TAG_user,str_user);

            replaceFragment(sec ,bundle);
//            getActivity().getSupportFragmentManager().beginTransaction().add(R.id.content,sec,"ีsec").commit();

        }
          else if (str_user.equals("admin") && str_pass.equals("12345"))

        {
              Fragment_Student sec =new Fragment_Student();
              Bundle bundle = new Bundle();
              bundle.putString(TAG_user,str_user);

              replaceFragment(sec ,bundle);

        }
        else if (str_user.equals("2")&& str_pass.equals("2")){


            Fragment_Student_Recycel sec = new Fragment_Student_Recycel();
            Bundle bunble = new Bundle();
            bunble.putString(TAG_user,str_user);

            replaceFragment(sec,bunble);
        }
        else  if (str_user.equals("3") && str_pass.equals("3")){

            Fragment_Teacher_Recycle sec = new Fragment_Teacher_Recycle();
            Bundle bundle = new Bundle();
            bundle.putString(TAG_user,str_user);

            replaceFragment(sec,bundle);
        }
        else  if (str_user.equals("4") && str_pass.equals("4")){

            Fragment_Teacher_Trainer sec = new Fragment_Teacher_Trainer();
            Bundle bundle = new Bundle();
            bundle.putString(TAG_user,str_user);

            replaceFragment(sec,bundle);
        }

    }

//    OnNetworkCallbackLoginListener listener = new OnNetworkCallbackLoginListener() {
//        @Override
//        public void onResponse(Login loginRes) {
//
//
//
//            Fragment_mainapp sec =new Fragment_mainapp();
//            Bundle bundle = new Bundle();
//            bundle.putString(TAG_user,loginRes.getAccesstoken());
//            Toast.makeText(getContext(), ""+loginRes.getAccesstoken(), Toast.LENGTH_SHORT).show();
//            replaceFragment(sec,bundle);
//
//            if(progressDialog.isShowing()){
//                progressDialog.dismiss();
//            }
//
//
//        }
//
//        @Override
//        public void onBodyError(ResponseBody responseBodyError) {
//
//            Log.e("onBodyError",""+responseBodyError);
//            if(progressDialog.isShowing()){
//                progressDialog.dismiss();
//            }
//
//        }
//
//        @Override
//        public void onBodyErrorIsNull() {
//            Log.e("onBodyErrorIsNull","Data is Null");
//            if(progressDialog.isShowing()){
//                progressDialog.dismiss();
//            }
//
//        }
//
//        @Override
//        public void onFailure(Throwable t) {
//            Log.e("onFailure",t.getMessage());
//
//            if(progressDialog.isShowing()){
//                progressDialog.dismiss();
//            }
//
//
//        }
//    };

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
//            showDialog("Hello");

//                showLoading();
                    login();

                break;
        }
    }
}
