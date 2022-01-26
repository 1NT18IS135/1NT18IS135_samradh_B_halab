package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    /*
     * Activity Lifecycle :
     * 1. On Launch : Create -> Start
     * 2. On Moving out : Pause -> Stop
     * 3. Clicking App again : Start -> Resume
     * 4. When app is removed from memory -> Destroy
     * */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //R --> Resources; loads the view onCreate activity
        setContentView(R.layout.activity_main);

        Toast.makeText(getApplicationContext(), "Creating Activity", Toast.LENGTH_SHORT).show();
    }

    public void onStart(){
        super.onStart();

        Toast.makeText(getApplicationContext(), "Starting Activity", Toast.LENGTH_SHORT).show();
    }

    public void onPause(){
        super.onPause();

        Toast.makeText(getApplicationContext(), "Pausing Activity", Toast.LENGTH_SHORT).show();
    }

    public void onStop(){
        super.onStop();

        Toast.makeText(getApplicationContext(), "Stopping Activity", Toast.LENGTH_SHORT).show();
    }

    public void onResume(){
        super.onResume();

        Toast.makeText(getApplicationContext(), "Resuming Activity", Toast.LENGTH_SHORT).show();
    }

    public void onDestroy(){
        super.onDestroy();

        Toast.makeText(getApplicationContext(), "Destroying Activity", Toast.LENGTH_SHORT).show();
    }
}