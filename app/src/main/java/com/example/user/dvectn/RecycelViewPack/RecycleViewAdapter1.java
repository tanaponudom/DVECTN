package com.example.user.dvectn.RecycelViewPack;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.dvectn.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by User on 7/3/2561.
 */

public class RecycleViewAdapter1 extends RecyclerView.Adapter<RecycleViewAdapter1.MyHoder> {

    Context context0;
    List<String> nData;
    List<String> nUrl;


    public RecycleViewAdapter1(Context context) {

        this.context0 = context;

    }

    public void Update_Data(List<String> nData,    List<String> nUrl) {

        this.nData = nData;
        this.nUrl = nUrl;
//        Toast.makeText(context0, ""+nData.size(), Toast.LENGTH_SHORT).show();
    }


    @Override
    public RecycleViewAdapter1.MyHoder onCreateViewHolder(ViewGroup parent, int viewType) {

        View T;
        T = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_data2,
                parent, false);

        return new MyHoder(T, context0);

    }

    @Override
    public void onBindViewHolder(RecycleViewAdapter1.MyHoder holder, int position) {

        holder.tv_name.setText(nData.get(position));
        holder.setIMG(nUrl.get(position));

    }

    @Override
    public int getItemCount() {return nData.size();}


    class MyHoder extends RecyclerView.ViewHolder{

        TextView tv_name;
        ImageView imgUser;
        Context context;


        public MyHoder(View itemView,Context context) {

            super(itemView);

            tv_name = itemView.findViewById(R.id.TW_row_st2);
            imgUser = itemView.findViewById(R.id.IV_row_st2);
            this.context = context;

        }

        public void setIMG(String url){
//            Toast.makeText(context, ""+url, Toast.LENGTH_SHORT).show();
            Picasso.with(context).load(url).into(imgUser);


        }


    }
}










