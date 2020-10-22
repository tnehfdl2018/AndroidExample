package com.soobineey.androidexample.chap07_p436_spinner;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.soobineey.androidexample.R;

public class SpinnerMainActivity extends AppCompatActivity {

  private TextView textView;
  private Spinner spinner;

  private String[] items = {"mike", "angel", "crow", "john", "ginnie", "sally", "cohen", "rice"};

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_spinner_main);

    textView = findViewById(R.id.text_view);
    spinner = findViewById(R.id.spinner);

    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, items);

    spinner.setAdapter(arrayAdapter);

    spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        textView.setText(items[i]);
      }
      @Override
      public void onNothingSelected(AdapterView<?> adapterView) {
        textView.setText("");
      }
    });
  }
}