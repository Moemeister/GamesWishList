package com.moesystems.gameswishlist;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by gerar on 24/4/2018.
 */

public class GamesAdapter extends RecyclerView.Adapter<GamesAdapter.GamesViewHolder> {
    private ArrayList<Games> game;
    
    public GamesAdapter(ArrayList<Games> series) {
        this.game = series;
    }


    public class GamesViewHolder extends RecyclerView.ViewHolder {
        CardView card;
        TextView name;
        ImageView img;

        public GamesViewHolder(View itemview) {
            super(itemview);
            card = itemview.findViewById(R.id.card_view);
            name = itemview.findViewById(R.id.name);
            img = itemview.findViewById(R.id.img);

        }
    }
    @Override
    public GamesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.actvity_cardview,parent,false);
        return (new GamesViewHolder(v));
    }

    @Override
    public void onBindViewHolder(GamesViewHolder holder, int position) {
        holder.name.setText(game.get(position).getName());
        holder.img.setImageResource(game.get(position).getImg());
    }

    @Override
    public int getItemCount() {
        return game.size();
    }

}

