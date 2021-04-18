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

public class ActivityOrganDetail extends AppCompatActivity {
    @BindView(R.id.txtNamaOrgan)
    TextView txtNamaOrgan;
    @BindView(R.id.txtPenjelasanOrgan)
    TextView txtPenjelasanOrgan;
    @BindView(R.id.imgGambarOrgan)
    ImageView imgGambarOrgan;
    @BindView(R.id.btnBackOrganDetail)
    ImageView btnBackOrganDetail;
    @BindView(R.id.imgBtn_sound)
    ImageView imgBtnSoundOn;
    @BindView(R.id.imgBtn_sound_off)
    ImageView imgBtnSoundOff;

    String penjelasanOrgan[]={
            "Hidung adalah organ pernapasan yang langsung berhubungan dengan udara luar. Hidung dilengkapi dengan rambut-rambut hidung, selaput lendir, dan konka dengan penjelasan sebagai berikut."+
            "Rambut hidung berfungsi untuk menyaring partikel debu dan kotoran yang masuk bersama udara."+
            "Selaput lendir berfungsi sebagai perangkap benda asing yang terhirup, misalnya debu, virus, dan bakteri."+
            "Konka memiliki banyak kapiler darah yang berfungsi menyamakan suhu udara yang terhirup dari luar dengan suhu tubuh atau menghangatkan udara yang masuk ke paru-paru.",

            "Bronkus adalah bagian paling dasar dari trakea yang bercabang menjadi dua. Masing-masing bronkus memasuki paru-paru kanan dan paru-paru kiri.  Struktur bronkus hampir sama dengan trakea, tetapi lebih sempit. Bentuk tulang rawan bronkus tidak teratur, tetapi berselang-seling dengan otot polos.\n",

            "Bronkiolus merupakan cabang-cabang kecil dari bronkus. Pada ujung-ujung bronkiolus terdapat gelembung-gelembung yang sangat kecil dan berdinding tipis yang disebut alveolus (jamak = alveoli).\n",

            "Alveolus adalah bagian paru-paru yang berperan dalam pertukaran gas oksigen dan gas karbon dioksida. \n" +
                    "Dinding alveolus tersusun atas satu lapis jaringan epitel pipih untuk memudahkan molekul-molekul gas melaluinya. Dinding alveolus berbatasan dengan pembuluh kapiler darah agar gas-gas dalam alveolus dapat dengan mudah mengalami pertukaran dengan gas-gas yang ada di dalam darah. \n",

            "Organ pernapasan yang terletak di belakang (posterior) rongga hidung hingga rongga mulut dan di atas laring (superior)\n" +
                    "\n" +
                    "Dinding faring tersusun atas otot rangka yang dilapisi oleh membran mukosa. Kontraksi dari otot rangka tersebut membantu dalam proses menelan makanan.\n" +
                    "\n" +
                    "Faring berfungsi sebagai jalur masuk udara dan makanan, ruang resonasi udara, serta tempat tonsil yang berpartisipasi dalam reaksi kekebalan tubuh dalam melawan benda asing.\n",

            "Laring atau ruang suara merupakan organ pernapasan yang menghubungkan faring dengan trakea.\n" +
                    "\n" +
                    "Di dalam laring terdapat epiglotis dan pita suara. \n" +
                    "Epiglotis berupa katup tulang rawan yang berbentuk seperti daun dilapisi oleh sel-sel epitel, berfungsi untuk menutup laring sewaktu menelan makanan atau minuman. Apabila partikel asing masuk ke laring, akan terjadi refleks batuk untuk mengekuarkannya.\n" +
                    "Udara yang melewati laring dapat menggetarkan pita suara, sehingga menghasilkan gelombang suara . \n",

            "Trakea adalah saluran yang menghubungkan laring dengan bronkus. Dinding trakea tersusun dari cincin-cincin tulang rawan dan selaput lendir yang terdiri atas jaringan epitelium bersilia. Fungsi silia pada dinding trakea untuk menyaring benda-benda asing yang masuk ke dalam saluran pernapasan\n",

            "Paru-paru merupakan alat pernapasan utama. Paru-paru terbagi menjadi dua bagian, yaitu paru-paru kanan (pulmo dekster) yang terdiri atas 3 lobus dan paru-paru kiri (pulmo sinister) yang terdiri atas 2 lobus. \n" +
                    "Paru-paru dibungkus oleh pleura. Pleura adalah kantung tertutup berisi cairan limfa yang berfungsi melindungi paru-paru dari gesekan saat mengembang dan mengempis.\n"


             };


    String judulOrgan []={
            "Hidung","Bronkus","Bronkiolus","Alveolus","Faring","Laring","Trakea","Paru-Paru"
    };
    int id_music [] ={
            R.raw.hidung,R.raw.bronkus,R.raw.bronkiolus,R.raw.alveolus,R.raw.faring,R.raw.laring1,R.raw.trakea,R.raw.paru_paru
    };

    int gambarOrgan [] ={
            R.drawable.organ1,R.drawable.organ2,R.drawable.organ2,R.drawable.organ2,R.drawable.organ5,R.drawable.organ5,R.drawable.organ2,R.drawable.organ8
    };
    MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_organ_detail);

        ButterKnife.bind(this);
        MediaPlayer mp_click = MediaPlayer.create(this, R.raw.click1);

        SharedPreferences prefs = getSharedPreferences("MyPref", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        int suara = prefs.getInt("suara", 1); //0 is the default value.
        if (suara==1){
            imgBtnSoundOn.setVisibility(View.VISIBLE);
            imgBtnSoundOff.setVisibility(View.INVISIBLE);
            mp.setVolume(1,1);
            mp_click.setVolume(1,1);
            Intent svc=new Intent(ActivityOrganDetail.this, BackgroundService.class);
            startService(svc); //OR stopService(svc);
        }else {
            imgBtnSoundOn.setVisibility(View.INVISIBLE);
            imgBtnSoundOff.setVisibility(View.VISIBLE);
            mp.setVolume(0,0);
            mp_click.setVolume(0,0);
            Intent svc=new Intent(ActivityOrganDetail.this, BackgroundService.class);
            stopService(svc); //OR stopService(svc);
        }
        Intent intent = getIntent();
        int id = intent.getIntExtra("key",0);
        txtNamaOrgan.setText(judulOrgan[id]);
        txtPenjelasanOrgan.setText(penjelasanOrgan[id]);

        if (id==6||id==1||id==2||id==3||id==7){
            Glide.with(this)
                    .asGif()
                    .load(gambarOrgan[id])
                    .into(imgGambarOrgan);
        }else {
            imgGambarOrgan.setImageResource(gambarOrgan[id]);
        }


             mp = MediaPlayer.create(ActivityOrganDetail.this, id_music[id]);
            mp.start();


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
                Intent svc=new Intent(ActivityOrganDetail.this, BackgroundService.class);
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
                Intent svc=new Intent(ActivityOrganDetail.this, BackgroundService.class);
                startService(svc); //OR stopService(svc);
                editor.putInt("suara", 1);
                editor.apply(); // commit changes
            }
        });




    }
}