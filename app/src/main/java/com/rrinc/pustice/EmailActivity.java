package com.rrinc.pustice;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

public class EmailActivity extends AppCompatActivity {


    InterstitialAd mInterstitialAd;
    AdView mAdView;

    EditText etmsg;
    Button seml;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);

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

        etmsg = (EditText) findViewById(R.id.emailmsg);
        seml = (Button) findViewById(R.id.btnsnt);

        seml.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {

                    String name = getIntent().getStringExtra("mlrn");
                    String msg = etmsg.getText().toString();

                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setType("text/email");
                    intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"rubyroseinc2018@gmail.com"});
                    intent.putExtra(Intent.EXTRA_SUBJECT, "Feed back from PUSTICE");
                    intent.putExtra(Intent.EXTRA_TEXT, "Name : " + name + "\n\nMessage : " + msg);
                    startActivity(Intent.createChooser(intent, "Choose an email client : "));

                } catch (Exception e) {

                    Toast.makeText(getApplicationContext(),"Exception : "+e,Toast.LENGTH_SHORT).show();

                }

            }
        });

    }

    public void showAd(){
        if (mInterstitialAd.isLoaded()){
            mInterstitialAd.show();
        }else {
            finish();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        showAd();
    }
}
