package com.example.miniproject3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdaptor extends RecyclerView.Adapter<MyAdaptor.ViewHolder> {

    Context context;
    ArrayList<ItemsContent> arrayList;

    public MyAdaptor(Context context, ArrayList<ItemsContent> arrayList) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View View = layoutInflater.inflate(R.layout.rv_item, parent, false);

        return new ViewHolder(View);

    }

    @Override
    public void onBindViewHolder(@NonNull MyAdaptor.ViewHolder holder, int position) {

        holder.tvProjectName.setText(arrayList.get(position).getProjectName());
        holder.tvRemainderTime.setText(arrayList.get(position).getRemainderTime());
        holder.progressBar.setProgress(arrayList.get(position).getProgress());
        holder.tvPercent.setText(String.valueOf(arrayList.get(position).getProgress() + "%"));


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        TextView tvPercent;
       TextView tvProjectName;
       TextView tvRemainderTime;
       ProgressBar progressBar;

        public ViewHolder(View itemView) {
            super(itemView);

            tvProjectName = itemView.findViewById(R.id.rv_project_name);
            tvRemainderTime = itemView.findViewById(R.id.tv_remainder_time);
            progressBar=itemView.findViewById(R.id.progress_bar);
            tvPercent=itemView.findViewById(R.id.percent_tv);


        }
    }
}
