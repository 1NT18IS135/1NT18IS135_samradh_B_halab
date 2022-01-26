package com.example.sqldatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText studName = findViewById(R.id.name);
        EditText studUsn = findViewById(R.id.usn);
        EditText studSem = findViewById(R.id.semester);
        EditText studMarks = findViewById(R.id.marks);

        Button submitBtn = findViewById(R.id.submit);

        DatabaseHelper dbh = new DatabaseHelper(getApplicationContext());

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Student stud = new Student(studName.getText().toString(),
                        studUsn.getText().toString(),
                        Integer.parseInt(studSem.getText().toString()),
                        Integer.parseInt(studMarks.getText().toString())
                );

                if (dbh.InsertStudent(stud)) {
                    Toast.makeText(getApplicationContext(), "Record inserted successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Record not inserted", Toast.LENGTH_SHORT).show();
                }

                studName.setText("");
                studUsn.setText("");
                studSem.setText("");
                studMarks.setText("");
            }
        });
    }
}