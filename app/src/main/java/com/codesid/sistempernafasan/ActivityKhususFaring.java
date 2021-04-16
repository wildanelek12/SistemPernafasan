package com.codesid.sistempernafasan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ActivityKhususFaring extends AppCompatActivity {
    @BindView(R.id.txtNamaOrgankhusus)
    TextView txtNamaOrgan;
    @BindView(R.id.txtPenjelasanOrganKhusus)
    TextView txtPenjelasanOrgan;
    @BindView(R.id.imgGambarOrgankhusus)
    ImageView imgGambarOrgan;
    @BindView(R.id.btnBackKhususFaring)
    ImageView btnBackOrganDetail;
    @BindView(R.id.btnNextSistemPernapasanKhsus)
    ImageView btnNextSistemPernapasanKhsus;
    @BindView(R.id.btnPreviousSistemPernapasanKhusus)
    ImageView btnPreviousSistemPernapasanKhusus;
    MediaPlayer mp;


    String penjelasanOrgan[]={
           "Laring atau ruang suara merupakan organ pernapasan yang menghubungkan faring dengan trakea.\n" +
                   "\n" +
                   "Di dalam laring terdapat epiglotis dan pita suara. \n" +
                   "Epiglotis berupa katup tulang rawan yang berbentuk seperti daun dilapisi oleh sel-sel epitel, berfungsi untuk menutup laring sewaktu menelan makanan atau minuman. Apabila partikel asing masuk ke laring, akan terjadi refleks batuk untuk mengekuarkannya.\n" +
                   "Udara yang melewati laring dapat menggetarkan pita suara, sehingga menghasilkan gelombang suara . \n",
            "Tinggi rendahnya suara dikontrol oleh tegangan pita suara.\n" +
                    "Apabila pita suara tegang akibat tertarik oleh otot, pita suara akan bergetar lebih cepat dan dihasilkan nada suara yang tinggi. \n" +
                    "Berkurangnya tegangan pada pita suara akan menyebabkan pita suara bergetar lebih lamban, sehingga menghasilkan nada suara yang rendah.\n"

    };


    String judulOrgan []={
            "Laring"
    };
    int id_music [] ={
            R.raw.laring1,R.raw.laring2
    };
    int gambarOrgan [] ={
            R.drawable.organ5
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_khusus_faring);

        ButterKnife.bind(this);

        Intent intent = getIntent();
        txtNamaOrgan.setText(judulOrgan[0]);
        txtPenjelasanOrgan.setText(penjelasanOrgan[0]);
        MediaPlayer mp_click = MediaPlayer.create(this, R.raw.click1);

            imgGambarOrgan.setImageResource(gambarOrgan[0]);
        btnPreviousSistemPernapasanKhusus.setVisibility(View.GONE);
        mp = MediaPlayer.create(ActivityKhususFaring.this, R.raw.laring1);
        mp.start();
        btnNextSistemPernapasanKhsus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp_click.start();
                btnPreviousSistemPernapasanKhusus.setVisibility(View.VISIBLE);
                btnNextSistemPernapasanKhsus.setVisibility(View.GONE);
                txtPenjelasanOrgan.setText(penjelasanOrgan[1]);
                stopPlaying();
                mp = MediaPlayer.create(ActivityKhususFaring.this, R.raw.laring2);
                mp.start();
            }
        });
        btnPreviousSistemPernapasanKhusus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp_click.start();
                btnPreviousSistemPernapasanKhusus.setVisibility(View.GONE);
                btnNextSistemPernapasanKhsus.setVisibility(View.VISIBLE);
                txtPenjelasanOrgan.setText(penjelasanOrgan[0]);
                stopPlaying();
                mp = MediaPlayer.create(ActivityKhususFaring.this, R.raw.laring1);
                mp.start();
            }
        });

        btnBackOrganDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp_click.start();
                mp.release();
                finish();
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