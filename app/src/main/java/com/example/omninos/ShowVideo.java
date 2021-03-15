package com.example.omninos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import java.util.ArrayList;
import java.util.List;

public class ShowVideo extends AppCompatActivity {
TextView tittle;
List<videos> list=new ArrayList<>();
    RecyclerView sr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_video);

        sr=findViewById(R.id.srecyclerview);
        categories videodata= (categories) getIntent().getSerializableExtra("VideosData");
        int position= getIntent().getIntExtra("position",0);
         VideoView videoView = (VideoView)findViewById(R.id.VideoView);
//       //videoView.setVideoPath(String.valueOf(videodata.sources));
        MediaController mediaController= new MediaController(this);
        mediaController.setAnchorView(videoView);

        //specify the location of media file
        Uri uri=Uri.parse(videodata.videos.get(position).sources.get(0));
        //Setting MediaController and URI, then starting the videoView
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(uri);
        videoView.requestFocus();
        videoView.start();
        tittle=findViewById(R.id.titles);
       tittle.setText(videodata.videos.get(position).title);
list=videodata.videos;
list.remove(position);
        sr.setLayoutManager(new LinearLayoutManager(getBaseContext()));

        sr.setAdapter(new SuggestionAdapter(list,position));

    }
}