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
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.user.dvectn.POJO.POJO_getstu;
import com.example.user.dvectn.R;
import com.example.user.dvectn.RecycelViewPack.Fragment_bt_ag;
import com.example.user.dvectn.Retrofit.NetworkConnectionManager;
import com.example.user.dvectn.Retrofit.OnNetworkCallBackGetStd;

import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;

/**
 * Created by Praipran on 3/21/2018.
 */

public class Fragment_AF_pj extends Fragment {


    String [] chataterNaJa ={ "นาย อักษรขจร รถผ่าน","นางสาว ประวิทย์ ฉลาดจุง","นาย ประหยัด จันทร์อังคารพุธ" };

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String dep_id = "";
    Context context;
    ListView listView;
    public static final String TAG_OHNOPJ = "OHNOPJ";
    ArrayAdapter ListViewAdapter;
    ProgressDialog progressDialog;
    List<String> nameStd;
    List<String> idStd;
    public static final String KEY_STD_ID = "id_std_res";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v4 =inflater.inflate(R.layout.af_pj_list,container,false);


        listView = v4.findViewById(R.id.list_af_pj);
        nameStd = new ArrayList<>();
        idStd = new ArrayList<>();

        context = getContext();

        //init session
        sharedPreferences = getActivity().getSharedPreferences(Fragment_login.MyPer, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        dep_id = sharedPreferences.getString(Fragment_login.KEY_dep_id,null);
//        Toast.makeText(context, ""+dep_id, Toast.LENGTH_SHORT).show();

        getStd();

        return v4;
    }

    private  void getStd(){

        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("Loading......");
        progressDialog.show();

        new NetworkConnectionManager().getStudentName(onCallbackList,dep_id);


//        ArrayAdapter
    }


    OnNetworkCallBackGetStd onCallbackList = new OnNetworkCallBackGetStd() {
        @Override
        public void onResponse(List<POJO_getstu> getstu) {

            if(progressDialog.isShowing()){
                progressDialog.dismiss();
            }

            for (int i = 0; i<getstu.size() ;i++){

                idStd.add(getstu.get(i).getId());
                nameStd.add(getstu.get(i).getFirstname()+" "+getstu.get(i).getLastnamename());

            }

            ListViewAdapter = new ArrayAdapter(getContext(),android.R.layout.simple_list_item_1,nameStd);
            listView.setAdapter(ListViewAdapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

//                    Toast.makeText(context, ""+idStd.get(position), Toast.LENGTH_SHORT).show();
                    editor.putString(KEY_STD_ID,idStd.get(position));
                    editor.commit();

                    replaceFragment(new Fragment_bt_pj() ,null);


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
}