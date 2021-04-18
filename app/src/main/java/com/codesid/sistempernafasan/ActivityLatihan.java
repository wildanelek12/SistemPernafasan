package com.codesid.sistempernafasan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ActivityLatihan extends AppCompatActivity {

    @BindView(R.id.btnLks)
    ImageView btnLks;
    @BindView(R.id.btnEvaluasi)
    ImageView btnEvaluasi;
    @BindView(R.id.btnBackLatihan)
    ImageView btnBackLatihan;
    @BindView(R.id.imgBtn_sound)
    ImageView imgBtnSoundOn;
    @BindView(R.id.imgBtn_sound_off)
    ImageView imgBtnSoundOff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_latihan);

        ButterKnife.bind(this);
        MediaPlayer mp_click = MediaPlayer.create(this, R.raw.click1);

        SharedPreferences prefs = getSharedPreferences("MyPref", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        int suara = prefs.getInt("suara", 1); //0 is the default value.
        if (suara==1){
            imgBtnSoundOn.setVisibility(View.VISIBLE);
            imgBtnSoundOff.setVisibility(View.INVISIBLE);

            mp_click.setVolume(1,1);
            Intent svc=new Intent(ActivityLatihan.this, BackgroundService.class);
            startService(svc); //OR stopService(svc);
        }else {
            imgBtnSoundOn.setVisibility(View.INVISIBLE);
            imgBtnSoundOff.setVisibility(View.VISIBLE);

            mp_click.setVolume(0,0);
            Intent svc=new Intent(ActivityLatihan.this, BackgroundService.class);
            stopService(svc); //OR stopService(svc);
        }
        btnEvaluasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp_click.start();
                Intent intent = new Intent(ActivityLatihan.this,EvaluasiActivity.class);
                startActivity(intent);
            }
        });
        btnLks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp_click.start();
                Intent intent = new Intent(ActivityLatihan.this,ActivityLks.class);
                startActivity(intent);
            }
        });
        btnBackLatihan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp_click.start();
                Intent intent = new Intent(ActivityLatihan.this,MainMenu.class);
                startActivity(intent);
            }
        });
        imgBtnSoundOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp_click.start();
                imgBtnSoundOn.setVisibility(View.INVISIBLE);
                imgBtnSoundOff.setVisibility(View.VISIBLE);

                mp_click.setVolume(0,0);
                Intent svc=new Intent(ActivityLatihan.this, BackgroundService.class);
                stopService(svc); //OR stopService(svc);
                editor.putInt("suara", 0);
                editor.apply(); // commit changes
            }
        });

        imgBtnSoundOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp_click.start();
                imgBtnSoundOn.setVisibility(View.VISIBLE);
                imgBtnSoundOff.setVisibility(View.INVISIBLE);

                mp_click.setVolume(1,1);
                Intent svc=new Intent(ActivityLatihan.this, BackgroundService.class);
                startService(svc); //OR stopService(svc);
                editor.putInt("suara", 1);
                editor.apply(); // commit changes
            }
        });

    }
}