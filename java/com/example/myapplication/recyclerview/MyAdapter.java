package com.example.myapplication.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.List;

class MyAdapter extends RecyclerView.Adapter<MyAdapter.myViewHolder>{


  List<Model> dataItems;


  public MyAdapter(List<Model> dataItems) {
    this.dataItems = dataItems;
  }

  @NonNull
  @Override
  public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view =  LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_layout,parent,false);
    return new myViewHolder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
    Model model = dataItems.get(position);
    holder.Name.setText(model.getName());
    holder.Gender.setText(model.getGender());
    holder.City.setText(model.getCity());
  }

  @Override
  public int getItemCount() {
    return dataItems.size();
  }

  class myViewHolder extends RecyclerView.ViewHolder{

    TextView Name,Gender,City;

    public myViewHolder(@NonNull View itemView) {
      super(itemView);
      Name=itemView.findViewById(R.id.textView);
      Gender=itemView.findViewById(R.id.textView2);
      City=itemView.findViewById(R.id.textView3);
    }
  }
}

