package com.bobbiny.wholesale.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bobbiny.wholesale.R;
import com.bobbiny.wholesale.databinding.ListItemBinding;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private ArrayList<String> strings;
    private RecyclerViewClickListener mItemClickListener;

    public RecyclerViewAdapter(RecyclerViewClickListener listener) {
        strings = new ArrayList<>();
        strings.add("1.");
        strings.add("2.");
        strings.add("3.");
        strings.add("4.");
        strings.add("5.");
        strings.add("6.");
        strings.add("7.");
        strings.add("8.");
        strings.add("9.");
        strings.add("10.");
        strings.add("11.");
        strings.add("12.");

        mItemClickListener = listener;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private ListItemBinding mBinding;

        ViewHolder(ListItemBinding binding, RecyclerViewClickListener listener) {
            super(binding.getRoot());
            mBinding = binding;
            mItemClickListener = listener;
        }

        void bind(@NonNull String string) {
            mBinding.setData(string);
            mBinding.executePendingBindings();
        }
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ListItemBinding binding = DataBindingUtil.inflate(inflater, R.layout.list_item, parent, false);
        return new RecyclerViewAdapter.ViewHolder(binding, mItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, final int position) {
        holder.bind(strings.get(position));

        ListItemBinding binding = holder.mBinding;
        binding.getRoot().findViewById(R.id.item_button)
                .setOnClickListener(view -> mItemClickListener.onItemClick(position));
    }

    @Override
    public int getItemCount() {
        return strings.size();
    }
}
