package com.example.custom_notificationlab9_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RemoteViews;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    String CHANNEL_ID="android";
    String CHANNEL_NAME="android";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //showNotifocation();
    }
    public void showNotifocation()
    {
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        RemoteViews remoteView = new RemoteViews(getPackageName(), R.layout.custom_notification);

        Intent intent = new Intent(this,MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent,0);

        NotificationCompat.Action action1 = new NotificationCompat.Action(R.drawable.ic_launcher_background,"ALL CATEGORIES",pendingIntent);
        NotificationCompat.Action action2 = new NotificationCompat.Action(R.drawable.ic_launcher_background,"DONE",pendingIntent);


        Notification builder = new NotificationCompat.Builder(this,CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setStyle(new NotificationCompat.DecoratedCustomViewStyle())
                .setCustomContentView(remoteView)
                .addAction(action1)
                .addAction(action2)
                .build();

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel =
                    new NotificationChannel(CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT);
            manager.createNotificationChannel(notificationChannel);
        }

        //Step 4 - Notify the user, using the notification manager
        manager.notify(1234, builder);
    }

    public void clickMe(View view)
    {
        showNotifocation();
    }
}