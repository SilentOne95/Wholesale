package com.bobbiny.wholesale.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bobbiny.wholesale.R;
import com.bobbiny.wholesale.adapter.RecyclerViewAdapter;
import com.bobbiny.wholesale.adapter.RecyclerViewClickListener;

import static androidx.navigation.fragment.NavHostFragment.findNavController;

public class ListViewFragment extends Fragment {

    private Fragment mFragment;
    private View mView;
    private RecyclerView mRecyclerView;
    private RecyclerViewAdapter mAdapter;

    public ListViewFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_list_view, container, false);
        return mView.getRootView();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mFragment = this;
        mRecyclerView = mView.findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapter = new RecyclerViewAdapter(mRecyclerViewItemClickListener);
        mRecyclerView.setAdapter(mAdapter);
    }

    private RecyclerViewClickListener mRecyclerViewItemClickListener = new RecyclerViewClickListener() {
        @Override
        public void onItemClick(int id) {
            findNavController(mFragment).navigate(R.id.action_listView_to_detailView);
        }
    };
}
