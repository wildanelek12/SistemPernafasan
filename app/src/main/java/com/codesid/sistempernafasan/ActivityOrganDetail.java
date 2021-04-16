package com.codesid.sistempernafasan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ActivityOrganDetail extends AppCompatActivity {
    @BindView(R.id.txtNamaOrgan)
    TextView txtNamaOrgan;
    @BindView(R.id.txtPenjelasanOrgan)
    TextView txtPenjelasanOrgan;
    @BindView(R.id.imgGambarOrgan)
    TextView imgGambarOrgan;

    String penjelasanOrgan[]={
            "Hidung adalah organ pernapasan yang langsung berhubungan dengan udara luar. Hidung dilengkapi dengan rambut-rambut hidung, selaput lendir, dan konka dengan penjelasan sebagai berikut."+
            "Rambut hidung berfungsi untuk menyaring partikel debu dan kotoran yang masuk bersama udara."+
            "Selaput lendir berfungsi sebagai perangkap benda asing yang terhirup, misalnya debu, virus, dan bakteri."+
            "Konka memiliki banyak kapiler darah yang berfungsi menyamakan suhu udara yang terhirup dari luar dengan suhu tubuh atau menghangatkan udara yang masuk ke paru-paru.",

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

            "Trakea adalah saluran yang menghubungkan laring dengan bronkus. Dinding trakea tersusun dari cincin-cincin tulang rawan dan selaput lendir yang terdiri atas jaringan epitelium bersilia. Fungsi silia pada dinding trakea untuk menyaring benda-benda asing yang masuk ke dalam saluran pernapasan\n",

            "Bronkus adalah bagian paling dasar dari trakea yang bercabang menjadi dua. Masing-masing bronkus memasuki paru-paru kanan dan paru-paru kiri.  Struktur bronkus hampir sama dengan trakea, tetapi lebih sempit. Bentuk tulang rawan bronkus tidak teratur, tetapi berselang-seling dengan otot polos.\n",

            "Bronkiolus merupakan cabang-cabang kecil dari bronkus. Pada ujung-ujung bronkiolus terdapat gelembung-gelembung yang sangat kecil dan berdinding tipis yang disebut alveolus (jamak = alveoli).\n",

            "Alveolus adalah bagian paru-paru yang berperan dalam pertukaran gas oksigen dan gas karbon dioksida. \n" +
                    "Dinding alveolus tersusun atas satu lapis jaringan epitel pipih untuk memudahkan molekul-molekul gas melaluinya. Dinding alveolus berbatasan dengan pembuluh kapiler darah agar gas-gas dalam alveolus dapat dengan mudah mengalami pertukaran dengan gas-gas yang ada di dalam darah. \n"
    };


    String judulOrgan []={
            "Hidung","Bronkus","Bronkiolus","Alveolus","Faring","Laring","Trakea","Paru-Paru"
    };

    int gambarOrgan [] ={
            R.drawable.organ1,R.drawable.organ2,R.drawable.organ2,R.drawable.organ2,R.drawable.organ5,R.drawable.organ1,R.drawable.organ2,R.drawable.organ8
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_organ_detail);

        ButterKnife.bind(this);





    }
}