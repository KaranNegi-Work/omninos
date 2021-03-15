package com.example.omninos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class test extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyler_view);
        RecyclerView r= findViewById(R.id.recyclerView);
        r.setLayoutManager(new LinearLayoutManager(this));
        String[] data={"Java","c++","Python","Spring","Spring Boot","MVC","Java Script","SQL","DS","HTML","CSS","Java","c++","Python","Spring","Spring Boot","MVC","Java Script","SQL","DS","HTML","CSS"};
        r.setAdapter(new Adapter(data));
    }
}