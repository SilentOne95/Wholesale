package com.bobbiny.wholesale.adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.bobbiny.wholesale.R;
import com.bobbiny.wholesale.ui.tabs.TabCordFragment;
import com.bobbiny.wholesale.ui.tabs.TabDeliveryFragment;
import com.bobbiny.wholesale.ui.tabs.TabMacrameFragment;
import com.bobbiny.wholesale.ui.tabs.TabOtherFragment;

import static com.bobbiny.wholesale.Constants.TAB_BUNDLE_KEY;

public class TabsAdapter extends FragmentPagerAdapter {

    private Context mContext;
    private int[] mTabIconsId = {R.drawable.ic_tab_cord, R.drawable.ic_tab_macrame, R.drawable.ic_tab_other, R.drawable.ic_tab_delivery};
    private int mId;

    public TabsAdapter(Context context, FragmentManager fragmentManager, int id) {
        super(fragmentManager);
        mContext = context;
        mId = id;
    }

    public View getTabView(int position) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.tab_view_custom, null);

        TextView title = view.findViewById(R.id.tab_view_text);
        title.setCompoundDrawablesWithIntrinsicBounds(mTabIconsId[position], 0, 0, 0);

        return view;
    }

    @Override
    public Fragment getItem(int position) {
        Bundle bundle = new Bundle();
        bundle.putInt(TAB_BUNDLE_KEY, mId);
        switch (position) {
            case 0:
                TabCordFragment fragmentOne = new TabCordFragment();
                fragmentOne.setArguments(bundle);
                return fragmentOne;
            case 1:
                TabMacrameFragment fragmentTwo = new TabMacrameFragment();
                fragmentTwo.setArguments(bundle);
                return fragmentTwo;
            case 2:
                TabOtherFragment fragmentThree = new TabOtherFragment();
                fragmentThree.setArguments(bundle);
                return fragmentThree;
            case 3:
                TabDeliveryFragment fragmentFour = new TabDeliveryFragment();
                fragmentFour.setArguments(bundle);
                return fragmentFour;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 4;
    }
}
