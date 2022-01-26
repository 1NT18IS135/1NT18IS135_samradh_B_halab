package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText op1 = findViewById(R.id.operand1);
        EditText op2 = findViewById(R.id.operand2);

        TextView result = findViewById(R.id.sum);

        Intent it = new Intent(this, Screen2.class);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
                int a = Integer.parseInt(op1.getText().toString());
                int b = Integer.parseInt(op2.getText().toString());

                int c = a + b;

//                result.setText("Sum is: " + String.valueOf(c));
                it.putExtra("sum", "Sum is: " + String.valueOf(c));
                startActivity(it);

//                 Toast.makeText(getApplicationContext(), (String) c, Toast.LENGTH_SHORT).show();
            }
        });

    }
}