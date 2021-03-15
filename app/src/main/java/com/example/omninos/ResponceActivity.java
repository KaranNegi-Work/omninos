package com.example.omninos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.omninos.modelClasses.DetailsClass;
import com.example.omninos.modelClasses.ResponseClass;
import com.example.omninos.modelClasses.imageAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ResponceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_responce);

        String baseURL="http://ominos.in/docWorldApplication/index.php/api/user/slider/";
//        b.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
        RecyclerView r2= findViewById(R.id.recyclerView);
                Retrofit retrofit=new Retrofit.Builder().baseUrl(baseURL).addConverterFactory(GsonConverterFactory.create()).build();
                OmninosServiceClass myservice=retrofit.create(OmninosServiceClass.class);
                Call<ResponseClass> responseClassCall=myservice.getResponse();
                Toast.makeText(getApplicationContext(),"Button Is clicked 1", Toast.LENGTH_SHORT).show();
                responseClassCall.enqueue(new Callback<ResponseClass>() {

                  //   Toast.makeText(getApplicationContext(),"Button Is clicked 2", Toast.LENGTH_SHORT).show();
                    @Override
                    public void onResponse(Call<ResponseClass> call, Response<ResponseClass> response) {
                        Log.e("Response ",""+ response.body().toString());
                        if(response.isSuccessful()){
                            Toast.makeText(getApplicationContext(),"Button Is clicked", Toast.LENGTH_SHORT).show();
                            ResponseClass data= response.body();
                            List<DetailsClass> loadImage=data.getDetails();
                            //DetailsClass r=loadImage.get(1);


                            r2.setLayoutManager(new LinearLayoutManager(getBaseContext()));
                            r2.setAdapter(new imageAdapter(loadImage));
//                            Glide.with(getBaseContext())
//                                    .load(r.getSliderImage())
//                                    .placeholder(R.drawable.ic_launcher_foreground)
//                                    .into(imageView);
                            //textView.setText(r.getSliderImage());
                            Log.e("Response ",""+response.body());
                        }

                    }
                    @Override
                    public void onFailure(Call<ResponseClass> call, Throwable t) {
                        Toast.makeText(getApplicationContext(),"Button Is clicked fail", Toast.LENGTH_SHORT).show();
                    }
                });

            }
//        });
//          }
}