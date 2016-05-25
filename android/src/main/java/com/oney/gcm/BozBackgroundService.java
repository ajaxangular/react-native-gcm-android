package com.oney.gcm;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import io.neson.react.notification.NotificationAttributes;
import android.os.Bundle;
import io.neson.react.notification.Notification;

public class BozBackgroundService extends Service {
    private static final String TAG = "BozBackgroundService";

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand");

        Bundle bundle = intent.getBundleExtra("bundle");
        String body = bundle.getString("message", "You have a notification");
        String subject = bundle.getString("subject", "Bozapp");

        NotificationAttributes attributes = new NotificationAttributes();
        attributes.delayed = false;
        attributes.scheduled = false;
        attributes.autoClear = true;
        attributes.inboxStyle = false;
        attributes.priority = 2;
        attributes.sound = "default";
        attributes.smallIcon = "ic_launcher";
        attributes.message = body;
        attributes.subject = subject;
        Notification notification = new Notification(this, 1, attributes);
        notification.create();

        return START_NOT_STICKY;
    }

}
