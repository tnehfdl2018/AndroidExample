package com.soobineey.androidexample;

import android.content.Intent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.soobineey.androidexample.chap06_p356_service.ServiceMainActivity;
import com.soobineey.androidexample.chap06_p363_broadcasting.BroadcastingMainActivity;
import com.soobineey.androidexample.chap06_p380_permission.PermissionMainActivity;
import com.soobineey.androidexample.chap06_p384_permission2.Permission2MainActivity;
import com.soobineey.androidexample.chap06_p392_doitmission11.ServiceApplicationMainActivity;
import com.soobineey.androidexample.chap06_p393_doitmission12.ServiceToBroadcastingMainActivity;
import com.soobineey.androidexample.chap07_p397_ninepatch.NinePatchMainActivity;
import com.soobineey.androidexample.chap07_p402_newview.MyButtonMainActivity;
import com.soobineey.androidexample.chap07_p409_cardview.CardMainActivity;
import com.soobineey.androidexample.chap07_p418_recyclerview.RecyclerViewMainActivity;
import com.soobineey.androidexample.chap07_p436_spinner.SpinnerMainActivity;
import com.soobineey.androidexample.chap07_p440_doitmission13.AddRecyclerViewMainActivity;
import com.soobineey.androidexample.chap07_p441_doitmission14.ToastRecyclerViewMainActivity;


public class MainActivity extends AppCompatActivity {

  private MainAdapter adapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    RecyclerView recyclerView = findViewById(R.id.main_recycler_view);

    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
    recyclerView.setLayoutManager(linearLayoutManager);

    adapter = new MainAdapter();
    adapter.addItem(new Item("service", "chap06-p.356", ServiceMainActivity.class));
    adapter.addItem(new Item("broadCasting", "chap06-p.363", BroadcastingMainActivity.class));
    adapter.addItem(new Item("permission", "chap06-p.380", PermissionMainActivity.class));
    adapter.addItem(new Item("permission2", "chap06-p.384", Permission2MainActivity.class));
    adapter.addItem(new Item("ninepatch", "chap07-p.397", NinePatchMainActivity.class));
    adapter.addItem(new Item("newView", "chap07-p.402", MyButtonMainActivity.class));
    adapter.addItem(new Item("cardView", "chap07-p.409", CardMainActivity.class));
    adapter.addItem(new Item("recyclerView", "chap07-p.418", RecyclerViewMainActivity.class));
    adapter.addItem(new Item("spinner", "chap07-p.436", SpinnerMainActivity.class));
    adapter.addItem(new Item("DoitMission-11", "chap06-p.392", ServiceApplicationMainActivity.class));
    adapter.addItem(new Item("DoitMission-12", "chap06-p.393", ServiceToBroadcastingMainActivity.class));
    adapter.addItem(new Item("DoitMission-13", "chap07-p.440", AddRecyclerViewMainActivity.class));
    adapter.addItem(new Item("DoitMission-14", "chap07-p.441", ToastRecyclerViewMainActivity.class));

    recyclerView.setAdapter(adapter);

    adapter.setOnItemClickListener(new OnMainItemClickListener() {
      @Override
      public void onItemClick(MainAdapter.ViewHolder holder, View view, int position) {

        Item item = adapter.getItem(position);

        Intent intent = new Intent(MainActivity.this, item.getClassName());

        startActivity(intent);


      }
    });

  }
}