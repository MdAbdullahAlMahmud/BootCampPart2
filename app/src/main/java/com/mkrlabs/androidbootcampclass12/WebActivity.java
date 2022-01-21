package com.mkrlabs.androidbootcampclass12;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class WebActivity extends AppCompatActivity {

    private WebView webView;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        webView= findViewById(R.id.webView);
        String url = "https://www.youtube.com/";

        webView.setWebViewClient(new MyWebClient());

        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(url);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        Toast.makeText(WebActivity.this, "On Create", Toast.LENGTH_SHORT).show();
    }


    @Override
    protected void onStart() {
        Toast.makeText(WebActivity.this, "On Start", Toast.LENGTH_SHORT).show();
        super.onStart();
    }

    @Override
    protected void onResume() {
        Toast.makeText(WebActivity.this, "On Resume", Toast.LENGTH_SHORT).show();
        super.onResume();
    }

    @Override
    protected void onPause() {
        Toast.makeText(WebActivity.this, "On Pause", Toast.LENGTH_SHORT).show();
        super.onPause();
    }

    @Override
    protected void onStop() {
        Toast.makeText(WebActivity.this, "On Stop", Toast.LENGTH_SHORT).show();
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Toast.makeText(WebActivity.this, "Destroy", Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }

    @Override
    protected void onRestart() {
        Toast.makeText(WebActivity.this, "On Restart", Toast.LENGTH_SHORT).show();
        super.onRestart();
    }
}