package com.rrinc.pustice;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

public class TeachersActivity extends AppCompatActivity {


    InterstitialAd mInterstitialAd;
    AdView mAdView;

    private ListView listView;
    private String[] tintal={"MOF","MAH","---","IA","---","PKP","MSH","SS","TNT","AFMZA"};

    private int[] tlpics={
            R.drawable.moflv,
            R.drawable.ahlv,
            R.drawable.ihlv,
            R.drawable.ialv,
            R.drawable.malv,
            R.drawable.pkplv,
            R.drawable.shlv,
            R.drawable.sslv,
            R.drawable.tntlv,
            R.drawable.zalv
    };
    private int[] tpics={
            R.drawable.mof,
            R.drawable.ah,
            R.drawable.ih,
            R.drawable.ia,
            R.drawable.ma,
            R.drawable.pkp,
            R.drawable.sh,
            R.drawable.ss,
            R.drawable.tnt,
            R.drawable.za
    };
    private int[] tdpics={
            R.drawable.mofd,
            R.drawable.ahd,
            R.drawable.ihd,
            R.drawable.iad,
            R.drawable.mad,
            R.drawable.pkpd,
            R.drawable.shd,
            R.drawable.ssd,
            R.drawable.tntd,
            R.drawable.zad
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teachers);

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

        listView= (ListView) findViewById(R.id.listViewIdt);

        final CustomAdapter customAdapter = new CustomAdapter();
        listView.setAdapter(customAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getApplicationContext(),TechprofileActivity.class);
                intent.putExtra("image",tpics[position]);
                intent.putExtra("image2",tdpics[position]);
                intent.putExtra("inti",tintal[position]);
                startActivity(intent);
            }
        });

    }

    private class CustomAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return tlpics.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view1=getLayoutInflater().inflate(R.layout.teach_sampleview,null);

            ImageView image=view1.findViewById(R.id.tecPic);
            ImageView image1=view1.findViewById(R.id.tp);
            ImageView image2=view1.findViewById(R.id.td);
            TextView textView=view1.findViewById(R.id.inl);


            image.setImageResource(tlpics[position]);


            return view1;
        }
    }
}
