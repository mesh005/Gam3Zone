package com.example.gam3zone.games;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.gam3zone.R;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class ActivityGames extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_games);

        TabLayout tabLayout =findViewById(R.id.tabBar);
        TabItem tabTop = findViewById(R.id.tabTop);
        TabItem tabPopular = findViewById(R.id.tabPopular);
        TabItem tabNew = findViewById(R.id.tabNew);
        ViewPager viewPager = findViewById(R.id.viewPager);

        GamePagerAdapter pagerAdapter = new
                GamePagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());

        viewPager.setAdapter(pagerAdapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                viewPager.setCurrentItem(tab.getPosition());

                if (tab.getPosition() == 0) {                    pagerAdapter.notifyDataSetChanged();
                }
                else if (tab.getPosition() == 1) {
                    pagerAdapter.notifyDataSetChanged();
                }
                else if (tab.getPosition() ==2 ) {
                    pagerAdapter.notifyDataSetChanged();
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }
}