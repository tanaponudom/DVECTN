package com.example.user.dvectn.Fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.dvectn.R;
import com.example.user.dvectn.RecycelViewPack.Fragment_Teacher_Recycle;

/**
 * Created by Praipran on 3/21/2018.
 */

public class Fragment_AF_Teacherlayout extends Fragment {


    String [] chataterNaJa ={ "ร้าน พี พาวเวอร์","ร้าน ท็อบวิวพอย์","ศาลากลางจังหวัด" };
    Context context;

    String scoreTmp="";
    public static final String TAG_OHNOTH = "OHNOTH";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v4 =inflater.inflate(R.layout.af_teacher_layout,container,false);
        ListView listView =(ListView) v4.findViewById(R.id.list_af_th);
        context = getContext();

        ArrayAdapter ListViewAdapter = new ArrayAdapter(getContext(),android.R.layout.simple_list_item_1,chataterNaJa);
        listView.setAdapter(ListViewAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                score(chataterNaJa[position]);
//                Toast.makeText(getContext(), "Item Click", Toast.LENGTH_SHORT);
//
//
//                Fragment_Teacher_Recycle teacher_layout = new Fragment_Teacher_Recycle();
//                replaceFragment(teacher_layout, null);



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


    private void score(String pe){


        AlertDialog.Builder builder  = new AlertDialog.Builder(context);
        builder.setTitle("กรุณาป้อนข้อมูล");
        builder.setMessage("ยินดีต้อนรับ "+pe);
        final EditText inputScore = new EditText(context);
        inputScore.setInputType(InputType.TYPE_CLASS_NUMBER);
        builder.setView(inputScore);

        builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                    scoreTmp = inputScore.getText().toString().trim();
                    try {

                        int tmp_sc = Integer.parseInt(scoreTmp);

                        if(tmp_sc <= 10 && tmp_sc > 0){
                            if(scoreTmp.isEmpty()) {
                                Toast.makeText(context, "กรุณาป้อนคะแนน", Toast.LENGTH_SHORT).show();

                            }else {

                                Toast.makeText(context, ""+scoreTmp, Toast.LENGTH_SHORT).show();

                            }
                        }else {
                            Toast.makeText(context, "Error !!!!!!!!!!!!!!!", Toast.LENGTH_SHORT).show();
                        }

                    }catch (Exception e){

                        Toast.makeText(context, "กรุณาป้อนคะแนน", Toast.LENGTH_SHORT).show();

                    }



            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
            }
        });

        builder.show();


    }

}

