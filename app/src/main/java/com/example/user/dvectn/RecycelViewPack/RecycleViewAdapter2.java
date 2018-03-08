package com.example.user.dvectn.RecycelViewPack;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.dvectn.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by User on 8/3/2561.
 */

public class RecycleViewAdapter2 extends RecyclerView.Adapter<RecycleViewAdapter2.MyHoder> {

    Context context ;
    List<String> thData;
    List<Integer> State;

    public RecycleViewAdapter2(Context context){

        this.context = context;

    }

    public  void Update_teacher_data(List<String>thData,List<Integer>State){

        this.thData = thData;
        this.State  = State;

    }

    @Override
    public RecycleViewAdapter2.MyHoder onCreateViewHolder(ViewGroup parent, int viewType) {

        View Y;
            Y = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_datath,parent
            , false);
            return new MyHoder(Y, context);

    }

    @Override
    public void onBindViewHolder(RecycleViewAdapter2.MyHoder holder, int position) {

        holder.dataview.setText(thData.get(position));
        holder.btn_state.setTextColor(context.getColor(R.color.text_w));
        if (State.get(position)==1){
            holder.btn_state.setText("อนุมัติ");
            holder.btn_state.setBackgroundColor(context.getColor(R.color.colorPrimaryDark));
        }else {
            holder.btn_state.setText("ไม่อนุมัติ");
            holder.btn_state.setBackgroundColor(context.getColor(R.color.colorAccent));

        }
    }

    @Override
    public int getItemCount(){return thData.size();}


    class MyHoder extends RecyclerView.ViewHolder{


        Button btn_state;
        TextView dataview;
        Context context;


        public MyHoder(View itemView,Context context) {

            super(itemView);

            btn_state = itemView.findViewById(R.id.btn_ap);
            dataview = itemView.findViewById(R.id.tv_th_1);

            this.context = context;

        }
//
//        public void setIMG(String url){
//            Toast.makeText(context, ""+url, Toast.LENGTH_SHORT).show();
//            Picasso.with(context).load(url).into(imgUser);


        }

    }


