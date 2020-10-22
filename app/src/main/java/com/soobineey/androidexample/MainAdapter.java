package com.soobineey.androidexample;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> implements OnMainItemClickListener {

  ArrayList<Item> items = new ArrayList<>();
  OnMainItemClickListener listener;

  @NonNull
  @Override
  public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    LayoutInflater inflater = LayoutInflater.from(parent.getContext());
    View itemView = inflater.inflate(R.layout.main_item, parent, false);

    return new MainAdapter.ViewHolder(itemView, this);
  }

  @Override
  public void onBindViewHolder(@NonNull MainAdapter.ViewHolder holder, int position) {
    Item item = items.get(position);
    holder.setItem(item);

  }

  @Override
  public int getItemCount() {
    return items.size();
  }

  public void addItem(Item item) {
    items.add(item);
  }

  public void setOnItemClickListener(OnMainItemClickListener listener) {
    this.listener = listener;
  }

  @Override
  public void onItemClick(MainAdapter.ViewHolder holder, View view, int position) {
    if (listener != null) {
      listener.onItemClick(holder, view, position);
    }
  }
  public Item getItem(int position) {
    return items.get(position);
  }


  public static class ViewHolder extends RecyclerView.ViewHolder {
    TextView textView;
    TextView textView2;

    public ViewHolder(View itemView, final OnMainItemClickListener listener) {
      super(itemView);

      textView = itemView.findViewById(R.id.text_view);
      textView2 = itemView.findViewById(R.id.text_view2);

      itemView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
          int position = getAdapterPosition();

          if (listener != null) {
            listener.onItemClick(ViewHolder.this, view, position);
          }
        }
      });
    }

    public void setItem(Item item) {
      textView.setText(item.getTitle());
      textView2.setText(item.getSubscript());
    }
  }
}
