package com.example.omninos;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.zip.Inflater;

public class Adapter extends RecyclerView.Adapter<Adapter.viewHolder> {
    String[] data ;
    Adapter(String[] data){
        this.data =data;
    }
    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
 View view =inflater.inflate(R.layout.template,parent,false);
 return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        String s=data[position];
        holder.t.setText(s);

    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class viewHolder extends RecyclerView.ViewHolder{
TextView t;
ImageView i;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            i=itemView.findViewById(R.id.image);
            t=itemView.findViewById(R.id.text);

        }
    }
}
