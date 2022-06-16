package com.pillgood.drholmes.info.disease;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pillgood.drholmes.R;

import java.util.ArrayList;

public class diseaseAdapter extends RecyclerView.Adapter<diseaseAdapter.ViewHolder>{

    private ArrayList<disease> items = new ArrayList<>();
    private diseaseAdapter.OnPharmacyItemClickListener itemClickListener;

    public interface OnPharmacyItemClickListener {
        void onItemClick(View view, int position);
    }

    public void setOnItemClickListener(diseaseAdapter.OnPharmacyItemClickListener listener) {
        this.itemClickListener = listener;
    }

    @NonNull
    @Override
    public diseaseAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.disease_list_item, parent, false);
        diseaseAdapter.ViewHolder viewHolder = new diseaseAdapter.ViewHolder(itemView);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = viewHolder.getAdapterPosition();
                if (itemClickListener != null) {
                    itemClickListener.onItemClick(view, position);
                }
            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull diseaseAdapter.ViewHolder holder, int position) {
        disease item = items.get(position);
        holder.setItem(item);

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void addItem(disease item) {
        items.add(item);
    }

    public void setItems(ArrayList<disease> items) {
        this.items = items;
    }

    public disease getItem(int position) {
        return  items.get(position);
    }

    public void setItem(int position, disease item) {
        items.set(position, item);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvPillName;
        private ImageView tvPillIcon;
        private TextView tvPillDesc;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvPillName = itemView.findViewById(R.id.disease_name);
        }

        public void setItem(disease item) {
//            tvPillName.setText(item.getName());
//            tvPillDesc.setText(item.getDesc());
            //tvPillIcon.setImage(item.getIcon());
        }
    }
}

