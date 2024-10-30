package com.example.belajarintent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //inisialiasi button untuk pindah ke second activity        
        AppCompatButton btn_to_sec_act = findViewById(R.id.toSecondActivity);
        //set button on click
        btn_to_sec_act.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //berikan notifikasi dengan toast
                Toast.makeText(MainActivity.this, "Berpindah ke second activity", Toast.LENGTH_SHORT).show();

                //aksi untuk berpindah acitivy dengan intent
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                intent.putExtra("message", "Ini adalah Second Acivity");
                startActivity(intent);

            }
        });

        //Sekrang running App, pada button play di atas
        //belajar intent selesai dan berhasil
    }
}