package com.soobineey.androidexample.chap06_p392_doitmission11;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import androidx.annotation.Nullable;

public class PassingService extends Service {

  private static final String TAG = "PassingService";

  public PassingService(){}

  @Override
  public int onStartCommand(Intent intent, int flags, int startId) {
    Log.e(TAG, "서비스 데이터 수신");

    if (intent == null) {
      return Service.START_STICKY;
    } else {
      String receivedData = intent.getStringExtra("data");

      Log.e(TAG, receivedData);

      Intent returnData = new Intent(getApplicationContext(), ServiceApplicationMainActivity.class);
      returnData.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
      returnData.putExtra("data", receivedData);
      startActivity(returnData);
      Log.e(TAG, "서비스 데이터 송신");
    }
    return super.onStartCommand(intent, flags, startId);
  }

  @Nullable
  @Override
  public IBinder onBind(Intent intent) {
    return null;
  }
}
