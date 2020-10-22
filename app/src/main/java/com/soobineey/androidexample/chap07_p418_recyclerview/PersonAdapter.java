package com.soobineey.androidexample.chap07_p418_recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.soobineey.androidexample.R;

import java.util.ArrayList;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHolder> implements OnPersonItemClickListener {

  ArrayList<Person> items = new ArrayList<>();
  OnPersonItemClickListener listener;

  @NonNull
  @Override
  public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

    LayoutInflater inflater = LayoutInflater.from(parent.getContext());
    View itemView = inflater.inflate(R.layout.person_item, parent, false);

    return new ViewHolder(itemView, this);
  }

  @Override
  public void onBindViewHolder(@NonNull PersonAdapter.ViewHolder holder, int position) {
    Person item = items.get(position);
    holder.setItem(item);
  }

  @Override
  public int getItemCount() {
    return items.size();
  }

  public void addItem(Person person) {
    items.add(person);
  }

  public void setOnItemClickListener(OnPersonItemClickListener listener) {
    this.listener = listener;
  }

  @Override
  public void onItemClick(ViewHolder holder, View view, int position) {
    if (listener != null) {
      listener.onItemClick(holder, view, position);
    }

  }
  //
//  public void setItems(ArrayList<Person> items) {
//    this.items = items;
//  }
//
  public Person getItem(int position) {
    return items.get(position);
  }
//
//  public void setItem(int position, Person person) {
//    items.set(position, person);
//  }

  public static class ViewHolder extends RecyclerView.ViewHolder {
    TextView textView;
    TextView textView2;

    public ViewHolder(View itemView, final OnPersonItemClickListener listener) {
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
    public void setItem(Person person) {
      textView.setText(person.getName());
      textView2.setText(person.getMobile());
    }
  }
}
