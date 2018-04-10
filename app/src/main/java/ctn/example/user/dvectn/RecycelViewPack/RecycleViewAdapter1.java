package ctn.example.user.dvectn.RecycelViewPack;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

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
        T = LayoutInflater.from(parent.getContext()).inflate(ctn.example.user.dvectn.R.layout.row_data2,
                parent, false);

        return new MyHoder(T, context0);

    }

    @Override
    public void onBindViewHolder(RecycleViewAdapter1.MyHoder holder, int position) {

        holder.tv_name.setText(nData.get(position));
        holder.setIMG(nUrl.get(position));
        holder.setOnClickRecycleView(new OnClickRecycleView() {
            @Override
            public void onClick(View view, int position, boolean isLongClick, MotionEvent motionEvent) {

            }
        });

    }


    @Override
    public int getItemCount() {return nData.size();}

    class MyHoder extends RecyclerView.ViewHolder implements  View.OnClickListener
            , View.OnLongClickListener, View.OnTouchListener {

        private OnClickRecycleView onClickRecycleView;
        TextView tv_name;
        ImageView imgUser;
        Context context;

        public MyHoder(View itemView,Context context) {

            super(itemView);

            tv_name = itemView.findViewById(ctn.example.user.dvectn.R.id.TW_row_st2);
            imgUser = itemView.findViewById(ctn.example.user.dvectn.R.id.IV_row_st2);
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

        public void setIMG(String url){

            if(!url.isEmpty())
            Picasso.with(context).load(url).into(imgUser);
            else
                imgUser.setImageDrawable(context.getDrawable(ctn.example.user.dvectn.R.drawable.logo2));

            }
        }

    }










