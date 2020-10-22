package com.soobineey.androidexample.chap06_p356_service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import androidx.annotation.Nullable;

public class MyService extends Service  {
  private static final String TAG = "MyService";

  // 서비스 첫 실행시 onCraete부터 실행한다.
  @Override
  public void onCreate() {
    super.onCreate();
    Log.d(TAG, "onCreate() 호출됨");
  }

  // 서비스가 메모리에 올라가고 난뒤에 호출 시 onStartCommand부터 실행이 된다.
  @Override
  public int onStartCommand(Intent intent, int flags, int startId) {
    Log.d(TAG, "onStartCommand() 호출됨");

    if (intent == null) {
      // 인텐트가 null이면 서비스 재시작
      return Service.START_STICKY;
    } else {
      // null이 아니면 하기 메소드 실행
      processCommand(intent);
    }
    return super.onStartCommand(intent, flags, startId);
  }

  // 메인 액티비티에서 넘어온 인텐트 정보를 가공하여 보여준다.
  private void processCommand(Intent intent) {
    String command = intent.getStringExtra("command");
    String name = intent.getStringExtra("name");

    Log.d(TAG, "command : " + command + ", name : " + name);

    for (int i = 0; i < 5; i++) {
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      Log.d(TAG, "Waiting " + i + "seconds.");
    }

    // 메인 액티비티로 정보를 되돌려 준다. 돌려줄 시 새로운 태스크 생성, 같은 액티비티가 상위에 있으면 제거 한다.
    Intent showIntent = new Intent(getApplicationContext(), ServiceMainActivity.class);
    showIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
    showIntent.putExtra("command", "show");
    showIntent.putExtra("name", name + "from service.");
    startActivity(showIntent);
  }

  @Nullable
  @Override
  public IBinder onBind(Intent intent) {
    return null;
  }
}