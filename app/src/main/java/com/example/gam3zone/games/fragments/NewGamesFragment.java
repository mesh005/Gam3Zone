package com.example.gam3zone.games.fragments;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gam3zone.R;
import com.example.gam3zone.games.Adaptery;
import com.example.gam3zone.games.Game;
import com.example.gam3zone.games.GameList;
import com.example.gam3zone.games.GameModelClass;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class NewGamesFragment extends Fragment {

    final String JSON_URL = "https://api.rawg.io/api/games";

    List<GameModelClass> gameList;
    RecyclerView recyclerView;

    public NewGamesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_top_games, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        gameList = new ArrayList<>();
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);

        NewGamesFragment.GetData getData = new NewGamesFragment.GetData();
        getData.execute();
    }

    public class GetData extends AsyncTask<String, Void, GameList> {

        ProgressDialog progressDialog = new ProgressDialog(getContext());

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog.setMessage("Loading games...please wait...");
            progressDialog.show();
        }


        @Override
        protected GameList doInBackground(String... strings) {

            String current = "";

            try {
                URL url;
                HttpURLConnection urlConnection = null;

                try {
                    url = new URL(JSON_URL);
                    urlConnection = (HttpURLConnection) url.openConnection();

                    InputStream is = urlConnection.getInputStream();
                    InputStreamReader isr = new InputStreamReader(is);
                    Gson gson = new Gson();
                    ///JsonReader reader = new JsonReader(isr);
                    GameList gamelist = gson.fromJson(isr, GameList.class);
                    //data.toScreen(); // prints to screen some values

                    return (GameList) gamelist;
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (urlConnection != null) {
                        urlConnection.disconnect();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(GameList s) {
            progressDialog.dismiss();

            for (Game g : s.getResults()) {
                GameModelClass model = new GameModelClass();
                model.setId(g.getId());
                model.setName(g.getName());
                //model.setImg(jsonObject1.getString("background_image"));

                gameList.add(model);
            }
            PutDataIntoRecyclerView(gameList);
        }


        private void PutDataIntoRecyclerView(List<GameModelClass> gameList) {
            Adaptery adaptery = new Adaptery(getContext(), gameList);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

            recyclerView.setAdapter(adaptery);
        }

    }
}