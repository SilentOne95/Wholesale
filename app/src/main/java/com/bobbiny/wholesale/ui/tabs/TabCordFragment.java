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
import com.bobbiny.wholesale.viewModel.tabs.TabCordViewModel;

public class TabCordFragment extends Fragment {

    public TabCordFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tab_cord, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setUpViewModel();
    }

    private void setUpViewModel() {
        TabCordViewModel viewModel = ViewModelProviders.of(this).get(TabCordViewModel.class);
        viewModel.getTabItems(1).observe(this, contractorList -> {});
    }
}
