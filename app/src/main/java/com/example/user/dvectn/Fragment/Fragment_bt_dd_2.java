package com.example.user.dvectn.Fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import android.widget.Spinner;

import com.example.user.dvectn.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 20/2/2561.
 */

public class Fragment_bt_dd_2 extends Fragment implements View.OnClickListener
{
    Bundle bn;
    String frg;
    String nameList[] = {"-","1","2","3","4","5"};
    Spinner spin1, spin2 , spin3 , spin4 , spin5 , spin6 , spin7 , spin8 ;
    public  static  final String TAG_HEW4 = "HEW4";



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.av_bt_dd_2,container, false);
        bn = getArguments();

        spin1 = view.findViewById(R.id.spinner6);
        ArrayAdapter adapter = new ArrayAdapter(getActivity(),android.R.layout.simple_spinner_item,nameList);
        spin1.setAdapter(adapter);

        spin2 = view.findViewById(R.id.spinner7);
        ArrayAdapter adapter1 = new ArrayAdapter(getActivity(),android.R.layout.simple_spinner_item,nameList);
        spin2.setAdapter(adapter1);

        spin3 = view.findViewById(R.id.spinner8);
        ArrayAdapter adapter2 = new ArrayAdapter(getActivity(),android.R.layout.simple_spinner_item,nameList);
        spin3.setAdapter(adapter2);

        spin4 = view.findViewById(R.id.spinner9);
        ArrayAdapter adapter3 = new ArrayAdapter(getActivity(),android.R.layout.simple_spinner_item,nameList);
        spin4.setAdapter(adapter3);

        spin5 = view.findViewById(R.id.spinner10);
        ArrayAdapter adapter4 = new ArrayAdapter(getActivity(),android.R.layout.simple_spinner_item,nameList);
        spin5.setAdapter(adapter4);

        spin6 = view.findViewById(R.id.spinner11);
        ArrayAdapter adapter5 = new ArrayAdapter(getActivity(),android.R.layout.simple_spinner_item,nameList);
        spin6.setAdapter(adapter5);

        spin7 = view.findViewById(R.id.spinner12);
        ArrayAdapter adapter6 = new ArrayAdapter(getActivity(),android.R.layout.simple_spinner_item,nameList);
        spin7.setAdapter(adapter6);

        spin8 = view.findViewById(R.id.spinner13);
        ArrayAdapter adapter7 = new ArrayAdapter(getActivity(),android.R.layout.simple_spinner_item,nameList);
        spin8.setAdapter(adapter7);


        if(bn != null);
        {
            frg = bn.getString(Fragment_bt_dd.TAG_KAWNA);
        }
        view.findViewById(R.id.btn7).setOnClickListener(this);
        view.findViewById(R.id.bbbtn2).setOnClickListener(this);


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
        String[] tmpSpn = {spin1.getSelectedItem().toString(),spin2.getSelectedItem().toString(),spin3.getSelectedItem().toString(),
                spin4.getSelectedItem().toString(),spin5.getSelectedItem().toString(),spin6.getSelectedItem().toString(),
                spin7.getSelectedItem().toString(),spin8.getSelectedItem().toString()};

        if(tmpSpn != null){
            if (!tmpSpn[0].equals("-") || !tmpSpn[1].equals("-") || !tmpSpn[2].equals("-") || !tmpSpn[3].equals("-") || !tmpSpn[4].equals("-")
                    || !tmpSpn[5].equals("-") || !tmpSpn[6].equals("-") || !tmpSpn[7].equals("-") ){
                Toast.makeText(getContext(), ""+tmpSpn[0]
                        +" , "+tmpSpn[1]+" , "+tmpSpn[2]+" , "+tmpSpn[3]+" , "+tmpSpn[4]+" , "+tmpSpn[5]
                        +" , "+tmpSpn[6]+" , "+tmpSpn[7], Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(getContext(),"กรุณากรอกให้ครบ",Toast.LENGTH_SHORT).show();
            }


        }else {
            Toast.makeText(getContext(), "wrong", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn7:
                Bundle bn = new Bundle();
                bn.putString(TAG_HEW4,"1475");

                Fragment_bt_dd av_bt_dd = new Fragment_bt_dd();
                av_bt_dd.setArguments(bn);
                replaceFragment(av_bt_dd,bn);
                break;

            case R.id.bbbtn2:

                senddata ();
                break;
        }

    }

}
