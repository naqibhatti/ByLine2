package com.example.naqi.crictic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewActivity extends AppCompatActivity {

    WebView browser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        browser = (WebView) findViewById(R.id.webs);

        browser.setWebViewClient(new WebViewClient());

        browser.loadUrl("http://www.geo.tv");
    }
}
