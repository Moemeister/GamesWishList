package com.moesystems.gameswishlist;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by gerar on 24/4/2018.
 */

public class GamesAdapter extends RecyclerView.Adapter<GamesAdapter.GamesViewHolder> {
    private ArrayList<Games> game;
    //state var
    private static boolean fav = false;

    private Context mContext;

    public GamesAdapter(ArrayList<Games> series,Context cont) {
        this.game = series;
        this.mContext = cont;
    }


    public class GamesViewHolder extends RecyclerView.ViewHolder {
        CardView card;
        TextView name;
        ImageView img;
        ImageButton ib;

        public GamesViewHolder(View itemview) {
            super(itemview);
            card = itemview.findViewById(R.id.card_view);
            name = itemview.findViewById(R.id.name);
            img = itemview.findViewById(R.id.img);
            ib =  itemview.findViewById(R.id.fav_vacio);
        }
    }
    @Override
    public GamesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.actvity_cardview,parent,false);
        return (new GamesViewHolder(v));
    }

    @Override
    public void onBindViewHolder(final GamesViewHolder holder, final int position) {
        holder.name.setText(game.get(position).getName());
        holder.img.setImageResource(game.get(position).getImg());

        if(game.get(position).yesorno())
            holder.ib.setImageResource(R.drawable.yellow);
        else
            holder.ib.setImageResource(R.drawable.star);
        //boton para agregar y quitar
        holder.ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (wishgame(position)){
                    holder.ib.setImageResource(R.drawable.yellow);
                        //Funcion del main que agrega a la lista de favoritos
                        ((MainActivity)mContext).addBookmark(game.get(position));

                }
                else {
                    holder.ib.setImageResource(R.drawable.star);
                        //elimina de favoritos
                        ((MainActivity)mContext).quitar(game.get(position).getName());

                }

            }
        });
    }


    @Override
    public int getItemCount() {
        return game.size();
    }
    public boolean wishgame(int position){
        game.get(position).set(!game.get(position).yesorno());
        return game.get(position).yesorno();
    }
    public void setTrue(){
        fav=true;
    }

    public void setFalse(){
        fav=false;
    }
    public boolean isOnBookmark() {
        return fav;
    }

}

