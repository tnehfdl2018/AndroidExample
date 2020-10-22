package com.soobineey.androidexample.chap07_p418_recyclerview;

import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.soobineey.androidexample.R;

public class RecyclerViewMainActivity extends AppCompatActivity {

  private PersonAdapter adapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_recycler_view_main);

    // 리사이클러 뷰 생성
    RecyclerView recyclerView = findViewById(R.id.recyclerview);

    // 리사이클러뷰 내에 아이템의 배치를 할 Layout형태를 지정한다.
//    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
//    recyclerView.setLayoutManager(linearLayoutManager);
    GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
    recyclerView.setLayoutManager(gridLayoutManager);

    // adapter 생성
    adapter = new PersonAdapter();

    adapter.addItem(new Person("김민수", "010-0000-0000"));
    adapter.addItem(new Person("김하늘", "010-1111-1111"));
    adapter.addItem(new Person("홍길동", "010-2222-2222"));
    adapter.addItem(new Person("김일번", "010-3333-3333"));
    adapter.addItem(new Person("김이번", "010-4444-4444"));
    adapter.addItem(new Person("김삼번", "010-5555-5555"));
    adapter.addItem(new Person("김사번", "010-6666-6666"));
    adapter.addItem(new Person("김오번", "010-7777-7777"));
    adapter.addItem(new Person("김육번", "010-8888-8888"));
    adapter.addItem(new Person("김칠번", "010-9999-9999"));
    adapter.addItem(new Person("최일번", "010-9999-8888"));
    adapter.addItem(new Person("최이번", "010-8888-7777"));
    adapter.addItem(new Person("최삼번", "010-7777-6666"));
    adapter.addItem(new Person("최사번", "010-6666-5555"));

    // adapter 부착
    recyclerView.setAdapter(adapter);

    adapter.setOnItemClickListener(new OnPersonItemClickListener() {
      @Override
      public void onItemClick(PersonAdapter.ViewHolder holder, View view, int position) {

        Person item = adapter.getItem(position);
        Toast.makeText(getApplicationContext(), "아이템 선택됨 : " + item.getName(), Toast.LENGTH_SHORT).show();
      }
    });
  }
}