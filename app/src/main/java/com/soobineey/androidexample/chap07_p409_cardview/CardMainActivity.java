package com.soobineey.androidexample.chap07_p409_cardview;

import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.soobineey.androidexample.R;

public class CardMainActivity extends AppCompatActivity {

  private Button button1;
  private Button button2;
  private CardLayout layout;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_card_main);

    layout = findViewById(R.id.layout1);

    layout.setImage(R.drawable.ic_launcher_background);

    layout.setName("김민수");
    layout.setMobile("010-0000-0000");

    button1 = findViewById(R.id.button1);
    button2 = findViewById(R.id.button2);

    button1.setOnClickListener(changeImg);
    button2.setOnClickListener(changeImg);
  }

  public View.OnClickListener changeImg = new View.OnClickListener() {
    @Override
    public void onClick(View view) {
      switch (view.getId()) {
        case R.id.button1:
          layout.setImage(R.drawable.ic_launcher_foreground);
          break;
        case R.id.button2:
          layout.setImage(R.drawable.ic_launcher_background);
          break;
      }
    }
  };
}