package com.example.user.dvectn.RecycelViewPack;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.user.dvectn.R;

import java.util.List;

import static java.security.AccessController.getContext;

/**
 * Created by User on 12/3/2561.
 */

public class RecycleViewAdapter4 extends RecyclerView.Adapter<RecycleViewAdapter4.MyHoder> {

    Context coconut;
    List<String> testwae;
    List<String> testwae2;

    ArrayAdapter adp ;



    public RecycleViewAdapter4(Context context) {

        this.coconut = context;

    }

    public void Dataspinner(List<String> testwae,List<String> testwae2 ,ArrayAdapter adp ) {

        this.testwae = testwae;
        this.testwae2 = testwae2;
        this.adp  = adp;

    }

    @Override
    public RecycleViewAdapter4.MyHoder onCreateViewHolder(ViewGroup parent, int viewType) {
//        return null;
        View j;
        j = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_dawae, parent,
                false);
        return new MyHoder(j , coconut);
    }

    @Override
    public void onBindViewHolder(RecycleViewAdapter4.MyHoder holder, int position) {


        holder.ux_1.setText(testwae.get(position));
        holder.ux_2.setText(testwae2.get(position));
        holder.ux_3.setAdapter(adp);

    }

    @Override
    public int getItemCount() {
        return testwae.size();
    }

    class  MyHoder extends RecyclerView.ViewHolder{

        TextView ux_1;
        TextView ux_2;
        Spinner ux_3;

        Context context;

        public MyHoder (View itemView, Context context){

            super(itemView);

            ux_1 =itemView.findViewById(R.id.tv_name);
            ux_2 =itemView.findViewById(R.id.tv_lastname);
            ux_3 =itemView.findViewById(R.id.spn_point);


            this.context = context;
        }
    }
//

}
