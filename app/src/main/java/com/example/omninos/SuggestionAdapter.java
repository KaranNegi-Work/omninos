package com.example.omninos;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

class SuggestionAdapter extends RecyclerView.Adapter<SuggestionAdapter.viewHolder> {
   List<videos> data ;
   int p;
    SuggestionAdapter(List<videos> data,int p){
        this.data =data;
        this.p=p;
    }
    @NonNull
    @Override
    public SuggestionAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view =inflater.inflate(R.layout.suggetions,parent,false);
        return new SuggestionAdapter.viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SuggestionAdapter.viewHolder holder, int position) {

            videos s = data.get(position);
            holder.stitle.setText(s.title);
            holder.ssubtitle.setText(s.subtitle);
            Glide.with(holder.sthumbnail.getContext())
                    .load(s.thumb)
                    .placeholder(R.drawable.ic_launcher_foreground)
                    .into(holder.sthumbnail);

    }
    @Override
    public int getItemCount() {
        return data.size();
    }

    public  class viewHolder  extends RecyclerView.ViewHolder{
        TextView stitle;
        TextView ssubtitle;
        ImageView sthumbnail;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            stitle=itemView.findViewById(R.id.stitle);
            ssubtitle=itemView.findViewById(R.id.ssubtitle);
            sthumbnail=itemView.findViewById(R.id.sthumbnail);
        }
    }
}
