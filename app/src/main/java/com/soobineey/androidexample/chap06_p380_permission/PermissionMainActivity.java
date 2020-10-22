package com.soobineey.androidexample.chap06_p380_permission;

import android.Manifest;
import android.content.pm.PackageManager;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.soobineey.androidexample.R;

import java.util.ArrayList;

public class PermissionMainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_permission_main);

    String[] permissions = {
        Manifest.permission.READ_EXTERNAL_STORAGE,
        Manifest.permission.WRITE_EXTERNAL_STORAGE
    };

    checkPermissions(permissions);

  }

  public void checkPermissions(String[] permissions) {
    ArrayList<String> targetList = new ArrayList<>();

    for (int i = 0; i < permissions.length; i++) {
      String curPermission = permissions[i];
      int permissionCheck = ContextCompat.checkSelfPermission(this, curPermission);
      if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
        Toast.makeText(getApplicationContext(), curPermission + "권한 있음", Toast.LENGTH_SHORT).show();
      } else {
        Toast.makeText(getApplicationContext(), curPermission + "권한 없음", Toast.LENGTH_SHORT).show();
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, curPermission)) {
          Toast.makeText(getApplicationContext(), curPermission + "권한 설명 필요함", Toast.LENGTH_SHORT).show();
        } else {
          targetList.add(curPermission);
        }
      }
    }
    String[] targets = new String[targetList.size()];
    targetList.toArray(targets);

    ActivityCompat.requestPermissions(this, targets, 101);
  }

  @Override
  public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
    switch (requestCode) {
      case 101:
        if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
          Toast.makeText(getApplicationContext(), "첫 번째 권한을 사용자가 승인함", Toast.LENGTH_SHORT).show();
        } else {
          Toast.makeText(getApplicationContext(), "첫 번째 권한 거부됨", Toast.LENGTH_SHORT).show();
        }
        return;
    }
  }
}