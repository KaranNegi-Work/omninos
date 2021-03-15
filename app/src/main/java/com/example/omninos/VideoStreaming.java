package com.example.omninos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Toast;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class VideoStreaming extends AppCompatActivity{
RecyclerView recyclerView;
    Cat data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_streaming);
//        Toast.makeText(getApplicationContext()," S", Toast.LENGTH_SHORT).show();

        Retrofit retrofit=ApiClient.getConnection();
        OmninosServiceClass service=retrofit.create(OmninosServiceClass.class);
        Call<Cat> responseClassCall=service.getVideoData();
        responseClassCall.enqueue(new Callback<Cat>() {
            @Override
            public void onResponse(Call<Cat> call, Response<Cat> response) {

                if(response.isSuccessful()){
                    data=response.body();

                    recyclerView=findViewById(R.id.videorecycleView);


        recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));
        recyclerView.setAdapter(new VideosAdapter(VideoStreaming.this, data, new onClickPost() {
            @Override
            public void postClicked(int position) {
                Toast.makeText(getApplicationContext(),"position= "+position, Toast.LENGTH_SHORT).show();
               Intent intent=new Intent(VideoStreaming.this,ShowVideo.class);
               intent.putExtra("VideosData",data.categories.get(0));
               intent.putExtra("position",position);
               startActivity(intent);
            }
        }));

                }
            }
            @Override
            public void onFailure(Call<Cat> call, Throwable t) {

            }
        });

    }

}