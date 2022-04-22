package com.rrinc.pustice;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

public class TechprofileActivity extends AppCompatActivity {

    InterstitialAd mInterstitialAd;
    AdView mAdView;
    ImageView image;
    ImageView image1;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_techprofile);

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

        image=(ImageView) findViewById(R.id.tp);
        image1=(ImageView) findViewById(R.id.td);
        textView=(TextView)findViewById(R.id.inl);

        Intent intent = getIntent();

        image.setImageResource(intent.getIntExtra("image",0));
        image1.setImageResource(intent.getIntExtra("image2",0));
        textView.setText(intent.getStringExtra("inti"));
    }
}
