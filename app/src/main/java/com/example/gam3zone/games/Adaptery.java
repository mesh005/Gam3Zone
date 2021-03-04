package com.example.gam3zone.games;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.gam3zone.R;
import com.example.gam3zone.games.fragments.GameDetailsFragment;

import java.util.List;

public class Adaptery extends RecyclerView.Adapter<Adaptery.MyViewHolder> {

    private Context mContext;
    private List<GameModelClass> mData;
    private Game gameModel;

    public Adaptery(Context mContext, List<GameModelClass> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        v = inflater.inflate(R.layout.game_item, parent, false);

         return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.id.setText(mData.get(position).getId());
        holder.name.setText(mData.get(position).getName());

     //   Usr Glide library to display the image
        Glide.with(mContext)
                .load(mData.get(position).getImg())
                .into(holder.img);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (AppCompatActivity)v.getContext();

                //send data from fragment to fragment
                Bundle bundle = new Bundle();


                GameDetailsFragment gameDetailsFragment= new GameDetailsFragment();
                gameDetailsFragment.setArguments(bundle);

                activity.getSupportFragmentManager().beginTransaction()
                        .replace(R.id.gamesFragment, gameDetailsFragment)
                        .setReorderingAllowed(true)
                        .addToBackStack(null)
                        .commit();
            }

        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    public  static class  MyViewHolder extends RecyclerView.ViewHolder
{

        TextView id;
        TextView name;
        ImageView img;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.id_txt);
            name = itemView.findViewById(R.id.name_txt);
            img = itemView.findViewById(R.id.imageView);
        }


    }
}
