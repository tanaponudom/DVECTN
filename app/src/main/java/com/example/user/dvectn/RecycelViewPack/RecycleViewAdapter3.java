package com.example.user.dvectn.RecycelViewPack;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.user.dvectn.R;

import java.util.List;

/**
 * Created by User on 9/3/2561.
 */

public class RecycleViewAdapter3 extends RecyclerView.Adapter<RecycleViewAdapter3.MyHoder> {

    Context contex;
    List<String> classlist;
    List<String> namelist;
    List<String> ltnamelist;
    List<Integer> numlist;
    ArrayAdapter adp2 ;

    public RecycleViewAdapter3(Context context) {

        this.contex = context;
    }

    public void DataStudent(List<String> namelist, List<String> ltnamelist, List<String> classlist, List<Integer> numlist , ArrayAdapter adp2) {

        this.namelist = namelist;
        this.classlist = classlist;
        this.numlist = numlist;
        this.ltnamelist = ltnamelist;
        this.adp2 = adp2 ;
    }

    @Override
    public RecycleViewAdapter3.MyHoder onCreateViewHolder(ViewGroup parent, int viewType) {
//        return null;
        View U;
        U = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_student, parent,
                false);
        return new MyHoder(U, contex);
    }

    @Override
    public void onBindViewHolder(RecycleViewAdapter3.MyHoder holder, int position) {


        holder.tx_1.setText(namelist.get(position));
        holder.tx_2.setText(classlist.get(position));
        holder.tx_3.setText(""+numlist.get(position));
        holder.tx_4.setText(ltnamelist.get(position));
        holder.tx_5.setAdapter(adp2);



    }

    @Override
    public int getItemCount() {
        return classlist.size();
    }
    class  MyHoder extends RecyclerView.ViewHolder{

        TextView tx_1;
        TextView tx_2;
        TextView tx_3;
        TextView tx_4;
        Spinner tx_5;
        Context context;

        public MyHoder (View itemView, Context context){

            super(itemView);

            tx_1 =itemView.findViewById(R.id.tw_namlist);
            tx_2 =itemView.findViewById(R.id.tw_classlist);
            tx_3 =itemView.findViewById(R.id.tw_numberlist);
            tx_4 =itemView.findViewById(R.id.cccttn);
            tx_5 =itemView.findViewById(R.id.spn_checklist);

            this.context = context;
        }
    }
//        return 0;



}
