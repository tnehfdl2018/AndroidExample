package com.soobineey.androidexample.chap07_p409_cardview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.soobineey.androidexample.R;

public class CardLayout extends LinearLayout {

  private ImageView imageView;
  private TextView textView;
  private TextView textView1;

  public CardLayout(Context context) {
    super(context);
    init(context);
  }

  public CardLayout(Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
    init(context);
  }

  private void init(Context context) {
    LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    inflater.inflate(R.layout.activity_card_layout, this, true);

    imageView = findViewById(R.id.image);
    textView = findViewById(R.id.text1);
    textView1 = findViewById(R.id.text2);
  }
  public void setImage(int resId) {
    imageView.setImageResource(resId);
  }

  public void setName(String name) {
    textView.setText(name);
  }
  public void setMobile(String mobile) {
    textView1.setText(mobile);
  }
}
