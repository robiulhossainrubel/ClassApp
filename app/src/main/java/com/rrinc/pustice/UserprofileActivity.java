package com.rrinc.pustice;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

public class UserprofileActivity extends AppCompatActivity {


    InterstitialAd mInterstitialAd;
    AdView mAdView;
    ImageView image;
    TextView name;
    TextView dist;
    TextView blood;
    TextView nick;
    TextView roll;
    TextView email;
    TextView phn;
    LinearLayout call,mail;
    TextView bod;
    TextView school;
    TextView college;
    String n,d,b,ni,ro,e,p,bo,s,c;
    int im;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userprofile);

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

        image=(ImageView) findViewById(R.id.uPic);
        name=(TextView) findViewById(R.id.uName);
        dist=(TextView) findViewById(R.id.uD);
        blood=(TextView)findViewById(R.id.blood);
        nick=(TextView)findViewById(R.id.nick);
        roll=(TextView)findViewById(R.id.rol);
        email=(TextView)findViewById(R.id.eMail);
        phn=(TextView)findViewById(R.id.uPhn);
        bod=(TextView)findViewById(R.id.bod);
        school=(TextView)findViewById(R.id.schl);
        college=(TextView)findViewById(R.id.clg);


        call=(LinearLayout)findViewById(R.id.call);
        mail=(LinearLayout)findViewById(R.id.sMail);



        im=getIntent().getIntExtra("image",0);
        n=getIntent().getStringExtra("name");
        d=getIntent().getStringExtra("dist");
        b=getIntent().getStringExtra("blood");
        ni=getIntent().getStringExtra("nick");
        ro=getIntent().getStringExtra("roll");
        e=getIntent().getStringExtra("emil");
        p=getIntent().getStringExtra("phn");
        bo=getIntent().getStringExtra("bod");
        s=getIntent().getStringExtra("schl");
        c=getIntent().getStringExtra("clg");

        image.setImageResource(im);
        name.setText(n);
        dist.setText(d);
        blood.setText(b);
        nick.setText(ni);
        roll.setText(ro);
        email.setText(e);
        phn.setText(p);
        bod.setText(bo);
        school.setText(s);
        college.setText(c);




        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentCall=new Intent(Intent.ACTION_CALL);
                String value=phn.getText().toString();

                    intentCall.setData(Uri.parse("tel:"+value));

                if(ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(getApplicationContext(),"Please grant permission",Toast.LENGTH_SHORT).show();
                    requestPermission();
                }else {
                    startActivity(intentCall);
                }

            }
        });

        mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    String semail=email.getText().toString();

                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setType("text/email");
                    intent.putExtra(Intent.EXTRA_EMAIL, new String[]{semail});
                    intent.putExtra(Intent.EXTRA_SUBJECT, "Mail from PUSTICE Family");
                    intent.putExtra(Intent.EXTRA_TEXT, "From : "+"\n\n");
                    startActivity(Intent.createChooser(intent, "Choose an email client : "));

                } catch (Exception e) {

                    Toast.makeText(getApplicationContext(),"Exception : "+e,Toast.LENGTH_SHORT).show();

                }
            }
        });

    }
    private  void requestPermission(){
        ActivityCompat.requestPermissions(UserprofileActivity.this,new String[]{Manifest.permission.CALL_PHONE},1);
    }
}
