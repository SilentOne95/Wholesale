package com.bobbiny.wholesale.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.bobbiny.wholesale.data.Injection;
import com.bobbiny.wholesale.data.WholesaleDataSource;
import com.bobbiny.wholesale.data.WholesaleRepository;
import com.bobbiny.wholesale.data.local.entity.Contractor;

import java.util.List;

public class DetailViewModel extends AndroidViewModel {

    private WholesaleRepository mRepository;

    private MutableLiveData<List<Contractor>> mContractors;

    public DetailViewModel(@NonNull Application application) {
        super(application);
        mRepository = Injection.provideWholesaleRepository(getApplication());
    }

    public LiveData<List<Contractor>> getContractors() {
        if (mContractors == null) {
            mContractors = new MutableLiveData<>();
            get();
        }

        return mContractors;
    }

    private void get() {
        mRepository.getAllContractors(new WholesaleDataSource.LoadDataCallback() {
            @Override
            public void onDataLoaded(List<?> data) {
                mContractors.setValue((List<Contractor>) data);
            }

            @Override
            public void onDataNotAvailable() { }
        });
    }
}
