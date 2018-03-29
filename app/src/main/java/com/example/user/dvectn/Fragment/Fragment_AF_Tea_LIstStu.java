package com.example.user.dvectn.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.user.dvectn.R;
import com.example.user.dvectn.RecycelViewPack.Fragment_Teacher_Trainer;

public class Fragment_AF_Tea_LIstStu extends Fragment {


    String [] chataterNaJa ={ "ร้าน พี พาวเวอร์","ร้าน ท็อบวิวพอย์","ศาลากลางจังหวัด" };
    Context context;

    String scoreTmp="";
    public static final String TAG_OHNOTH = "OHNOTH";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v4 =inflater.inflate(R.layout.af_tea_sta_teainer,container,false);
        ListView listView =(ListView) v4.findViewById(R.id.list_af_th_stu);
        context = getContext();

        ArrayAdapter ListViewAdapter = new ArrayAdapter(getContext(),android.R.layout.simple_list_item_1,chataterNaJa);
        listView.setAdapter(ListViewAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                Toast.makeText(getContext(), "Item Click", Toast.LENGTH_SHORT);


                Fragment_Teacher_Trainer teacher_layout = new Fragment_Teacher_Trainer();
                replaceFragment(teacher_layout, null);



            }
        });

        return v4;
    }

    public void replaceFragment(Fragment fragment, Bundle bundle) {

        if (bundle != null)
            fragment.setArguments(bundle);

        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction frgTran = fragmentManager.beginTransaction();
        frgTran.replace(R.id.content,fragment).addToBackStack(null).commit();

    }




}

