package com.codesid.sistempernafasan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.imgBtn_sound)
    ImageView imgBtnSoundOn;
    @BindView(R.id.imgBtn_sound_off)
    ImageView imgBtnSoundOff;

    MediaPlayer mp_click;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        imgBtnSoundOff.setVisibility(View.INVISIBLE);
        MediaPlayer mp = MediaPlayer.create(this, R.raw.opening);
        mp_click = MediaPlayer.create(this, R.raw.click1);
        mp.start();
        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                mp.start();
            }
        });

        imgBtnSoundOn.setVisibility(View.INVISIBLE);

        ImageView imgbtnStart = findViewById(R.id.imgBtn_start);

        Intent svc=new Intent(this, BackgroundService.class);
        startService(svc); //OR stopService(svc);




        Animation connectingAnimation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.alpha_scale_animation);
        imgbtnStart.startAnimation(connectingAnimation);
        imgbtnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp_click.start();
                view.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.image_click));
                Intent intent = new Intent(MainActivity.this,MainMenu.class);
                mp.release();
                startActivity(intent);
                finish();

            }
        });

        imgBtnSoundOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp_click.start();
                imgBtnSoundOn.setVisibility(View.INVISIBLE);
                imgBtnSoundOff.setVisibility(View.VISIBLE);
                mp.setVolume(0,0);
            }
        });

        imgBtnSoundOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp_click.start();
                imgBtnSoundOn.setVisibility(View.VISIBLE);
                imgBtnSoundOff.setVisibility(View.INVISIBLE);
                mp.setVolume(1,1);

            }
        });


    }
}