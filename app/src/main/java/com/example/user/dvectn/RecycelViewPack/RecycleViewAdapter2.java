package com.example.user.dvectn.RecycelViewPack;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.dvectn.R;
import com.squareup.picasso.Picasso;


import java.util.List;

/**
 * Created by User on 8/3/2561.
 */

public class RecycleViewAdapter2 extends RecyclerView.Adapter<RecycleViewAdapter2.MyHoder> {

    Context context ;
    List<String> flthData;
    List<String> lsthData;
    List<Integer> State;


    public RecycleViewAdapter2(Context context){

        this.context = context;

    }

    public  void Update_teacher_data(List<String>flthData,  List<String> lsthData,List<Integer>State){

        this.flthData = flthData;
        this.lsthData = lsthData;
        this.State  = State;

    }

    public  void  Update_str_work (List<String>flthData,  List<String> lsthData,List<Integer>State){

        this.flthData = flthData;
        this.lsthData = lsthData;
        this.State = State;
    }

    @Override
    public RecycleViewAdapter2.MyHoder onCreateViewHolder(ViewGroup parent, int viewType) {

        View Y;
            Y = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_datath,parent
            , false);
            return new MyHoder(Y, context);

    }

    @Override
    public void onBindViewHolder(MyHoder holder, final int position) {

        holder.dataview.setText(flthData.get(position));
        holder.dataview2.setText(lsthData.get(position));
        holder.setOnClickRecycleView(new OnClickRecycleView() {
            @Override
            public void onClick(View view, int position, boolean isLongClick, MotionEvent motionEvent) {
                showCustomDialog("50999"+position,"ลง windows","http://2.bp.blogspot.com/-6_khqkp_IYc/Vm3LCXRwdvI/AAAAAAAA3i8/jYteC-WQXRE/s1000/header.jpg");

            }
        });

        holder.btn_state.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, ""+ flthData.get(position), Toast.LENGTH_SHORT).show();

                showCustomDialog(""+position,"ลง windows 25","http://2.bp.blogspot.com/-6_khqkp_IYc/Vm3LCXRwdvI/AAAAAAAA3i8/jYteC-WQXRE/s1000/header.jpg");

            }
        });


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            holder.btn_state.setTextColor(context.getColor(R.color.text_w));
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
    public int getItemCount(){return flthData.size();}


    class MyHoder extends RecyclerView.ViewHolder implements  View.OnClickListener
            , View.OnLongClickListener, View.OnTouchListener {

        private OnClickRecycleView onClickRecycleView;
        Button btn_state;
        TextView dataview;
        TextView dataview2;
        Context context;


        public MyHoder(View itemView,Context context) {

            super(itemView);

            btn_state = itemView.findViewById(R.id.btn_ap);
            dataview = itemView.findViewById(R.id.tv_th_1);
            dataview2 = itemView.findViewById(R.id.tv_th_2);

            this.context = context;

            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);

        }

        public void setOnClickRecycleView(OnClickRecycleView onClickRecycleView){
            this.onClickRecycleView =  onClickRecycleView;

        }

        @Override
        public void onClick(View view) {
            onClickRecycleView.onClick(view, getAdapterPosition(), false, null);
        }

        @Override
        public boolean onLongClick(View view) {
            onClickRecycleView.onClick(view, getAdapterPosition(), false, null);
            return true;
        }

        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            onClickRecycleView.onClick(view, getAdapterPosition(), false, null);
            return true;
        }
//
//        public void setIMG(String url){
//            Toast.makeText(context, ""+url, Toast.LENGTH_SHORT).show();
//            Picasso.with(context).load(url).into(imgUser);


        }

    private void showCustomDialog(final String member_id, String detail, String url){

        String[] DataSp = {"-","0","1","2","3"};  // คะแนน

        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        LayoutInflater layoutInflater = LayoutInflater.from(context);

        View handleView = layoutInflater.inflate(R.layout.custom_layout_dialog,null);
        TextView tv_detail = handleView.findViewById(R.id.tv_detail);
        ImageView imageView = handleView.findViewById(R.id.img);
        final Spinner spinner = handleView.findViewById(R.id.spScore);

        //set detail
        tv_detail.setText(detail);
        // set image from url
         if (!url.isEmpty())
        Picasso.with(context).load(url).into(imageView);
        else
            imageView.setImageDrawable(context.getDrawable(R.drawable.logo2));

        ArrayAdapter adt = new ArrayAdapter(context,android.R.layout.simple_spinner_dropdown_item,DataSp);
        spinner.setAdapter(adt);
        builder.setTitle("ดูรายละเอียด");
        builder.setView(handleView);

        builder.setPositiveButton("อนุมัติ", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                Toast.makeText(context, "อนุมัติ", Toast.LENGTH_SHORT).show();

            }
        });

        builder.setNegativeButton("ไม่อนุมัติ", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                Toast.makeText(context, "ไม่อนุมัติ", Toast.LENGTH_SHORT).show();



            }
        });
        builder.show();


    }

    }


