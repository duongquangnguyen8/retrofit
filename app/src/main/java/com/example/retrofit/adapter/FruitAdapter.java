package com.example.retrofit.adapter;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofit.R;
import com.example.retrofit.models.Distributor;
import com.example.retrofit.models.Fruit;

import java.util.List;

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.FruitViewHolder> {

    private List<Fruit> fruitList;
    private Context context;
    public FruitAdapter(List<Fruit> fruitList, Context context) {
        this.fruitList = fruitList;
        this.context = context;
    }

    @NonNull
    @Override
    public FruitViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FruitViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_item_fruit, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull FruitViewHolder holder, int position) {
        Fruit fruit=fruitList.get(position);
        Distributor distributor=fruit.getDistributor();
        if (fruit!=null) {
            holder.tvId.setText("Id: " + fruit.getId());
            holder.tvName.setText("Name: " + fruit.getName());
            holder.tvQuantity.setText("Quantity: " + fruit.getQuantity());
            holder.tvPrice.setText("Price: " + fruit.getPrice());
            holder.tvStatus.setText("Status: " + fruit.getStatus());
            holder.tvImage.setText("Image: " + fruit.getImage());
            holder.tvDescription.setText("Description: " + fruit.getDescription());
            holder.tvCreatedAt.setText("CreatedAt: " + fruit.getCreatedAt());
            holder.tvUpdatedAt.setText("UpdatedAt: " + fruit.getUpdatedAt());
            if (distributor.getName()!=null){
                holder.tvNameDistributor.setText("Name: " + distributor.getName());
            }else{
                holder.tvNameDistributor.setText("Name: null");
            }
            holder.tvIdDistributor.setText("Id: " + distributor.getId());
            holder.tvCreatedAtDistributor.setText("CreatedAt: " + distributor.getCreatedAt());
            holder.tvUpdatedAtDistributor.setText("UpdatedAt: " + distributor.getUpdatedAt());
        }
    }

    @Override
    public int getItemCount() {
        if (fruitList!=null){
            return fruitList.size();
        }
        return 0;
    }

    public class FruitViewHolder extends RecyclerView.ViewHolder {

        TextView tvId, tvName,tvQuantity,tvPrice,tvStatus,tvImage,tvDescription,tvCreatedAt,tvUpdatedAt;
        TextView tvNameDistributor,tvCreatedAtDistributor,tvUpdatedAtDistributor,tvIdDistributor;
        public FruitViewHolder(@NonNull View itemView) {
            super(itemView);
            tvId = itemView.findViewById(R.id.tvId_fruit);
            tvName = itemView.findViewById(R.id.tvName_fruit);
            tvQuantity = itemView.findViewById(R.id.tvQuantity_fruit);
            tvPrice = itemView.findViewById(R.id.tvPrice_fruit);
            tvImage=itemView.findViewById(R.id.tvImage_fruit);
            tvDescription=itemView.findViewById(R.id.tvDescription_fruit);
            tvNameDistributor=itemView.findViewById(R.id.tvName_distributo);
            tvIdDistributor=itemView.findViewById(R.id.tvId_distributo);
            tvCreatedAtDistributor=itemView.findViewById(R.id.tvCreatedAt_distributo);
            tvUpdatedAtDistributor=itemView.findViewById(R.id.tvUpdatedAt_distributo);
            tvStatus=itemView.findViewById(R.id.tvStatus_fruit);
            tvCreatedAt=itemView.findViewById(R.id.tvCreatedAt_fruit);
            tvUpdatedAt=itemView.findViewById(R.id.tvUpdatedAt_fruit);
        }
    }
}
