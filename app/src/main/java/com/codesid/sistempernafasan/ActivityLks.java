package com.codesid.sistempernafasan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ActivityLks extends AppCompatActivity {


    @BindView(R.id.btnHidung)
    ConstraintLayout btnHidung;
    @BindView(R.id.btnBackLKS)
    ImageView btnBackLks;
    @BindView(R.id.btnBronkus)
    ConstraintLayout btnBronkus;
    @BindView(R.id.btnBronkiolus)
    ConstraintLayout btnBronkiolus;
    @BindView(R.id.btnAlveolus)
    ConstraintLayout btnAlveolus;
    @BindView(R.id.btnFaring)
    ConstraintLayout btnFaring;
    @BindView(R.id.btnLaring)
    ConstraintLayout btnLaring;
    @BindView(R.id.btnTrakea)
    ConstraintLayout btnTrakea;
    @BindView(R.id.btnParu)
    ConstraintLayout btnParu;
    @BindView(R.id.txtHidung)
    TextView txtHidung;
    @BindView(R.id.txtBronkus)
    TextView txtBronkus;
    @BindView(R.id.txtBronkiolus)
    TextView txtBronkiolus;
    @BindView(R.id.txtAlveolus)
    TextView txtAlveolus;
    @BindView(R.id.txtFaring)
    TextView txtFaring;
    @BindView(R.id.txtLaring)
    TextView txtLaring;
    @BindView(R.id.txtTrakea)
    TextView txtTrakea;
    @BindView(R.id.txtParu)
    TextView txtParu;
    @BindView(R.id.imgBtn_sound)
    ImageView imgBtnSoundOn;
    @BindView(R.id.imgBtn_sound_off)
    ImageView imgBtnSoundOff;



    int skor = 0;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lks);

        ButterKnife.bind(this);
        MediaPlayer mp_click = MediaPlayer.create(this, R.raw.click1);


        SharedPreferences prefs = getSharedPreferences("MyPref", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        int suara = prefs.getInt("suara", 1); //0 is the default value.
        if (suara==1){
            imgBtnSoundOn.setVisibility(View.VISIBLE);
            imgBtnSoundOff.setVisibility(View.INVISIBLE);

            mp_click.setVolume(1,1);
            Intent svc=new Intent(ActivityLks.this, BackgroundService.class);
            startService(svc); //OR stopService(svc);
        }else {
            imgBtnSoundOn.setVisibility(View.INVISIBLE);
            imgBtnSoundOff.setVisibility(View.VISIBLE);

            mp_click.setVolume(0,0);
            Intent svc=new Intent(ActivityLks.this, BackgroundService.class);
            stopService(svc); //OR stopService(svc);
        }
        btnHidung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp_click.start();
                if (txtHidung.getText().equals("Hidung")){

                }else {
                    showDialog("Hidung", btnHidung, 0, txtHidung);
                }
            }
        });
        btnBronkus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp_click.start();
                showDialog("Bronkus",btnBronkus,1,txtBronkus);
            }
        });
        btnBronkiolus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp_click.start();
                showDialog("Bronkiolus",btnBronkiolus,2,txtBronkiolus);
            }
        });

        btnAlveolus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp_click.start();
                showDialog("Alveolus",btnAlveolus,3,txtAlveolus);
            }
        });
        btnFaring.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp_click.start();
                showDialog("Faring",btnFaring,4,txtFaring);
            }
        });
        btnLaring.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp_click.start();
                showDialog("Laring",btnLaring,5,txtLaring);
            }
        });
        btnTrakea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp_click.start();
                showDialog("Trakea",btnTrakea,6,txtTrakea);
            }
        });
        btnParu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp_click.start();
                showDialog("Paru-Paru",btnParu,7,txtParu);
            }
        });
        btnBackLks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp_click.start();
                finish();
            }
        });





        imgBtnSoundOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp_click.start();
                imgBtnSoundOn.setVisibility(View.INVISIBLE);
                imgBtnSoundOff.setVisibility(View.VISIBLE);

                mp_click.setVolume(0,0);
                Intent svc=new Intent(ActivityLks.this, BackgroundService.class);
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
                Intent svc=new Intent(ActivityLks.this, BackgroundService.class);
                startService(svc); //OR stopService(svc);
                editor.putInt("suara", 1);
                editor.apply(); // commit changes
            }
        });


    }


    public void showDialog(String value, ConstraintLayout cl, int index, TextView textView){
        Dialog alertDialog = new Dialog(ActivityLks.this);
        alertDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        alertDialog.setContentView(R.layout.dialog_materi);
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        String organ [] ={"Hidung","Bronkus","Bronkiolus","Alveolus","Faring","Laring","Trakea","Paru-Paru"};

        final Spinner spinner = alertDialog.findViewById(R.id.spinner_organ);
        final Button btnok = alertDialog.findViewById(R.id.btn_ok_materi);


        btnok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (spinner.getSelectedItem().equals(organ[index])){
                    cl.setBackgroundResource(R.drawable.border_organ_true);
                    alertDialog.dismiss();
                    textView.setText(organ[index]);
                    skor+=10;

                }else{
                    cl.setBackgroundResource(R.drawable.border_organ_false);
                    alertDialog.dismiss();
                }



            }
        });






        alertDialog.show();
    }

}