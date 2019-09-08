package com.bobbiny.wholesale.viewModel.tabs;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.bobbiny.wholesale.data.Injection;
import com.bobbiny.wholesale.data.WholesaleDataSource;
import com.bobbiny.wholesale.data.WholesaleRepository;
import com.bobbiny.wholesale.data.local.entity.Item;

import java.util.List;

import static com.bobbiny.wholesale.Constants.FIRST_CATEGORY;

public class TabCordViewModel extends AndroidViewModel {

    private WholesaleRepository mRepository;
    private MutableLiveData<List<Item>> mTabItems;

    public TabCordViewModel(@NonNull Application application) {
        super(application);
        mRepository = Injection.provideWholesaleRepository(application);
    }

    public MutableLiveData<List<Item>> getTabItems(int id) {
        if (mTabItems == null) {
            mTabItems = new MutableLiveData<>();
            getData(id);
        }

        return mTabItems;
    }

    private void getData(int id) {
        mRepository.getCategoryItems(id, FIRST_CATEGORY, new WholesaleDataSource.LoadDataCallback() {
            @Override
            public void onDataLoaded(List<?> data) {
                mTabItems.setValue((List<Item>) data);
            }

            @Override
            public void onDataNotAvailable() { }
        });
    }
}
