package com.example.funtrepreneur;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.File;

public class content extends AppCompatActivity {

    private WebView wv1;
    CollapsingToolbarLayout ctl;
    ImageView titleImage;

    boolean isFABOpen;
    FloatingActionButton fab1,fab2,fab3;

    TextView tvLoad;
    String title;
    ImageView loadImage;


    AdView mAdView,mAdView2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        String url = getIntent().getStringExtra("web_uri_identifier");
        title = getIntent().getStringExtra("TitleText");

        ctl=(CollapsingToolbarLayout)findViewById(R.id.collapsableToolbar);
        ctl.setTitle(title);

        tvLoad=(TextView)findViewById(R.id.loadtv);

        titleImage=(ImageView)findViewById(R.id.titleImage);
        loadImage=(ImageView)findViewById(R.id.loadingImage);

        setImageResourceForCollapsableTitleBar();
        animateLoadIcon();
        setAdView();



        wv1 =(WebView)findViewById(R.id.webview);
        wv1.setWebViewClient(new MyBrowser());



        wv1.getSettings().setLoadsImagesAutomatically(true);
        wv1.getSettings().setJavaScriptEnabled(true);
        wv1.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        wv1.loadUrl(url);


        fab1=(FloatingActionButton)findViewById(R.id.fab1);
        fab2=(FloatingActionButton)findViewById(R.id.fab2);
        fab3=(FloatingActionButton)findViewById(R.id.fab3);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab1 = (FloatingActionButton) findViewById(R.id.fab1);
        fab2 = (FloatingActionButton) findViewById(R.id.fab2);
        fab3 = (FloatingActionButton) findViewById(R.id.fab3);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isFABOpen){
                    showFABMenu();
                }else{
                    closeFABMenu();
                }
            }
        });

    }

    private void setAdView() {
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mAdView2 = findViewById(R.id.adView2);
        AdRequest adRequest2 = new AdRequest.Builder().build();
        mAdView2.loadAd(adRequest2);
    }

    private void animateLoadIcon() {
        Animation aniRotate = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.clockwise);
        loadImage.startAnimation(aniRotate);
    }

    private void setImageResourceForCollapsableTitleBar() {
        switch (title){
            case "Health & Fitness Funtrepreneur":
                titleImage.setImageResource(R.mipmap.fitness_title);
                break;
            case "Lifestyle Funtrepreneur":
                titleImage.setImageResource(R.mipmap.lifestyle);
                break;
            case "Technology Funtrepreneur":
                titleImage.setImageResource(R.mipmap.technology);
                break;
            case "Entertainment Funtrepreneur":
                titleImage.setImageResource(R.mipmap.entertainment);
                break;
            case "Music Funtrepreneur":
                titleImage.setImageResource(R.mipmap.music);
                break;
            case "Beauty Funtrepreneur":
                titleImage.setImageResource(R.mipmap.beauty);
                break;
            case "Nature Funtrepreneur":
                titleImage.setImageResource(R.mipmap.nature);
                break;
            case "Food Funtrepreneur":
                titleImage.setImageResource(R.mipmap.food);
                break;
            case "Travel Funtrepreneur":
                titleImage.setImageResource(R.mipmap.travel);
                break;
            case "Nutrition Funtrepreneur":
                titleImage.setImageResource(R.mipmap.nutrition);
                break;
            case "Ayurveda Funtrepreneur":
                titleImage.setImageResource(R.mipmap.ayurveda);
                break;
            case "Automobile Funtrepreneur":
                titleImage.setImageResource(R.mipmap.automobile);
                break;
            default:
                titleImage.setImageResource(R.mipmap.f);
                break;

        }

    }


    public void goToHome(View view) {
        startActivity(new Intent(this,MainActivity.class));
    }


    private class MyBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }


        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            wv1.setVisibility(View.VISIBLE);
            tvLoad.setVisibility(View.GONE);
            loadImage.setVisibility(View.GONE);
        }
    }

    private void showFABMenu(){
        isFABOpen=true;
        fab1.animate().translationY(-getResources().getDimension(R.dimen.standard_55));
        fab2.animate().translationY(-getResources().getDimension(R.dimen.standard_105));
        fab3.animate().translationY(-getResources().getDimension(R.dimen.standard_155));
    }

    private void closeFABMenu(){
        isFABOpen=false;
        fab1.animate().translationY(0);
        fab2.animate().translationY(0);
        fab3.animate().translationY(0);
    }

    public void shareit(View view) {
        ApplicationInfo api = getApplicationContext().getApplicationInfo();
        String apkPath=api.sourceDir;
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("application/vnd.android.package-archive");
        intent.putExtra(Intent.EXTRA_STREAM,Uri.fromFile(new File(apkPath)));
        startActivity(Intent.createChooser(intent,"ShareVia"));
    }

    public void takeMeToInstagram(View view) {
        Uri uri = Uri.parse("https://www.instagram.com/fun_trepreneur/");
        Intent instagram=new Intent(Intent.ACTION_VIEW,uri);
        instagram.setPackage("com.instagram.android");
        try{
            startActivity(instagram);
        }
        catch(ActivityNotFoundException e){
            startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.instagram.com/fun_trepreneur/")));
        }
    }

    public void takeMeToFacebook(View view) {
        Uri uri = Uri.parse("https://www.facebook.com/Funtrepreneur-112742763724321/");
        Intent facebook=new Intent(Intent.ACTION_VIEW,uri);
        facebook.setPackage("com.facebook.katana");
        try{
            startActivity(facebook);
        }
        catch(ActivityNotFoundException e){
            startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.facebook.com/Funtrepreneur-112742763724321/")));
        }
    }

    public void takeMeToTwitter(View view) {
        Uri uri = Uri.parse("https://twitter.com/Fun_trepreneur?s=09");
        Intent twitter=new Intent(Intent.ACTION_VIEW,uri);
        twitter.setPackage("com.twitter.android");
        try{
            startActivity(twitter);
        }
        catch(ActivityNotFoundException e){
            startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("https://twitter.com/Fun_trepreneur?s=09")));
        }

    }
}
