package com.example.omninos;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CAdapter extends RecyclerView.Adapter<CAdapter.viewHolder> {
     String[] data ;
     CAdapter(String[] data){
          this.data =data;
     }
     @NonNull
     @Override
     public CAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
          LayoutInflater inflater=LayoutInflater.from(parent.getContext());
          View view =inflater.inflate(R.layout.cardview,parent,false);
          return new CAdapter.viewHolder(view);
     }

     @Override
     public void onBindViewHolder(@NonNull CAdapter.viewHolder holder, int position) {
          String s=data[position];
          holder.t.setText(s);

     }

     @Override
     public int getItemCount() {
          return data.length;
     }

     public  class viewHolder  extends RecyclerView.ViewHolder{
          TextView t;
       public viewHolder(@NonNull View itemView) {
            super(itemView);
            t=itemView.findViewById(R.id.ctext);
       }
  }
}
