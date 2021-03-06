package com.codesid.sistempernafasan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.pedant.SweetAlert.SweetAlertDialog;

public class ActivityEvaluasiSoal extends AppCompatActivity {

    @BindView(R.id.txtSoal)
    TextView txtSoal;
    @BindView(R.id.txt_answer_a)
    TextView txt_answer_a;
    @BindView(R.id.txt_answer_b)
    TextView txt_answer_b;
    @BindView(R.id.txt_answer_c)
    TextView txt_answer_c;
    @BindView(R.id.txt_answer_d)
    TextView txt_answer_d;
    @BindView(R.id.btnBackEvaluasiSoal)
    ImageView btnBackEvaluasiSoal;
    @BindView(R.id.imgBtn_sound)
    ImageView imgBtnSoundOn;
    @BindView(R.id.imgBtn_sound_off)
    ImageView imgBtnSoundOff;
    MediaPlayer mp;


    int index = 0;
    int score =0;
    int suara;
    private final String[] question = {
            "Urutan jalannya udara pernapasan dari luar ke dalam tubuh yang benar adalah…",
            "Jumlah lobus pada paru-paru kanan dan paru-paru kiri manusia adalah….",
            "Alveolus merupakan bagian akhir dari saluran pernapasan. Alveolus berdinding sangat tipis yang berfungsi untuk….",
            "Perhatikan mekanisme pernapasan dada berikut! 1. Otot antartulang rusuk luar berkontraksi. 2. Tekanan udara dalam rongga dada mengecil. 3. Tulang rusuk terangkat ke atas. 4. Udara masuk ke paru-paru. 5. Volume rongga dada membesar. Mekanisme pernapasan dada pada saat inspirasi secara urut adalah…",
            "Istilah penyebutan dan besarnya volume pernapasan yang merupakan total dari volume tidal, volume cadangan inspirasi, dan volume cadangan ekspirasi adalah….",
            "Pada ujung laring terdapat katup penutup yang berfungsi untuk menutup laring sewaktu menelan makanan dan minuman agar tidak  masuk ke dalam tenggorokan. Katup tersebut dinamakan…",
            "Perhatikan pernyataan berikut! 1. Golongan darah 2. Suhu tubuh 3. Aktivitas tubuh 4. Kualitas udara Pernyataan yang tepat dari faktor yang mempengaruhi frekuensi pernapasan manusia ditunjukkan oleh nomor….",
            "Bu Ana melewati kelas yang sedang kerja bakti sehingga menyebabkan banyak debu beterbangan. Saat partikel debu terhirup, tiba-tiba Bu Ana merasa sesak napas karena terjadi penyempitan saluran napas. Gangguan pernapasan yang diderita oleh Bu Ana adalah….",
            "Paru-paru seorang pasien penuh dengan cairan. Setelah dianalisis, ternyata ditemukan bakteri Streptococcus pneumoniae. Pasien tersebut terserang penyakit…."
    };
    private final String[] answer = new String[10];
    private final String[] key = {"c", "a", "b", "b", "c", "d", "c", "d", "a"};
    private final String[][] option = {
            {
                    "Rongga hidung – faring – trakea – laring – alveolus – bronkus – bronkiolus ",
                    "Rongga hidung – trakea – faring – laring – bronkus – alveolus – bronkiolus ",
                    "Rongga hidung –faring – laring – trakea – bronkus – bronkiolus – alveolus ",
                    "Rongga hidung – laring –  faring – trakea –  bronkus – bronkiolus – alveolus"
            },
            {
                    "Paru-paru kanan memiliki 3 lobus sedangkan paru-paru kiri memiliki 2 lobus ",
                    "Paru-paru kanan memiliki 2 lobus sedangkan paru-paru kiri memiliki 3 lobus",
                    "Paru-paru kanan dan kiri sama-sama memiliki 2 lobus",
                    "Paru-paru kanan dan kiri sama-sama memiliki 3 lobus"
            },
            {
                    "Memperluas permukaan yang digunakan untuk pertukaran gas",
                    "Mempermudah gas-gas berdifusi melewati membran alveolus",
                    "Menyaring benda asing yang masuk bersama udara pernapasan",
                    "Mengangkut gas-gas pernapasan hasil difusi"
            },
            {
                    "1) – 2) – 3) – 4) – 5)",
                    "1) – 3) – 5) – 2) – 4) ",
                    "4) – 1) – 3) – 2) – 5)",
                    "4) – 5) – 2) – 1) – 3) "
            },
            {
                    "Kapasitas vital paru-paru, 3000 mL",
                    "Kapasitas total paru-paru, 3500 mL",
                    "Kapasitas vital paru-paru, 3500 mL",
                    "Kapasitas total paru-paru, 4500 mL"
            },
            {
                    "Pleura",
                    "Silia",
                    "Pita suara",
                    "Epiglotis"
            },
            {
                    "1 dan 2",
                    "1 dan 4",
                    "2 dan 3",
                    "2 dan 4"
            },
            {
                    "Tonsilitis",
                    "TBC",
                    "Pneumonia",
                    "Asma"
            },
            {
                    "Pneumonia",
                    "Asma",
                    "Tuberculosis",
                    "Kanker paru-paru"
            }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaluasi_soal);

        ButterKnife.bind(this);


            _setQuestion();
        MediaPlayer mp_click2 = MediaPlayer.create(this, R.raw.click1);
            btnBackEvaluasiSoal.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mp_click2.start();
                    finish();
                }
            });
        SharedPreferences prefs = getSharedPreferences("MyPref", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
         suara = prefs.getInt("suara", 1); //0 is the default value.
        if (suara==1){
            imgBtnSoundOn.setVisibility(View.VISIBLE);
            imgBtnSoundOff.setVisibility(View.INVISIBLE);
            if (mp!=null) {
                mp.setVolume(0, 0);
            }
            mp_click2.setVolume(1,1);
            Intent svc=new Intent(ActivityEvaluasiSoal.this, BackgroundService.class);
            startService(svc); //OR stopService(svc);
        }else {
            imgBtnSoundOn.setVisibility(View.INVISIBLE);
            imgBtnSoundOff.setVisibility(View.VISIBLE);
            if (mp!=null) {
                mp.setVolume(0, 0);
            }
            mp_click2.setVolume(0,0);
            Intent svc=new Intent(ActivityEvaluasiSoal.this, BackgroundService.class);
            stopService(svc); //OR stopService(svc);
        }

        imgBtnSoundOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp_click2.start();
                imgBtnSoundOn.setVisibility(View.INVISIBLE);
                imgBtnSoundOff.setVisibility(View.VISIBLE);
                mp.setVolume(0,0);
                mp_click2.setVolume(0,0);
                Intent svc=new Intent(ActivityEvaluasiSoal.this, BackgroundService.class);
                stopService(svc); //OR stopService(svc);
                editor.putInt("suara", 0);
                editor.apply(); // commit changes
            }
        });

        imgBtnSoundOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp_click2.start();
                imgBtnSoundOn.setVisibility(View.VISIBLE);
                imgBtnSoundOff.setVisibility(View.INVISIBLE);
                mp.setVolume(1,1);
                mp_click2.setVolume(1,1);
                Intent svc=new Intent(ActivityEvaluasiSoal.this, BackgroundService.class);
                startService(svc); //OR stopService(svc);
                editor.putInt("suara", 1);
                editor.apply(); // commit changes
            }
        });

    }

    public void _optionSelected(View v) {
        MediaPlayer mp_click = MediaPlayer.create(this, R.raw.click1);
        switch (v.getId()) {

            case R.id.btn_a:
                mp_click.start();
                answer[index] = "a";
                _setQuestion();

                if (answer[index].equals(key[index])){
                    stopPlaying();
                    mp = MediaPlayer.create(ActivityEvaluasiSoal.this,R.raw.correct);
                    mp.start();
                    if (suara==1){
                        mp.setVolume(1,1);
                    }else {
                        mp.setVolume(0,0);
                    }
                    new SweetAlertDialog(this, SweetAlertDialog.SUCCESS_TYPE)
                            .setTitleText("Yeay, Benar!")
                            .setContentText("Jawaban anda benar")
                            .show();
                    score+=10;



                }else {
                    stopPlaying();
                    mp = MediaPlayer.create(ActivityEvaluasiSoal.this,R.raw.wrong);
                    mp.start();
                    if (suara==1){
                        mp.setVolume(1,1);
                    }else {
                        mp.setVolume(0,0);
                    }
                    new SweetAlertDialog(this, SweetAlertDialog.ERROR_TYPE)
                            .setTitleText("Yahhh!")
                            .setContentText("Jawaban benar adalah "+key[index].toUpperCase())
                            .show();
                }



                break;

            case R.id.btn_b:
                mp_click.start();
                answer[index] = "b";
                _setQuestion();
                if (answer[index].equals(key[index])){
                    stopPlaying();
                    mp = MediaPlayer.create(ActivityEvaluasiSoal.this,R.raw.correct);
                    mp.start();
                    if (suara==1){
                        mp.setVolume(1,1);
                    }else {
                        mp.setVolume(0,0);
                    }
                    new SweetAlertDialog(this, SweetAlertDialog.SUCCESS_TYPE)
                            .setTitleText("Yeay, Benar!")
                            .setContentText("Jawaban anda benar")
                            .show();
                    score+=10;


                }else {
                    stopPlaying();
                    mp = MediaPlayer.create(ActivityEvaluasiSoal.this,R.raw.wrong);
                    mp.start();
                    new SweetAlertDialog(this, SweetAlertDialog.ERROR_TYPE)
                            .setTitleText("Yahhh!")
                            .setContentText("Jawaban benar adalah "+key[index].toUpperCase())
                            .show();

                }


                break;

            case R.id.btn_c:
                mp_click.start();
                answer[index] = "c";
                _setQuestion();
                if (answer[index].equals(key[index])){
                    stopPlaying();
                    mp = MediaPlayer.create(ActivityEvaluasiSoal.this,R.raw.correct);
                    mp.start();
                    if (suara==1){
                        mp.setVolume(1,1);
                    }else {
                        mp.setVolume(0,0);
                    }
                    new SweetAlertDialog(this, SweetAlertDialog.SUCCESS_TYPE)
                            .setTitleText("Yeay, Benar!")
                            .setContentText("Jawaban anda benar")
                            .show();
                    score+=10;

                }else {
                    stopPlaying();
                    mp = MediaPlayer.create(ActivityEvaluasiSoal.this,R.raw.wrong);
                    mp.start();
                    new SweetAlertDialog(this, SweetAlertDialog.ERROR_TYPE)
                            .setTitleText("Yahhh!")
                            .setContentText("Jawaban benar adalah "+key[index].toUpperCase())
                            .show();

                }


                break;

            case R.id.btn_d:
                mp_click.start();
                answer[index] = "d";
                _setQuestion();
                if (answer[index].equals(key[index])){
                    stopPlaying();
                    mp = MediaPlayer.create(ActivityEvaluasiSoal.this,R.raw.correct);
                    mp.start();
                    new SweetAlertDialog(this, SweetAlertDialog.SUCCESS_TYPE)
                            .setTitleText("Yeay, Benar!")
                            .setContentText("Jawaban anda benar")
                            .show();
                    score+=10;


                }else {
                    stopPlaying();
                    mp = MediaPlayer.create(ActivityEvaluasiSoal.this,R.raw.wrong);
                    mp.start();
                    new SweetAlertDialog(this, SweetAlertDialog.ERROR_TYPE)
                            .setTitleText("Yahhh!")
                            .setContentText("Jawaban benar adalah "+key[index].toUpperCase())
                            .show();

                }


                break;
        }

        index++;
        if (index==9) {
            Intent intent = new Intent(this,ScoreActivity.class);
            intent.putExtra("score",score);
            startActivity(intent);
            finish();
        }else {
            _setQuestion();
        }
    }
    void _setQuestion(){
        txtSoal.setText(question[index]);
        txt_answer_a.setText(option[index][0]);
        txt_answer_b.setText(option[index][1]);
        txt_answer_c.setText(option[index][2]);
        txt_answer_d.setText(option[index][3]);
    }
    private void stopPlaying() {
        if (mp != null) {
            mp.stop();
            mp.release();
            mp = null;
        }
    }

}






