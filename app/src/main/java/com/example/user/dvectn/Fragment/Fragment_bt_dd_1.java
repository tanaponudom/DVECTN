package com.example.user.dvectn.Fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.user.dvectn.R;

/**
 * Created by User on 20/2/2561.
 */

public class Fragment_bt_dd_1 extends Fragment implements View.OnClickListener
{
    Bundle bn;
    String frg;
    String nameList[] = {"","1","2","3","4","5"};
    Button bbb;
    Spinner spn1, spn2 , spn3 , spn4 , spn5 ;
    public  static  final String TAG_HEW3 = "HEW3";


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.av_bt_dd_1,container, false);
        bn = getArguments();

        bbb=view.findViewById(R.id.bbbtn1);


        spn1 = view.findViewById(R.id.spinner1);
        ArrayAdapter adapter = new ArrayAdapter(getActivity(),android.R.layout.simple_spinner_item,nameList);
        spn1.setAdapter(adapter);

        spn2 = view.findViewById(R.id.spinner2);
        ArrayAdapter adapter1 = new ArrayAdapter(getActivity(),android.R.layout.simple_spinner_item,nameList);
        spn2.setAdapter(adapter1);

        spn3 = view.findViewById(R.id.spinner3);
        ArrayAdapter adapter2 = new ArrayAdapter(getActivity(),android.R.layout.simple_spinner_item,nameList);
        spn3.setAdapter(adapter2);

        spn4 = view.findViewById(R.id.spinner4);
        ArrayAdapter adapter3 = new ArrayAdapter(getActivity(),android.R.layout.simple_spinner_item,nameList);
        spn4.setAdapter(adapter3);

        spn5 = view.findViewById(R.id.spinner5);
        ArrayAdapter adapter4 = new ArrayAdapter(getActivity(),android.R.layout.simple_spinner_item,nameList);
        spn5.setAdapter(adapter4);




        if(bn != null);
        {
            frg = bn.getString(Fragment_bt_dd.TAG_KAWNA);
        }
        view.findViewById(R.id.btn6).setOnClickListener(this);
        view.findViewById(R.id.bbbtn1).setOnClickListener(this);
        return view;
    }


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


    private void senddata (){
        String[] tmpSpn = {spn1.getSelectedItem().toString(),spn2.getSelectedItem().toString(),spn3.getSelectedItem().toString(),
                spn4.getSelectedItem().toString(),spn5.getSelectedItem().toString()};

        Toast.makeText(getContext(), ""+tmpSpn[0]+" , "+tmpSpn[1]+" , "+tmpSpn[2]+" , "+tmpSpn[3]+" , "+tmpSpn[4], Toast.LENGTH_SHORT).show();

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn6:
                Bundle bn = new Bundle();
                bn.putString(TAG_HEW3,"7894");

                Fragment_bt_dd av_bt_dd = new Fragment_bt_dd();
                av_bt_dd.setArguments(bn);
                replaceFragment(av_bt_dd,bn);
                break;
            case  R.id.bbbtn1:

                senddata ();
                break;
        }
//        ยืนยันข้อมูลเรียนร้อย
    }
}