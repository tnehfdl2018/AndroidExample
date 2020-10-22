package com.soobineey.androidexample.chap07_p440_doitmission13;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.soobineey.androidexample.R;

public class AddRecyclerViewMainActivity extends AppCompatActivity {

  private EditText editName;
  private EditText editBirth;
  private EditText editPhoneNum;
  private Button addBtn;
  private RecyclerView recyclerView;
  private CustomAdapter adapter;

  private TextView cusCountData;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_add_recycler_view_main);

    recyclerView = findViewById(R.id.recycler_view);
    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
    recyclerView.setLayoutManager(linearLayoutManager);

    editName = findViewById(R.id.name);
    editBirth = findViewById(R.id.birth);
    editPhoneNum = findViewById(R.id.phone_num);
    addBtn = findViewById(R.id.add_btn);
    cusCountData = findViewById(R.id.cus_count_data);

    addBtn.setOnClickListener(addData);

    adapter = new CustomAdapter();

    adapter.addItem(new Custom("홍길동", "1992/01/01", "010-1111-2222"));
    adapter.addItem(new Custom("홍길순", "1992/02/02", "010-3333-4444"));
    int count = adapter.getItemCount();
    cusCountData.setText(count + "명");
    recyclerView.setAdapter(adapter);

  }

  public View.OnClickListener addData = new View.OnClickListener() {
    @Override
    public void onClick(View view) {
      String name = editName.getText().toString();
      String birth = editBirth.getText().toString();
      String phoneNum = editPhoneNum.getText().toString();

      adapter.addItem(new Custom(name, birth, phoneNum));

      adapter.notifyDataSetChanged();

      int count = adapter.getItemCount();
      cusCountData.setText(count + "명");



    }
  };

}