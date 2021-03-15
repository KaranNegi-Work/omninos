package com.example.omninos.modelClasses;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.omninos.Adapter;
import com.example.omninos.MainActivity;
import com.example.omninos.R;

import java.util.List;

public class imageAdapter extends RecyclerView.Adapter<imageAdapter.viewHolder>{
    List<DetailsClass> data ;
    public imageAdapter(List<DetailsClass> data){
        this.data =data;
    }
    @NonNull
    @Override
    public imageAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view =inflater.inflate(R.layout.imagetemplate,parent,false);
        return new imageAdapter.viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        DetailsClass s= data.get(position);
        Glide.with(holder.i.getContext())
                .load(s.getSliderImage())
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(holder.i);
        holder.t.setText(s.title);
    }



    @Override
    public int getItemCount() {

        return data.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{
        TextView t;
        ImageView i;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            i=itemView.findViewById(R.id.i);
            t=itemView.findViewById(R.id.t);

        }
    }
}