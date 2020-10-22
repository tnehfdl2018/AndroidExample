package com.soobineey.androidexample.chap06_p363_broadcasting;

import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.pedro.library.AutoPermissions;
import com.pedro.library.AutoPermissionsListener;
import com.soobineey.androidexample.R;

public class BroadcastingMainActivity extends AppCompatActivity implements AutoPermissionsListener {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_broadcasting_main);

    AutoPermissions.Companion.loadAllPermissions(this, 101);
  }

  @Override
  public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
    super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    AutoPermissions.Companion.parsePermissions(this, requestCode, permissions, this);
  }

  @Override
  public void onDenied(int i, String[] strings) {
    Toast.makeText(getApplicationContext(), "permissions denied : " + strings.length, Toast.LENGTH_SHORT).show();

  }

  @Override
  public void onGranted(int i, String[] strings) {
    Toast.makeText(getApplicationContext(), "permissions granted : " + strings.length, Toast.LENGTH_SHORT).show();

  }
}
