package com.example.uts_00000019999_stefanusdwitralauwrendo_ninja;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;


public class StartActivity extends AppCompatActivity {
    Button exitButton;
    ImageView gambarNinja;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        MediaPlayer music = MediaPlayer.create(StartActivity.this, R.raw.start);
        music.start();
        exitButton = findViewById(R.id.buttonExit);
        gambarNinja = findViewById(R.id.gambarNinja);
        gambarNinja.setImageResource(R.drawable.ninja2_2);
        exitButton.setVisibility(View.INVISIBLE);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                int distance = 1000;
                double direction = Math.random()  * 2 * Math.PI;
                double direction2 = Math.random()  * 2 * Math.PI;
                float translationX = (float) (Math.cos(direction) * distance);
                float translationY = (float) (Math.sin(direction2) * distance);
                ObjectAnimator animX = ObjectAnimator.ofFloat(gambarNinja, "x", translationX);
                ObjectAnimator animY = ObjectAnimator.ofFloat(gambarNinja, "y",translationY);
                AnimatorSet animSetXY = new AnimatorSet();
                animSetXY.playTogether(animX, animY);
                animSetXY.start();
                handler.postDelayed(this,500);
            }
        }, 1000);
        gambarNinja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view == gambarNinja) {
                    gambarNinja.setImageResource(0);
                    exitButton.setVisibility(View.VISIBLE);
                    MediaPlayer ring= MediaPlayer.create(StartActivity.this,R.raw.hit);
                    ring.start();
                }else{
                    MediaPlayer ring= MediaPlayer.create(StartActivity.this,R.raw.miss);
                    ring.start();
                }
            }
        });
    }


    public void keluarBalik(View view) {
        Intent intent = new Intent(StartActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
