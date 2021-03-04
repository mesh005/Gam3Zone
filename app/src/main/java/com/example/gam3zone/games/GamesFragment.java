package com.example.gam3zone.games;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gam3zone.MainUI.PagerAdapter;
import com.example.gam3zone.MainUI.feed.NintendoFragment;
import com.example.gam3zone.MainUI.feed.PlaystationFragment;
import com.example.gam3zone.MainUI.feed.XboxFragment;
import com.example.gam3zone.R;
import com.example.gam3zone.games.fragments.NewGamesFragment;
import com.example.gam3zone.games.fragments.PopularGamesFragment;
import com.example.gam3zone.games.fragments.TopGamesFragment;
import com.google.android.material.tabs.TabLayout;


public class GamesFragment extends Fragment {

    View myFragment;

    ViewPager viewPager;
    TabLayout tabLayout;


    public GamesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        myFragment = inflater.inflate(R.layout.fragment_games, container, false);
        viewPager = myFragment.findViewById(R.id.viewPager);
        tabLayout = myFragment.findViewById(R.id.tabBar);

        return  myFragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setUpViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void setUpViewPager(ViewPager viewPager) {
        PagerAdapter adapter = new PagerAdapter(getChildFragmentManager());

        adapter.addFragment(new TopGamesFragment(), "Top");
        adapter.addFragment(new PopularGamesFragment(), "Popular");
        adapter.addFragment(new NewGamesFragment(), "New");

        viewPager.setAdapter(adapter);
    }


}


