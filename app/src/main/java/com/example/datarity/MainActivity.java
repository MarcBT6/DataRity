package com.example.datarity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements  CabeceraAdapter.OnClickListener {

    private CabeceraAdapter cabeceraAdapter;
    ArrayList<Header> myDataset = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(gridLayoutManager);


        /*myDataset.add(new Header("Nombre","https://rickandmortyapi.com/api/character/avatar/1.jpeg"));
        myDataset.add(new Header("Nombre","https://rickandmortyapi.com/api/character/avatar/2.jpeg"));
        myDataset.add(new Header("Nombre","https://rickandmortyapi.com/api/character/avatar/3.jpeg"));
        myDataset.add(new Header("Nombre","https://rickandmortyapi.com/api/character/avatar/4.jpeg"));
        myDataset.add(new Header("Nombre","https://rickandmortyapi.com/api/character/avatar/5.jpeg"));
        myDataset.add(new Header("Nombre","https://rickandmortyapi.com/api/character/avatar/6.jpeg"));
        myDataset.add(new Header("Nombre","https://rickandmortyapi.com/api/character/avatar/7.jpeg"));*/
        cabeceraAdapter = new CabeceraAdapter(myDataset,this);
        recyclerView.setAdapter(cabeceraAdapter);

    }
    private void getPost() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://rickandmortyapi.com/api")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        PostService postService = retrofit.create(PostService.class);
        Call<List<Header>> call = postService.getPost();

        call.enqueue(new Callback<List<Header>>() {
            @Override
            public void onResponse(Call<List<Header>> call, Response<List<Header>> response) {
                for(Header header : response.body()) {
                    myDataset.add(header);
                }
                cabeceraAdapter.notifyDataSetChanged();
            }
            @Override
            public void onFailure(Call<List<Header>> call, Throwable t) {
            }
        });
    }



    @Override
    public void onClick(int pos) {
        Intent intent = new Intent(this,Detalles.class);
        startActivity(intent);
        //Toast.makeText(this,"Pos num: "+pos+" clicked",Toast.LENGTH_SHORT).show();
    }
}
