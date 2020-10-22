package com.soobineey.androidexample.chap06_p393_doitmission12;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class DataReceiver extends BroadcastReceiver {
  private static final String TAG = "DataReceiver";
  @Override
  public void onReceive(Context context, Intent intent) {

    Log.e(TAG, "브로드캐스트 수신");

    if (intent != null) {
      String data = intent.getStringExtra("data");
      Intent sendIntent = new Intent(context, ServiceToBroadcastingMainActivity.class);
      sendIntent.putExtra("data", data);
      context.startActivity(sendIntent);
      Log.e(TAG, "브로드캐스트 송신");
    }
  }
}
