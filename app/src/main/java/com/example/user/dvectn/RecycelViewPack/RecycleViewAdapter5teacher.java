package com.example.user.dvectn.RecycelViewPack;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.user.dvectn.R;

import java.util.List;

/**
 * Created by User on 26/3/2561.
 */

public class RecycleViewAdapter5teacher extends RecyclerView.Adapter<RecycleViewAdapter5teacher.MyHoder> {

    Context contex;
    List<String> name1;
    List<String> name2;
    List<String> name3;

    ArrayAdapter adp2 ;

    public  RecycleViewAdapter5teacher(Context context){

        this.contex = context;
    }

    public  void  Dataname(List<String> name1,List<String> name2,List<String> name3,ArrayAdapter adp2){

        this.name1 = name1;
        this.name2 = name2;
        this.name3 = name3;
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
    public void onBindViewHolder(RecycleViewAdapter5teacher.MyHoder holder, int position) {


        holder.tx_1.setText(name1.get(position));
        holder.tx_2.setText(name2.get(position));
        holder.tx_3.setText(name3.get(position));
        holder.tx_5.setAdapter(adp2);



    }

    @Override
    public int getItemCount() {return name1.size();}
    class  MyHoder extends RecyclerView.ViewHolder{

        TextView tx_1;
        TextView tx_2;
        TextView tx_3;
        Spinner tx_4;
        Spinner tx_5;
        Spinner tx_6;
        Context context;

        public MyHoder (View itemView, Context context){

            super(itemView);

            tx_1 =itemView.findViewById(R.id.tw_namlist_te);
            tx_2 =itemView.findViewById(R.id.tw_namlist_te1);
            tx_3 =itemView.findViewById(R.id.tw_namlist_te2);
            tx_4 =itemView.findViewById(R.id.spinner_te);
            tx_5 =itemView.findViewById(R.id.spinner_te1);
            tx_6 = itemView.findViewById(R.id.spinner_te2);

            this.context = context;
        }
    }

}
