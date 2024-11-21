package com.example.retrofit.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofit.R;
import com.example.retrofit.models.Distributor;

import java.util.List;

public class DistributorAdapter extends RecyclerView.Adapter<DistributorAdapter.DistributorViewHolder> {

    private List<Distributor> distributorList;
    private Context context;
    public DistributorAdapter(List<Distributor> distributorList, Context context) {
        this.distributorList = distributorList;
        this.context = context;
    }

    @NonNull
    @Override
    public DistributorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DistributorViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_item, parent, false));
    }
    @Override
    public void onBindViewHolder(@NonNull DistributorViewHolder holder, int position) {
        Distributor distributor=distributorList.get(position);
        if (distributor!=null){
            holder.tvId.setText("Id: "+distributor.getId());
            holder.tvName.setText("Name: "+distributor.getName());
            holder.tvCreatedAt.setText("CreatedAt: "+distributor.getCreatedAt());
            holder.tvUpdatedAt.setText("UpdatedAt: "+distributor.getUpdatedAt());
        }
    }

    @Override
    public int getItemCount() {
        if (distributorList!=null){
            return distributorList.size();
        }
        return 0;
    }

    class DistributorViewHolder extends RecyclerView.ViewHolder {
        TextView tvId, tvName,tvCreatedAt,tvUpdatedAt;

        public DistributorViewHolder(@NonNull View itemView) {
            super(itemView);
            tvId = itemView.findViewById(R.id.tvId);
            tvName = itemView.findViewById(R.id.tvName);
            tvCreatedAt = itemView.findViewById(R.id.tvCreatedAt);
            tvUpdatedAt = itemView.findViewById(R.id.tvUpdatedAt);
        }
    }
}
