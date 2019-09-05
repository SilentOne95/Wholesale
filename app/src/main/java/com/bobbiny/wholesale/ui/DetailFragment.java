package com.bobbiny.wholesale.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

import com.bobbiny.wholesale.R;
import com.bobbiny.wholesale.adapter.TabsAdapter;
import com.bobbiny.wholesale.databinding.FragmentDetailViewBinding;
import com.bobbiny.wholesale.viewModel.DetailViewModel;
import com.google.android.material.tabs.TabLayout;

public class DetailFragment extends Fragment {

    private FragmentDetailViewBinding mBinding;

    public DetailFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail_view, container, false);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getActivity().setTitle(R.string.screen_title_detail);

        setUpViewPagerAdapter();

        if (getArguments() != null) {
            setUpViewModel(DetailFragmentArgs.fromBundle(getArguments()).getItemId());
        } else {
            setUpViewModel(0);
        }
    }

    private void setUpViewPagerAdapter() {
        TabLayout tabLayout = mBinding.getRoot().findViewById(R.id.tab_layout);
        final ViewPager viewPager = mBinding.getRoot().findViewById(R.id.view_pager);

        TabsAdapter tabsAdapter = new TabsAdapter(getContext(), getChildFragmentManager());
        viewPager.setAdapter(tabsAdapter);

        tabLayout.setupWithViewPager(viewPager);

        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            if (tab != null) {
                tab.setCustomView(tabsAdapter.getTabView(i));
            }
        }
    }

    private void setUpViewModel(int selectedItemId) {
        DetailViewModel viewModel = ViewModelProviders.of(this).get(DetailViewModel.class);
        mBinding.setLifecycleOwner(this);
        mBinding.setViewModel(viewModel);

        viewModel.getContractors(selectedItemId + 1).observe(this, contractor -> {
            mBinding.detailUserNameText.setText(contractor.getFirstName()
                    .concat(" ").concat(contractor.getLastName()));
            mBinding.detailUserCountryText.setText(contractor.getCountry());
            mBinding.detailCurrencyText.setText(contractor.getCurrency());
        });
    }
}
