package com.moesystems.gameswishlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView rv;
    GamesAdapter adapter;
    ArrayList<Games> game,bm;
    LinearLayoutManager lManager;
    Button btn1;
    Button btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        game= new ArrayList<>();
        bm= new ArrayList<>();
        btn1 = findViewById(R.id.games);
        btn2 = findViewById(R.id.fav);


        rv= findViewById(R.id.recycler);
        rv.setHasFixedSize(true);

        lManager = new LinearLayoutManager(this);
        rv.setLayoutManager(lManager);

        prepareSeries();

        adapter = new GamesAdapter(game,this);
        rv.setAdapter(adapter);

    }
    //Funciones onclick para los botones del menu
    public void boton1_list(View v){
        adapter.setFalse();
        adapter = new GamesAdapter(game,v.getContext());
        rv.setAdapter(adapter);
    }
    public void boton2_bookmark(View v){
        adapter.setTrue();
        adapter = new GamesAdapter(bm,v.getContext());
        rv.setAdapter(adapter);
    }

    private void prepareSeries() {

        String TAG = "Mensaje";
        game = new ArrayList<>();
        game.add(new Games("Counter Strike", R.drawable.csgo,"A FPS game"));
        game.add(new Games("Hollow Knight", R.drawable.hollow,"A Platform game"));
        game.add(new Games("Fortnite", R.drawable.fortnite,"A Survival game"));
        game.add(new Games("God of War", R.drawable.gow,"An Action-adventure game"));

    }
    //funcion para agregar a los marcadores
    public void addBookmark(Games wishlist){
        bm.add(wishlist);
    }
    //funcion para quitar de los marcadores
    // se recorre la lista de marcadores y si encuentra uno con un nombre que este en la lista original
    // rompe el ciclo y se quitar del arraylist
    // y se le da f5 para ver que se quito con el isOnBookmark
    public void quitar(String GameName){
        int counter=0;

        for(Games game : bm){
            if(game.getName() == GameName){
                break;
            }
            counter++;
        }
        bm.remove(counter);
        if(adapter.isOnBookmark()){
            adapter = new GamesAdapter(bm, this);
            rv.setAdapter(adapter);
        }
    }
}
