package com.hacktiv8.siklushidup;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "SIKLUS HIDUP";
    EditText komentarText;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        komentarText = findViewById(R.id.editText);

        // Inisialisasi SharedPreferences
        sharedPreferences = getSharedPreferences("siklus_hidup", Context.MODE_PRIVATE);


    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "On Start", Toast.LENGTH_SHORT);
        System.out.println(TAG + "On Start");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "On Stop", Toast.LENGTH_SHORT);
        System.out.println(TAG + "On Stop");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "On Pause", Toast.LENGTH_SHORT);
        System.out.println(TAG + "On Pause");

        // Simpan teks dari EditText ke SharedPreferences saat aplikasi dijeda
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("komentar", komentarText.getText().toString());
        editor.apply();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "On Resume", Toast.LENGTH_SHORT);
        System.out.println(TAG + "On Resume");

        // Ambil teks dari SharedPreferences dan setel di EditText saat aplikasi dilanjutkan
        String dataTersimpan = sharedPreferences.getString("komentar", "");
        komentarText.setText(dataTersimpan);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "On Destroy", Toast.LENGTH_SHORT);
        System.out.println(TAG + "On Destroy");
    }
}