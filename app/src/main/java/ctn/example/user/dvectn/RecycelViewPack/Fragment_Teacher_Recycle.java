package ctn.example.user.dvectn.RecycelViewPack;

import android.app.ProgressDialog;
import android.content.Context;
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
import android.widget.Spinner;
import android.widget.Toast;

import ctn.example.user.dvectn.Fragment.Fragment_AF_Teacherlayout;
import ctn.example.user.dvectn.Fragment.Fragment_AF_Teacherlayout2;
import ctn.example.user.dvectn.Fragment.Fragment_login;
import ctn.example.user.dvectn.POJO.POJO_Stu_naja_gogo;
import ctn.example.user.dvectn.Retrofit.NetworkConnectionManager;
import ctn.example.user.dvectn.Retrofit.OnNetworkCallback_Stu_naja_gogo;

import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;

/**
 * Created by User on 7/3/2561.
 */

public class Fragment_Teacher_Recycle extends Fragment {

    String str_tch;
    List<String> Data_url_th;
    RecyclerView recyclerView5;
    RecycleViewAdapter5teacher recycleViewAdapter5;
    String nameList[] = {"-","1","2","3","4","5","6","7","8","9","10"};
    List<String> Data_name;
    List<String> Data_name1;
    List<String> Data_name2;
    List<String> Data_score;
    List<Integer> Data_member_ID;
    List<Integer> score;
    ArrayAdapter adp2;
    Context context;
    String dep_id = "8";
    int suppvision = -1;
    int memberId = 0;
    int spn  = -1;
    SharedPreferences.Editor editor;
    ProgressDialog progressDialog;
    SharedPreferences sharedPreferences;

    Spinner spn1;
    public static final String TAG_TCH ="TCH";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View viewtch = inflater.inflate(ctn.example.user.dvectn.R.layout.teacher_layout,container,false);
//        str_tch = bd_tch.getString(Fragment_login.TAG_user);
        context = getContext();

        sharedPreferences = getActivity().getSharedPreferences(Fragment_login.MyPer, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        dep_id = sharedPreferences.getString(Fragment_login.KEY_dep_id,null);
        suppvision = sharedPreferences.getInt(Fragment_login.KEY_SUPERVISION,-1);
//        Toast.makeText(context, ""+suppvision, Toast.LENGTH_SHORT).show();

        memberId = sharedPreferences.getInt(Fragment_login.KEY_member_id,0);
        spn = sharedPreferences.getInt(Fragment_login.KEY_SUPERVISION,-1);

//        str_tch = bd_tch.getString(Fragment_login.TAG_user);

        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();


        recyclerView5 = viewtch.findViewById(ctn.example.user.dvectn.R.id.LV_th_1);

        Data_name = new ArrayList<>();
        Data_name1 = new ArrayList<>();
        Data_name2 = new ArrayList<>();
        Data_score = new ArrayList<>();
        Data_member_ID = new ArrayList<>();

//        Toast.makeText(context, ""+suppvision, Toast.LENGTH_SHORT).show();

//        progressDialog = new ProgressDialog(context);
//        progressDialog.setMessage("Loading......");
//        progressDialog.show();


//        Toast.makeText(context, ""+suppvision, Toast.LENGTH_SHORT).show();
        new NetworkConnectionManager().callServer_stu_naja_gogo(onCallbackList,dep_id,suppvision);
//        new NetworkConnectionManager().callServer_row_teacher(onCallbackList2,score);


//        Toast.makeText(context, ""+Data_name, Toast.LENGTH_SHORT).show();

        return viewtch;



    }
//    OnNetworkCallback_row_teacher onCallbackList2 =new OnNetworkCallback_row_teacher() {
//        @Override
//        public void onResponse(POJO_row_teacher save_nite) {
//
//        }
//
//        @Override
//        public void onBodyError(ResponseBody responseBodyError) {
//
//        }
//
//        @Override
//        public void onBodyErrorIsNull() {
//
//        }
//
//        @Override
//        public void onFailure(Throwable t) {
//
//        }
//    };

    OnNetworkCallback_Stu_naja_gogo onCallbackList = new OnNetworkCallback_Stu_naja_gogo() {
        @Override
        public void onResponse(List<POJO_Stu_naja_gogo> stu_naja_gogo) {

//            if(progressDialog.isShowing()){
//                progressDialog.dismiss();
//            }

//                Toast.makeText(context, ""+stu_naja_gogo.size(), Toast.LENGTH_SHORT).show();

            for (int i = 0; i< stu_naja_gogo.size() ;i++){


//                Data_name1.add(stu_naja_gogo.get(i).getFirstname());
//                Data_name2.add(getstu.get(i).getLastnamename());
                Data_member_ID.add(Integer.parseInt(stu_naja_gogo.get(i).getMemberId()));

                Data_score.add(stu_naja_gogo.get(i).getScore());
                Data_name.add(stu_naja_gogo.get(i).getFirstname()+"\t"+stu_naja_gogo.get(i).getLastnamename());

            }

            showdawaefah(recyclerView5);

//            adp2 =  new ArrayAdapter(context,android.R.layout.simple_spinner_dropdown_item,nameList);

            recycleViewAdapter5.Dataname(Data_name,Data_score,Data_member_ID,spn,adp2);
            recyclerView5.setLayoutManager(new LinearLayoutManager(getContext()));
            recyclerView5.setHasFixedSize(true);
            recyclerView5.setAdapter(recycleViewAdapter5);


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
    private void showdawaefah(View view) {



//        Data_url_th = new ArrayList<>();



//      Data_url_th.add("https://images.pexels.com/photos/52710/matterhorn-zermatt-switzerland-snow-52710.jpeg?w=940&h=650&auto=compress&cs=tinysrgb");


        adp2 = new ArrayAdapter(getContext(),android.R.layout.simple_spinner_dropdown_item ,nameList);

        recyclerView5 = view.findViewById(ctn.example.user.dvectn.R.id.LV_th_1);

        recycleViewAdapter5 = new RecycleViewAdapter5teacher(getContext());
        //Toast.makeText(getContext(), ""+Data_th.size(), Toast.LENGTH_SHORT).show();



    }


    public void replaceFragment(Fragment fragment, Bundle bundle) {

        if (bundle != null)
            fragment.setArguments(bundle);

        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction frgTran = fragmentManager.beginTransaction();
        frgTran.replace(ctn.example.user.dvectn.R.id.content,fragment).addToBackStack(null).commit();


    }


}





