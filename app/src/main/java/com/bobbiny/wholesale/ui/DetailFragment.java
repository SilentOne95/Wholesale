package com.bobbiny.wholesale.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

import com.bobbiny.wholesale.R;
import com.bobbiny.wholesale.adapter.TabsAdapter;
import com.bobbiny.wholesale.viewModel.DetailViewModel;
import com.google.android.material.tabs.TabLayout;

public class DetailFragment extends Fragment {

    private View mView;

    public DetailFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_detail_view, container, false);
        return mView.getRootView();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TabLayout tabLayout = mView.findViewById(R.id.tab_layout);
        final ViewPager viewPager = mView.findViewById(R.id.view_pager);

        TabsAdapter tabsAdapter = new TabsAdapter(getContext(), getChildFragmentManager());
        viewPager.setAdapter(tabsAdapter);

        tabLayout.setupWithViewPager(viewPager);

        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            if (tab != null) {
                tab.setCustomView(tabsAdapter.getTabView(i));
            }
        }

        DetailViewModel viewModel = ViewModelProviders.of(this).get(DetailViewModel.class);
    }
}
