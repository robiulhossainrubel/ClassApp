package com.rrinc.pustice;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import com.rrinc.pustice.support.ViewPageAdapter;

public class TabActivity extends AppCompatActivity {

    InterstitialAd mInterstitialAd;
    AdView mAdView;

    private TabLayout tabLayout;
    private AppBarLayout appBarLayout;
    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);


        tabLayout=(TabLayout) findViewById(R.id.tablayout_id);
        appBarLayout=(AppBarLayout)findViewById(R.id.appbarid);

        viewPager=(ViewPager)findViewById(R.id.viewpager_id);
        ViewPageAdapter adapter=new ViewPageAdapter(getSupportFragmentManager());
        adapter.AddFragment(new FragmentSaturday(),"Saturday");
        adapter.AddFragment(new FragmentSunday(),"Sunday");
        adapter.AddFragment(new FragmentMonday(),"Monday");
        adapter.AddFragment(new FragmentTuesday(),"Tuesday");
        adapter.AddFragment(new FragmentWednesday(),"Wednesday");
        adapter.AddFragment(new FragmentThursday(),"Thursday");
        adapter.AddFragment(new FragmentFriday(),"Friday");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);



    }
}
