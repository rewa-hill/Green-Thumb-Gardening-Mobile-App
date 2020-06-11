package com.example.component2_greenthumbgardening;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import gr.net.maroulis.library.EasySplashScreen;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // With help from Coding In Flow's Easy Splash Screen tutorial:
        // https://www.youtube.com/watch?v=gt1WYT0Qpfk
        EasySplashScreen config = new EasySplashScreen(SplashScreen.this)
                .withFullScreen()
                .withTargetActivity(MainActivity.class)
                .withSplashTimeOut(5000)
                .withBackgroundColor(Color.parseColor("#598B11"))
                .withAfterLogoText("Green Thumb\n Gardening")
                .withFooterText("© 2020")
                .withLogo(R.drawable.gtg_logo_white);

        config.getLogo().setMaxHeight(700);

        //After Logo text settings
        config.getAfterLogoTextView().setTextColor(Color.WHITE);
        config.getAfterLogoTextView().setTextSize(40);
        config.getAfterLogoTextView().setAllCaps(true);
        config.getAfterLogoTextView().setGravity(Gravity.CENTER);

        //Footer text settings
        config.getFooterTextView().setTextColor(Color.WHITE);

        //Creates splash screen view
        View splashScreen = config.create();
        setContentView(splashScreen);

    }
}
