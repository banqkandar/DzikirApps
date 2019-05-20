package com.app.bangkandar;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView dzikir;
    int zikir = 0;
    Vibrator vibe;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dzikir = (TextView) findViewById(R.id.dzikir);
        vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        FloatingActionButton myFab = (FloatingActionButton) findViewById(R.id.reset);
        myFab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mediaPlayer.stop();
                zikir = 0;
                tampil(zikir);
            }
        });
    }

    public void subhanallah(View view) {
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.tasbih);
        mediaPlayer.start();
        zikir = zikir + 1;
        tampil(zikir);
        vibe.vibrate(50);
    }

    public void alhamdulillah(View view) {
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.tahmid);
        mediaPlayer.start();
        zikir = zikir + 1;
        tampil(zikir);
        vibe.vibrate(50);
    }

    public void lailahaillallah(View view) {
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.tahlil);
        mediaPlayer.start();
        zikir = zikir + 1;
        tampil(zikir);
        vibe.vibrate(50);
    }

    public void allahuakbar(View view) {
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.takbir);
        mediaPlayer.start();
        zikir = zikir + 1;
        tampil(zikir);
        vibe.vibrate(50);
    }

    public void tampil(int z) {
        dzikir.setText("" + z + "x");
    }
}