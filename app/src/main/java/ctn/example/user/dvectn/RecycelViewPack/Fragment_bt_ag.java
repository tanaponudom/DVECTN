package ctn.example.user.dvectn.RecycelViewPack;

import android.app.DatePickerDialog;
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
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;


import ctn.example.user.dvectn.Fragment.Fragment_login;
import ctn.example.user.dvectn.POJO.POJO_confirm_AG;
import ctn.example.user.dvectn.R;
import ctn.example.user.dvectn.Retrofit.NetworkConnectionManager;
import ctn.example.user.dvectn.Retrofit.OnNetworkCallback_confirm_AG;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import okhttp3.ResponseBody;

/**
 * Created by User on 20/2/2561.
 */

public class Fragment_bt_ag extends Fragment {


    RecyclerView recycleView6;
    RecycleViewAdapter2 recycleViewAdapter6;
    List<String> Data_flstr;
    List<String> Data_member_ID;
    List<String> Data_dep_id;
    List<Integer> Data_state;

    List<String> Data_img;
    List<String> Data_detail;
    List<String> Data_score;

    View view;
    Calendar myCalendar;
    TextView tv_date;
    Button btnSelectDate;
    Context context;
    String dep_id = "";
    SharedPreferences.Editor editor;
    ProgressDialog progressDialog;
    SharedPreferences sharedPreferences;
    int memberId = 0;
    public static final String TAG_KAW = "KAW";
    String userType = "";
    String myFormat = "yyyy-MM-dd"; //In which you need put here


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view2 = inflater.inflate(ctn.example.user.dvectn.R.layout.av_bt_ag, container, false);
        context = getContext();

        tv_date = view2.findViewById(R.id.tv_datetime);
        tv_date.setText(datenow());
        myCalendar = Calendar.getInstance();
        btnSelectDate = view2.findViewById(R.id.btnSelectDate);
        btnSelectDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(getContext(), date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        sharedPreferences = getActivity().getSharedPreferences(Fragment_login.MyPer, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();


        userType = sharedPreferences.getString(Fragment_login.KEY_member_type,null);
        dep_id = sharedPreferences.getString(Fragment_login.KEY_dep_id,null);
//        Toast.makeText(context, ""+dep_id, Toast.LENGTH_SHORT).show();
        memberId = sharedPreferences.getInt(Fragment_login.KEY_member_id,0);

        recycleView6 = view2.findViewById(ctn.example.user.dvectn.R.id.LV_str_naja);


        Data_flstr = new ArrayList<>();
        Data_state = new ArrayList<>();
        Data_member_ID = new ArrayList<>();
        Data_dep_id = new ArrayList<>();

        Data_img = new ArrayList<>();
        Data_detail = new ArrayList<>();
        Data_score = new ArrayList<>();

        recycleViewAdapter6 = new RecycleViewAdapter2(getContext());

        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();

        new NetworkConnectionManager().callSrever_confirm_AG(onCallbackList,Integer.parseInt(dep_id));

        return view2;
    }

    DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            // TODO Auto-generated method stub
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, monthOfYear);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            sendData();
        }

    };

    private String datenow() {
        DateFormat dateFormat = new SimpleDateFormat(myFormat);
        Date date = new Date();
        return dateFormat.format(date);
    }

    private void sendData() {


        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, new Locale("th", "TH"));

        tv_date.setText(sdf.format(myCalendar.getTime()));

    }

    OnNetworkCallback_confirm_AG onCallbackList = new OnNetworkCallback_confirm_AG() {
        @Override
        public void onResponse(List<POJO_confirm_AG> getstu) {


            for (int i = 0; i< getstu.size() ;i++){


                Data_dep_id.add(getstu.get(i).getMemberId());
                Data_member_ID.add(getstu.get(i).getMemberId());

                Data_flstr.add(getstu.get(i).getFirstname()+"\t"+getstu.get(i).getLastname());

                Data_detail.add(getstu.get(i).getDetail());
                Data_score.add(getstu.get(i).getScore());
                Data_img.add(getstu.get(i).getImg());

                Data_state.add(i);

            }




            recycleViewAdapter6.Update_teacher_data(Data_flstr,Data_state,Data_img,Data_detail,Data_score,Data_member_ID,userType);
            recycleView6.setLayoutManager(new LinearLayoutManager(getContext()));
            recycleView6.setHasFixedSize(true);
            recycleView6.setAdapter(recycleViewAdapter6);

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
        frgTran.replace(ctn.example.user.dvectn.R.id.content,fragment).addToBackStack(null).commit();


    }



}
