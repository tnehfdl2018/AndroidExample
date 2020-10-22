package com.soobineey.androidexample.chap06_p393_doitmission12;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import androidx.annotation.Nullable;
import com.soobineey.androidexample.chap06_p392_doitmission11.ServiceApplicationMainActivity;

public class SendService extends Service {

  private static final String TAG = "SendService";

  public SendService(){}

  @Override
  public int onStartCommand(Intent intent, int flags, int startId) {
    Log.e(TAG, "서비스 수신");

    if (intent == null) {
      return Service.START_STICKY;
    } else {
      String receivedData = intent.getStringExtra("data");

      Intent returnData = new Intent("com.soobineey.androidexample.chap06_p393_doitmission12");
//      returnData.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
      returnData.putExtra("data", receivedData);
      sendBroadcast(returnData);
      Log.e(TAG, "서비스에서 브로드캐스트로 송신");
    }
    return super.onStartCommand(intent, flags, startId);
  }

  @Nullable
  @Override
  public IBinder onBind(Intent intent) {
    return null;
  }
}
