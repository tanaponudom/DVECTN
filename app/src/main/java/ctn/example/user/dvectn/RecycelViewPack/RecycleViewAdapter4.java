package ctn.example.user.dvectn.RecycelViewPack;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import ctn.example.user.dvectn.POJO.POJO_Checkdaily;
import ctn.example.user.dvectn.Retrofit.NetworkConnectionManager;
import ctn.example.user.dvectn.Retrofit.OnNetworkCallback_Checkdaily_D1;
import com.squareup.picasso.Picasso;

import java.util.List;

import okhttp3.ResponseBody;

/**
 * Created by User on 12/3/2561.
 */

public class RecycleViewAdapter4 extends RecyclerView.Adapter<RecycleViewAdapter4.MyHoder> {

    ProgressDialog progressDialog;
    Context coconut;
    List<String> testwae;
    List<String> testwae2;
    List<Integer> testwaeScore;
    ArrayAdapter adp ;



    public RecycleViewAdapter4(Context context) {

        this.coconut = context;

    }

    public void Dataspinner(List<String> testwae,List<String> testwae2 , List<Integer> testwaeScore ,ArrayAdapter adp ) {

        this.testwae = testwae;
        this.testwae2 = testwae2;
        this.testwaeScore = testwaeScore;
        this.adp  = adp;



    }

    @Override
    public RecycleViewAdapter4.MyHoder onCreateViewHolder(ViewGroup parent, int viewType) {
//        return null;
        View j;
        j = LayoutInflater.from(parent.getContext()).inflate(ctn.example.user.dvectn.R.layout.row_dawae, parent,
                false);
        return new MyHoder(j , coconut);
    }

    @Override
    public void onBindViewHolder(final RecycleViewAdapter4.MyHoder holder, int position) {


        holder.ux_1.setText(testwae.get(position));
        holder.ux_2.setText(testwae2.get(position));
        holder.ux_3.setAdapter(adp);

        int spinnerPosition = adp.getPosition(getStatusStr(testwaeScore.get(position)-1));
        holder.ux_3.setSelection(spinnerPosition);
        holder.ux_3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if(!holder.ux_3.getSelectedItem().toString().equals("-")){

//                    progressDialog = new ProgressDialog(coconut);
//                    progressDialog.setMessage("Loading......");
//                    progressDialog.show();

                    new NetworkConnectionManager().callServer_Checkdaily(onCallbackList,holder.ux_1.getText().toString()
                            ,getStatus(holder.ux_3.getSelectedItem().toString()));

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    ///////////////////////////////////////////////////////////////////////////////////////////
    OnNetworkCallback_Checkdaily_D1 onCallbackList = new OnNetworkCallback_Checkdaily_D1() {
        @Override
        public void onResponse(POJO_Checkdaily getstu) {

            Toast.makeText(coconut, "จัดการข้อมูลสำเร็จ", Toast.LENGTH_SHORT).show();

            if (progressDialog.isShowing()) {
                progressDialog.dismiss();
            }
        }

        @Override
        public void onBodyError(ResponseBody responseBodyError) {
            Toast.makeText(coconut, "responseBodyError", Toast.LENGTH_SHORT).show();
            if (progressDialog.isShowing()) {
                progressDialog.dismiss();
            }

        }

        @Override
        public void onBodyErrorIsNull() {

            Toast.makeText(coconut, "res is null", Toast.LENGTH_SHORT).show();
            if (progressDialog.isShowing()) {
                progressDialog.dismiss();
            }

        }

        @Override
        public void onFailure(Throwable t) {

//            Toast.makeText(coconut, "Err "+t.getMessage(), Toast.LENGTH_SHORT).show();
            if (progressDialog.isShowing()) {
                progressDialog.dismiss();
            }

        }
    };


    @Override
    public int getItemCount() {
        return testwae.size();
    }

    class  MyHoder extends RecyclerView.ViewHolder{

        TextView ux_1;
        TextView ux_2;
        ImageView imgUser;
        Spinner ux_3;


        Context coconut;

        public MyHoder (View itemView, Context context){

            super(itemView);

            ux_1 =itemView.findViewById(ctn.example.user.dvectn.R.id.tv_name);
            ux_2 =itemView.findViewById(ctn.example.user.dvectn.R.id.tv_lastname);
            ux_3 =itemView.findViewById(ctn.example.user.dvectn.R.id.spn_point);


            this.coconut = context;


        }
        public void setIMG(String url) {
//            Toast.makeText(context, ""+url, Toast.LENGTH_SHORT).show();
            Picasso.with(coconut).load(url).into(imgUser);


        }
    }

    private int getStatus(String input){

        if(input.equals("-")){
            return 0;
        }else if (input.equals("ต้องปรับปรุง")){
            return 1;
        }else if (input.equals("พอใช้")){
            return 2;
        }else if (input.equals("ดี")){
            return 3;
        }else if (input.equals("ดีมาก")){
            return 4;
        }else {
            return -1;
        }
    }




    private String getStatusStr(int input){

        if(input == 0 ){
            return "-";
        }else if (input== 1){
            return "ต้องปรับปรุง";
        }else if (input == 2 ){
            return "พอใช้";
        }else if (input == 3){
            return "ดี";
        }else if (input == 4){
            return "ดีมาก";
        }else {
            return "-";
        }
    }
//

}
