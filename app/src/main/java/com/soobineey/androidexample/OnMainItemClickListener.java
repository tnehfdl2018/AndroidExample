package com.soobineey.androidexample;

import android.view.View;
import com.soobineey.androidexample.chap07_p418_recyclerview.PersonAdapter;

public interface OnMainItemClickListener {

  public void onItemClick(MainAdapter.ViewHolder holder, View view, int position);
}

