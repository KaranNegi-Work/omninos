package com.example.omninos;

import android.content.Context;
import android.content.Intent;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;
import java.util.zip.Inflater;

import retrofit2.Callback;

public class VideosAdapter extends RecyclerView.Adapter<VideosAdapter.viewHolder> {
    Cat data;
    onClickPost onClickPost;
    Context context;
    VideosAdapter(Context context, Cat data, onClickPost onClickPost){
        this.onClickPost=onClickPost;
        this.data=  data;
        this.context=context;
    }
    @NonNull
    @Override
    public VideosAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view =inflater.inflate(R.layout.videotemplate,parent,false);
        return new VideosAdapter.viewHolder(view,onClickPost);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        categories c=data.categories.get(0);
        Glide.with(holder.thumbnail.getContext())
                .load(c.videos.get(position).thumb)
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(holder.thumbnail);
        holder.title.setText(c.videos.get(position).title);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickPost.postClicked(position);
            }
        });
    }

    @Override
    public int getItemCount() {

        return data.categories.get(0).videos.size();
    }

    class viewHolder extends RecyclerView.ViewHolder{
        ImageView thumbnail;
        TextView title;
        onClickPost onClickPost2;
        public viewHolder(@NonNull View itemView,onClickPost onClickPost) {
            super(itemView);
            this.onClickPost2 =onClickPost;
            thumbnail=itemView.findViewById(R.id.thumbnail);
            title=itemView.findViewById(R.id.title);

        }


    }
}
