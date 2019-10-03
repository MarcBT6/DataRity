package com.example.datarity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;
import android.widget.GridLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements  CabeceraAdapter.OnClickListener {

    private CabeceraAdapter cabeceraAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(gridLayoutManager);

        ArrayList<Header> myDataset = new ArrayList<>();
        myDataset.add(new Header("Nombre"));
        myDataset.add(new Header("Nombre"));
        myDataset.add(new Header("Nombre"));
        myDataset.add(new Header("Nombre"));
        myDataset.add(new Header("Nombre"));
        myDataset.add(new Header("Nombre"));
        myDataset.add(new Header("Nombre"));
        cabeceraAdapter = new CabeceraAdapter(myDataset,this);
        recyclerView.setAdapter(cabeceraAdapter);

    }

    @Override
    public void onClick(int pos) {
        //Intent intent = new Intent(this,Detalles.class);
        Toast.makeText(this,"Pos num: "+pos+" clicked",Toast.LENGTH_SHORT).show();
    }
}
