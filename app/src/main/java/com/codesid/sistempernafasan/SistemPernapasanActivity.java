package com.codesid.sistempernafasan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.opengl.Visibility;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SistemPernapasanActivity extends AppCompatActivity {

    @BindView(R.id.imgGif)
    ImageView imgGif;
    @BindView(R.id.txtSistemPenapasan)
    TextView txtSistemPernapasan;
    @BindView(R.id.btnNextSistemPernapasan)
    ImageView btnNextSistemPernapasan;
    @BindView(R.id.btnPreviousSistemPernapasan)
    ImageView btnPreviousSistemPernapasan;
    @BindView(R.id.btnBackSistemPernapasan)
    ImageView btnBackSistemPernapasan;
    @BindView(R.id.imgBtn_sound)
    ImageView imgBtnSoundOn;
    @BindView(R.id.imgBtn_sound_off)
    ImageView imgBtnSoundOff;
    MediaPlayer mp;

    String materi[]={
                "Pernapasan adalah proses menghirup udara bebas yang mengandung oksigen (inspirasi) dan mengeluarkan udara yang mengandung karbondioksida (ekspirasi).\n" +
                        "\n" +
                        "Ada dua proses pernapasan pada manusia:\n" +
                        "Respirasi eksternal, yaitu pertukaran oksigen dan karbon dioksida dari atmosfer dengan paru-paru (alveolus).\n" +
                        "Respirasi internal, yaitu pertukaran oksigen dan karbon dioksida  antara kapiler darah dengan sel-sel tubuh.\n"

            ,"Sistem organ manusia yang tersusun atas hidung, faring (tekak), laring (ruang suara), trakea (tenggorokan), bronkus, dan paru-paru.\n" +
            "\n" +
            "Secara struktural, sistem pernapasan tersusun atas 2 bagian utama:\n" +
            "Saluran pernapasan bagian atas : rongga hidung dan faring.\n" +
            "Saluran pernapasan bagian bawah: laring, trakea, bronkus, dan paru-paru.\n"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sistem_pernapasan);

        ButterKnife.bind(this);

        txtSistemPernapasan.setText(materi[0]);
        btnPreviousSistemPernapasan.setVisibility(View.GONE);

        MediaPlayer mp_click = MediaPlayer.create(this, R.raw.click1);

        SharedPreferences prefs = getSharedPreferences("MyPref", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        int suara = prefs.getInt("suara", 1); //0 is the default value.
        if (suara==1){
            imgBtnSoundOn.setVisibility(View.VISIBLE);
            imgBtnSoundOff.setVisibility(View.INVISIBLE);
            mp.setVolume(1,1);
            mp_click.setVolume(1,1);
            Intent svc=new Intent(SistemPernapasanActivity.this, BackgroundService.class);
            startService(svc); //OR stopService(svc);
        }else {
            imgBtnSoundOn.setVisibility(View.INVISIBLE);
            imgBtnSoundOff.setVisibility(View.VISIBLE);
            mp.setVolume(0,0);
            mp_click.setVolume(0,0);
            Intent svc=new Intent(SistemPernapasanActivity.this, BackgroundService.class);
            stopService(svc); //OR stopService(svc);
        }
        mp = MediaPlayer.create(this, R.raw.sistem_pernapasan1);
        mp.start();
        btnNextSistemPernapasan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp_click.start();
                btnPreviousSistemPernapasan.setVisibility(View.VISIBLE);
                btnNextSistemPernapasan.setVisibility(View.GONE);
                txtSistemPernapasan.setText(materi[1]);
                stopPlaying();
                mp = MediaPlayer.create(SistemPernapasanActivity.this, R.raw.sistem_pernapasan2);
                mp.start();

            }
        });
        btnPreviousSistemPernapasan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp_click.start();
                btnPreviousSistemPernapasan.setVisibility(View.GONE);
                btnNextSistemPernapasan.setVisibility(View.VISIBLE);
                txtSistemPernapasan.setText(materi[0]);
                stopPlaying();
                mp = MediaPlayer.create(SistemPernapasanActivity.this, R.raw.sistem_pernapasan1);
                mp.start();

            }
        });

        btnBackSistemPernapasan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp_click.start();
                mp.release();
                finish();
            }
        });


        Glide.with(this)
                .asGif()
                .load(R.drawable.as)
                .into(imgGif);
        imgBtnSoundOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp_click.start();
                imgBtnSoundOn.setVisibility(View.INVISIBLE);
                imgBtnSoundOff.setVisibility(View.VISIBLE);
                mp.setVolume(0,0);
                mp_click.setVolume(0,0);
                Intent svc=new Intent(SistemPernapasanActivity.this, BackgroundService.class);
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
                mp.setVolume(1,1);
                mp_click.setVolume(1,1);
                Intent svc=new Intent(SistemPernapasanActivity.this, BackgroundService.class);
                startService(svc); //OR stopService(svc);
                editor.putInt("suara", 1);
                editor.apply(); // commit changes
            }
        });


    }
    private void stopPlaying() {
        if (mp != null) {
            mp.stop();
            mp.release();
            mp = null;
        }
    }
}