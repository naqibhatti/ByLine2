package com.example.naqi.crictic;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class ArticleViewActivity extends AppCompatActivity implements View.OnClickListener, View.OnLongClickListener {
    TextView headlines;
    TextView description;
    TextView aText;
    ImageView aImage;
    String ArtiUrls;
    String ArtiText;
    String ArtiTitles;
    String ArtiImgUrls;
    String ArtiDesc;

    Typeface typeFace;
    Typeface typeFace2;
    Typeface typeFace3;
    Typeface typeFace4;
    Typeface typeFace5;

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

        typeFace = Typeface.createFromAsset(this.getAssets(), "fonts/AbrilFatface-Regular.ttf");
        typeFace2 = Typeface.createFromAsset(this.getAssets(), "fonts/adam.otf");
        typeFace3 = Typeface.createFromAsset(this.getAssets(), "fonts/zebrazil.ttf");
        typeFace4 = Typeface.createFromAsset(this.getAssets(), "fonts/anson.otf");
        typeFace5 = Typeface.createFromAsset(this.getAssets(), "fonts/Roboto-Regular.ttf");


        ArtiTitles = getIntent().getStringExtra("headline");
//      ArtiUrls = getIntent().getStringExtra("ArticlesUrls");
        ArtiImgUrls = getIntent().getStringExtra("Image");
        ArtiDesc = getIntent().getStringExtra("description");
        ArtiText = getIntent().getStringExtra("text");

        headlines.setText(ArtiTitles);
        description.setText(ArtiDesc);
        aText.setText(ArtiText);

        headlines.setTypeface(typeFace4);
        description.setTypeface(typeFace2);
        aText.setTypeface(typeFace5);

        URI url = null;
        try {
            url = new URI(ArtiImgUrls);
        }catch (URISyntaxException e) {
            e.printStackTrace();
        }

        Picasso.get()
                .load(String.valueOf(url))
                .into(aImage);

        aText.setOnClickListener(this);
        aText.setOnLongClickListener(this);
    }

    @Override
    public boolean onLongClick(View v) {
        Toast.makeText(this, "Long Click", Toast.LENGTH_LONG).show();
        aText.setTextSize(TypedValue.COMPLEX_UNIT_PX,aText.getTextSize()-2);
        return true;
    }

    @Override
    public void onClick(View v) {
        float textSizes = aText.getTextSize();
        textSizes = textSizes + 1;
        aText.setTextSize(TypedValue.COMPLEX_UNIT_PX,aText.getTextSize() + 2);
    }
}
