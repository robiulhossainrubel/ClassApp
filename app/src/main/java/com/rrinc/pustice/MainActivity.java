package com.rrinc.pustice;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.rrinc.pustice.view.NotesActivity;

public class MainActivity extends AppCompatActivity {

    InterstitialAd mInterstitialAd;
    AdView mAdView;

    String[] studentName;

    int[] pics={
            R.drawable.mitu,
            R.drawable.himel,
            R.drawable.atik,
            R.drawable.motin,
            R.drawable.faruk,
            R.drawable.mia,
            R.drawable.un,
            R.drawable.masud,
            R.drawable.ratul,
            R.drawable.sowrob,
            R.drawable.mehedi,
            R.drawable.arif,
            R.drawable.akash,
            R.drawable.rubel,
            R.drawable.emran,
            R.drawable.nyme,
            R.drawable.sohan,
            R.drawable.mizan,
            R.drawable.sagor,
            R.drawable.sumiya,
            R.drawable.shadat,
            R.drawable.emu,
            R.drawable.molla,
            R.drawable.khairul,
            R.drawable.hasan,
            R.drawable.shadin,
            R.drawable.halim,
            R.drawable.rifat,
            R.drawable.monju,
            R.drawable.sadia,
            R.drawable.sohag,
            R.drawable.ny,
            R.drawable.shahin,
            R.drawable.bappy,
            R.drawable.joy,
            R.drawable.sorif,
            R.drawable.mahi,
            R.drawable.sakib,
            R.drawable.mahfuz,
            R.drawable.islam,
            R.drawable.blankpp,
            R.drawable.blankpp1,
            R.drawable.blankpp2
    };

    private GridLayout gridLayout;
    private TextView textView;
    private TextView textView1;
    private ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

        studentName = getResources().getStringArray(R.array.studentsArray);

        textView=(TextView) findViewById(R.id.ID);
        textView1=(TextView) findViewById(R.id.username);
        imageView=(ImageView) findViewById(R.id.userpic);
        gridLayout = (GridLayout)findViewById(R.id.gridLay);
        setSingleEvent(gridLayout);



        String idf = getIntent().getStringExtra("id");


        assert idf != null;
        if(idf.equals("190601")){

            textView1.setText( studentName[0]);
            imageView.setImageResource(pics[0]);
        }
        else if(idf.equals("190602")){

            textView1.setText( studentName[1]);
            imageView.setImageResource(pics[1]);
        }
        else if(idf.equals("190603")){

            textView1.setText( studentName[2]);
            imageView.setImageResource(pics[2]);
        }
        else if(idf.equals("190604")){

            textView1.setText( studentName[3]);
            imageView.setImageResource(pics[3]);
        }
        else if(idf.equals("190605")){

            textView1.setText( studentName[4]);
            imageView.setImageResource(pics[4]);
        }
        else if(idf.equals("190606")){

            textView1.setText( studentName[5]);
            imageView.setImageResource(pics[5]);
        }
        else if(idf.equals("190607")){

            textView1.setText( studentName[6]);
            imageView.setImageResource(pics[6]);
        }
        else if(idf.equals("190608")){

            textView1.setText( studentName[7]);
            imageView.setImageResource(pics[7]);
        }
        else if(idf.equals("190609")){

            textView1.setText( studentName[8]);
            imageView.setImageResource(pics[8]);
        }
        else if(idf.equals("190610")){

            textView1.setText( studentName[9]);
            imageView.setImageResource(pics[9]);
        }
        else if(idf.equals("190611")){

            textView1.setText( studentName[10]);
            imageView.setImageResource(pics[10]);
        }
        else if(idf.equals("190612")){

            textView1.setText( studentName[11]);
            imageView.setImageResource(pics[11]);
        }
        else if(idf.equals("190613")){

            textView1.setText( studentName[12]);
            imageView.setImageResource(pics[12]);
        }
        else if(idf.equals("190614")){

            textView1.setText( studentName[13]);
            imageView.setImageResource(pics[13]);
        }
        else if(idf.equals("190615")){

            textView1.setText( studentName[14]);
            imageView.setImageResource(pics[14]);
        }
        else if(idf.equals("190616")){

            textView1.setText( studentName[15]);
            imageView.setImageResource(pics[15]);
        }
        else if(idf.equals("190617")){

            textView1.setText( studentName[16]);
            imageView.setImageResource(pics[16]);
        }
        else if(idf.equals("190618")){

            textView1.setText( studentName[17]);
            imageView.setImageResource(pics[17]);
        }
        else if(idf.equals("190619")){

            textView1.setText( studentName[18]);
            imageView.setImageResource(pics[18]);
        }
        else if(idf.equals("190620")){

            textView1.setText( studentName[19]);
            imageView.setImageResource(pics[19]);
        }
        else if(idf.equals("190621")){

            textView1.setText( studentName[20]);
            imageView.setImageResource(pics[20]);
        }
        else if(idf.equals("190622")){

            textView1.setText( studentName[21]);
            imageView.setImageResource(pics[21]);
        }
        else if(idf.equals("190623")){

            textView1.setText( studentName[22]);
            imageView.setImageResource(pics[22]);
        }
        else if(idf.equals("190624")){

            textView1.setText( studentName[23]);
            imageView.setImageResource(pics[23]);
        }
        else if(idf.equals("190625")){

            textView1.setText( studentName[24]);
            imageView.setImageResource(pics[24]);
        }else if(idf.equals("190626")){

            textView1.setText( studentName[25]);
            imageView.setImageResource(pics[25]);
        }else if(idf.equals("190627")){

            textView1.setText( studentName[26]);
            imageView.setImageResource(pics[26]);
        }else if(idf.equals("190628")){

            textView1.setText( studentName[27]);
            imageView.setImageResource(pics[27]);
        }else if(idf.equals("190629")){

            textView1.setText( studentName[28]);
            imageView.setImageResource(pics[28]);
        }else if(idf.equals("190630")){

            textView1.setText( studentName[29]);
            imageView.setImageResource(pics[29]);
        }else if(idf.equals("190631")){

            textView1.setText( studentName[30]);
            imageView.setImageResource(pics[30]);
        }else if(idf.equals("190632")){

            textView1.setText( studentName[31]);
            imageView.setImageResource(pics[31]);
        }else if(idf.equals("190633")){

            textView1.setText( studentName[32]);
            imageView.setImageResource(pics[32]);
        }else if(idf.equals("190634")){

            textView1.setText( studentName[33]);
            imageView.setImageResource(pics[33]);
        }else if(idf.equals("190635")){

            textView1.setText( studentName[34]);
            imageView.setImageResource(pics[34]);
        }else if(idf.equals("190636")){

            textView1.setText( studentName[35]);
            imageView.setImageResource(pics[35]);
        }else if(idf.equals("190637")){

            textView1.setText( studentName[36]);
            imageView.setImageResource(pics[36]);
        }else if(idf.equals("190638")){

            textView1.setText( studentName[37]);
            imageView.setImageResource(pics[37]);
        }else if(idf.equals("190639")){

            textView1.setText( studentName[38]);
            imageView.setImageResource(pics[38]);
        }else if(idf.equals("190640")){

            textView1.setText( studentName[39]);
            imageView.setImageResource(pics[39]);
        }else if(idf.equals("180629")){

            textView1.setText( studentName[40]);
            imageView.setImageResource(pics[40]);
        }
        else if(idf.equals("180635")){

            textView1.setText( studentName[41]);
            imageView.setImageResource(pics[41]);
        }
        else if(idf.equals("180639")){

            textView1.setText( studentName[42]);
            imageView.setImageResource(pics[42]);
        }else {
            textView1.setText("Guest");
            imageView.setImageResource(R.drawable.blankpp);
        }

        textView.setText(idf);

        }


    private void setSingleEvent(GridLayout gridLayout) {

        for(int i=0;i<gridLayout.getChildCount();i++){

            final CardView cardView=(CardView)gridLayout.getChildAt(i);
            final int finalI=i;

            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    String na=textView1.getText().toString();

                    if (finalI==0){

                        Intent intent=new Intent(MainActivity.this,AlluserActivity.class);
                        intent.putExtra("na",na);
                        startActivity(intent);
                    }else if(finalI==1){

                            Intent lonintent=getPackageManager().getLaunchIntentForPackage("com.rrinc.routinepust");
                            if (lonintent !=null){
                                startActivity(lonintent);
                            }else {
                                Toast.makeText(getApplicationContext(),"Get it On GooglePlay",Toast.LENGTH_SHORT).show();
                                open();
                            }

                    }else if(finalI==2) {
                        Intent intent = new Intent(MainActivity.this, TeachersActivity.class);
                        startActivity(intent);
                    }else if(finalI==3) {
                        Intent intent = new Intent(MainActivity.this, NotesActivity.class);
                        startActivity(intent);

                    }else if(finalI==4) {
                        Intent intent = new Intent(MainActivity.this, WebActivity.class);
                        startActivity(intent);
                    }else if(finalI==5) {
                        Intent intent = new Intent(MainActivity.this, AboutdevActivity.class);
                        intent.putExtra("na",na);
                        startActivity(intent);
                    }

                }
            });

        }
    }

    @Override
    public void onBackPressed() {


        AlertDialog.Builder builder=new AlertDialog.Builder(this);

        builder.setMessage("Do You Want To Exit?")
        .setCancelable(false)
        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                MainActivity.super.onBackPressed();
            }
        })

        .setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                dialog.cancel();
            }
        });

        AlertDialog alertDialog=builder.create();
        alertDialog.show();

    }

    public void open(){
        Intent bintent=new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.ap_link)));
        startActivity(bintent);
    }

}
