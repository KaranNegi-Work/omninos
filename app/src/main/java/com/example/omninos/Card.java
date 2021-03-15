package com.example.omninos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class Card extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);
        RecyclerView recyclerView= findViewById(R.id.recyclerView2);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
String[] data={"Black space","Fifty Shades","Havana","Dua","Party All night","Disco","Chain","Koi mil Gya","Robot","Tere Sang","Soch na sake","Nain","Rata Kaliya","Sawan","Barish","Mitti","Teri or"};
        recyclerView.setAdapter(new CAdapter(data));
    }
}