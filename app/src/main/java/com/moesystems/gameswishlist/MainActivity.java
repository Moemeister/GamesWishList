package com.moesystems.gameswishlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView rv;
    GamesAdapter adapter;
    ArrayList<Games> game;
    LinearLayoutManager lManager;
    int var =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        game= new ArrayList<>();
        rv= findViewById(R.id.recycler);
        rv.setHasFixedSize(true);

        lManager = new LinearLayoutManager(this);
        rv.setLayoutManager(lManager);

        prepareSeries();

        adapter = new GamesAdapter(game);
        rv.setAdapter(adapter);
    }

    private void prepareSeries() {

        String TAG = "Mensaje";
        game = new ArrayList<>();
        game.add(new Games("Counter Strike", R.drawable.csgo,"A FPS game"));



    }
//

    public void btnFav(View v){
        ImageButton ib = findViewById(R.id.fav_vacio);
        if (var == 0 ){
            ib.setImageResource(R.drawable.yellow);
            var=1;
        }
        else if(var == 1){
            ib.setImageResource(R.drawable.star);
            var=0;
        }


    }
}
