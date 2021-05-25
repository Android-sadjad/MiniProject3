package com.example.miniproject3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdaptor extends RecyclerView.Adapter<MyAdaptor.ViewHolder> {

    Context context;

    public MyAdaptor(Context context) {

        this.context=context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater=LayoutInflater.from(context);
        View View=layoutInflater.inflate(R.layout.rv_item,parent,false);

        return new ViewHolder(View);

    }

    @Override
    public void onBindViewHolder(@NonNull MyAdaptor.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{


        TextView tvProjectName;
        TextView tvRemainderTime;

        public ViewHolder(View itemView) {
            super(itemView);

            tvProjectName=itemView.findViewById(R.id.rv_project_name);
            tvRemainderTime=itemView.findViewById(R.id.tv_remainder_time);


        }
    }
}
