package com.codesid.sistempernafasan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
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
    @BindView(R.id.imgBtn_sound)
    ImageView imgBtnSoundOn;
    @BindView(R.id.imgBtn_sound_off)
    ImageView imgBtnSoundOff;
    MediaPlayer mp;


    String penjelasanOrgan[]={
           "Laring atau ruang suara merupakan organ pernapasan yang menghubungkan faring dengan trakea.\n" +
                   "\n" +
                   "Di dalam laring terdapat epiglotis dan pita suara. \n" +
                   "Epiglotis berupa katup tulang rawan yang berbentuk seperti daun dilapisi oleh sel-sel epitel, berfungsi untuk menutup laring sewaktu menelan makanan atau minuman. Apabila partikel asing masuk ke laring, akan terjadi refleks batuk untuk mengeluarkannya.\n" +
                   "Udara yang melewati laring dapat menggetarkan pita suara, sehingga menghasilkan gelombang suara . \n",
            "Tinggi rendahnya suara dikontrol oleh tegangan pita suara.\n" +
                    "•Apabila pita suara tegang akibat tertarik oleh otot, pita suara akan bergetar lebih cepat dan dihasilkan nada suara yang tinggi. \n" +
                    "•Berkurangnya tegangan pada pita suara akan menyebabkan pita suara bergetar lebih lamban, sehingga menghasilkan nada suara yang rendah.\n"

    };
    String penjelasanOrganHidung[]={
            "Hidung adalah organ pernapasan yang langsung berhubungan dengan udara luar. Hidung dilengkapi dengan rambut-rambut hidung, selaput lendir, dan konka dengan penjelasan sebagai berikut.\n" +
                    "• Rambut hidung berfungsi untuk menyaring partikel debu dan kotoran yang masuk bersama udara.\n",
            "• Selaput lendir berfungsi sebagai perangkap benda asing yang terhirup, misalnya debu, virus, dan bakteri.\n" +
                    "• Konka memiliki banyak kapiler darah yang berfungsi menyamakan suhu udara yang terhirup dari luar dengan suhu tubuh atau menghangatkan udara yang masuk ke paru-paru.\n"

    };
    String penjelasanOrganFaring[]={

            "Organ pernapasan yang terletak di belakang (posterior) rongga hidung hingga rongga mulut dan di atas laring (superior)\n" +
                    "\n" +
                    "Dinding faring tersusun atas otot rangka yang dilapisi oleh membran mukosa. Kontraksi dari otot rangka tersebut membantu dalam proses menelan makanan.\n",

            "Faring berfungsi sebagai jalur masuk udara dan makanan, ruang resonasi udara, serta tempat tonsil yang berpartisipasi dalam reaksi kekebalan tubuh dalam melawan benda asing.\n"
    };



    String judulOrgan []={
            "Laring","Hidung","Faring"
    };
    int id_music [] ={
            R.raw.laring1,R.raw.laring2
    };
    int gambarOrgan [] ={
            R.drawable.organ5
    };
    int gambarOrganHidung [] ={
            R.drawable.organ1
    };
    int gambarOrganFaring [] ={
            R.drawable.organ5
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_khusus_faring);

        ButterKnife.bind(this);

        Intent intent = getIntent();
        MediaPlayer mp_click = MediaPlayer.create(this, R.raw.click1);

        SharedPreferences prefs = getSharedPreferences("MyPref", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        int suara = prefs.getInt("suara", 1); //0 is the default value.
        if (suara==1){
            imgBtnSoundOn.setVisibility(View.VISIBLE);
            imgBtnSoundOff.setVisibility(View.INVISIBLE);
            if (mp!=null){
                mp.setVolume(1,1);
            }
            mp_click.setVolume(1,1);
            Intent svc=new Intent(ActivityKhususFaring.this, BackgroundService.class);
            startService(svc); //OR stopService(svc);
        }else {
            imgBtnSoundOn.setVisibility(View.INVISIBLE);
            imgBtnSoundOff.setVisibility(View.VISIBLE);
            if (mp!=null){
                mp.setVolume(1,1);
            }
            mp_click.setVolume(0,0);
            Intent svc=new Intent(ActivityKhususFaring.this, BackgroundService.class);
            stopService(svc); //OR stopService(svc);
        }


        if (intent.getIntExtra("key2",0)==0){
            txtNamaOrgan.setText(judulOrgan[1]);
            txtPenjelasanOrgan.setText(penjelasanOrganHidung[0]);


            imgGambarOrgan.setImageResource(gambarOrganHidung[0]);
            btnPreviousSistemPernapasanKhusus.setVisibility(View.GONE);
            mp = MediaPlayer.create(ActivityKhususFaring.this, R.raw.hidung);
            mp.start();

            if (suara==1){
                mp.setVolume(1,1);
            }else {
                mp.setVolume(0,0);
            }
            btnNextSistemPernapasanKhsus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mp_click.start();
                    btnPreviousSistemPernapasanKhusus.setVisibility(View.VISIBLE);
                    btnNextSistemPernapasanKhsus.setVisibility(View.GONE);
                    txtPenjelasanOrgan.setText(penjelasanOrganHidung[1]);
                }
            });
            btnPreviousSistemPernapasanKhusus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mp_click.start();
                    btnPreviousSistemPernapasanKhusus.setVisibility(View.GONE);
                    btnNextSistemPernapasanKhsus.setVisibility(View.VISIBLE);
                    txtPenjelasanOrgan.setText(penjelasanOrganHidung[0]);
                }
            });
        }else if (intent.getIntExtra("key2",0)==5){

            txtNamaOrgan.setText(judulOrgan[0]);
            txtPenjelasanOrgan.setText(penjelasanOrgan[0]);


            imgGambarOrgan.setImageResource(gambarOrgan[0]);
            btnPreviousSistemPernapasanKhusus.setVisibility(View.GONE);
            mp = MediaPlayer.create(ActivityKhususFaring.this, R.raw.laring1);
            mp.start();
            if (suara==1){
                mp.setVolume(1,1);
            }else {
                mp.setVolume(0,0);
            }
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

        }
        else {

            txtNamaOrgan.setText(judulOrgan[2]);
            txtPenjelasanOrgan.setText(penjelasanOrganFaring[0]);


            imgGambarOrgan.setImageResource(gambarOrganFaring[0]);
            btnPreviousSistemPernapasanKhusus.setVisibility(View.GONE);
            mp = MediaPlayer.create(ActivityKhususFaring.this, R.raw.faring);
            mp.start();
            if (suara==1){
                mp.setVolume(1,1);
            }else {
                mp.setVolume(0,0);
            }
            btnNextSistemPernapasanKhsus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mp_click.start();
                    btnPreviousSistemPernapasanKhusus.setVisibility(View.VISIBLE);
                    btnNextSistemPernapasanKhsus.setVisibility(View.GONE);
                    txtPenjelasanOrgan.setText(penjelasanOrganFaring[1]);

                }
            });
            btnPreviousSistemPernapasanKhusus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mp_click.start();
                    btnPreviousSistemPernapasanKhusus.setVisibility(View.GONE);
                    btnNextSistemPernapasanKhsus.setVisibility(View.VISIBLE);
                    txtPenjelasanOrgan.setText(penjelasanOrganFaring[0]);
                }
            });

        }
        btnBackOrganDetail.setOnClickListener(new View.OnClickListener() {
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
                Intent svc=new Intent(ActivityKhususFaring.this, BackgroundService.class);
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
                Intent svc=new Intent(ActivityKhususFaring.this, BackgroundService.class);
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