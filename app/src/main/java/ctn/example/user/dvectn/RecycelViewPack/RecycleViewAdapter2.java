package ctn.example.user.dvectn.RecycelViewPack;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import ctn.example.user.dvectn.POJO.POJO_save_AG;
import ctn.example.user.dvectn.POJO.POJO_save_data_trainer;
import ctn.example.user.dvectn.Retrofit.NetworkConnectionManager;
import ctn.example.user.dvectn.Retrofit.OnNetworkCallback_save_AG;
import ctn.example.user.dvectn.Retrofit.OnNetworkCallback_save_data_trainer;
import com.squareup.picasso.Picasso;


import java.util.List;

import okhttp3.ResponseBody;

/**
 * Created by User on 8/3/2561.
 */

public class RecycleViewAdapter2 extends RecyclerView.Adapter<RecycleViewAdapter2.MyHoder> {

    Context context;
    List<String> flthData;

    List<Integer> State;

    List<String> Data_img;
    List<String> Data_detail;
    List<String> Data_score;
    List<String> Data_member_ID;
    String type = "";

    public RecycleViewAdapter2(Context context) {

        this.context = context;

    }

    public void Update_teacher_data(List<String> flthData, List<Integer> State, List<String> Data_img, List<String> Data_detail,
                                    List<String> Data_score, List<String> Data_member_ID, String type) {

        this.flthData = flthData;


        this.State = State;

        this.Data_img = Data_img;
        this.Data_detail = Data_detail;
        this.Data_score = Data_score;
        this.Data_member_ID = Data_member_ID;
        this.type = type;
    }


    @Override
    public RecycleViewAdapter2.MyHoder onCreateViewHolder(ViewGroup parent, int viewType) {

        View Y;
        Y = LayoutInflater.from(parent.getContext()).inflate(ctn.example.user.dvectn.R.layout.row_datath, parent
                , false);
        return new MyHoder(Y, context);

    }

    @Override
    public void onBindViewHolder(MyHoder holder, final int position) {

        holder.dataview.setText(flthData.get(position));
//        holder.dataview2.setText(lsthData.get(position));

//        holder.setOnClickRecycleView(new OnClickRecycleView() {
//            @Override
//            public void onClick(View view, int position, boolean isLongClick, MotionEvent motionEvent) {
//                showCustomDialog(Data_member_ID.get(position),Data_detail.get(position),Data_img.get(position),Data_score.get(position));
//
//            }
//        });

        holder.btn_state.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {

                    showCustomDialog(Data_member_ID.get(position), Data_detail.get(position), Data_img.get(position), Data_score.get(position));

                } catch (Exception e) {

                }


            }
        });


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            holder.btn_state.setTextColor(context.getColor(ctn.example.user.dvectn.R.color.text_w));
        }
//        if (State.get(position)==1){
//            holder.btn_state.setText("อนุมัติ");
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//                holder.btn_state.setBackgroundColor(context.getColor(R.color.colorPrimaryDark));
//            }
//
//
//
//        }
    }


    @Override
    public int getItemCount() {
        return flthData.size();
    }


    class MyHoder extends RecyclerView.ViewHolder {

        Button btn_state;
        TextView dataview;
        Context context;


        public MyHoder(View itemView, Context context) {

            super(itemView);

            btn_state = itemView.findViewById(ctn.example.user.dvectn.R.id.btn_ap);
            dataview = itemView.findViewById(ctn.example.user.dvectn.R.id.tv_th_1);


            this.context = context;


        }

    }

    OnNetworkCallback_save_AG onNetworkCallback_save_ag = new OnNetworkCallback_save_AG() {
        @Override
        public void onResponse(List<POJO_save_AG> save_AG) {

        }

        @Override
        public void onBodyError(ResponseBody responseBodyError) {

        }

        @Override
        public void onBodyErrorIsNull() {

        }

        @Override
        public void onFailure(Throwable t) {

        }
    };

    OnNetworkCallback_save_data_trainer onCallbackList = new OnNetworkCallback_save_data_trainer() {
        @Override
        public void onResponse(List<POJO_save_data_trainer> save_data_trainers) {

        }

        @Override
        public void onBodyError(ResponseBody responseBodyError) {
            Toast.makeText(context, "เกิดข้อผิดพลาด", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onBodyErrorIsNull() {
            Toast.makeText(context, "ข้อมูลว่างเปล่า", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onFailure(Throwable t) {
            Toast.makeText(context, "เกิดข้อผิดพลาด", Toast.LENGTH_SHORT).show();
        }

    };

    private void showCustomDialog(final String member_id, String detail, String url, final String score) {

//        final String[] DataSp = {"-", "0", "1", "2", "3"};  // คะแนน
        String DataSp [] = {"-","ต้องปรับปรุง","พอใช้","ดี","ดีมาก"};
//        Toast.makeText(context, "member_id = "+member_id+" detail = "+detail+" url = "+url +" score ="+score, Toast.LENGTH_SHORT).show();

        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        LayoutInflater layoutInflater = LayoutInflater.from(context);

        View handleView = layoutInflater.inflate(ctn.example.user.dvectn.R.layout.custom_layout_dialog, null);
        TextView tv_detail = handleView.findViewById(ctn.example.user.dvectn.R.id.tv_detail);
        TextView tv_lbl_score = handleView.findViewById(ctn.example.user.dvectn.R.id.tv_lbl_score);
        ImageView imageView = handleView.findViewById(ctn.example.user.dvectn.R.id.img);

        final Spinner spinner = handleView.findViewById(ctn.example.user.dvectn.R.id.spScore);

        if (type.equals("admin")) {
            spinner.setVisibility(View.GONE);
            tv_lbl_score.setVisibility(View.GONE);
        } else {
            spinner.setVisibility(View.VISIBLE);
            tv_lbl_score.setVisibility(View.VISIBLE);
        }


        //D/Member Type: admin
        //D/Member Type: establishment


        //set detail
        tv_detail.setText(detail);

        try {

            // set image from url
            if (!url.isEmpty())
                Picasso.with(context).load(url).into(imageView);
            else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                imageView.setImageDrawable(context.getDrawable(ctn.example.user.dvectn.R.drawable.logo2));
            }

        } catch (Exception e) {

        }

        ArrayAdapter adt = new ArrayAdapter(context, android.R.layout.simple_spinner_dropdown_item, DataSp);
        spinner.setAdapter(adt);
        builder.setTitle("ดูรายละเอียด");
        builder.setView(handleView);

        builder.setPositiveButton("อนุมัติ", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (type.equals("establishment"))
                    new NetworkConnectionManager().callSrever_save_data_trainer(onCallbackList,
                            Integer.parseInt(member_id),
                            getStatus(spinner.getSelectedItem().toString()),
                            1);

                else  // establishment
                    new NetworkConnectionManager().callSrever_save_AG(onNetworkCallback_save_ag, Integer.parseInt(member_id),
                             1);
//                Toast.makeText(context, member_id + " อนุมัติ " + spinner.getSelectedItem(), Toast.LENGTH_SHORT).show();
                Toast.makeText(context, " อนุมัติเรียบร้อยแล้วครับ ", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("ไม่อนุมัติ", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                new NetworkConnectionManager().callSrever_save_AG(onNetworkCallback_save_ag, Integer.parseInt(member_id),
                        0);
                Toast.makeText(context, "ไม่อนุมัติ", Toast.LENGTH_SHORT).show();
            }
        });
        builder.show();
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

}



