package com.rrinc.pustice;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;

import com.rrinc.pustice.support.User;

public class SplashActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private int prog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash);

        progressBar=(ProgressBar) findViewById(R.id.pbar);

        final User user =new User(SplashActivity.this);

        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                dowork();
                if (user.getID()!=""){
                    Intent intent=new Intent(SplashActivity.this,MainActivity.class);
                    intent.putExtra("id",user.getID());
                    startActivity(intent);
                    finish();
                }
                else {
                    startApp();
                }

            }
        });

        thread.start();
    }

    public void dowork(){
        for (prog=25;prog<=100;prog=prog+25) {
            try {
                Thread.sleep(1000);
                progressBar.setProgress(prog);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void startApp(){
        Intent intent=new Intent(SplashActivity.this,LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
