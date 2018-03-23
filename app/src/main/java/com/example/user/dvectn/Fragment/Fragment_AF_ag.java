package com.example.user.dvectn.Fragment;

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
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.user.dvectn.R;
import com.example.user.dvectn.RecycelViewPack.Fragment_bt_ag;

/**
 * Created by Praipran on 3/21/2018.
 */

public class Fragment_AF_ag extends Fragment  {


    ListView listView;
    String [] chataterNaJa ={ "นาย อักษรขจร รถผ่าน","นางสาว ประวิทย์ ฉลาดจุง","นาย ประหยัด จันทร์อังคารพุธ" };


    public static final String TAG_OHNOAG = "OHNOAG";


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v4 =inflater.inflate(R.layout.af_ag_list,container,false);
        ListView listView =(ListView) v4.findViewById(R.id.list_af_ag);

        ArrayAdapter ListViewAdapter = new ArrayAdapter(getContext(),android.R.layout.simple_list_item_1,chataterNaJa);
        listView.setAdapter(ListViewAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getContext(), "Item C3lick", Toast.LENGTH_SHORT);


                Fragment_bt_ag av_bt_ag = new Fragment_bt_ag();
                replaceFragment(av_bt_ag, null);


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
