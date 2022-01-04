package com.example.musicplayerlab8_3;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.IBinder;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;

import java.util.Date;

public class playerService extends Service {

    private MediaPlayer player;
    String CHANNEL_ID="android";
    String CHANNEL_NAME="android";
    int songs[];
    int songPosition=0;

    @Override
    public void onCreate() {
        super.onCreate();
        songs = new int[]{R.raw.song,R.raw.song1,R.raw.song2,R.raw.song3,R.raw.song4};
    }

    boolean isPlaying = false;
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        showNotifocation();

        player = MediaPlayer.create(getApplicationContext(),songs[songPosition]);
        player.start();
        isPlaying = true;
        Intent intent1 = new Intent(getApplicationContext(),MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(),0,intent1,0);
        NotificationCompat.Action action = new NotificationCompat.Action(R.drawable.music,"START",pendingIntent);
        Notification builder = new NotificationCompat.Builder(this,CHANNEL_ID)
                .setContentTitle(getResources().getResourceEntryName(songs[songPosition]))
                .setAutoCancel(false)
                .setContentIntent(pendingIntent)
                .setSmallIcon(R.drawable.play)
                .addAction(action).build();
        startForeground(1,builder);
    playSong();
        return START_STICKY;
    }
   public void playSong()
   {
       if(songPosition<songs.length-1){
           player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
               @Override
               public void onCompletion(MediaPlayer mp) {
                   isPlaying = false;
                   songPosition++;

                   player = MediaPlayer.create(getApplicationContext(), songs[songPosition]);
                   player.start();
                   Notification builder = new NotificationCompat.Builder(getApplicationContext(), CHANNEL_ID)
                           .setContentTitle(getResources().getResourceEntryName(songs[songPosition]))
                           .setAutoCancel(false)
                           .setSmallIcon(R.drawable.music).
                                   build();
                   startForeground(1,builder);
                   System.out.println("next playing");
                   playSong();
               }
           });
       }
       else {
           player.stop();
           stopForeground(true);
       }
        return;

   }



    public void showNotifocation()
    {
        //NotificationChannel notificationChannel = new NotificationChannel("channelid","Forground Service",NotificationManager.IMPORTANCE_DEFAULT);
        NotificationManager manager = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            manager = (NotificationManager) getSystemService(NotificationManager.class);
        }

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel =
                    new NotificationChannel(CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT);

            manager.createNotificationChannel(notificationChannel);
        }
        //Step 4 - Notify the user, using the notification manager
        //manager.notify(1234, notification);
    }


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        stopForeground(false);
    }
}
