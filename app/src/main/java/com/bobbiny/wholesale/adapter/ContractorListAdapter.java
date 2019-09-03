package com.bobbiny.wholesale.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bobbiny.wholesale.R;
import com.bobbiny.wholesale.data.local.entity.Contractor;

import java.util.List;

public class ContractorListAdapter extends RecyclerView.Adapter<ContractorListAdapter.ViewHolder> {

    private final LayoutInflater mInflater;
    private List<Contractor> mContractors;
    private RecyclerViewClickListener mItemClickListener;

    public ContractorListAdapter(Context context, RecyclerViewClickListener listener) {
        mInflater = LayoutInflater.from(context);
        mItemClickListener = listener;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView idItemView;
        private final TextView nameItemView;
        private final TextView countryItemView;
        private final ImageButton buttonItemView;

        ViewHolder(View view) {
            super(view);
            idItemView = view.findViewById(R.id.item_id);
            nameItemView = view.findViewById(R.id.item_full_name);
            countryItemView = view.findViewById(R.id.item_country);
            buttonItemView = view.findViewById(R.id.item_button);
        }
    }

    @NonNull
    @Override
    public ContractorListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.list_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ContractorListAdapter.ViewHolder holder, final int position) {
        Contractor current = mContractors.get(position);
        holder.idItemView.setText(String.valueOf(current.getId()).concat("."));
        holder.nameItemView.setText(current.getFirstName());
        holder.countryItemView.setText(current.getCountry());
        holder.buttonItemView.setOnClickListener(view -> mItemClickListener.onItemClick(position));
    }

    public void setContractors(List<Contractor> contractors) {
        mContractors = contractors;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (mContractors != null)
            return mContractors.size();
        else
            return 0;
    }
}
