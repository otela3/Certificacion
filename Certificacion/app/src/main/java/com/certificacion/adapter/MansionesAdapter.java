package com.certificacion.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.certificacion.R;
import com.certificacion.databinding.ItemListBinding;
import com.certificacion.model.Mansion;
import com.certificacion.viewmodel.MansionViewModel;


import java.util.ArrayList;

public class MansionesAdapter extends RecyclerView.Adapter<MansionesAdapter.MansionViewHolder> {
    private Context mContext;
    private ArrayList<Mansion> mList;
    private ItemListBinding binding;
    LayoutInflater inflater;


    public MansionesAdapter(Context mContext, ArrayList<Mansion> mList) {
        this.mContext = mContext;
        this.mList = mList;
        inflater = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public MansionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = ItemListBinding.inflate(inflater,parent,false);
        return new MansionViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MansionViewHolder holder,int position){
        holder.itemListBinding.MansionName.setText(mList.get(position).getName());
        Glide.with(mContext).load(mList.get(position).getPhoto())
                .into(holder.itemListBinding.MansionImage);
    }

    @Override
    public int getItemCount() {
        return mList == null? 0 : mList.size();
    }

    public class MansionViewHolder extends RecyclerView.ViewHolder {
        private ItemListBinding itemListBinding;


        public MansionViewHolder(ItemListBinding itemListBinding){
            super(itemListBinding.getRoot());
            this.itemListBinding = itemListBinding;
     }
    }
}
