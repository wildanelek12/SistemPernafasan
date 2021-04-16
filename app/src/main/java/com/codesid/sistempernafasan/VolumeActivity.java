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


    }


    void setTextVolume(int id){
        txtVolumePernapasan.setText(volumePernapasan[id]);
    }

}