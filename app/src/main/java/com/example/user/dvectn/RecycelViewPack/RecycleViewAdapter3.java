package com.example.user.dvectn.RecycelViewPack;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.dvectn.POJO.POJO_Checkdaily;
import com.example.user.dvectn.R;
import com.example.user.dvectn.Retrofit.NetworkConnectionManager;
import com.example.user.dvectn.Retrofit.OnNetworkCallback_Checkdaily_D1;

import java.util.List;

import okhttp3.ResponseBody;

/**
 * Created by User on 9/3/2561.
 */

public class RecycleViewAdapter3 extends RecyclerView.Adapter<RecycleViewAdapter3.MyHoder> {
    ProgressDialog progressDialog;
    Context context;
    List<String> namelist;
    List<String> ltnamelist;
    List<String> numlist;
    List<Integer> state;
    ArrayAdapter adp2 ;

    public RecycleViewAdapter3(Context context) {

        this.context = context;
    }

    public void DataStudent(List<String> namelist, List<String> ltnamelist,  List<String> numlist,List<Integer> state , ArrayAdapter adp2) {

        this.namelist = namelist;

        this.numlist = numlist;
        this.ltnamelist = ltnamelist;
        this.state = state;
        this.adp2 = adp2 ;
    }

    @Override
    public RecycleViewAdapter3.MyHoder onCreateViewHolder(ViewGroup parent, int viewType) {
//        return null;
        View U;
        U = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_student, parent,
                false);
        return new MyHoder(U, context);
    }

    @Override
    public void onBindViewHolder(RecycleViewAdapter3.MyHoder holder, int position) {


        holder.tx_1.setText(namelist.get(position));
        holder.tx_2.setText(ltnamelist.get(position));
        holder.tx_3.setText(""+numlist.get(position));
        holder.tx_5.setAdapter(adp2);

        int spinnerPosition = adp2.getPosition(getStatusStr(state.get(position)-1));
        holder.tx_5.setSelection(spinnerPosition);


    }

    OnNetworkCallback_Checkdaily_D1 onCallbackList = new OnNetworkCallback_Checkdaily_D1() {
        @Override
        public void onResponse(POJO_Checkdaily getstu) {

            Toast.makeText(context, "บันทึกข้อมูลสำเร็จ", Toast.LENGTH_SHORT).show();

            if (progressDialog.isShowing()) {
                progressDialog.dismiss();
            }
        }

        @Override
        public void onBodyError(ResponseBody responseBodyError) {
            Toast.makeText(context, "responseBodyError", Toast.LENGTH_SHORT).show();
            if (progressDialog.isShowing()) {
                progressDialog.dismiss();
            }

        }

        @Override
        public void onBodyErrorIsNull() {

            Toast.makeText(context, "res is null", Toast.LENGTH_SHORT).show();
            if (progressDialog.isShowing()) {
                progressDialog.dismiss();
            }

        }

        @Override
        public void onFailure(Throwable t) {

//            Toast.makeText(context, "Err "+t.getMessage(), Toast.LENGTH_SHORT).show();
            if (progressDialog.isShowing()) {
                progressDialog.dismiss();
            }

        }
    };

    @Override
    public int getItemCount() {
        return namelist.size();
    }
    class  MyHoder extends RecyclerView.ViewHolder{

        TextView tx_1;
        TextView tx_2;
        TextView tx_3;

        Spinner tx_5;
        Context context;

        public MyHoder (View itemView, final Context context){

            super(itemView);

            tx_1 =itemView.findViewById(R.id.tw_namlist);
            tx_2 =itemView.findViewById(R.id.cccttn);
            tx_3 =itemView.findViewById(R.id.tw_numberlist);

            tx_5 =itemView.findViewById(R.id.spn_checklist);
            this.context = context;

            tx_5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                    if(!tx_5.getSelectedItem().toString().equals("-")){

                        progressDialog = new ProgressDialog(context);
                        progressDialog.setMessage("Loading......");
                        progressDialog.show();

                            new NetworkConnectionManager().callServer_Checkdaily(onCallbackList,tx_1.getText().toString(),getStatus(tx_5.getSelectedItem().toString()));

                        }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });


        }

        private int getStatus(String input){

            if(input.equals("ขาด")){
                return 0;
            }else if (input.equals("ลา")){
                return 1;
            }else if (input.equals("มา")){
                return 2;
            }else if (input.equals("มาสาย")){
                return 3;
            }else {
                return -1;
            }
        }


    }

    private String getStatusStr(int input){

        if(input == 0 ){
            return "ขาด";
        }else if (input== 1){
            return "ลา";
        }else if (input == 2 ){
            return "มา";
        }else if (input == 3){
            return "มาสาย";
        }else {
            return "-";
        }
    }

}
