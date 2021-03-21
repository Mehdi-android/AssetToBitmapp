package com.clevertap.android.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.clevertap.android.R;

public class DrawableList extends RecyclerView.Adapter {
    Context context;
    String[] filelistInSubfolder;
    View.OnClickListener onClickListener;

    public DrawableList(Context context, String[] filelistInSubfolder, View.OnClickListener onClickListener) {
        this.context = context;
        this.filelistInSubfolder = filelistInSubfolder;
        this.onClickListener = onClickListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_drawables, parent, false);
        // set the view's size, margins, paddings and layout parameters
        MyViewHolder vh = new MyViewHolder(v); // pass the view to View Holder


        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MyViewHolder viewholder = (MyViewHolder) holder;
        viewholder.tv_img.setText(filelistInSubfolder[position]);
        viewholder.tv_img.setOnClickListener(onClickListener);
        viewholder.tv_img.setTag(position);

    }

    @Override
    public int getItemCount() {
        return filelistInSubfolder.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        // init the item view's
        TextView tv_img;

        public MyViewHolder(View itemView) {
            super(itemView);
            // get the reference of item view's
            tv_img = (TextView) itemView.findViewById(R.id.tv_img);


        }

    }

}
