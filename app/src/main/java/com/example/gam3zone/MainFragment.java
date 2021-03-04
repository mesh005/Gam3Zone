package com.example.gam3zone;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toolbar;

import com.example.gam3zone.MainUI.exploreFragment;
import com.example.gam3zone.MainUI.feed.feedFragment;
import com.example.gam3zone.MainUI.profileFragment;
import com.example.gam3zone.MainUI.savedFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainFragment extends Fragment {

    View myFragment;

    Toolbar myToolbar;
    BottomNavigationView bottomNavigationView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

//        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //configure toolbar
     //   myToolbar = getActivity().findViewById(R.id.myToolbar);


        //configure bottom nav
        bottomNavigationView = getActivity().findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_main, new feedFragment()).commit();

    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            switch (item.getItemId()) {
                case R.id.feedFragment:
                    fragmentTransaction.replace(R.id.fragment_main, new feedFragment()).commit();
                    return true;
                case R.id.exploreFragment:
                    fragmentTransaction.replace(R.id.fragment_main, new exploreFragment()).commit();
                    return true;
                case R.id.savedFragment:
                    fragmentTransaction.replace(R.id.fragment_main, new savedFragment()).commit();
                    return true;
                case R.id.profileFragment:
                    fragmentTransaction.replace(R.id.fragment_main, new profileFragment()).commit();
                    return true;
            }
            return false;
        }

    };
}