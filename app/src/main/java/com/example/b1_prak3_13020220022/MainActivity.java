package com.example.b1_prak3_13020220022;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
             EditText txtStb;
             EditText txtNama;
             Spinner spnAkt;
             RadioGroup rgProdi;
             RadioButton rbti;
             RadioButton rbsi;
             List<String> minat;
             CheckBox cb1;
             CheckBox cb2;
             CheckBox cb3;
             CheckBox cb4;
             CheckBox cb5;
             CheckBox cb6;
             Button btnTambil;

            txtStb = findViewById(R.id.txt_edit_stb);
            txtNama = findViewById(R.id.txt_edit_nama);
            spnAkt = findViewById(R.id.spin_ang);
            rgProdi = findViewById(R.id.rg_prodi);
            rbti = findViewById(R.id.rb_ti);
            rbsi = findViewById(R.id.rb_si);
            cb1 = findViewById(R.id.cb_1);
            cb2 = findViewById(R.id.cb_2);
            cb3 = findViewById(R.id.cb_3);
            cb4 = findViewById(R.id.cb_4);
            cb5 = findViewById(R.id.cb_5);
            cb6 = findViewById(R.id.cb_6);
            btnTambil = findViewById(R.id.btn_tampil);
            minat = new ArrayList<>();

            String[] angkatan = {"Pilih Angkatan", "2022", "2021", "2020", "2019"};
            ArrayAdapter<String> angkatanAdapter = new ArrayAdapter<>(this,
                    android.R.layout.simple_spinner_item, angkatan);
            angkatanAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            spnAkt.setAdapter(angkatanAdapter);
btnTambil.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        String stambuk = txtStb.getText().toString();
        String nama = txtNama.getText().toString();
        String angkatan = spnAkt.getSelectedItem().toString();
        String programStudi = "";
        if (rbti.isChecked()) {
            programStudi = "Teknik Informatika";
        } else if (rbsi.isChecked()) {
            programStudi = "Sistem Informasi";
        }


        minat.clear();
        if (cb1.isChecked()) {
            minat.add("Badan Eksekutif Mahasiswa");
        }
        if (cb2.isChecked()) {
            minat.add("Penulisan Karya Ilmiah");
        }
        if (cb3.isChecked()) {
            minat.add("Kewirausahaan");
        }
        if (cb4.isChecked()) {
            minat.add("Kesenian");
        }
        if (cb5.isChecked()) {
            minat.add("Jurnalistik");
        }
        if (cb6.isChecked()) {
            minat.add("Olahraga");
        }

        if (angkatan.equals("Pilih Angkatan")) {
            Toast.makeText(MainActivity.this, "Mohon pilih angkatan terlebih dahulu", Toast.LENGTH_SHORT).show();
            return;
        }

        String minatStr = TextUtils.join("\n- ", minat);
        if (!minatStr.isEmpty()) {
            minatStr = "- " + minatStr;
        }

        Intent intent = new Intent(MainActivity.this, DetailActivity.class);

        Bundle bundle = new Bundle();
        bundle.putString("stambuk", stambuk);
        bundle.putString("nama", nama);
        bundle.putString("angkatan", angkatan);
        bundle.putString("programStudi", programStudi);
        bundle.putString("minat", minatStr);

        intent.putExtras(bundle);
        startActivity(intent);

    }
});
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

}