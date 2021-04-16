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

public class FrekuensiActivity extends AppCompatActivity {
    @BindView(R.id.txtFrekuensi)
    TextView txtFrekuensi;
    @BindView(R.id.btnFrekuensiUmur)
    ConstraintLayout btnFrekuensiUmur;
    @BindView(R.id.btnFrekuensiJK)
    ConstraintLayout btnFrekuensiJK;
    @BindView(R.id.btnFrekuensiSuhuTubuh)
    ConstraintLayout btnFrekuensiSuhuTubuh;
    @BindView(R.id.btnFrekuensiPosisi)
    ConstraintLayout btnFrekuensiPosisi;
    @BindView(R.id.btnFrekuensiKegiatan)
    ConstraintLayout btnFrekuensiKegiatan;
    @BindView(R.id.btnBackFrekuensi)
    ImageView btnBackFrekuensi;
    MediaPlayer mp;




    String frekuensiPernapasan [] = {
            "Semakin bertambah umur seseorang maka semakin rendah frekuensi pernapasannya. \n",
            "Pada umumnya laki-laki lebih banyak bergerak sehingga lebih banyak memerlukan energi. Jadi, Kebutuhan O2\n" +
                    "dan produksi CO2 pada laki-laki lebih tinggi dibandingkan perempuan.\n",
            "Semakin tinggi suhu tubuh ,maka semakin cepat frekuensi pernapasannya. Hal ini terjadi karena adanya peningkatan metabolisme tubuh, sehingga pemasukan O2 dan produksi CO2.\n",
            "Frekuensi pernapasan saat berdiri lebih banyak jika dibandingkan saat duduk atau berbaring. Pada saat berdiri, otot-otot kaki akan berkontraksi untuk menghasilkan tenaga yang diperlukan tubuh untuk tetap tegak berdiri. Sedangkan pada saat posisi tubuh duduk atau berbaring, beban berat tubuh disangga oleh sebagian besar tubuh sehingga tubuh tidak memerlukan banyak energi.\n",
            "Orang yang melakukan banyak aktivitas  memerlukan lebih banyak energi. Ketika tubuh membutuhkan banyak energi maka tubuh perlu lebih banyak oksigen sehingga frekuensi pernapasan meningkat.\n",
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frekuensi1);

        ButterKnife.bind(this);

        setTextVolume(0);
        btnFrekuensiUmur.setBackgroundResource(R.drawable.dialog_button_ok);
        btnFrekuensiJK.setBackgroundResource(R.drawable.border_organ);
        btnFrekuensiSuhuTubuh.setBackgroundResource(R.drawable.border_organ);
        btnFrekuensiPosisi.setBackgroundResource(R.drawable.border_organ);
        btnFrekuensiKegiatan.setBackgroundResource(R.drawable.border_organ);
        mp = MediaPlayer.create(FrekuensiActivity.this, R.raw.frekuensi_pernapasan);
        mp.start();
        MediaPlayer mp_click = MediaPlayer.create(this, R.raw.click1);


        btnFrekuensiUmur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp_click.start();
                setTextVolume(0);
                btnFrekuensiUmur.setBackgroundResource(R.drawable.dialog_button_ok);
                btnFrekuensiJK.setBackgroundResource(R.drawable.border_organ);
                btnFrekuensiSuhuTubuh.setBackgroundResource(R.drawable.border_organ);
                btnFrekuensiPosisi.setBackgroundResource(R.drawable.border_organ);
                btnFrekuensiKegiatan.setBackgroundResource(R.drawable.border_organ);

            }
        });
        btnFrekuensiJK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp_click.start();
                setTextVolume(1);
                btnFrekuensiUmur.setBackgroundResource(R.drawable.border_organ);
                btnFrekuensiJK.setBackgroundResource(R.drawable.dialog_button_ok);
                btnFrekuensiSuhuTubuh.setBackgroundResource(R.drawable.border_organ);
                btnFrekuensiPosisi.setBackgroundResource(R.drawable.border_organ);
                btnFrekuensiKegiatan.setBackgroundResource(R.drawable.border_organ);
     
            }
        });
        btnFrekuensiSuhuTubuh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp_click.start();
                setTextVolume(2);
                btnFrekuensiUmur.setBackgroundResource(R.drawable.border_organ);
                btnFrekuensiJK.setBackgroundResource(R.drawable.border_organ);
                btnFrekuensiSuhuTubuh.setBackgroundResource(R.drawable.dialog_button_ok);
                btnFrekuensiPosisi.setBackgroundResource(R.drawable.border_organ);
                btnFrekuensiKegiatan.setBackgroundResource(R.drawable.border_organ);
           
            }
        });
        btnFrekuensiPosisi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp_click.start();
                setTextVolume(3);
                btnFrekuensiUmur.setBackgroundResource(R.drawable.border_organ);
                btnFrekuensiJK.setBackgroundResource(R.drawable.border_organ);
                btnFrekuensiSuhuTubuh.setBackgroundResource(R.drawable.border_organ);
                btnFrekuensiPosisi.setBackgroundResource(R.drawable.dialog_button_ok);
                btnFrekuensiKegiatan.setBackgroundResource(R.drawable.border_organ);
            }
        });
        btnFrekuensiKegiatan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp_click.start();
                setTextVolume(4);
                btnFrekuensiUmur.setBackgroundResource(R.drawable.border_organ);
                btnFrekuensiJK.setBackgroundResource(R.drawable.border_organ);
                btnFrekuensiSuhuTubuh.setBackgroundResource(R.drawable.border_organ);
                btnFrekuensiPosisi.setBackgroundResource(R.drawable.border_organ);
                btnFrekuensiKegiatan.setBackgroundResource(R.drawable.dialog_button_ok);
           
            }
        });

        btnBackFrekuensi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp_click.start();
                mp.release();
                finish();
            }
        });



    }


    void setTextVolume(int id){
        txtFrekuensi.setText(frekuensiPernapasan[id]);
    }
    private void stopPlaying() {
        if (mp != null) {
            mp.stop();
            mp.release();
            mp = null;
        }
    }
}