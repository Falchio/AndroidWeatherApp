package ru.skillsnet.falchio.receiver;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Build;

import androidx.core.app.NotificationCompat;

import ru.skillsnet.MyApplication;
import ru.skillsnet.falchio.R;

public class ConnectReceiver extends BroadcastReceiver {
    private static final String CHANNEL_ID ="channel id" ;
    private int messageId = 1000;

    @Override
    public void onReceive(Context context, Intent intent) {
        String s = NetworkUtil.getConnectivityStatusString(context);

        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Channel name";
            String description = "description";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            notificationManager.createNotificationChannel(channel);
        }

            NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "2")
                    .setSmallIcon(R.mipmap.sun_round)
                    .setContentTitle(context.getString(R.string.attention))
                    .setContentText(s);
            notificationManager.notify(messageId++, builder.build());
    }
}
