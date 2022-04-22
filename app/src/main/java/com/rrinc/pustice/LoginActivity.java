package com.rrinc.pustice;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.rrinc.pustice.support.User;

public class LoginActivity extends AppCompatActivity {

    InterstitialAd mInterstitialAd;
    AdView mAdView;

    private EditText Roll;
    private Button Login;
    private TextView Info,guest;
    private int count = 3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

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


        Roll = (EditText) findViewById(R.id.eroll);
        Info = (TextView) findViewById(R.id.tvInfo);
        guest = (TextView) findViewById(R.id.guest);
        Login = (Button) findViewById(R.id.elogin);
        Info.setText("No of attemts remaining : 3");


        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String txt_roll = Roll.getText().toString();
                validate(txt_roll);


            }
        });

        guest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent accountsIntent = new Intent(LoginActivity.this, MainActivity.class);
                accountsIntent.putExtra("id","Visitor");
                startActivity(accountsIntent);
                finish();
            }
        });


    }

    private void validate(String URoll) {

        if ((URoll.equals("190601")) || (URoll.equals("190602")) || (URoll.equals("190603")) || (URoll.equals("190604")) || (URoll.equals("190605")) ||
                (URoll.equals("190606")) || (URoll.equals("190607")) || (URoll.equals("190608")) || (URoll.equals("190609")) || (URoll.equals("190610")) ||
                (URoll.equals("190611")) || (URoll.equals("190612")) || (URoll.equals("190613")) || (URoll.equals("190614")) || (URoll.equals("190615")) ||
                (URoll.equals("190616")) || (URoll.equals("190617")) || (URoll.equals("190618")) || (URoll.equals("190619")) || (URoll.equals("190620")) ||
                (URoll.equals("190621")) || (URoll.equals("190622")) || (URoll.equals("190623")) || (URoll.equals("190624")) || (URoll.equals("190625")) ||
                (URoll.equals("190626")) || (URoll.equals("190627")) || (URoll.equals("190628")) || (URoll.equals("190629")) || (URoll.equals("190630")) ||
                (URoll.equals("190631")) || (URoll.equals("190632")) || (URoll.equals("190633")) || (URoll.equals("190634")) || (URoll.equals("190635")) ||
                (URoll.equals("190636")) || (URoll.equals("190637")) || (URoll.equals("190638")) || (URoll.equals("190639")) || (URoll.equals("190640")) ||
                (URoll.equals("180629")) || (URoll.equals("180635")) || (URoll.equals("180639"))) {

            User user =new User(LoginActivity.this);
            user.setID(URoll);
            Intent accountsIntent = new Intent(LoginActivity.this, MainActivity.class);
            accountsIntent.putExtra("id",URoll);
            startActivity(accountsIntent);
            finish();

        } else {
            count--;
            Toast.makeText(getApplicationContext(), "Incorrect ID", Toast.LENGTH_SHORT).show();
            Info.setText("No of attemts remaining: " + String.valueOf(count));
            if (count == 0) {
                Login.setEnabled(false);
            }
        }
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

