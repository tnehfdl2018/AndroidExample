package com.soobineey.androidexample.chap06_p356_service;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.soobineey.androidexample.R;

public class ServiceMainActivity extends AppCompatActivity {
  private EditText editText;
  private Button button;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_service_main);
    editText = findViewById(R.id.edit_text);
    button = findViewById(R.id.button);

    button.setOnClickListener(toService);

    Intent passedIntent = getIntent();
    processIntent(passedIntent);
  }

  // 메모리에 메인액티비티가 이미 생성이 되어 있으므로 MyService에서 인텐트 객체 전달시
  // onNewIntent 실행
  @Override
  protected void onNewIntent(Intent intent) {
    processIntent(intent);
    super.onNewIntent(intent);
  }

  // 넘어온 데이터를 Toast메시지로 보여준다.
  private void processIntent(Intent intent) {
    if (intent != null) {
      String command = intent.getStringExtra("command");
      String name = intent.getStringExtra("name");

      Toast.makeText(getApplicationContext(), "command : " + command + ", name : " + name, Toast.LENGTH_SHORT).show();
    }
  }

  public View.OnClickListener toService = new View.OnClickListener() {
    @Override
    public void onClick(View v) {
      String name = editText.getText().toString();

      // 버튼 클릭시 이름을 담아 서비스로 보낸다.
      Intent intent = new Intent(getApplicationContext(), MyService.class);
      intent.putExtra("command", "show");
      intent.putExtra("name", name);
      startService(intent);
    }
  };
}