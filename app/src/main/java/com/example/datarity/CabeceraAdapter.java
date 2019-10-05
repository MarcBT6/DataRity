package com.example.datarity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class CabeceraAdapter extends RecyclerView.Adapter<CabeceraAdapter.MyViewHolder>{
        private ArrayList<Header> mDataset= new ArrayList<>();
        private OnClickListener onClickListener;


    // Provide a reference to the views for each data item
        // Complex data items may need more than one view per item, and
        // you provide access to all the views for a data item in a view holder
        static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            // each data item is just a string in this case
            TextView nombre;
            TextView image;
            CardView items;
            OnClickListener onClickListener;
            MyViewHolder(View v, OnClickListener onClickListener) {
                super(v);
                nombre = v.findViewById(R.id.Nombre);
                items = v.findViewById(R.id.recyclerView);
                itemView.setOnClickListener(this);
                this.onClickListener = onClickListener;
            }

        @Override
        public void onClick(View v) {
            onClickListener.onClick(getAdapterPosition());
        }
    }
        // Provide a suitable constructor (depends on the kind of dataset)
        public CabeceraAdapter(ArrayList<Header> myDataset, OnClickListener onClickListener) {
            this.onClickListener = onClickListener;
        }

        // Create new views (invoked by the layout manager)
        @Override
        public CabeceraAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                               int viewType) {
            // create a new view
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.celda_layout, parent, false);
            return new MyViewHolder(v,onClickListener);
        }

        // Replace the contents of a view (invoked by the layout manager)
        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            // - get element from your dataset at this position
            // - replace the contents of the view with that element
            holder.nombre.setText(mDataset.get(position).getNombre());
            holder.image.setText(mDataset.get(position).getImage());

        }

        // Return the size of your dataset (invoked by the layout manager)
        @Override
        public int getItemCount() {
            return mDataset.size();
        }
        public interface OnClickListener{
            void onClick(int pos);
        }
}

