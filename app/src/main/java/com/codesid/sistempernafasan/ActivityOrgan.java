package com.codesid.sistempernafasan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ActivityOrgan extends AppCompatActivity {


    @BindView(R.id.btnHidung)
    ConstraintLayout btnHidung;
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

    int skor = 0;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_organ);

        ButterKnife.bind(this);


        btnHidung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog("Hidung",btnHidung,0);
            }
        });
        btnBronkus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog("Bronkus",btnBronkus,1);
            }
        });
        btnBronkiolus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog("Bronkiolus",btnBronkiolus,2);
            }
        });

        btnAlveolus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog("Alveolus",btnAlveolus,3);
            }
        });
        btnFaring.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog("Faring",btnFaring,4);
            }
        });
        btnLaring.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog("Laring",btnLaring,5);
            }
        });
        btnTrakea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog("Trakea",btnTrakea,6);
            }
        });
        btnParu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog("Paru-Paru",btnParu,7);
            }
        });






    }


    public void showDialog(String value,ConstraintLayout cl,int index){
        Dialog alertDialog = new Dialog(ActivityOrgan.this);
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
                    cl.setEnabled(false);
                    skor+=10;
                }else{
                    cl.setBackgroundResource(R.drawable.border_organ_false);
                    alertDialog.dismiss();
                }

                if (skor==80){
//                    Toast.makeText(ActivityOrgan.this, "Sudah Selesai Semua", Toast.LENGTH_SHORT).show();

                }


            }
        });




        alertDialog.show();
    }

}