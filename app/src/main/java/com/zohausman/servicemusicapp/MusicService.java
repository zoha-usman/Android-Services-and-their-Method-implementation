package com.zohausman.servicemusicapp;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;
import androidx.annotation.Nullable;

public class MusicService extends Service {
    MediaPlayer mediaPlayer;

//    unboundined services
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
//    always triger with start (onStartCommand)
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
//      goal is to see service is playing pr not
//       playing default muic
        mediaPlayer= MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();
        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        mediaPlayer.stop();
        super.onDestroy();
    }
}
