package com.example.user.dvectn.RecycelViewPack;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.user.dvectn.Fragment.Fragment_login;
import com.example.user.dvectn.Fragment.Teacher_layout_save;
import com.example.user.dvectn.Fragment.Teacher_spy_save;
import com.example.user.dvectn.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 7/3/2561.
 */

public class Fragment_Teacher_Recycle extends Fragment {
    String str_tch;
    //List<String> Data_th;
    List<String> Data_url_th;
    RecyclerView recyclerView5;
    RecycleViewAdapter5teacher recycleViewAdapter5;
    String nameList[] = {"-","1","2","3","4","5"};
    String nameList2[] = {"-","1","2","3","4","5"};
    String nameList3[] = {"-","1","2","3","4","5"};
    List<String> Data_name1;
    List<String> Data_name2;
    List<String> Data_name3;
    Button bbb;
    Spinner spn_name_stu1,spn_name_stu31,spn_name_stu41 ;
    ArrayAdapter adp2;
    public static final String TAG_TCH ="TCH";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View viewtch = inflater.inflate(R.layout.teacher_layout,container,false);
//        str_tch = bd_tch.getString(Fragment_login.TAG_user);


//        str_tch = bd_tch.getString(Fragment_login.TAG_user);


        ((AppCompatActivity) getActivity()).getSupportActionBar().show();
        showdawaefah(viewtch);


//        FloatingActionButton fab1 = viewtch.findViewById(R.id.fab1);
//        fab1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                switch (view.getId()){
//                    case R.id.fab1:
//                        Bundle bgh = new Bundle();
//                        bgh.putString(TAG_TCH,"147258");
//
//                        Snackbar.make(view, "โปรดกรอกข้อมูล", Snackbar.LENGTH_LONG)
//                                .setAction("Action", null).show();
//
//                        Teacher_layout_save fragment_Teacher_Recycle = new Teacher_layout_save();
//                        fragment_Teacher_Recycle.setArguments(bgh);
//                        replaceFragment(fragment_Teacher_Recycle,bgh);
//                        break;
//                }
//            }
//        });

        return viewtch;



    }
    private void showdawaefah(View view) {


        Data_name1 = new ArrayList<>();
        Data_name2 = new ArrayList<>();
        Data_name3 = new ArrayList<>();
//        Data_url_th = new ArrayList<>();




        Data_name1.add("นาย อักษรขจร รถผ่าน");
        Data_name2.add("นางสาว ประวิทย์ ฉลาดจุง");
        Data_name3.add("นาย ประหยัด จันทร์อังคารพุธ");
//      Data_url_th.add("https://images.pexels.com/photos/52710/matterhorn-zermatt-switzerland-snow-52710.jpeg?w=940&h=650&auto=compress&cs=tinysrgb");


        adp2 = new ArrayAdapter(getContext(),android.R.layout.simple_dropdown_item_1line ,nameList);
        adp2 = new ArrayAdapter(getContext(),android.R.layout.simple_dropdown_item_1line ,nameList2);
        adp2 = new ArrayAdapter(getContext(),android.R.layout.simple_dropdown_item_1line ,nameList3);
        recyclerView5 = view.findViewById(R.id.LV_th_1);

        recycleViewAdapter5 = new RecycleViewAdapter5teacher(getContext());
        //Toast.makeText(getContext(), ""+Data_th.size(), Toast.LENGTH_SHORT).show();

        recycleViewAdapter5.Dataname(Data_name1,Data_name2,Data_name3,adp2);
        recyclerView5.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView5.setHasFixedSize(true);
        recyclerView5.setAdapter(recycleViewAdapter5);
    }


    public void replaceFragment(Fragment fragment, Bundle bundle) {

        if (bundle != null)
            fragment.setArguments(bundle);

        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction frgTran = fragmentManager.beginTransaction();
        frgTran.replace(R.id.content,fragment).addToBackStack(null).commit();


    }


}





