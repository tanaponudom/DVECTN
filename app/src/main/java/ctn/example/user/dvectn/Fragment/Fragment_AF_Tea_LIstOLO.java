package ctn.example.user.dvectn.Fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import ctn.example.user.dvectn.POJO.POJO_trainer;
import ctn.example.user.dvectn.RecycelViewPack.Fragment_Teacher_Trainer;
import ctn.example.user.dvectn.Retrofit.NetworkConnectionManager;
import ctn.example.user.dvectn.Retrofit.OnNetworkCallback_trainer;

import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;

public class Fragment_AF_Tea_LIstOLO extends Fragment {

    String [] chataterNaJa ={ "ร้าน พี พาวเวอร์","ร้าน ท็อบวิวพอย์","ศาลากลางจังหวัด" };
    Context context;
    ArrayAdapter ListViewAdapter;
    ProgressDialog progressDialog;
    List<String> namestore;
    List<String> dep_id_list;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String dep_id = "";
    ListView listView;
    public static final String TAG_OHNOTH = "OHNOTH";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v4 =inflater.inflate(ctn.example.user.dvectn.R.layout.af_teacher_trainer,container,false);
        listView =(ListView) v4.findViewById(ctn.example.user.dvectn.R.id.list_af_th_OLO);
        context = getContext();

//        ArrayAdapter ListViewAdapter = new ArrayAdapter(getContext(),android.R.layout.simple_list_item_1,n);
        listView.setAdapter(ListViewAdapter);


        namestore = new ArrayList<>();
        dep_id_list = new ArrayList<>();


        sharedPreferences = getActivity().getSharedPreferences(Fragment_login.MyPer, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        dep_id = sharedPreferences.getString(Fragment_login.KEY_dep_id,null);

        getStd();

//        Toast.makeText(context, "Hello", Toast.LENGTH_SHORT).show();


        FloatingActionButton fab = v4.findViewById(ctn.example.user.dvectn.R.id.fab7);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case ctn.example.user.dvectn.R.id.fab7:
                        Logout();
//                new CountDownTimer(3000,1000){
//                    @Override
//                    public void onTick(long millisUntilFinished) {
////                        Toast.makeText(context, ""+millisUntilFinished, Toast.LENGTH_SHORT).show();
//                    }
//
//                    @Override
//                    public void onFinish() {
//                        Toast.makeText(context, "Logout finish.", Toast.LENGTH_SHORT).show();
//                    }
//                }.start();
//
//                }
                }
            }

        });

        return v4;
    }

    private  void getStd(){

        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("Loading......");
        progressDialog.show();

        new NetworkConnectionManager().callSrever_trainer(onCallbackList);


//
    }

    OnNetworkCallback_trainer onCallbackList = new OnNetworkCallback_trainer() {
        @Override
        public void onResponse(List<POJO_trainer> trainer) {
//            Toast.makeText(context, ""+af_teacher.get(0).getMemberId(), Toast.LENGTH_SHORT).show();
            if(progressDialog.isShowing()){
                progressDialog.dismiss();
            }


            for (int i = 0; i<trainer.size() ;i++){

                namestore.add(trainer.get(i).getName());
                dep_id_list.add(trainer.get(i).getDepId());

            }

            ListViewAdapter = new ArrayAdapter(context,android.R.layout.simple_list_item_1,namestore);
            listView.setAdapter(ListViewAdapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

//                    Toast.makeText(context, ""+dep_id_list.get(position), Toast.LENGTH_SHORT).show();
                    editor.putString(Fragment_login.KEY_dep_id,dep_id_list.get(position));
                    editor.commit();
//
                    replaceFragment(new Fragment_Teacher_Trainer(),null);

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
        frgTran.replace(ctn.example.user.dvectn.R.id.content,fragment).addToBackStack(null).commit();

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