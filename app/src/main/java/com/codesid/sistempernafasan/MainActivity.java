package com.codesid.sistempernafasan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.imgBtn_sound)
    ImageView imgBtnSoundOn;
    @BindView(R.id.imgBtn_sound_off)
    ImageView imgBtnSoundOff;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        imgBtnSoundOff.setVisibility(View.INVISIBLE);

        ImageView imgbtnStart = findViewById(R.id.imgBtn_start);
        imgbtnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.image_click));
                Intent intent = new Intent(MainActivity.this,MainMenu.class);
                startActivity(intent);

            }
        });

        imgBtnSoundOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgBtnSoundOn.setVisibility(View.INVISIBLE);
                imgBtnSoundOff.setVisibility(View.VISIBLE);
            }
        });

        imgBtnSoundOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgBtnSoundOn.setVisibility(View.VISIBLE);
                imgBtnSoundOff.setVisibility(View.INVISIBLE);
            }
        });


    }
}