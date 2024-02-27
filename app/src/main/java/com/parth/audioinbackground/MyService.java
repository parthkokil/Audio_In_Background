package com.parth.audioinbackground;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyService extends Service {

    MediaPlayer mediaPlayer;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        Toast.makeText(this,"Service Created Successfully",Toast.LENGTH_SHORT).show();

        mediaPlayer = MediaPlayer.create(this,R.raw.music);  // We have to create a directory in resouces with name of "raw" to put audio file

        mediaPlayer.start();

        mediaPlayer.setLooping(false);
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);

        Toast.makeText(this,"Service Started Playing Song..",Toast.LENGTH_SHORT).show();

        mediaPlayer.start();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        Toast.makeText(this,"Service Stopped",Toast.LENGTH_SHORT).show();

        mediaPlayer.stop();
    }
}
