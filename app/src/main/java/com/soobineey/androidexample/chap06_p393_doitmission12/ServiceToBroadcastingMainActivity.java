package com.soobineey.androidexample.chap06_p393_doitmission12;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.soobineey.androidexample.R;
import com.soobineey.androidexample.chap06_p392_doitmission11.PassingService;

public class ServiceToBroadcastingMainActivity extends AppCompatActivity {

  private EditText editText;
  private Button button;
  private TextView textView;

  private static final String TAG = "ServiceApplicationMainActivity";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_service_application_main);

    editText = findViewById(R.id.edit_text);
    button = findViewById(R.id.button);
    textView = findViewById(R.id.text_view);

    button.setOnClickListener(sendService);
  }

  public View.OnClickListener sendService = new View.OnClickListener() {
    @SuppressLint("LongLogTag")
    @Override
    public void onClick(View view) {
      String data = editText.getText().toString();

      Log.e(TAG, data);

      // 버튼 클릭시 editText의 값을 가져와 Intent에 담고 서비스로 보낸다.
      Intent intent = new Intent(getApplicationContext(), SendService.class);
      intent.putExtra("data", data);
      startService(intent);
      Log.e(TAG, "서비스로 송신");
    }
  };

  @Override
  protected void onNewIntent(Intent intent) {
    Log.e(TAG, "브로드캐스트로 부터 수신");
    // 서비스에서 돌아온  Intent가 null인지 확인하고 null이 아니라면
    // 데이터를 꺼내 TextView에 붙힌다.
    if (intent != null) {
      String rcvData = intent.getStringExtra("data");

      textView.setText(rcvData);
    }
    super.onNewIntent(intent);
  }
}