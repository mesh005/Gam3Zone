package com.example.gam3zone.MainUI;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.gam3zone.R;
import com.example.gam3zone.games.ActivityGames;
import com.example.gam3zone.games.GamesFragment;
import com.example.gam3zone.games.fragments.GameDetailsFragment;


public class exploreFragment extends Fragment {
   private Button button;

    public exploreFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
       View view = inflater.inflate(R.layout.fragment_explore, container, false);

       Button button = (Button) view.findViewById(R.id.games_button);
       button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
//               Intent in = new Intent(getActivity(), ActivityGames.class);
//               startActivity(in);
               AppCompatActivity activity = (AppCompatActivity)v.getContext();


               GamesFragment gamesFragment= new GamesFragment();

               activity.getSupportFragmentManager().beginTransaction()
                       .replace(R.id.activity_main, gamesFragment)
                       .setReorderingAllowed(true)
                       .addToBackStack(null)
                       .commit();
           }
       });
       return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
}