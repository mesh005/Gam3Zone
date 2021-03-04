package com.example.gam3zone.games;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.gam3zone.MainUI.feed.NintendoFragment;
import com.example.gam3zone.MainUI.feed.XboxFragment;
import com.example.gam3zone.games.fragments.NewGamesFragment;
import com.example.gam3zone.games.fragments.PopularGamesFragment;
import com.example.gam3zone.games.fragments.TopGamesFragment;

public class GamePagerAdapter  extends FragmentPagerAdapter {

    private  int numOfTabs;

    public GamePagerAdapter (FragmentManager fm, int numOfTabs) {
        super (fm);
        this.numOfTabs = numOfTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new TopGamesFragment();
            case 1:
                return new NewGamesFragment();
            case 2:
                return new PopularGamesFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }


}
