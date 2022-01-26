package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Screen2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen2);

        TextView result = findViewById(R.id.result);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String value = extras.getString("sum");

            result.setText(value);
            //The key argument here must match that used in the other activity
        }
    }
}