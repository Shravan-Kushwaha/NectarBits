package com.example.myapplication.Practical1.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Practical1.Models.ModelClassPractical1;
import com.example.myapplication.R;

import java.util.List;

public class MyAdapterPractical1 extends RecyclerView.Adapter<MyAdapterPractical1.MyViewHolderprac1> {

    List<ModelClassPractical1> modelClassPractical1List;

    public MyAdapterPractical1(List<ModelClassPractical1> modelClassPractical1List) {
        this.modelClassPractical1List = modelClassPractical1List;
    }

    @NonNull
    @Override
    public MyViewHolderprac1 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_layout_practical1, parent, false);
        return new MyViewHolderprac1(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderprac1 holder, int position) {
        ModelClassPractical1 modelClassPractical1 = modelClassPractical1List.get(position);
        holder.textViewName.setText(modelClassPractical1.getName());
        holder.textViewAge.setText(modelClassPractical1.getAge());
        holder.textViewCompany.setText(modelClassPractical1.getCompany());
        holder.textViewCity.setText(modelClassPractical1.getCity());
    }

    @Override
    public int getItemCount() {
        return modelClassPractical1List.size();
    }

    public class MyViewHolderprac1 extends RecyclerView.ViewHolder {

        TextView textViewName, textViewAge, textViewCompany, textViewCity;

        public MyViewHolderprac1(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.tvName);
            textViewAge = itemView.findViewById(R.id.tvAge);
            textViewCompany = itemView.findViewById(R.id.tvCompany);
            textViewCity = itemView.findViewById(R.id.tvCity);
        }
    }
}
