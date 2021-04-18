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

public class VolumeActivity extends AppCompatActivity {
    @BindView(R.id.txtVolumePernapasan)
    TextView txtVolumePernapasan;
    @BindView(R.id.btnVolumeTidal)
    ConstraintLayout btnVolumeTidal;
    @BindView(R.id.btnVolumeCadanganEkspirasi)
    ConstraintLayout btnVolumeCadanganEkspirasi;
    @BindView(R.id.btnVolumeCadanganKomplementer)
    ConstraintLayout btnVolumeCadanganKomplementer;
    @BindView(R.id.btnVolumeResidu)
    ConstraintLayout btnVolumeResidu;
    @BindView(R.id.btnVitalParu)
    ConstraintLayout btnVitalParu;
    @BindView(R.id.btnKapasitasTotal)
    ConstraintLayout btnKapasitasTotal;
    @BindView(R.id.btnBackVolume)
    ImageView btnBackVolume;
    @BindView(R.id.imgBtn_sound)
    ImageView imgBtnSoundOn;
    @BindView(R.id.imgBtn_sound_off)
    ImageView imgBtnSoundOff;
    MediaPlayer mp;



    String volumePernapasan [] = {
                    "Volume udara yang keluar masuk paru-paru saat tubuh melakukan inspirasi atau ekspirasi biasa (normal), volumenya sekitar 500 mL.\n",
                    "Volume udara yang masih dapat dikeluarkan secara maksimal dari paru-paru setelah melakukan ekspirasi biasa.volumenya sekitar 1500 mL \n",
                    "Volume udara yang masih dapat dimasukkan ke dalam paru-paru setelah melakukan inspirasi secara biasa. volumenya sekitar 1500 mL\n",
                    "Volume udara yang masih tersisa di dalam paru-paru meskipun telah melakukan ekspirasi secara maksimal,volumenya sekitar 1000 mL\n",
                    "Total dari volume tidal + volume cadangan ekspirasi + volume cadangan inspirasi,volumenya sekitar  3500 mL",
                    "Volume udara yang dapat ditampung secara maksimal dalam paru-paru. Merupakan total dari volume kapasitas vital paru-paru volume residu,volumenya sekitar 4500 mL\n"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volume);

        ButterKnife.bind(this);

        setTextVolume(0);
        btnVolumeTidal.setBackgroundResource(R.drawable.dialog_button_ok);
        btnVolumeCadanganEkspirasi.setBackgroundResource(R.drawable.border_organ);
        btnVolumeCadanganKomplementer.setBackgroundResource(R.drawable.border_organ);
        btnVolumeResidu.setBackgroundResource(R.drawable.border_organ);
        btnVitalParu.setBackgroundResource(R.drawable.border_organ);
        btnKapasitasTotal.setBackgroundResource(R.drawable.border_organ);
        mp = MediaPlayer.create(VolumeActivity.this, R.raw.volume_pernapasan);
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
            Intent svc=new Intent(VolumeActivity.this, BackgroundService.class);
            startService(svc); //OR stopService(svc);
        }else {
            imgBtnSoundOn.setVisibility(View.INVISIBLE);
            imgBtnSoundOff.setVisibility(View.VISIBLE);
            mp.setVolume(0,0);
            mp_click.setVolume(0,0);
            Intent svc=new Intent(VolumeActivity.this, BackgroundService.class);
            stopService(svc); //OR stopService(svc);
        }


        btnVolumeTidal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp_click.start();
                setTextVolume(0);
                btnVolumeTidal.setBackgroundResource(R.drawable.dialog_button_ok);
                btnVolumeCadanganEkspirasi.setBackgroundResource(R.drawable.border_organ);
                btnVolumeCadanganKomplementer.setBackgroundResource(R.drawable.border_organ);
                btnVolumeResidu.setBackgroundResource(R.drawable.border_organ);
                btnVitalParu.setBackgroundResource(R.drawable.border_organ);
                btnKapasitasTotal.setBackgroundResource(R.drawable.border_organ);
            }
        });
        btnVolumeCadanganEkspirasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp_click.start();
                setTextVolume(1);
                btnVolumeTidal.setBackgroundResource(R.drawable.border_organ);
                btnVolumeCadanganEkspirasi.setBackgroundResource(R.drawable.dialog_button_ok);
                btnVolumeCadanganKomplementer.setBackgroundResource(R.drawable.border_organ);
                btnVolumeResidu.setBackgroundResource(R.drawable.border_organ);
                btnVitalParu.setBackgroundResource(R.drawable.border_organ);
                btnKapasitasTotal.setBackgroundResource(R.drawable.border_organ);
            }
        });
        btnVolumeCadanganKomplementer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp_click.start();
                setTextVolume(2);
                btnVolumeTidal.setBackgroundResource(R.drawable.border_organ);
                btnVolumeCadanganEkspirasi.setBackgroundResource(R.drawable.border_organ);
                btnVolumeCadanganKomplementer.setBackgroundResource(R.drawable.dialog_button_ok);
                btnVolumeResidu.setBackgroundResource(R.drawable.border_organ);
                btnVitalParu.setBackgroundResource(R.drawable.border_organ);
                btnKapasitasTotal.setBackgroundResource(R.drawable.border_organ);
            }
        });
        btnVolumeResidu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp_click.start();
                setTextVolume(3);
                btnVolumeTidal.setBackgroundResource(R.drawable.border_organ);
                btnVolumeCadanganEkspirasi.setBackgroundResource(R.drawable.border_organ);
                btnVolumeCadanganKomplementer.setBackgroundResource(R.drawable.border_organ);
                btnVolumeResidu.setBackgroundResource(R.drawable.dialog_button_ok);
                btnVitalParu.setBackgroundResource(R.drawable.border_organ);
                btnKapasitasTotal.setBackgroundResource(R.drawable.border_organ);
            }
        });
        btnVitalParu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp_click.start();
                setTextVolume(4);
                btnVolumeTidal.setBackgroundResource(R.drawable.border_organ);
                btnVolumeCadanganEkspirasi.setBackgroundResource(R.drawable.border_organ);
                btnVolumeCadanganKomplementer.setBackgroundResource(R.drawable.border_organ);
                btnVolumeResidu.setBackgroundResource(R.drawable.border_organ);
                btnVitalParu.setBackgroundResource(R.drawable.dialog_button_ok);
                btnKapasitasTotal.setBackgroundResource(R.drawable.border_organ);
            }
        });
        btnKapasitasTotal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp_click.start();
                setTextVolume(5);
                btnVolumeTidal.setBackgroundResource(R.drawable.border_organ);
                btnVolumeCadanganEkspirasi.setBackgroundResource(R.drawable.border_organ);
                btnVolumeCadanganKomplementer.setBackgroundResource(R.drawable.border_organ);
                btnVolumeResidu.setBackgroundResource(R.drawable.border_organ);
                btnVitalParu.setBackgroundResource(R.drawable.border_organ);
                btnKapasitasTotal.setBackgroundResource(R.drawable.dialog_button_ok);
            }
        });

        btnBackVolume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp_click.start();
                mp.release();
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
                mp_click.setVolume(0,0);
                Intent svc=new Intent(VolumeActivity.this, BackgroundService.class);
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
                Intent svc=new Intent(VolumeActivity.this, BackgroundService.class);
                startService(svc); //OR stopService(svc);
                editor.putInt("suara", 1);
                editor.apply(); // commit changes
            }
        });

    }


    void setTextVolume(int id){
        txtVolumePernapasan.setText(volumePernapasan[id]);
    }

}