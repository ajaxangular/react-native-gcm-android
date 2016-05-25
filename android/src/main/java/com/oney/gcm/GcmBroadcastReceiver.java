package com.oney.gcm;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import android.content.Context;

public class GcmBroadcastReceiver extends BroadcastReceiver {
    private final static String TAG = GcmModule.class.getCanonicalName();

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "onReceive");

        Bundle bundle = intent.getBundleExtra("bundle");

        Intent newIntent = new Intent(context, BozBackgroundService.class);
        newIntent.putExtra("bundle", bundle);
        context.startService(newIntent);
        abortBroadcast();
    }
}
