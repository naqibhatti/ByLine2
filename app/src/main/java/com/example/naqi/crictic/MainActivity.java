package com.example.naqi.crictic;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

import static com.example.naqi.crictic.MyRecyclerViewAdapter.webTrue;


public class MainActivity extends AppCompatActivity implements MyRecyclerViewAdapter.ItemClickListener, MyRecyclerViewAdapter.ItemLongClickListener {
    MyRecyclerViewAdapter adapter;
    MyRecyclerViewAdapter adapter2;
    ArrayList<String> ArtiUrls;
    ArrayList<String> ArtiText;
    ArrayList<String> ArtiTitles;
    ArrayList<String> ArtiImgUrls;
    ArrayList<String> ArtiDesc;



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

        TextView textView = (TextView) findViewById(R.id.test);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/AbrilFatface-Regular.ttf");
        textView.setTypeface(typeface);

        ArrayList<String> matches = new ArrayList();
        ArrayList<Drawable> imag = new ArrayList();

        ArtiTitles = getIntent().getStringArrayListExtra("ArticlesTitles");
        ArtiUrls = getIntent().getStringArrayListExtra("ArticlesUrls");
        ArtiImgUrls = getIntent().getStringArrayListExtra("ArticlesImgUrls");
        ArtiDesc = getIntent().getStringArrayListExtra("ArticlesDesc");
        ArtiText = getIntent().getStringArrayListExtra("ArticlesText");

        Log.d("TAG", "MAIN ACTIVITY");
        for (int i = 0; i < ArtiTitles.size(); i++) {
            Log.d("TAG", ArtiTitles.get(i));
            Log.d("TAG", ArtiUrls.get(i));
            Log.d("TAG", ArtiImgUrls.get(i));
        }

//Musa do something with this:
//        BottomNavigationView bottomNavigationView = (BottomNavigationView)
//                    findViewById(R.id.bottom_navigation);
//
//            bottomNavigationView.setOnNavigationItemSelectedListener(
//                    new BottomNavigationView.OnNavigationItemSelectedListener() {
//                        @Override
//                        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                            switch (item.getItemId()) {
//                                case R.id.action_favorites:
//
//                                    break;
//                                case R.id.action_schedules:
//
//                                    break;
//                                case R.id.action_music:
//
//                                    break;
//                            }
//                            return false;
//                        }
//                    });

//        imag.add(getResources().getDrawable(R.drawable.asad));
//        imag.add(getResources().getDrawable(R.drawable.sril));
//        imag.add(getResources().getDrawable(R.drawable.nab));
//        imag.add(getResources().getDrawable(R.drawable.i));
//        imag.add(getResources().getDrawable(R.drawable.bilawal));
//        imag.add(getResources().getDrawable(R.drawable.iw));
//        imag.add(getResources().getDrawable(R.drawable.srila));
//        imag.add(getResources().getDrawable(R.drawable.joe));
//        imag.add(getResources().getDrawable(R.drawable.jah));
//        imag.add(getResources().getDrawable(R.drawable.foot));
//        imag.add(getResources().getDrawable(R.drawable.pesh));
//
//        matches.add("Asad Umar Outsted!:New Finance Minister Who?");
//        matches.add("Sri Lanka Terrorist Attacks: Over 290 Dead.");
//        matches.add("NAB inquiry: Sharif's Dilemma");
//        matches.add("Pakistan Settles on World Cup Squad: See the ins and outs");
//        matches.add("PM Imran’s ‘sahiba’ comment sends a message that being a women is an insult: Bilawal");
//        matches.add("Imran Khan, Wasim Akram named in Cricinfo’s all-time World Cup XI");
//        matches.add("Sri Lanka troops join hunt for bomb attack suspects");
//        matches.add("Former Vice President Joe Biden to make third run for the White House");
//        matches.add("Jahangir Tareen meets over 11 MNAs in last 24 hours");
//        matches.add("Guardiola's Man City raise the bar as Man Utd fall behind");
//        matches.add("Peshawar polio campaign: Faking childrens' illness was a pre-planned conspiracy, says report");


        RecyclerView rc2 = findViewById(R.id.rvAnimals1);

        LinearLayoutManager layoutManager1
                = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        rc2.setLayoutManager(layoutManager1);
        rc2.setNestedScrollingEnabled(false);

        adapter2 = new MyRecyclerViewAdapter(this, ArtiTitles, ArtiImgUrls, ArtiDesc);
//        Log.d("TAG", "View set");
        adapter2.setClickListener(this);

        rc2.setAdapter(adapter2);

        adapter2.setLongClickListener(this);

        RecyclerView recyclerView = findViewById(R.id.rvAnimals);

        /**LinearLayoutManager layoutManager
         = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

         recyclerView.setLayoutManager(layoutManager);

         adapter = new MyRecyclerViewAdapter(this, matches);

         adapter.setClickListener(this);
         recyclerView.setAdapter(adapter);**/
    }

    /**
     * @Override public boolean onCreateOptionsMenu(Menu menu) {
     * getMenuInflater().inflate(R.menu.main, menu);
     * return true;
     * }
     * @Override public boolean onOptionsItemSelected(MenuItem item) {
     * int itemSelected = item.getItemId();
     * if(itemSelected == R.id.action_search){
     * Context context = MainActivity.this;
     * String message = "Search Clicked";
     * <p>
     * Toast.makeText(context, message, Toast.LENGTH_LONG).show();
     * }
     * return super.onOptionsItemSelected(item);
     * }
     **/
    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(this, "You clicked " + adapter2.getItem(position) + " on row number " + position, Toast.LENGTH_SHORT).show();
        for (int i = 0; i < ArtiUrls.size(); i++) {
            if (position == i) {
                Intent a;
                a = new Intent(this, ArticleViewActivity.class);

                String articleToPass = ArtiText.get(i);
                String urlToPass = ArtiUrls.get(i);
                String headline = ArtiTitles.get(i);
                String imageUrl = ArtiImgUrls.get(i);
                String description = ArtiDesc.get(i);

                a.putExtra("link", urlToPass);
                a.putExtra("text", articleToPass);
                a.putExtra("description", description);
                a.putExtra("Image", imageUrl);
                a.putExtra("headline", headline);
                a.putExtra("name", headline);
                startActivity(a);
            }
//        }else if(position == 1){
//            Intent b;
//            b = new Intent(this, WebViewActivity.class);
//            b.putExtra("link", "https://foreignpolicy.com/2019/04/21/whats-behind-the-terrorist-attacks-in-sri-lanka/");
//            startActivity(b);
//        }else if(position == 2){
//            Intent c;
//            c = new Intent(this, WebViewActivity.class);
//            c.putExtra("link", "https://dunyanews.tv/en/Pakistan/488615-LNG-scam-NAB-investigates-Shahid-Khaqan-Abbasi");
//            startActivity(c);
//        }else if(position == 3) {
//            Intent d;
//            d = new Intent(this, WebViewActivity.class);
//            d.putExtra("link", "https://www.geo.tv/latest/235019-pakistan-team-arrives-in-london-for-england-series-world-cup");
//            startActivity(d);
//        }else if(position == 4) {
//            Intent e;
//            e = new Intent(this, WebViewActivity.class);
//            e.putExtra("link", "https://www.geo.tv/latest/235297-is-pm-imran-saying-that-being-a-woman-is-a-curse-asks-bilawal");
//            startActivity(e);
//        }else if(position == 5) {
//            Intent f;
//            f = new Intent(this, WebViewActivity.class);
//            f.putExtra("link", "https://www.geo.tv/latest/235265-imran-khan-wasim-akram-named-in-cricinfos-all-time-world-cup-xi");
//            startActivity(f);
//        }else if(position == 6) {
//            Intent g;
//            g = new Intent(this, WebViewActivity.class);
//            g.putExtra("link", "https://www.geo.tv/latest/235256-sri-lanka-troops-join-hunt-for-bomb-attack-suspects");
//            startActivity(g);
//        }else if(position == 7) {
//            Intent h;
//            h = new Intent(this, WebViewActivity.class);
//            h.putExtra("link", "https://www.geo.tv/latest/235271-former-vice-president-joe-biden-to-make-third-run-for-the-white-house");
//            startActivity(h);
//        }else if(position == 8) {
//            Intent i;
//            i = new Intent(this, WebViewActivity.class);
//            i.putExtra("link", "https://www.geo.tv/latest/235279-jahangir-tareen-meets-over-11-mnas-in-last-24-hours");
//            startActivity(i);
//        }else if(position == 9) {
//            Intent j;
//            j = new Intent(this, WebViewActivity.class);
//            j.putExtra("link", "https://www.geo.tv/latest/235185-guardiolas-man-city-raise-the-bar-as-man-utd-fall-behind");
//            startActivity(j);
//        }else if(position == 10) {
//            Intent k;
//            k = new Intent(this, WebViewActivity.class);
//            k.putExtra("link", "");
//            startActivity(k);
//        }else{
        }
    }
    @Override
    public void onItemLongClick(View view, int position) {
        Toast.makeText(this, "You clicked " + adapter2.getItem(position) + " on row number " + position, Toast.LENGTH_SHORT).show();
        for (int i = 0; i < ArtiUrls.size(); i++) {
            if (position == i) {
                Intent a;
                a = new Intent(this, WebViewActivity.class);
                String urlToPass = ArtiUrls.get(i);

                a.putExtra("link", urlToPass);

                startActivity(a);
            }
        }
    }
}
