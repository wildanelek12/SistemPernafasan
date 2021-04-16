package com.codesid.sistempernafasan;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import butterknife.BindView;

public class GangguanActivity extends AppCompatActivity {

    @BindView(R.id.btnBackGangguan)
    ImageView btnBackGangguan;
    @BindView(R.id.txtGangguan)
    TextView txtGangguan;
    @BindView(R.id.imgGangguan)
    ImageView imgGangguan;
    @BindView(R.id.txtJudulGangguan)
    TextView judulGangguan;

    String penjelasanOrgan[]={
            "Penyakit yang disebabkan oleh infeksi Influenza virus. Gejala umum influenza yaitu, demam dengan suhu lebih dari 39o C, pilek, bersin-bersin, batuk, sakit kepala, sakit otot, dan rongga hidung terasa gatal. Dengan kondisi hidung tersumbat, penderita influenza akan kesulitan untuk bernapas. \n" +
                    "\n" +
                    "Agar kamu tidak mudah tertular virus influenza, sebaiknya kamu selalu menggunakan masker ketika berkendaraan dan rajin mencuci tangan dengan menggunakan sabun sebelum makan.\n",

            "Secara normal, tonsil (amandel) akan menyaring virus dan bakteri yang akan masuk ke dalam tubuh. Apabila daya tahan tubuh lemah, virus dan bakteri akan menginfeksi tonsil sehingga dapat menyebabkan penyakit tonsilitis. Virus yang dapat menyebabkan tonsilitis yaitu Adenovirus, Rhinovirus, Influenza, dan Corona virus. Golongan bakteri yang menyebabkan tonsilitis pada umumnya bakteri Streptococcus.\n" +
                    " \n" +
                    "Gejala tonsilitis yaitu sakit tenggorokan, tonsil mengalami peradangan, batuk, sakit kepala, sakit pada bagian leher atau telinga, dan demam. \n",

            "Faringitis adalah infeksi  yang terjadi pada faring karena virus, bakteri, jamur, dan zat kimia. Virus yang dapat menyebabkan faringitis misalnya, Adenovirus, Orthomyxovirus, Rhinovirus, dan Coronavirus. Salah satu bakteri yang dapat menginfeksi faring yaitu Streptococcus pyogenes. \n" +
                    " \n" +
                    "Penanganan faringitis yaitu dengan memberi antibiotik dan anti-fungi untuk membunuh bakteri serta jamur yang menginfeksi faring.\n",

            "Pneumonia merupakan infeksi  yang terjadi pada bronkiolus dan alveolus oleh virus, bakteri, jamur, dan parasit lainnya . Pada umumnya , pneumonia disebabkan oleh bakteri Streptococcus pneumoniae. Pada paru-paru penderita pneumonia, terdapat cairan kental yang dapat mengganggu pertukaran gas pada paru-paru. \n" +
                    "\n" +
                    "Gejala dari penyakit pneumonia yaitu demam, batuk berdahak, tidak enak badan, sakit pada bagian dada, dan terkadang mengalami kesulitan bernapas. Penanganan pneumonia dilakukan dengan memberikan antibiotik, bronkodilator, terapi oksigen, dan penyedotan cairan dalam paru-paru.\n",

            "Penyakit TBC disebabkan oleh infeksi bakteri Mycobacterium tuberculosis. Gejala dari penyakit TBC yaitu mudah lelah, berat badan turun drastis, lesu, hilang nafsu makan, demam, berkeringat di malam hari, sulit bernapas, sakit pada bagian dada, dan batuk berdarah.\n",

            "Asma merupakan salah satu kelainan yang menyerang saluran pernapasan. Asma dapat disebabkan oleh faktor lingkungan atau masuknya zat pemicu alergi (alergen) dalam tubuh, misalnya asap rokok, debu, bulu hewan peliharaan, dan lain-lain. Masuknya alergen akan memicu tubuh untuk menghasilkan senyawa kimia seperti prostaglandin dan histamin yang dapat memicu penyempitan saluran pernapasan.\n" +
                    " \n" +
                    "Penyempitan yang terjadi pada saluran pernapasan menyebabkan penderita kesulitan untuk menghirup cukup oksigen. Penderita asma akan mengalami batuk, napas berbunyi, napas pendek, dan sesak napas. \n",

            "Kanker paru-paru terjadi karena pertumbuhan sel-sel yang tidak terkendali pada jaringan dalam paru-paru. Jika sel-sel tersebut tidak segera ditangani, dapat menyebar ke seluruh paru-paru bahkan jaringan di sekitar paru-paru. \n" +
                    " \n" +
                    "Gejala orang yang menderita kanker paru-paru yaitu batuk disertai darah, berat badan berkurang drastis, napas menjadi pendek, dan sakit pada bagian dada. Sekitar 85% kasus kanker paru-paru disebabkan oleh merokok dalam jangka waktu yang lama, sedangkan 10-15% kasus terjadi pada orang yang tidak pernah merokok. \n"
    };


    String judulOrgan []={
            "Influenza  ","Tonsilitis","Faringitis","Pneumonia","Tuberculosis","Asma","Kanker Paru-Paru"
    };

    int gambarOrgan [] ={
            R.drawable.gangguan1,R.drawable.gangguan2,R.drawable.gangguan3,R.drawable.gangguan4,R.drawable.gangguan5,R.drawable.gangguan6,R.drawable.gangguan7
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gangguan);

        btnBackGangguan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}