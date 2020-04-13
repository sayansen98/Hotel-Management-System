package com.example.hotelmanagement;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class recycleviewq extends RecyclerView.Adapter <recycleviewq.myviewholder>{
    private Context mcontext;
    private List<hoteli> mdata;
    String email;
    public  recycleviewq(Context mcontext,List<hoteli> mdata,String email)
    {
        this.mcontext=mcontext;
        this.mdata=mdata;
        this.email=email;
    }
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater mInlator=LayoutInflater.from(mcontext);
        view= (View) mInlator.inflate(R.layout.cardiew_item,parent,false);
        return new myviewholder(view);}
    public void onBindViewHolder(@NonNull myviewholder holder, final int position) {
        holder.tv_hotel_view.setText(mdata.get(position).getName());
        holder.image_hotel_thumnail.setImageResource(mdata.get(position).getThumbnail());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(mcontext, trd_hotelimg.class);
                intent.putExtra("name", mdata.get(position).getName());
                intent.putExtra("thumbnile", mdata.get(position).getThumbnail());
                intent.putExtra("rate", mdata.get(position).getRate());
                intent.putExtra("description", mdata.get(position).getDescription());
                intent.putExtra("email", email);
                mcontext.startActivity(intent);

            }
        });
    }
    public int getItemCount() {
        return mdata.size() ;
    }



public static class myviewholder extends RecyclerView.ViewHolder {
    TextView tv_hotel_view;
    ImageView image_hotel_thumnail;
    CardView cardView;

    public myviewholder(View hotelview) {
        super(hotelview);
        tv_hotel_view = (TextView) itemView.findViewById(R.id.hotel_book_id);
        image_hotel_thumnail = (ImageView) itemView.findViewById(R.id.hotel_img);
        cardView = (CardView) itemView.findViewById(R.id.cardview_id);
    }

}}