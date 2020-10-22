package com.soobineey.androidexample.chap06_p363_broadcasting;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.soobineey.androidexample.R;

public class SmsActivity extends AppCompatActivity {

  private EditText sentNum;
  private EditText receiveContents;
  private EditText receiveTime;
  private Button button;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_sms);

    sentNum = findViewById(R.id.sent_num);
    receiveContents = findViewById(R.id.receive_contents);
    receiveTime = findViewById(R.id.receive_time);
    button = findViewById(R.id.button);

    button.setOnClickListener(forFinish);

    Intent passedIntent = getIntent();
    processIntent(passedIntent);
  }

  @Override
  protected void onNewIntent(Intent intent) {
    processIntent(intent);
    super.onNewIntent(intent);
  }

  private void processIntent(Intent intent) {
    if (intent != null) {
      String sender = intent.getStringExtra("sender");
      String contents = intent.getStringExtra("contents");
      String receivedDate = intent.getStringExtra("receivedDate");

      sentNum.setText(sender);
      receiveContents.setText(contents);
      receiveTime.setText(receivedDate);
    }
  }

  public View.OnClickListener forFinish = new View.OnClickListener() {
    @Override
    public void onClick(View view) {

      finish();

    }
  };
}