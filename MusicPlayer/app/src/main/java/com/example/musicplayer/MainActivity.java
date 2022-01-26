package com.example.musicplayer;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.media.MediaPlayer;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SeekBar seekbar;

    double startTime = 0;
    double finalTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.song);
        Button playBtn = findViewById(R.id.play);

        Button rewindBtn = findViewById(R.id.rewind);
        Button skipBtn = findViewById(R.id.skip);
        Button resetBtn = findViewById(R.id.reset);

        seekbar = (SeekBar)findViewById(R.id.seekBar2);
//        seekbar.setClickable(false);

        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(mediaPlayer != null && fromUser){
                    mediaPlayer.seekTo(progress * 1000);
                }
            }
        });

        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Playing Song",Toast.LENGTH_LONG).show();

                finalTime = mediaPlayer.getDuration();
                startTime = mediaPlayer.getCurrentPosition();

                mediaPlayer.start();

//                seekbar.setProgress((int)startTime);
            }
        });

        Button pauseBtn=findViewById(R.id.pause);
        pauseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Pausing Song",Toast.LENGTH_LONG).show();
                mediaPlayer.pause();
            }
        });

        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.seekTo((int) 0);
            }
        });

        rewindBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double curTime = mediaPlayer.getCurrentPosition();

                if (curTime - 5000 < 0) {
                    Toast.makeText(getApplicationContext(), "Cannot rewind further", Toast.LENGTH_SHORT).show();
                } else {
                    mediaPlayer.seekTo((int) curTime - 5000);
                }
            }
        });

        skipBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double curTime = mediaPlayer.getCurrentPosition();
                double dur = mediaPlayer.getDuration();

                if (curTime + 5000 > dur) {
                    Toast.makeText(getApplicationContext(), "Cannot skip further", Toast.LENGTH_SHORT).show();
                } else {
                    mediaPlayer.seekTo((int) curTime + 5000);
                }
            }
        });

        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Toast.makeText(getApplicationContext(), "Playback Complete",Toast.LENGTH_LONG).show();
            }
        });
    }
}