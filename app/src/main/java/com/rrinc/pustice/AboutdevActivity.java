package com.rrinc.pustice;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import android.view.View;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class AboutdevActivity extends AppCompatActivity {

    FloatingActionButton sent,share;
    InterstitialAd mInterstitialAd;
    AdView mAdView;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutdev);

        MobileAds.initialize(this,getString(R.string.app_id));
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(getString(R.string.ads_initial));
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
        mInterstitialAd.setAdListener(new AdListener(){
            @Override
            public void onAdClosed(){
                super.onAdClosed();
                finish();
            }
        });

        mAdView = (AdView)findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        sent=(FloatingActionButton)findViewById(R.id.senteml);
        share=(FloatingActionButton)findViewById(R.id.shareid);

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                String sub="PUSTICE";
                String body="This app help to find your department friends information and teachers information,Routine and so on.\n com.rrinc.pustice";

                intent.putExtra(Intent.EXTRA_SUBJECT,sub);
                intent.putExtra(Intent.EXTRA_TEXT,body);
                startActivity(Intent.createChooser(intent,"Share With"));
            }
        });


        sent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String na=getIntent().getStringExtra("na");
                Intent intent = new Intent(AboutdevActivity.this, EmailActivity.class);
                intent.putExtra("mlrn",na);
                startActivity(intent);
            }
        });

    }

}
