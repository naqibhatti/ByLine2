package com.example.naqi.byline;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;

import java.util.ArrayList;
import java.util.Objects;

public class FirstTimeActivity extends AppCompatActivity {

    ArrayList<String> ArticleTitles = new ArrayList();
    ArrayList<String> ArticleUrls = new ArrayList();
    ArrayList<String> ArticleImgUrls = new ArrayList();
    ArrayList<String> ArticleDesc = new ArrayList();
    ArrayList<String> ArticleText = new ArrayList();
    ArrayList<String> ArticleChannel = new ArrayList();

    private static int SPLASH_TIME_OUT = 8000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_time);

        Objects.requireNonNull(getSupportActionBar()).hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        ArticleTitles = getIntent().getStringArrayListExtra("ArticlesTitles");
        ArticleUrls = getIntent().getStringArrayListExtra("ArticlesUrls");
        ArticleImgUrls = getIntent().getStringArrayListExtra("ArticlesImgUrls");
        ArticleDesc = getIntent().getStringArrayListExtra("ArticlesDesc");
        ArticleText = getIntent().getStringArrayListExtra("ArticlesText");

        ArticleChannel = getIntent().getStringArrayListExtra("ArticlesChannel");

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                Intent i = new Intent(FirstTimeActivity.this, MainActivity.class);
                i.putStringArrayListExtra("ArticlesTitles", ArticleTitles);
                i.putStringArrayListExtra("ArticlesUrls", ArticleUrls);
                i.putStringArrayListExtra("ArticlesImgUrls", ArticleImgUrls);
                i.putStringArrayListExtra("ArticlesDesc", ArticleDesc);
                i.putStringArrayListExtra("ArticlesText", ArticleText);
                i.putStringArrayListExtra("ArticlesChannel", ArticleChannel);
                startActivity(i);
                // close this activity
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}
