package com.example.basic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.zip.Inflater;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<ListView> listview;
    private Context context;

    public MyAdapter(List<ListView> listview, Context context) {
        this.listview = listview;
        this.context = context;
    }

    @NonNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
               .inflate(R.layout.cardview,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.ViewHolder holder, int position) {

        ListView li = listview.get(position);
        holder.txthead.setText(li.getHead());
        holder.txtdesc.setText(li.getDesc());
    }

    @Override
    public int getItemCount() {
        return listview.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView txthead , txtdesc;

        public ViewHolder(View itemView){
            super(itemView);

            txthead = itemView.findViewById(R.id.heading);
            txtdesc = itemView.findViewById(R.id.description);
        }


    }
}
