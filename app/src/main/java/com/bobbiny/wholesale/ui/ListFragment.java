package com.bobbiny.wholesale.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bobbiny.wholesale.R;
import com.bobbiny.wholesale.adapter.ContractorListAdapter;
import com.bobbiny.wholesale.adapter.RecyclerViewClickListener;
import com.bobbiny.wholesale.viewModel.ListViewModel;

import static androidx.navigation.fragment.NavHostFragment.findNavController;

public class ListFragment extends Fragment {

    private Fragment mFragment;
    private View mView;
    private RecyclerView mRecyclerView;
    private ContractorListAdapter mAdapter;

    public ListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_list_view, container, false);
        mFragment = this;
        return mView.getRootView();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getActivity().setTitle(R.string.screen_title_list);

        setUpAdapter();
        setUpViewModel();
    }

    private void setUpAdapter() {
        mRecyclerView = mView.findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapter = new ContractorListAdapter(getContext(), mRecyclerViewItemClickListener);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void setUpViewModel() {
        ListViewModel viewModel = ViewModelProviders.of(this).get(ListViewModel.class);
        viewModel.getContractors().observe(this, contractorList -> mAdapter.setContractors(contractorList));
    }

    private RecyclerViewClickListener mRecyclerViewItemClickListener = new RecyclerViewClickListener() {
        @Override
        public void onItemClick(int id) {
            findNavController(mFragment).navigate(ListFragmentDirections.actionOpenDetailView(id));
        }
    };
}
