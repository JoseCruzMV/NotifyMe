package com.example.notifyme;

import androidx.appcompat.app.AppCompatActivity;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static final String PRIMARY_CHANNEL_ID =
            "primary_notification_channel";
    private Button button_notify;
    private NotificationManager mNotificationManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_notify = findViewById(R.id.notify);
        button_notify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendNotification();
            }
        });
    }

    public void sendNotification() {

    }

    public void createNotificationChannel() {
        mNotificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel( PRIMARY_CHANNEL_ID,
                    "Mascot Notification", NotificationManager.IMPORTANCE_HIGH);

            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(Color.RED);
            notificationChannel.enableVibration(true);
            notificationChannel.setDescription("Notification from Mascot");
            mNotificationManager.createNotificationChannel(notificationChannel);

        }
    }
}