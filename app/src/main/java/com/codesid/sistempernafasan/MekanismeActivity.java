package com.codesid.sistempernafasan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

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
    MediaPlayer mp;


    String judulMekanisme []={"Mekanisme Pernapasan Dada","Mekanisme Pernapasan Perut"};
    String judulMekanisme2 []={"Pernapasan dada terjadi karena aktivitas otot antar tulang rusuk. \n","Pernapasan perut terjadi karena aktivitas otot diafragma.\n"};
    String penjelasanMekanisme [] ={

                "Otot-otot antartulang rusuk berkontraksi \n" +
                        "Tulang rusuk terangkat -> volume rongga dada membesar -> tekanan udara paru-paru kecil -> udara masuk paru-paru \n",
                    "Otot-otot antartulang rusuk relaksasi \n" +
                            "Tulang rusuk turun -> volume rongga dada mengecil -> tekanan paru-paru membesar -> udara terdorong keluar\n",

                "Otot diaframa berkontraksi (mendatar) \n" +
                        "volume rongga dada membesar -> tekanan udara paru-paru kecil -> udara masuk ke paru-paru \n",

                    "Otot diaframa relaksasi (melengkung) \n" +
                            "volume rongga dada mengecil -> tekanan paru-paru membesar -> udara terdorong keluar.\n"

    };


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
        txtPenjelasanMekanisme.setText(penjelasanMekanisme[0]);
        btnPreviousMekanisme.setVisibility(View.INVISIBLE);
        mp = MediaPlayer.create(MekanismeActivity.this, R.raw.pernapasan_dada);
        mp.start();
        MediaPlayer mp_click = MediaPlayer.create(this, R.raw.click1);

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
                    }else{
                        btnInspirasi.setBackgroundResource(R.drawable.dialog_button_ok);
                        btnEkspirasi.setBackgroundResource(R.drawable.border_organ);
                        txtPenjelasanMekanisme.setText(penjelasanMekanisme[2]);
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
                    }else{
                        btnInspirasi.setBackgroundResource(R.drawable.border_organ);
                        btnEkspirasi.setBackgroundResource(R.drawable.dialog_button_ok);
                        txtPenjelasanMekanisme.setText(penjelasanMekanisme[3]);
                    }
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