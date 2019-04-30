package com.example.naqi.crictic;

import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class ArticleViewActivity extends AppCompatActivity {
    TextView headlines;
    TextView description;
    TextView aText;
    ImageView aImage;
    String ArtiUrls;
    String ArtiText;
    String ArtiTitles;
    String ArtiImgUrls;
    String ArtiDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_view);

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        getWindow().setStatusBarColor(Color.WHITE);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.icon_lay);

        headlines = findViewById(R.id.artiHead);
        description = findViewById(R.id.artides);
        aText = findViewById(R.id.artiText);
        aText = findViewById(R.id.artiText);
        aImage = findViewById(R.id.artiImage);

        ArtiTitles = getIntent().getStringExtra("headline");
//      ArtiUrls = getIntent().getStringExtra("ArticlesUrls");
        ArtiImgUrls = getIntent().getStringExtra("Image");
        ArtiDesc = getIntent().getStringExtra("description");
        ArtiText = getIntent().getStringExtra("text");


        headlines.setText(ArtiTitles);
        description.setText(ArtiDesc);
        aText.setText(ArtiText);

        URI url = null;
        try {
            url = new URI(ArtiImgUrls);
        }catch (URISyntaxException e) {
            e.printStackTrace();
        }

        Picasso.get()
                .load(String.valueOf(url))
                .into(aImage);
    }
}
