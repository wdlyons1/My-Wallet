package com.finalproject.mywallet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashScreen extends AppCompatActivity {


        Animation animation;
        ImageView logo;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_splash_screen);
            logo =(ImageView)findViewById(R.id.imageView2);
            animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.animation1);
            animation.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    startActivity(new Intent(SplashScreen.this,MainActivity.class));

                }

                @Override
                public void onAnimationRepeat(Animation animation) {
                }
            });
            logo.startAnimation(animation);
        }
    }
