package com.codesid.sistempernafasan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MekanismeActivity extends AppCompatActivity {

    @BindView(R.id.txtJudulMekanisme)
    TextView txtJudulMekanisme;
    @BindView(R.id.imgMekanismePernapasan)
    ImageView imgMekanismePernapasan;
    @BindView(R.id.txtPenjelasanMekanisme)
    TextView txtPenjelasanMekanisme;
    @BindView(R.id.txtJudulMekanismeFix)
    TextView txtJudulMekanismeFix;
    @BindView(R.id.btnInspirasi)
    ConstraintLayout btnInspirasi;
    @BindView(R.id.btnEkspirasi)
    ConstraintLayout btnEkspirasi;
    @BindView(R.id.btnNextMekanisme)
    ImageView btnNextMekanisme;
    @BindView(R.id.btnPreviousMekanisme)
    ImageView btnPreviousMekanisme;
    @BindView(R.id.btnBackMekanisme)
    ImageView btnBackMekanisme;
    @BindView(R.id.imgBtn_sound)
    ImageView imgBtnSoundOn;
    @BindView(R.id.imgBtn_sound_off)
    ImageView imgBtnSoundOff;
    MediaPlayer mp;


    String judulMekanisme []={"Mekanisme Pernapasan Dada","Mekanisme Pernapasan Perut"};
    String judulMekanisme2 []={"Pernapasan dada terjadi karena aktivitas otot antar tulang rusuk. \n","Pernapasan perut terjadi karena aktivitas otot diafragma.\n"};
    String penjelasanMekanisme [] ={

                "Otot-otot antartulang rusuk berkontraksi → \n" +
                        "Tulang rusuk terangkat → volume rongga dada membesar → tekanan udara paru-paru kecil → udara masuk paru-paru \n",
                    "Otot-otot antartulang rusuk relaksasi → \n" +
                            "Tulang rusuk turun → volume rongga dada mengecil → tekanan paru-paru membesar → udara terdorong keluar\n",

                "Otot diaframa berkontraksi (mendatar) → \n" +
                        "volume rongga dada membesar → tekanan udara paru-paru kecil → udara masuk ke paru-paru \n",

                    "Otot diaframa relaksasi (melengkung) → \n" +
                            "volume rongga dada mengecil  →  tekanan paru-paru membesar →  udara terdorong keluar.\n"

    };
    int gambarMekanisme []={R.drawable.dada_inspirasi,R.drawable.dada_ekspirasi,R.drawable.perut_inspirasi,R.drawable.perut_ekspirasi};


    int index = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mekanisme);

        ButterKnife.bind(this);
        txtJudulMekanismeFix.setText(judulMekanisme[index]);
        txtJudulMekanisme.setText(judulMekanisme2[index]);
        btnInspirasi.setBackgroundResource(R.drawable.dialog_button_ok);
        btnEkspirasi.setBackgroundResource(R.drawable.border_organ);
        imgMekanismePernapasan.setImageResource(gambarMekanisme[0]);
        txtPenjelasanMekanisme.setText(penjelasanMekanisme[0]);
        btnPreviousMekanisme.setVisibility(View.INVISIBLE);
        mp = MediaPlayer.create(MekanismeActivity.this, R.raw.pernapasan_dada);
        mp.start();
        MediaPlayer mp_click = MediaPlayer.create(this, R.raw.click1);

        SharedPreferences prefs = getSharedPreferences("MyPref", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        int suara = prefs.getInt("suara", 1); //0 is the default value.
        if (suara==1){
            imgBtnSoundOn.setVisibility(View.VISIBLE);
            imgBtnSoundOff.setVisibility(View.INVISIBLE);
            mp.setVolume(1,1);
            mp_click.setVolume(1,1);
            Intent svc=new Intent(MekanismeActivity.this, BackgroundService.class);
            startService(svc); //OR stopService(svc);
        }else {
            imgBtnSoundOn.setVisibility(View.INVISIBLE);
            imgBtnSoundOff.setVisibility(View.VISIBLE);
            mp.setVolume(0,0);
            mp_click.setVolume(0,0);
            Intent svc=new Intent(MekanismeActivity.this, BackgroundService.class);
            stopService(svc); //OR stopService(svc);
        }

        btnBackMekanisme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp_click.start();
                mp.release();
                finish();
            }
        });
        btnNextMekanisme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp_click.start();
                index++;
                btnNextMekanisme.setVisibility(View.INVISIBLE);
                btnPreviousMekanisme.setVisibility(View.VISIBLE);
                btnInspirasi.setBackgroundResource(R.drawable.dialog_button_ok);
                btnEkspirasi.setBackgroundResource(R.drawable.border_organ);
                txtPenjelasanMekanisme.setText(penjelasanMekanisme[2]);
                txtJudulMekanismeFix.setText(judulMekanisme[index]);
                txtJudulMekanisme.setText(judulMekanisme2[index]);
                imgMekanismePernapasan.setImageResource(gambarMekanisme[2]);
                stopPlaying();
                mp = MediaPlayer.create(MekanismeActivity.this, R.raw.pernapasan_perut);
                mp.start();
            }
        });

        btnPreviousMekanisme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp_click.start();
                index--;
                btnInspirasi.setBackgroundResource(R.drawable.dialog_button_ok);
                btnEkspirasi.setBackgroundResource(R.drawable.border_organ);
                btnNextMekanisme.setVisibility(View.VISIBLE);
                btnPreviousMekanisme.setVisibility(View.INVISIBLE);
                txtPenjelasanMekanisme.setText(penjelasanMekanisme[0]);
                txtJudulMekanismeFix.setText(judulMekanisme[index]);
                txtJudulMekanisme.setText(judulMekanisme2[index]);
                imgMekanismePernapasan.setImageResource(gambarMekanisme[0]);
                stopPlaying();
                mp = MediaPlayer.create(MekanismeActivity.this, R.raw.pernapasan_dada);
                mp.start();
            }
        });


            btnInspirasi.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mp_click.start();
                    if (index==0) {
                        btnInspirasi.setBackgroundResource(R.drawable.dialog_button_ok);
                        btnEkspirasi.setBackgroundResource(R.drawable.border_organ);
                        txtPenjelasanMekanisme.setText(penjelasanMekanisme[0]);
                        imgMekanismePernapasan.setImageResource(gambarMekanisme[0]);
                    }else{
                        btnInspirasi.setBackgroundResource(R.drawable.dialog_button_ok);
                        btnEkspirasi.setBackgroundResource(R.drawable.border_organ);
                        txtPenjelasanMekanisme.setText(penjelasanMekanisme[2]);
                        imgMekanismePernapasan.setImageResource(gambarMekanisme[2]);
                    }

                }
            });
            btnEkspirasi.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mp_click.start();
                    if (index==0) {
                        btnInspirasi.setBackgroundResource(R.drawable.border_organ);
                        btnEkspirasi.setBackgroundResource(R.drawable.dialog_button_ok);
                        txtPenjelasanMekanisme.setText(penjelasanMekanisme[1]);
                        imgMekanismePernapasan.setImageResource(gambarMekanisme[1]);
                    }else{
                        btnInspirasi.setBackgroundResource(R.drawable.border_organ);
                        btnEkspirasi.setBackgroundResource(R.drawable.dialog_button_ok);
                        txtPenjelasanMekanisme.setText(penjelasanMekanisme[3]);
                        imgMekanismePernapasan.setImageResource(gambarMekanisme[3]);
                    }
                }
            });


        imgBtnSoundOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp_click.start();
                imgBtnSoundOn.setVisibility(View.INVISIBLE);
                imgBtnSoundOff.setVisibility(View.VISIBLE);
                mp.setVolume(0,0);
                mp_click.setVolume(0,0);
                Intent svc=new Intent(MekanismeActivity.this, BackgroundService.class);
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
                Intent svc=new Intent(MekanismeActivity.this, BackgroundService.class);
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