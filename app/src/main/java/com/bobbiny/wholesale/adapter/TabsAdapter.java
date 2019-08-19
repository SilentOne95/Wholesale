package com.bobbiny.wholesale.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.bobbiny.wholesale.R;
import com.bobbiny.wholesale.ui.tabs.TabCordFragment;
import com.bobbiny.wholesale.ui.tabs.TabMacrameFragment;
import com.bobbiny.wholesale.ui.tabs.TabOtherFragment;

public class TabsAdapter extends FragmentPagerAdapter {

    private Context mContext;
    private int[] mTabTitles = {R.string.tab_adapter_cord_title, R.string.tab_adapter_macrame_title, R.string.tab_adapter_other_title};
    private int[] mTabIconsId = {R.drawable.ic_tab_cord, R.drawable.ic_tab_macrame, R.drawable.ic_tab_other};

    public TabsAdapter(Context context, FragmentManager fragmentManager) {
        super(fragmentManager);
        mContext = context;
    }

    public View getTabView(int position) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.tab_view_custom, null);

        TextView title = view.findViewById(R.id.tab_view_text);
        title.setText(mTabTitles[position]);
        title.setCompoundDrawablesWithIntrinsicBounds(mTabIconsId[position], 0, 0, 0);

        return view;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new TabCordFragment();
            case 1:
                return new TabMacrameFragment();
            case 2:
                return new TabOtherFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
