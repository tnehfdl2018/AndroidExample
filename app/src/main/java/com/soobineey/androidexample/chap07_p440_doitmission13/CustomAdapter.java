package com.soobineey.androidexample.chap07_p440_doitmission13;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.soobineey.androidexample.R;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

  private ArrayList<Custom> items = new ArrayList<>();

  @NonNull
  @Override
  public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    LayoutInflater inflater = LayoutInflater.from(parent.getContext());
    View view = inflater.inflate(R.layout.custom_item, parent, false);
    return new ViewHolder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull CustomAdapter.ViewHolder holder, int position) {
    Custom item = items.get(position);
    holder.setItem(item);
  }

  @Override
  public int getItemCount() {
    return items.size();
  }

  public void addItem(Custom custom) {
    items.add(custom);
  }

  public static class ViewHolder extends RecyclerView.ViewHolder {

    TextView txName;
    TextView txBirth;
    TextView txPhoneNum;

    public ViewHolder(View itemView) {
      super(itemView);

      txName = itemView.findViewById(R.id.tx_name);
      txBirth = itemView.findViewById(R.id.tx_birth);
      txPhoneNum = itemView.findViewById(R.id.tx_phone);

    }
    public void setItem(Custom custom) {
      txName.setText(custom.getName());
      txBirth.setText(custom.getBirth());
      txPhoneNum.setText(custom.getPhoneNum());
    }
  }



}
