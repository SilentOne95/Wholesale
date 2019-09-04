package com.bobbiny.wholesale.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.bobbiny.wholesale.data.Injection;
import com.bobbiny.wholesale.data.WholesaleDataSource;
import com.bobbiny.wholesale.data.WholesaleRepository;

import java.util.List;

public class DetailViewModel extends AndroidViewModel {

    private WholesaleRepository mRepository;

    public DetailViewModel(@NonNull Application application) {
        super(application);
        mRepository = Injection.provideWholesaleRepository(getApplication());
    }

    private void getData() {
        mRepository.getAllItems(new WholesaleDataSource.LoadDataCallback() {
            @Override
            public void onDataLoaded(List<?> data) {
            }

            @Override
            public void onDataNotAvailable() { }
        });
    }
}
