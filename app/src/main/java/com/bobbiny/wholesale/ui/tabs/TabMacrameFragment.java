package com.bobbiny.wholesale.ui.tabs;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bobbiny.wholesale.R;
import com.bobbiny.wholesale.viewModel.tabs.TabMacrameViewModel;

public class TabMacrameFragment extends Fragment {

    public TabMacrameFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tab_macrame, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setUpViewModel();
    }

    private void setUpViewModel() {
        TabMacrameViewModel viewModel = ViewModelProviders.of(this).get(TabMacrameViewModel.class);
        viewModel.getTabItems(1).observe(this, contractorList -> {});
    }
}
