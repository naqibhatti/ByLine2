package com.example.naqi.byline;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class SplashActivity extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 7000;
    private Boolean firstTime = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        final ArrayList<Article> Articles = new ArrayList();

        getSupportActionBar().hide();
        // Splash screen timer

        ImageView myView = (ImageView) findViewById(R.id.splash);


        for (int i = 1; i < 40; i++) {
            DocumentReference docRef2 = db.collection("Geo_Urdu").document("Article" + Integer.toString(i));
            final int finalI = i;
            docRef2.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                    if (task.isSuccessful()) {
                        // Document found in the offline cache
                        DocumentSnapshot document = task.getResult();
                        Article city = document.toObject(Article.class);
                        city.setChannelName("Geo_Urdu");
                        Articles.add(city);
                        Log.d("TAG", "Article" + Integer.toString(finalI) + ": " + city.getTitle());

                        //matches.add(city.getTitle());

                    } else {
                        Log.d("TAG", "Cached get failed: ", task.getException());
                    }
                }
            });
        }
//        for (int i = 1; i < 20; i++) {
//            DocumentReference docRef3 = db.collection("Dawn").document("Article" + Integer.toString(i));
//            final int finalI = i;
//            docRef3.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
//                @Override
//                public void onComplete(@NonNull Task<DocumentSnapshot> task) {
//                    if (task.isSuccessful()) {
//                        // Document found in the offline cache
//                        DocumentSnapshot document = task.getResult();
//                        Article city = document.toObject(Article.class);
//                        city.setChannelName("Dawn");
//                        Articles.add(city);
//                        Log.d("TAG", "Article" + Integer.toString(finalI) + ": " + city.getTitle());
//
//                        //matches.add(city.getTitle());
//
//                    } else {
//                        Log.d("TAG", "Cached get failed: ", task.getException());
//                    }
//                }
//            });
//        }
        for (int i = 1; i < 5; i++) {
            DocumentReference docRef4 = db.collection("MangoFuck").document("Article" + Integer.toString(i));
            final int finalI = i;
            docRef4.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                    if (task.isSuccessful()) {
                        // Document found in the offline cache
                        DocumentSnapshot document = task.getResult();
                        Article city = document.toObject(Article.class);
                        city.setChannelName("Mango");
                        Articles.add(city);
                        Log.d("TAG", "Article" + Integer.toString(finalI) + ": " + city.getTitle());

                        //matches.add(city.getTitle());

                    } else {
                        Log.d("TAG", "Cached get failed: ", task.getException());
                    }
                }
            });
        }
        for (int i = 1; i < 10; i++) {
            DocumentReference docRef2 = db.collection("Tribune").document("Article" + Integer.toString(i));
            final int finalI = i;
            docRef2.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                    if (task.isSuccessful()) {
                        // Document found in the offline cache
                        DocumentSnapshot document = task.getResult();
                        Article city = document.toObject(Article.class);
                        city.setChannelName("Tribune");
                        Articles.add(city);
                        Log.d("TAG", "Article" + Integer.toString(finalI) + ": " + city.getTitle());

                        //matches.add(city.getTitle());

                    } else {
                        Log.d("TAG", "Cached get failed: ", task.getException());
                    }
                }
            });
        }
        for (int i = 1; i < 40; i++) {
            DocumentReference docRef = db.collection("Geo").document("Article" + Integer.toString(i));
            final int finalI = i;
            docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                    if (task.isSuccessful()) {
                        // Document found in the offline cache
                        DocumentSnapshot document = task.getResult();
                        Article city = document.toObject(Article.class);
                        city.setChannelName("Geo");
                        Articles.add(city);
                        Log.d("TAG", "Article" + Integer.toString(finalI) + ": " + city.getTitle());

                        //matches.add(city.getTitle());

                    } else {
                        Log.d("TAG", "Cached get failed: ", task.getException());
                    }
                }
            });
        }


        ObjectAnimator fadeOut = ObjectAnimator.ofFloat(myView, "alpha", 1f, .3f);
        fadeOut.setDuration(1500);

        ObjectAnimator fadeIn = ObjectAnimator.ofFloat(myView, "alpha", .3f, 1f);
        fadeIn.setDuration(1500);

        final AnimatorSet mAnimationSet = new AnimatorSet();

        mAnimationSet.play(fadeIn).after(fadeOut);

        mAnimationSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                mAnimationSet.start();
            }
        });
        mAnimationSet.start();

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        getWindow().setStatusBarColor(Color.WHITE);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                ArrayList<String> ArticleTitles = new ArrayList();
                ArrayList<String> ArticleUrls = new ArrayList();
                ArrayList<String> ArticleImgUrls = new ArrayList();
                ArrayList<String> ArticleDesc = new ArrayList();
                ArrayList<String> ArticleText = new ArrayList();
                ArrayList<String> ArticleChannel = new ArrayList();


                for (int i = 0; i < Articles.size(); i++) {
                    Log.d("TAG", Articles.get(i).getTitle());
                    ArticleTitles.add(Articles.get(i).getTitle());
                    ArticleUrls.add(Articles.get(i).getLink());
                    ArticleImgUrls.add(Articles.get(i).getImage_link());
                    ArticleDesc.add(Articles.get(i).getDescription());
                    ArticleText.add(Articles.get(i).getText());
                    ArticleChannel.add(Articles.get(i).getChannelName());

                }
            if(isFirstTime() == false) {
                Intent i = new Intent(SplashActivity.this, MainActivity.class);
                i.putStringArrayListExtra("ArticlesTitles", ArticleTitles);
                i.putStringArrayListExtra("ArticlesUrls", ArticleUrls);
                i.putStringArrayListExtra("ArticlesImgUrls", ArticleImgUrls);
                i.putStringArrayListExtra("ArticlesDesc", ArticleDesc);
                i.putStringArrayListExtra("ArticlesText", ArticleText);
                i.putStringArrayListExtra("ArticlesChannel", ArticleChannel);
                startActivity(i);
            }else{
                Intent i = new Intent(SplashActivity.this, FirstTimeActivity.class);
                i.putStringArrayListExtra("ArticlesTitles", ArticleTitles);
                i.putStringArrayListExtra("ArticlesUrls", ArticleUrls);
                i.putStringArrayListExtra("ArticlesImgUrls", ArticleImgUrls);
                i.putStringArrayListExtra("ArticlesDesc", ArticleDesc);
                i.putStringArrayListExtra("ArticlesText", ArticleText);
                i.putStringArrayListExtra("ArticlesChannel", ArticleChannel);
                startActivity(i);
            }
                // close this activity
                finish();
            }
        }, SPLASH_TIME_OUT);
    }

    private boolean isFirstTime() {
        if (firstTime == null) {
            SharedPreferences mPreferences = this.getSharedPreferences("first_time", Context.MODE_PRIVATE);
            firstTime = mPreferences.getBoolean("firstTime", true);
            if (firstTime) {
                SharedPreferences.Editor editor = mPreferences.edit();
                editor.putBoolean("firstTime", false);
                editor.apply();
            }else{
                firstTime = false;
            }
        }
        return firstTime;
    }

}
