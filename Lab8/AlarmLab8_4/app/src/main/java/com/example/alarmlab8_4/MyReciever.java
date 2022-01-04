package com.example.alarmlab8_4;
import static android.content.Context.NOTIFICATION_SERVICE;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.AlarmClock;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;

import java.util.Date;

public class MyReciever extends BroadcastReceiver {
    Button btn;
    @Override
    public void onReceive(Context context, Intent intent1) {
        Toast.makeText(context.getApplicationContext(), "Alaram started", Toast.LENGTH_SHORT).show();
        NotificationManager manager = (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);

        Intent intent = new Intent(context,MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context,0,intent,0);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context,"CHANNEL_ID")
                .setContentTitle("Alarm notification")
                .setContentText(new Date().toString())
                .setAutoCancel(true)
                .setSmallIcon(R.drawable.alarm)
                .setContentIntent(pendingIntent);
        Notification notification = builder.build();

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel =
                    new NotificationChannel("CHANNEL_ID", "CHANNEL_NAME", NotificationManager.IMPORTANCE_DEFAULT);

            manager.createNotificationChannel(notificationChannel);
        }
        //Step 4 - Notify the user, using the notification manager
        manager.notify(1234, notification);

    }
}