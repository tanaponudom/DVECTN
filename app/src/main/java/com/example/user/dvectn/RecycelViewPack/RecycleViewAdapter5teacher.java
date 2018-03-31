package com.example.user.dvectn.RecycelViewPack;

import android.content.Context;
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
import com.example.user.dvectn.POJO.POJO_Stu_naja_gogo;
import com.example.user.dvectn.POJO.POJO_getstu;
import com.example.user.dvectn.R;
import com.example.user.dvectn.Retrofit.NetworkConnectionManager;
import com.example.user.dvectn.Retrofit.OnNetworkCallBackGetStd;
import com.example.user.dvectn.Retrofit.OnNetworkCallback_Checkdaily_D1;
import com.example.user.dvectn.Retrofit.OnNetworkCallback_Stu_naja_gogo;

import java.util.List;

import okhttp3.ResponseBody;

/**
 * Created by User on 26/3/2561.
 */

public class RecycleViewAdapter5teacher extends RecyclerView.Adapter<RecycleViewAdapter5teacher.MyHoder> {

    Context contex;
    List<String> name1;
    List<String> name2;
    List<String> score;

    ArrayAdapter adp2 ;

    public  RecycleViewAdapter5teacher(Context context){

        this.contex = context;
    }

    public  void  Dataname(List<String> name2,List<String> score,ArrayAdapter adp2){


        this.name2 = name2;
        this.score = score;
        this.adp2 = adp2;

    }
    @Override
    public RecycleViewAdapter5teacher.MyHoder onCreateViewHolder(ViewGroup parent, int viewType) {
//        return null;
        View U;
        U = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_teacherspinner, parent,
                false);
        return new MyHoder(U, contex);
    }

    @Override
    public void onBindViewHolder(final RecycleViewAdapter5teacher.MyHoder holder, int position) {



        holder.tx_2.setText(name2.get(position));
        holder.tx_5.setAdapter(adp2);

        if(score.get(position) != null)
        {
//                    Toast.makeText(context, ""+score.get(position), Toast.LENGTH_SHORT).show();
            int spinnerPosition = adp2.getPosition(getStatusStr(Integer.parseInt(score.get(position))));
            holder.tx_5.setSelection(spinnerPosition);
        }


        holder.tx_5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if(!holder.tx_5.getSelectedItem().toString().equals("-") )
                {

                    new NetworkConnectionManager().callServer_stu_naja_gogo(onCallbackList,holder.tx_5.getSelectedItem().toString());

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });





    }

    OnNetworkCallback_Stu_naja_gogo onCallbackList = new OnNetworkCallback_Stu_naja_gogo() {


        @Override
        public void onResponse(List<POJO_Stu_naja_gogo> stu_naja_gogo) {
            Toast.makeText(contex, "จัดการข้อมูลสำเร็จ", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onBodyError(ResponseBody responseBodyError) {
            Toast.makeText(contex, "responseBodyError", Toast.LENGTH_SHORT).show();



        }

        @Override
        public void onBodyErrorIsNull() {

            Toast.makeText(contex, "res is null", Toast.LENGTH_SHORT).show();


        }

        @Override
        public void onFailure(Throwable t) {

            Toast.makeText(contex, "Err "+t.getMessage(), Toast.LENGTH_SHORT).show();

        }
    };


    @Override
    public int getItemCount() {return name2.size();}
    class  MyHoder extends RecyclerView.ViewHolder{

        TextView tx_2;
        Spinner tx_5;
        Context context;

        public MyHoder (View itemView, Context context){
            super(itemView);
            tx_2 =itemView.findViewById(R.id.tw_namlist_te1);
            tx_5 =itemView.findViewById(R.id.spinner_te1);

            this.context = context;
        }
    }
    private int getStatus(String input){

        if(input.equals("-")){
            return 0;
        }else if (input.equals("1")){
            return 1;
        }else if (input.equals("2")){
            return 2;
        }else if (input.equals("3")){
            return 3;
        }else if (input.equals("4")){
            return 4;
        }else if (input.equals("5")){
            return 5;
        }else if (input.equals("6")){
            return 6;
        }else if (input.equals("7")){
            return 7;
        }else if (input.equals("8")){
            return 8;
        }else if (input.equals("9")){
            return 9;
        }else if (input.equals("10")){
            return 10;
        }else {
            return -1;
        }
    }
    private String getStatusStr(int input){

        if(input == 0 ){
            return "0";
        }else if (input== 1){
            return "1";
        }else if (input == 2 ){
            return "2";
        }else if (input == 3){
            return "3";
        }else if (input == 4){
            return "4";
        }else if (input == 5){
            return "5";
        }else if (input == 6){
            return "6";
        }else if (input == 7){
            return "7";
        }else if (input == 8){
            return "8";
        }else if (input == 9){
            return "9";
        }else if (input == 10){
            return "10";
        }else {
            return "-";
        }
    }

}
