package com.example.naqi.crictic;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Build;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements MyRecyclerViewAdapter.ItemClickListener {
    MyRecyclerViewAdapter adapter;
    MyRecyclerViewAdapter adapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

/**     getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.byt);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
 **/
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.icon_lay);

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        getWindow().setStatusBarColor(Color.WHITE);

        setContentView(R.layout.activity_main);

        ArrayList<String> matches = new ArrayList();
        ArrayList<Drawable> imag = new ArrayList();

        imag.add(getResources().getDrawable(R.drawable.asad));
        imag.add(getResources().getDrawable(R.drawable.sril));
        imag.add(getResources().getDrawable(R.drawable.nab));

        TextView textView = (TextView) findViewById(R.id.test);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/AbrilFatface-Regular.ttf");
        textView.setTypeface(typeface);

        matches.add("Asad Umar Outsted!:New Finance Minister Who?");
        matches.add("Sri Lanka Terrorist Attacks: Over 290 Dead.");
        matches.add("NAB inquiry: Sharif's Dilemma");

        RecyclerView rc2 = findViewById(R.id.rvAnimals1);

        LinearLayoutManager layoutManager1
                = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        rc2.setLayoutManager(layoutManager1);
        rc2.setNestedScrollingEnabled(false);

        adapter2 = new MyRecyclerViewAdapter(this, matches, imag);

        adapter2.setClickListener(this);

        rc2.setAdapter(adapter2);

        RecyclerView recyclerView = findViewById(R.id.rvAnimals);

        /**LinearLayoutManager layoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        recyclerView.setLayoutManager(layoutManager);

        adapter = new MyRecyclerViewAdapter(this, matches);

        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);**/
    }

/**    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

   @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemSelected = item.getItemId();
        if(itemSelected == R.id.action_search){
            Context context = MainActivity.this;
            String message = "Search Clicked";

            Toast.makeText(context, message, Toast.LENGTH_LONG).show();
        }
        return super.onOptionsItemSelected(item);
    }
**/
    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(this, "You clicked " + adapter2.getItem(position) + " on row number " + position, Toast.LENGTH_SHORT).show();

        if(position == 0){
            Intent a;
            a = new Intent(this,    WebViewActivity.class);
            startActivity(a);
        }else if(position == 1){
            Intent b;
            b = new Intent(this, WebViewActivity.class);
            startActivity(b);
        }else if(position == 2){
            Intent c;
            c = new Intent(this, WebViewActivity.class);
            startActivity(c);
        }else{ }
    }
}
