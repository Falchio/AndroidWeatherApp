package ru.skillsnet.falchio.receiver;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;

import androidx.core.app.NotificationCompat;

import ru.skillsnet.MyApplication;
import ru.skillsnet.falchio.R;

public class ConnectReceiver extends BroadcastReceiver {
    private int messageId = 1000;

    @Override
    public void onReceive(Context context, Intent intent) {
        String s = NetworkUtil.getConnectivityStatusString(context);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "2")
                .setSmallIcon(R.mipmap.sun_round)
                .setContentTitle(context.getString(R.string.attention))
                .setContentText(s);

        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(messageId++, builder.build());
    }
}
