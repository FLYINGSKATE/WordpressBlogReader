package com.example.funtrepreneur;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    boolean isFABOpen;
    FloatingActionButton fab1,fab2,fab3;

    AdView mAdView,mAdView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
        setAdView();
    }



    public void goToContent(View view) {
        Intent intent = new Intent(this, content.class);
        switch(view.getId()){
            case R.id.fitness:
                String fitness="https://sumeetshelte.wordpress.com/2020/04/13/15-basic-exercises-you-can-do-at-the-comfort-of-your-home-targeting-each-every-muscle-of-your-body-that-too-without-any-fancy-gym-equipments/";
                intent.putExtra("web_uri_identifier", fitness);
                intent.putExtra("TitleText","Health & Fitness Funtrepreneur");
                startActivity(intent);
                break;
            case R.id.tech:
                String tech = "https://sumeetshelte.wordpress.com/2020/04/26/10-android-apps-that-will-take-your-productivity-to-another-level/";
                intent.putExtra("TitleText","Technology Funtrepreneur");
                intent.putExtra("web_uri_identifier", tech);
                startActivity(intent);
                break;
            case R.id.beauty:
                String beauty="file:///android_asset/loadscreenASH.html";
                intent.putExtra("web_uri_identifier", beauty);
                intent.putExtra("TitleText","Beauty Funtrepreneur");
                startActivity(intent);
                break;

            case R.id.nature:
                String nature="file:///android_asset/loadscreenASH.html";
                intent.putExtra("web_uri_identifier", nature);
                intent.putExtra("TitleText","Nature Funtrepreneur");
                startActivity(intent);
                break;
            case R.id.entertainment:
                String entertainment="file:///android_asset/loadscreenASH.html";
                intent.putExtra("web_uri_identifier", entertainment);
                intent.putExtra("TitleText","Entertainment Funtrepreneur");
                startActivity(intent);
                break;
            case R.id.ayurveda:
                String ayurveda="file:///android_asset/loadscreenASH.html";
                intent.putExtra("web_uri_identifier", ayurveda);
                intent.putExtra("TitleText","Ayurveda Funtrepreneur");
                startActivity(intent);
                break;

            case R.id.music:
                String music="file:///android_asset/loadscreenASH.html";
                intent.putExtra("web_uri_identifier", music);
                intent.putExtra("TitleText","Music Funtrepreneur");
                startActivity(intent);
                break;
            case R.id.lifestyle:
                String lifestyle="file:///android_asset/loadscreenASH.html";
                intent.putExtra("web_uri_identifier", lifestyle);
                intent.putExtra("TitleText","Lifestyle Funtrepreneur");
                startActivity(intent);
                break;
            case R.id.automobile:
                String automobile="file:///android_asset/loadscreenASH.html";
                intent.putExtra("web_uri_identifier", automobile);
                intent.putExtra("TitleText","Automobile Funtrepreneur");
                startActivity(intent);
                break;

            case R.id.nutrition:
                String nutrition="file:///android_asset/loadscreenASH.html";
                intent.putExtra("web_uri_identifier", nutrition);
                intent.putExtra("TitleText","Nutrition Funtrepreneur");
                startActivity(intent);
                break;
            case R.id.travel:
                String travel="file:///android_asset/loadscreenASH.html";
                intent.putExtra("web_uri_identifier", travel);
                intent.putExtra("TitleText","Travel Funtrepreneur");
                startActivity(intent);
                break;
            case R.id.food:
                String food="file:///android_asset/loadscreenASH.html";
                intent.putExtra("web_uri_identifier", food);
                intent.putExtra("TitleText","Food Funtrepreneur");
                startActivity(intent);
                break;

            default:
                String def="file:///android_asset/loadscreenASH.html";
                intent.putExtra("web_uri_identifier", def);
                intent.putExtra("TitleText","ERROR PAGE");
                startActivity(intent);
                break;
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

    public void shareit(View view) {
        ApplicationInfo api = getApplicationContext().getApplicationInfo();
        String apkPath=api.sourceDir;
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("application/vnd.android.package-archive");
        intent.putExtra(Intent.EXTRA_STREAM,Uri.fromFile(new File(apkPath)));
        startActivity(Intent.createChooser(intent,"ShareVia"));
    }
}
