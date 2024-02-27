package com.parth.audioinbackground;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

//Create an Android application that plays an audio(song) in the background. Audio will not be
//stopped even if you switch to another activity. To stop the audio, you need to stop the service.

public class MainActivity extends AppCompatActivity {

    private Button start,next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start = findViewById(R.id.startBtn);
        next = findViewById(R.id.NextActivityBtn);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startService(new Intent(MainActivity.this,MyService.class));

            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,NextActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}